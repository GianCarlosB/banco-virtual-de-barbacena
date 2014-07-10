package tsi.too.bvb.gui.menuprincipal;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.eventos.menuprincipal.TEActionMenuPrincipal;
import tsi.too.bvb.eventos.menuprincipal.TEJanelaMenuPrincipal;
import tsi.too.bvb.eventos.menuprincipal.TEMouseMenuPrincipal;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.login.IgLogin;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

public class IgMenuPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1271399365713672153L;
	
	private Funcionario funcionario;
	private Date dataInicial;
	
	private JButton altClienteImgBtn;
	private JButton relClienteImgBtn;
	private JButton exClienteImgBtn;
	private JButton cadClienteBtn;
	private JButton altClienteBtn;
	private JButton relClienteBtn;
	private JButton exClienteBtn;
	private JButton cadFuncImgBtn;
	private JButton altFuncImgBtn;
	private JButton relFuncImgBtn;
	private JButton exFuncImgBtn;
	private JButton cadFuncBtn;
	private JButton altFuncBtn;
	private JButton relFuncBtn;
	private JButton exFuncBtn;
	private JButton cadAgImgBtn;
	private JButton altAgImgBtn;
	private JButton relAgImgBtn;
	private JButton exAgImgBtn;
	private JButton cadAgBtn;
	private JButton altAgBtn;
	private JButton relAgBtn;
	private JButton exAgBtn;
	private JButton cadClienteImgBtn;
	private JButton ajudaImgBtn;
	private JButton ajudaBtn;
	private JButton consFuncImgBtn;
	private JButton consFuncBtn;
	private JButton consAgImgBtn;
	private JButton consAgBtn;
	private JMenuItem mntmSair;
	private JMenuItem mntmAutor;
	private JButton consClienteImgBtn;
	private JButton consClienteBtn;
	private JButton depositarSalContaImgBtn;
	private JButton depositarSalContaBtn;
	private JButton criarAplicContaImgBtn;
	private JButton criarAplicContaBtn;
	private JButton alterarAplicContaImgBtn;
	private JButton alterarAplicContaBtn;
	private JButton abrirContaImgBtn;
	private JButton abrirContaBtn;
	private JButton caixaEletronicoImgBtn;
	private JButton caixaEletronicoBtn;
	private JButton alterarSenhaImgBtn;
	private JButton alterarSenhaBtn;
	private JMenuItem mntmLogout;
	private JMenu mnAparência;
	private JLabel lblImgSeta1;
	private JLabel lblImgSeta2;
	private JLabel lblImgSeta3;
	private JLabel lblImgSeta5;
	private JLabel lblImgSeta6;
	private JLabel lblImgAjuda;
	private JTabbedPane tabbedPane;
	private JLabel lblImgSeta4;
	private JTextField txtTopico4;
	private JLabel lblBanner;
	private JLabel lblCopyrightHome;
	private JLabel lblCopyrightClientes;
	private JLabel lblCopyrightFuncionarios;
	private JLabel lblCopyrightAgencias;
	private JLabel lblCopyrightContas;
	private JLabel lblCopyrightOutros;
	private JMenuItem mntmTema;
	private JMenuItem mntmLimparBD;

	public IgMenuPrincipal(Funcionario funcionario) {
		this.funcionario = funcionario;
		this.dataInicial = new Date();
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/BVB - \u00EDcone.png")));
		addWindowListener(new TEJanelaMenuPrincipal(this));

		// Cores Flat
		Color peterRiver = new Color(52, 152, 219);
		Color sunFlower = new Color(241, 196, 15);
		Color pomergante = new Color(192, 57, 43);
		Color midnigthBlue = new Color(44, 62, 80);
		Color concrete = new Color(127, 140, 141);
		Color nephritis = new Color(39, 174, 96);
		Color pumpkin = new Color(211, 84, 0);
		Color turquoise = new Color(26, 188, 156);
		Color orange = new Color(243, 156, 18);
		
		setTitle(".: BVB - Banco Virtual de Barbacena :.");
		setSize(926, 620);
		getContentPane().setBackground(concrete);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 118, 920, 474);
		tabbedPane.setMinimumSize(new Dimension(15, 15));
		tabbedPane.setPreferredSize(new Dimension(15, 15));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(midnigthBlue);
		
		JPanel homePanel = new JPanel();  // Cria o painel Home.
		homePanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Home", new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Home-24.png")),
				          homePanel, "painel inicial");
		homePanel.setLayout(null);
		
		lblCopyrightHome = new JLabel("Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04");
		lblCopyrightHome.setBounds(725, 418, 175, 16);
		homePanel.add(lblCopyrightHome);
		lblCopyrightHome.setForeground(Color.WHITE);
		lblCopyrightHome.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblTituloHome = new JLabel("Seja Bem Vindo Sr(a). " + funcionario.getNomeUsuario());
		lblTituloHome.setBounds(0, 11, 915, 34);
		lblTituloHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloHome.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 24));
		lblTituloHome.setForeground(Color.WHITE);
		lblTituloHome.setBackground(midnigthBlue);
		homePanel.add(lblTituloHome);
		
		JLabel lblImgBVB = new JLabel("bvb");
		lblImgBVB.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Logo02 - BVB.png")));
		lblImgBVB.setBounds(10, 48, 387, 387);
		homePanel.add(lblImgBVB);
		
		JPanel introducaoPanel = new JPanel();
		introducaoPanel.setBackground(midnigthBlue);
		introducaoPanel.setBounds(407, 48, 498, 387);
		homePanel.add(introducaoPanel);
		introducaoPanel.setLayout(null);
		
		JEditorPane dtrpnTxtIntroducao = new JEditorPane();
		dtrpnTxtIntroducao.setEditable(false);
		dtrpnTxtIntroducao.setText("Este m\u00F3dulo \u00E9 composto por um conjunto de servi\u00E7os\r\nrespons\u00E1veis por controlar a entrada e sa\u00EDda de dados do sistema.\r\nAbaixo est\u00E1 listado algumas das funcionalidades do software:");
		dtrpnTxtIntroducao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dtrpnTxtIntroducao.setForeground(Color.WHITE);
		dtrpnTxtIntroducao.setBackground(midnigthBlue);
		dtrpnTxtIntroducao.setBounds(10, 11, 478, 66);
		introducaoPanel.add(dtrpnTxtIntroducao);
		
		lblImgSeta1 = new JLabel("");
		lblImgSeta1.addMouseListener(new TEMouseMenuPrincipal(this));
		lblImgSeta1.setDisplayedMnemonic(KeyEvent.VK_1);
		lblImgSeta1.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Arrowhead-Right-32 (cinza).png")));
		lblImgSeta1.setBounds(20, 89, 32, 32);
		introducaoPanel.add(lblImgSeta1);
		
		lblImgSeta2 = new JLabel("");
		lblImgSeta2.addMouseListener(new TEMouseMenuPrincipal(this));
		lblImgSeta2.setDisplayedMnemonic(KeyEvent.VK_2);
		lblImgSeta2.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Arrowhead-Right-32 (cinza).png")));
		lblImgSeta2.setBounds(20, 129, 32, 32);
		introducaoPanel.add(lblImgSeta2);
		
		lblImgSeta3 = new JLabel("");
		lblImgSeta3.addMouseListener(new TEMouseMenuPrincipal(this));
		lblImgSeta3.setDisplayedMnemonic(KeyEvent.VK_3);
		lblImgSeta3.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Arrowhead-Right-32 (cinza).png")));
		lblImgSeta3.setBounds(20, 169, 32, 32);
		introducaoPanel.add(lblImgSeta3);
		
		lblImgSeta4 = new JLabel("");
		lblImgSeta4.addMouseListener(new TEMouseMenuPrincipal(this));
		lblImgSeta4.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Arrowhead-Right-32 (cinza).png")));
		lblImgSeta4.setDisplayedMnemonic(KeyEvent.VK_4);
		lblImgSeta4.setBounds(20, 209, 32, 32);
		introducaoPanel.add(lblImgSeta4);
		
		lblImgSeta5 = new JLabel("");
		lblImgSeta5.addMouseListener(new TEMouseMenuPrincipal(this));
		lblImgSeta5.setDisplayedMnemonic(KeyEvent.VK_5);
		lblImgSeta5.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Arrowhead-Right-32 (cinza).png")));
		lblImgSeta5.setBounds(20, 249, 32, 32);
		introducaoPanel.add(lblImgSeta5);
		
		lblImgSeta6 = new JLabel("");
		lblImgSeta6.addMouseListener(new TEMouseMenuPrincipal(this));
		lblImgSeta6.setDisplayedMnemonic(KeyEvent.VK_6);
		lblImgSeta6.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Arrowhead-Right-32 (cinza).png")));
		lblImgSeta6.setBounds(20, 289, 32, 32);
		introducaoPanel.add(lblImgSeta6);
		
		JTextField txtTopico1 = new JTextField();
		txtTopico1.setEditable(false);
		lblImgSeta1.setLabelFor(txtTopico1);
		txtTopico1.setBorder(null);
		txtTopico1.setBackground(midnigthBlue);
		txtTopico1.setForeground(Color.WHITE);
		txtTopico1.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTopico1.setText(" Controle de Clientes");
		txtTopico1.setBounds(62, 89, 218, 32);
		introducaoPanel.add(txtTopico1);
		txtTopico1.setColumns(10);
		
		JTextField txtTopico2 = new JTextField();
		txtTopico2.setEditable(false);
		lblImgSeta2.setLabelFor(txtTopico2);
		txtTopico2.setBorder(null);
		txtTopico2.setBackground(midnigthBlue);
		txtTopico2.setForeground(Color.WHITE);
		txtTopico2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTopico2.setText(" Controle de Funcion\u00E1rios");
		txtTopico2.setColumns(10);
		txtTopico2.setBounds(62, 129, 218, 32);
		introducaoPanel.add(txtTopico2);
		
		JTextField txtTopico3 = new JTextField();
		txtTopico3.setEditable(false);
		lblImgSeta3.setLabelFor(txtTopico3);
		txtTopico3.setBorder(null);
		txtTopico3.setBackground(midnigthBlue);
		txtTopico3.setForeground(Color.WHITE);
		txtTopico3.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTopico3.setText(" Controle de Ag\u00EAncias");
		txtTopico3.setColumns(10);
		txtTopico3.setBounds(62, 169, 218, 32);
		introducaoPanel.add(txtTopico3);
		lblImgSeta4.setLabelFor(txtTopico4);
		
		txtTopico4 = new JTextField();
		txtTopico4.setText(" Controle de Contas");
		txtTopico4.setForeground(Color.WHITE);
		txtTopico4.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTopico4.setEditable(false);
		txtTopico4.setColumns(10);
		txtTopico4.setBorder(null);
		txtTopico4.setBackground(new Color(44, 62, 80));
		txtTopico4.setBounds(62, 209, 218, 32);
		introducaoPanel.add(txtTopico4);
		
		JTextField txtTopico5 = new JTextField();
		txtTopico5.setEditable(false);
		lblImgSeta5.setLabelFor(txtTopico5);
		txtTopico5.setBorder(null);
		txtTopico5.setBackground(midnigthBlue);
		txtTopico5.setForeground(Color.WHITE);
		txtTopico5.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTopico5.setText(" Alterar Senha");
		txtTopico5.setColumns(10);
		txtTopico5.setBounds(62, 249, 218, 32);
		introducaoPanel.add(txtTopico5);
		
		JTextField txtTopico6 = new JTextField();
		txtTopico6.setEditable(false);
		lblImgSeta6.setLabelFor(txtTopico6);
		txtTopico6.setBorder(null);
		txtTopico6.setBackground(midnigthBlue);
		txtTopico6.setForeground(Color.WHITE);
		txtTopico6.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTopico6.setText(" Iniciar o Caixa eletr\u00F4nico");
		txtTopico6.setColumns(10);
		txtTopico6.setBounds(62, 289, 218, 32);
		introducaoPanel.add(txtTopico6);
		
		lblImgAjuda = new JLabel("");
		lblImgAjuda.addMouseListener(new TEMouseMenuPrincipal(this));
		lblImgAjuda.setDisplayedMnemonic(KeyEvent.VK_H);
		lblImgAjuda.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Help-24 (cinza).png")));
		lblImgAjuda.setBounds(155, 350, 24, 24);
		introducaoPanel.add(lblImgAjuda);
		
		JEditorPane dtrpnTxtDuvida = new JEditorPane();
		dtrpnTxtDuvida.setEditable(false);
		lblImgAjuda.setLabelFor(dtrpnTxtDuvida);
		dtrpnTxtDuvida.setText("Para tirar d\u00FAvidas sobre o funcionamento do aplicativo, v\u00E1 na aba \"Outros\" e\nclique no bot\u00E3o de ajuda.");
		dtrpnTxtDuvida.setForeground(Color.WHITE);
		dtrpnTxtDuvida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dtrpnTxtDuvida.setBackground(new Color(44, 62, 80));
		dtrpnTxtDuvida.setBounds(10, 333, 478, 43);
		introducaoPanel.add(dtrpnTxtDuvida);
		JPanel clientePanel = new JPanel(); // Cria o painel Clientes.
		clientePanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Clientes", new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/User-Login-24.png")),
				          clientePanel, "painel de controle de clientes");
		
		cadClienteImgBtn = new JButton("");
		cadClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		cadClienteImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		cadClienteImgBtn.setBounds(20, 77, 160, 160);
		cadClienteImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/User-Add-128.png")));
		cadClienteImgBtn.setBackground(peterRiver);
		
		altClienteImgBtn = new JButton("");
		altClienteImgBtn.setBounds(380, 77, 160, 160);
		altClienteImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/User-Modify-128.png")));
		altClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		altClienteImgBtn.setBackground(peterRiver);
		
		relClienteImgBtn = new JButton("");
		relClienteImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		relClienteImgBtn.setBounds(740, 77, 160, 160);
		relClienteImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/File-Format-PDF-128.png")));
		relClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		relClienteImgBtn.setBackground(peterRiver);
		
		exClienteImgBtn = new JButton("");
		exClienteImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		exClienteImgBtn.setBounds(560, 77, 160, 160);
		exClienteImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/close11.png")));
		exClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		exClienteImgBtn.setBackground(pomergante);
		
		cadClienteBtn = new JButton("Cadastrar");
		cadClienteBtn.addActionListener(new TEActionMenuPrincipal(this));
		cadClienteBtn.setMnemonic(KeyEvent.VK_C);
		cadClienteBtn.setBounds(20, 248, 160, 38);
		cadClienteBtn.setBorder(new LineBorder(Color.WHITE));
		cadClienteBtn.setForeground(Color.WHITE);
		cadClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cadClienteBtn.setBackground(peterRiver);
		
		altClienteBtn = new JButton("Alterar");
		altClienteBtn.setMnemonic(KeyEvent.VK_A);
		altClienteBtn.setBounds(380, 248, 160, 38);
		altClienteBtn.setActionCommand("Alterar");
		altClienteBtn.setForeground(Color.WHITE);
		altClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altClienteBtn.setBorder(new LineBorder(Color.WHITE));
		altClienteBtn.setBackground(peterRiver);
		
		relClienteBtn = new JButton("Relatorio");
		relClienteBtn.addActionListener(new TEActionMenuPrincipal(this));
		relClienteBtn.setMnemonic(KeyEvent.VK_R);
		relClienteBtn.setBounds(740, 248, 160, 38);
		relClienteBtn.setForeground(Color.WHITE);
		relClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relClienteBtn.setBorder(new LineBorder(Color.WHITE));
		relClienteBtn.setBackground(peterRiver);
		
		exClienteBtn = new JButton("Excluir");
		exClienteBtn.addActionListener(new TEActionMenuPrincipal(this));
		exClienteBtn.setMnemonic(KeyEvent.VK_E);
		exClienteBtn.setBounds(560, 248, 160, 38);
		exClienteBtn.setForeground(Color.WHITE);
		exClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exClienteBtn.setBorder(new LineBorder(Color.WHITE));
		exClienteBtn.setBackground(pomergante);
		clientePanel.setLayout(null);
		clientePanel.add(cadClienteImgBtn);
		clientePanel.add(cadClienteBtn);
		clientePanel.add(altClienteImgBtn);
		clientePanel.add(relClienteImgBtn);
		clientePanel.add(altClienteBtn);
		clientePanel.add(relClienteBtn);
		clientePanel.add(exClienteBtn);
		clientePanel.add(exClienteImgBtn);
		
		consClienteImgBtn = new JButton("");
		consClienteImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		consClienteImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/ID-Information-128.png")));
		consClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		consClienteImgBtn.setBackground(peterRiver);
		consClienteImgBtn.setBounds(200, 77, 160, 160);
		clientePanel.add(consClienteImgBtn);
		
		consClienteBtn = new JButton("Consultar");
		consClienteBtn.addActionListener(new TEActionMenuPrincipal(this));
		consClienteBtn.setMnemonic(KeyEvent.VK_O);
		consClienteBtn.setForeground(Color.WHITE);
		consClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		consClienteBtn.setBorder(new LineBorder(Color.WHITE));
		consClienteBtn.setBackground(peterRiver);
		consClienteBtn.setBounds(200, 248, 160, 38);
		clientePanel.add(consClienteBtn);
		
		lblCopyrightClientes = new JLabel("Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04");
		lblCopyrightClientes.setForeground(Color.WHITE);
		lblCopyrightClientes.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCopyrightClientes.setBounds(725, 418, 175, 16);
		clientePanel.add(lblCopyrightClientes);
		JPanel funcionarioPanel = new JPanel(); // Cria o painel Funcionários.
		funcionarioPanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Funcionários", new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/User-24.png")),
				          funcionarioPanel, "painel de controle de funcionários");
		
		cadFuncImgBtn = new JButton("");
		cadFuncImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		cadFuncImgBtn.setBounds(20, 77, 160, 160);
		cadFuncImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Employee-Add-128.png")));
		cadFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		cadFuncImgBtn.setBackground(nephritis);
		
		altFuncImgBtn = new JButton("");
		altFuncImgBtn.setBounds(380, 77, 160, 160);
		altFuncImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/User-Refresh-128.png")));
		altFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		altFuncImgBtn.setBackground(nephritis);
		
		exFuncImgBtn = new JButton("");
		exFuncImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		exFuncImgBtn.setBounds(560, 77, 160, 160);
		exFuncImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/close11.png")));
		exFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		exFuncImgBtn.setBackground(pomergante);
		
		relFuncImgBtn = new JButton("");
		relFuncImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		getContentPane().setLayout(null);
		relFuncImgBtn.setBounds(740, 77, 160, 160);
		relFuncImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/User-Monitor-128.png")));
		relFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		relFuncImgBtn.setBackground(nephritis);
		
		cadFuncBtn = new JButton("Cadastrar");
		cadFuncBtn.addActionListener(new TEActionMenuPrincipal(this));
		cadFuncBtn.setMnemonic(KeyEvent.VK_C);
		cadFuncBtn.setBounds(20, 248, 160, 38);
		cadFuncBtn.setForeground(Color.WHITE);
		cadFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cadFuncBtn.setBorder(new LineBorder(Color.WHITE));
		cadFuncBtn.setBackground(nephritis);
		
		altFuncBtn = new JButton("Alterar");
		altFuncBtn.setMnemonic(KeyEvent.VK_A);
		altFuncBtn.setBounds(380, 248, 160, 38);
		altFuncBtn.setForeground(Color.WHITE);
		altFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altFuncBtn.setBorder(new LineBorder(Color.WHITE));
		altFuncBtn.setBackground(nephritis);
		
		relFuncBtn = new JButton("Relatorio");
		relFuncBtn.addActionListener(new TEActionMenuPrincipal(this));
		relFuncBtn.setMnemonic(KeyEvent.VK_R);
		relFuncBtn.setBounds(740, 248, 160, 38);
		relFuncBtn.setForeground(Color.WHITE);
		relFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relFuncBtn.setBorder(new LineBorder(Color.WHITE));
		relFuncBtn.setBackground(nephritis);
		
		exFuncBtn = new JButton("Excluir");
		exFuncBtn.addActionListener(new TEActionMenuPrincipal(this));
		exFuncBtn.setMnemonic(KeyEvent.VK_E);
		exFuncBtn.setBounds(560, 248, 160, 38);
		exFuncBtn.setForeground(Color.WHITE);
		exFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exFuncBtn.setBorder(new LineBorder(Color.WHITE));
		exFuncBtn.setBackground(pomergante);
		funcionarioPanel.setLayout(null);
		funcionarioPanel.add(cadFuncImgBtn);
		funcionarioPanel.add(cadFuncBtn);
		funcionarioPanel.add(altFuncImgBtn);
		funcionarioPanel.add(altFuncBtn);
		funcionarioPanel.add(relFuncImgBtn);
		funcionarioPanel.add(relFuncBtn);
		funcionarioPanel.add(exFuncBtn);
		funcionarioPanel.add(exFuncImgBtn);
		
		consFuncImgBtn = new JButton("");
		consFuncImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		consFuncImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/User-Information-128.png")));
		consFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		consFuncImgBtn.setBackground(nephritis);
		consFuncImgBtn.setBounds(200, 77, 160, 160);
		funcionarioPanel.add(consFuncImgBtn);
		
		consFuncBtn = new JButton("Consultar");
		consFuncBtn.addActionListener(new TEActionMenuPrincipal(this));
		consFuncBtn.setMnemonic(KeyEvent.VK_O);
		consFuncBtn.setForeground(Color.WHITE);
		consFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		consFuncBtn.setBorder(new LineBorder(Color.WHITE));
		consFuncBtn.setBackground(nephritis);
		consFuncBtn.setBounds(200, 248, 160, 38);
		funcionarioPanel.add(consFuncBtn);
		
		lblCopyrightFuncionarios = new JLabel("Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04");
		lblCopyrightFuncionarios.setForeground(Color.WHITE);
		lblCopyrightFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCopyrightFuncionarios.setBounds(725, 418, 175, 16);
		funcionarioPanel.add(lblCopyrightFuncionarios);
		
		JPanel agenciaPanel = new JPanel(); // Cria o painel Agênicas.
		agenciaPanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Agências", new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Building-24.png")),
				          agenciaPanel, "painel de controle de agências");
		agenciaPanel.setLayout(null);
		
		cadAgImgBtn = new JButton("");
		cadAgImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		cadAgImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Building-Add-128.png")));
		cadAgImgBtn.setAlignmentX(0.5f);
		cadAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		cadAgImgBtn.setBackground(pumpkin);
		cadAgImgBtn.setBounds(20, 77, 160, 160);
		agenciaPanel.add(cadAgImgBtn);
		
		altAgImgBtn = new JButton("");
		altAgImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Document-Exchange-01-128.png")));
		altAgImgBtn.setAlignmentX(0.5f);
		altAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		altAgImgBtn.setBackground(pumpkin);
		altAgImgBtn.setBounds(380, 77, 160, 160);
		agenciaPanel.add(altAgImgBtn);
		
		relAgImgBtn = new JButton("");
		relAgImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		relAgImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Document-128.png")));
		relAgImgBtn.setAlignmentX(0.5f);
		relAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		relAgImgBtn.setBackground(pumpkin);
		relAgImgBtn.setBounds(740, 77, 160, 160);
		agenciaPanel.add(relAgImgBtn);
		
		exAgImgBtn = new JButton("");
		exAgImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		exAgImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/close11.png")));
		exAgImgBtn.setAlignmentX(0.5f);
		exAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		exAgImgBtn.setBackground(pomergante);
		exAgImgBtn.setBounds(560, 77, 160, 160);
		agenciaPanel.add(exAgImgBtn);
		
		cadAgBtn = new JButton("Cadastrar");
		cadAgBtn.addActionListener(new TEActionMenuPrincipal(this));
		cadAgBtn.setMnemonic(KeyEvent.VK_C);
		cadAgBtn.setAlignmentX(0.5f);
		cadAgBtn.setForeground(Color.WHITE);
		cadAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cadAgBtn.setBorder(new LineBorder(Color.WHITE));
		cadAgBtn.setBackground(pumpkin);
		cadAgBtn.setBounds(20, 248, 160, 38);
		agenciaPanel.add(cadAgBtn);
		
		altAgBtn = new JButton("Alterar");
		altAgBtn.setMnemonic(KeyEvent.VK_A);
		altAgBtn.setAlignmentX(0.5f);
		altAgBtn.setForeground(Color.WHITE);
		altAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altAgBtn.setBorder(new LineBorder(Color.WHITE));
		altAgBtn.setBackground(pumpkin);
		altAgBtn.setActionCommand("Alterar");
		altAgBtn.setBounds(380, 248, 160, 38);
		agenciaPanel.add(altAgBtn);
		
		relAgBtn = new JButton("Relatorio");
		relAgBtn.addActionListener(new TEActionMenuPrincipal(this));
		relAgBtn.setMnemonic(KeyEvent.VK_R);
		relAgBtn.setAlignmentX(0.5f);
		relAgBtn.setForeground(Color.WHITE);
		relAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relAgBtn.setBorder(new LineBorder(Color.WHITE));
		relAgBtn.setBackground(pumpkin);
		relAgBtn.setBounds(740, 248, 160, 38);
		agenciaPanel.add(relAgBtn);
		
		exAgBtn = new JButton("Excluir");
		exAgBtn.addActionListener(new TEActionMenuPrincipal(this));
		exAgBtn.setMnemonic(KeyEvent.VK_E);
		exAgBtn.setAlignmentX(0.5f);
		exAgBtn.setForeground(Color.WHITE);
		exAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exAgBtn.setBorder(new LineBorder(Color.WHITE));
		exAgBtn.setBackground(pomergante);
		exAgBtn.setBounds(560, 248, 160, 38);
		agenciaPanel.add(exAgBtn);
		
		consAgImgBtn = new JButton("");
		consAgImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		consAgImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Data-Analysis-128.png")));
		consAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		consAgImgBtn.setBackground(pumpkin);
		consAgImgBtn.setBounds(200, 77, 160, 160);
		agenciaPanel.add(consAgImgBtn);
		
		consAgBtn = new JButton("Consultar");
		consAgBtn.addActionListener(new TEActionMenuPrincipal(this));
		consAgBtn.setMnemonic(KeyEvent.VK_O);
		consAgBtn.setForeground(Color.WHITE);
		consAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		consAgBtn.setBorder(new LineBorder(Color.WHITE));
		consAgBtn.setBackground(pumpkin);
		consAgBtn.setBounds(200, 248, 160, 38);
		agenciaPanel.add(consAgBtn);
		
		lblCopyrightAgencias = new JLabel("Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04");
		lblCopyrightAgencias.setForeground(Color.WHITE);
		lblCopyrightAgencias.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCopyrightAgencias.setBounds(725, 418, 175, 16);
		agenciaPanel.add(lblCopyrightAgencias);
		
		JPanel contaPanel = new JPanel(); // Cria o painel Conta.
		contaPanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Contas Bancárias", new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Payment-01-24.png")),
				          contaPanel, "painel de controle de contas bancárias");
		contaPanel.setLayout(null);
		
		abrirContaImgBtn = new JButton("");
		abrirContaImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		abrirContaImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Account-Payable-128.png")));
		abrirContaImgBtn.setBorder(new LineBorder(Color.WHITE));
		abrirContaImgBtn.setBackground(turquoise);
		abrirContaImgBtn.setAlignmentX(0.5f);
		abrirContaImgBtn.setBounds(20, 77, 160, 160);
		contaPanel.add(abrirContaImgBtn);
		
		abrirContaBtn = new JButton("Abrir");
		abrirContaBtn.addActionListener(new TEActionMenuPrincipal(this));
		abrirContaBtn.setMnemonic(KeyEvent.VK_A);
		abrirContaBtn.setForeground(Color.WHITE);
		abrirContaBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		abrirContaBtn.setBorder(new LineBorder(Color.WHITE));
		abrirContaBtn.setBackground(turquoise);
		abrirContaBtn.setAlignmentX(0.5f);
		abrirContaBtn.setBounds(20, 248, 160, 38);
		contaPanel.add(abrirContaBtn);
		
		depositarSalContaImgBtn = new JButton("");
		depositarSalContaImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		depositarSalContaImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Donate -128.png")));
		depositarSalContaImgBtn.setBorder(new LineBorder(Color.WHITE));
		depositarSalContaImgBtn.setBackground(turquoise);
		depositarSalContaImgBtn.setAlignmentX(0.5f);
		depositarSalContaImgBtn.setBounds(200, 77, 160, 160);
		contaPanel.add(depositarSalContaImgBtn);
		
		depositarSalContaBtn = new JButton("Depositar Sal\u00E1rio");
		depositarSalContaBtn.addActionListener(new TEActionMenuPrincipal(this));
		depositarSalContaBtn.setMnemonic(KeyEvent.VK_D);
		depositarSalContaBtn.setForeground(Color.WHITE);
		depositarSalContaBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		depositarSalContaBtn.setBorder(new LineBorder(Color.WHITE));
		depositarSalContaBtn.setBackground(turquoise);
		depositarSalContaBtn.setAlignmentX(0.5f);
		depositarSalContaBtn.setBounds(200, 248, 160, 38);
		contaPanel.add(depositarSalContaBtn);
		
		criarAplicContaImgBtn = new JButton("");
		criarAplicContaImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		criarAplicContaImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Stock-Exchange-128.png")));
		criarAplicContaImgBtn.setBorder(new LineBorder(Color.WHITE));
		criarAplicContaImgBtn.setBackground(turquoise);
		criarAplicContaImgBtn.setAlignmentX(0.5f);
		criarAplicContaImgBtn.setBounds(560, 77, 160, 160);
		contaPanel.add(criarAplicContaImgBtn);
		
		criarAplicContaBtn = new JButton("Criar Aplica\u00E7\u00E3o");
		criarAplicContaBtn.addActionListener(new TEActionMenuPrincipal(this));
		criarAplicContaBtn.setMnemonic(KeyEvent.VK_C);
		criarAplicContaBtn.setForeground(Color.WHITE);
		criarAplicContaBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		criarAplicContaBtn.setBorder(new LineBorder(Color.WHITE));
		criarAplicContaBtn.setBackground(turquoise);
		criarAplicContaBtn.setAlignmentX(0.5f);
		criarAplicContaBtn.setBounds(560, 248, 160, 38);
		contaPanel.add(criarAplicContaBtn);
		
		alterarAplicContaImgBtn = new JButton("");
		alterarAplicContaImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		alterarAplicContaImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Money-Transfer-128.png")));
		alterarAplicContaImgBtn.setBorder(new LineBorder(Color.WHITE));
		alterarAplicContaImgBtn.setBackground(turquoise);
		alterarAplicContaImgBtn.setAlignmentX(0.5f);
		alterarAplicContaImgBtn.setBounds(740, 77, 160, 160);
		contaPanel.add(alterarAplicContaImgBtn);
		
		alterarAplicContaBtn = new JButton("Alterar Aplica\u00E7\u00E3o");
		alterarAplicContaBtn.addActionListener(new TEActionMenuPrincipal(this));
		alterarAplicContaBtn.setMnemonic(KeyEvent.VK_L);
		alterarAplicContaBtn.setForeground(Color.WHITE);
		alterarAplicContaBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		alterarAplicContaBtn.setBorder(new LineBorder(Color.WHITE));
		alterarAplicContaBtn.setBackground(turquoise);
		alterarAplicContaBtn.setAlignmentX(0.5f);
		alterarAplicContaBtn.setBounds(740, 248, 160, 38);
		contaPanel.add(alterarAplicContaBtn);
		
		lblCopyrightContas = new JLabel("Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04");
		lblCopyrightContas.setForeground(Color.WHITE);
		lblCopyrightContas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCopyrightContas.setBounds(725, 418, 175, 16);
		contaPanel.add(lblCopyrightContas);
		JPanel outrosPanel = new JPanel(); // Cria o painel Outros.
		outrosPanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Outros", new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Gear-24.png")),
				          outrosPanel, "painel de outras opções");
		outrosPanel.setLayout(null);
		
		ajudaImgBtn = new JButton("");
		ajudaImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		ajudaImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Help-128.png")));
		ajudaImgBtn.setBorder(new LineBorder(Color.WHITE));
		ajudaImgBtn.setBackground(sunFlower);
		ajudaImgBtn.setAlignmentX(0.5f);
		ajudaImgBtn.setBounds(380, 77, 160, 160);
		outrosPanel.add(ajudaImgBtn);
		
		ajudaBtn = new JButton("Ajuda");
		ajudaBtn.addActionListener(new TEActionMenuPrincipal(this));
		ajudaBtn.setMnemonic(KeyEvent.VK_A);
		ajudaBtn.setForeground(Color.BLACK);
		ajudaBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ajudaBtn.setBorder(new LineBorder(Color.WHITE));
		ajudaBtn.setBackground(sunFlower);
		ajudaBtn.setBounds(380, 248, 160, 38);
		outrosPanel.add(ajudaBtn);
		
		caixaEletronicoImgBtn = new JButton("");
		caixaEletronicoImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/ATM-128.png")));
		caixaEletronicoImgBtn.setBorder(new LineBorder(Color.WHITE));
		caixaEletronicoImgBtn.setBackground(orange);
		caixaEletronicoImgBtn.setAlignmentX(0.5f);
		caixaEletronicoImgBtn.setBounds(560, 77, 160, 160);
		outrosPanel.add(caixaEletronicoImgBtn);
		
		caixaEletronicoBtn = new JButton("Caixa Eletr\u00F4nico");
		caixaEletronicoBtn.setMnemonic(KeyEvent.VK_C);
		caixaEletronicoBtn.setForeground(Color.WHITE);
		caixaEletronicoBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		caixaEletronicoBtn.setBorder(new LineBorder(Color.WHITE));
		caixaEletronicoBtn.setBackground(orange);
		caixaEletronicoBtn.setBounds(560, 248, 160, 38);
		outrosPanel.add(caixaEletronicoBtn);
		
		alterarSenhaImgBtn = new JButton("");
		alterarSenhaImgBtn.addActionListener(new TEActionMenuPrincipal(this));
		alterarSenhaImgBtn.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Key-Access-128.png")));
		alterarSenhaImgBtn.setBorder(new LineBorder(Color.WHITE));
		alterarSenhaImgBtn.setBackground(orange);
		alterarSenhaImgBtn.setAlignmentX(0.5f);
		alterarSenhaImgBtn.setBounds(200, 77, 160, 160);
		outrosPanel.add(alterarSenhaImgBtn);
		
		alterarSenhaBtn = new JButton("Alterar Senha");
		alterarSenhaBtn.addActionListener(new TEActionMenuPrincipal(this));
		alterarSenhaBtn.setMnemonic(KeyEvent.VK_L);
		alterarSenhaBtn.setForeground(Color.WHITE);
		alterarSenhaBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		alterarSenhaBtn.setBorder(new LineBorder(Color.WHITE));
		alterarSenhaBtn.setBackground(orange);
		alterarSenhaBtn.setBounds(200, 248, 160, 38);
		outrosPanel.add(alterarSenhaBtn);
		
		lblCopyrightOutros = new JLabel("Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04");
		lblCopyrightOutros.setForeground(Color.WHITE);
		lblCopyrightOutros.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCopyrightOutros.setBounds(725, 418, 175, 16);
		outrosPanel.add(lblCopyrightOutros);
		
		// adiciona o JTabbedPane ao quadro
		getContentPane().add(tabbedPane); 
		
		lblBanner = new JLabel("");
		lblBanner.addMouseListener(new TEMouseMenuPrincipal(this));
		lblBanner.setDisplayedMnemonic(KeyEvent.VK_HOME);
		lblBanner.setBorder(null);
		lblBanner.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Banner - BVB.png")));
		lblBanner.setBounds(321, 32, 278, 75);
		getContentPane().add(lblBanner);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 920, 21);
		getContentPane().add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic(KeyEvent.VK_Q);
		menuBar.add(mnArquivo);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSair.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Fire-Exit-24.png")));
		mntmSair.addActionListener(new TEActionMenuPrincipal(this));
		
		mntmLimparBD = new JMenuItem("Limpar Banco de Dados");
		mntmLimparBD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmLimparBD.addActionListener(new TEActionMenuPrincipal(this));
		mntmLimparBD.setMnemonic(KeyEvent.VK_L);
		mntmLimparBD.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Data-Delete-24.png")));
		mnArquivo.add(mntmLimparBD);
		
		JSeparator menuArquivoSeparator = new JSeparator();
		mnArquivo.add(menuArquivoSeparator);
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new TEActionMenuPrincipal(this));
		mntmLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmLogout.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Logout-24.png")));
		mntmLogout.setMnemonic(KeyEvent.VK_O);
		mnArquivo.add(mntmLogout);
		mntmSair.setMnemonic(KeyEvent.VK_S);
		mnArquivo.add(mntmSair);
		
		mnAparência = new JMenu("Apar\u00EAncia");
		mnAparência.setMnemonic(KeyEvent.VK_P);
		menuBar.add(mnAparência);
		
		mntmTema = new JMenuItem("Tema");
		mntmTema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmTema.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Black-Board-24.png")));
		mntmTema.addActionListener(new TEActionMenuPrincipal(this));
		mntmTema.setMnemonic(KeyEvent.VK_T);
		mnAparência.add(mntmTema);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setMnemonic(KeyEvent.VK_S);
		menuBar.add(mnSobre);
		
		mntmAutor = new JMenuItem("Autor");
		mntmAutor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mntmAutor.setIcon(new ImageIcon(IgMenuPrincipal.class.getResource("/tsi/too/bvb/recursos/imagens/Graduate-01-24.png")));
		mntmAutor.addActionListener(new TEActionMenuPrincipal(this));
		mntmAutor.setMnemonic(KeyEvent.VK_A);
		mnSobre.add(mntmAutor);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void terminarPrograma() {
		// Encera o banco de dados.
		BancoDeDadosBVB.encerrarBD();
		
		// Libera os recursos.
		IgMenuPrincipal.this.dispose();
		System.exit(0);
	}
	
	public void logout() {
		Applet.newAudioClip(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/sons/Windows Logoff Sound.wav")).play();
		
		// Cria a janela que contém o login.
		new IgLogin();
		
		IgMenuPrincipal.this.dispose();
	}
	
	/// ===== * Início dos Geters dos botões * ===== ///
	public JButton getAltClienteImgBtn() {
		return altClienteImgBtn;
	}

	public JButton getRelClienteImgBtn() {
		return relClienteImgBtn;
	}

	public JButton getExClienteImgBtn() {
		return exClienteImgBtn;
	}

	public JButton getCadClienteBtn() {
		return cadClienteBtn;
	}

	public JButton getAltClienteBtn() {
		return altClienteBtn;
	}

	public JButton getRelClienteBtn() {
		return relClienteBtn;
	}

	public JButton getExClienteBtn() {
		return exClienteBtn;
	}

	public JButton getCadFuncImgBtn() {
		return cadFuncImgBtn;
	}

	public JButton getAltFuncImgBtn() {
		return altFuncImgBtn;
	}

	public JButton getRelFuncImgBtn() {
		return relFuncImgBtn;
	}

	public JButton getExFuncImgBtn() {
		return exFuncImgBtn;
	}

	public JButton getCadFuncBtn() {
		return cadFuncBtn;
	}

	public JButton getAltFuncBtn() {
		return altFuncBtn;
	}

	public JButton getRelFuncBtn() {
		return relFuncBtn;
	}

	public JButton getExFuncBtn() {
		return exFuncBtn;
	}

	public JButton getCadAgImgBtn() {
		return cadAgImgBtn;
	}

	public JButton getAltAgImgBtn() {
		return altAgImgBtn;
	}

	public JButton getRelAgImgBtn() {
		return relAgImgBtn;
	}

	public JButton getExAgImgBtn() {
		return exAgImgBtn;
	}

	public JButton getCadAgBtn() {
		return cadAgBtn;
	}

	public JButton getAltAgBtn() {
		return altAgBtn;
	}

	public JButton getRelAgBtn() {
		return relAgBtn;
	}

	public JButton getExAgBtn() {
		return exAgBtn;
	}

	public JButton getCadClienteImgBtn() {
		return cadClienteImgBtn;
	}

	public JButton getAjudaImgBtn() {
		return ajudaImgBtn;
	}

	public JButton getAjudaBtn() {
		return ajudaBtn;
	}

	public JButton getConsFuncImgBtn() {
		return consFuncImgBtn;
	}

	public JButton getConsFuncBtn() {
		return consFuncBtn;
	}

	public JButton getConsAgImgBtn() {
		return consAgImgBtn;
	}

	public JButton getConsAgBtn() {
		return consAgBtn;
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}

	public JMenuItem getMntmAutor() {
		return mntmAutor;
	}

	public JButton getConsClienteImgBtn() {
		return consClienteImgBtn;
	}

	public JButton getConsClienteBtn() {
		return consClienteBtn;
	}

	public JButton getDepositarSalContaImgBtn() {
		return depositarSalContaImgBtn;
	}

	public JButton getDepositarSalContaBtn() {
		return depositarSalContaBtn;
	}

	public JButton getCriarAplicContaImgBtn() {
		return criarAplicContaImgBtn;
	}

	public JButton getCriarAplicContaBtn() {
		return criarAplicContaBtn;
	}

	public JButton getAlterarAplicContaImgBtn() {
		return alterarAplicContaImgBtn;
	}

	public JButton getAlterarAplicContaBtn() {
		return alterarAplicContaBtn;
	}

	public JButton getAbrirContaImgBtn() {
		return abrirContaImgBtn;
	}

	public JButton getAbrirContaBtn() {
		return abrirContaBtn;
	}

	public JButton getCaixaEletronicoImgBtn() {
		return caixaEletronicoImgBtn;
	}

	public JButton getCaixaEletronicoBtn() {
		return caixaEletronicoBtn;
	}

	public JButton getAlterarSenhaImgBtn() {
		return alterarSenhaImgBtn;
	}

	public JButton getAlterarSenhaBtn() {
		return alterarSenhaBtn;
	}
	/// ===== * Fim dos Geters dos botões * ===== ///
	
	/// ===== * Início dos Geters dos itens da aba Home * ===== ///
	public JLabel getLblImgSeta1() {
		return lblImgSeta1;
	}

	public JLabel getLblImgSeta2() {
		return lblImgSeta2;
	}

	public JLabel getLblImgSeta3() {
		return lblImgSeta3;
	}

	public JLabel getLblImgSeta4() {
		return lblImgSeta4;
	}

	public JLabel getLblImgSeta5() {
		return lblImgSeta5;
	}
	
	public JLabel getLblImgSeta6() {
		return lblImgSeta6;
	}

	public JLabel getLblImgAjuda() {
		return lblImgAjuda;
	}

	public JLabel getLblBanner() {
		return lblBanner;
	}
	/// ===== * Fim dos Geters dos itens da aba Home * ===== ///

	public JMenuItem getMntmLogout() {
		return mntmLogout;
	}

	public JMenuItem getMntmTema() {
		return mntmTema;
	}
	
	public JMenuItem getMntmLimparBD() {
		return mntmLimparBD;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Date getDataInicial() {
		return dataInicial;
	}
	
} // class IgMenuPrincipal