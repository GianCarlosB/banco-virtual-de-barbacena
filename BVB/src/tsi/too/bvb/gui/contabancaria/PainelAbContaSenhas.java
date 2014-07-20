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

/** Classe que define o painel senhas utilizado pelas janelas <code>IgAbrirContaBancaria</code> e 
 * <code>IgCriarAplicacao</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see JPanel
 * @see IgAbrirContaBancaria
 * @see IgCriarAplicacao
 * @see TratadorDeCampos
 */
public class PainelAbContaSenhas extends JPanel implements TratadorDeCampos {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 6747114381339596765L;
	private JPasswordField senhaNumPasswordField;
	private JPasswordField senhaAlfPasswordField;
	private JPasswordField rSenhaNumPasswordField;
	private JPasswordField rSenhaAlfPasswordField;

	/** Cria uma instância do painel senhas utilizado pelas janelas <code>IgAbrirContaBancaria</code> e 
	 * <code>IgCriarAplicacao</code>
	 */	
	public PainelAbContaSenhas() {
		setLayout(null);
		
		JPanel senhaNumPanel = new JPanel();
		senhaNumPanel.setLayout(null);
		senhaNumPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Senha Num\u00E9rica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		senhaNumPanel.setBounds(10, 11, 497, 98);
		add(senhaNumPanel);
		
		JLabel lblSenhaNum = new JLabel("Senha Num\u00E9rica:");
		lblSenhaNum.setBounds(10, 20, 115, 14);
		senhaNumPanel.add(lblSenhaNum);
		lblSenhaNum.setDisplayedMnemonic(KeyEvent.VK_S);
		
		senhaNumPasswordField = new JPasswordField();
		senhaNumPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter 4 d\u00EDgitos decimais");
		senhaNumPasswordField.setBounds(130, 17, 269, 20);
		senhaNumPanel.add(senhaNumPasswordField);
		lblSenhaNum.setLabelFor(senhaNumPasswordField);
		
		JLabel lblRSenhaNum = new JLabel("Repita Senha:");
		lblRSenhaNum.setDisplayedMnemonic(KeyEvent.VK_R);
		lblRSenhaNum.setBounds(10, 56, 115, 14);
		senhaNumPanel.add(lblRSenhaNum);
		
		rSenhaNumPasswordField = new JPasswordField();
		rSenhaNumPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e as senhas devem conferir");
		lblRSenhaNum.setLabelFor(rSenhaNumPasswordField);
		rSenhaNumPasswordField.setBounds(130, 53, 269, 20);
		senhaNumPanel.add(rSenhaNumPasswordField);
		
		JPanel senhaAlfPanel = new JPanel();
		senhaAlfPanel.setLayout(null);
		senhaAlfPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Senha Alfab\u00E9tica", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		senhaAlfPanel.setBounds(10, 120, 497, 98);
		add(senhaAlfPanel);
		
		JLabel lblRSenhaAlf = new JLabel("Repita Senha:");
		lblRSenhaAlf.setDisplayedMnemonic(KeyEvent.VK_P);
		lblRSenhaAlf.setBounds(10, 56, 115, 14);
		senhaAlfPanel.add(lblRSenhaAlf);
		
		rSenhaAlfPasswordField = new JPasswordField();
		rSenhaAlfPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e as senhas devem conferir");
		lblRSenhaAlf.setLabelFor(rSenhaAlfPasswordField);
		rSenhaAlfPasswordField.setBounds(130, 53, 269, 20);
		senhaAlfPanel.add(rSenhaAlfPasswordField);
		
		JLabel lblSenhaAlf = new JLabel("Senha Alfab\u00E9tica:");
		lblSenhaAlf.setBounds(10, 20, 115, 14);
		senhaAlfPanel.add(lblSenhaAlf);
		lblSenhaAlf.setDisplayedMnemonic(KeyEvent.VK_E);
		
		senhaAlfPasswordField = new JPasswordField();
		senhaAlfPasswordField.setToolTipText("este campo \u00E9 de preenchimento obrigat\u00F3rio e deve conter 6 letras");
		senhaAlfPasswordField.setBounds(130, 17, 269, 20);
		senhaAlfPanel.add(senhaAlfPasswordField);
		lblSenhaAlf.setLabelFor(senhaAlfPasswordField);
	}

	/** Limpa os campos do painel
	 */
	@Override
	public void limparCampos() {
		inserirBordasPadrao();
		
		senhaNumPasswordField.setText("");
		rSenhaNumPasswordField.setText("");
		senhaAlfPasswordField.setText("");
		rSenhaAlfPasswordField.setText("");
	}

	/** Salva os dados inseridos na janela em um objeto do tipo <code>ContaBancaria</code>
	 * @param contaBancaria <code>Object</code> referênte ao objeto que será salvo
	 */
	@Override
	public void salvarCampos(Object contaBancaria) {
		((ContaBancaria) contaBancaria).setSenhaNumerica(new String(senhaNumPasswordField.getPassword()));
		((ContaBancaria) contaBancaria).setSenhaAlfabetica(new String(senhaAlfPasswordField.getPassword()));
	}

	/** Verifica se os campos do painel foram preenchidos corretamente. Os campos errados 
	 * recebem uma borda vermelha
	 *  @return <code>boolean</code> com <code>true</code> caso todos os campos tenham sido preenchidos corretamente, 
	 *  e <code>false</code> caso contrário
	 */
	@Override
	public boolean validarCampos() {
		boolean valido = true;

		if(ValidarDados.validarSenhaNumCB(new String(senhaNumPasswordField.getPassword()))) {
			senhaNumPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
			
			if(!ValidarDados.validarSenhasIguais(senhaNumPasswordField.getPassword(), rSenhaNumPasswordField.getPassword())) {
				rSenhaNumPasswordField.setBorder(new LineBorder(Color.RED));
				valido = false;
			}
			else  rSenhaNumPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		}
		else {
			senhaNumPasswordField.setBorder(new LineBorder(Color.RED));
			rSenhaNumPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
			valido = false;
		}
		// Fim das validações da senha numérica.
		
		if(ValidarDados.validarSenhaAlfCB(new String(senhaAlfPasswordField.getPassword()))) {
			senhaAlfPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));

			if(!ValidarDados.validarSenhasIguais(senhaAlfPasswordField.getPassword(), rSenhaAlfPasswordField.getPassword())) {
				rSenhaAlfPasswordField.setBorder(new LineBorder(Color.RED));
				valido = false;
			}
			else rSenhaAlfPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		}
		else {
			senhaAlfPasswordField.setBorder(new LineBorder(Color.RED));
			rSenhaAlfPasswordField.setBorder(new LineBorder(Color.RED));
			valido = false;
		}
		// Fim das validações da senha alfabética.
		
		return valido;
	}

	/** Insere a borda padrão nos campos do painel
	 */
	@Override
	public void inserirBordasPadrao() {
		senhaNumPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		rSenhaNumPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		senhaAlfPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
		rSenhaAlfPasswordField.setBorder(UIManager.getBorder("FormattedTextField.border"));
	}
	
} // class PainelAbContaSenhas
