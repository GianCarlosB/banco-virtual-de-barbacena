package tsi.too.bvb.gui.cliente;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.tiposenumerados.UF;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define o painel endereço utilizado pela janela <code>IgCadCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgCadCliente
 * @see TratadorDeCampos
 */
public class PainelCadEndereco extends JPanel implements TratadorDeCampos {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 4933250266690793219L;
	
	private JTextField logradouroTextField;
	private JTextField complementoTextField;
	private JTextField numeroTextField;
	private JTextField bairroTextField;
	private JTextField cidadeTextField;
	private JFormattedTextField cepFormTextField;
	private JComboBox<Object> ufComboBox;

	/** Cria uma instância do painel endereço utilizado pela janela <code>IgCadCliente</code>
	 */	
	public PainelCadEndereco() {
		setLayout(null);
		
		JPanel localPanel = new JPanel();
		localPanel.setLayout(null);
		localPanel.setBorder(new TitledBorder(null, "Local", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		localPanel.setBounds(10, 11, 497, 152);
		add(localPanel);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setDisplayedMnemonic(KeyEvent.VK_M);
		lblComplemento.setBounds(10, 50, 85, 14);
		localPanel.add(lblComplemento);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setDisplayedMnemonic(KeyEvent.VK_O);
		lblLogradouro.setBounds(10, 20, 70, 14);
		localPanel.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setDisplayedMnemonic(KeyEvent.VK_N);
		lblNumero.setBounds(10, 80, 50, 14);
		localPanel.add(lblNumero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setDisplayedMnemonic(KeyEvent.VK_B);
		lblBairro.setBounds(10, 110, 46, 14);
		localPanel.add(lblBairro);
		
		logradouroTextField = new JTextField();
		lblLogradouro.setLabelFor(logradouroTextField);
		logradouroTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio");
		logradouroTextField.setColumns(10);
		logradouroTextField.setBounds(100, 17, 308, 20);
		localPanel.add(logradouroTextField);
		
		complementoTextField = new JTextField();
		lblComplemento.setLabelFor(complementoTextField);
		complementoTextField.setToolTipText("este campo \u00E9 de preenchimento opcional");
		complementoTextField.setColumns(10);
		complementoTextField.setBounds(100, 47, 308, 20);
		localPanel.add(complementoTextField);
		
		numeroTextField = new JTextField();
		lblNumero.setLabelFor(numeroTextField);
		numeroTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter apenas d\u00EDgitos decimais");
		numeroTextField.setColumns(10);
		numeroTextField.setBounds(100, 77, 308, 20);
		localPanel.add(numeroTextField);
		
		bairroTextField = new JTextField();
		lblBairro.setLabelFor(bairroTextField);
		bairroTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio");
		bairroTextField.setColumns(10);
		bairroTextField.setBounds(100, 107, 308, 20);
		localPanel.add(bairroTextField);
		
		JPanel RegionalPanel = new JPanel();
		RegionalPanel.setLayout(null);
		RegionalPanel.setBorder(new TitledBorder(null, "Regional", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		RegionalPanel.setBounds(10, 174, 497, 114);
		add(RegionalPanel);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setDisplayedMnemonic(KeyEvent.VK_U);
		lblUf.setBounds(10, 80, 46, 14);
		RegionalPanel.add(lblUf);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setDisplayedMnemonic(KeyEvent.VK_I);
		lblCidade.setBounds(10, 50, 46, 14);
		RegionalPanel.add(lblCidade);
		
		ufComboBox = new JComboBox<Object>(UF.obterArrayUF());
		ufComboBox.setToolTipText("selecione o UF de sua cidade");
		lblUf.setLabelFor(ufComboBox);
		ufComboBox.setBounds(100, 77, 45, 20);
		RegionalPanel.add(ufComboBox);
		
		cidadeTextField = new JTextField();
		lblCidade.setLabelFor(cidadeTextField);
		cidadeTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio");
		cidadeTextField.setColumns(10);
		cidadeTextField.setBounds(100, 47, 308, 20);
		RegionalPanel.add(cidadeTextField);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setDisplayedMnemonic(KeyEvent.VK_E);
		lblCep.setBounds(10, 20, 46, 14);
		RegionalPanel.add(lblCep);
		
		cepFormTextField = new JFormattedTextField(new Mascara("#####-###"));
		lblCep.setLabelFor(cepFormTextField);
		cepFormTextField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter apenas d\u00EDgitos decimais");
		cepFormTextField.setBounds(100, 17, 308, 20);
		RegionalPanel.add(cepFormTextField);
	}

	/** Limpa os campos do painel
	 */
	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		logradouroTextField.setText("");
		complementoTextField.setText("");
		numeroTextField.setText("");
		bairroTextField.setText("");
		cidadeTextField.setText("");
		cepFormTextField.setText("");

		ufComboBox.setSelectedIndex(0);
	}

	/** Salva os dados inseridos na janela em um objeto do tipo <code>Cliente</code>
	 * @param cliente <code>Object</code> referênte ao objeto que será salvo
	 */
	@Override
	public void salvarCampos(Object cliente) {
		((Cliente) cliente).getEndereco().setBairro(bairroTextField.getText());
		bairroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		((Cliente) cliente).getEndereco().setCep(cepFormTextField.getText().replace("-", ""));
		cepFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		((Cliente) cliente).getEndereco().setCidade(cidadeTextField.getText());
		cidadeTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		((Cliente) cliente).getEndereco().setComplemento(complementoTextField.getText());
		
		((Cliente) cliente).getEndereco().setLogradouro(logradouroTextField.getText());
		logradouroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		((Cliente) cliente).getEndereco().setNumero(numeroTextField.getText());
		numeroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		((Cliente) cliente).getEndereco().setUf(UF.obterUF((String)ufComboBox.getSelectedItem()));
	}

	/** Verifica se os campos do painel foram preenchidos corretamente. Os campos errados 
	 * recebem uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!ValidarDados.validarVazio(logradouroTextField.getText())) {
			logradouroTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else logradouroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		if(!ValidarDados.validarIntPositivo(numeroTextField.getText())) {
			numeroTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else numeroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		if(!ValidarDados.validarVazio(bairroTextField.getText())) {
			bairroTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else bairroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		if(!ValidarDados.validarVazio(cidadeTextField.getText())) {
			cidadeTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else cidadeTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		if(!ValidarDados.validarIntPositivo(cepFormTextField.getText().replace("-", ""))) {
			cepFormTextField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else cepFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		return valido;
	}

	/** Insere a borda padrão nos campos do painel
	 */
	@Override
	public void inserirBordasPadrao() {
		logradouroTextField.setBorder(UIManager.getBorder("TextField.border"));
		numeroTextField.setBorder(UIManager.getBorder("TextField.border"));
		bairroTextField.setBorder(UIManager.getBorder("TextField.border"));
		cidadeTextField.setBorder(UIManager.getBorder("TextField.border"));
		cepFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
	}
	
} // class PainelCadEndereco
