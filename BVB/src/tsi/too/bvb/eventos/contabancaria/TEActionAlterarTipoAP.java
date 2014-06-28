package tsi.too.bvb.eventos.contabancaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.JanelaPopUpPergunta;
import tsi.too.bvb.gui.contabancaria.IgAlterarTipoAplicacao;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ContaBancariaDAO;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEActionAlterarTipoAP implements ActionListener {
	
	private IgAlterarTipoAplicacao igAlterarTipoAplicacao;

	public TEActionAlterarTipoAP(IgAlterarTipoAplicacao igAlterarTipoAplicacao) {
		super();
		this.igAlterarTipoAplicacao = igAlterarTipoAplicacao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igAlterarTipoAplicacao.getBtnBuscar()) {
			if(!igAlterarTipoAplicacao.getNumContaTextField().getText().isEmpty()) {
				if(ValidarDados.validarIntPositivo(igAlterarTipoAplicacao.getNumContaTextField().getText())) {
					igAlterarTipoAplicacao.setContaBancaria(new ContaBancariaDAO().pesquisarNumConta(BancoDeDadosBVB.getInstance(), igAlterarTipoAplicacao
                                                            .getNumContaTextField().getText()));
					
					if(igAlterarTipoAplicacao.getContaBancaria() == null)
						new JanelaPopUpAviso(igAlterarTipoAplicacao, "BVB - Alteração do Tipo da Aplicação", " Nenhuma conta bancária com o número '" +
								             igAlterarTipoAplicacao.getNumContaTextField().getText() + "' foi encontrada.");
					else {
						if(igAlterarTipoAplicacao.getContaBancaria().getTipoConta() == TipoConta.FIF_PRATICO) {
							if(igAlterarTipoAplicacao.getContaBancaria().getSaldo() >= 15000) {
								igAlterarTipoAplicacao.setSaldoTextField(Double.toString(igAlterarTipoAplicacao.getContaBancaria().getSaldo()));
								igAlterarTipoAplicacao.getNumContaTextField().setEnabled(false);
								igAlterarTipoAplicacao.exibeOpcoesAtualizar();
							} // fim if(igAlterarTipoAplicacao.getContaBancaria().getSaldo() >= 15000)
							else
								new JanelaPopUpAviso(igAlterarTipoAplicacao, "BVB - Alteração do Tipo da Aplicação", " A conta bancária de número '" +
				                         igAlterarTipoAplicacao.getNumContaTextField().getText() + "' não possui saldo suficiente" +
				                         "\n para ser modificada para BVB FIF Executivo." +
				                         "\n Insera o número de uma conta bancária com saldo" +
				                         "\n igual ou superior a R$ 15.000,00.");
						} // fim if(igAlterarTipoAplicacao.getContaBancaria().getTipoConta() == TipoConta.FIF_PRATICO)
						else
							new JanelaPopUpAviso(igAlterarTipoAplicacao, "BVB - Alteração do Tipo da Aplicação", " A conta bancária de número '" +
			                         igAlterarTipoAplicacao.getNumContaTextField().getText() + "' não é do tipo de aplicação" +
			                         "\n financeira BVB FIF Prático." +
			                         "\n Insera o número de uma conta bancária do tipo" +
			                         "\n BVB FIF Prático.");
					} // fim else
				} // fim if(ValidarDados.validarIntPositivo(igAlterarTipoAplicacao.getNumContaTextField().getText()))
				else
					new JanelaPopUpErro(igAlterarTipoAplicacao, "BVB - Alteração do Tipo da Aplicação", " O nº de conta bancária '" +
							            igAlterarTipoAplicacao.getNumContaTextField().getText() + "' é inválido!" +
							             "\n O campo de busca deve receber um valor inteiro e positivo.");
			} // fim if(!igAlterarTipoAplicacao.getNumContaTextField().getText().isEmpty())
			else
				new JanelaPopUpErro(igAlterarTipoAplicacao, "BVB - Alteração do Tipo da Aplicação", " Entrada inválida!\n" +
                                    " O campo de busca não pode ser vazio.");
		} // fim if(e.getSource() == igAlterarTipoAplicacao.getBtnBuscar())
		
		else if(e.getSource() == igAlterarTipoAplicacao.getBtnDepositar()) {
			JanelaPopUpPergunta janelaPopUpPergunta = new JanelaPopUpPergunta(igAlterarTipoAplicacao, "BVB - Alteração do Tipo da Aplicação",
					" Esta operação irá alterar permanentemente o tipo da conta"
					+ "\n de BVB FIF Prático para BVB FIF Executivo."
					+ "\n\n Deseja continuar assim mesmo?");
			
			if(janelaPopUpPergunta.isSim()) {
				igAlterarTipoAplicacao.getContaBancaria().setTipoConta(TipoConta.FIF_EXECUTIVO);
				new ContaBancariaDAO().alterarTipoConta(BancoDeDadosBVB.getInstance(), igAlterarTipoAplicacao.getContaBancaria());
				new JanelaPopUpInfo(igAlterarTipoAplicacao, "BVB - Alteração do Tipo da Aplicação",
						            " Tipo da conta de aplicação financeira alterada com sucesso!");
				
				igAlterarTipoAplicacao.escondeOpcoesAtualizar();
				igAlterarTipoAplicacao.getNumContaTextField().setEnabled(true);
			}
		}
		
		else if(e.getSource() == igAlterarTipoAplicacao.getBtnAlterar()) {
			igAlterarTipoAplicacao.escondeOpcoesAtualizar();
			igAlterarTipoAplicacao.getNumContaTextField().setEnabled(true);
		}
	}

} // class TEActionAlterarTipoAP
