package tsi.too.bvb.entidades.tiposenumerados;

/** Enumeração com os tipos de operações de contas bancárias permitidos no sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */ 
public enum TipoOperacao {
	
	/** Saque */
	SAQUE(1, "Saque"),
	/** Depósito */
	DEPOSITO(2, "Depósito"),
	/** Transferência */
	TRANSFERENCIA(3, "Transferência"),
	/** Resgate */
	RESGATE(4, "Resgate");
	
	private int numero;
	private String descricao;
	private final static int NUM_TIPOS = 4;

	private TipoOperacao(int numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	/** Retorna um <code>int</code> com o número do tipo de operação de conta bancária
	 * @return <code>int</code> com o número do tipo de operação de conta bancária
	 */
	public int getNumero() {
		return numero;
	}

	/** Retorna uma <code>String</code> com a descrição do tipo de operação de conta bancária
	 * @return <code>String</code> com a descrição do tipo de operação conta bancária
	 */
	public String getDescricao() {
		return descricao;
	}

	/** Retorna um <code>int</code> o número de tipos
	 * @return <code>int</code> o número de tipos
	 */
	public static int getNumTipos() {
		return NUM_TIPOS;
	}

	/** Retorna um <code>String[]</code> com todos os tipos da enumeração
	 * @return <code>String[]</code> com todos os tipos da enumeração
	 */
	public static String[] obterArrayTipos() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = SAQUE.getDescricao();
		arrayTipos[i++] = DEPOSITO.getDescricao();
		arrayTipos[i++] = TRANSFERENCIA.getDescricao();
		arrayTipos[i++] = RESGATE.getDescricao();
		
		return arrayTipos;
	}
	
	/** Obtém o tipo da enumeração corresponte ao parâmetro passado
	 * @param descricao <code>String</code> referêrente ao tipo desejado
	 * @return <code>TipoOperacao</code> com o tipo desajado ou <code>null</code> caso não seja encontrado
	 */
	public static TipoOperacao obterTipoOperacao(String descricao) {
		if(descricao.equalsIgnoreCase(SAQUE.getDescricao()))
			return SAQUE;
		else if(descricao.equalsIgnoreCase(DEPOSITO.getDescricao()))
			return DEPOSITO;
		else if(descricao.equalsIgnoreCase(TRANSFERENCIA.getDescricao()))
			return TRANSFERENCIA;
		else if(descricao.equalsIgnoreCase(RESGATE.getDescricao()))
			return RESGATE;
		
		return null;
	}
	
	/** Obtém o tipo da enumeração corresponte ao parâmetro passado
	 * @param numero <code>int</code> referêrente ao tipo desejado
	 * @return <code>TipoOperacao</code> com o tipo desajado ou <code>null</code> caso não seja encontrado
	 */
	public static TipoOperacao obterTipoOperacao(int numero) {
		if(numero == SAQUE.getNumero())
			return SAQUE;
		else if(numero == DEPOSITO.getNumero())
			return DEPOSITO;
		else if(numero == TRANSFERENCIA.getNumero())
			return TRANSFERENCIA;
		else if(numero == RESGATE.getNumero())
			return RESGATE;
		
		return null;
	}
	
} // enum TipoOperacao
