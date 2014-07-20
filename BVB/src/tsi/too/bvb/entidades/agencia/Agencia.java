package tsi.too.bvb.entidades.agencia;

/** A classe <code>Agencia</code> manipula dados referênte as agências do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class Agencia {
	
	private int codAgencia;
	private String descricao;
	
	/** Cria uma agência sem nem um atributo
	 */
	public Agencia() {
		super();
	}
	
	/** Cria uma agência com o código e a descrição
	 * 
	 * @param codAgencia <code>int</code> com o código da agência
	 * @param descricao <code>String</code> com a descrição da agência
	 */
	public Agencia(int codAgencia, String descricao) {
		this();
		this.codAgencia = codAgencia;
		this.descricao = descricao;
	}

	/** Retorna um <code>int</code> com o código da agência
	 * @return <code>int</code> com o código da agência
	 */
	public int getCodAgencia() {
		return codAgencia;
	}

	/** Muda o código da agência
	 * @param codAgencia <code>int</code> com o novo código da agência
	 */
	public void setCodAgencia(int codAgencia) {
		this.codAgencia = codAgencia;
	}

	/** Retorna uma <code>String</code> com a descrição da agência
	 * @return <code>String</code> com a descrição da agência
	 */
	public String getDescricao() {
		return descricao;
	}

	/** Muda a descrição da agência
	 * @param descricao <code>String</code> com a nova descrição da agência
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/** Retorna uma <code>String</code> com todos os dados da agência
	 * @return <code>String</code> com todos os dados da agência
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Código da Agência: ").append(codAgencia)
				.append("\n Descrição: ").append(descricao);
		return builder.toString();
	}
	
} // class Agencia
