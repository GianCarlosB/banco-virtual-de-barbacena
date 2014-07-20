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

/** Classe que define o painel cliente utilizado pela janela <code>IgAltCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgAltCliente
 * @see TratadorDeCampos
 */
public class PainelAltCliente extends JPanel implements TratadorDeCampos {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = -8140411404894329609L;
	
	private JTextField nomeTextField;
	private JFormattedTextField cpfFormattedTextField;
	private JButton btnEditarNome;

	/** Cria uma instância do painel cliente utilizado pela janela <code>IgAltCliente</code>
	 * @param janelaPai <code>Window</code> com a janela pai do painel <code>PainelAltCliente</code>
	 * @param cliente <code>Cliente</code> com os dados do cliente que será alterado
	 * 
	 * @see Window
	 * @see Cliente
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

	/* (non-Javadoc)
	 * @see TratadorDeCampos
	 */
	@Override
	public void limparCampos() {}

	/* (non-Javadoc)
	 * @see TratadorDeCampos
	 */
	@Override
	public void salvarCampos(Object cliente) {}

	/** Verifica se os campos do painel foram preenchidos corretamente. Os campos errados 
	 * recebem uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	@Override
	public boolean validarCampos() {
		if(!ValidarDados.validarVazio(nomeTextField.getText())) {
			nomeTextField.setBorder(new LineBorder(Color.RED));
			
			return false;
		}
		else nomeTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
	}

	/** Insere a borda padrão nos campos do painel
	 */
	@Override
	public void inserirBordasPadrao() {
		nomeTextField.setBorder(UIManager.getBorder("TextField.border"));
	}
	
	/** Retorna um <code>JTextField</code> com o campo de texto nome
	 * @return <code>JTextField</code> com o campo de texto nome
	 */
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	/** Retorna um <code>JFormattedTextField</code> com o campo de texto cpf
	 * @return <code>JFormattedTextField</code> com o campo de texto cpf
	 */
	public JFormattedTextField getCpfFormattedTextField() {
		return cpfFormattedTextField;
	}

	/** Retorna um <code>JButton</code> com o botão editar nome
	 * @return <code>JButton</code> com o botão editar nome
	 */
	public JButton getBtnEditarNome() {
		return btnEditarNome;
	}

} // class PainelAltCliente
