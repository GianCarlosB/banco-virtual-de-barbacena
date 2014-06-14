package tsi.too.bvb.gui.excluircadastro;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelExAgencia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4798665446521942880L;
	private JTextField codigoTextField;

	/**
	 * Create the panel.
	 */
	public PainelExAgencia() {
		setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_O);
		lblCodigo.setBounds(10, 25, 46, 14);
		add(lblCodigo);
		
		codigoTextField = new JTextField();
		lblCodigo.setLabelFor(codigoTextField);
		codigoTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve conter no m\u00EDnimo 6 e no m\u00E1ximo 20 caracteres (letras, d\u00EDgitos e os s\u00EDmbolos underscore (_) ou ponto (.)) e deve ser \u00FAnico");
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(100, 22, 288, 20);
		add(codigoTextField);

	}

	public void setCodigoTextField(String codigoTextField) {
		this.codigoTextField.setText(codigoTextField);
	}

	public JTextField getCodigoTextField() {
		return codigoTextField;
	}

} // class PainelExAgencia
