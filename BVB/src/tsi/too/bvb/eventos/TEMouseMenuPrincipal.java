package tsi.too.bvb.eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.cliente.Contato;
import tsi.too.bvb.entidades.cliente.Endereco;
import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.gui.IgMenuPrincipal;
import tsi.too.bvb.gui.agencia.IgCadAgencia;
import tsi.too.bvb.gui.agencia.IgConsultarAgencia;
import tsi.too.bvb.gui.cliente.IgCadCliente;
import tsi.too.bvb.gui.cliente.IgConsultarCliente;
import tsi.too.bvb.gui.funcionario.IgCadFuncionario;
import tsi.too.bvb.gui.funcionario.IgConsultarFuncionario;

public class TEMouseMenuPrincipal extends MouseAdapter {
	
	private IgMenuPrincipal igMenuPrincipal;

	public TEMouseMenuPrincipal(IgMenuPrincipal igMenuPrincipal) {
		super();
		this.igMenuPrincipal = igMenuPrincipal;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);

		if(e.getButton() == MouseEvent.BUTTON1) { // botão esquerdo do mouse
			
			if((e.getSource() == igMenuPrincipal.getCadClienteBtn()) || (e.getSource() == igMenuPrincipal.getCadClienteImgBtn())) {
				IgCadCliente igCadCliente = new IgCadCliente(new Cliente(new Contato(), new Endereco()));
				igCadCliente.setLocationRelativeTo(igMenuPrincipal);
			}
			
			if((e.getSource() == igMenuPrincipal.getConsClienteBtn()) || (e.getSource() == igMenuPrincipal.getConsClienteImgBtn())){
				IgConsultarCliente igConsultarCliente = new IgConsultarCliente();
				igConsultarCliente.setLocationRelativeTo(igMenuPrincipal);
			}
				
			if((e.getSource() == igMenuPrincipal.getAltClienteBtn()) || (e.getSource() == igMenuPrincipal.getAltClienteImgBtn())){}
			
			if((e.getSource() == igMenuPrincipal.getExClienteBtn()) || (e.getSource() == igMenuPrincipal.getExClienteImgBtn())){}
			
			if((e.getSource() == igMenuPrincipal.getRelClienteBtn()) || (e.getSource() == igMenuPrincipal.getRelClienteImgBtn())){}
		
			// Fim dos botões cliente.
			
			
			if((e.getSource() == igMenuPrincipal.getCadFuncBtn()) || (e.getSource() == igMenuPrincipal.getCadFuncImgBtn())) {
				IgCadFuncionario igCadFuncionario = new IgCadFuncionario(new Funcionario());
				igCadFuncionario.setLocationRelativeTo(igMenuPrincipal);
			}
			
			if((e.getSource() == igMenuPrincipal.getConsFuncBtn()) || (e.getSource() == igMenuPrincipal.getConsFuncImgBtn())) {
				IgConsultarFuncionario igConsultarFuncionario = new IgConsultarFuncionario();
				igConsultarFuncionario.setLocationRelativeTo(igMenuPrincipal);
			}
			
			if((e.getSource() == igMenuPrincipal.getAltFuncBtn()) || (e.getSource() == igMenuPrincipal.getAltFuncImgBtn())){}
			
			if((e.getSource() == igMenuPrincipal.getExFuncBtn()) || (e.getSource() == igMenuPrincipal.getExFuncImgBtn())){}
			
			if((e.getSource() == igMenuPrincipal.getRelFuncBtn()) || (e.getSource() == igMenuPrincipal.getRelFuncImgBtn())){}
	
			// Fim dos botões do funcionário.
			
			
			if((e.getSource() == igMenuPrincipal.getCadAgBtn()) || (e.getSource() == igMenuPrincipal.getCadAgImgBtn())) {
				IgCadAgencia igCadAgencia = new IgCadAgencia(new Agencia());
				igCadAgencia.setLocationRelativeTo(igMenuPrincipal);
			}
			
			if((e.getSource() == igMenuPrincipal.getConsAgBtn()) || (e.getSource() == igMenuPrincipal.getConsAgImgBtn())) {
				IgConsultarAgencia igConsultarAgencia = new IgConsultarAgencia();
				igConsultarAgencia.setLocationRelativeTo(igMenuPrincipal);
			}
			
			if((e.getSource() == igMenuPrincipal.getAltAgBtn()) || (e.getSource() == igMenuPrincipal.getAltAgImgBtn())){}
			
			if((e.getSource() == igMenuPrincipal.getExAgBtn()) || (e.getSource() == igMenuPrincipal.getExAgImgBtn())){}
			
			if((e.getSource() == igMenuPrincipal.getRelAgBtn()) || (e.getSource() == igMenuPrincipal.getRelAgImgBtn())){}
			
			// Fim dos botões da agência.
			
			
			if(e.getSource() == igMenuPrincipal.getAjudaImgBtn()){}	
		}
	}
	
} // class TEMouseMenuPrincipal