package tsi.too.bvb.gui.funcionario;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.eventos.funcionario.TEActionAlterarFuncionario;

public class IgAltFuncionario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5763247405489792683L;
	
	private Funcionario funcionario;
	
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnFinalizar;
	private JRadioButton rdbtnAdministrador;
	private JRadioButton rdbtnCaixa;
	private JRadioButton rdbtnGerente;
	private JButton btnEditarTipo;
	private JTextField loginTextField;
	
	/**
	 * Create the frame.
	 */
	public IgAltFuncionario(Funcionario funcionario, Point point) {
		this.funcionario = funcionario;
		setModal(true);
		Color nephritis = new Color(39, 174, 96);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Altera\u00E7\u00E3o de Funcion\u00E1rio");
		setBounds(100, 100, 523, (int)(506 * 0.55));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 196, 517, 2);
		contentPane.add(separatorBtn);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(nephritis);
		txtpnSubTitulo.setText("Selecione o novo tipo do usu\u00E1rio do funcion\u00E1rio.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 280, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(nephritis);
		txtpnTitulo.setText("Altera\u00E7\u00E3o de Funcion\u00E1rio");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 210, 22);
		contentPane.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon(IgCadFuncionario.class.getResource("/tsi/too/bvb/recursos/imagens/User-48.png")));
		lblImg.setBounds(457, 11, 48, 48);
		contentPane.add(lblImg);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(nephritis);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 207, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setMnemonic(KeyEvent.VK_F);
		btnFinalizar.addActionListener(new TEActionAlterarFuncionario(this));
		Btnpanel.add(btnFinalizar);
		
		JPanel tipoUsuarioPanel = new JPanel();
		tipoUsuarioPanel.setLayout(null);
		tipoUsuarioPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo do Usu\u00E1rio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		tipoUsuarioPanel.setBounds(10, 125, 497, 58);
		contentPane.add(tipoUsuarioPanel);
		
		rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setToolTipText("selecione se desejar alterar o tipo do usu\u00E1rio para administrador e clique no bot\u00E3o editar");
		buttonGroup.add(rdbtnAdministrador);
		rdbtnAdministrador.setSelected(true);
		rdbtnAdministrador.setMnemonic(KeyEvent.VK_A);
		rdbtnAdministrador.setBounds(10, 20, 108, 23);
		tipoUsuarioPanel.add(rdbtnAdministrador);
		
		rdbtnCaixa = new JRadioButton("Caixa");
		rdbtnCaixa.setToolTipText("selecione se desejar alterar o tipo do usu\u00E1rio para caixa e clique no bot\u00E3o editar");
		buttonGroup.add(rdbtnCaixa);
		rdbtnCaixa.setMnemonic(KeyEvent.VK_C);
		rdbtnCaixa.setBounds(120, 20, 58, 23);
		tipoUsuarioPanel.add(rdbtnCaixa);
		
		rdbtnGerente = new JRadioButton("Gerente");
		rdbtnGerente.setToolTipText("selecione se desejar alterar o tipo do usu\u00E1rio para gerente e clique no bot\u00E3o editar");
		buttonGroup.add(rdbtnGerente);
		rdbtnGerente.setMnemonic(KeyEvent.VK_G);
		rdbtnGerente.setBounds(220, 20, 72, 23);
		tipoUsuarioPanel.add(rdbtnGerente);
		
		btnEditarTipo = new JButton("Editar");
		btnEditarTipo.setBounds(396, 20, 89, 23);
		tipoUsuarioPanel.add(btnEditarTipo);
		btnEditarTipo.addActionListener(new TEActionAlterarFuncionario(this));
		btnEditarTipo.setMnemonic(KeyEvent.VK_E);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setDisplayedMnemonic(KeyEvent.VK_L);
		lblLogin.setBounds(10, 95, 60, 14);
		contentPane.add(lblLogin);
		
		loginTextField = new JTextField();
		loginTextField.setText(funcionario.getNomeUsuario());
		loginTextField.setEditable(false);
		lblLogin.setLabelFor(loginTextField);
		loginTextField.setToolTipText("este campo n\u00E3o pode ser alterado");
		loginTextField.setColumns(10);
		loginTextField.setBounds(100, 92, 288, 20);
		contentPane.add(loginTextField);

		if(funcionario.getTipoUsuario().getPerfil().equals(TipoUsuario.ADMINISTRADOR.getPerfil())) rdbtnAdministrador.setSelected(true);
		else if(funcionario.getTipoUsuario().getPerfil().equals(TipoUsuario.CAIXA.getPerfil())) rdbtnCaixa.setSelected(true);
		else rdbtnGerente.setSelected(true);
		
		Point localPoint = new Point(point);
		localPoint.x += 275;
		
		setLocation(localPoint);
		setVisible(true);
	}

	public String obterRadioBtnSelecionado() {
		String radioBtnTxt;
		
		if(rdbtnAdministrador.isSelected())
			radioBtnTxt = rdbtnAdministrador.getText();
		else if(rdbtnCaixa.isSelected())
			radioBtnTxt = rdbtnCaixa.getText();
		else
			radioBtnTxt = rdbtnGerente.getText();
		
		return radioBtnTxt;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public JButton getBtnEditarTipo() {
		return btnEditarTipo;
	}

	public JRadioButton getRdbtnAdministrador() {
		return rdbtnAdministrador;
	}

	public JRadioButton getRdbtnCaixa() {
		return rdbtnCaixa;
	}

	public JRadioButton getRdbtnGerente() {
		return rdbtnGerente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	
} // class IgCadFuncionario
