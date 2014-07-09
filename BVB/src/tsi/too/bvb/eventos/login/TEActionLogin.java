package tsi.too.bvb.eventos.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.UIManager;

import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.login.IgLogin;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

public class TEActionLogin implements ActionListener {
	
	private IgLogin igLogin;

	public TEActionLogin(IgLogin igLogin) {
		super();
		this.igLogin = igLogin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igLogin.getBtnFazerLogin() && (igLogin.isContemTxtLogin() && igLogin.isContemTxtSenha())) {
			if(BancoDeDadosBVB.getInstance().getConn() != null) {
				try {
					if(igLogin.validarCampos()) {
						igLogin.getLoginTextField().setBorder(UIManager.getBorder("TextField.border"));
						igLogin.getPasswordField().setBorder(UIManager.getBorder("PasswordField.border"));
						igLogin.setLblCamposErrados(false);
						
						igLogin.dispose();
					}
				} catch (NoSuchAlgorithmException eNSA) {
					// TODO Auto-generated catch block
					new JanelaPopUpErro(null, "BVB - ERRO", eNSA);
				}
			}
			else
				new JanelaPopUpErro(igLogin, "BVB - ERRO", " A conexão com o banco de dados não foi estabelecida!\n" +
			                        " Para realizar login reinicie a aplicação!");
		}
	}

} // class TEActionCadastrarFuncionario
