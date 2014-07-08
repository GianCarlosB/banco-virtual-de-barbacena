package tsi.too.bvb.gui.funcionario;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.eventos.funcionario.TEActionAltSenhaFuncionario;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.Criptografia;
import tsi.too.bvb.validacoes.ValidarDados;

public class IgAltSenhaFuncionario extends JDialog implements TratadorDeCampos {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2280225669362216887L;
	
	private String senhaAntiga;
	
	private JPanel contentPane;
	private JPasswordField nPasswordField;
	private JButton btnAlterar;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private JLabel lblCamposErrados;
	private JPasswordField rPasswordField;
	private JPasswordField aPasswordField;
	
	/**
	 * Create the frame.
	 */
	public IgAltSenhaFuncionario(Window janelaPai, Funcionario funcionario) {
		this.senhaAntiga = funcionario.getSenha();
		setModal(true);
		Color orange = new Color(243, 156, 18);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("BVB - Altera\u00E7\u00E3o de Senha");
		setBounds(100, 100, 523, (int)(506 * 0.70));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separatorBtn = new JSeparator();
		separatorBtn.setBounds(0, 272, 517, 2);
		contentPane.add(separatorBtn);
		
		JSeparator separatorTitulo = new JSeparator();
		separatorTitulo.setBounds(0, 69, 517, 2);
		contentPane.add(separatorTitulo);
		
		JTextPane txtpnSubTitulo = new JTextPane();
		txtpnSubTitulo.setEditable(false);
		txtpnSubTitulo.setForeground(Color.WHITE);
		txtpnSubTitulo.setBackground(orange);
		txtpnSubTitulo.setText("Insira a senha atual e depois a nova senha.");
		txtpnSubTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnSubTitulo.setBounds(20, 36, 250, 22);
		contentPane.add(txtpnSubTitulo);
		
		JTextPane txtpnTitulo = new JTextPane();
		txtpnTitulo.setEditable(false);
		txtpnTitulo.setForeground(Color.WHITE);
		txtpnTitulo.setBackground(orange);
		txtpnTitulo.setText("Altera\u00E7\u00E3o de Senha");
		txtpnTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTitulo.setBounds(10, 11, 150, 22);
		contentPane.add(txtpnTitulo);
		
		JLabel lblImg = new JLabel("Label Img");
		lblImg.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblImg.setIcon(new ImageIcon(IgAltSenhaFuncionario.class.getResource("/tsi/too/bvb/recursos/imagens/Key-Access-48.png")));
		lblImg.setBounds(459, 11, 48, 48);
		contentPane.add(lblImg);
		
		JEditorPane dtrpnCampoTitulo = new JEditorPane();
		dtrpnCampoTitulo.setBackground(orange);
		dtrpnCampoTitulo.setEditable(false);
		dtrpnCampoTitulo.setBounds(0, 0, 517, 70);
		contentPane.add(dtrpnCampoTitulo);
		
		JPanel Btnpanel = new JPanel();
		Btnpanel.setBounds(0, 283, 517, 43);
		contentPane.add(Btnpanel);
		Btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new TEActionAltSenhaFuncionario(this, funcionario));
		btnAlterar.setMnemonic(KeyEvent.VK_A);
		Btnpanel.add(btnAlterar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new TEActionAltSenhaFuncionario(this, funcionario));
		btnLimpar.setMnemonic(KeyEvent.VK_L);
		Btnpanel.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IgAltSenhaFuncionario.this.dispose();
			}
		});
		btnCancelar.setMnemonic(KeyEvent.VK_C);
		Btnpanel.add(btnCancelar);
		
		lblCamposErrados = new JLabel("* Os campos destacados de vermelho n\u00E3o foram preenchidos corretamente!");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setBounds(10, 247, 497, 14);
		contentPane.add(lblCamposErrados);
		
		JLabel lblAntigaSenha = new JLabel("Antiga Senha:");
		lblAntigaSenha.setDisplayedMnemonic(KeyEvent.VK_N);
		lblAntigaSenha.setBounds(10, 95, 80, 14);
		contentPane.add(lblAntigaSenha);
		
		aPasswordField = new JPasswordField();
		lblAntigaSenha.setLabelFor(aPasswordField);
		aPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter a antiga senha");
		aPasswordField.setBounds(100, 92, 308, 20);
		contentPane.add(aPasswordField);
		
		JPanel novaSenhaPanel = new JPanel();
		novaSenhaPanel.setLayout(null);
		novaSenhaPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nova Senha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		novaSenhaPanel.setBounds(10, 125, 497, 98);
		contentPane.add(novaSenhaPanel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 20, 80, 14);
		novaSenhaPanel.add(lblSenha);
		lblSenha.setDisplayedMnemonic(KeyEvent.VK_S);
		
		JLabel lblRepetirSenha = new JLabel("Repita a Senha:");
		lblRepetirSenha.setBounds(10, 56, 88, 14);
		novaSenhaPanel.add(lblRepetirSenha);
		lblRepetirSenha.setDisplayedMnemonic(KeyEvent.VK_R);
		
		nPasswordField = new JPasswordField();
		nPasswordField.setBounds(130, 17, 308, 20);
		novaSenhaPanel.add(nPasswordField);
		nPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio, deve ser diferente da senha antiga e conter no m\u00EDnimo 6 e no m\u00E1ximo 10 caracteres");
		lblSenha.setLabelFor(nPasswordField);
		
		rPasswordField = new JPasswordField();
		rPasswordField.setBounds(130, 53, 308, 20);
		novaSenhaPanel.add(rPasswordField);
		rPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e as senhas devem conferir");
		lblRepetirSenha.setLabelFor(rPasswordField);
		
		setLocationRelativeTo(janelaPai);
		setVisible(true);
	}
	
	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		aPasswordField.setText("");
		nPasswordField.setText("");
		rPasswordField.setText("");		
	}
	
	@Override
	public void salvarCampos(Object funcionario) {
		try {
			((Funcionario) funcionario).setSenha(new String(Criptografia.converterSenhaParaMD5(new String(nPasswordField.getPassword()))));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
	}

	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		try {
			if(!senhaAntiga.equals(new String(Criptografia.converterSenhaParaMD5(new String(aPasswordField.getPassword()))))) {
				aPasswordField.setBorder(new LineBorder(Color.RED));
				valido = false;
			}
			else aPasswordField.setBorder(UIManager.getBorder("PasswordField.border"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		if(ValidarDados.validarSenhaFunc(nPasswordField.getPassword()) &&
		   !ValidarDados.validarSenhasIguais(aPasswordField.getPassword(), nPasswordField.getPassword())) {
			nPasswordField.setBorder(UIManager.getBorder("PasswordField.border"));
			
			if(!ValidarDados.validarSenhasIguais(nPasswordField.getPassword(), rPasswordField.getPassword())) {
				rPasswordField.setBorder(new LineBorder(Color.RED));
				valido = false;
			}
			else rPasswordField.setBorder(UIManager.getBorder("PasswordField.border"));
		}
		else {
			nPasswordField.setBorder(new LineBorder(Color.RED));
			rPasswordField.setBorder(UIManager.getBorder("PasswordField.border"));
			valido = false;
		}
		
		return valido;
	}
	
	@Override
	public void inserirBordasPadrao() {
		aPasswordField.setBorder(UIManager.getBorder("PasswordField.border"));
		nPasswordField.setBorder(UIManager.getBorder("PasswordField.border"));
		rPasswordField.setBorder(UIManager.getBorder("PasswordField.border"));
	}
	
	public JPasswordField getnPasswordField() {
		return nPasswordField;
	}

	public JButton getBtnAlterar() {
		return btnAlterar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JPasswordField getrPasswordField() {
		return rPasswordField;
	}

	public JPasswordField getaPasswordField() {
		return aPasswordField;
	}

	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}
} // class IgAltSenhaFuncionario
