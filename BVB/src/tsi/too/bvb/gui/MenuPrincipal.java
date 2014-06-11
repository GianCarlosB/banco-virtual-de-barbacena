package tsi.too.bvb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import tsi.too.bvb.eventos.TEMouseMenuPrincipal;
import tsi.too.bvb.eventos.agencia.TEMouseCadastrarAgencia;

public class MenuPrincipal extends JFrame {
	
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

	public MenuPrincipal() {
		setTitle(".: BVB :.");
		setDefaultCloseOperation(MenuPrincipal.DISPOSE_ON_CLOSE);
		setSize(800, 620);
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
	
		// Cores Flat
		Color peterRiver = new Color(52, 152, 219);
		Color sunFlower = new Color(241, 196, 15);
		Color pomergante = new Color(192, 57, 43);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 794, 592);
		tabbedPane.setMinimumSize(new Dimension(15, 15));
		tabbedPane.setPreferredSize(new Dimension(15, 15));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(peterRiver);
		
		// Cria o painel Home
		JPanel homePanel = new JPanel(); 
		homePanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Home",null,homePanel,"First Panel");
		homePanel.setLayout(null);
		
		lblTituloHome = new JLabel("Seja Bem Vindo ao BVB - Este é seu painel de administração");
		lblTituloHome.setBounds(0, 11, 789, 26);
		lblTituloHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloHome.setFont(new Font("Swis721 WGL4 BT", Font.BOLD, 20));
		lblTituloHome.setForeground(Color.WHITE);
		lblTituloHome.setBackground(Color.DARK_GRAY);
		homePanel.add(lblTituloHome);
		
		lblImgBVB = new JLabel("Img");
		lblImgBVB.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Logo2 - BVB.png"));
		lblImgBVB.setBounds(10, 53, 500, 500);
		homePanel.add(lblImgBVB);
		
		dtrpnTextoHome = new JEditorPane();
		dtrpnTextoHome.setText("- Texto sobre o Trabalho Aqui -");
		dtrpnTextoHome.setEditable(false);
		dtrpnTextoHome.setForeground(Color.WHITE);
		dtrpnTextoHome.setFont(new Font("Swis721 WGL4 BT", Font.PLAIN, 18));
		dtrpnTextoHome.setBackground(Color.DARK_GRAY);
		dtrpnTextoHome.setBounds(520, 138, 259, 250);
		homePanel.add(dtrpnTextoHome);
		JPanel clientePanel = new JPanel(); // cria o primeiro painel
		clientePanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Clientes",null,clientePanel,"First Panel");
		

		
		
		cadClienteImgBtn = new JButton("");
		cadClienteImgBtn.addMouseListener(new TEMouseMenuPrincipal(this));
		cadClienteImgBtn.setBounds(30, 30, 160, 160);
		cadClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\create1.png"));
		cadClienteImgBtn.setBorder(null);
		cadClienteImgBtn.setBackground(peterRiver);
		
		altClienteImgBtn = new JButton("");
		altClienteImgBtn.setBounds(220, 30, 160, 160);
		altClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\shuffle10.png"));
		altClienteImgBtn.setBorder(null);
		altClienteImgBtn.setBackground(peterRiver);
		
		relClienteImgBtn = new JButton("");
		relClienteImgBtn.setBounds(410, 30, 160, 160);
		relClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\seo2.png"));
		relClienteImgBtn.setBorder(null);
		relClienteImgBtn.setBackground(peterRiver);
		
		exClienteImgBtn = new JButton("");
		exClienteImgBtn.setBounds(600, 30, 160, 160);
		exClienteImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\close11.png"));
		exClienteImgBtn.setBorder(null);
		exClienteImgBtn.setBackground(pomergante);
		
		cadClienteBtn = new JButton("Cadastrar");
		cadClienteBtn.addMouseListener(new TEMouseMenuPrincipal(this));
		cadClienteBtn.setMnemonic(KeyEvent.VK_C);
		cadClienteBtn.setBounds(30, 201, 160, 38);
		cadClienteBtn.setBorder(new LineBorder(Color.WHITE));
		cadClienteBtn.setForeground(Color.WHITE);
		cadClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cadClienteBtn.setBackground(peterRiver);
		
