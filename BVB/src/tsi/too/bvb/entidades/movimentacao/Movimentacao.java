package tsi.too.bvb.entidades.movimentacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.entidades.tiposenumerados.TipoOperacao;

/** A classe <code>Movimentacao</code> manipula dados referênte as movimentações das contas bancárias do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class Movimentacao {
	
	private int numConta;
	private int codAgencia;
	private TipoConta tipoConta;
	private TipoOperacao tipoOperacao;
	private Date dataHora;
	private double valor;
	
	/** Cria uma movimentação sem nem um atributo
	 */
	public Movimentacao() {
		super();
	}
	
	/** Cria uma movimentação com o número da conta bancária, código da agência, tipo da conta, tipo da operação, data, hora e valor
	 * 
	 * @param numConta <code>int</code> com o número da conta bancária movimentada
	 * @param codAgencia <code>int</code> com o código da agência da conta bancária movimentada
	 * @param tipoConta <code>TipoConta</code> com o tipo da conta bancária movimentada
	 * @param tipoOperacao <code>TipoOperacao</code> com o tipo de operação da movimentação
	 * @param dataHora <code>Date</code> com a data e a hora da movimentação
	 * @param valor <code>double</code> com o valor da movimentação
	 * 
	 * @see TipoConta
	 * @see TipoOperacao
	 */
	public Movimentacao(int numConta, int codAgencia, TipoConta tipoConta,
			TipoOperacao tipoOperacao, Date dataHora, double valor) {
		this();
		this.numConta = numConta;
		this.codAgencia = codAgencia;
		this.tipoConta = tipoConta;
		this.tipoOperacao = tipoOperacao;
		this.dataHora = dataHora;
		this.valor = valor;
	}

	/** Retorna um <code>int</code> com o número da conta bancária movimentada
	 * @return <code>int</code> com o número da conta bancária movimentada
	 */
	public int getCodAgencia() {
		return codAgencia;
	}

	/** Muda o número da conta bancária movimentada
	 * @param codAgencia <code>int</code> com o novo número da conta bancária movimentada
	 */
	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}

	/** Retorna um <code>int</code> com o código da agência da conta bancária movimentada
	 * @return <code>int</code> com o código da agência da conta bancária movimentada
	 */
	public int getNumConta() {
		return numConta;
	}

	/** Muda o código da agência da conta bancária movimentada
	 * @param numConta <code>int</code> com o novo código da agência da conta bancária movimentada
	 */
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	/** Retorna um <code>TipoConta</code> com o tipo da conta bancária movimentada
	 * @return <code>TipoConta</code> com o tipo da conta bancária movimentada
	 */
	public TipoConta getTipoConta() {
		return tipoConta;
	}

	/** Muda o tipo da conta bancária movimentada
	 * @param tipoConta <code>TipoConta</code> com o novo tipo da conta bancária movimentada
	 */
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	/** Retorna um <code>TipoOperacao</code> com o tipo de operação da movimentação
	 * @return <code>TipoOperacao</code> com o novo tipo de operação da movimentação
	 */
	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	/** Muda o tipo de operação da movimentação
	 * @param tipoOperacao <code>TipoOperacao</code> com o novo tipo de operação da movimentação
	 */
	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	/** Retorna um <code>Date</code> com a data e a hora da movimentação
	 * @return <code>Date</code> com a data e a hora da movimentação
	 */
	public Date getDataHora() {
		return dataHora;
	}

	/** Muda a data e a hora da movimentação
	 * @param dataHora <code>Date</code> com a nova data e a hora da movimentação
	 */
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	/** Retorna um <code>double</code> com o valor da movimentação
	 * @return <code>double</code> com o valor da movimentação
	 */
	public double getValor() {
		return valor;
	}

	/** Muda o valor da movimentação
	 * @param valor <code>double</code> com o novo valor da movimentação
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/** Retorna uma <code>String</code> com todos os dados da movimentação
	 * @return <code>String</code> com todos os dados da movimentação
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Código da Agência: ").append(codAgencia)
				.append("\n Número da Conta: ").append(numConta).append("\n Tipo da Conta: ")
				.append(tipoConta).append("\n Tipo da Operação: ")
				.append(tipoOperacao.getDescricao()).append("\n Data: ").append(new SimpleDateFormat("dd/MM/yyyy").format(dataHora))
				.append("\n Hora: ").append(new SimpleDateFormat("HH:mm:ss").format(dataHora)).append("\n Valor: ")
				.append(valor);
		return builder.toString();
	}
	
} // class Movimentacao
