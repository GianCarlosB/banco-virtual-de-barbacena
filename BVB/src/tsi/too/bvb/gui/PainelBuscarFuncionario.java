package tsi.too.bvb.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class PainelBuscarFuncionario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3360654599044445275L;
	
	private JTextField loginTextField;

	/**
	 * Create the panel.
	 */
	public PainelBuscarFuncionario() {
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setDisplayedMnemonic(KeyEvent.VK_L);
		lblLogin.setBounds(10, 25, 60, 14);
		add(lblLogin);
		
		loginTextField = new JTextField();
		lblLogin.setLabelFor(loginTextField);
		loginTextField.setToolTipText("insira o login do funcion\u00E1rio que deseja excluir e clique em buscar");
		loginTextField.setColumns(10);
		loginTextField.setBounds(100, 22, 308, 20);
		add(loginTextField);

	}

	public void setLoginTextField(String loginTextField) {
		this.loginTextField.setText(loginTextField);
	}

	public JTextField getLoginTextField() {
		return loginTextField;
	}
	
} // class PainelBuscarFuncionario
