package tsi.too.bvb.eventos.contabancaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import tsi.too.bvb.entidades.movimentacao.Movimentacao;
import tsi.too.bvb.entidades.tiposenumerados.TipoOperacao;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.contabancaria.IgDepositarSal;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ContaBancariaDAO;
import tsi.too.bvb.persistencia.MovimentacaoDAO;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe para tratar os eventos de ação da janela <code>IgDepositarSal</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionDepositarSal implements ActionListener {
	
	private IgDepositarSal igDepositarSal;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgDepositarSal</code>
	 * @param igDepositarSal <code>IgDepositarSal</code> que será manipulada
	 */
	public TEActionDepositarSal(IgDepositarSal igDepositarSal) {
		super();
		this.igDepositarSal = igDepositarSal;
	}

	/** Trata os eventos de ação dos elementos da janela <code>IgDepositarSal</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igDepositarSal.getBtnBuscar()) {
			if(!igDepositarSal.getNumContaTextField().getText().isEmpty()) {
				if(ValidarDados.validarIntPositivo(igDepositarSal.getNumContaTextField().getText()) &&
				   igDepositarSal.getNumContaTextField().getText().length() <=9) {
					igDepositarSal.setContaBancaria(new ContaBancariaDAO().pesquisarNumConta(BancoDeDadosBVB.getInstance(), igDepositarSal
                                                    .getNumContaTextField().getText()));
					
					if(igDepositarSal.getContaBancaria() == null)
						new JanelaPopUpAviso(igDepositarSal, "BVB - Depósito de Salário", " Nenhuma conta bancária com o número '" +
								             igDepositarSal.getNumContaTextField().getText() + "' foi encontrada.");
					else {
						if(igDepositarSal.getContaBancaria().isContaSalario()) {
							igDepositarSal.getNumContaTextField().setEnabled(false);
							igDepositarSal.exibeOpcoesDepositar();
						} // fim if(igDepositarSal.getContaBancaria().isContaSalario())
						else
							new JanelaPopUpAviso(igDepositarSal, "BVB - Depósito de Salário", " A conta bancária de número '" +
						                         igDepositarSal.getNumContaTextField().getText() + "' não é conta salário." +
						                         "\n Insera o número de uma conta bancária que esteja" +
						                         "\n habilitada a receber salários.");
					} // fim else
				} // fim if(ValidarDados.validarIntPositivo(igDepositarSal.getNumContaTextField().getText()))
				else
					new JanelaPopUpErro(igDepositarSal, "BVB - Depósito de Salário", " O nº de conta bancária '" +
							            igDepositarSal.getNumContaTextField().getText() + "' é inválido!" +
							             "\n O campo de busca deve receber um valor inteiro e positivo" +
							             "\n com no máximo 9 dígitos.");
			} // fim if(!igDepositarSal.getNumContaTextField().getText().isEmpty())
			else
				new JanelaPopUpErro(igDepositarSal, "BVB - Depósito de Salário", " Entrada inválida!\n" +
                                    " O campo de busca não pode ser vazio.");
		} // fim if(e.getSource() == igDepositarSal.getBtnBuscar())
		
		else if(e.getSource() == igDepositarSal.getBtnDepositar()) {
			double deposito = Double.parseDouble(igDepositarSal.getDepositoTextField().getText().replace(",", ".").replace("R", "").replace("$", "")),
			       saldo = igDepositarSal.getContaBancaria().getSaldo();
			
			if(deposito != 0) {
				igDepositarSal.getContaBancaria().setSaldo(saldo + deposito);
				new ContaBancariaDAO().alterarSaldo(BancoDeDadosBVB.getInstance(), igDepositarSal.getContaBancaria());
				new MovimentacaoDAO().criar(BancoDeDadosBVB.getInstance(), new Movimentacao(igDepositarSal.getContaBancaria().getNumConta(),
																							igDepositarSal.getContaBancaria().getCodAgencia(),
																							igDepositarSal.getContaBancaria().getTipoConta(),
																							TipoOperacao.DEPOSITO, new Date(), deposito));
				new JanelaPopUpInfo(igDepositarSal, "BVB - Depósito de Salário", " Depósito realizado com sucesso!");
				
				igDepositarSal.escondeOpcoesDepositar();
				igDepositarSal.getNumContaTextField().setEnabled(true);
			}
			else
				new JanelaPopUpErro(igDepositarSal, "BVB - Depósito de Salário", " O valor do depósito não pode ser igual a '0'!");
		}
		
		else if(e.getSource() == igDepositarSal.getBtnAlterar()) {
			igDepositarSal.getNumContaTextField().setEnabled(true);
			igDepositarSal.escondeOpcoesDepositar();
		}
	}

} // class TEActionDepositarSal
