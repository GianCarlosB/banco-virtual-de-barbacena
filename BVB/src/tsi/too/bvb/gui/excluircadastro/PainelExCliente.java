package tsi.too.bvb.gui.excluircadastro;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tsi.too.bvb.entidades.Mascara;
import java.awt.event.KeyEvent;

public class PainelExCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2915370770617175465L;
	private JFormattedTextField cpfFormattedTextField;

	/**
	 * Create the panel.
	 */
	public PainelExCliente() {
		setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setDisplayedMnemonic(KeyEvent.VK_P);
		lblCpf.setBounds(10, 25, 46, 14);
		add(lblCpf);
		
		cpfFormattedTextField = new JFormattedTextField(new Mascara("###.###.###-##"));
		lblCpf.setLabelFor(cpfFormattedTextField);
		cpfFormattedTextField.setToolTipText("insira o cpf do cliente que deseja excluir e clique em buscar");
		cpfFormattedTextField.setBounds(100, 22, 308, 20);
		add(cpfFormattedTextField);

	}

	public void setCpfFormattedTextField(String cpfFormattedTextField) {
		this.cpfFormattedTextField.setText(cpfFormattedTextField);
	}

	public JFormattedTextField getCpfFormattedTextField() {
		return cpfFormattedTextField;
	}
	
} // class PainelExCliente
