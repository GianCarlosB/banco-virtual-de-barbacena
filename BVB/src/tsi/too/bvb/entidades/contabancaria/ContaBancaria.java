package tsi.too.bvb.entidades.contabancaria;

import java.text.SimpleDateFormat;
import java.util.Date;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.validacoes.ValidarDados;

/** A classe <code>ContaBancaria</code> manipula dados referênte as contas bancárias do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class ContaBancaria {
	
	private int numConta;
	private int codAgencia;
	private TipoConta tipoConta;
	private Date dataAbertura;
	private String cpf;
	private String senhaNumerica;
	private String senhaAlfabetica;
	private boolean contaSalario;
	private double saldo;
	
	/** Cria uma conta bancária sem nem um atributo
	 */
	public ContaBancaria() {
		super();
	}

	/** Cria uma conta bancária com o número da conta, código d agência, tipo da conta, cpf do cliente, data de abertura, 
	 * senha numérica, senha alfabética, se é ou não conta salário e o saldo
	 * 
	 * @param numConta <code>int</code> com o número da conta bancária
	 * @param codAgencia <code>int</code> com o código da agência da conta bancária
	 * @param tipoConta <code>TipoConta</code> com o tipo da conta bancária
	 * @param cpf <code>String</code> com o cpf do cliente proprietário da conta bancária
	 * @param dataAbertura <code>Date</code> com a data de abertura da conta bancária
	 * @param senhaNumerica <code>String</code> com a senha numérica da conta bancária
	 * @param senhaAlfabetica <code>String</code> com a senha alfabética da conta bancária
	 * @param contaSalario <code>boolean</code> com <code>true</code> se a conta bancária for conta salário e <code>false</code> caso contrário
	 * @param saldo <code>double</code> com o saldo da conta bancária
	 * 
	 * @see TipoConta
	 */
	public ContaBancaria(int numConta, int codAgencia, TipoConta tipoConta,
			String cpf, Date dataAbertura, String senhaNumerica,
			String senhaAlfabetica, boolean contaSalario, double saldo) {
		this();
		this.numConta = numConta;
		this.codAgencia = codAgencia;
		this.tipoConta = tipoConta;
		this.cpf = cpf;
		this.dataAbertura = dataAbertura;
		this.senhaNumerica = senhaNumerica;
		this.senhaAlfabetica = senhaAlfabetica;
		this.contaSalario = contaSalario;
		this.saldo = saldo;
	}

	/** Retorna um <code>int</code> com o código da agência da conta bancária
	 * @return <code>int</code> com o código da agência da conta bancária
	 */
	public int getCodAgencia() {
		return codAgencia;
	}
	
	/** Muda o código da agência da conta bancária
	 * @param codAgencia <code>int</code> com o novo código da agência da conta bancária
	 */
	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}
	
	/** Retorna um <code>int</code> com o número da conta bancária
	 * @return <code>int</code> com o número da conta bancária
	 */
	public int getNumConta() {
		return numConta;
	}
	
	/** Muda o número da conta bancária
	 * @param numConta <code>int</code> com o novo número da conta bancária
	 */
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	
	/** Retorna um <code>TipoConta</code> com o tipo da conta bancária
	 * @return <code>TipoConta</code> com o tipo da conta bancária
	 */
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	
	/** Muda o tipo da conta bancária
	 * @param tipoConta <code>TipoConta</code> com o novo tipo da conta bancária
	 */
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	/** Retorna um <code>String</code> com o cpf do cliente proprietário da conta bancária
	 * @return <code>String</code> com o cpf do cliente proprietário da conta bancária
	 */
	public String getCpf() {
		return cpf;
	}
	
	/** Muda o cpf do cliente proprietário da conta bancária
	 * @param cpf <code>String</code> com o novo cpf do cliente proprietário da conta bancária
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/** Retorna um <code>Date</code> com a data de abertura da conta bancária
	 * @return <code>Date</code> com a data de abertura da conta bancária
	 */
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	/** Muda a data de abertura da conta bancária
	 * @param dataAbertura <code>Date</code> com a nova data de abertura da conta bancária
	 */
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	/** Retorna um <code>String</code> com a senha numérica da conta bancária
	 * @return <code>String</code> com a senha numérica da conta bancária
	 */
	public String getSenhaNumerica() {
		return senhaNumerica;
	}
	
	/** Muda a senha numérica da conta bancária
	 * @param senhaNumerica <code>String</code> com a nova senha numérica da conta bancária
	 */
	public void setSenhaNumerica(String senhaNumerica) {
		this.senhaNumerica = senhaNumerica;
	}
	
	/** Retorna um <code>String</code> com a senha alfabética da conta bancária
	 * @return <code>String</code> com a senha alfabética da conta bancária
	 */
	public String getSenhaAlfabetica() {
		return senhaAlfabetica;
	}
	
	/** Muda a senha alfabética da conta bancária
	 * @param senhaAlfabetica <code>String</code> com a nova senha alfabética da conta bancária
	 */
	public void setSenhaAlfabetica(String senhaAlfabetica) {
		this.senhaAlfabetica = senhaAlfabetica;
	}
	
	/** Retorna um <code>boolean</code> com <code>true</code> se a conta bancária for conta salário e <code>false</code> caso contrário
	 * @return <code>boolean</code> com <code>true</code> se a conta bancária for conta salário e <code>false</code> caso contrário
	 */
	public boolean isContaSalario() {
		return contaSalario;
	}
	
	/** Muda a opção de conta salário para sim <code>true</code> ou não <code>false</code> da conta bancária
	 * @param contaSalario <code>boolean</code> com <code>true</code> se a conta bancária for conta salário, e <code>false</code> caso contrário
	 */
	public void setContaSalario(boolean contaSalario) {
		this.contaSalario = contaSalario;
	}
	
	/** Retorna um <code>double</code> com o saldo da conta bancária
	 * @return <code>double</code> com o saldo da conta bancária
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/** Muda o saldo da conta bancária
	 * @param saldo <code>double</code> com a novo saldo da conta bancária
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	/** Retorna uma <code>String</code> com todos os dados da conta bancária formatados, com o número da conta oculto
	 * @return <code>String</code> com todos os dados da conta bancária formatados, com o número da conta oculto
	 */
	public String exibeDadosFormatados() {
		String contaSalario = "Não";
		String cpf = this.cpf;
		Date dataAbertura = this.dataAbertura;
		
		if(this.contaSalario)
			contaSalario = "Sim";
		
		if(ValidarDados.validarVazio(cpf.trim()))
			cpf = Mascara.formatarString(cpf, "###.###.###-##");
		
		StringBuilder builder = new StringBuilder();
		builder.append(" Código da Agência: ").append(codAgencia)
				.append("\n Número da Conta: ").append("XXXXXXXXX").append("\n Tipo da Conta: ")
				.append(tipoConta.getDescricao()).append("\n CPF: ").append(cpf)
				.append("\n Data de Abertura: ").append(new SimpleDateFormat("dd/MM/yyyy  HH:mm").format(dataAbertura))
				.append("\n Senha Númerica: ").append(senhaNumerica)
				.append("\n Senha Alfabética: ").append(senhaAlfabetica)
				.append("\n Conta Sálario: ").append(contaSalario)
				.append("\n Saldo: R$").append(saldo);
		return builder.toString();
	}

	/** Retorna uma <code>String</code> com todos os dados da conta bancária
	 * @return <code>String</code> com todos os dados da conta bancária
	 */
	@Override
	public String toString() {
		String contaSalario = "Não";
		String cpf = this.cpf;
		Date dataAbertura = this.dataAbertura;
		
		if(this.contaSalario)
			contaSalario = "Sim";
		
		if(ValidarDados.validarVazio(cpf.trim()))
			cpf = Mascara.formatarString(cpf, "###.###.###-##");
		
		StringBuilder builder = new StringBuilder();
		builder.append(" Código da Agência: ").append(codAgencia)
				.append("\n Número da Conta: ").append(numConta).append("\n Tipo da Conta: ")
				.append(tipoConta.getDescricao()).append("\n CPF: ").append(cpf)
				.append("\n Data de Abertura: ").append(new SimpleDateFormat("dd/MM/yyyy  HH:mm").format(dataAbertura))
				.append("\n Senha Númerica: ").append(senhaNumerica)
				.append("\n Senha Alfabética: ").append(senhaAlfabetica)
				.append("\n Conta Sálario: ").append(contaSalario)
				.append("\n Saldo: R$").append(saldo);
		return builder.toString();
	}
	
} // class ContaBancaria
