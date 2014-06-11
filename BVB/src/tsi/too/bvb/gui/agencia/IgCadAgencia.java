package tsi.too.bvb.gui.agencia;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.eventos.agencia.TEMouseCadastrarAgencia;
import java.awt.Color;

public class IgCadAgencia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3879979808799859918L;
	
	private JPanel contentPane;
	private JTextField codigoTextField;
	private JButton btnFinalizar;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JEditorPane descricaoEditorPane;
	private JLabel lblCamposErrados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new IgCadAgencia(new Agencia());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IgCadAgencia(Agencia agencia) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Novo Cadastro de Ag\u00EAncia");
		setBounds(100, 100, 523, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 4);
		contentPane.add(separatorTitulo);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 424, 517, 2);
		contentPane.add(separatorBtn);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setIcon(new ImageIcon("src\\tsi\\too\\bvb\\recursos\\imagens\\commerical-building.png"));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setText("Insera a descri\u00E7\u00E3o da nova ag\u00EAncia.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnSubTitulo.setBounds(20, 36, 210, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setText("Cadastro de Ag\u00EAncia");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPane.add(txtpnTitulo);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 435, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addMouseListener(new TEMouseCadastrarAgencia(this, agencia));
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		Btnpanel.add(btnFinalizar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new TEMouseCadastrarAgencia(this, agencia));
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		Btnpanel.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgCadAgencia.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		Btnpanel.add(btnCancelar);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setDisplayedMnemonic(KeyEvent.VK_O);
		lblCodigo.setBounds(10, 95, 60, 14);
		contentPane.add(lblCodigo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panel.setBounds(10, 145, 497, 154);
		contentPane.add(panel);
		
		JLabel lblDescricao = new JLabel("Nome da cidade onde a ag\u00EAncia se localiza e demais descri\u00E7\u00F5es:");
		lblDescricao.setDisplayedMnemonic(KeyEvent.VK_D);
		lblDescricao.setBounds(10, 20, 380, 14);
		panel.add(lblDescricao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 477, 98);
		panel.add(scrollPane);
		
		descricaoEditorPane = new JEditorPane();
		descricaoEditorPane.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio");
		lblDescricao.setLabelFor(descricaoEditorPane);
		scrollPane.setViewportView(descricaoEditorPane);
		
		codigoTextField = new JTextField();
		codigoTextField.setToolTipText("este campo \u00E9 gerado automaticamente");
		lblCodigo.setLabelFor(codigoTextField);
		codigoTextField.setText("O c\u00F3digo da ag\u00EAncia \u00E9 gerado automaticamente");
		codigoTextField.setEnabled(false);
		codigoTextField.setEditable(false);
		codigoTextField.setColumns(10);
		codigoTextField.setBounds(80, 92, 308, 20);
		contentPane.add(codigoTextField);
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setBounds(10, 399, 497, 14);
		contentPane.add(lblCamposErrados);
		
		setVisible(true);
	}
	
	public void salvarCampos(Agencia agencia) {
		agencia.setDescricao(descricaoEditorPane.getText());
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setCodigoTextField(String codAgencia) {
		this.codigoTextField.setText(codAgencia);
	}

	public JEditorPane getDescricaoEditorPane() {
		return descricaoEditorPane;
	}

	public void setDescricaoEditorPane(String descricao) {
		this.descricaoEditorPane.setText(descricao);
	}

	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}
	
} // class IgCadAgencia
