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
import tsi.too.bvb.eventos.cliente.TEMouseCadastrarCliente;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelCadCliente extends JPanel implements PainelCliente {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4165406095601940313L;
	
	private JTextField nomeTextField;
	private JFormattedTextField cpfFormattedTextField;
	private JButton btnValidar;
	private JPanel cpfPanel;

	/**
	 * Create the panel.
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
		lblCpf.setBounds(10, 75, 46, 14);
		add(lblCpf);
		
		cpfPanel = new JPanel();
		cpfPanel.setLayout(null);
		cpfPanel.setBorder(new TitledBorder(null, "N\u00E3o Validado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		cpfPanel.setBounds(100, 55, 407, 58);
		add(cpfPanel);
		
		cpfFormattedTextField = new JFormattedTextField(new Mascara("###.###.###-##"));
		lblCpf.setLabelFor(cpfFormattedTextField);
		cpfFormattedTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter apenas d\u00EDgitos decimais, deve ser v\u00E1lido e \u00FAnico");
		cpfFormattedTextField.setBounds(10, 20, 288, 20);
		cpfPanel.add(cpfFormattedTextField);
		
		btnValidar = new JButton("Validar");
		btnValidar.addActionListener(new TEMouseCadastrarCliente(this));

		btnValidar.setMnemonic(KeyEvent.VK_V);
		btnValidar.setBounds(308, 19, 89, 23);
		cpfPanel.add(btnValidar);
	}

	@Override
	public void limpaCampos() {
		nomeTextField.setText("");
		cpfFormattedTextField.setText("");
	}

	@Override
	public void salvarCampos(Cliente cliente) {
		cliente.setCpf(cpfFormattedTextField.getText().replace(".", "").replace("-", ""));
		cliente.setNome(nomeTextField.getText());
	}

	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(ValidarDados.validarVazio(nomeTextField.getText()) == false) {
			nomeTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else nomeTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		if(validarCampoCpf() == false)
			valido = false;
		
		return valido;
	}
	
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

	public JButton getBtnValidar() {
		return btnValidar;
	}
	
} // class PainelCadCliente
