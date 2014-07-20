package tsi.too.bvb.gui.contabancaria;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.eventos.contabancaria.TEActionAbrirCB;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.persistencia.ContaBancariaDAO;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define o painel dados chave utilizado pelas janelas <code>IgAbrirContaBancaria</code> e 
 * <code>IgCriarAplicacao</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgAbrirContaBancaria
 * @see IgCriarAplicacao
 * @see TratadorDeCampos
 */
public class PainelAbContaDadosChave extends JPanel implements TratadorDeCampos {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = -4165406095601940313L;
	
	private JTextField codAgenciaTextField;
	private JTextField numContaTextField;
	private JRadioButton rdbtnTipoConta1;
	private JRadioButton rdbtnTipoConta2;
	private JPanel cpfPanel;
	private JFormattedTextField cpfFormattedTextField;
	private JButton btnValidarCpf;
	private JPanel codAgenciaPanel;
	private JButton btnValidarCodAgencia;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/** Cria uma instância do painel dados chave utilizado pelas janelas <code>IgAbrirContaBancaria</code> e 
	 * <code>IgCriarAplicacao</code>
	 * @param tipoConta1 <code>String</code> com o nome do primeiro botão de rádio do tipo da conta
	 * @param tipoConta2 <code>String</code> com o nome do segundo botão de rádio do tipo da conta
	 * 
	 * @see TipoConta
	 */	
	public PainelAbContaDadosChave(String tipoConta1, String tipoConta2) {
		setLayout(null);
		
		JLabel lblCodAgencia = new JLabel("C\u00F3digo da Ag\u00EAncia:");
		lblCodAgencia.setDisplayedMnemonic(KeyEvent.VK_O);
		lblCodAgencia.setBounds(10, 45, 115, 14);
		add(lblCodAgencia);
		
		JLabel lblNumConta = new JLabel("N\u00FAmero da Conta:");
		lblNumConta.setDisplayedMnemonic(KeyEvent.VK_N);
		lblNumConta.setBounds(10, 178, 115, 14);
		add(lblNumConta);
		
		numContaTextField = new JTextField();
		numContaTextField.setEditable(false);
		numContaTextField.setText("XXXXXXXXX");
		lblNumConta.setLabelFor(numContaTextField);
		numContaTextField.setToolTipText("este campo \u00E9 gerado automaticamente");
		numContaTextField.setColumns(10);
		numContaTextField.setBounds(130, 175, 269, 20);
		add(numContaTextField);
		
		JPanel tipoContaPanel = new JPanel();
		tipoContaPanel.setLayout(null);
		tipoContaPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Tipo da Conta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		tipoContaPanel.setBounds(10, 208, 497, 58);
		add(tipoContaPanel);
		
		rdbtnTipoConta1 = new JRadioButton(tipoConta1);
		buttonGroup.add(rdbtnTipoConta1);
		rdbtnTipoConta1.setToolTipText("selecione se for " + tipoConta1.toLowerCase());
		rdbtnTipoConta1.setSelected(true);
		rdbtnTipoConta1.setMnemonic(KeyEvent.VK_R);
		rdbtnTipoConta1.setBounds(10, 20, 150, 23);
		tipoContaPanel.add(rdbtnTipoConta1);
		
		rdbtnTipoConta2 = new JRadioButton(tipoConta2);
		buttonGroup.add(rdbtnTipoConta2);
		rdbtnTipoConta2.setToolTipText("selecione se a conta for " + tipoConta2.toLowerCase());
		rdbtnTipoConta2.setMnemonic(KeyEvent.VK_U);
		rdbtnTipoConta2.setBounds(180, 20, 150, 23);
		tipoContaPanel.add(rdbtnTipoConta2);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setDisplayedMnemonic(KeyEvent.VK_P);
		lblCpf.setBounds(10, 116, 80, 14);
		add(lblCpf);
		
		cpfPanel = new JPanel();
		cpfPanel.setLayout(null);
		cpfPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		cpfPanel.setBounds(130, 96, 377, 58);
		add(cpfPanel);
		
		cpfFormattedTextField = new JFormattedTextField(new Mascara("###.###.###-##"));
		lblCpf.setLabelFor(cpfFormattedTextField);
		cpfFormattedTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter apenas d\u00EDgitos decimais, estar cadastrado no sistema e pertencer a um correntista caso o tipo da conta seja fif");
		cpfFormattedTextField.setBounds(10, 20, 254, 20);
		cpfPanel.add(cpfFormattedTextField);
		
		btnValidarCpf = new JButton("Validar");
		btnValidarCpf.addActionListener(new TEActionAbrirCB(this));
		btnValidarCpf.setMnemonic(KeyEvent.VK_A);
		btnValidarCpf.setBounds(276, 19, 89, 23);
		cpfPanel.add(btnValidarCpf);
		
		codAgenciaPanel = new JPanel();
		codAgenciaPanel.setLayout(null);
		codAgenciaPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		codAgenciaPanel.setBounds(130, 25, 377, 58);
		add(codAgenciaPanel);
		
		btnValidarCodAgencia = new JButton("Validar");
		btnValidarCodAgencia.addActionListener(new TEActionAbrirCB(this));
		btnValidarCodAgencia.setMnemonic(KeyEvent.VK_V);
		btnValidarCodAgencia.setBounds(276, 19, 89, 23);
		codAgenciaPanel.add(btnValidarCodAgencia);
		
		codAgenciaTextField = new JTextField();
		lblCodAgencia.setLabelFor(codAgenciaTextField);
		codAgenciaTextField.setBounds(10, 20, 254, 20);
		codAgenciaPanel.add(codAgenciaTextField);
		codAgenciaTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter apenas d\u00EDgitos decimais e deve estar cadastrado no sistema");
		codAgenciaTextField.setColumns(10);
	}

