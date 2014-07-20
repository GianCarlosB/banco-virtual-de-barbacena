package tsi.too.bvb.gui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.eventos.login.TEActionLogin;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.FuncionarioDAO;
import tsi.too.bvb.validacoes.Criptografia;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe que define a GUI para o login de funcionário do sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JFrame
 */
public class IgLogin extends JFrame {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = -4269216190339219821L;
	
	private boolean contemTxtLogin = false;
	private boolean contemTxtSenha = false;
	
	private Funcionario funcionario;
	
	private JPanel contentPane;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	private JButton btnFazerLogin;
	private JLabel lblCamposErrados;

	/** Cria uma instância da janela de login de funcionário do sistema BVB
	 */	
	public IgLogin() {
		funcionario = new Funcionario();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				terminarPrograma();
			}
		});
		
		// Cores Flat
		Color peterRiver = new Color(52, 152, 219);
		Color concrete = new Color(127, 140, 141);
		
		setTitle("BVB - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(IgLogin.class.getResource("/tsi/too/bvb/recursos/imagens/BVB - \u00EDcone.png")));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 375);
		contentPane = new JPanel();
		contentPane.setBackground(concrete);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBackground(concrete);
		imgPanel.setBounds(10, 11, 334, 138);
		contentPane.add(imgPanel);
		
		JLabel lblImg = new JLabel("");
		imgPanel.add(lblImg);
		lblImg.setIcon(new ImageIcon(IgLogin.class.getResource("/tsi/too/bvb/recursos/imagens/Windows-8-Login-128.png")));
		lblImg.requestFocusInWindow(); 
		
		JPanel dadosPanel = new JPanel();
		dadosPanel.setBackground(concrete);
		dadosPanel.setBounds(20, 160, 314, 176);
		contentPane.add(dadosPanel);
		dadosPanel.setLayout(null);
		
		btnFazerLogin = new JButton("Fazer Login");
		btnFazerLogin.setMnemonic(KeyEvent.VK_ENTER);
		btnFazerLogin.addActionListener(new TEActionLogin(this));
		btnFazerLogin.setBorder(new LineBorder(Color.WHITE));
		btnFazerLogin.setFont(new Font("Dialog", Font.BOLD, 14));
		btnFazerLogin.setForeground(Color.WHITE);
		btnFazerLogin.setBackground(peterRiver);
		btnFazerLogin.setBounds(10, 130, 294, 35);
		dadosPanel.add(btnFazerLogin);
		
		loginTextField = new JTextField();
		loginTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				desativarPlaceHolderLogin();
			}
		});
		loginTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ativarPlaceHolderLogin();
			}
		});
		loginTextField.setForeground(Color.LIGHT_GRAY);
		loginTextField.setFont(new Font("Dialog", Font.PLAIN, 14));
		loginTextField.setText(" Login");
		loginTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		loginTextField.setColumns(10);
		loginTextField.setBounds(10, 10, 294, 35);
		dadosPanel.add(loginTextField);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ativarPlaceHolderSenha();
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				desativarPlaceHolderSenha();
			}
		});
		passwordField.setForeground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 14));
		passwordField.setText(" Senha");
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setColumns(10);
		passwordField.setBounds(10, 60, 294, 35);
		passwordField.setEchoChar((char)0);
		dadosPanel.add(passwordField);
		
		lblCamposErrados = new JLabel("");
		lblCamposErrados.setVisible(false);
		lblCamposErrados.setForeground(Color.RED);
		lblCamposErrados.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCamposErrados.setBounds(10, 100, 294, 16);
		dadosPanel.add(lblCamposErrados);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/** Finaliza a conexão com o banco de dados e dispõe a janela <code>IgLogin</code>
	 */
	private void terminarPrograma() {
		// Encera o banco de dados.
		BancoDeDadosBVB.encerrarBD();
		
		IgLogin.this.dispose();
		System.exit(0);
	}
	
	/** Verifica se os campos da janela foram preenchidos corretamente. Os campos errados 
	 * recebem uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 *  @throws NoSuchAlgorithmException possível erro disparado quando um algoritmo criptográfico particular é requerido,
	 *  mas não está disponível no ambiente
	 */
	public boolean validarCampos() throws NoSuchAlgorithmException {
		boolean valido = true;
		
		funcionario = new FuncionarioDAO().pesquisarLoginUnico(BancoDeDadosBVB.getInstance(), loginTextField.getText());
		
		if(funcionario != null) {
			loginTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			
			if(!ValidarDados.validarSenhasIguais(Criptografia.converterSenhaParaMD5(new String(passwordField.getPassword())),
					                             funcionario.getSenha())) {
				passwordField.setBorder(new LineBorder(Color.RED));
				setLblCamposErrados(true);
				lblCamposErrados.setText("* A senha inserida está incorreta.");
				valido = false;
			}
			else passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		else {
			loginTextField.setBorder(new LineBorder(Color.RED));
			passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			setLblCamposErrados(true);
			lblCamposErrados.setText("* O login inserido está incorreto.");
			valido = false;
		}
		
		return valido;
	}
	
	/** Insere a borda padrão nos campos da janela
	 */
	public void inserirBordasPadrao() {
		loginTextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}
	
	/** Ativa o place holder no campo de login da janela
	 */
	private void ativarPlaceHolderLogin() {
		if(!ValidarDados.validarVazio(loginTextField.getText())) {
			loginTextField.setForeground(Color.LIGHT_GRAY);
			loginTextField.setText(" Login");
			contemTxtLogin = false;
		}
	}
	
	/** Desativa o place holder no campo de login da janela
	 */
	private void desativarPlaceHolderLogin() {
		if(!contemTxtLogin) {
			loginTextField.setForeground(new Color(51, 51, 51));
			loginTextField.setText("");
			contemTxtLogin = true;
		}
	}
	
	/** Ativa o place holder no campo de senha da janela
	 */
	private void ativarPlaceHolderSenha() {
		if(!ValidarDados.validarVazio(new String(passwordField.getPassword()))) {
			passwordField.setForeground(Color.LIGHT_GRAY);
			passwordField.setEchoChar((char)0);
			passwordField.setText(" Senha");
			contemTxtSenha = false;
		}
	}
	
	/** Desativa o place holder no campo de senha da janela
	 */
	private void desativarPlaceHolderSenha() {
		if(!contemTxtSenha) {
			passwordField.setForeground(new Color(51, 51, 51));
			passwordField.setEchoChar('•');
			passwordField.setText("");
			contemTxtSenha = true;
		}
	}

	/** Retorna um <code>boolean</code> informando se o usuário inseriu algum caractere no 
	 * campo de texto login
	 * @return <code>boolean</code> com <code>true</code> se o usuário tiver inserido algum caractere no 
	 * campo de texto login, e <code>false</code> caso contrário
	 */
	public boolean isContemTxtLogin() {
		return contemTxtLogin;
	}

	/** Retorna um <code>boolean</code> informando se o usuário inseriu algum caractere no 
	 * campo de texto senha
	 * @return <code>boolean</code> com <code>true</code> se o usuário tiver inserido algum caractere no 
	 * campo de texto senha, e <code>false</code> caso contrário
	 */
	public boolean isContemTxtSenha() {
		return contemTxtSenha;
	}

	/** Retorna um <code>JTextField</code> com o campo de texto login
	 * @return <code>JTextField</code> com o campo de texto login
	 */
	public JTextField getLoginTextField() {
		return loginTextField;
	}

	/** Retorna um <code>JPasswordField</code> com o campo de texto senha
	 * @return <code>JPasswordField</code> com o campo de texto senha
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/** Retorna um <code>JButton</code> com o botão fazer login
	 * @return <code>JButton</code> com o botão fazer login
	 */
	public JButton getBtnFazerLogin() {
		return btnFazerLogin;
	}

	/** Retorna um <code>Funcionario</code> com os dados do funcionário logado
	 * @return <code>Funcionario</code> com os dados do funcionário logado
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	/** Muda a visibilidade do rótulo que indica que algum campo não foi corretamente preenchido
	 * @param visivel <code>boolean</code> com <code>true</code> se for visível e <code>false</code> caso contrário
	 */
	public void setLblCamposErrados(boolean visivel) {
		this.lblCamposErrados.setVisible(visivel);
	}
	
} // class IgLogin
