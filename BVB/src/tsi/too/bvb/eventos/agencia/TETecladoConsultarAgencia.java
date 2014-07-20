package tsi.too.bvb.eventos.agencia;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTextField;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.gui.agencia.IgConsultarAgencia;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

/** Classe para tratar os eventos do teclado da janela <code>IgConsultarAgencia</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see KeyAdapter
 */
public class TETecladoConsultarAgencia extends KeyAdapter {
	
	private IgConsultarAgencia igConsultarAgencia;
	
	/** Cria uma instância do Tratador de eventos do teclado da janela <code>IgConsultarAgencia</code>
	 * @param igConsultarAgencia <code>IgConsultarAgencia</code> que será manipulada
	 */
	public TETecladoConsultarAgencia(IgConsultarAgencia igConsultarAgencia) {
		super();
		this.igConsultarAgencia = igConsultarAgencia;
	}

	/** Trata os eventos do teclado dos elementos da janela <code>IgConsultarAgencia</code>
	 * @see KeyAdapter
	 */
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
