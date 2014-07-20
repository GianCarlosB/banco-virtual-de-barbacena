package tsi.too.bvb.gui;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Classe que define o painel buscar funcionário utilizado por diversos componentes GUI do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 */
public class PainelBuscarFuncionario extends JPanel {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = -3360654599044445275L;
	
	private JTextField loginTextField;

	/** Cria uma instância do painel buscar funcionário utilizado por diversos componentes GUI do sistema BVB
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

	/** Muda o campo de texto login
	 * @param loginTextField <code>String</code> com o novo login do campo
	 */
	public void setLoginTextField(String loginTextField) {
		this.loginTextField.setText(loginTextField);
	}

	/** Retorna um <code>JTextField</code> com o campo de texto login
	 * @return <code>JTextField</code> com o campo de texto login
	 */
	public JTextField getLoginTextField() {
		return loginTextField;
	}
	
} // class PainelBuscarFuncionario
