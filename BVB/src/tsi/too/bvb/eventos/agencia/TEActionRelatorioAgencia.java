package tsi.too.bvb.eventos.agencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.entidades.tiposenumerados.Mes;
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.agencia.IgRelatorioAgencia;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ContaBancariaDAO;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEActionRelatorioAgencia implements ActionListener {
	
	private IgRelatorioAgencia igRelatorioAgencia;

	public TEActionRelatorioAgencia(IgRelatorioAgencia igRelatorioAgencia) {
		super();
		this.igRelatorioAgencia = igRelatorioAgencia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igRelatorioAgencia.getBtnBuscar()) {
			if(!igRelatorioAgencia.getCodigoTextField().getText().isEmpty()) {
				if(ValidarDados.validarIntPositivo(igRelatorioAgencia.getCodigoTextField().getText())) {
					if(new ContaBancariaDAO().pesquisarContasAgencia(BancoDeDadosBVB.getInstance(),
					   igRelatorioAgencia.getCodigoTextField().getText()) == null)
						new JanelaPopUpAviso(igRelatorioAgencia, "BVB - Relatório de Agência", " Nenhuma conta bancária foi encontrada na agência" +
								             " de\n código '" + igRelatorioAgencia.getCodigoTextField().getText() + "'.");
					else {
						igRelatorioAgencia.getCodigoTextField().setEnabled(false);
						igRelatorioAgencia.exibeOpcoesGerarRelatorio();
					}
				}
				else
					new JanelaPopUpErro(igRelatorioAgencia, "BVB - Relatório de Agência", " O código de agência '" +
							            igRelatorioAgencia.getCodigoTextField().getText() + "' é inválido!" +
							            "\n O campo de busca deve receber um valor inteiro e positivo.");
			}
			else
				new JanelaPopUpErro(igRelatorioAgencia, "BVB - Relatório de Agência", " Entrada inválida!\n" +
                                    " O campo de busca não pode ser vazio.");
		}
		
		else if(e.getSource() == igRelatorioAgencia.getBtnGerarRelatorio()) {
			// Variáveis que contém as datas em formato String.
			String 	mesIni = (String) igRelatorioAgencia.getMesIniComboBox().getSelectedItem(),
					anoIni = (String) igRelatorioAgencia.getAnoIniComboBox().getSelectedItem(),
					mesFin = (String) igRelatorioAgencia.getMesFinComboBox().getSelectedItem(),
					anoFin = (String) igRelatorioAgencia.getAnoFinComboBox().getSelectedItem();
			
			// Transforma os itens selecionados na caixa de combinação em uma variável do tipo Data.
			Calendar calIni = Calendar.getInstance(),
					 calFin = Calendar.getInstance();
			calIni.set(Calendar.DAY_OF_MONTH, 1);
			calIni.set(Calendar.MONTH, Mes.obterMes(mesIni).getNumero());
			calIni.set(Calendar.YEAR, Integer.parseInt(anoIni));
			
			calFin.set(Calendar.DAY_OF_MONTH, 1);
			calFin.set(Calendar.MONTH, Mes.obterMes(mesFin).getNumero());
			calFin.set(Calendar.YEAR, Integer.parseInt(anoFin));
			
			Date dataIni = (Date) calIni.getTime(), // Data incial.
					 dataFin = (Date) calFin.getTime(), // Data final.
					 data; // Variável para armazenar a data de cada interação no loop que percorre a coleção 'set'.
			
			if(!ValidarDados.validarPeriodo(dataIni, dataFin))
				new JanelaPopUpErro(igRelatorioAgencia, "BVB - Relatório de Agência", " A data inicial não pode ser maior que a data final!");
			else {
				// Variáveis que contém os elementos do relatório.
				String codAgencia = igRelatorioAgencia.getCodigoTextField().getText(),
					   descricaoAgencia = new AgenciaDAO().pesquisarCodigo(BancoDeDadosBVB.getInstance(), igRelatorioAgencia
						                                                   .getCodigoTextField().getText()).getDescricao(),
					   dataFormatada,
				 	   cabecalho = String.format("Agência: %s %-50s Período: %s/%s a %s/%s", descricaoAgencia, " ", mesIni, anoIni, mesFin, anoFin),
					   titulosColunas = String.format("%-20s\t%-30s\t%s", "Tipo de Conta", "Quantidade de Clientes", "Saldo Total (R$)"),
					   separador = "\n---------------------------------------------------------------"
								 + "---------------------------------------------------------------\n",
					   relatorio = cabecalho;
				
				int qtdeClientes[]; // Array de inteiros para armazenar a quantidade de clientes dos 4 tipos de contas.
				double saldoTotal[]; // Array de números reais para armazenar o valor total em reais dos 4 tipos de contas.
	
				ContaBancariaDAO contaBancariaDAO = new ContaBancariaDAO();
				Set<Date> set = contaBancariaDAO.pesquisarDatasContasAgencia(BancoDeDadosBVB.getInstance(), codAgencia, dataIni, dataFin);
				
				if(set == null)
					new JanelaPopUpAviso(igRelatorioAgencia, "BVB - Relatório de Agência", " Nenhuma conta bancária foi encontrada na agência de" +
							             "\n código '" + codAgencia + "', no período de " + mesIni + " de " + anoIni +
							             " a " + mesFin + " de " + anoFin + ".");
				else {
					// Loop para percorrer a coleção 'set' e procurar as contas bancárias.
					for(Iterator<Date> i = set.iterator(); i.hasNext();) {
						data = i.next();
						dataFormatada = new SimpleDateFormat("MM/yyyy").format(data.getTime());
								
						List<ContaBancaria> contasBancarias = contaBancariaDAO.pesquisarContasAgencia(BancoDeDadosBVB.getInstance(),
																									  codAgencia, data);
						
						qtdeClientes = obterQtdeClientesAgencia(contasBancarias);
						saldoTotal = obterSaldoTotalAgencia(contasBancarias);
						
						relatorio += separador + String.format("Mês: %s", dataFormatada) + separador + titulosColunas + separador;
					
						if(qtdeClientes[0] > 0)
							relatorio += String.format("%-30s\t%-50s\t%s\n", "Conta Corrente", qtdeClientes[0], "R$ " + saldoTotal[0]);
						if(qtdeClientes[1] > 0)
							relatorio += String.format("%-30s\t%-50s\t%s\n", "Poupança", qtdeClientes[1], "R$ " + saldoTotal[1]);
						if(qtdeClientes[2] > 0)
							relatorio += String.format("%-30s\t%-50s\t%s\n", "BVB FIF Prático", qtdeClientes[2], "R$ " + saldoTotal[2]);
						if(qtdeClientes[3] > 0)
							relatorio += String.format("%-30s\t%-50s\t%s\n", "BVB FIF Executivo", qtdeClientes[3], "R$ " + saldoTotal[3]);
						
						relatorio += "\n\n";
					} // fim for(Iterator<Date> i = set.iterator(); i.hasNext();)
					
					igRelatorioAgencia.setRelatorioEditorPane(relatorio);
				} // fim else
			} // fim else
		} // fim if(e.getSource() == igRelatorioAgencia.getBtnGerarRelatorio())
		
		else if(e.getSource() == igRelatorioAgencia.getBtnAlterar()) {
			igRelatorioAgencia.getCodigoTextField().setEnabled(true);
			igRelatorioAgencia.escondeOpcoesGerarRelatorio();
		}
	}
	
	private int[] obterQtdeClientesAgencia(List<ContaBancaria> contasBancarias) {
		int qtdeClientes[] = new int[TipoConta.getNumTipos()];
		
		for(ContaBancaria cb : contasBancarias) {
			switch(cb.getTipoConta().getNumero()) {
			case 1: qtdeClientes[0]++; break;
			case 2: qtdeClientes[1]++; break; 
			case 3: qtdeClientes[2]++; break; 
			case 4: qtdeClientes[3]++; break; 
			}
		}
		
		return qtdeClientes;
	}
	
	private double[] obterSaldoTotalAgencia(List<ContaBancaria> contasBancarias) {
		double saldoTotal[] = new double[TipoConta.getNumTipos()];
		
		for(ContaBancaria cb : contasBancarias) {
			switch(cb.getTipoConta().getNumero()) {
			case 1: saldoTotal[0] += cb.getSaldo(); break;
			case 2: saldoTotal[1] += cb.getSaldo(); break; 
			case 3: saldoTotal[2] += cb.getSaldo(); break; 
			case 4: saldoTotal[3] += cb.getSaldo(); break; 
			}
		}
		
		return saldoTotal;
	}

} // class TEActionRelatorioAgencia
