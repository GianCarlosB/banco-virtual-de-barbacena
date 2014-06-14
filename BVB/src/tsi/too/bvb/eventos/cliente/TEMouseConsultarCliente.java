package tsi.too.bvb.eventos.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.cliente.IgConsultarCliente;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEMouseConsultarCliente implements ActionListener {
	
	private IgConsultarCliente igConsultarCliente;

	public TEMouseConsultarCliente(IgConsultarCliente igConsultarCliente) {
		super();
		this.igConsultarCliente = igConsultarCliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igConsultarCliente.getBtnLimpar())
			igConsultarCliente.limpaTabela();
		else if(e.getSource() == igConsultarCliente.getBtnBuscar()) {
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
	}

} // class TEMouseConsultarCliente
