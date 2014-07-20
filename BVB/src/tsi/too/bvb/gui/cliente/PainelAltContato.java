package tsi.too.bvb.gui.cliente;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.eventos.cliente.TEActionAlterarCliente;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define o painel contato utilizado pela janela <code>IgAltCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgAltCliente
 * @see TratadorDeCampos
 */
public class PainelAltContato extends JPanel implements TratadorDeCampos {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 2413065008402544562L;
	
	private JFormattedTextField telFixoFormTextField;
	private JFormattedTextField telMovelFormTextField;
	private JButton btnEditarTelMovel;
	private JButton btnEditarTelFixo;
	

	/** Cria uma instância do painel contato utilizado pela janela <code>IgAltCliente</code>
	 * @param janelaPai <code>Window</code> com a janela pai do painel <code>PainelAltContato</code>
	 * @param cliente <code>Cliente</code> com os dados do cliente que será alterado
	 * 
	 * @see Window
	 * @see Cliente
	 */	
	public PainelAltContato(Window janelaPai, Cliente cliente) {
		setLayout(null);
		
		JLabel lblTelefoneFixo = new JLabel("Tel Fixo:");
		lblTelefoneFixo.setDisplayedMnemonic(KeyEvent.VK_F);
		lblTelefoneFixo.setBounds(10, 25, 80, 14);
		add(lblTelefoneFixo);
		
		JLabel lblTelefoneMovel = new JLabel("Tel M\u00F3vel:");
		lblTelefoneMovel.setDisplayedMnemonic(KeyEvent.VK_M);
		lblTelefoneMovel.setBounds(10, 55, 61, 14);
		add(lblTelefoneMovel);
		
		telFixoFormTextField = new JFormattedTextField(new Mascara("(##)####-####"));
		telFixoFormTextField.setText(cliente.getContato().getTelefoneFixo());
		lblTelefoneFixo.setLabelFor(telFixoFormTextField);
		telFixoFormTextField.setToolTipText("este campo n\u00E3o pode ficar vazio");
		telFixoFormTextField.setBounds(100, 22, 269, 20);
		telFixoFormTextField.setText(cliente.getContato().getTelefoneFixo());
		add(telFixoFormTextField);
		
		telMovelFormTextField = new JFormattedTextField(new Mascara("(##)####-####"));
		telMovelFormTextField.setText(cliente.getContato().getTelefoneMovel());
		lblTelefoneMovel.setLabelFor(telMovelFormTextField);
		telMovelFormTextField.setToolTipText("este campo pode ficar vazio");
		telMovelFormTextField.setBounds(100, 52, 269, 20);
		telMovelFormTextField.setText(cliente.getContato().getTelefoneMovel());
		add(telMovelFormTextField);
		
		JLabel lblTelFixoImg = new JLabel("Tel Fixo");
		lblTelFixoImg.setIcon(new ImageIcon(PainelCadContato.class.getResource("/tsi/too/bvb/recursos/imagens/Telephone-03-32.png")));
		lblTelFixoImg.setDisplayedMnemonic(KeyEvent.VK_F);
		lblTelFixoImg.setBounds(379, 16, 32, 32);
		add(lblTelFixoImg);
		
		JLabel lblTelMovelImg = new JLabel("Tel Mï¿½vel");
		lblTelMovelImg.setIcon(new ImageIcon(PainelCadContato.class.getResource("/tsi/too/bvb/recursos/imagens/Mobile-Phone-32.png")));
		lblTelMovelImg.setDisplayedMnemonic(KeyEvent.VK_M);
		lblTelMovelImg.setBounds(379, 46, 32, 32);
		add(lblTelMovelImg);
		
		btnEditarTelFixo = new JButton("Editar");
		btnEditarTelFixo.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarTelFixo.setMnemonic(KeyEvent.VK_E);
		btnEditarTelFixo.setBounds(416, 21, 89, 23);
		add(btnEditarTelFixo);
		
		btnEditarTelMovel = new JButton("Editar");
		btnEditarTelMovel.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarTelMovel.setMnemonic(KeyEvent.VK_D);
		btnEditarTelMovel.setBounds(416, 51, 89, 23);
		add(btnEditarTelMovel);
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
		if(!ValidarDados.validarIntPositivo(telFixoFormTextField.getText().replace("(", "").replace(")", "").replace("-", ""))) {
			telFixoFormTextField.setBorder(new LineBorder(Color.RED));
			
			return false;
		}
		else telFixoFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		return true;
	}

	/** Insere a borda padrão nos campos do painel
	 */
	@Override
	public void inserirBordasPadrao() {
		telFixoFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
	}

	/** Retorna um <code>JFormattedTextField</code> com o campo de texto telefone fixo
	 * @return <code>JFormattedTextField</code> com o campo de texto telefone fixo
	 */
	public JFormattedTextField getTelFixoFormTextField() {
		return telFixoFormTextField;
	}

	/** Retorna um <code>JFormattedTextField</code> com o campo de texto telefone móvel
	 * @return <code>JFormattedTextField</code> com o campo de texto telefone móvel
	 */
	public JFormattedTextField getTelMovelFormTextField() {
		return telMovelFormTextField;
	}

	/** Retorna um <code>JButton</code> com o botão editar telefone fixo
	 * @return <code>JButton</code> com o botão editar telefone fixo
	 */
	public JButton getBtnEditarTelFixo() {
		return btnEditarTelFixo;
	}
	
	/** Retorna um <code>JButton</code> com o botão editar telefone móvel
	 * @return <code>JButton</code> com o botão editar telefone móvel
	 */
	public JButton getBtnEditarTelMovel() {
		return btnEditarTelMovel;
	}
	
} // class PainelAltContato
