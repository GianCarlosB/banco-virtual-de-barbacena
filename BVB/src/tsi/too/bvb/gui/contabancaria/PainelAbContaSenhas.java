package tsi.too.bvb.gui.contabancaria;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.validacoes.ValidarDados;

public class PainelAbContaSenhas extends JPanel implements TratadorDeCampos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6747114381339596765L;
	private JPasswordField senhaNumPasswordField;
	private JPasswordField senhaAlfPasswordField;
	private JPasswordField rSenhaNumPasswordField;
	private JPasswordField rSenhaAlfPasswordField;

	/**
	 * Create the panel.
	 */
	public PainelAbContaSenhas() {
		setLayout(null);
		
		JPanel senhaNumPanel = new JPanel();
		senhaNumPanel.setLayout(null);
		senhaNumPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Senha Num\u00E9rica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		senhaNumPanel.setBounds(10, 11, 497, 98);
		add(senhaNumPanel);
		
		JLabel lblSenhaNum = new JLabel("Senha Num\u00E9rica:");
		lblSenhaNum.setBounds(10, 20, 80, 14);
		senhaNumPanel.add(lblSenhaNum);
		lblSenhaNum.setDisplayedMnemonic(KeyEvent.VK_S);
		
		senhaNumPasswordField = new JPasswordField();
		senhaNumPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter 4 d\u00EDgitos decimais");
		senhaNumPasswordField.setBounds(100, 17, 308, 20);
		senhaNumPanel.add(senhaNumPasswordField);
		lblSenhaNum.setLabelFor(senhaNumPasswordField);
		
		JLabel lblRSenhaNum = new JLabel("Repita Senha Num\u00E9rica:");
		lblRSenhaNum.setDisplayedMnemonic(KeyEvent.VK_R);
		lblRSenhaNum.setBounds(10, 56, 80, 14);
		senhaNumPanel.add(lblRSenhaNum);
		
		rSenhaNumPasswordField = new JPasswordField();
		rSenhaNumPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e as senhas devem conferir");
		lblRSenhaNum.setLabelFor(rSenhaNumPasswordField);
		rSenhaNumPasswordField.setBounds(100, 53, 308, 20);
		senhaNumPanel.add(rSenhaNumPasswordField);
		
		JPanel senhaAlfPanel = new JPanel();
		senhaAlfPanel.setLayout(null);
		senhaAlfPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Senha Alfab\u00E9tica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		senhaAlfPanel.setBounds(10, 120, 497, 98);
		add(senhaAlfPanel);
		
		JLabel lblRSenhaAlf = new JLabel("Repita Senha Alfab\u00E9tica:");
		lblRSenhaAlf.setDisplayedMnemonic(KeyEvent.VK_P);
		lblRSenhaAlf.setBounds(10, 56, 80, 14);
		senhaAlfPanel.add(lblRSenhaAlf);
		
		rSenhaAlfPasswordField = new JPasswordField();
		rSenhaAlfPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e as senhas devem conferir");
		lblRSenhaAlf.setLabelFor(rSenhaAlfPasswordField);
		rSenhaAlfPasswordField.setBounds(100, 53, 308, 20);
		senhaAlfPanel.add(rSenhaAlfPasswordField);
		
		JLabel lblSenhaAlf = new JLabel("Senha Alfab\u00E9tica:");
		lblSenhaAlf.setBounds(10, 20, 60, 14);
		senhaAlfPanel.add(lblSenhaAlf);
		lblSenhaAlf.setDisplayedMnemonic(KeyEvent.VK_E);
		
		senhaAlfPasswordField = new JPasswordField();
		senhaAlfPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter 6 letras");
		senhaAlfPasswordField.setBounds(100, 17, 308, 20);
		senhaAlfPanel.add(senhaAlfPasswordField);
		lblSenhaAlf.setLabelFor(senhaAlfPasswordField);
	}

	@Override
	public void limparCampos() {
		senhaNumPasswordField.setText("");
		rSenhaNumPasswordField.setText("");
		senhaAlfPasswordField.setText("");
		rSenhaAlfPasswordField.setText("");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void salvarCampos(Object contaBancaria) {
		((ContaBancaria) contaBancaria).setSenhaNumerica(senhaNumPasswordField.getText());
		((ContaBancaria) contaBancaria).setSenhaAlfabetica(senhaAlfPasswordField.getText());
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean validarCampos() {
		boolean valido = true;
		
		if(!ValidarDados.validarSenhaNumCB(senhaNumPasswordField.getPassword())) {
			senhaNumPasswordField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else senhaNumPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		if(!ValidarDados.validarSenhasIguais(senhaNumPasswordField.getText(), rSenhaNumPasswordField.getText())) {
			rSenhaNumPasswordField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else  rSenhaNumPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		// Fim das validações da senha numérica.
		
		if(!ValidarDados.validarSenhaAlfCB(senhaAlfPasswordField.getPassword())) {
			senhaAlfPasswordField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else senhaAlfPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		
		if(!ValidarDados.validarSenhasIguais(senhaAlfPasswordField.getText(), rSenhaAlfPasswordField.getText())) {
			rSenhaAlfPasswordField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		else rSenhaAlfPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		// Fim das validações da senha alfabética.
		
		return valido;
	}
	
} // class PainelAbContaSenhas
