package tsi.too.bvb.gui.menuprincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.eventos.menuprincipal.TEMouseMenuPrincipal;

public class IgMenuPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1271399365713672153L;
	
	private JButton cadastrarClienteButton;
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
	private JLabel lblTituloHome;
	private JButton cadAgImgBtn;
	private JButton altAgImgBtn;
	private JButton relAgImgBtn;
	private JButton exAgImgBtn;
	private JButton cadAgBtn;
	private JButton altAgBtn;
	private JButton relAgBtn;
	private JButton exAgBtn;
	private JButton cadClienteImgBtn;
	private JLabel lblImgBVB;
	private JEditorPane dtrpnTextoHome;
	private JButton ajudaImgBtn;
	private JLabel lblBanner;
	private JButton ajudaBtn;
	private JButton consFuncImgBtn;
	private JButton consFuncBtn;
	private JButton consAgImgBtn;
	private JButton consAgBtn;
	private JMenuItem mntmSair;
	private JMenuItem mntmAutor;
	private JButton consClienteImgBtn;
	private JButton consClienteBtn;

	public IgMenuPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\tsi\\too\\bvb\\recursos\\imagens\\BVB - \u00EDcone.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				terminaPrograma();
			}
		});
		// Cores Flat
		Color peterRiver = new Color(52, 152, 219);
		Color sunFlower = new Color(241, 196, 15);
		Color pomergante = new Color(192, 57, 43);
		Color midnigthBlue = new Color(44, 62, 80);
		Color concrete = new Color(127, 140, 141);
		Color nephritis = new Color(39, 174, 96);
		Color pumpkin = new Color(211, 84, 0);
		
		setTitle(".: BVB :.");
		setDefaultCloseOperation(IgMenuPrincipal.DISPOSE_ON_CLOSE);
		setSize(926, 620);
		setResizable(false);
		getContentPane().setBackground(concrete);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 118, 920, 474);
		tabbedPane.setMinimumSize(new Dimension(15, 15));
		tabbedPane.setPreferredSize(new Dimension(15, 15));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(midnigthBlue);
		
		// Cria o painel Home
		JPanel homePanel = new JPanel(); 
		homePanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Home",null,homePanel,"First Panel");
		homePanel.setLayout(null);
		
		lblTituloHome = new JLabel("Seja Bem Vindo ao BVB - Este é seu painel de administração");
		lblTituloHome.setBounds(0, 11, 915, 26);
		lblTituloHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloHome.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		lblTituloHome.setForeground(Color.WHITE);
		lblTituloHome.setBackground(midnigthBlue);
		homePanel.add(lblTituloHome);
		
		lblImgBVB = new JLabel("bvb");
		lblImgBVB.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Logo02 - BVB.png"));
		lblImgBVB.setBounds(10, 48, 387, 387);
		homePanel.add(lblImgBVB);
		
		dtrpnTextoHome = new JEditorPane();
		dtrpnTextoHome.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BVB", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		dtrpnTextoHome.setText("          BVB - Banco Virtual de Barbacena\r\nEste sistema possibilita o gerenciamento de servi\u00E7os oferecidos nas ag\u00EAncias do banco virtual de barbacena, como o controle de clientes, funcion\u00E1rios, ag\u00EAncias e contas banc\u00E1rias. Para tirar d\u00FAvidas sobre o funcionamento do software, v\u00E1 na aba \"Outros\" e clique no bot\u00E3o de ajuda.");
		dtrpnTextoHome.setEditable(false);
		dtrpnTextoHome.setForeground(Color.WHITE);
		dtrpnTextoHome.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 18));
		dtrpnTextoHome.setBackground(midnigthBlue);
		dtrpnTextoHome.setBounds(520, 138, 385, 218);
		homePanel.add(dtrpnTextoHome);
		JPanel clientePanel = new JPanel(); // cria o primeiro painel
		clientePanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Clientes",null,clientePanel,"First Panel");
		
		cadClienteImgBtn = new JButton("");
		cadClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		cadClienteImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		cadClienteImgBtn.setBounds(20, 77, 160, 160);
		cadClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\User-Add-128.png"));
		cadClienteImgBtn.setBackground(peterRiver);
		
		altClienteImgBtn = new JButton("");
		altClienteImgBtn.setBounds(380, 77, 160, 160);
		altClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\User-Modify-128.png"));
		altClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		altClienteImgBtn.setBackground(peterRiver);
		
		relClienteImgBtn = new JButton("");
		relClienteImgBtn.setBounds(740, 77, 160, 160);
		relClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\File-Format-PDF-128.png"));
		relClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		relClienteImgBtn.setBackground(peterRiver);
		
		exClienteImgBtn = new JButton("");
		exClienteImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		exClienteImgBtn.setBounds(560, 77, 160, 160);
		exClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\close11.png"));
		exClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		exClienteImgBtn.setBackground(pomergante);
		
		cadClienteBtn = new JButton("Cadastrar");
		cadClienteBtn.addActionListener(new TEMouseMenuPrincipal(this));
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
		relClienteBtn.setMnemonic(KeyEvent.VK_R);
		relClienteBtn.setBounds(740, 248, 160, 38);
		relClienteBtn.setForeground(Color.WHITE);
		relClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relClienteBtn.setBorder(new LineBorder(Color.WHITE));
		relClienteBtn.setBackground(peterRiver);
		
		exClienteBtn = new JButton("Excluir");
		exClienteBtn.addActionListener(new TEMouseMenuPrincipal(this));
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
		consClienteImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		consClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\ID-Information-128.png"));
		consClienteImgBtn.setBorder(new LineBorder(Color.WHITE));
		consClienteImgBtn.setBackground(new Color(52, 152, 219));
		consClienteImgBtn.setBounds(200, 77, 160, 160);
		clientePanel.add(consClienteImgBtn);
		
		consClienteBtn = new JButton("Consultar");
		consClienteBtn.addActionListener(new TEMouseMenuPrincipal(this));
		consClienteBtn.setMnemonic(KeyEvent.VK_O);
		consClienteBtn.setForeground(Color.WHITE);
		consClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		consClienteBtn.setBorder(new LineBorder(Color.WHITE));
		consClienteBtn.setBackground(new Color(52, 152, 219));
		consClienteBtn.setBounds(200, 248, 160, 38);
		clientePanel.add(consClienteBtn);
		JPanel funcionarioPanel = new JPanel(); // cria o primeiro painel
		funcionarioPanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Funcionário",null,funcionarioPanel,"Second Panel");
		
		cadFuncImgBtn = new JButton("");
		cadFuncImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		cadFuncImgBtn.setBounds(20, 77, 160, 160);
		cadFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Employee-Add-128.png"));
		cadFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		cadFuncImgBtn.setBackground(nephritis);
		
		altFuncImgBtn = new JButton("");
		altFuncImgBtn.setBounds(380, 77, 160, 160);
		altFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\User-Refresh-128.png"));
		altFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		altFuncImgBtn.setBackground(nephritis);
		
		exFuncImgBtn = new JButton("");
		exFuncImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		exFuncImgBtn.setBounds(560, 77, 160, 160);
		exFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\close11.png"));
		exFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		exFuncImgBtn.setBackground(pomergante);
		
		relFuncImgBtn = new JButton("");
		getContentPane().setLayout(null);
		relFuncImgBtn.setBounds(740, 77, 160, 160);
		relFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\business28.png"));
		relFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		relFuncImgBtn.setBackground(nephritis);
		
		cadFuncBtn = new JButton("Cadastrar");
		cadFuncBtn.addActionListener(new TEMouseMenuPrincipal(this));
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
		relFuncBtn.setMnemonic(KeyEvent.VK_R);
		relFuncBtn.setBounds(740, 248, 160, 38);
		relFuncBtn.setForeground(Color.WHITE);
		relFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relFuncBtn.setBorder(new LineBorder(Color.WHITE));
		relFuncBtn.setBackground(nephritis);
		
		exFuncBtn = new JButton("Excluir");
		exFuncBtn.addActionListener(new TEMouseMenuPrincipal(this));
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
		consFuncImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		consFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\User-Information-128.png"));
		consFuncImgBtn.setBorder(new LineBorder(Color.WHITE));
		consFuncImgBtn.setBackground(nephritis);
		consFuncImgBtn.setBounds(200, 77, 160, 160);
		funcionarioPanel.add(consFuncImgBtn);
		
		consFuncBtn = new JButton("Consultar");
		consFuncBtn.addActionListener(new TEMouseMenuPrincipal(this));
		consFuncBtn.setMnemonic(KeyEvent.VK_O);
		consFuncBtn.setForeground(Color.WHITE);
		consFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		consFuncBtn.setBorder(new LineBorder(Color.WHITE));
		consFuncBtn.setBackground(nephritis);
		consFuncBtn.setBounds(200, 248, 160, 38);
		funcionarioPanel.add(consFuncBtn);
		
		JPanel agenciaPanel = new JPanel();
		agenciaPanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Agência", null, agenciaPanel, null);
		agenciaPanel.setLayout(null);
		
		cadAgImgBtn = new JButton("");
		cadAgImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		cadAgImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Building-Add-128.png"));
		cadAgImgBtn.setAlignmentX(0.5f);
		cadAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		cadAgImgBtn.setBackground(pumpkin);
		cadAgImgBtn.setBounds(20, 77, 160, 160);
		agenciaPanel.add(cadAgImgBtn);
		
		altAgImgBtn = new JButton("");
		altAgImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Document-Exchange-01-128.png"));
		altAgImgBtn.setAlignmentX(0.5f);
		altAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		altAgImgBtn.setBackground(pumpkin);
		altAgImgBtn.setBounds(380, 77, 160, 160);
		agenciaPanel.add(altAgImgBtn);
		
		relAgImgBtn = new JButton("");
		relAgImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Document-128.png"));
		relAgImgBtn.setAlignmentX(0.5f);
		relAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		relAgImgBtn.setBackground(pumpkin);
		relAgImgBtn.setBounds(740, 77, 160, 160);
		agenciaPanel.add(relAgImgBtn);
		
		exAgImgBtn = new JButton("");
		exAgImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		exAgImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\close11.png"));
		exAgImgBtn.setAlignmentX(0.5f);
		exAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		exAgImgBtn.setBackground(pomergante);
		exAgImgBtn.setBounds(560, 77, 160, 160);
		agenciaPanel.add(exAgImgBtn);
		
		cadAgBtn = new JButton("Cadastrar");
		cadAgBtn.addActionListener(new TEMouseMenuPrincipal(this));
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
		relAgBtn.setMnemonic(KeyEvent.VK_R);
		relAgBtn.setAlignmentX(0.5f);
		relAgBtn.setForeground(Color.WHITE);
		relAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relAgBtn.setBorder(new LineBorder(Color.WHITE));
		relAgBtn.setBackground(pumpkin);
		relAgBtn.setBounds(740, 248, 160, 38);
		agenciaPanel.add(relAgBtn);
		
		exAgBtn = new JButton("Excluir");
		exAgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		exAgBtn.setMnemonic(KeyEvent.VK_E);
		exAgBtn.setAlignmentX(0.5f);
		exAgBtn.setForeground(Color.WHITE);
		exAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exAgBtn.setBorder(new LineBorder(Color.WHITE));
		exAgBtn.setBackground(pomergante);
		exAgBtn.setBounds(560, 248, 160, 38);
		agenciaPanel.add(exAgBtn);
		
		consAgImgBtn = new JButton("");
		consAgImgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		consAgImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Data-Analysis-128.png"));
		consAgImgBtn.setBorder(new LineBorder(Color.WHITE));
		consAgImgBtn.setBackground(pumpkin);
		consAgImgBtn.setBounds(200, 77, 160, 160);
		agenciaPanel.add(consAgImgBtn);
		
		consAgBtn = new JButton("Consultar");
		consAgBtn.addActionListener(new TEMouseMenuPrincipal(this));
		consAgBtn.setMnemonic(KeyEvent.VK_O);
		consAgBtn.setForeground(Color.WHITE);
		consAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		consAgBtn.setBorder(new LineBorder(Color.WHITE));
		consAgBtn.setBackground(pumpkin);
		consAgBtn.setBounds(200, 248, 160, 38);
		agenciaPanel.add(consAgBtn);
		JPanel outrosPanel = new JPanel(); // cria o primeiro painel
		outrosPanel.setBackground(midnigthBlue);
		tabbedPane.addTab("Outros",null,outrosPanel,"Third Panel");
		outrosPanel.setLayout(null);
		
		ajudaImgBtn = new JButton("");
		ajudaImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Help-128.png"));
		ajudaImgBtn.setBorder(new LineBorder(Color.WHITE));
		ajudaImgBtn.setBackground(sunFlower);
		ajudaImgBtn.setAlignmentX(0.5f);
		ajudaImgBtn.setBounds(380, 77, 160, 160);
		outrosPanel.add(ajudaImgBtn);
		
		ajudaBtn = new JButton("Ajuda");
		ajudaBtn.setMnemonic(KeyEvent.VK_A);
		ajudaBtn.setForeground(Color.WHITE);
		ajudaBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ajudaBtn.setBorder(new LineBorder(Color.WHITE));
		ajudaBtn.setBackground(sunFlower);
		ajudaBtn.setBounds(380, 248, 160, 38);
		outrosPanel.add(ajudaBtn);
				
		getContentPane().add(tabbedPane); // adiciona o JTabbedPane ao quadro
		
		lblBanner = new JLabel("");
		lblBanner.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Banner - BVB.png"));
		lblBanner.setBounds(275, 32, 250, 75);
		getContentPane().add(lblBanner);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 920, 21);
		getContentPane().add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic(KeyEvent.VK_Q);
		menuBar.add(mnArquivo);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new TEMouseMenuPrincipal(this));
		mntmSair.setMnemonic(KeyEvent.VK_S);
		mnArquivo.add(mntmSair);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setMnemonic(KeyEvent.VK_B);
		menuBar.add(mnSobre);
		
		mntmAutor = new JMenuItem("Autor");
		mntmAutor.addActionListener(new TEMouseMenuPrincipal(this));
		mntmAutor.setMnemonic(KeyEvent.VK_U);
		mnSobre.add(mntmAutor);
		setVisible(true);
	}
	
	public void terminaPrograma() {

	}

	public JButton getCadastrarClienteButton() {
		return cadastrarClienteButton;
	}

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

	public JButton getConsClienteImgBtn() {
		return consClienteImgBtn;
	}

	public JButton getConsClienteBtn() {
		return consClienteBtn;
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

	public void setDtrpnTextoHome(String texto) {
		this.dtrpnTextoHome.setText(texto);
	}
	
} // class IgMenuPrincipal