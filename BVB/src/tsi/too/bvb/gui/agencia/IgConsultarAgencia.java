package tsi.too.bvb.gui.agencia;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.eventos.agencia.TEActionConsultarAgencia;
import tsi.too.bvb.eventos.agencia.TETecladoConsultarAgencia;

/** Classe que define a GUI de consulta de agência do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JDialog
 */
public class IgConsultarAgencia extends JDialog {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = -733130280527598L;
	
	// Número de colunas da tabela com os dados das agências pesquisadas
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
	private JTextField descricaoTextField;
	private JButton btnCancelar;

	/** Cria uma instância da janela de consulta de agência do sistema BVB
	 * @param janelaPai <code>Window</code> com a janela pai da caixa de diálogo <code>IgConsultarAgencia</code>
	 * 
	 * @see Window
	 */	
	public IgConsultarAgencia(Window janelaPai) {
		setModal(true);
		final Color pumpkin = new Color(211, 84, 0);
		final Color carrot = new Color(230, 126, 34);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Consulta de Ag\u00EAncia");
		setBounds(100, 100, 523, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon(IgConsultarAgencia.class.getResource("/tsi/too/bvb/recursos/imagens/Building-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(pumpkin);
		txtpnSubTitulo.setText("Pesquise uma ag\u00EAncia pelo c\u00F3digo ou pela descri\u00E7\u00E3o.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 320, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnConsultaDeAgncia = new JTextPane();
		txtpnConsultaDeAgncia.setEditable(false);
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
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_O);
		lblCodigo.setBounds(10, 95, 60, 14);
		contentPane.add(lblCodigo);
		
		codigoTextField = new JTextField();
		lblCodigo.setLabelFor(codigoTextField);
		codigoTextField.setToolTipText("para pesquisar utilizando o c\u00F3digo clique no bot\u00E3o buscar");
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(100, 92, 308, 20);
		contentPane.add(codigoTextField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 497, 263);
		contentPane.add(scrollPane);
		
	    tableConsulta = new JTable(new DefaultTableModel(linhasTabela, COLUNAS_AGENCIA)) {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		tableConsulta.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
		    /**
			 * @serial
			 */
			private static final long serialVersionUID = -2860037545840868142L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {  
		        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
		        if(row % 2 == 0)
		            setBackground(pumpkin);  
		        else 
		            setBackground(carrot);  
		        
		        return this;  
		    }  
		});
	    tableConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableConsulta.setCellSelectionEnabled(true);
		tableConsulta.setColumnSelectionAllowed(true);
		tableConsulta.setForeground(Color.WHITE);
		tableConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tableConsulta);
		tableConsulta.setBackground(pumpkin);

		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new TEActionConsultarAgencia(this));
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(418, 91, 89, 23);
		contentPane.add(btnBuscar);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new TEActionConsultarAgencia(this));
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		Btnpanel.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgConsultarAgencia.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		btnCancelar.setActionCommand("OK");
		Btnpanel.add(btnCancelar);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		contentPane.add(separatorBtn);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setDisplayedMnemonic(KeyEvent.VK_D);
		lblDescricao.setBounds(10, 125, 65, 14);
		contentPane.add(lblDescricao);
		
		descricaoTextField = new JTextField();
		descricaoTextField.setToolTipText("a pesquisa \u00E9 realizada automaticamente quando cada caracter \u00E9 digitado");
		descricaoTextField.addKeyListener(new TETecladoConsultarAgencia(this));
		lblDescricao.setLabelFor(descricaoTextField);
		descricaoTextField.setBounds(100, 123, 308, 20);
		contentPane.add(descricaoTextField);
		descricaoTextField.setColumns(10);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	/** Adiciona linhas à tabela. É inserido o dado da agência que for passado por parâmetro
	 * @param agencia <code>Agencia</code> com o dado da agência que será inserida na tabela
	 */
	public void addLinhasTabela(Agencia agencia) {
		DefaultTableModel model = ((DefaultTableModel)(tableConsulta.getModel()));
		model.setNumRows(num_linhas++);

		Object[] linha = new Object[NUMERO_COLUNAS_TABELA];
		
		linha[0] = agencia.getCodAgencia();
		linha[1] = agencia.getDescricao();
		model.addRow(linha);
	}
	
	/** Adiciona linhas à tabela. São inseridos os dados das agências que foram passados por parâmetro na lista <code>List</code>
	 * @param agencias <code>List</code> com os dados das agências que serão inseridos na tabela
	 * 
	 * @see List
	 */
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
	
	/** Limpa a tabela de pesquisa apagando os dados contidos nela
	 * @return <code>DefaultTableModel</code> com o modelo da tabela
	 */
	public DefaultTableModel limpaTabela() {
		DefaultTableModel model = ((DefaultTableModel)(tableConsulta.getModel()));
		num_linhas = 0;
		model.setNumRows(num_linhas);
		
		return model;
	}
	
	/** Limpa os campos da janela <code>IgConsultarAgencia</code>
	 */
	public void limpaCampos() {
		codigoTextField.setText("");
		descricaoTextField.setText("");
	}
	
	/** Pesquisa se determinada agência foi inserida na tabela
	 * @param agenca <code>Agencia</code> com os dados da agência que será pesquisada
	 * @return <code>boolean</code> com <code>true</code> caso a agência tenha sido encontrada, e <code>false</code> caso contrário
	 */
	public boolean pesquisaTabela(Agencia agenca) {
		for(int i = 0; i < num_linhas; i++) {
			int codigo = Integer.parseInt(tableConsulta.getModel().getValueAt(i, 0).toString());
			if(codigo == agenca.getCodAgencia())
				return true;
		}
		
		return false;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto código
	 * @return <code>JTextField</code> com o campo de texto código
	 */
	public JTextField getCodigoTextField() {
		return codigoTextField;
	}
	
	/** Retorna um <code>JTextField</code> com o campo de texto descrição
	 * @return <code>JTextField</code> com o campo de texto descrição
	 */
	public JTextField getDescricaoTextField() {
		return descricaoTextField;
	}

	/** Retorna um <code>JButton</code> com o botão buscar
	 * @return <code>JButton</code> com o botão buscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	/** Retorna um <code>JButton</code> com o botão limpar
	 * @return <code>JButton</code> com o botão limpar
	 */
	public JButton getBtnLimpar() {
		return btnLimpar;
	}
	
} // class IgConsultarAgencia
