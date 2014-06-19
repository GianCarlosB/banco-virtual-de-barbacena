package tsi.too.bvb.entidades.cliente;

import tsi.too.bvb.entidades.tiposenumerados.UF;

public class Endereco {
	
	private String logradouro, numero, complemento, bairro, cidade, cep;
	private UF uf;
	
	public Endereco() {}
	
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

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
