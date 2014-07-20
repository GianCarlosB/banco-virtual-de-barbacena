package tsi.too.bvb.eventos.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.entidades.tiposenumerados.Mes;
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.cliente.IgRelatorioCliente;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.persistencia.ContaBancariaDAO;

/** Classe para tratar os eventos de ação da janela <code>IgRelatorioCliente</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionRelatorioCliente implements ActionListener {
	
	private IgRelatorioCliente igRelatorioCliente;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgRelatorioCliente</code>
	 * @param igRelatorioCliente <code>IgRelatorioCliente</code> que será manipulada
	 */
	public TEActionRelatorioCliente(IgRelatorioCliente igRelatorioCliente) {
		super();
		this.igRelatorioCliente = igRelatorioCliente;
	}

	/** Trata os eventos de ação dos elementos da janela <code>IgRelatorioCliente</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igRelatorioCliente.getBtnGerarRelatorio()) {
			// Variáveis que contém os elementos do relatório.
			String titulosColunas = String.format("%-40s\t%-40s\t%s", "Nome", "Agência – Número", "Data de Abertura"),
				   separador = "\n---------------------------------------------------------------"
							 + "---------------------------------------------------------------\n",
				   relatorio = "",
				   mes = (String) igRelatorioCliente.getMesComboBox().getSelectedItem(),
				   ano = (String) igRelatorioCliente.getAnoComboBox().getSelectedItem(),
				   dataFormatada;
			
			// Transforma os itens selecionados na caixa de combinação em uma variável do tipo Data.
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.MONTH, Mes.obterMes(mes).getNumero());
			cal.set(Calendar.YEAR, Integer.parseInt(ano));
			
			ClienteDAO clienteDAO = new ClienteDAO();
			AgenciaDAO agenciaDAO = new AgenciaDAO();
			
			Cliente cliente;
			Agencia agencia;
			
			List<ContaBancaria> contasBancarias = new ContaBancariaDAO().pesquisarContas(BancoDeDadosBVB.getInstance(), cal.getTime());
			
			if(contasBancarias == null)
				new JanelaPopUpAviso(igRelatorioCliente, "BVB - Relatório de Cliente", " Nenhuma conta bancária foi aberta em " + 
							         mes + " de " + ano + ".");
			else {
				List<ContaBancaria>[] cbList = separarListaCB(contasBancarias);
				
				// Loop para percorrer as 4 posições da lista de tipos de contas bancárias.
				for(int i = 0; i < TipoConta.getNumTipos(); i++) {
					if(!cbList[i].isEmpty()) // Se a lista não estiver vazia.
						relatorio += String.format("Mês: %s/%s - %s", mes, ano, TipoConta.obterTipoConta(i + 1).getDescricao()) +
							                       separador + titulosColunas + separador;
					
					// Loop para percorrer a lista do tipo corrente.
					for(ContaBancaria cb : cbList[i]) {
						cliente = clienteDAO.pesquisarCpf(BancoDeDadosBVB.getInstance(), cb.getCpf());
						agencia = agenciaDAO.pesquisarCodigo(BancoDeDadosBVB.getInstance(), Integer.toString(cb.getCodAgencia()));
						dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(cb.getDataAbertura());
						
						relatorio += String.format("%-30s\t%s - %-30s\t%s\n",  cliente.getNome(), agencia.getDescricao(),
								                   cb.getNumConta(), dataFormatada);
					} // fim for(ContaBancaria cb : cbList[i])
					
					if(!cbList[i].isEmpty()) // Se a lista não estiver vazia.
						relatorio += "\n\n";
				} // fim for(int i = 0; i < TipoConta.getNumTipos(); i++)
				
				igRelatorioCliente.setRelatorioEditorPane(relatorio);
			} // fim else
		} // fim if(e.getSource() == IgRelatorioCliente.getBtnGerarRelatorio())
	}
	
	/** Separa uma lista <code>List</code> de contas bancárias por tipo
	 * @param contasBancarias <code>List</code> do tipo <code>ContaBancaria</code> com as contas bancárias
	 * @return uma <code>List[]</code> do tipo <code>ContaBancaria</code> de 4 posições com um <code>ArrayList</code>
	 * em cada posição contendo cada tipo de conta bancária
	 * 
	 * @see List
	 * @see ArrayList
	 * @see ContaBancaria
	 * @see TipoConta
	 */
	@SuppressWarnings("unchecked")
	private List<ContaBancaria>[] separarListaCB(List<ContaBancaria> contasBancarias) {
		List<ContaBancaria> cbList[] = new ArrayList[TipoConta.getNumTipos()];
		
		cbList[0] = new ArrayList<ContaBancaria>();
		cbList[1] = new ArrayList<ContaBancaria>();
		cbList[2] = new ArrayList<ContaBancaria>();
		cbList[3] = new ArrayList<ContaBancaria>();
		
		for(ContaBancaria cb : contasBancarias) {
			switch(cb.getTipoConta().getNumero()) {
			case 1: cbList[0].add(cb); break;
			case 2: cbList[1].add(cb); break; 
			case 3: cbList[2].add(cb); break; 
			case 4: cbList[3].add(cb); break; 
			}
		}
		
		return cbList;
	}

} // class TEActionRelatorioCliente
