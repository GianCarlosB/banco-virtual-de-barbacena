package tsi.too.bvb.gui;

import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Classe que define o painel buscar agência utilizado por diversos componentes GUI do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 */
public class PainelBuscarAgencia extends JPanel {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = -4006535614283973222L;
	
	private JTextField codigoTextField;

	/** Cria uma instância do painel buscar agência utilizado por diversos componentes GUI do sistema BVB
	 */	
	public PainelBuscarAgencia() {
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

	/** Muda o campo de texto código
	 * @param codigoTextField <code>String</code> com o novo código do campo
	 */
	public void setCodigoTextField(String codigoTextField) {
		this.codigoTextField.setText(codigoTextField);
	}

	/** Retorna um <code>JTextField</code> com o campo de texto código
	 * @return <code>JTextField</code> com o campo de texto código
	 */
	public JTextField getCodigoTextField() {
		return codigoTextField;
	}

} // class PainelBuscarAgencia
