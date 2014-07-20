package tsi.too.bvb.entidades.tiposenumerados;

/** Enumeração com os tipos de conta bancárias permitidos no sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */ 
public enum TipoConta {
	
	/** Conta Corrente */
	CONTA_CORRENTE(1, "Conta Corrente"),
	/** Conta Poupança */
	CONTA_POUPANCA(2, "Conta Poupança"),
	/** BVB FIF Prático */
	FIF_PRATICO(3, "BVB FIF Prático"),
	/** BVB FIF Executivo */
	FIF_EXECUTIVO(4, "BVB FIF Executivo");
	
	private int numero;
	private String descricao;
	private final static int NUM_TIPOS = 4;
	
	private TipoConta(int tipo, String descricao) {
		this.numero = tipo;
		this.descricao = descricao;
	}

	/** Retorna um <code>int</code> com o número do tipo de conta bancária
	 * @return <code>int</code> com o número do tipo de conta bancária
	 */
	public int getNumero() {
		return numero;
	}

	/** Retorna uma <code>String</code> com a descrição do tipo de conta bancária
	 * @return <code>String</code> com a descrição do tipo de conta bancária
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

	/** Retorna um <code>String[]</code> com os tipos comuns da enumeração (conta corrente e poupança)
	 * @return <code>String[]</code> com os tipos comuns da enumeração (conta corrente e poupança)
	 */
	public static String[] obterArrayTiposComuns() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = CONTA_CORRENTE.getDescricao();
		arrayTipos[i++] = CONTA_POUPANCA.getDescricao();
		
		return arrayTipos;
	}
	
	/** Retorna um <code>String[]</code> com os tipos fif da enumeração (fif prático e executivo)
	 * @return <code>String[]</code> com os tipos fif da enumeração (fif prático e executivo)
	 */
	public static String[] obterArrayTiposFIF() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = FIF_PRATICO.getDescricao();
		arrayTipos[i++] = FIF_EXECUTIVO.getDescricao();
		
		return arrayTipos;
	}
	
	/** Obtém o tipo da enumeração corresponte ao parâmetro passado
	 * @param descricao <code>String</code> referêrente ao tipo desejado
	 * @return <code>TipoConta</code> com o tipo desajado ou <code>null</code> caso não seja encontrado
	 */
	public static TipoConta obterTipoConta(String descricao) {
		if(descricao.equalsIgnoreCase(CONTA_CORRENTE.getDescricao()))
			return CONTA_CORRENTE;
		else if(descricao.equalsIgnoreCase(CONTA_POUPANCA.getDescricao()))
			return CONTA_POUPANCA;
		else if(descricao.equalsIgnoreCase(FIF_PRATICO.getDescricao()))
			return FIF_PRATICO;
		else if(descricao.equalsIgnoreCase(FIF_EXECUTIVO.getDescricao()))
			return FIF_EXECUTIVO;
		
		return null;
	}
	
	/** Obtém o tipo da enumeração corresponte ao parâmetro passado
	 * @param numero <code>int</code> referêrente ao tipo desejado
	 * @return <code>TipoConta</code> com o tipo desajado ou <code>null</code> caso não seja encontrado
	 */
	public static TipoConta obterTipoConta(int numero) {
		if(numero == CONTA_CORRENTE.getNumero())
			return CONTA_CORRENTE;
		else if(numero == CONTA_POUPANCA.getNumero())
			return CONTA_POUPANCA;
		else if(numero == FIF_PRATICO.getNumero())
			return FIF_PRATICO;
		else if(numero == FIF_EXECUTIVO.getNumero())
			return FIF_EXECUTIVO;
		
		return null;
	}

} // enum TipoConta
