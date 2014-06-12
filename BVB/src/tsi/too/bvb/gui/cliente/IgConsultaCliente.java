package tsi.too.bvb.gui.cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
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

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.cliente.Cliente;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class IgConsultaCliente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8844899981206036228L;

	/** <code>int</code> com o número de colunas da tabela com os dados dos clientes pesquisados */
	public final int NUMERO_COLUNAS_TABELA = 11;
	
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			new IgConsultaCliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IgConsultaCliente() {
		Color peterRiver = new Color(52, 152, 219);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Consulta de Cliente");
		setBounds(100, 100, 784, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 778, 2);
		contentPanel.add(separatorTitulo);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(peterRiver);
		txtpnSubTitulo.setText("Pesquise um cliente pelo nome ou pelo CPF.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 320, 22);
		contentPanel.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(peterRiver);
		txtpnTitulo.setText("Consulta de Cliente");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPanel.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\User-Login-48.png"));
		lblImg.setBounds(720, 11, 48, 48);
		contentPanel.add(lblImg);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(peterRiver);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 778, 70);
		contentPanel.add(dtrpnCampoTitulo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setDisplayedMnemonic(KeyEvent.VK_N);
		lblNome.setBounds(10, 95, 46, 14);
		contentPanel.add(lblNome);
		
		nomeTextField = new JTextField();
		lblNome.setLabelFor(nomeTextField);
		nomeTextField.setToolTipText("a pesquisa \u00E9 realizada automaticamente quando cada caracter \u00E9 digitado");
		nomeTextField.setColumns(10);
		nomeTextField.setBounds(66, 92, 231, 20);
		contentPanel.add(nomeTextField);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setDisplayedMnemonic(KeyEvent.VK_C);
		lblCpf.setBounds(382, 95, 46, 14);
		contentPanel.add(lblCpf);
		
		cpfFormattedTextField = new JFormattedTextField(new Mascara("###.###.###-##"));
		lblCpf.setLabelFor(cpfFormattedTextField);
		cpfFormattedTextField.setToolTipText("para pesquisar utilizando o cpf clique no bot\u00E3o buscar");
		cpfFormattedTextField.setBounds(438, 92, 231, 20);
		contentPanel.add(cpfFormattedTextField);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setMnemonic(KeyEvent.VK_B);
		btnBuscar.setBounds(679, 91, 89, 23);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBounds(10, 125, 758, 342);
		contentPanel.add(scrollPane);

		tableConsulta = new JTable(new DefaultTableModel(linhasTabela, COLUNAS_CLIENTE));
		tableConsulta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(tableConsulta);
		
		setVisible(true);
	}
	
	public void addLinhasTabela(List<Cliente> clientes) {
		DefaultTableModel model = limpaTabela();
		
		if (clientes.size() > 0){
			Object[] linha = new Object[NUMERO_COLUNAS_TABELA];
			
			for(int i = 0; i < clientes.size(); i++) {
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
} // class IgConsultaCliente
