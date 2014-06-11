package tsi.too.bvb.gui.agencia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tsi.too.bvb.entidades.agencia.Agencia;

public class IgConsultaAgencia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -733130280527598L;
	
	/** <code>int</code> com o número de colunas da tabela com os dados dos clientes pesquisados */
	private final int NUMERO_COLUNAS_TABELA = 2;
	
	private final String COLUNA_CODIGO = "Código";
	private final String COLUNA_DESCRICAO = "Descrição";
	private final String[] COLUNAS_AGENCIA = {COLUNA_CODIGO, COLUNA_DESCRICAO};
	private String[][] linhasTabela = new String[0][NUMERO_COLUNAS_TABELA];
	
	private JPanel contentPane;
	private JTextField textField;
	private JTable tableConsulta;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new IgConsultaAgencia();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IgConsultaAgencia() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Consulta de Ag\u00EAncia");
		setBounds(100, 100, 523, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 4);
		contentPane.add(separatorTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\commerical-building.png"));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setText("Pesquise uma ag\u00EAncia pelo c\u00F3digo.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnSubTitulo.setBounds(20, 36, 200, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnConsultaDeAgncia = new JTextPane();
		txtpnConsultaDeAgncia.setText("Consulta de Ag\u00EAncia");
		txtpnConsultaDeAgncia.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnConsultaDeAgncia.setBounds(10, 11, 150, 22);
		contentPane.add(txtpnConsultaDeAgncia);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_C);
		lblCodigo.setBounds(10, 95, 60, 14);
		contentPane.add(lblCodigo);
		
		textField = new JTextField();
		textField.setToolTipText("a pesquisa \u00E9 realizada automaticamente quando cada caracter \u00E9 digitado");
		textField.setColumns(10);
		textField.setBounds(80, 92, 308, 20);
		contentPane.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 125, 497, 342);
		contentPane.add(scrollPane);
		
		tableConsulta = new JTable(new DefaultTableModel(linhasTabela, COLUNAS_AGENCIA));
		tableConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tableConsulta);
		tableConsulta.setBackground(Color.WHITE);
		tableConsulta.getColumn(COLUNA_CODIGO).setPreferredWidth(1);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(398, 91, 89, 23);
		contentPane.add(btnBuscar);
		
		setVisible(true);
	}
	
	public void addLinhasTabela(List<Agencia> agencias) {
		DefaultTableModel model = limpaTabela();
		
		if (agencias.size() > 0){
			Object[] linha = new Object[NUMERO_COLUNAS_TABELA];
			
			for(int i = 0; i < agencias.size(); i++) {
				linha[0] = agencias.get(i).getCodAgencia();
				linha[1] = agencias.get(i).getDescricao();
				model.addRow(linha);
			}
		}
		else {}
	}
	
	public DefaultTableModel limpaTabela() {
		DefaultTableModel model = ((DefaultTableModel)(tableConsulta.getModel()));
		model.setNumRows(0);
		
		return model;
	}
	
} // class IgConsultaAgencia
