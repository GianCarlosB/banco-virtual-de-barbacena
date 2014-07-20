package tsi.too.bvb.eventos.cliente;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTextField;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.gui.cliente.IgConsultarCliente;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;

/** Classe para tratar os eventos do teclado da janela <code>IgConsultarCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see KeyAdapter
 */
public class TETecladoConsultarCliente extends KeyAdapter {
	
	private IgConsultarCliente igConsultarCliente;

	/** Cria uma instância do Tratador de eventos do teclado da janela <code>IgConsultarCliente</code>
	 * @param igConsultarCliente <code>IgConsultarCliente</code> que será manipulada
	 */
	public TETecladoConsultarCliente(IgConsultarCliente igConsultarCliente) {
		super();
		this.igConsultarCliente = igConsultarCliente;
	}

	/** Trata os eventos do teclado dos elementos da janela <code>IgConsultarCliente</code>
	 * @see KeyAdapter
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyReleased(e);
		
		if(e.getSource() instanceof JTextField) {
			if ((JTextField)e.getSource() == igConsultarCliente.getNomeTextField()) {
				if(!igConsultarCliente.getNomeTextField().getText().isEmpty()) {
					String nome = igConsultarCliente.getNomeTextField().getText();
					List<Cliente> clientes = new ClienteDAO().pesquisarNome(BancoDeDadosBVB.getInstance(), nome);
					igConsultarCliente.addLinhasTabela(clientes);
				}
				else
					igConsultarCliente.limpaTabela();
			}
		}
	}

} // class TETecladoConsultarCliente
