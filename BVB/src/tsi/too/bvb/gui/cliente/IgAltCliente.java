package tsi.too.bvb.gui.cliente;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.eventos.cliente.TEActionAlterarCliente;
import tsi.too.bvb.gui.TratadorDeCampos;

/** Classe que define a GUI de alteração de cliente do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgAltCliente extends JDialog {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = -4813322970092459329L;
	
	private Cliente cliente;
	
	private CardLayout cardLayout= new CardLayout();
	
	private JPanel contentPane = new JPanel();
	private JPanel cardPanel = new JPanel();
	private final int NUM_CARDS = 4;
	
	private PainelAltCliente pAltCliente;
	private PainelAltEndereco pAltEndereco;
	private PainelAltContato pAltContato;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnFinalizar;
	private JTextPane txtpnSubTitulo;
	private JLabel lblCamposErrados;

	/** Cria uma instância da janela de alteração de cliente do sistema BVB
	 * @param cliente <code>Cliente</code> com os dados do cliente que será alterado
	 * @param point <code>Point</code> com as coordenadas de onde a caixa de diálogo <code>IgAltCliente</code> se localizará
	 * 
	 * @see Cliente
	 * @see Point
	 */	
	public IgAltCliente(Cliente cliente, Point point) {
		this.cliente = cliente;
		
		pAltCliente = new PainelAltCliente(this, this.cliente);
		pAltEndereco = new PainelAltEndereco(this, this.cliente);
		pAltContato = new PainelAltContato(this, this.cliente);
		
		setModal(true);
		Color peterRiver = new Color(52, 152, 219);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Altera\u00E7\u00E3o de Cliente");
		setBounds(100, 100, 523, 506);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(peterRiver);
		txtpnSubTitulo.setText("Insira o novo nome do cliente.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 260, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(peterRiver);
		txtpnTitulo.setText("Altera\u00E7\u00E3o de Cliente");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 173, 22);
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
		btnAnterior.setVisible(false);
		btnAnterior.addActionListener(new TEActionAlterarCliente(this, cliente));
		btnAnterior.setMnemonic(KeyEvent.VK_A);
		Btnpanel.add(btnAnterior);
		
		btnProximo = new JButton("Pr\u00F3ximo >");
		btnProximo.addActionListener(new TEActionAlterarCliente(this, cliente));
		btnProximo.setMnemonic(KeyEvent.VK_P);
		Btnpanel.add(btnProximo);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new TEActionAlterarCliente(this, cliente));
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
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
		cardPanel.add(pAltCliente, "clientePanel");
		cardPanel.add(pAltEndereco, "enderecoPanel");
		cardPanel.add(pAltContato, "contatoPanel");
		cardLayout.show(cardPanel, "clientePanel");
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setBounds(10, 399, 497, 14);
		contentPane.add(lblCamposErrados);
		
		Point localPoint = new Point(point);
		localPoint.x += 275;
		
		setLocation(localPoint);
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
			return pAltCliente;
		if(paineis[i++].isVisible())
			return pAltEndereco;
		if(paineis[i++].isVisible())
			return pAltContato;
		
		return null;
	}
	
	/** Retorna um <code>CardLayout</code> com layout utilizado no painel de "cartas"
	 * @return <code>CardLayout</code> com layout utilizado no painel de "cartas"
	 */
	public CardLayout getCardLayout() {
		return cardLayout;
	}

	/** Retorna um <code>PainelAltCliente</code> referênte ao painel do cliente
	 * @return <code>PainelAltCliente</code> referênte ao painel do cliente
	 */
	public PainelAltCliente getpAltCliente() {
		return pAltCliente;
	}

	/** Retorna um <code>PainelAltEndereco</code> referênte ao painel do endereço
	 * @return <code>PainelAltEndereco</code> referênte ao painel do endereço
	 */
	public PainelAltEndereco getpAltEndereco() {
		return pAltEndereco;
	}

	/** Retorna um <code>PainelAltContato</code> referênte ao painel do contato
	 * @return <code>PainelAltContato</code> referênte ao painel do cantato
	 */
	public PainelAltContato getpAltContato() {
		return pAltContato;
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
	
	/** Muda o campo de texto do subtítulo
	 * @param subTitulo <code>String</code> com o novo subtítulo do campo
	 */
	public void setTxtpnSubTitulo(String subTitulo) {
		this.txtpnSubTitulo.setText(subTitulo);
	}

	/** Retorna um <code>int</code> com o número de "cartas" do painel
	 * @return <code>int</code> com o número de "cartas" do painel
	 */
	public int getNUM_CARDS() {
		return NUM_CARDS;
	}
	
	/** Retorna um <code>Cliente</code> com os dados do cliente que pode ter sido alterado
	 * @return <code>Cliente</code> com os dados do cliente que pode ter sido alterado
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/** Muda a visibilidade do rótulo que indica que algum campo não foi corretamente preenchido
	 * @param visivel <code>boolean</code> com <code>true</code> se for visível e <code>false</code> caso contrário
	 */
	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}
	
} // class IgPrincipalCadCliente
