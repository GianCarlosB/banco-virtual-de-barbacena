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

public class TEActionConsultarAgencia implements ActionListener {
	
	private IgConsultarAgencia igConsultarAgencia;

	public TEActionConsultarAgencia(IgConsultarAgencia igConsultarAgencia) {
		super();
		this.igConsultarAgencia = igConsultarAgencia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igConsultarAgencia.getBtnLimpar()) {
			igConsultarAgencia.limpaTabela();
			igConsultarAgencia.limpaCampos();
		}
		else if(e.getSource() == igConsultarAgencia.getBtnBuscar()) {
			String codigo = igConsultarAgencia.getCodigoTextField().getText();
			
			if(ValidarDados.validarIntPositivo(codigo)) {
				Agencia agencia = new AgenciaDAO().pesquisarCodigo(BancoDeDadosBVB.getInstance(), codigo);
				
				if(agencia != null) {
					if(!igConsultarAgencia.pesquisaTabela(agencia))
						igConsultarAgencia.addLinhasTabela(agencia);
					else
						new JanelaPopUpAviso(igConsultarAgencia, "BVB - Consulta de Agência", " A agência de código '" +
								             codigo + "' já foi consultada.");
				}
				else
					new JanelaPopUpAviso(igConsultarAgencia, "BVB - Consulta de Agência", " Nenhuma agência com o código '" +
							             codigo + "' foi encontrada.");
			}
			else
				new JanelaPopUpErro(igConsultarAgencia, "BVB - Consulta de Agência", " Entrada inválida!\n" +
						             " O campo de busca não pode ser vazio,\n e deve receber um valor inteiro e positivo.");
		} // fim if(e.getSource() == igConsultarAgencia.getBtnBuscar())
	}

} // class TEActionConsultarAgencia