		altClienteBtn = new JButton("Alterar");
		altClienteBtn.setMnemonic(KeyEvent.VK_A);
		altClienteBtn.setBounds(220, 201, 160, 38);
		altClienteBtn.setActionCommand("Alterar");
		altClienteBtn.setForeground(Color.WHITE);
		altClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altClienteBtn.setBorder(new LineBorder(Color.WHITE));
		altClienteBtn.setBackground(peterRiver);
		
		relClienteBtn = new JButton("Relatorio");
		relClienteBtn.setMnemonic(KeyEvent.VK_R);
		relClienteBtn.setBounds(410, 201, 160, 38);
		relClienteBtn.setForeground(Color.WHITE);
		relClienteBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relClienteBtn.setBorder(new LineBorder(Color.WHITE));
		relClienteBtn.setBackground(peterRiver);
		
		exClienteBtn = new JButton("Excluir");
		exClienteBtn.setMnemonic(KeyEvent.VK_E);
		exClienteBtn.setBounds(600, 201, 160, 38);
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
		JPanel funcionarioPanel = new JPanel(); // cria o primeiro painel
		funcionarioPanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Funcionário",null,funcionarioPanel,"Second Panel");
		
		cadFuncImgBtn = new JButton("");
		cadFuncImgBtn.setBounds(30, 30, 160, 160);
		cadFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\user62.png"));
		cadFuncImgBtn.setBorder(null);
		cadFuncImgBtn.setBackground(peterRiver);
		
		altFuncImgBtn = new JButton("");
		altFuncImgBtn.setBounds(220, 30, 160, 160);
		altFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\settings.png"));
		altFuncImgBtn.setBorder(null);
		altFuncImgBtn.setBackground(peterRiver);
		
		exFuncImgBtn = new JButton("");
		exFuncImgBtn.setBounds(600, 30, 160, 160);
		exFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\close11.png"));
		exFuncImgBtn.setBorder(null);
		exFuncImgBtn.setBackground(pomergante);
		
		relFuncImgBtn = new JButton("");
		relFuncImgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().setLayout(null);
		relFuncImgBtn.setBounds(410, 30, 160, 160);
		relFuncImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\business28.png"));
		relFuncImgBtn.setBorder(null);
		relFuncImgBtn.setBackground(peterRiver);
		
		cadFuncBtn = new JButton("Cadastrar");
		cadFuncBtn.setMnemonic(KeyEvent.VK_C);
		cadFuncBtn.setBounds(30, 201, 160, 38);
		cadFuncBtn.setForeground(Color.WHITE);
		cadFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cadFuncBtn.setBorder(new LineBorder(Color.WHITE));
		cadFuncBtn.setBackground(peterRiver);
		
		altFuncBtn = new JButton("Alterar");
		altFuncBtn.setMnemonic(KeyEvent.VK_A);
		altFuncBtn.setBounds(220, 201, 160, 38);
		altFuncBtn.setForeground(Color.WHITE);
		altFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altFuncBtn.setBorder(new LineBorder(Color.WHITE));
		altFuncBtn.setBackground(peterRiver);
		
		relFuncBtn = new JButton("Relatorio");
		relFuncBtn.setMnemonic(KeyEvent.VK_R);
		relFuncBtn.setBounds(410, 201, 160, 38);
		relFuncBtn.setForeground(Color.WHITE);
		relFuncBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relFuncBtn.setBorder(new LineBorder(Color.WHITE));
		relFuncBtn.setBackground(peterRiver);
		
		exFuncBtn = new JButton("Excluir");
		exFuncBtn.setMnemonic(KeyEvent.VK_E);
		exFuncBtn.setBounds(600, 201, 160, 38);
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
		
		JPanel agenciaPanel = new JPanel();
		agenciaPanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Agência", null, agenciaPanel, null);
		agenciaPanel.setLayout(null);
		
		cadAgImgBtn = new JButton("");
		cadAgImgBtn.setAlignmentX(0.5f);
		cadAgImgBtn.setBorder(null);
		cadAgImgBtn.setBackground(peterRiver);
		cadAgImgBtn.setBounds(30, 30, 160, 160);
		agenciaPanel.add(cadAgImgBtn);
		
