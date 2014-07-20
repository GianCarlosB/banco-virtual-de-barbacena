package tsi.too.bvb.eventos.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.funcionario.IgCadFuncionario;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.FuncionarioDAO;

/** Classe para tratar os eventos de ação da janela <code>IgCadFuncionario</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionCadastrarFuncionario implements ActionListener {
	
	private IgCadFuncionario igCadFuncionario;
	private Funcionario funcionario;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgCadFuncionario</code>
	 * @param igCadFuncionario <code>IgCadFuncionario</code> que será manipulada
	 * @param funcionario <code>Funcionario</code> referênte ao objeto que será manipulado
	 * 
	 * @see Funcionario
	 */
	public TEActionCadastrarFuncionario(IgCadFuncionario igCadFuncionario, Funcionario funcionario) {
		super();
		this.igCadFuncionario = igCadFuncionario;
		this.funcionario = funcionario;
	}
	
	/** Trata os eventos de ação dos elementos da janela <code>IgCadFuncionario</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igCadFuncionario.getBtnLimpar()) {
			igCadFuncionario.limparCampos();
			igCadFuncionario.setLblCamposErrados(false);
		}
		
		else if(e.getSource() == igCadFuncionario.getBtnFinalizar()) {
			if(igCadFuncionario.validarCampos()) {
				igCadFuncionario.setLblCamposErrados(false);
				igCadFuncionario.salvarCampos(funcionario);
				igCadFuncionario.getLoginTextField().setBorder(UIManager.getBorder("TextField.border"));
				igCadFuncionario.getPasswordField().setBorder(UIManager.getBorder("PasswordField.border"));
				igCadFuncionario.getrPasswordField().setBorder(UIManager.getBorder("PasswordField.border"));
				
				new FuncionarioDAO().criar(BancoDeDadosBVB.getInstance(), funcionario);
				
				new JanelaPopUpInfo(igCadFuncionario, "BVB - Cadastro de Funcionário", " Cadastro do Funcionário Realizado com Sucesso!",
						            funcionario.toString());
				igCadFuncionario.dispose();
			}
			else
				igCadFuncionario.setLblCamposErrados(true);
		}
		
		else if(e.getSource() == igCadFuncionario.getBtnVerificar())
			igCadFuncionario.validarLogin();
	}

} // class TEActionCadastrarFuncionario
