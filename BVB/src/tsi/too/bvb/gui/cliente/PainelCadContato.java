package tsi.too.bvb.gui.cliente;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelCadContato extends JPanel implements TratadorDeCampos {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2413065008402544562L;
	
	private JFormattedTextField telFixoFormTextField;
	private JFormattedTextField telMovelFormTextField;
	

	/**
	 * Create the panel.
	 */
	public PainelCadContato() {
		setLayout(null);
		
		JLabel lblTelefoneFixo = new JLabel("Tel Fixo:");
		lblTelefoneFixo.setDisplayedMnemonic(KeyEvent.VK_F);
		lblTelefoneFixo.setBounds(10, 25, 80, 14);
		add(lblTelefoneFixo);
		
		JLabel lblTelefoneMovel = new JLabel("Tel M\u00F3vel:");
		lblTelefoneMovel.setDisplayedMnemonic(KeyEvent.VK_M);
		lblTelefoneMovel.setBounds(10, 55, 90, 14);
		add(lblTelefoneMovel);
		
		telFixoFormTextField = new JFormattedTextField(new Mascara("(##)####-####"));
		lblTelefoneFixo.setLabelFor(telFixoFormTextField);
		telFixoFormTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio");
		telFixoFormTextField.setBounds(100, 22, 308, 20);
		add(telFixoFormTextField);
		
		telMovelFormTextField = new JFormattedTextField(new Mascara("(##)####-####"));
		lblTelefoneMovel.setLabelFor(telMovelFormTextField);
		telMovelFormTextField.setToolTipText("este campo \u00E9 de preenchimento opcional");
		telMovelFormTextField.setBounds(100, 52, 308, 20);
		add(telMovelFormTextField);
		
		JLabel lblTelFixoImg = new JLabel("Tel Fixo");
		lblTelFixoImg.setIcon(new ImageIcon(PainelCadContato.class.getResource("/tsi/too/bvb/recursos/imagens/Telephone-03-32.png")));
		lblTelFixoImg.setDisplayedMnemonic(KeyEvent.VK_F);
		lblTelFixoImg.setBounds(418, 16, 32, 32);
		add(lblTelFixoImg);
		
		JLabel lblTelMovelImg = new JLabel("Tel Móvel");
		lblTelMovelImg.setIcon(new ImageIcon(PainelCadContato.class.getResource("/tsi/too/bvb/recursos/imagens/Mobile-Phone-32.png")));
		lblTelMovelImg.setDisplayedMnemonic(KeyEvent.VK_M);
		lblTelMovelImg.setBounds(418, 46, 32, 32);
		add(lblTelMovelImg);
	}

	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		telFixoFormTextField.setText("");
		telMovelFormTextField.setText("");
	}

	@Override
	public void salvarCampos(Object cliente) {
		((Cliente) cliente).getContato().setTelefoneFixo(telFixoFormTextField.getText().replace("(", "").replace(")", "").replace("-", ""));
		((Cliente) cliente).getContato().setTelefoneMovel(telMovelFormTextField.getText().replace("(", "").replace(")", "").replace("-", ""));
	}

	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!ValidarDados.validarIntPositivo(telFixoFormTextField.getText().replace("(", "").replace(")", "").replace("-", ""))) {
			telFixoFormTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else telFixoFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		return valido;
	}

	@Override
	public void inserirBordasPadrao() {
		telFixoFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
	}
	
} // class PainelCadContato
