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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

public class IgBuscarCadastro extends JDialog {

	/**
	 * 
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

	/**
	 * Create the dialog.
	 */
	public IgBuscarCadastro(Window janelaPai, String titulo, String txtTitulo, String txtSubTitulo, final int tipo) {
		setModal(true);
		
		// Cores Flat
		final Color peterRiver = new Color(52, 152, 219);
		final Color nephritis = new Color(39, 174, 96);
		final Color pumpkin = new Color(211, 84, 0);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				carregarElementosTipo(tipo, peterRiver, nephritis, pumpkin);
			}
		});
		
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
		
		setLocation(localPoint);
		setVisible(true);
	}
	
	private void exibeCardPainel(int tipo) {
		switch(tipo) {
		case 1: cardLayout.show(cardPanel, "clientePanel"); break;
		case 2: cardLayout.show(cardPanel, "funcionarioPanel"); break;
		case 3: cardLayout.show(cardPanel, "agenciaPanel"); break;
		}
	}
	
	public void exibeOpcoesAlterarDados(String dados) {
		btnAlterarDados.setEnabled(true);
		btnBuscar.setVisible(false);
		btnAlterar.setVisible(true);
		dadosEditorPane.setText(dados);
	}
	
	public void escondeOpcoesAlterarDados() {
		btnAlterarDados.setEnabled(false);
		btnBuscar.setVisible(true);
		btnAlterar.setVisible(false);
		dadosEditorPane.setText("");
	}
	
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
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public PainelBuscarCliente getPBuscarCliente() {
		return pBuscarCliente;
	}

	public PainelBuscarFuncionario getPBuscarFuncionario() {
		return pBuscarFuncionario;
	}

	public Point getPoint() {
		return point;
	}

	public PainelBuscarAgencia getPBuscarAgencia() {
		return pBuscarAgencia;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public JButton getBtnAlterarDados() {
		return btnAlterarDados;
	}

	public int getNUM_CARDS() {
		return NUM_CARDS;
	}
	
} // class IgBuscarCadastro
