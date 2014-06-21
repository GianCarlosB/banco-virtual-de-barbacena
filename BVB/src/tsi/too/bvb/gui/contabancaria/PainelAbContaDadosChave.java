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
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelAbContaDadosChave extends JPanel implements TratadorDeCampos {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4165406095601940313L;
	
	private JTextField codAgenciaTextField;
	private JTextField numContaTextField;
	private JRadioButton rdbtnCorrente;
	private JRadioButton rdbtnPoupanca;
	private JPanel cpfPanel;
	private JFormattedTextField cpfFormattedTextField;
	private JButton btnValidarCpf;
	private JPanel codAgenciaPanel;
	private JButton btnValidarCodAgencia;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PainelAbContaDadosChave() {
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
		
		rdbtnCorrente = new JRadioButton("Conta Corrente");
		buttonGroup.add(rdbtnCorrente);
		rdbtnCorrente.setToolTipText("selecione se a conta for corrente");
		rdbtnCorrente.setSelected(true);
		rdbtnCorrente.setMnemonic(KeyEvent.VK_R);
		rdbtnCorrente.setBounds(10, 20, 112, 23);
		tipoContaPanel.add(rdbtnCorrente);
		
		rdbtnPoupanca = new JRadioButton("Conta Poupan\u00E7a");
		buttonGroup.add(rdbtnPoupanca);
		rdbtnPoupanca.setToolTipText("selecione se a conta for poupan\u00E7a");
		rdbtnPoupanca.setMnemonic(KeyEvent.VK_U);
		rdbtnPoupanca.setBounds(180, 20, 120, 23);
		tipoContaPanel.add(rdbtnPoupanca);
		
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
		cpfFormattedTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter apenas d\u00EDgitos decimais e deve estar cadastrado no sistema");
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

	@Override
	public void limparCampos() {
		cpfFormattedTextField.setText("");
		cpfPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		cpfFormattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		codAgenciaPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		codAgenciaTextField.setBorder(UIManager.getBorder("TextField.border"));
		codAgenciaTextField.setText("");
		
		rdbtnCorrente.setSelected(true);
	}

	@Override
	public void salvarCampos(Object contaBancaria) {
		((ContaBancaria) contaBancaria).setCodAgencia(Integer.parseInt(codAgenciaTextField.getText()));
		((ContaBancaria) contaBancaria).setCpf(cpfFormattedTextField.getText().replace(".", "").replace("-", ""));
		((ContaBancaria) contaBancaria).setTipoConta(TipoConta.obterTipoConta(obterRadioBtnSelecionado()));
	}

	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!validarCampoCodAgencia()) valido = false;
		
		if(!validarCampoCpf()) valido = false;
		
		return valido;
	}
	
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
	
	public boolean validarCampoCpf() {
		String cpf = cpfFormattedTextField.getText().replace(".", "").replace("-", "");

		if(ValidarDados.validarCPF(cpf)) {
			if(new ClienteDAO().pesquisarCpf(BancoDeDadosBVB.getInstance(), cpf) != null) {
				cpfPanel.setBorder(new TitledBorder(null, "Encontrado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
				cpfFormattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
				
				return true;
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
	
	private String obterRadioBtnSelecionado() {
		String radioBtnTxt;
		
		if(rdbtnCorrente.isSelected())
			radioBtnTxt = rdbtnCorrente.getText();
		else
			radioBtnTxt = rdbtnPoupanca.getText();
		
		return radioBtnTxt;
	}

	public JButton getBtnValidarCpf() {
		return btnValidarCpf;
	}

	public JButton getBtnValidarCodAgencia() {
		return btnValidarCodAgencia;
	}

	public void setNumContaTextField(String numero) {
		this.numContaTextField.setText(numero);
	}
	
} // class PainelAbContaDadosChave
