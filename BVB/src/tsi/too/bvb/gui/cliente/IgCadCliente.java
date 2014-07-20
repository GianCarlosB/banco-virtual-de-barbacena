package tsi.too.bvb.gui.cliente;

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
import tsi.too.bvb.eventos.cliente.TEActionCadastrarCliente;
import tsi.too.bvb.gui.PainelConfCad;
import tsi.too.bvb.gui.TratadorDeCampos;

/** Classe que define a GUI de cadastro de cliente do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgCadCliente extends JDialog {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = -4813322970092459329L;
	
	private CardLayout cardLayout= new CardLayout();
	
	private JPanel contentPane = new JPanel();
	private JPanel cardPanel = new JPanel();
	private final int NUM_CARDS = 4;
	
	private PainelCadCliente pCadCliente = new PainelCadCliente();
	private PainelCadEndereco pCadEndereco = new PainelCadEndereco();
	private PainelCadContato pCadContato = new PainelCadContato();
	private PainelConfCad pConfCad = new PainelConfCad("Dados do Cliente");
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JButton btnFinalizar;
	private JTextPane txtpnSubTitulo;
	private JProgressBar progressBar;
	private JLabel lblCamposErrados;

	/** Cria uma instância da janela de cadastro de cliente do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgCadCliente</code>
	 * @param cliente <code>Cliente</code> referênte ao objeto onde os dados serão salvos
	 * 
	 * @see Window
	 * @see Cliente
	 */	
	public IgCadCliente(Window janelaPai, Cliente cliente) {
		setModal(true);
		Color peterRiver = new Color(52, 152, 219);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Cadastro de Cliente");
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
		txtpnSubTitulo.setBackground(peterRiver);
		txtpnSubTitulo.setText("Insira o nome e o CPF do novo cliente.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 260, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(peterRiver);
		txtpnTitulo.setText("Cadastro de Cliente");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPane.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblImg.setIcon(new ImageIcon(IgCadCliente.class.getResource("/tsi/too/bvb/recursos/imagens/User-Login-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnAnterior = new JButton("< Anterior");
		btnAnterior.addActionListener(new TEActionCadastrarCliente(this, cliente));
		btnAnterior.setVisible(false);
		btnAnterior.setMnemonic(KeyEvent.VK_A);
		Btnpanel.add(btnAnterior);
		
		btnProximo = new JButton("Pr\u00F3ximo >");
		btnProximo.addActionListener(new TEActionCadastrarCliente(this, cliente));
		btnProximo.setMnemonic(KeyEvent.VK_P);
		Btnpanel.add(btnProximo);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new TEActionCadastrarCliente(this, cliente));
		btnFinalizar.setVisible(false);
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new TEActionCadastrarCliente(this, cliente));
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
		dtrpnCampoTitulo.setBackground(peterRiver);
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
		cardPanel.add(pConfCad, "confClientePanel");
		cardLayout.show(cardPanel, "clientePanel");
		
		JLabel label = new JLabel("Progresso do Cadastro:");
		label.setDisplayedMnemonic(KeyEvent.VK_R);
		label.setBounds(20, 403, 140, 14);
		contentPane.add(label);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(178, 403, 238, 14);
		contentPane.add(progressBar);
		progressBar.setForeground(peterRiver);
		label.setLabelFor(progressBar);
		progressBar.setStringPainted(true);
		
		JSeparator separatorPB = new JSeparator();
		separatorPB.setBounds(0, 394, 517, 2);
		contentPane.add(separatorPB);
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setBounds(10, 368, 497, 14);
		contentPane.add(lblCamposErrados);
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		
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
			return pCadCliente;
		if(paineis[i++].isVisible())
			return pCadEndereco;
		if(paineis[i++].isVisible())
			return pCadContato;
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

	/** Retorna um <code>PainelCadCliente</code> referênte ao painel do cliente
	 * @return <code>PainelCadCliente</code> referênte ao painel do cliente
	 */
	public PainelCadCliente getpCadCliente() {
		return pCadCliente;
	}

	/** Retorna um <code>PainelCadEndereco</code> referênte ao painel do endereço
	 * @return <code>PainelCadEndereco</code> referênte ao painel do endereço
	 */
	public PainelCadEndereco getpCadEndereco() {
		return pCadEndereco;
	}

	/** Retorna um <code>PainelCadContato</code> referênte ao painel do contato
	 * @return <code>PainelCadContato</code> referênte ao painel do contato
	 */
	public PainelCadContato getpCadContato() {
		return pCadContato;
	}

	/** Retorna um <code>PainelConfCad</code> referênte ao painel de confirmação
	 * @return <code>PainelConfCad</code> referênte ao painel de confirmação
	 */
	public PainelConfCad getpConfCad() {
		return pConfCad;
	}

	/** Retorna um <code>JPanel</code> com o painel de "cartas"
	 * @return <code>JPanel</code> com o painel de "cartas"
	 */
	public JPanel getCardPanel() {
		return cardPanel;
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

	/** Retorna um <code>JButton</code> com o botão finalizar
	 * @return <code>JButton</code> com o botão finalizar
	 */
	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	/** Retorna um <code>JButton</code> com o botão limpar
	 * @return <code>JButton</code> com o botão limpar
	 */
	public JButton getBtnLimpar() {
		return btnLimpar;
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
	
} // class IgPrincipalCadCliente
