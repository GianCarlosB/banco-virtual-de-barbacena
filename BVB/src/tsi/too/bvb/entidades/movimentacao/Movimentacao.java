package tsi.too.bvb.entidades.movimentacao;

import java.util.Date;

import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.entidades.tiposenumerados.TipoOperacao;

public class Movimentacao {
	
	private int numConta;
	private int codAgencia;
	private TipoConta tipoConta;
	private TipoOperacao tipoOperacao;
	private Date data;
	private Date hora;
	private double valor;
	
	public Movimentacao() {
		super();
	}

	public Movimentacao(int numConta, int codAgencia, TipoConta tipoConta,
			TipoOperacao tipoOperacao) {
		this();
		this.numConta = numConta;
		this.codAgencia = codAgencia;
		this.tipoConta = tipoConta;
		this.tipoOperacao = tipoOperacao;
	}

	public Movimentacao(Date data, Date hora, double valor) {
		this();
		this.data = data;
		this.hora = hora;
		this.valor = valor;
	}

	public Movimentacao(int numConta, int codAgencia, TipoConta tipoConta,
			TipoOperacao tipoOperacao, Date data, Date hora, double valor) {
		this();
		this.numConta = numConta;
		this.codAgencia = codAgencia;
		this.tipoConta = tipoConta;
		this.tipoOperacao = tipoOperacao;
		this.data = data;
		this.hora = hora;
		this.valor = valor;
	}

	public int getCodAgencia() {
		return codAgencia;
	}

	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Código da Agência: ").append(codAgencia)
				.append("\n Número da Conta: ").append(numConta).append("\n Tipo da Conta: ")
				.append(tipoConta).append("\n Tipo da Operação: ")
				.append(tipoOperacao.getDescricao()).append("\n Data: ").append(data)
				.append("\n Hora: ").append(hora).append("\n Valor: ")
				.append(valor);
		return builder.toString();
	}
	
} // class Movimentacao
