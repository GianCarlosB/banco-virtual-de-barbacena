package tsi.too.bvb.entidades.funcionario;

import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;

public class Funcionario {
	
	private String nomeUsuario;
	private String senha;
	private TipoUsuario tipoUsuario;

	public Funcionario() {
		super();
	}
	
	public Funcionario(String nomeUsuario, String senha, TipoUsuario tipoUsuario) {
		this();
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String toStringSemSenha() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Nome do Usuário: ").append(nomeUsuario)
			   .append("\n Tipo do Usuário: ").append(tipoUsuario.getPerfil());
		return builder.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Nome do Usuário: ").append(nomeUsuario)
				.append("\n Senha: ").append(senha).append("\n Tipo do Usuário: ")
				.append(tipoUsuario.getPerfil());
		return builder.toString();
	}
	
} // Funcionario
