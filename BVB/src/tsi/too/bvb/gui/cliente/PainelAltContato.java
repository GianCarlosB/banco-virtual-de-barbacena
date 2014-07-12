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

public class PainelAltContato extends JPanel implements TratadorDeCampos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2413065008402544562L;
	
	private JFormattedTextField telFixoFormTextField;
	private JFormattedTextField telMovelFormTextField;
	private JButton btnEditarTelMovel;
	private JButton btnEditarTelFixo;
	

	/**
	 * Create the panel.
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
		
		JLabel lblTelMovelImg = new JLabel("Tel M�vel");
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
	
	public boolean validarTelFixo() {
		if(!ValidarDados.validarIntPositivo(telFixoFormTextField.getText().replace("(", "").replace(")", "").replace("-", ""))) {
			telFixoFormTextField.setBorder(new LineBorder(Color.RED));
			
			return false;
		}
		else telFixoFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		return true;
	}
	
	@Override
	public void limparCampos() {}

	@Override
	public void salvarCampos(Object cliente) {}

	@Override
	public boolean validarCampos() {
		return false;
	}

	@Override
	public void inserirBordasPadrao() {
		telFixoFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
	}

	public JFormattedTextField getTelFixoFormTextField() {
		return telFixoFormTextField;
	}

	public JFormattedTextField getTelMovelFormTextField() {
		return telMovelFormTextField;
	}

	public JButton getBtnEditarTelMovel() {
		return btnEditarTelMovel;
	}

	public JButton getBtnEditarTelFixo() {
		return btnEditarTelFixo;
	}
	
} // class PainelAltContato
