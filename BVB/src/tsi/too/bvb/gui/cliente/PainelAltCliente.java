package tsi.too.bvb.gui.cliente;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.eventos.cliente.TEActionAlterarCliente;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelAltCliente extends JPanel implements TratadorDeCampos {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8140411404894329609L;
	
	private JTextField nomeTextField;
	private JFormattedTextField cpfFormattedTextField;
	private JButton btnEditarNome;

	/**
	 * Create the panel.
	 */
	public PainelAltCliente(Window janelaPai, Cliente cliente) {
		setLayout(null);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setDisplayedMnemonic(KeyEvent.VK_N);
		lblNome.setBounds(10, 25, 46, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setDisplayedMnemonic(KeyEvent.VK_C);
		lblCpf.setBounds(10, 55, 46, 14);
		add(lblCpf);
		
		cpfFormattedTextField = new JFormattedTextField(new Mascara("###.###.###-##"));
		cpfFormattedTextField.setText(cliente.getCpf());
		cpfFormattedTextField.setEditable(false);
		lblCpf.setLabelFor(cpfFormattedTextField);
		cpfFormattedTextField.setToolTipText("este campo n\u00E3o pode ser alterado");
		cpfFormattedTextField.setBounds(100, 52, 308, 20);
		add(cpfFormattedTextField);
		
		nomeTextField = new JTextField();
		nomeTextField.setText(cliente.getNome());
		lblNome.setLabelFor(nomeTextField);
		nomeTextField.setToolTipText("este campo n\u00E3o pode ficar vazio");
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(100, 22, 308, 20);
		add(nomeTextField);
		
		btnEditarNome = new JButton("Editar");
		btnEditarNome.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarNome.setMnemonic(KeyEvent.VK_E);
		btnEditarNome.setBounds(416, 21, 89, 23);
		add(btnEditarNome);
	}

	public boolean validarNome() {
		if(!ValidarDados.validarVazio(nomeTextField.getText())) {
			nomeTextField.setBorder(new LineBorder(Color.RED));
			
			return false;
		}
		else nomeTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
	}

	@Override
	public void limparCampos() {}

	@Override
	public void salvarCampos(Object cliente) {}

	@Override
	public boolean validarCampos() {
		return false;
	}

	@Override
	public void inserirBordasPadrao() {
		nomeTextField.setBorder(UIManager.getBorder("TextField.border"));
	}
	
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public JFormattedTextField getCpfFormattedTextField() {
		return cpfFormattedTextField;
	}

	public JButton getBtnEditarNome() {
		return btnEditarNome;
	}

} // class PainelAltCliente
