package tsi.too.bvb.entidades.agencia;

public class Agencia {
	
	private int codAgencia;
	private String descricao;
	
	public Agencia() {
		super();
	}
	
	public Agencia(String descricao) {
		this();
		this.descricao = descricao;
	}
	
	public Agencia(int codAgencia, String descricao) {
		this();
		this.codAgencia = codAgencia;
		this.descricao = descricao;
	}

	public int getCodAgencia() {
		return codAgencia;
	}

	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Código da Agência: ").append(codAgencia)
				.append("\n Descrição: ").append(descricao);
		return builder.toString();
	}
	
} // class Agencia
