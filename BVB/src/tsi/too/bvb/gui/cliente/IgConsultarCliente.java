package tsi.too.bvb.gui.cliente;

import java.awt.BorderLayout;
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
import javax.swing.JFormattedTextField;
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

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.eventos.cliente.TEActionConsultarCliente;
import tsi.too.bvb.eventos.cliente.TETecladoConsultarCliente;

public class IgConsultarCliente extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8844899981206036228L;

	/** <code>int</code> com o número de colunas da tabela com os dados dos clientes pesquisados */
	public final int NUMERO_COLUNAS_TABELA = 11;
	private int num_linhas;
	
	private final String COLUNA_CPF = "CPF";
	private final String COLUNA_NOME = "Nome";
	private final String COLUNA_LOGRADOURO = "Logradouro";
	private final String COLUNA_NUMERO = "Número";
	private final String COLUNA_COMPLEMENTO = "Complemento";
	private final String COLUNA_BAIRRO = "Bairro";
	private final String COLUNA_CIDADE = "Cidade";
	private final String COLUNA_UF = "UF";
	private final String COLUNA_CEP = "CEP";
	private final String COLUNA_TEL_FIXO = "Tel Fixo";
	private final String COLUNA_TEL_MOVEL = "Tel Móvel";
	private final String[] COLUNAS_CLIENTE = {COLUNA_CPF, COLUNA_NOME, COLUNA_LOGRADOURO, COLUNA_NUMERO,COLUNA_COMPLEMENTO, COLUNA_BAIRRO,
											  COLUNA_CIDADE, COLUNA_UF, COLUNA_CEP, COLUNA_TEL_FIXO, COLUNA_TEL_MOVEL};
	private String[][] linhasTabela = new String[0][NUMERO_COLUNAS_TABELA];

	private final JPanel contentPanel = new JPanel();
	private JTextField nomeTextField;
	private JTable tableConsulta;
	private JFormattedTextField cpfFormattedTextField;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JButton btnBuscar;

	/**
	 * Create the dialog.
	 */
	public IgConsultarCliente(Window janelaPai) {
		setModal(true);
		final Color peterRiver = new Color(52, 152, 219);
		final Color belizeHole = new Color(41, 128, 185);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Consulta de Cliente");
		setBounds(100, 100, 523, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 778, 2);
		contentPanel.add(separatorTitulo);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(peterRiver);
		txtpnSubTitulo.setText("Pesquise um cliente pelo nome ou pelo CPF.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 320, 22);
		contentPanel.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(peterRiver);
		txtpnTitulo.setText("Consulta de Cliente");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPanel.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon(IgConsultarCliente.class.getResource("/tsi/too/bvb/recursos/imagens/User-Login-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPanel.add(lblImg);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(peterRiver);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPanel.add(dtrpnCampoTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setDisplayedMnemonic(KeyEvent.VK_N);
		lblNome.setBounds(10, 95, 46, 14);
		contentPanel.add(lblNome);
		
		nomeTextField = new JTextField();
		nomeTextField.addKeyListener(new TETecladoConsultarCliente(this));
		lblNome.setLabelFor(nomeTextField);
		nomeTextField.setToolTipText("a pesquisa \u00E9 realizada automaticamente quando cada caracter \u00E9 digitado");
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(100, 92, 308, 20);
		contentPanel.add(nomeTextField);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setDisplayedMnemonic(KeyEvent.VK_P);
		lblCpf.setBounds(10, 125, 46, 14);
		contentPanel.add(lblCpf);
		
		cpfFormattedTextField = new JFormattedTextField(new Mascara("###.###.###-##"));
		lblCpf.setLabelFor(cpfFormattedTextField);
		cpfFormattedTextField.setToolTipText("para pesquisar utilizando o cpf clique no bot\u00E3o buscar");
		cpfFormattedTextField.setBounds(100, 123, 308, 20);
		contentPanel.add(cpfFormattedTextField);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new TEActionConsultarCliente(this));
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(418, 121, 89, 23);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBounds(10, 150, 497, 263);
		contentPanel.add(scrollPane);

		tableConsulta = new JTable(new DefaultTableModel(linhasTabela, COLUNAS_CLIENTE)) {
	        private static final long serialVersionUID = 1L;
	
	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		tableConsulta.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {  
		    /**
			 * 
			 */
			private static final long serialVersionUID = -2860037545840868142L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {  
		        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
		        if(row % 2 == 0)
		            setBackground(peterRiver);  
		        else 
		            setBackground(belizeHole);  
		        
		        return this;  
		    }  
		});
		tableConsulta.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableConsulta.setForeground(Color.WHITE);
		tableConsulta.setBackground(peterRiver);
		tableConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tableConsulta);
		tableConsulta.getColumn(COLUNA_CPF).setPreferredWidth(100);
		tableConsulta.getColumn(COLUNA_NOME).setPreferredWidth(150);
		tableConsulta.getColumn(COLUNA_LOGRADOURO).setPreferredWidth(150);
		tableConsulta.getColumn(COLUNA_NUMERO).setPreferredWidth(100);
		tableConsulta.getColumn(COLUNA_COMPLEMENTO).setPreferredWidth(150);
		tableConsulta.getColumn(COLUNA_BAIRRO).setPreferredWidth(150);
		tableConsulta.getColumn(COLUNA_CIDADE).setPreferredWidth(150);
		tableConsulta.getColumn(COLUNA_UF).setPreferredWidth(50);
		tableConsulta.getColumn(COLUNA_CEP).setPreferredWidth(100);
		tableConsulta.getColumn(COLUNA_TEL_FIXO).setPreferredWidth(100);
		tableConsulta.getColumn(COLUNA_TEL_MOVEL).setPreferredWidth(100);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 435, 517, 43);
		contentPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new TEActionConsultarCliente(this));
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		panel.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IgConsultarCliente.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		btnCancelar.setActionCommand("OK");
		panel.add(btnCancelar);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		contentPanel.add(separatorBtn);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	public void addLinhasTabela(Cliente cliente) {
		DefaultTableModel model = ((DefaultTableModel)(tableConsulta.getModel()));
		model.setNumRows(num_linhas++);
		
		Object[] linha = new Object[NUMERO_COLUNAS_TABELA];
		
		linha[0] = Mascara.formatarString(cliente.getCpf(), "###.###.###-##");
		linha[1] = cliente.getNome();
		linha[2] = cliente.getEndereco().getLogradouro();
		linha[3] = cliente.getEndereco().getNumero();
		linha[4] = cliente.getEndereco().getComplemento();
		linha[5] = cliente.getEndereco().getBairro();
		linha[6] = cliente.getEndereco().getCidade();
		linha[7] = cliente.getEndereco().getUf().getUf();
		linha[8] = Mascara.formatarString(cliente.getEndereco().getCep(), "#####-###");
		linha[9] = Mascara.formatarString(cliente.getContato().getTelefoneFixo(), "(##)####-####");
		linha[10] = Mascara.formatarString(cliente.getContato().getTelefoneMovel(), "(##)####-####");
		model.addRow(linha);
	}
	
	public void addLinhasTabela(List<Cliente> clientes) {
		DefaultTableModel model = limpaTabela();
		
		if (clientes.size() > 0) {
			Object[] linha = new Object[NUMERO_COLUNAS_TABELA];
			
			for(int i = 0; i < clientes.size(); i++, num_linhas++) {
				clientes.get(i).insereMascara();
				linha[0] = clientes.get(i).getCpf();
				linha[1] = clientes.get(i).getNome();
				linha[2] = clientes.get(i).getEndereco().getLogradouro();
				linha[3] = clientes.get(i).getEndereco().getNumero();
				linha[4] = clientes.get(i).getEndereco().getComplemento();
				linha[5] = clientes.get(i).getEndereco().getBairro();
				linha[6] = clientes.get(i).getEndereco().getCidade();
				linha[7] = clientes.get(i).getEndereco().getUf().getUf();
				linha[8] = clientes.get(i).getEndereco().getCep();
				linha[9] = clientes.get(i).getContato().getTelefoneFixo();
				linha[10] = clientes.get(i).getContato().getTelefoneMovel();
				clientes.get(i).removeMascara();
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
	
	public boolean pesquisaTabela(Cliente cliente) {
		for(int i = 0; i < num_linhas; i++) {
			String cpf = tableConsulta.getModel().getValueAt(i, 0).toString().replace(".", "").replace("-", "");
			if(cpf.equals(cliente.getCpf()))
				return true;
		}
		
		return false;
	}
	
	public void limpaCampos() {
		nomeTextField.setText("");
		cpfFormattedTextField.setText("");
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public JFormattedTextField getCpfFormattedTextField() {
		return cpfFormattedTextField;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	
} // class IgConsultarCliente
