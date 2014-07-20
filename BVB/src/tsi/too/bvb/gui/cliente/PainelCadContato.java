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

/** Classe que define o painel contato utilizado pela janela <code>IgCadCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgCadCliente
 * @see TratadorDeCampos
 */
public class PainelCadContato extends JPanel implements TratadorDeCampos {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 2413065008402544562L;
	
	private JFormattedTextField telFixoFormTextField;
	private JFormattedTextField telMovelFormTextField;
	

	/** Cria uma instância do painel contato utilizado pela janela <code>IgCadCliente</code>
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

	/** Limpa os campos do painel
	 */
	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		telFixoFormTextField.setText("");
		telMovelFormTextField.setText("");
	}

	/** Salva os dados inseridos na janela em um objeto do tipo <code>Cliente</code>
	 * @param cliente <code>Object</code> referênte ao objeto que será salvo
	 */
	@Override
	public void salvarCampos(Object cliente) {
		((Cliente) cliente).getContato().setTelefoneFixo(telFixoFormTextField.getText().replace("(", "").replace(")", "").replace("-", ""));
		((Cliente) cliente).getContato().setTelefoneMovel(telMovelFormTextField.getText().replace("(", "").replace(")", "").replace("-", ""));
	}

	/** Verifica se os campos do painel foram preenchidos corretamente. Os campos errados 
	 * recebem uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
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

	/** Insere a borda padrão nos campos do painel
	 */
	@Override
	public void inserirBordasPadrao() {
		telFixoFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
	}
	
} // class PainelCadContato
