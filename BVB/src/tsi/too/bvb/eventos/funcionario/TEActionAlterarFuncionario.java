package tsi.too.bvb.eventos.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.funcionario.IgAltFuncionario;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.FuncionarioDAO;

/** Classe para tratar os eventos de ação da janela <code>IgAltFuncionario</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionAlterarFuncionario implements ActionListener {
	
	private IgAltFuncionario igAltFuncionario;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgAltFuncionario</code>
	 * @param igAltFuncionario <code>IgAltFuncionario</code> que será manipulada
	 */
	public TEActionAlterarFuncionario(IgAltFuncionario igAltFuncionario) {
		super();
		this.igAltFuncionario = igAltFuncionario;
	}
	
	/** Trata os eventos de ação dos elementos da janela <code>IgAltFuncionario</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igAltFuncionario.getBtnEditarTipo()) {
			if(igAltFuncionario.getFuncionario().getTipoUsuario().getCaractere() !=
			   TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()).getCaractere()) {
				new FuncionarioDAO().alterarTipo(BancoDeDadosBVB.getInstance(), igAltFuncionario.getFuncionario(),
						                         TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()));
	
				new JanelaPopUpInfo(igAltFuncionario, "BVB - Alteração de Funcionário", " Alteração do Tipo do Funcionário Realizada com Sucesso!" ,
				                    " Novo Tipo: " + TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()).getPerfil());
				
				igAltFuncionario.getFuncionario().setTipoUsuario(TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()));
			}
		}
		
		else if(e.getSource() == igAltFuncionario.getBtnFinalizar())
			igAltFuncionario.dispose();
	}

} // class TEActionCadastrarFuncionario
