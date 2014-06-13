package tsi.too.bvb.eventos.cliente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.cliente.IgConsultarCliente;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEMouseConsultarCliente extends MouseAdapter {
	
	private IgConsultarCliente igConsultarCliente;

	public TEMouseConsultarCliente(IgConsultarCliente igConsultarCliente) {
		super();
		this.igConsultarCliente = igConsultarCliente;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		
		if(e.getButton() == MouseEvent.BUTTON1) { //botao esquerdo do mouse
			if(e.getSource() == igConsultarCliente.getBtnLimpar())
				igConsultarCliente.limpaTabela();
			if(e.getSource() == igConsultarCliente.getBtnBuscar()) {
				String cpfFormatado = igConsultarCliente.getCpfFormattedTextField().getText();
				String cpf = igConsultarCliente.getCpfFormattedTextField().getText().replace(".", "").replace("-", "");
				
				if(ValidarDados.validarIntPositivo(cpf)) {
					Cliente cliente = new ClienteDAO().pesquisarCpf(BancoDeDadosBVB.getInstance(), cpf);
					
					if(cliente != null) {
						if(!igConsultarCliente.pesquisaTabela(cliente))
							igConsultarCliente.addLinhasTabela(cliente);
						else
							new JanelaPopUpAviso(igConsultarCliente, "Consulta de Cliente", " O cliente de cpf '" +
									             cpfFormatado + "' já foi consultado.");
					}
					else
						new JanelaPopUpAviso(igConsultarCliente, "Consulta de Cliente", " Nenhum cliente com o cpf '" +
								             cpfFormatado + "' foi encontrado.");
				}
				else
					new JanelaPopUpErro(igConsultarCliente, "Consulta de Cliente", " Entrada inválida!\n" +
							             " O campo de busca não pode ser vazio,\n e deve receber 11 valores inteiros e positivos.");
			} // fim if(e.getSource() == igConsultarCliente.getBtnBuscar())
		} // fim if(e.getButton() == MouseEvent.BUTTON1)
	}

} // class TEMouseConsultarCliente
