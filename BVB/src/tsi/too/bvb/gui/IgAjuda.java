package tsi.too.bvb.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class IgAjuda extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -708231668410033376L;
	
	private JPanel contentPane;
	private JRadioButton rdbtnPerg8;
	private JRadioButton rdbtnPerg7;
	private JRadioButton rdbtnPerg6;
	private JRadioButton rdbtnPerg5;
	private JRadioButton rdbtnPerg4;
	private JRadioButton rdbtnPerg3;
	private JRadioButton rdbtnPerg2;
	private JRadioButton rdbtnPerg1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JEditorPane respostaEditorPane;
	private JRadioButton rdbtnPerg12;
	private JRadioButton rdbtnPerg10;
	private JRadioButton rdbtnPerg11;
	private JRadioButton rdbtnPerg9;

	/**
	 * Create the frame.
	 */
	public IgAjuda(Window janelaPai) {
		setModal(true);
		final Color sunFlower = new Color(241, 196, 15);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Ajuda");
		setBounds(100, 100, 523, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 4);
		contentPane.add(separatorTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.BLACK, 1, true));
		lblImg.setIcon(new ImageIcon(IgAjuda.class.getResource("/tsi/too/bvb/recursos/imagens/Help-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.BLACK);
		txtpnSubTitulo.setBackground(sunFlower);
		txtpnSubTitulo.setText("Selecione suas d\u00FAvidas no painel de perguntas.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 280, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnConsultaDeAgncia = new JTextPane();
		txtpnConsultaDeAgncia.setEditable(false);
		txtpnConsultaDeAgncia.setForeground(Color.BLACK);
		txtpnConsultaDeAgncia.setBackground(sunFlower);
		txtpnConsultaDeAgncia.setText("Ajuda");
		txtpnConsultaDeAgncia.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnConsultaDeAgncia.setBounds(10, 11, 60, 22);
		contentPane.add(txtpnConsultaDeAgncia);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(sunFlower);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JPanel respostaPanel = new JPanel();
		respostaPanel.setBorder(null);
		respostaPanel.setBounds(17, 95, 331, 103);
		contentPane.add(respostaPanel);
		respostaPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane respostaScrollPane = new JScrollPane();
		respostaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		respostaScrollPane.setBorder(null);
		respostaPanel.add(respostaScrollPane, BorderLayout.CENTER);
		
		respostaEditorPane = new JEditorPane();
		respostaEditorPane.setText(" Como posso ajudar?");
		respostaEditorPane.setFont(new Font("Dialog", Font.BOLD, 12));
		respostaEditorPane.setBackground(new Color(238, 238, 238));
		respostaEditorPane.setEditable(false);
		respostaScrollPane.setViewportView(respostaEditorPane);
		
		JPanel btnsPerguntaPanel = new JPanel();
		btnsPerguntaPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Perguntas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		btnsPerguntaPanel.setBounds(12, 219, 495, 247);
		contentPane.add(btnsPerguntaPanel);
		btnsPerguntaPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane perguntaScrollPane = new JScrollPane();
		perguntaScrollPane.setBorder(null);
		btnsPerguntaPanel.add(perguntaScrollPane, BorderLayout.CENTER);
		
		JPanel Perguntaspanel = new JPanel();
		perguntaScrollPane.setViewportView(Perguntaspanel);
		Perguntaspanel.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][]"));
		
		rdbtnPerg1 = new JRadioButton("Como fa\u00E7o para iniciar um processo de cadastro?");
		rdbtnPerg1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg1);
		Perguntaspanel.add(rdbtnPerg1, "cell 0 0");
		
		rdbtnPerg2 = new JRadioButton("Como fa\u00E7o para realizar uma consulta?");
		rdbtnPerg2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg2);
		Perguntaspanel.add(rdbtnPerg2, "cell 0 1");
		
		rdbtnPerg3 = new JRadioButton("Como fa\u00E7o para iniciar um processo de altera\u00E7\u00E3o de dados?");
		rdbtnPerg3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg3);
		Perguntaspanel.add(rdbtnPerg3, "cell 0 2");
		
		rdbtnPerg4 = new JRadioButton("Como fa\u00E7o para iniciar um processo de exclus\u00E3o de cadastro?");
		rdbtnPerg4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg4);
		Perguntaspanel.add(rdbtnPerg4, "cell 0 3");
		
		rdbtnPerg5 = new JRadioButton("Como fa\u00E7o para visualizar um relat\u00F3rio?");
		rdbtnPerg5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg5);
		Perguntaspanel.add(rdbtnPerg5, "cell 0 4");
		
		rdbtnPerg6 = new JRadioButton("Como fa\u00E7o para alterar minha senha?");
		rdbtnPerg6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg6);
		Perguntaspanel.add(rdbtnPerg6, "cell 0 5");
		
		rdbtnPerg7 = new JRadioButton("Como fa\u00E7o para iniciar o caixa eletr\u00F4nico?");
		rdbtnPerg7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg7);
		Perguntaspanel.add(rdbtnPerg7, "cell 0 6");
		
		rdbtnPerg8 = new JRadioButton("Como fa\u00E7o para limpar o banco de dados?");
		rdbtnPerg8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg8);
		Perguntaspanel.add(rdbtnPerg8, "cell 0 7");
		
		rdbtnPerg10 = new JRadioButton("Como fa\u00E7o para visualizar as informa\u00E7\u00F5es sobre o software?");
		rdbtnPerg10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		
		rdbtnPerg11 = new JRadioButton("Como fa\u00E7o para realizar Logout?");
		buttonGroup.add(rdbtnPerg11);
		rdbtnPerg11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		
		rdbtnPerg9 = new JRadioButton("Como fa\u00E7o para visualizar as informa\u00E7\u00F5es sobre o tema utilizado?");
		rdbtnPerg9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg9);
		Perguntaspanel.add(rdbtnPerg9, "cell 0 8");
		Perguntaspanel.add(rdbtnPerg11, "cell 0 10");
		buttonGroup.add(rdbtnPerg10);
		Perguntaspanel.add(rdbtnPerg10, "cell 0 9");
		
		rdbtnPerg12 = new JRadioButton("Como fa\u00E7o para sair do programa?");
		rdbtnPerg12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				atualizarResposta();
			}
		});
		buttonGroup.add(rdbtnPerg12);
		Perguntaspanel.add(rdbtnPerg12, "cell 0 11");
		
		JLabel lblImgDogSearch = new JLabel("");
		lblImgDogSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				respostaEditorPane.setText(" Como posso ajudar?");
			}
		});
		lblImgDogSearch.setIcon(new ImageIcon(IgAjuda.class.getResource("/tsi/too/bvb/recursos/imagens/dog_search.png")));
		lblImgDogSearch.setBounds(446, 110, 61, 72);
		contentPane.add(lblImgDogSearch);
		
		JLabel lblCaixaResposta = new JLabel("");
		lblCaixaResposta.setIcon(new ImageIcon(IgAjuda.class.getResource("/tsi/too/bvb/recursos/imagens/caixa de di\u00E1logo.png")));
		lblCaixaResposta.setBounds(10, 85, 447, 122);
		contentPane.add(lblCaixaResposta);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	private void atualizarResposta() {
		if(rdbtnPerg1.isSelected())
			respostaEditorPane.setText(" Selecione a aba correspondente ao tipo de CADASTRO"
					+ "\n que deseja realizar (clientes, funcionários ou agências),"
					+ "\n e clique no botão 'Cadastrar' ou em sua respectiva"
					+ "\n imagem.");
		else if(rdbtnPerg2.isSelected())
			respostaEditorPane.setText(" Selecione a aba correspondente ao tipo de CONSULTA"
					+ "\n que deseja realizar (clientes, funcionários ou agências),"
					+ "\n e clique no botão 'Consultar' ou em sua respectiva"
					+ "\n imagem.");
		else if(rdbtnPerg3.isSelected())
			respostaEditorPane.setText(" Selecione a aba correspondente ao tipo de ALTERAÇÃO"
					+ "\n que deseja realizar (clientes, funcionários ou agências),"
					+ "\n e clique no botão 'Alterar' ou em sua respectiva"
					+ "\n imagem.");
		else if(rdbtnPerg4.isSelected())
			respostaEditorPane.setText(" Selecione a aba correspondente ao tipo de EXCLUSÃO"
					+ "\n que deseja realizar (clientes, funcionários ou agências),"
					+ "\n e clique no botão 'Excluir' ou em sua respectiva"
					+ "\n imagem.");
		else if(rdbtnPerg5.isSelected())
			respostaEditorPane.setText(" Selecione a aba correspondente ao tipo de RELATÓRIO"
					+ "\n que deseja realizar (clientes, funcionários ou agências),"
					+ "\n e clique no botão 'Relatório' ou em sua respectiva"
					+ "\n imagem.");
		else if(rdbtnPerg6.isSelected())
			respostaEditorPane.setText(" Selecione a aba 'outros' e clique no botão 'Alterar"
					+ "\n Senha' ou em sua respectiva imagem.");
		else if(rdbtnPerg7.isSelected())
			respostaEditorPane.setText(" Selecione a aba 'outros' e clique no botão 'Caixa"
					+ "\n Eletrônico' ou em sua respectiva imagem.");
		else if(rdbtnPerg8.isSelected())
			respostaEditorPane.setText(" Selecione o menu 'Arquivo' e clique no item de menu"
					+ "\n 'Limpar Banco de Dados', ou  use as teclas de atalho"
					+ "\n 'Ctrl+Shift+L', então leia atentamente o aviso e"
					+ "\n clique em 'sim'. Vale resaltar que esta operação"
					+ "\n irá excluir permanentemente TODOS os registros do"
					+ "\n banco de dados, e só pode ser realizada por um"
					+ "\n ADMINISTRADOR.");
		else if(rdbtnPerg9.isSelected())
			respostaEditorPane.setText(" Selecione o menu 'Aparência' e clique no item de menu"
					+ "\n 'Tema'. Ou use as teclas de atalho 'Ctrl+Shift+T'.");
		else if(rdbtnPerg10.isSelected())
			respostaEditorPane.setText(" Selecione o menu 'Sobre' e clique no item de menu"
					+ "\n 'Autor'. Ou use as teclas de atalho 'Ctrl+Shift+A'.");
		else if(rdbtnPerg11.isSelected())
			respostaEditorPane.setText(" Selecione o menu 'Arquivo' e clique no item de menu"
					+ "\n 'Logout'. Ou use as teclas de atalho 'Ctrl+L'.");
		else if(rdbtnPerg12.isSelected())
			respostaEditorPane.setText(" Selecione o menu 'Arquivo' e clique no item de menu"
					+ "\n 'Sair'. Ou use as teclas de atalho 'Ctrl+S'.");
	}
	
} // class IgAjuda
