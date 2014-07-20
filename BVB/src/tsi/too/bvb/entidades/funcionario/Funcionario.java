package tsi.too.bvb.entidades.funcionario;

import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;

/** A classe <code>Funcionario</code> manipula dados referênte aos funcionários do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class Funcionario {
	
	private String nomeUsuario;
	private String senha;
	private TipoUsuario tipoUsuario;

	/** Cria um funcionário sem nem um atributo
	 */
	public Funcionario() {
		super();
	}
	
	/** Cria um funcionário com o nome de usuário, senha e tipo
	 * 
	 * @param nomeUsuario <code>String</code> com o nome do funcionário
	 * @param senha <code>String</code> com a senha do funcionário
	 * @param tipoUsuario <code>TipoUsuario</code> com o tipo do funcionário
	 * 
	 * @see TipoUsuario
	 */
	public Funcionario(String nomeUsuario, String senha, TipoUsuario tipoUsuario) {
		this();
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
	
	/** Retorna uma <code>String</code> com o nome do funcionário
	 * @return <code>String</code> com o nome do funcionário
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	/** Muda o nome do funcionário
	 * @param nomeUsuario <code>String</code> com o novo nome do funcionário
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	/** Retorna uma <code>String</code> com a senha do funcionário
	 * @return <code>String</code> com a senha do funcionário
	 */
	public String getSenha() {
		return senha;
	}
	
	/** Muda a senha do funcionário
	 * @param senha <code>String</code> com a nova senha do funcionário
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/** Retorna um <code>TipoUsuario</code> com o tipo do funcionário
	 * @return <code>TipoUsuario</code> com o tipo do funcionário
	 */
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	
	/** Muda o tipo do funcionário
	 * @param tipoUsuario <code>TipoUsuario</code> com o novo tipo do funcionário
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/** Retorna uma <code>String</code> com o nome e o tipo do funcionário
	 * @return <code>String</code> com o nome e o tipo do funcionário
	 */
	public String toStringSemSenha() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Nome do Usuário: ").append(nomeUsuario)
			   .append("\n Tipo do Usuário: ").append(tipoUsuario.getPerfil());
		return builder.toString();
	}
	
	/** Retorna uma <code>String</code> com todos os dados do funcionário
	 * @return <code>String</code> com todos os dados do funcionário
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Nome do Usuário: ").append(nomeUsuario)
				.append("\n Senha: ").append(senha).append("\n Tipo do Usuário: ")
				.append(tipoUsuario.getPerfil());
		return builder.toString();
	}
	
} // class Funcionario
