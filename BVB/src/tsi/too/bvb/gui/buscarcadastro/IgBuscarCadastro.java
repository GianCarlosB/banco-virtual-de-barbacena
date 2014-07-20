package tsi.too.bvb.gui.buscarcadastro;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.eventos.buscarcadastro.TEActionBuscarCadastro;
import tsi.too.bvb.gui.PainelBuscarAgencia;
import tsi.too.bvb.gui.PainelBuscarCliente;
import tsi.too.bvb.gui.PainelBuscarFuncionario;

/** Classe que define a GUI de busca de cadastro do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgBuscarCadastro extends JDialog {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 3529551018719501018L;
	
	private Cliente cliente;
	private Funcionario funcionario;
	private Agencia agencia;
	
	private Point point = new Point();

	private CardLayout cardLayout= new CardLayout();
	
	private final JPanel contentPanel = new JPanel();
	private JPanel cardPanel;
	private final int NUM_CARDS = 3;
	
	private PainelBuscarCliente pBuscarCliente = new PainelBuscarCliente();
	private PainelBuscarFuncionario pBuscarFuncionario = new PainelBuscarFuncionario();
	private PainelBuscarAgencia pBuscarAgencia = new PainelBuscarAgencia();
	private JButton btnBuscar;
	private JButton btnAlterarDados;
	private JEditorPane dadosEditorPane;
	private JButton btnAlterar;
	private JTextPane txtpnTitulo;
	private JTextPane txtpnSubTitulo;
	private JEditorPane dtrpnCampoTitulo;
	private JLabel lblImg;

	/** Cria uma instância da janela de alteração de cadastro do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgBuscarCadastro</code>
	 * @param titulo <code>String</code> com o título da janela
	 * @param txtTitulo <code>String</code> com o título do corpo da janela
	 * @param txtSubTitulo <code>String</code> com o subtítulo do corpo da janela
	 * @param tipo <code>final</code> <code>int</code> com o tipo da busca: 1 - Cliente, 2 - Funcionário, 3 - Agência
	 * 
	 * @see Window
	 */	
	public IgBuscarCadastro(Window janelaPai, String titulo, String txtTitulo, String txtSubTitulo, final int tipo) {
		setModal(true);
		
		// Cores Flat
		Color peterRiver = new Color(52, 152, 219);
		Color nephritis = new Color(39, 174, 96);
		Color pumpkin = new Color(211, 84, 0);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle(titulo);
		setBounds(100, 100, 523, 506);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		getContentPane().add(separatorTitulo);
		
		txtpnTitulo = new JTextPane();
		txtpnTitulo.setBackground(Color.LIGHT_GRAY);
		txtpnTitulo.setText(txtTitulo);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 330, 22);
		getContentPane().add(txtpnTitulo);
		
		txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setBackground(Color.LIGHT_GRAY);
		txtpnSubTitulo.setText(txtSubTitulo);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 330, 22);
		getContentPane().add(txtpnSubTitulo);
		
		lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setBounds(459, 11, 48, 48);
		getContentPane().add(lblImg);
		
		dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(Color.LIGHT_GRAY);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		getContentPane().add(dtrpnCampoTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		getContentPane().add(separatorBtn);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		getContentPane().add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setEnabled(false);
		btnAlterarDados.setMnemonic(KeyEvent.VK_L);
		btnAlterarDados.addActionListener(new TEActionBuscarCadastro(this, tipo));
		Btnpanel.add(btnAlterarDados);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgBuscarCadastro.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		Btnpanel.add(btnCancelar);
		
		cardPanel = new JPanel();
		cardPanel.setBounds(0, 70, 415, 48);
		getContentPane().add(cardPanel);
		cardPanel.setLayout(cardLayout);
		pBuscarCliente.getCpfFormattedTextField().setToolTipText("para pesquisar utilizando o cpf clique no bot\u00E3o buscar");
		pBuscarCliente.getCpfFormattedTextField().setBounds(100, 22, 308, 20);
		cardPanel.add(pBuscarCliente, "clientePanel");
		pBuscarFuncionario.getLoginTextField().setToolTipText("para pesquisar utilizando o login clique no bot\u00E3o buscar");
		cardPanel.add(pBuscarFuncionario, "funcionarioPanel");
		pBuscarAgencia.getCodigoTextField().setToolTipText("para pesquisar utilizando o c\u00F3digo clique no bot\u00E3o buscar");
		cardPanel.add(pBuscarAgencia, "agenciaPanel");
		exibeCardPainel(tipo);
		
		JPanel panelDados = new JPanel();
		panelDados.setLayout(null);
		panelDados.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelDados.setBounds(10, 129, 497, 284);
		getContentPane().add(panelDados);
		
		JScrollPane dadosScrollPane = new JScrollPane();
		dadosScrollPane.setBorder(null);
		dadosScrollPane.setBounds(10, 20, 477, 253);
		panelDados.add(dadosScrollPane);
		
		dadosEditorPane = new JEditorPane();
		dadosEditorPane.setToolTipText("este campo exibe os dados refer\u00EAntes ao item buscado");
		dadosEditorPane.setForeground(Color.BLACK);
		dadosEditorPane.setFont(new Font("Arial", Font.BOLD, 14));
		dadosEditorPane.setEditable(false);
		dadosEditorPane.setBackground(new Color(238, 238, 238));
		dadosScrollPane.setViewportView(dadosEditorPane);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.addActionListener(new TEActionBuscarCadastro(this, tipo));
		btnBuscar.setBounds(418, 91, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setVisible(false);
		btnAlterar.addActionListener(new TEActionBuscarCadastro(this, tipo));
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		btnAlterar.setBounds(418, 91, 89, 23);
		getContentPane().add(btnAlterar);
		
		this.point = janelaPai.getLocation();
		this.point.x += (janelaPai.getWidth() / 2 - this.getWidth() / 2);
		this.point.y += (janelaPai.getHeight() / 2 - this.getHeight() / 2);
		
		Point localPoint = new Point(this.point);
		localPoint.x -= 275;
		
		carregarElementosTipo(tipo, peterRiver, nephritis, pumpkin);
		setLocation(localPoint);
		setVisible(true);
	}
	
	/** Exibe o painel da janela <code>IgBuscarCadastro</code> de acordo com o tipo da busca
	 * @param tipo <code>int</code> com o tipo da busca: 1 - Cliente, 2 - Funcionário, 3 - Agência
	 */
	private void exibeCardPainel(int tipo) {
		switch(tipo) {
		case 1: cardLayout.show(cardPanel, "clientePanel"); break;
		case 2: cardLayout.show(cardPanel, "funcionarioPanel"); break;
		case 3: cardLayout.show(cardPanel, "agenciaPanel"); break;
		}
	}
	
	/** Exibe as opções de alterar dados da janela <code>IgBuscarCadastro</code>
	 * @param dados <code>String</code> com o texto do campo de texto dados
	 */
	public void exibeOpcoesAlterarDados(String dados) {
		btnAlterarDados.setEnabled(true);
		btnBuscar.setVisible(false);
		btnAlterar.setVisible(true);
		dadosEditorPane.setText(dados);
	}
	
	/** Esconde as opções de alterar dados da janela <code>IgBuscarCadastro</code>
	 */
	public void escondeOpcoesAlterarDados() {
		btnAlterarDados.setEnabled(false);
		btnBuscar.setVisible(true);
		btnAlterar.setVisible(false);
		dadosEditorPane.setText("");
	}
	
	/** Carrega os elementos da janela <code>IgBuscarCadastro</code> de acordo com o tipo da busca
	 * tipo <code>int</code> com o tipo da busca: 1 - Cliente, 2 - Funcionário, 3 - Agência
	 * tipo <code>Color</code> com a cor do cabeçalho da janela se o tipo <code>int</code> passado como parâmetro for cliente
	 * tipo <code>Color</code> com a cor do cabeçalho da janela se o tipo <code>int</code> passado como parâmetro for funcionário
	 * tipo <code>Color</code> com a cor do cabeçalho da janela se o tipo <code>int</code> passado como parâmetro for agência
	 * 
	 * @see Color
	 */
	private void carregarElementosTipo(int tipo, Color peterRiver, Color nephritis, Color pumpkin) {
		switch(tipo) {
		case 1:
			txtpnTitulo.setBackground(peterRiver);
			txtpnSubTitulo.setBackground(peterRiver);
			dtrpnCampoTitulo.setBackground(peterRiver);
			lblImg.setIcon(new ImageIcon(IgBuscarCadastro.class.getResource("/tsi/too/bvb/recursos/imagens/User-Login-48.png")));
			break;
		case 2:
			txtpnTitulo.setBackground(nephritis);
			txtpnSubTitulo.setBackground(nephritis);
			dtrpnCampoTitulo.setBackground(nephritis);
			lblImg.setIcon(new ImageIcon(IgBuscarCadastro.class.getResource("/tsi/too/bvb/recursos/imagens/User-48.png")));
			break;
		case 3:
			txtpnTitulo.setBackground(pumpkin);
			txtpnSubTitulo.setBackground(pumpkin);
			dtrpnCampoTitulo.setBackground(pumpkin);
			lblImg.setIcon(new ImageIcon(IgBuscarCadastro.class.getResource("/tsi/too/bvb/recursos/imagens/Building-48.png")));
			break;
		}
	}
	
	/** Retorna um <code>Cliente</code> com os dados do cliente pesquisado
	 * @return <code>Cliente</code> com os dados do cliente pesquisado
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/** Muda o objeto cliente
	 * @param cliente <code>Cliente</code> com o novo objeto cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/** Retorna um <code>Funcionario</code> com os dados do funcionário pesquisado
	 * @return <code>Funcionario</code> com os dados do funcionário pesquisado
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/** Muda o objeto funcionário
	 * @param funcionario <code>Funcionario</code> com o novo objeto funcionário
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/** Retorna uma <code>Agencia</code> com os dados da agência pesquisada
	 * @return <code>Agencia</code> com os dados da agência pesquisada
	 */
	public Agencia getAgencia() {
		return agencia;
	}

	/** Muda o objeto agência
	 * @param agencia <code>Agencia</code> com o novo objeto agência
	 */
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	/** Retorna um <code>PainelBuscarCliente</code> referênte ao painel do cliente
	 * @return <code>PainelBuscarCliente</code> referênte ao painel do cliente
	 */
	public PainelBuscarCliente getPBuscarCliente() {
		return pBuscarCliente;
	}

	/** Retorna um <code>PainelBuscarFuncionario</code> referênte ao painel do funcionário
	 * @return <code>PainelBuscarFuncionario</code> referênte ao painel do funcionário
	 */
	public PainelBuscarFuncionario getPBuscarFuncionario() {
		return pBuscarFuncionario;
	}

	/** Retorna um <code>PainelBuscarAgencia</code> referênte ao painel da agência
	 * @return <code>PainelBuscarAgencia</code> referênte ao painel da agência
	 */
	public PainelBuscarAgencia getPBuscarAgencia() {
		return pBuscarAgencia;
	}
	
	/** Retorna um <code>Point</code> com as coordenadas da janela pai
	 * @return <code>Point</code> com as coordenadas da janela pai
	 */
	public Point getPoint() {
		return point;
	}

	/** Retorna um <code>JButton</code> com o botão buscar
	 * @return <code>JButton</code> com o botão buscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/** Retorna um <code>JButton</code> com o botão alterar
	 * @return <code>JButton</code> com o botão alterar
	 */
	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	/** Retorna um <code>JButton</code> com o botão alterar dados
	 * @return <code>JButton</code> com o botão alterar dados
	 */
	public JButton getBtnAlterarDados() {
		return btnAlterarDados;
	}

	/** Retorna um <code>int</code> com o número de "cartas" do painel
	 * @return <code>int</code> com o número de "cartas" do painel
	 */
	public int getNUM_CARDS() {
		return NUM_CARDS;
	}
	
} // class IgBuscarCadastro
