package tsi.too.bvb.eventos.funcionario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTextField;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.gui.funcionario.IgConsultarFuncionario;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.FuncionarioDAO;

public class TETecladoConsultarFuncionario extends KeyAdapter {
	
	private IgConsultarFuncionario igConsultarFuncionario;

	public TETecladoConsultarFuncionario(IgConsultarFuncionario igConsultarFuncionario) {
		super();
		this.igConsultarFuncionario = igConsultarFuncionario;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
		
		if(e.getSource() instanceof JTextField) {
			if ((JTextField)e.getSource() == igConsultarFuncionario.getLoginTextField()) {
				if(!igConsultarFuncionario.getLoginTextField().getText().isEmpty()) {
					String login = igConsultarFuncionario.getLoginTextField().getText();
					List<Funcionario> funcionarios = new FuncionarioDAO().pesquisarLogin(BancoDeDadosBVB.getInstance(), login);
					igConsultarFuncionario.addLinhasTabela(funcionarios);
				}
				else
					igConsultarFuncionario.limpaTabela();
			}
		}
	}
	
} // class TETecladoConsultarFuncionario