	/** Limpa os campos do painel
	 */
	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		cpfFormattedTextField.setText("");
		codAgenciaTextField.setText("");
		
		rdbtnTipoConta1.setSelected(true);
	}

	/** Salva os dados inseridos na janela em um objeto do tipo <code>ContaBancaria</code>
	 * @param contaBancaria <code>Object</code> referênte ao objeto que será salvo
	 */
	@Override
	public void salvarCampos(Object contaBancaria) {
		((ContaBancaria) contaBancaria).setCodAgencia(Integer.parseInt(codAgenciaTextField.getText()));
		((ContaBancaria) contaBancaria).setCpf(cpfFormattedTextField.getText().replace(".", "").replace("-", ""));
		((ContaBancaria) contaBancaria).setTipoConta(TipoConta.obterTipoConta(obterRadioBtnSelecionado()));
	}

	/** Verifica se os campos do painel foram preenchidos corretamente
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!validarCampoCodAgencia()) valido = false;
		
		if(!validarCampoCpf()) valido = false;
		
		return valido;
	}
	
	/** Insere a borda padrão nos campos do painel
	 */
	@Override
	public void inserirBordasPadrao() {
		cpfPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		cpfFormattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		codAgenciaPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		codAgenciaTextField.setBorder(UIManager.getBorder("TextField.border"));
	}

	/** Verifica se o campo código da agência do painel for preenchido corretamente. Se o campo estiver errado
	 *  receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo código da agência tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarCampoCodAgencia() {
		String codAgencia = codAgenciaTextField.getText();
		
		if(ValidarDados.validarIntPositivo(codAgencia)) {
			if(new AgenciaDAO().pesquisarCodigo(BancoDeDadosBVB.getInstance(), codAgencia) != null) {
				codAgenciaPanel.setBorder(new TitledBorder(null, "Encontrado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
				codAgenciaTextField.setBorder(UIManager.getBorder("TextField.border"));
				
				return true;
			}
			else {
				codAgenciaPanel.setBorder(new TitledBorder(null, "Não Encontrado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				codAgenciaTextField.setBorder(new LineBorder(Color.RED));
			}
		}
		else {
			codAgenciaPanel.setBorder(new TitledBorder(null, "Inválido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
			codAgenciaTextField.setBorder(new LineBorder(Color.RED));
		}
		
		return false;
	}
	
	/** Verifica se o campo cpf do painel for preenchido corretamente. Se o campo estiver errado
	 *  receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo cpf tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarCampoCpf() {
		String cpf = cpfFormattedTextField.getText().replace(".", "").replace("-", "");

		if(ValidarDados.validarCPF(cpf)) {
			if(new ClienteDAO().pesquisarCpf(BancoDeDadosBVB.getInstance(), cpf) != null) {
				if((rdbtnTipoConta1.getText().equals("BVB FIF Pr\u00E1tico") || rdbtnTipoConta2.getText().equals("BVB FIF Executivo")) &&
				   (new ContaBancariaDAO().pesquisarCorrentista(BancoDeDadosBVB.getInstance(), cpf, TipoConta.CONTA_CORRENTE)) == null) {
					cpfPanel.setBorder(new TitledBorder(null, "Não Correntista", TitledBorder.LEADING, TitledBorder.TOP,
							           null, new Color(255, 0, 0)));
					cpfFormattedTextField.setBorder(new LineBorder(Color.RED));
				}
				else {
					cpfPanel.setBorder(new TitledBorder(null, "Encontrado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
					cpfFormattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
					
					return true;
				}
				
			}
			else {
				cpfPanel.setBorder(new TitledBorder(null, "Não Encontrado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				cpfFormattedTextField.setBorder(new LineBorder(Color.RED));
			}
		}
		else {
			cpfPanel.setBorder(new TitledBorder(null, "Inválido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
			cpfFormattedTextField.setBorder(new LineBorder(Color.RED));
		}
		
		return false;
	}
	
	/** Retorna o texto do botão de rádio que está selecionado
	 *  @return <code>String</code> com o texto do botão de rádio que está selecionado
	 */
	public String obterRadioBtnSelecionado() {
		String radioBtnTxt;
		
		if(rdbtnTipoConta1.isSelected())
			radioBtnTxt = rdbtnTipoConta1.getText();
		else
			radioBtnTxt = rdbtnTipoConta2.getText();
		
		return radioBtnTxt;
	}

	/** Retorna um <code>JButton</code> com o botão validar cpf
	 * @return <code>JButton</code> com o botão validar cpf
	 */
	public JButton getBtnValidarCpf() {
		return btnValidarCpf;
	}

	/** Retorna um <code>JButton</code> com o botão validar código da agência
	 * @return <code>JButton</code> com o botão validar código da agência
	 */
	public JButton getBtnValidarCodAgencia() {
		return btnValidarCodAgencia;
	}

	/** Muda o campo de texto número da conta
	 * @param numero <code>String</code> com o novo número da conta do campo
	 */
	public void setNumContaTextField(String numero) {
		this.numContaTextField.setText(numero);
	}

	/** Retorna um <code>boolean</code> indicando se o botão de rádio 1 está selecionado
	 *  @return <code>boolean</code> com <code>true</code> caso  o botão de rádio 1 esteja selecionado, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean rdbtnTipoConta1isSelected() {
		return rdbtnTipoConta1.isSelected();
	}

	/** Retorna um <code>boolean</code> indicando se o botão de rádio 2 está selecionado
	 *  @return <code>boolean</code> com <code>true</code> caso  o botão de rádio 2 esteja selecionado, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean rdbtnTipoConta2isSelected() {
		return rdbtnTipoConta2.isSelected();
	}
	
} // class PainelAbContaDadosChave
