package tsi.too.bvb.gui.cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.tiposenumerados.Mes;
import tsi.too.bvb.eventos.cliente.TEActionRelatorioCliente;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define a GUI de relatório de cliente do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgRelatorioCliente extends JDialog {
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 8844899981206036228L;
	
	private int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
	private int mesAtual = Calendar.getInstance().get(Calendar.MONTH);
	
	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JComboBox<String> mesComboBox;
	private JComboBox<String> anoComboBox;
	private DefaultComboBoxModel<String> modeloAnoCorrente = new DefaultComboBoxModel<String>(Mes.obterArrayMeses(mesAtual + 1));
	private DefaultComboBoxModel<String> modeloAnosPassados = new DefaultComboBoxModel<String>(Mes.obterArrayMeses());
	private JButton btnGerarRelatorio;
	private JEditorPane relatorioEditorPane;

	/** Cria uma instância da janela de relatório de cliente do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgRelatorioCliente</code>
	 * 
	 * @see Window
	 */	
	public IgRelatorioCliente(Window janelaPai) {
		setModal(true);
		Color peterRiver = new Color(52, 152, 219);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Relat\u00F3rio de Cliente");
		setBounds(100, 100, 690, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 685, 2);
		contentPanel.add(separatorTitulo);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(peterRiver);
		txtpnSubTitulo.setText("Insira a data da qual deseja gerar o relat\u00F3rio dos clientes que abriram contas banc\u00E1rias.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 500, 22);
		contentPanel.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(peterRiver);
		txtpnTitulo.setText("Relat\u00F3rio de Cliente");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPanel.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon(IgRelatorioCliente.class.getResource("/tsi/too/bvb/recursos/imagens/User-Login-48.png")));
		lblImg.setBounds(624, 11, 48, 48);
		contentPanel.add(lblImg);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(peterRiver);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 685, 70);
		contentPanel.add(dtrpnCampoTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 435, 685, 43);
		contentPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IgRelatorioCliente.this.dispose();
			}
		});
		
		btnGerarRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatorio.addActionListener(new TEActionRelatorioCliente(this));
		btnGerarRelatorio.setMnemonic(KeyEvent.VK_G);
		panel.add(btnGerarRelatorio);
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		btnCancelar.setActionCommand("OK");
		panel.add(btnCancelar);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 685, 2);
		contentPanel.add(separatorBtn);
		
		JPanel panelRelatorio = new JPanel();
		panelRelatorio.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Relat\u00F3rio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panelRelatorio.setBounds(10, 127, 662, 285);
		contentPanel.add(panelRelatorio);
		panelRelatorio.setLayout(new BorderLayout(0, 0));
		
		JScrollPane relatorioScrollPane = new JScrollPane();
		relatorioScrollPane.setBorder(null);
		relatorioScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelRelatorio.add(relatorioScrollPane, BorderLayout.CENTER);
		
		relatorioEditorPane = new JEditorPane();
		relatorioEditorPane.setFont(new Font("Arial", Font.BOLD, 14));
		relatorioEditorPane.setEditable(false);
		relatorioEditorPane.setBackground(new Color(238, 238, 238));
		relatorioScrollPane.setViewportView(relatorioEditorPane);
		
		mesComboBox =  new JComboBox<String>();
		mesComboBox.setToolTipText("selecione o m\u00EAs");
		mesComboBox.setModel(modeloAnosPassados);
		mesComboBox.setBounds(50, 90, 85, 25);
		contentPanel.add(mesComboBox);
		
		JLabel lblMes = new JLabel("M\u00EAs:");
		lblMes.setLabelFor(mesComboBox);
		lblMes.setDisplayedMnemonic(KeyEvent.VK_M);
		lblMes.setBounds(10, 95, 35, 14);
		contentPanel.add(lblMes);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setDisplayedMnemonic(KeyEvent.VK_A);
		lblAno.setBounds(200, 95, 40, 16);
		contentPanel.add(lblAno);
		
		anoComboBox = new JComboBox<String>();
		anoComboBox.setToolTipText("selecione o ano");
		anoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				verifcarAnoCorrente();
			}
		});
		anoComboBox.setModel(new DefaultComboBoxModel<String>(arrayAnos()));
		lblAno.setLabelFor(anoComboBox);
		anoComboBox.setBounds(250, 90, 60, 25);
		contentPanel.add(anoComboBox);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	/** Cria um <code>String[]</code> com os anos permitidos dentro dos parâmetros aceitos no sistema BVB
	 *  @return <code>String[]</code> com os anos permitidos dentro dos parâmetros aceitos no sistema BVB
	 */
	private String[] arrayAnos() {
		ArrayList<String> anosList = new ArrayList<String>();
		String  arrayAnos[];
		
		for(int ano = ValidarDados.ANO_MIN; ano <= anoAtual && ano < ValidarDados.ANO_MAX; ano++)
			anosList.add(Integer.toString(ano));
		
		arrayAnos = new String[anosList.size()];
		arrayAnos = anosList.toArray(arrayAnos);
		
		return arrayAnos;
	}
	
	/** Verifica se o ano selecionado na caixa de combinação é igual ao ano atual
	 */
	private void verifcarAnoCorrente() {
		if(Integer.parseInt((String) anoComboBox.getSelectedItem()) == anoAtual)
			mesComboBox.setModel(modeloAnoCorrente);
		else
			mesComboBox.setModel(modeloAnosPassados);
	}

	/** Retorna um <code>JComboBox</code> com a caixa de combinação do mês
	 * @return <code>JComboBox</code> com a caixa de combinação do mês
	 */
	public JComboBox<String> getMesComboBox() {
		return mesComboBox;
	}

	/** Retorna um <code>JComboBox</code> com a caixa de combinação do ano
	 * @return <code>JComboBox</code> com a caixa de combinação do ano
	 */
	public JComboBox<String> getAnoComboBox() {
		return anoComboBox;
	}

	/** Retorna um <code>JButton</code> com o botão gerar relatório
	 * @return <code>JButton</code> com o botão gerar relatório
	 */
	public JButton getBtnGerarRelatorio() {
		return btnGerarRelatorio;
	}

	/** Muda o campo de texto relatório
	 * @param relatorio <code>String</code> com o novo relatório do campo
	 */
	public void setRelatorioEditorPane(String relatorio) {
		this.relatorioEditorPane.setText(relatorio);;
	}
	
} // class IgConsultarCliente
