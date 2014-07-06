package tsi.too.bvb.entidades.cliente;

public class Contato {
	
	private String telefoneFixo;
	private String telefoneMovel;
	
	public Contato() {}

	public Contato(String telefoneFixo, String telefoneMovel) {
		this.telefoneFixo = telefoneFixo;
		this.telefoneMovel = telefoneMovel;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneMovel() {
		return telefoneMovel;
	}

	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n Telefone Fixo: ").append(telefoneFixo)
				.append("\n Telefone Móvel: ").append(telefoneMovel);
		return builder.toString();
	}
	
} // class Contato
