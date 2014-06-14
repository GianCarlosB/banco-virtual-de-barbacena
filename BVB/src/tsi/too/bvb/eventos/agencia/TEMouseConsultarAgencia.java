package tsi.too.bvb.eventos.agencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.agencia.IgConsultarAgencia;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEMouseConsultarAgencia implements ActionListener {
	
	private IgConsultarAgencia igConsultarAgencia;

	public TEMouseConsultarAgencia(IgConsultarAgencia igConsultarAgencia) {
		super();
		this.igConsultarAgencia = igConsultarAgencia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igConsultarAgencia.getBtnLimpar())
			igConsultarAgencia.limpaTabela();
		else if(e.getSource() == igConsultarAgencia.getBtnBuscar()) {
			String codigo = igConsultarAgencia.getCodigoTextField().getText();
			
			if(ValidarDados.validarIntPositivo(codigo)) {
				Agencia agencia = new AgenciaDAO().pesquisarCodigo(BancoDeDadosBVB.getInstance(), codigo);
				
				if(agencia != null) {
					if(!igConsultarAgencia.pesquisaTabela(agencia))
						igConsultarAgencia.addLinhasTabela(agencia);
					else
						new JanelaPopUpAviso(igConsultarAgencia, "Consulta de Agência", " A agência de código '" +
								             codigo + "' já foi cunsultada.");
				}
				else
					new JanelaPopUpAviso(igConsultarAgencia, "Consulta de Agência", " Nenhuma agência com o código '" +
							             codigo + "' foi encontrada.");
			}
			else
				new JanelaPopUpErro(igConsultarAgencia, "Consulta de Agência", " Entrada inválida!\n" +
						             " O campo de busca não pode ser vazio,\n e deve receber um valor inteiro e positivo.");
		} // fim if(e.getSource() == igConsultarAgencia.getBtnBuscar())
	}

} // class TEMouseConsultarAgencia
