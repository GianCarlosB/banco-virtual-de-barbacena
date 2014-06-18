package tsi.too.bvb.gui.contabancaria;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.gui.PainelConfCad;
import tsi.too.bvb.gui.TratadorDeCampos;

public class IgAbrirContaBancaria extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6372789872654518383L;

	private CardLayout cardLayout= new CardLayout();
	
	private JPanel contentPane = new JPanel();
	private JPanel cardPanel = new JPanel();
	private final int NUM_CARDS = 4;
	
	private PainelAbContaDadosChave pAbContaDadosChave = new PainelAbContaDadosChave();
	private PainelAbContaDadosSec pAbContaDadosSec = new PainelAbContaDadosSec();
	private PainelAbContaSenhas pAbContaSenhas = new PainelAbContaSenhas();
	private PainelConfCad pConfCad = new PainelConfCad("Dados da Conta");
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private JTextPane txtpnSubTitulo;
	private JProgressBar progressBar;
	private JLabel lblCamposErrados;

	/**
	 * Create the frame.
	 */
	public IgAbrirContaBancaria(Window janelaPai, Cliente cliente) {
		setModal(true);
		Color turquoise = new Color(26, 188, 156);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Abrir Conta Banc\u00E1ria");
		setBounds(100, 100, 523, 506);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(turquoise);
		txtpnSubTitulo.setText("Insira os dados chave da nova conta banc\u00E1ria.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 290, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(turquoise);
		txtpnTitulo.setText("Abertura de Conta Banc\u00E1ria");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 270, 22);
		contentPane.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblImg.setIcon(new ImageIcon(IgAbrirContaBancaria.class.getResource("/tsi/too/bvb/recursos/imagens/Payment-01-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnAnterior = new JButton("< Anterior");
		btnAnterior.setVisible(false);
		btnAnterior.setMnemonic(KeyEvent.VK_A);
		Btnpanel.add(btnAnterior);
		
		btnProximo = new JButton("Pr\u00F3ximo >");
		btnProximo.setMnemonic(KeyEvent.VK_P);
		Btnpanel.add(btnProximo);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setVisible(false);
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		Btnpanel.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgAbrirContaBancaria.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		Btnpanel.add(btnCancelar);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(turquoise);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		contentPane.add(separatorBtn);

		cardPanel.setBounds(0, 70, 517, 296);
		contentPane.add(cardPanel);
		cardPanel.setLayout(cardLayout);
		cardPanel.add(pAbContaDadosChave, "dadosChavePanel");
		cardPanel.add(pAbContaDadosSec, "dadosSecundarioPanel");
		cardPanel.add(pAbContaSenhas, "senhasPanel");
		cardPanel.add(pConfCad, "confCadPanel");
		cardLayout.show(cardPanel, "dadosChavePanel");
		
		JLabel lblProgressoDaAbertura = new JLabel("Progresso da Abertura:");
		lblProgressoDaAbertura.setDisplayedMnemonic(KeyEvent.VK_R);
		lblProgressoDaAbertura.setBounds(20, 402, 140, 14);
		contentPane.add(lblProgressoDaAbertura);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(turquoise);
		lblProgressoDaAbertura.setLabelFor(progressBar);
		progressBar.setValue(25);
		progressBar.setStringPainted(true);
		progressBar.setBounds(170, 402, 238, 14);
		contentPane.add(progressBar);
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setBounds(10, 377, 497, 14);
		contentPane.add(lblCamposErrados);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	public TratadorDeCampos obterPainelVisivel() {
		int i = 0;
		Component paineis[] = cardPanel.getComponents();
		
		if(paineis[i++].isVisible())
			return pAbContaDadosChave;
		if(paineis[i++].isVisible())
			return pAbContaDadosSec;
		if(paineis[i++].isVisible())
			return pAbContaSenhas;
		if(paineis[i++].isVisible())
			return pConfCad;
		
		return null;
	}

	public int getNUM_CARDS() {
		return NUM_CARDS;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public JButton getBtnProximo() {
		return btnProximo;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}
	
} // class IgAbrirContaBancaria