		altAgImgBtn = new JButton("");
		altAgImgBtn.setAlignmentX(0.5f);
		altAgImgBtn.setBorder(null);
		altAgImgBtn.setBackground(peterRiver);
		altAgImgBtn.setBounds(220, 30, 160, 160);
		agenciaPanel.add(altAgImgBtn);
		
		relAgImgBtn = new JButton("");
		relAgImgBtn.setAlignmentX(0.5f);
		relAgImgBtn.setBorder(null);
		relAgImgBtn.setBackground(peterRiver);
		relAgImgBtn.setBounds(410, 30, 160, 160);
		agenciaPanel.add(relAgImgBtn);
		
		exAgImgBtn = new JButton("");
		exAgImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\close11.png"));
		exAgImgBtn.setAlignmentX(0.5f);
		exAgImgBtn.setBorder(null);
		exAgImgBtn.setBackground(pomergante);
		exAgImgBtn.setBounds(600, 30, 160, 160);
		agenciaPanel.add(exAgImgBtn);
		
		cadAgBtn = new JButton("Cadastrar");
		cadAgBtn.setMnemonic(KeyEvent.VK_C);
		cadAgBtn.setAlignmentX(0.5f);
		cadAgBtn.setForeground(Color.WHITE);
		cadAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cadAgBtn.setBorder(new LineBorder(Color.WHITE));
		cadAgBtn.setBackground(peterRiver);
		cadAgBtn.setBounds(30, 201, 160, 38);
		agenciaPanel.add(cadAgBtn);
		
		altAgBtn = new JButton("Alterar");
		altAgBtn.setMnemonic(KeyEvent.VK_A);
		altAgBtn.setAlignmentX(0.5f);
		altAgBtn.setForeground(Color.WHITE);
		altAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		altAgBtn.setBorder(new LineBorder(Color.WHITE));
		altAgBtn.setBackground(peterRiver);
		altAgBtn.setActionCommand("Alterar");
		altAgBtn.setBounds(220, 201, 160, 38);
		agenciaPanel.add(altAgBtn);
		
		relAgBtn = new JButton("Relatorio");
		relAgBtn.setMnemonic(KeyEvent.VK_R);
		relAgBtn.setAlignmentX(0.5f);
		relAgBtn.setForeground(Color.WHITE);
		relAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		relAgBtn.setBorder(new LineBorder(Color.WHITE));
		relAgBtn.setBackground(peterRiver);
		relAgBtn.setBounds(410, 201, 160, 38);
		agenciaPanel.add(relAgBtn);
		
		exAgBtn = new JButton("Excluir");
		exAgBtn.setMnemonic(KeyEvent.VK_E);
		exAgBtn.setAlignmentX(0.5f);
		exAgBtn.setForeground(Color.WHITE);
		exAgBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		exAgBtn.setBorder(new LineBorder(Color.WHITE));
		exAgBtn.setBackground(pomergante);
		exAgBtn.setBounds(600, 201, 160, 38);
		agenciaPanel.add(exAgBtn);
		JPanel outrosPanel = new JPanel(); // cria o primeiro painel
		outrosPanel.setBackground(Color.DARK_GRAY);
		tabbedPane.addTab("Outros",null,outrosPanel,"Third Panel");
		outrosPanel.setLayout(null);
		
		ajudaImgBtn = new JButton("");
		ajudaImgBtn.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\help.png"));
		ajudaImgBtn.setBorder(null);
		ajudaImgBtn.setBackground(sunFlower);
		ajudaImgBtn.setAlignmentX(0.5f);
		ajudaImgBtn.setBounds(320, 30, 160, 160);
		outrosPanel.add(ajudaImgBtn);
				
		getContentPane().add(tabbedPane); // adiciona o JTabbedPane ao quadro
		setVisible(true);
	}

	public JLabel getLblTituloHome() {
		return lblTituloHome;
	}

	public void setLblTituloHome(String titulo) {
		this.lblTituloHome.setText(titulo);
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

	public JEditorPane getDtrpnTextoHome() {
		return dtrpnTextoHome;
	}

	public void setDtrpnTextoHome(String texto) {
		this.dtrpnTextoHome.setText(texto);
	}
} // class MenuPrincipal