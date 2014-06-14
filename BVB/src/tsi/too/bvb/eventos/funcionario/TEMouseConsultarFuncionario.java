package tsi.too.bvb.eventos.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.funcionario.IgConsultarFuncionario;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.FuncionarioDAO;

public class TEMouseConsultarFuncionario implements ActionListener {
	
	private IgConsultarFuncionario igConsultarFuncionario;

	public TEMouseConsultarFuncionario(IgConsultarFuncionario igConsultarFuncionario) {
		super();
		this.igConsultarFuncionario = igConsultarFuncionario;
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				
		if(e.getSource() == igConsultarFuncionario.getBtnLimpar())
			igConsultarFuncionario.limpaTabela();
		else if(e.getSource() == igConsultarFuncionario.getBtnBuscar()) {
			List<Funcionario> funcionarios = new FuncionarioDAO().pesquisarTipo(BancoDeDadosBVB.getInstance(), TipoUsuario.obterTipoUsuario
					                                                     (igConsultarFuncionario.getTipoUsuarioComboBox()).getTipo());
			if(!funcionarios.isEmpty())
				igConsultarFuncionario.addLinhasTabela(funcionarios);
			else
				new JanelaPopUpAviso(igConsultarFuncionario, "Consulta de Funcionário", " Nenhum funcionário do tipo '" +
						             igConsultarFuncionario.getTipoUsuarioComboBox() + "' foi encontrado.");
		}
	}
	
} // class TEMouseConsultarFuncionario
