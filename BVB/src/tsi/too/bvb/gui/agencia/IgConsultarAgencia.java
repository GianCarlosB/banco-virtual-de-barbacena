package tsi.too.bvb.gui.agencia;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.eventos.agencia.TEMouseConsultarAgencia;
import tsi.too.bvb.eventos.agencia.TETecladoConsultarAgencia;

public class IgConsultarAgencia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -733130280527598L;
	
	/** <code>int</code> com o número de colunas da tabela com os dados das agências pesquisadas */
	private final int NUMERO_COLUNAS_TABELA = 2;
	private int num_linhas;
	
	private final String COLUNA_CODIGO = "Código";
	private final String COLUNA_DESCRICAO = "Descrição";
	private final String[] COLUNAS_AGENCIA = {COLUNA_CODIGO, COLUNA_DESCRICAO};
	private String[][] linhasTabela = new String[0][NUMERO_COLUNAS_TABELA];
	
	private JPanel contentPane;
	private JTextField codigoTextField;
	private JTable tableConsulta;
	private JButton btnBuscar;
	private JButton btnLimpar;
	private JButton btnOk;
	private JTextField descricaoTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new IgConsultarAgencia();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IgConsultarAgencia() {
		Color pumpkin = new Color(211, 84, 0);
		
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
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\Building-48.png"));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(pumpkin);
		txtpnSubTitulo.setText("Pesquise uma ag\u00EAncia pelo c\u00F3digo.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 260, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnConsultaDeAgncia = new JTextPane();
		txtpnConsultaDeAgncia.setForeground(Color.WHITE);
		txtpnConsultaDeAgncia.setBackground(pumpkin);
		txtpnConsultaDeAgncia.setText("Consulta de Ag\u00EAncia");
		txtpnConsultaDeAgncia.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnConsultaDeAgncia.setBounds(10, 11, 150, 22);
		contentPane.add(txtpnConsultaDeAgncia);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(pumpkin);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_C);
		lblCodigo.setBounds(10, 95, 60, 14);
		contentPane.add(lblCodigo);
		
		codigoTextField = new JTextField();
		lblCodigo.setLabelFor(codigoTextField);
		codigoTextField.setToolTipText("para pesquisar utilizando o c\u00F3digo clique no bot\u00E3o buscar");
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(80, 92, 308, 20);
		contentPane.add(codigoTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 497, 268);
		contentPane.add(scrollPane);
		
	    tableConsulta = new JTable(new DefaultTableModel(linhasTabela, COLUNAS_AGENCIA)) {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
	    tableConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableConsulta.setCellSelectionEnabled(true);
		tableConsulta.setColumnSelectionAllowed(true);
		tableConsulta.setForeground(Color.WHITE);
		tableConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tableConsulta);
		tableConsulta.setBackground(pumpkin);

		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new TEMouseConsultarAgencia(this));
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(398, 91, 89, 23);
		contentPane.add(btnBuscar);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new TEMouseConsultarAgencia(this));
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		Btnpanel.add(btnLimpar);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgConsultarAgencia.this.dispose();
			}
		});
		btnOk.setMnemonic(KeyEvent.VK_O);
		btnOk.setActionCommand("OK");
		Btnpanel.add(btnOk);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		contentPane.add(separatorBtn);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setDisplayedMnemonic(KeyEvent.VK_D);
		lblDescricao.setBounds(10, 120, 65, 14);
		contentPane.add(lblDescricao);
		
		descricaoTextField = new JTextField();
		descricaoTextField.setToolTipText("a pesquisa \u00E9 realizada automaticamente quando cada caracter \u00E9 digitado");
		descricaoTextField.addKeyListener(new TETecladoConsultarAgencia(this));
		lblDescricao.setLabelFor(descricaoTextField);
		descricaoTextField.setBounds(80, 117, 308, 20);
		contentPane.add(descricaoTextField);
		descricaoTextField.setColumns(10);
		
		setVisible(true);
	}
	
	public void addLinhasTabela(Agencia agencia) {
		DefaultTableModel model = ((DefaultTableModel)(tableConsulta.getModel()));
		model.setNumRows(num_linhas++);

		Object[] linha = new Object[NUMERO_COLUNAS_TABELA];
		
		linha[0] = agencia.getCodAgencia();
		linha[1] = agencia.getDescricao();
		model.addRow(linha);
	}
	
	public void addLinhasTabela(List<Agencia> agencias) {
		DefaultTableModel model = limpaTabela();
		
		if (agencias.size() > 0) {
			Object[] linha = new Object[NUMERO_COLUNAS_TABELA];
			
			for(int i = 0; i < agencias.size(); i++, num_linhas++) {
				linha[0] = agencias.get(i).getCodAgencia();
				linha[1] = agencias.get(i).getDescricao();
				model.addRow(linha);
			}
		}
	}
	
	public DefaultTableModel limpaTabela() {
		DefaultTableModel model = ((DefaultTableModel)(tableConsulta.getModel()));
		num_linhas = 0;
		model.setNumRows(num_linhas);
		
		return model;
	}
	
	public boolean pesquisaTabela(Agencia agenca) {
		for(int i = 0; i < num_linhas; i++) {
			int codigo = Integer.parseInt(tableConsulta.getModel().getValueAt(i, 0).toString());
			if(codigo == agenca.getCodAgencia())
				return true;
		}
		
		return false;
	}

	public JTextField getCodigoTextField() {
		return codigoTextField;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JTextField getDescricaoTextField() {
		return descricaoTextField;
	}
	
} // class IgConsultarAgencia
