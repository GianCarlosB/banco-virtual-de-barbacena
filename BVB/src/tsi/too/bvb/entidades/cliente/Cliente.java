package tsi.too.bvb.entidades.cliente;

public class Cliente {
	
	private String cpf, nome;
	private Contato contato;
	private Endereco endereco;
	
	public Cliente() {
		super();
	}

	public Cliente(String cpf, String nome) {
		this();
		this.cpf = cpf;
		this.nome = nome;
	}

	public Cliente(Contato contato, Endereco endereco) {
		this();
		this.contato = contato;
		this.endereco = endereco;
	}

	public Cliente(String cpf, String nome, Contato contato, Endereco endereco) {
		this();
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" CPF: ").append(cpf).append("\n Nome: ")
				.append(nome).append(contato).append(endereco);
		return builder.toString();
	}

} // class Cliente
