package tsi.too.bvb.eventos.agencia;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTextField;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.gui.agencia.IgConsultarAgencia;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

public class TETecladoConsultarAgencia extends KeyAdapter {
	
	private IgConsultarAgencia igConsultarAgencia;

	public TETecladoConsultarAgencia(IgConsultarAgencia igConsultarAgencia) {
		super();
		this.igConsultarAgencia = igConsultarAgencia;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
		
		if(e.getSource() instanceof JTextField) {
			if ((JTextField)e.getSource() == igConsultarAgencia.getDescricaoTextField()) {
				if(!igConsultarAgencia.getDescricaoTextField().getText().isEmpty()) {
					String descricao = igConsultarAgencia.getDescricaoTextField().getText();
					List<Agencia> agencias = new AgenciaDAO().pesquisarDescricao(BancoDeDadosBVB.getInstance(), descricao);
					igConsultarAgencia.addLinhasTabela(agencias);
				}
				else
					igConsultarAgencia.limpaTabela();
			}
		}
	}
	

} // class TETecladoConsultarAgencia
