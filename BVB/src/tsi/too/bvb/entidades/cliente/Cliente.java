package tsi.too.bvb.entidades.cliente;

import tsi.too.bvb.entidades.Mascara;

/** A classe <code>Cliente</code> manipula dados referênte aos contatos dos clientes do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class Cliente {
	
	private String cpf;
	private String nome;
	private Contato contato;
	private Endereco endereco;
	
	/** Cria um cliente sem nem um atributo
	 */
	public Cliente() {
		super();
	}
	
	/** Cria um cliente com o cpf e o nome
	 * 
	 * @param cpf <code>String</code> com o cpf do cliente
	 * @param nome <code>String</code> com o nome do cliente
	 */
	public Cliente(String cpf, String nome) {
		this();
		this.cpf = cpf;
		this.nome = nome;
	}
	
	/** Cria um cliente com o contato e o endereço
	 * 
	 * @param contato <code>Contato</code> com o contato do cliente
	 * @param endereco <code>Endereco</code> com o endereço do cliente
	 */
	public Cliente(Contato contato, Endereco endereco) {
		this();
		this.contato = contato;
		this.endereco = endereco;
	}

	/** Cria um cliente com o cpf, nome, contato e o endereço
	 * 
	 * @param cpf <code>String</code> com o cpf do cliente
	 * @param nome <code>String</code> com o nome do cliente
	 * @param contato <code>Contato</code> com o contato do cliente
	 * @param endereco <code>Endereco</code> com o endereço do cliente
	 */
	public Cliente(String cpf, String nome, Contato contato, Endereco endereco) {
		this();
		this.cpf = cpf;
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
	}

	/** Retorna uma <code>String</code> com o cpf do cliente
	 * @return <code>String</code> com o cpf do cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/** Muda o cpf do cliente
	 * @param cpf <code>String</code> com o novo cpf do cliente
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/** Retorna uma <code>String</code> com o nome do cliente
	 * @return <code>String</code> com o nome do cliente
	 */
	public String getNome() {
		return nome;
	}

	/** Muda o nome do cliente
	 * @param nome <code>String</code> com o novo nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** Retorna um <code>Contato</code> com o contato do cliente
	 * @return <code>Contato</code> com o contato do cliente
	 */
	public Contato getContato() {
		return contato;
	}

	/** Muda o contato do cliente
	 * @param contato <code>Contato</code> com o novo contato do cliente
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	/** Retorna um <code>Endereco</code> com o endereço do cliente
	 * @return <code>Endereco</code> com o endereço do cliente
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	
	/** Muda o endereço do cliente
	 * @param endereco <code>Endereco</code> com o novo endereço do cliente
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	/** Insere as máscaras no cpf, cep, telefone fixo e móvel do cliente
	 * 
	 * @see Mascara
	 */
	public void insereMascara() {
		cpf = Mascara.formatarString(cpf, "###.###.###-##");
		endereco.setCep(Mascara.formatarString(endereco.getCep(), "#####-###"));
		contato.setTelefoneFixo(Mascara.formatarString(contato.getTelefoneFixo(), "(##)####-####"));
		contato.setTelefoneMovel(Mascara.formatarString(contato.getTelefoneMovel(), "(##)####-####"));
	}
	
	/** Remove as máscaras no cpf, cep, telefone fixo e móvel do cliente
	 * 
	 * @see Mascara
	 */
	public void removeMascara() {
		cpf = cpf.replace(".", "").replace("-", "");
		endereco.setCep(endereco.getCep().replace("-", ""));
		contato.setTelefoneFixo(contato.getTelefoneFixo().replace("(", "").replace(")", "").replace("-", ""));
		contato.setTelefoneMovel(contato.getTelefoneMovel().replace("(", "").replace(")", "").replace("-", ""));
	}
	
	/** Retorna uma <code>String</code> com todos os dados do cliente formatados
	 * @return <code>String</code> com todos os dados do cliente formatados
	 */
	public String exibeDadosFormatados() {
		insereMascara();
		String dados = toString();
		removeMascara();
		return dados;
	}

	/** Retorna uma <code>String</code> com todos os dados do cliente
	 * @return <code>String</code> com todos os dados do cliente
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" CPF: ").append(cpf).append("\n Nome: ")
				.append(nome).append(contato).append(endereco);
		return builder.toString();
	}

} // class Cliente
