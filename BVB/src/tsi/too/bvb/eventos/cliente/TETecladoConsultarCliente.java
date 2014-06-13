package tsi.too.bvb.eventos.cliente;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTextField;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.gui.cliente.IgConsultarCliente;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;

public class TETecladoConsultarCliente extends KeyAdapter {
	
	private IgConsultarCliente igConsultarCliente;

	public TETecladoConsultarCliente(IgConsultarCliente igConsultarCliente) {
		super();
		this.igConsultarCliente = igConsultarCliente;
	}

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
