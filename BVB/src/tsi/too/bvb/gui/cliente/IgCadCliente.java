package tsi.too.bvb.gui.cliente;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.cliente.Contato;
import tsi.too.bvb.entidades.cliente.Endereco;
import tsi.too.bvb.eventos.cliente.TEMouseCadastrarCliente;
import java.awt.Color;

public class IgCadCliente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4813322970092459329L;
	
	private CardLayout cardLayout= new CardLayout();
	
	private JPanel contentPane = new JPanel();
	private JPanel cardPanel = new JPanel();
	private final int NUM_CARDS = 4;
	
	private PainelCadCliente pCadCliente = new PainelCadCliente();
	private PainelCadEndereco pCadEndereco = new PainelCadEndereco();
	private PainelCadContato pCadContato = new PainelCadContato();
	private PainelConfCadCliente pConfCadCliente = new PainelConfCadCliente();
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private JTextPane txtpnSubTitulo;
	private JProgressBar progressBar;
	private JLabel lblCamposErrados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new IgCadCliente(new Cliente(new Contato(), new Endereco()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IgCadCliente(Cliente cliente) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Novo Cadastro de Cliente");
		setBounds(100, 100, 523, 506);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setText("Insira o nome e o CPF do novo cliente.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnSubTitulo.setBounds(20, 36, 192, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setText("Cadastro de Cliente");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPane.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\user_add.png"));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnAnterior = new JButton("< Anterior");
		btnAnterior.addMouseListener(new TEMouseCadastrarCliente(this, cliente));
		btnAnterior.setVisible(false);
		btnAnterior.setMnemonic(KeyEvent.VK_A);
		Btnpanel.add(btnAnterior);
		
		btnProximo = new JButton("Pr\u00F3ximo >");
		btnProximo.addMouseListener(new TEMouseCadastrarCliente(this, cliente));
		btnProximo.setMnemonic(KeyEvent.VK_P);
		Btnpanel.add(btnProximo);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addMouseListener(new TEMouseCadastrarCliente(this, cliente));
		btnFinalizar.setVisible(false);
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new TEMouseCadastrarCliente(this, cliente));
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		Btnpanel.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgCadCliente.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		Btnpanel.add(btnCancelar);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		contentPane.add(separatorBtn);

		cardPanel.setBounds(0, 70, 517, 296);
		contentPane.add(cardPanel);
		cardPanel.setLayout(cardLayout);
		cardPanel.add(pCadCliente, "clientePanel");
		cardPanel.add(pCadEndereco, "enderecoPanel");
		cardPanel.add(pCadContato, "contatoPanel");
		cardPanel.add(pConfCadCliente, "confClientePanel");
		cardLayout.show(cardPanel, "clientePanel");
		
		JLabel label = new JLabel("Progresso do Cadastro:");
		label.setDisplayedMnemonic(KeyEvent.VK_R);
		label.setBounds(20, 402, 140, 14);
		contentPane.add(label);
		
		progressBar = new JProgressBar();
		label.setLabelFor(progressBar);
		progressBar.setValue(25);
		progressBar.setStringPainted(true);
		progressBar.setBounds(170, 402, 238, 14);
		contentPane.add(progressBar);
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setBounds(10, 377, 497, 14);
		contentPane.add(lblCamposErrados);
		
		setVisible(true);
	}
	
	public PainelCliente obterPainelVisivel() {
		int i = 0;
		Component paineis[] = cardPanel.getComponents();
		
		if(paineis[i++].isVisible() == true)
			return pCadCliente;
		if(paineis[i++].isVisible() == true)
			return pCadEndereco;
		if(paineis[i++].isVisible() == true)
			return pCadContato;
		if(paineis[i++].isVisible() == true)
			return pConfCadCliente;
		
		return null;
	}

	public PainelCadCliente getpCadCliente() {
		return pCadCliente;
	}

	public PainelCadEndereco getpCadEndereco() {
		return pCadEndereco;
	}

	public PainelCadContato getpCadContato() {
		return pCadContato;
	}

	public PainelConfCadCliente getpConfCadCliente() {
		return pConfCadCliente;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public JButton getBtnProximo() {
		return btnProximo;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void setTxtpnSubTitulo(String subTitulo) {
		this.txtpnSubTitulo.setText(subTitulo);
	}

	public void setProgressBar(int valor) {
		this.progressBar.setValue(valor);
	}

	public int getNUM_CARDS() {
		return NUM_CARDS;
	}

	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}
	
} // class IgPrincipalCadCliente
