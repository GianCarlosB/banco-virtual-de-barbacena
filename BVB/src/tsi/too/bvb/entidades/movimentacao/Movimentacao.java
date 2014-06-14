package tsi.too.bvb.entidades.movimentacao;

import java.sql.Date;

import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.entidades.tiposenumerados.TipoOperacao;

public class Movimentacao {
	
	private int codAgencia, numConta;
	private TipoConta tipoConta;
	private TipoOperacao tipoOperacao;
	private Date data;
	private String hora;
	private double valor;
	
	public Movimentacao() {
		super();
	}

	public Movimentacao(int codAgencia, int numConta, TipoConta tipoConta,
			TipoOperacao tipoOperacao) {
		this();
		this.codAgencia = codAgencia;
		this.numConta = numConta;
		this.tipoConta = tipoConta;
		this.tipoOperacao = tipoOperacao;
	}

	public Movimentacao(Date data, String hora, double valor) {
		this();
		this.data = data;
		this.hora = hora;
		this.valor = valor;
	}

	public Movimentacao(int codAgencia, int numConta, TipoConta tipoConta,
			TipoOperacao tipoOperacao, Date data, String hora, double valor) {
		this();
		this.codAgencia = codAgencia;
		this.numConta = numConta;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
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
				.append(tipoOperacao).append("\n Data: ").append(data)
				.append("\n Hora: ").append(hora).append("\n Valor: ")
				.append(valor);
		return builder.toString();
	}
	
} // class Movimentacao
