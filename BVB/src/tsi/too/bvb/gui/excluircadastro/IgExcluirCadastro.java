package tsi.too.bvb.gui.excluircadastro;

import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.eventos.excluircadastro.TEActionExcluirCadastro;
import tsi.too.bvb.gui.PainelBuscarAgencia;
import tsi.too.bvb.gui.PainelBuscarCliente;
import tsi.too.bvb.gui.PainelBuscarFuncionario;

/** Classe que define a GUI de exclusão de cadastro do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgExcluirCadastro extends JDialog {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = -7001548312817723522L;
	
	private Funcionario funcionario;
	
	private CardLayout cardLayout= new CardLayout();
	
	private final JPanel contentPanel = new JPanel();
	private JPanel cardPanel;
	private final int NUM_CARDS = 3;
	
	private PainelBuscarCliente pBuscarCliente = new PainelBuscarCliente();
	private PainelBuscarFuncionario pBuscarFuncionario = new PainelBuscarFuncionario();
	private PainelBuscarAgencia pBuscarAgencia = new PainelBuscarAgencia();
	private JButton btnBuscar;
	private JButton btnExcluir;
	private JEditorPane dadosEditorPane;
	private JButton btnAlterar;

	/** Cria uma instância da janela de exclusão de cadastro do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgExcluirCadastro</code>
	 * @param funcionario <code>Funcionario</code> com os dados do funcionário logado
	 * @param titulo <code>String</code> com o título da janela
	 * @param txtTitulo <code>String</code> com o título do corpo da janela
	 * @param txtSubTitulo <code>String</code> com o subtítulo do corpo da janela
	 * @param tipo <code>final</code> <code>int</code> com o tipo de exclusão: 1 - Cliente, 2 - Funcionário, 3 - Agência
	 * 
	 * @see Window
	 */	
	public IgExcluirCadastro(Window janelaPai, Funcionario funcionario, String titulo, String txtTitulo, String txtSubTitulo, int tipo) {
		this.funcionario = funcionario;
		
		setModal(true);
		Color pomergante = new Color(192, 57, 43);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle(titulo);
		setBounds(100, 100, 523, 506);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(janelaPai);
		getContentPane().setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		getContentPane().add(separatorTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setText(txtTitulo);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBackground(pomergante);
		txtpnTitulo.setBounds(10, 11, 330, 22);
		getContentPane().add(txtpnTitulo);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setText(txtSubTitulo);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBackground(pomergante);
		txtpnSubTitulo.setBounds(20, 36, 330, 22);
		getContentPane().add(txtpnSubTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setIcon(new ImageIcon(IgExcluirCadastro.class.getResource("/tsi/too/bvb/recursos/imagens/Delete-48.png")));
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setBounds(459, 11, 48, 48);
		getContentPane().add(lblImg);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBackground(pomergante);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		getContentPane().add(dtrpnCampoTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		getContentPane().add(separatorBtn);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		getContentPane().add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new TEActionExcluirCadastro(this, tipo));
		btnExcluir.setEnabled(false);
		btnExcluir.setMnemonic(KeyEvent.VK_E);
		Btnpanel.add(btnExcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgExcluirCadastro.this.dispose();
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
		btnBuscar.addActionListener(new TEActionExcluirCadastro(this, tipo));
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(418, 91, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new TEActionExcluirCadastro(this, tipo));
		btnAlterar.setVisible(false);
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		btnAlterar.setBounds(418, 91, 89, 23);
		getContentPane().add(btnAlterar);
		setVisible(true);
	}
	
	/** Exibe o painel da janela <code>IgExcluirCadastro</code> de acordo com o tipo de exclusão
	 * @param tipo <code>int</code> com o tipo de exclusão: 1 - Cliente, 2 - Funcionário, 3 - Agência
	 */
	private void exibeCardPainel(int tipo) {
		switch(tipo) {
		case 1: cardLayout.show(cardPanel, "clientePanel"); break;
		case 2: cardLayout.show(cardPanel, "funcionarioPanel"); break;
		case 3: cardLayout.show(cardPanel, "agenciaPanel"); break;
		}
	}
	
	/** Exibe as opções de alterar dados da janela <code>IgExcluirCadastro</code>
	 * @param dados <code>String</code> com o texto do campo de texto dados
	 */
	public void exibeOpcoesExcluir(String dados) {
		btnExcluir.setEnabled(true);
		btnBuscar.setVisible(false);
		btnAlterar.setVisible(true);
		dadosEditorPane.setText(dados);
	}
	
	/** Esconde as opções de alterar dados da janela <code>IgExcluirCadastro</code>
	 */
	public void escondeOpcoesExcluir() {
		btnExcluir.setEnabled(false);
		btnBuscar.setVisible(true);
		btnAlterar.setVisible(false);
		dadosEditorPane.setText("");
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

	/** Retorna um <code>JButton</code> com o botão excluir
	 * @return <code>JButton</code> com o botão excluir
	 */
	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	/** Retorna um <code>Funcionario</code> com os dados do funcionário logado
	 * @return <code>Funcionario</code> com os dados do funcionário logado
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/** Retorna um <code>int</code> com o número de "cartas" do painel
	 * @return <code>int</code> com o número de "cartas" do painel
	 */
	public int getNUM_CARDS() {
		return NUM_CARDS;
	}
	
} // class IgExcluir
