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
		codigoTextField.setToolTipText("insira o c\u00F3digo da ag\u00EAncia que deseja excluir e clique em buscar");
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(100, 22, 308, 20);
		add(codigoTextField);

	}

	public void setCodigoTextField(String codigoTextField) {
		this.codigoTextField.setText(codigoTextField);
	}

	public JTextField getCodigoTextField() {
		return codigoTextField;
	}

} // class PainelExAgencia
