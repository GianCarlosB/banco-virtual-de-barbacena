package tsi.too.bvb.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.cliente.Contato;
import tsi.too.bvb.entidades.cliente.Endereco;
import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.gui.MenuPrincipal;
import tsi.too.bvb.gui.agencia.IgCadAgencia;
import tsi.too.bvb.gui.cliente.IgCadCliente;
import tsi.too.bvb.gui.funcionario.IgCadFuncionario;

public class TEMouseMenuPrincipal extends MouseAdapter {
	
	private MenuPrincipal menuPrincipal;

	public TEMouseMenuPrincipal(MenuPrincipal menuPrincipal) {
		super();
		this.menuPrincipal = menuPrincipal;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		
		if(e.getButton() == MouseEvent.BUTTON1) { // botão esquerdo do mouse
			
			if((e.getSource() == menuPrincipal.getCadClienteBtn()) || (e.getSource() == menuPrincipal.getCadClienteImgBtn())){
				Cliente cliente = new Cliente(new Contato(), new Endereco());
				IgCadCliente igCadCliente = new IgCadCliente(cliente);
				igCadCliente.setLocationRelativeTo(menuPrincipal);
			}
				
			if((e.getSource() == menuPrincipal.getAltClienteBtn()) || (e.getSource() == menuPrincipal.getAltClienteImgBtn())){}
			
			if((e.getSource() == menuPrincipal.getRelClienteBtn()) || (e.getSource() == menuPrincipal.getRelClienteImgBtn())){}
			
			if((e.getSource() == menuPrincipal.getExClienteBtn()) || (e.getSource() == menuPrincipal.getExClienteImgBtn())){}
			// Fim dos botões cliente.
			
			
			if((e.getSource() == menuPrincipal.getCadFuncBtn()) || (e.getSource() == menuPrincipal.getCadFuncImgBtn())){
				IgCadFuncionario igCadFuncionario = new IgCadFuncionario(new Funcionario());
				igCadFuncionario.setLocationRelativeTo(menuPrincipal);
			}
			
			if((e.getSource() == menuPrincipal.getAltFuncBtn()) || (e.getSource() == menuPrincipal.getAltFuncImgBtn())){}
			
			if((e.getSource() == menuPrincipal.getRelFuncBtn()) || (e.getSource() == menuPrincipal.getRelFuncImgBtn())){}
			
			if((e.getSource() == menuPrincipal.getExFuncBtn()) || (e.getSource() == menuPrincipal.getExFuncImgBtn())){}
			// Fim dos botões do funcionário.
			
			
			if((e.getSource() == menuPrincipal.getCadAgBtn()) || (e.getSource() == menuPrincipal.getCadAgImgBtn())){
				IgCadAgencia igCadAgencia = new IgCadAgencia(new Agencia());
				igCadAgencia.setLocationRelativeTo(menuPrincipal);
			}
			
			if((e.getSource() == menuPrincipal.getAltAgBtn()) || (e.getSource() == menuPrincipal.getAltAgImgBtn())){}
			
			if((e.getSource() == menuPrincipal.getRelAgBtn()) || (e.getSource() == menuPrincipal.getRelAgImgBtn())){}
			
			if((e.getSource() == menuPrincipal.getExAgBtn()) || (e.getSource() == menuPrincipal.getExAgImgBtn())){}
			// Fim dos botões da agência.
			
			
			if(e.getSource() == menuPrincipal.getAjudaImgBtn()){}	
		}
	}
	
} // class TEMouseMenuPrincipal