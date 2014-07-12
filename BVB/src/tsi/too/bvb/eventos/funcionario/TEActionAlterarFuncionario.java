package tsi.too.bvb.eventos.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.funcionario.IgAltFuncionario;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.FuncionarioDAO;

public class TEActionAlterarFuncionario implements ActionListener {
	
	private IgAltFuncionario igAltFuncionario;

	public TEActionAlterarFuncionario(IgAltFuncionario igAltFuncionario) {
		super();
		this.igAltFuncionario = igAltFuncionario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igAltFuncionario.getBtnEditarTipo()) {
			if(igAltFuncionario.getFuncionario().getTipoUsuario().getCaractere() !=
			   TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()).getCaractere()) {
				new FuncionarioDAO().alterarTipo(BancoDeDadosBVB.getInstance(), igAltFuncionario.getFuncionario(),
						                         TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()).getCaractere());
	
				new JanelaPopUpInfo(igAltFuncionario, "BVB - Alteração de Funcionário", " Alteração do Tipo do Funcionário Realizada com Sucesso!" ,
				                    " Novo Tipo: " + TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()).getPerfil());
				
				igAltFuncionario.getFuncionario().setTipoUsuario(TipoUsuario.obterTipoUsuario(igAltFuncionario.obterRadioBtnSelecionado()));
			}
		}
		
		else if(e.getSource() == igAltFuncionario.getBtnFinalizar())
			igAltFuncionario.dispose();
	}

} // class TEActionCadastrarFuncionario
