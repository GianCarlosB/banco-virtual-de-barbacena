package tsi.too.bvb.gui.cliente;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.eventos.cliente.TEActionCadastrarCliente;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define o painel cliente utilizado pela janela <code>IgCadCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgCadCliente
 * @see TratadorDeCampos
 */
public class PainelCadCliente extends JPanel implements TratadorDeCampos {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = -4165406095601940313L;
	
	private JTextField nomeTextField;
	private JFormattedTextField cpfFormattedTextField;
	private JButton btnValidar;
	private JPanel cpfPanel;

	/** Cria uma instância do painel cliente utilizado pela janela <code>IgCadCliente</code>
	 */	
	public PainelCadCliente() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setDisplayedMnemonic(KeyEvent.VK_N);
		lblNome.setBounds(10, 25, 46, 14);
		add(lblNome);
		
		nomeTextField = new JTextField();
		lblNome.setLabelFor(nomeTextField);
		nomeTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio");
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(100, 22, 308, 20);
		add(nomeTextField);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setDisplayedMnemonic(KeyEvent.VK_F);
		lblCpf.setBounds(10, 85, 46, 14);
		add(lblCpf);
		
		cpfPanel = new JPanel();
		cpfPanel.setLayout(null);
		cpfPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		cpfPanel.setBounds(100, 65, 407, 58);
		add(cpfPanel);
		
		cpfFormattedTextField = new JFormattedTextField(new Mascara("###.###.###-##"));
		lblCpf.setLabelFor(cpfFormattedTextField);
		cpfFormattedTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter apenas d\u00EDgitos decimais, deve ser v\u00E1lido e \u00FAnico");
		cpfFormattedTextField.setBounds(10, 20, 288, 20);
		cpfPanel.add(cpfFormattedTextField);
		
		btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new TEActionCadastrarCliente(this));

		btnValidar.setMnemonic(KeyEvent.VK_V);
		btnValidar.setBounds(308, 19, 89, 23);
		cpfPanel.add(btnValidar);
	}

	/** Limpa os campos do painel
	 */
	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		cpfFormattedTextField.setText("");
		nomeTextField.setText("");
	}

	/** Salva os dados inseridos na janela em um objeto do tipo <code>Cliente</code>
	 * @param cliente <code>Object</code> referênte ao objeto que será salvo
	 */
	@Override
	public void salvarCampos(Object cliente) {
		((Cliente) cliente).setCpf(cpfFormattedTextField.getText().replace(".", "").replace("-", ""));
		((Cliente) cliente).setNome(nomeTextField.getText());
	}

	/** Verifica se os campos do painel foram preenchidos corretamente. Os campos errados 
	 * recebem uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!ValidarDados.validarVazio(nomeTextField.getText())) {
			nomeTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else nomeTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		if(!validarCampoCpf()) valido = false;
		
		return valido;
	}
	
	/** Insere a borda padrão nos campos do painel
	 */
	@Override
	public void inserirBordasPadrao() {
		cpfPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		cpfFormattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		nomeTextField.setBorder(UIManager.getBorder("TextField.border"));
	}

	/** Verifica se o campo cpf do painel for preenchido corretamente. Se o campo 
	 *  estiver errado, receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo  tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarCampoCpf() {
		String cpf = cpfFormattedTextField.getText().replace(".", "").replace("-", "");

		if(ValidarDados.validarCPF(cpf)) {
			if(new ClienteDAO().pesquisarCpf(BancoDeDadosBVB.getInstance(), cpf) == null) {
				cpfPanel.setBorder(new TitledBorder(null, "Disponível", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
				cpfFormattedTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
				
				return true;
			}
			else {
				cpfPanel.setBorder(new TitledBorder(null, "Insdisponível", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
				cpfFormattedTextField.setBorder(new LineBorder(Color.RED));
			}
		}
		else {
			cpfPanel.setBorder(new TitledBorder(null, "Inválido", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
			cpfFormattedTextField.setBorder(new LineBorder(Color.RED));
		}
		
		return false;
	}

	/** Retorna um <code>JButton</code> com o botão validar
	 * @return <code>JButton</code> com o botão validar
	 */
	public JButton getBtnValidar() {
		return btnValidar;
	}
	
} // class PainelCadDadosPrincipais
