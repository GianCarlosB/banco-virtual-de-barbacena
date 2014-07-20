package tsi.too.bvb.entidades.cliente;

import tsi.too.bvb.entidades.tiposenumerados.UF;

/** A classe <code>Endereco</code> manipula dados referênte aos dados do endereço dos clientes do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class Endereco {
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private UF uf;
	
	/** Cria um endereço sem nem um atributo
	 */
	public Endereco() {
		super();
	}
	
	/** Cria um endereço com o logradouro, número, complemento, bairro, cidade, uf e cep
	 * 
	 * @param logradouro <code>String</code> com o logradouro do endereço
	 * @param numero <code>String</code> com o número do endereço
	 * @param complemento <code>String</code> com o complemento do endereço
	 * @param bairro <code>String</code> com bairro do endereço
	 * @param cidade <code>String</code> com a cidade do endereço
	 * @param uf <code>UF</code> com o uf do endereço
	 * @param cep <code>String</code> com o cep do endereço
	 * 
	 * @see UF
	 */
	public Endereco(String logradouro, String numero, String complemento,
			String bairro, String cidade, UF uf, String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	/** Retorna uma <code>String</code> com o logradouro do endereço
	 * @return <code>String</code> com o logradouro do endereço
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/** Muda o logradouro do endereço
	 * @param logradouro <code>String</code> com o novo logradouro do endereço
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/** Retorna uma <code>String</code> com o número do endereço
	 * @return <code>String</code> com o número do endereço
	 */
	public String getNumero() {
		return numero;
	}

	/** Muda o número do endereço
	 * @param numero <code>String</code> com o novo número do endereço
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/** Retorna uma <code>String</code> com o complemento do endereço
	 * @return <code>String</code> com o complemento do endereço
	 */
	public String getComplemento() {
		return complemento;
	}

	/** Muda o complemento do endereço
	 * @param complemento <code>String</code> com o novo complemento do endereço
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/** Retorna uma <code>String</code> com o bairro do endereço
	 * @return <code>String</code> com o bairro do endereço
	 */
	public String getBairro() {
		return bairro;
	}

	/** Muda o bairro do endereço
	 * @param bairro <code>String</code> com o novo bairro do endereço
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/** Retorna uma <code>String</code> com a cidade do endereço
	 * @return <code>String</code> com a cidade do endereço
	 */
	public String getCidade() {
		return cidade;
	}

	/** Muda a cidade do endereço
	 * @param cidade <code>String</code> com a nova cidade do endereço
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/** Retorna um <code>UF</code> com o uf do endereço
	 * @return <code>UF</code> com o uf do endereço
	 */
	public UF getUf() {
		return uf;
	}

	/** Muda o uf do endereço
	 * @param uf <code>UF</code> com o novo uf do endereço
	 */
	public void setUf(UF uf) {
		this.uf = uf;
	}

	/** Retorna uma <code>String</code> com o cep do endereço
	 * @return <code>String</code> com o cep do endereço
	 */
	public String getCep() {
		return cep;
	}

	/** Muda o cep do endereço
	 * @param cep <code>String</code> com o novo cep do endereço
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/** Retorna uma <code>String</code> com todos os dados do endereço
	 * @return <code>String</code> com todos os dados do endereço
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Logradouro: ").append(logradouro)
				.append("\n Número: ").append(numero).append("\n Complemento: ")
				.append(complemento).append("\n Bairro: ").append(bairro)
				.append("\n Cidade: ").append(cidade).append("\n UF: ").append(uf.getUf())
				.append("\n CEP: ").append(cep);
		return builder.toString();
	}
	
} // class Endereco
