package tsi.too.bvb.eventos.funcionario;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.funcionario.IgConsultarFuncionario;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.FuncionarioDAO;

public class TEMouseConsultarFuncionario extends MouseAdapter {
	
	private IgConsultarFuncionario igConsultarFuncionario;

	public TEMouseConsultarFuncionario(IgConsultarFuncionario igConsultarFuncionario) {
		super();
		this.igConsultarFuncionario = igConsultarFuncionario;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		
		if(e.getButton() == MouseEvent.BUTTON1) { //botao esquerdo do mouse
			if(e.getSource() == igConsultarFuncionario.getBtnLimpar())
				igConsultarFuncionario.limpaTabela();
			if(e.getSource() == igConsultarFuncionario.getBtnBuscar()) {
				List<Funcionario> funcionarios = new FuncionarioDAO().pesquisarTipo(BancoDeDadosBVB.getInstance(), TipoUsuario.obterTipoUsuario
						                                                     (igConsultarFuncionario.getTipoUsuarioComboBox()).getTipo());
				if(!funcionarios.isEmpty())
					igConsultarFuncionario.addLinhasTabela(funcionarios);
				else
					new JanelaPopUpAviso(igConsultarFuncionario, "Consulta de Funcionário", " Nenhum funcionário do tipo '" +
							             igConsultarFuncionario.getTipoUsuarioComboBox() + "' foi encontrado.");
			}
		}
	}
	
} // class TEMouseConsultarFuncionario
