package tsi.too.bvb.gui.cliente;

import tsi.too.bvb.entidades.cliente.Cliente;

public interface PainelCliente {

	public void limpaCampos();
	
	public void salvarCampos(Cliente cliente);
	
	public boolean validarCampos();
	
} // interface PainelCliente
