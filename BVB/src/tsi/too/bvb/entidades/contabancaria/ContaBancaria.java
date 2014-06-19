package tsi.too.bvb.entidades.contabancaria;

import java.util.Date;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;

public class ContaBancaria {
	
	private int codAgencia, numConta;
	private TipoConta tipoConta;
	private Date dataAbertura;
	private String cpf, senhaNumerica, senhaAlfabetica;
	private boolean contaSalario;
	private double saldo;
	
	public ContaBancaria() {
		super();
	}
	
	public ContaBancaria(String senhaNumerica, String senhaAlfabetica) {
		this();
		this.senhaNumerica = senhaNumerica;
		this.senhaAlfabetica = senhaAlfabetica;
	}

	public ContaBancaria(int codAgencia, int numConta, TipoConta tipoConta) {
		this();
		this.codAgencia = codAgencia;
		this.numConta = numConta;
		this.tipoConta = tipoConta;
	}

	public ContaBancaria(String cpf, Date dataAbertura, String senhaNumerica,
			String senhaAlfabetica, boolean contaSalario, double saldo) {
		this();
		this.cpf = cpf;
		this.dataAbertura = dataAbertura;
		this.senhaNumerica = senhaNumerica;
		this.senhaAlfabetica = senhaAlfabetica;
		this.contaSalario = contaSalario;
		this.saldo = saldo;
	}

	public ContaBancaria(int codAgencia, int numConta, TipoConta tipoConta,
			String cpf, Date dataAbertura, String senhaNumerica,
			String senhaAlfabetica, boolean contaSalario, double saldo) {
		this();
		this.codAgencia = codAgencia;
		this.numConta = numConta;
		this.tipoConta = tipoConta;
		this.cpf = cpf;
		this.dataAbertura = dataAbertura;
		this.senhaNumerica = senhaNumerica;
		this.senhaAlfabetica = senhaAlfabetica;
		this.contaSalario = contaSalario;
		this.saldo = saldo;
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
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public String getSenhaNumerica() {
		return senhaNumerica;
	}
	
	public void setSenhaNumerica(String senhaNumerica) {
		this.senhaNumerica = senhaNumerica;
	}
	
	public String getSenhaAlfabetica() {
		return senhaAlfabetica;
	}
	
	public void setSenhaAlfabetica(String senhaAlfabetica) {
		this.senhaAlfabetica = senhaAlfabetica;
	}
	
	public boolean isContaSalario() {
		return contaSalario;
	}
	
	public void setContaSalario(boolean contaSalario) {
		this.contaSalario = contaSalario;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void insereMascara() {
		cpf = Mascara.formatarString(cpf, "###.###.###-##");
	}
	
	public void removeMascara() {
		cpf = cpf.replace(".", "").replace("-", "");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Código da Agência: ").append(codAgencia)
				.append("\n Número da Conta: ").append(numConta).append("\n Tipo da Conta: ")
				.append(tipoConta.getDescricao()).append("\n CPF: ").append(cpf)
				.append("\n Data de Abertura: ").append(dataAbertura)
				.append("\n Senha Númerica: ").append(senhaNumerica)
				.append("\n Senha Alfabética: ").append(senhaAlfabetica)
				.append("\n Conta Sálario: ").append(contaSalario)
				.append("\n Saldo: R$").append(saldo);
		return builder.toString();
	}
	
} // class ContaBancaria
