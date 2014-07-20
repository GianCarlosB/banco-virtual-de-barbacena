package tsi.too.bvb.entidades.cliente;

/** A classe <code>Contato</code> manipula dados referênte aos contatos dos clientes do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class Contato {
	
	private String telefoneFixo;
	private String telefoneMovel;
	
	/** Cria um contato sem nem um atributo
	 */
	public Contato() {
		super();
	}

	/** Cria um contato com o telefone fixo e o telefone móvel
	 * 
	 * @param telefoneFixo <code>String</code> com o telefone fixo do contato
	 * @param telefoneMovel <code>String</code> com o telefone móvel do contato
	 */
	public Contato(String telefoneFixo, String telefoneMovel) {
		this.telefoneFixo = telefoneFixo;
		this.telefoneMovel = telefoneMovel;
	}

	/** Retorna uma <code>String</code> com o telefone fixo do contato
	 * @return <code>String</code> com o telefone fixo do contato
	 */
	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	/** Muda o telefone fixo do contato
	 * @param telefoneFixo <code>String</code> com o novo telefone fixo do contato
	 */
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	/** Retorna uma <code>String</code> com o telefone móvel do contato
	 * @return <code>String</code> com o telefone móvel do contato
	 */
	public String getTelefoneMovel() {
		return telefoneMovel;
	}

	/** Muda o telefone nóvel do contato
	 * @param telefoneMovel <code>String</code> com o novo telefone móvel do contato
	 */
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}

	/** Retorna uma <code>String</code> com todos os dados do contato
	 * @return <code>String</code> com todos os dados do contato
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Telefone Fixo: ").append(telefoneFixo)
				.append("\n Telefone Móvel: ").append(telefoneMovel);
		return builder.toString();
	}
	
} // class Contato
