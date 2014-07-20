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

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.eventos.contabancaria.TEActionAbrirCB;
import tsi.too.bvb.gui.PainelConfCad;
import tsi.too.bvb.gui.TratadorDeCampos;

/** Classe que define a GUI de abertura de conta bancária do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgAbrirContaBancaria extends JDialog {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 6372789872654518383L;

	private CardLayout cardLayout= new CardLayout();
	
	private JPanel contentPane = new JPanel();
	private JPanel cardPanel = new JPanel();
	private final int NUM_CARDS = 4;
	private String radioBtnContaCorrenteTxt = "Conta Corrente",
			       radioBtnContaPoupancaTxt = "Conta Poupan\u00E7a";
	
	private PainelAbContaDadosChave pAbContaDadosChave = new PainelAbContaDadosChave(radioBtnContaCorrenteTxt, radioBtnContaPoupancaTxt);
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
	private JSeparator separator;

	/** Cria uma instância da janela de abertura de conta bancária do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgAbrirContaBancaria</code>
	 * @param contaBancaria <code>ContaBancaria</code> referênte ao objeto onde os dados serão salvos
	 * 
	 * @see Window
	 * @see ContaBancaria
	 */	
	public IgAbrirContaBancaria(Window janelaPai, ContaBancaria contaBancaria) {
		setModal(true);
		Color turquoise = new Color(26, 188, 156);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Abertura de Conta Banc\u00E1ria");
		setBounds(100, 100, 523, 506);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(turquoise);
		txtpnSubTitulo.setText("Insira os dados chave da nova conta banc\u00E1ria.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 290, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
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
		btnAnterior.addActionListener(new TEActionAbrirCB(this, contaBancaria));
		btnAnterior.setVisible(false);
		btnAnterior.setMnemonic(KeyEvent.VK_A);
		Btnpanel.add(btnAnterior);
		
		btnProximo = new JButton("Pr\u00F3ximo >");
		btnProximo.addActionListener(new TEActionAbrirCB(this, contaBancaria));
		btnProximo.setMnemonic(KeyEvent.VK_P);
		Btnpanel.add(btnProximo);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new TEActionAbrirCB(this, contaBancaria));
		btnFinalizar.setVisible(false);
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new TEActionAbrirCB(this, contaBancaria));
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
		lblProgressoDaAbertura.setDisplayedMnemonic(KeyEvent.VK_G);
		lblProgressoDaAbertura.setBounds(20, 403, 140, 14);
		contentPane.add(lblProgressoDaAbertura);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(turquoise);
		lblProgressoDaAbertura.setLabelFor(progressBar);
		progressBar.setStringPainted(true);
		progressBar.setBounds(178, 403, 238, 14);
		contentPane.add(progressBar);
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setBounds(10, 368, 497, 14);
		contentPane.add(lblCamposErrados);
		
		separator = new JSeparator();
		separator.setBounds(0, 394, 517, 2);
		contentPane.add(separator);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	/** Verifica qual painel do painel de "cartas" está visível
	 *  @return <code>TratadorDeCampos</code> com o painel visível ou <code>null</code> caso nem um esteja visível
	 *  
	 *  @see TratadorDeCampos
	 */
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

	/** Retorna um <code>CardLayout</code> com layout utilizado no painel de "cartas"
	 * @return <code>CardLayout</code> com layout utilizado no painel de "cartas"
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	
	/** Retorna um <code>JButton</code> com o botão anterior
	 * @return <code>JButton</code> com o botão anterior
	 */
	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	/** Retorna um <code>JButton</code> com o botão próximo
	 * @return <code>JButton</code> com o botão próximo
	 */
	public JButton getBtnProximo() {
		return btnProximo;
	}

	/** Retorna um <code>JButton</code> com o botão limpar
	 * @return <code>JButton</code> com o botão limpar
	 */
	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	/** Retorna um <code>JButton</code> com o botão finalizar
	 * @return <code>JButton</code> com o botão finalizar
	 */
	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}
	
	/** Retorna um <code>JPanel</code> com o painel de "cartas"
	 * @return <code>JPanel</code> com o painel de "cartas"
	 */
	public JPanel getCardPanel() {
		return cardPanel;
	}

	/** Retorna um <code>PainelAbContaDadosChave</code> referênte ao painel dos dados chave
	 * @return <code>PainelAbContaDadosChave</code> referênte ao painel dos dados chave
	 */
	public PainelAbContaDadosChave getpAbContaDadosChave() {
		return pAbContaDadosChave;
	}

	/** Retorna um <code>PainelAbContaDadosChave</code> referênte ao painel dos dados secundários
	 * @return <code>PainelAbContaDadosChave</code> referênte ao painel dos dados secundários
	 */
	public PainelAbContaDadosSec getpAbContaDadosSec() {
		return pAbContaDadosSec;
	}

	/** Retorna um <code>PainelAbContaDadosChave</code> referênte ao painel das senhas
	 * @return <code>PainelAbContaDadosChave</code> referênte ao painel das senhas
	 */
	public PainelAbContaSenhas getpAbContaSenhas() {
		return pAbContaSenhas;
	}

	/** Retorna um <code>PainelConfCad</code> referênte ao painel de confirmação
	 * @return <code>PainelConfCad</code> referênte ao painel de confirmação
	 */
	public PainelConfCad getpConfCad() {
		return pConfCad;
	}

	/** Muda o campo de texto do subtítulo
	 * @param subTitulo <code>String</code> com o novo subtítulo do campo
	 */
	public void setTxtpnSubTitulo(String subTitulo) {
		this.txtpnSubTitulo.setText(subTitulo);
	}

	/** Muda o valor da barra de progresso
	 * @param valor <code>int</code> com o novo valor da barra de progresso
	 */
	public void setProgressBar(int valor) {
		this.progressBar.setValue(valor);
	}
	
	/** Retorna um <code>int</code> com o número de "cartas" do painel
	 * @return <code>int</code> com o número de "cartas" do painel
	 */
	public int getNUM_CARDS() {
		return NUM_CARDS;
	}
	
	/** Muda a visibilidade do rótulo que indica que algum campo não foi corretamente preenchido
	 * @param visivel <code>boolean</code> com <code>true</code> se for visível e <code>false</code> caso contrário
	 */
	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}
} // class IgAbrirContaBancaria
