package tsi.too.bvb.gui;

import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tsi.too.bvb.entidades.Mascara;

/** Classe que define o painel buscar cliente utilizado por diversos componentes GUI do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 */
public class PainelBuscarCliente extends JPanel {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 4584584587198563696L;
	
	private JFormattedTextField cpfFormattedTextField;

	/** Cria uma instância do painel buscar cliente utilizado por diversos componentes GUI do sistema BVB
	 */	
	public PainelBuscarCliente() {
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

	/** Muda o campo de texto cpf
	 * @param cpfFormattedTextField <code>String</code> com o novo cpf do campo
	 */
	public void setCpfFormattedTextField(String cpfFormattedTextField) {
		this.cpfFormattedTextField.setText(cpfFormattedTextField);
	}

	/** Retorna um <code>JFormattedTextField</code> com o campo de texto cpf
	 * @return <code>JFormattedTextField</code> com o campo de texto cpf
	 */
	public JFormattedTextField getCpfFormattedTextField() {
		return cpfFormattedTextField;
	}
	
} // class PainelBuscarCliente
