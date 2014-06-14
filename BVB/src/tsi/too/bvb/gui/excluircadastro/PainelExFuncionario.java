package tsi.too.bvb.gui.excluircadastro;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class PainelExFuncionario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8077783487604979385L;
	private JTextField loginTextField;

	/**
	 * Create the panel.
	 */
	public PainelExFuncionario() {
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setDisplayedMnemonic(KeyEvent.VK_L);
		lblLogin.setBounds(10, 25, 60, 14);
		add(lblLogin);
		
		loginTextField = new JTextField();
		lblLogin.setLabelFor(loginTextField);
		loginTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter no m\u00EDnimo 6 e no m\u00E1ximo 20 caracteres (letras, d\u00EDgitos e os s\u00EDmbolos underscore (_) ou ponto (.)) e deve ser \u00FAnico");
		loginTextField.setColumns(10);
		loginTextField.setBounds(100, 22, 288, 20);
		add(loginTextField);

	}

	public void setLoginTextField(String loginTextField) {
		this.loginTextField.setText(loginTextField);
	}

	public JTextField getLoginTextField() {
		return loginTextField;
	}
	
} // class PainelExFuncionario
