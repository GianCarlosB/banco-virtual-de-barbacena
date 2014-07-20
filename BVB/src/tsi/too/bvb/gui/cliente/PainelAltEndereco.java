package tsi.too.bvb.gui.cliente;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
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
import tsi.too.bvb.eventos.cliente.TEActionAlterarCliente;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define o painel endereço utilizado pela janela <code>IgAltCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgAltCliente
 * @see TratadorDeCampos
 */
public class PainelAltEndereco extends JPanel implements TratadorDeCampos {
	
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
	private JButton btnEditarLogradouro;
	private JButton btnEditarComplemento;
	private JButton btnEditarNumero;
	private JButton btnEditarBairro;
	private JButton btnEditarCep;
	private JButton btnEditarCidade;
	private JButton btnEditarUf;
	private JComboBox<Object> ufComboBox;

	/** Cria uma instância do painel endereço utilizado pela janela <code>IgAltCliente</code>
	 * @param janelaPai <code>Window</code> com a janela pai do painel <code>PainelAltEndereco</code>
	 * @param cliente <code>Cliente</code> com os dados do cliente que será alterado
	 * 
	 * @see Window
	 * @see Cliente
	 */	
	public PainelAltEndereco(Window janelaPai, Cliente cliente) {
		setLayout(null);
		
		JPanel localPanel = new JPanel();
		localPanel.setLayout(null);
		localPanel.setBorder(new TitledBorder(null, "Local", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		localPanel.setBounds(10, 11, 497, 152);
		add(localPanel);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setDisplayedMnemonic(KeyEvent.VK_C);
		lblComplemento.setBounds(10, 50, 85, 14);
		localPanel.add(lblComplemento);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setDisplayedMnemonic(KeyEvent.VK_L);
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
		logradouroTextField.setToolTipText("este campo n\u00E3o pode ficar vazio");
		logradouroTextField.setColumns(10);
		logradouroTextField.setBounds(100, 17, 269, 20);
		logradouroTextField.setText(cliente.getEndereco().getLogradouro());
		localPanel.add(logradouroTextField);
		
		complementoTextField = new JTextField();
		lblComplemento.setLabelFor(complementoTextField);
		complementoTextField.setToolTipText("este campo pode ficar vazio");
		complementoTextField.setColumns(10);
		complementoTextField.setBounds(100, 47, 269, 20);
		complementoTextField.setText(cliente.getEndereco().getComplemento());
		localPanel.add(complementoTextField);
		
		numeroTextField = new JTextField();
		lblNumero.setLabelFor(numeroTextField);
		numeroTextField.setToolTipText("este campo n\u00E3o pode ficar vazio e deve conter apenas d\u00EDgitos decimais");
		numeroTextField.setColumns(10);
		numeroTextField.setText(cliente.getEndereco().getNumero());
		numeroTextField.setBounds(100, 77, 269, 20);
		localPanel.add(numeroTextField);
		
		bairroTextField = new JTextField();
		lblBairro.setLabelFor(bairroTextField);
		bairroTextField.setToolTipText("este campo n\u00E3o pode ficar vazio");
		bairroTextField.setColumns(10);
		bairroTextField.setBounds(100, 107, 269, 20);
		bairroTextField.setText(cliente.getEndereco().getBairro());
		localPanel.add(bairroTextField);
		
		btnEditarLogradouro = new JButton("Editar");
		btnEditarLogradouro.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarLogradouro.setMnemonic(KeyEvent.VK_1);
		btnEditarLogradouro.setBounds(396, 14, 89, 23);
		localPanel.add(btnEditarLogradouro);
		
		btnEditarComplemento = new JButton("Editar");
		btnEditarComplemento.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarComplemento.setMnemonic(KeyEvent.VK_2);
		btnEditarComplemento.setBounds(396, 44, 89, 23);
		localPanel.add(btnEditarComplemento);
		
		btnEditarNumero = new JButton("Editar");
		btnEditarNumero.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarNumero.setMnemonic(KeyEvent.VK_3);
		btnEditarNumero.setBounds(396, 74, 89, 23);
		localPanel.add(btnEditarNumero);
		
		btnEditarBairro = new JButton("Editar");
		btnEditarBairro.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarBairro.setMnemonic(KeyEvent.VK_4);
		btnEditarBairro.setBounds(396, 104, 89, 23);
		localPanel.add(btnEditarBairro);
		
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
		
		cidadeTextField = new JTextField();
		lblCidade.setLabelFor(cidadeTextField);
		cidadeTextField.setToolTipText("este campo n\u00E3o pode ficar vazio");
		cidadeTextField.setColumns(10);
		cidadeTextField.setBounds(100, 47, 269, 20);
		cidadeTextField.setText(cliente.getEndereco().getCidade());
		RegionalPanel.add(cidadeTextField);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setDisplayedMnemonic(KeyEvent.VK_E);
		lblCep.setBounds(10, 20, 46, 14);
		RegionalPanel.add(lblCep);
		
		cepFormTextField = new JFormattedTextField(new Mascara("#####-###"));
		cepFormTextField.setText(cliente.getEndereco().getCep());
		lblCep.setLabelFor(cepFormTextField);
		cepFormTextField.setToolTipText("este campo n\u00E3o pode ficar vazio e deve conter apenas d\u00EDgitos decimais");
		cepFormTextField.setBounds(100, 17, 269, 20);
		RegionalPanel.add(cepFormTextField);
		cepFormTextField.setText(cliente.getEndereco().getCep());
		
		btnEditarCep = new JButton("Editar");
		btnEditarCep.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarCep.setMnemonic(KeyEvent.VK_5);
		btnEditarCep.setBounds(396, 14, 89, 23);
		RegionalPanel.add(btnEditarCep);
		
		btnEditarCidade = new JButton("Editar");
		btnEditarCidade.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarCidade.setMnemonic(KeyEvent.VK_6);
		btnEditarCidade.setBounds(396, 44, 89, 23);
		RegionalPanel.add(btnEditarCidade);
		
		btnEditarUf = new JButton("Editar");
		btnEditarUf.addActionListener(new TEActionAlterarCliente((IgAltCliente) janelaPai, this, cliente));
		btnEditarUf.setMnemonic(KeyEvent.VK_7);
		btnEditarUf.setBounds(396, 74, 89, 23);
		RegionalPanel.add(btnEditarUf);
		
		ufComboBox = new JComboBox<Object>(UF.obterArrayUF());
		ufComboBox.setToolTipText("selecione o novo UF de sua cidade se dejar alterar");
		ufComboBox.setBounds(100, 77, 45, 20);
		RegionalPanel.add(ufComboBox);
		
		for(int i =0; i < UF.getNUM_ESTADOS(); i++)
			if(((String)ufComboBox.getItemAt(i)).equals(cliente.getEndereco().getUf().getUf())) {
				ufComboBox.setSelectedIndex(i);
				break;
			}
	}
	
	/** Verifica se o campo logradouro do painel for preenchido corretamente. Se o campo estiver errado
	 *  receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo logradouro tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarLogradouro() {
		if(!ValidarDados.validarVazio(logradouroTextField.getText())) {
			logradouroTextField.setBorder(new LineBorder(Color.RED));
			return false;
		}
		else logradouroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
	}
	
	/** Verifica se o campo número do painel for preenchido corretamente. Se o campo estiver errado
	 *  receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo número tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarNumero() {
		if(!ValidarDados.validarIntPositivo(numeroTextField.getText())) {
			numeroTextField.setBorder(new LineBorder(Color.RED));
			return false;
		}
		else numeroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
	}
	
	/** Verifica se o campo bairro do painel for preenchido corretamente. Se o campo estiver errado
	 *  receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo bairro tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarBairro() {
		if(!ValidarDados.validarVazio(bairroTextField.getText())) {
			bairroTextField.setBorder(new LineBorder(Color.RED));
			return false;
		}
		else bairroTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
	}
	
	/** Verifica se o campo cep do painel for preenchido corretamente. Se o campo estiver errado
	 *  receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo cep tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarCep() {
		if(!ValidarDados.validarIntPositivo(cepFormTextField.getText().replace("-", ""))) {
			cepFormTextField.setBorder(new LineBorder(Color.RED));
			return false;
		}
		else cepFormTextField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		return true;
	}
	
	/** Verifica se o campo cidade do painel for preenchido corretamente. Se o campo estiver errado
	 *  receberá uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso o campo cidade tenha sido preenchido corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	public boolean validarCidade() {
		if(!ValidarDados.validarVazio(cidadeTextField.getText())) {
			cidadeTextField.setBorder(new LineBorder(Color.RED));
			return false;
		}
		else cidadeTextField.setBorder(UIManager.getBorder("TextField.border"));
		
		return true;
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

	/* (non-Javadoc)
	 * @see TratadorDeCampos
	 */
	@Override
	public boolean validarCampos() {
		return false;
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

	/** Retorna um <code>JTextField</code> com o campo de texto logradouro
	 * @return <code>JTextField</code> com o campo de texto logradouro
	 */
	public JTextField getLogradouroTextField() {
		return logradouroTextField;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto complemento
	 * @return <code>JTextField</code> com o campo de texto complemento
	 */
	public JTextField getComplementoTextField() {
		return complementoTextField;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto número
	 * @return <code>JTextField</code> com o campo de texto número
	 */
	public JTextField getNumeroTextField() {
		return numeroTextField;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto bairro
	 * @return <code>JTextField</code> com o campo de texto bairro
	 */
	public JTextField getBairroTextField() {
		return bairroTextField;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto cidade
	 * @return <code>JTextField</code> com o campo de texto cidade
	 */
	public JTextField getCidadeTextField() {
		return cidadeTextField;
	}

	/** Retorna um <code>JFormattedTextField</code> com o campo de texto cpf
	 * @return <code>JFormattedTextField</code> com o campo de texto cpf
	 */
	public JFormattedTextField getCepFormTextField() {
		return cepFormTextField;
	}

	/** Retorna um <code>JComboBox</code> com a caixa de combinação uf
	 * @return <code>JComboBox</code> com a caixa de combinação uf
	 */
	public JComboBox<Object> getUfComboBox() {
		return ufComboBox;
	}

	/** Retorna um <code>JButton</code> com o botão editar logradouro
	 * @return <code>JButton</code> com o botão editar logradouro
	 */
	public JButton getBtnEditarLogradouro() {
		return btnEditarLogradouro;
	}

	/** Retorna um <code>JButton</code> com o botão editar complemento
	 * @return <code>JButton</code> com o botão editar complemento
	 */
	public JButton getBtnEditarComplemento() {
		return btnEditarComplemento;
	}

	/** Retorna um <code>JButton</code> com o botão editar número
	 * @return <code>JButton</code> com o botão editar número
	 */
	public JButton getBtnEditarNumero() {
		return btnEditarNumero;
	}

	/** Retorna um <code>JButton</code> com o botão editar bairro
	 * @return <code>JButton</code> com o botão editar bairro
	 */
	public JButton getBtnEditarBairro() {
		return btnEditarBairro;
	}

	/** Retorna um <code>JButton</code> com o botão editar cep
	 * @return <code>JButton</code> com o botão editar cep
	 */
	public JButton getBtnEditarCep() {
		return btnEditarCep;
	}

	/** Retorna um <code>JButton</code> com o botão editar cidade
	 * @return <code>JButton</code> com o botão editar cidade
	 */
	public JButton getBtnEditarCidade() {
		return btnEditarCidade;
	}

	/** Retorna um <code>JButton</code> com o botão editar uf
	 * @return <code>JButton</code> com o botão editar uf
	 */
	public JButton getBtnEditarUf() {
		return btnEditarUf;
	}

} // class PainelCadEndereco
