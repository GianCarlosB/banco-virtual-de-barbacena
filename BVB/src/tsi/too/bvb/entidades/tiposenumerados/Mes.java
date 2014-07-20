package tsi.too.bvb.entidades.tiposenumerados;

/** Enumeração com os meses do ano
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */ 
public enum Mes {
	
    /** Mês de Janeiro */
	JANEIRO(0, "Janeiro"),
	/** Mês de Fevereiro */
	FEVEREIRO(1, "Fevereiro"),
	/** Mês de Março */
	MARCO(2, "Março"),
	/** Mês de Abriu */
	ABRIU(3, "Abriu"),
	/** Mês de Maio */
	MAIO(4, "Maio"),
	/** Mês de Junho */
	JUNHO(5, "Junho"),
	/** Mês de Julho */
	JULHO(6, "Julho"),
	/** Mês de Agosto */
	AGOSTO(7, "Agosto"),
	/** Mês de Setembro */
	SETEMBRO(8, "Setembro"),
	/** Mês de Outrubro */
	OUTUBRO(9, "Outrubro"),
	/** Mês de Novembro */
	NOVEMBRO(10, "Novembro"),
	/** Mês de Dezembro */
	DEZEMBRO(11, "Dezembro");
	
	private int numero;
	private String descricao;
	private final static int NUM_TIPOS = 12;
	
	private Mes(int numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}
	
	/** Retorna um <code>int</code> com o número do mês
	 * @return <code>int</code> com o número do mês
	 */
	public int getNumero() {
		return numero;
	}

	/** Retorna uma <code>String</code> o nome do mês
	 * @return <code>String</code> o nome do mês
	 */
	public String getDescricao() {
		return descricao;
	}

	/** Retorna um <code>int</code> o número de meses
	 * @return <code>int</code> o número de meses
	 */
	public static int getNumTipos() {
		return NUM_TIPOS;
	}

	/** Retorna um <code>String[]</code> com todos os meses da enumeração
	 * @return <code>String[]</code> com todos os meses da enumeração
	 */
	public static String[] obterArrayMeses() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = JANEIRO.getDescricao();
		arrayTipos[i++] = FEVEREIRO.getDescricao();
		arrayTipos[i++] = MARCO.getDescricao();
		arrayTipos[i++] = ABRIU.getDescricao();
		arrayTipos[i++] = MAIO.getDescricao();
		arrayTipos[i++] = JUNHO.getDescricao();
		arrayTipos[i++] = JULHO.getDescricao();
		arrayTipos[i++] = AGOSTO.getDescricao();
		arrayTipos[i++] = SETEMBRO.getDescricao();
		arrayTipos[i++] = OUTUBRO.getDescricao();
		arrayTipos[i++] = NOVEMBRO.getDescricao();
		arrayTipos[i++] = DEZEMBRO.getDescricao();
		
		return arrayTipos;
	}
	
	/** Retorna um <code>String[]</code> com o número de meses desejados da enumeração
	 * @param numMeses <code>int</code> com o número de meses desejados no array
	 * @return <code>String[]</code> com o número de meses desejados da enumeração
	 */
	public static String[] obterArrayMeses(int numMeses) {
		String arrayTipos[] = new String[numMeses];
		int i = 0;
		
		arrayTipos[i++] = JANEIRO.getDescricao(); if(numMeses == 1) return arrayTipos;
		arrayTipos[i++] = FEVEREIRO.getDescricao(); if(numMeses == 2) return arrayTipos;
		arrayTipos[i++] = MARCO.getDescricao(); if(numMeses == 3) return arrayTipos;
		arrayTipos[i++] = ABRIU.getDescricao(); if(numMeses == 4) return arrayTipos;
		arrayTipos[i++] = MAIO.getDescricao(); if(numMeses == 5) return arrayTipos;
		arrayTipos[i++] = JUNHO.getDescricao(); if(numMeses == 6) return arrayTipos;
		arrayTipos[i++] = JULHO.getDescricao(); if(numMeses == 7) return arrayTipos;
		arrayTipos[i++] = AGOSTO.getDescricao(); if(numMeses == 8) return arrayTipos;
		arrayTipos[i++] = SETEMBRO.getDescricao(); if(numMeses == 9) return arrayTipos;
		arrayTipos[i++] = OUTUBRO.getDescricao(); if(numMeses == 10) return arrayTipos;
		arrayTipos[i++] = NOVEMBRO.getDescricao(); if(numMeses == 11) return arrayTipos;
		arrayTipos[i++] = DEZEMBRO.getDescricao(); if(numMeses == 12) return arrayTipos;
		
		return arrayTipos;
	}
	
	/** Obtém o mês da enumeração corresponte ao parâmetro passado
	 * @param mes <code>String</code> referêrente ao mês desejado
	 * @return <code>Mes</code> com o mês desajado ou <code>null</code> caso não seja encontrado
	 */
	public static Mes obterMes(String mes) {
		if(mes.equalsIgnoreCase(JANEIRO.getDescricao()))
			return JANEIRO;
		else if(mes.equalsIgnoreCase(FEVEREIRO.getDescricao()))
			return FEVEREIRO;
		else if(mes.equalsIgnoreCase(MARCO.getDescricao()))
			return MARCO;
		else if(mes.equalsIgnoreCase(ABRIU.getDescricao()))
			return ABRIU;
		else if(mes.equalsIgnoreCase(MAIO.getDescricao()))
			return MAIO;
		else if(mes.equalsIgnoreCase(JUNHO.getDescricao()))
			return JUNHO;
		else if(mes.equalsIgnoreCase(JULHO.getDescricao()))
			return JULHO;
		else if(mes.equalsIgnoreCase(AGOSTO.getDescricao()))
			return AGOSTO;
		else if(mes.equalsIgnoreCase(SETEMBRO.getDescricao()))
			return SETEMBRO;
		else if(mes.equalsIgnoreCase(OUTUBRO.getDescricao()))
			return OUTUBRO;
		else if(mes.equalsIgnoreCase(NOVEMBRO.getDescricao()))
			return NOVEMBRO;
		else if(mes.equalsIgnoreCase(DEZEMBRO.getDescricao()))
			return DEZEMBRO;
		
		return null;
	}
	
	/** Obtém o mês da enumeração corresponte ao parâmetro passado
	 * @param numero <code>int</code> referêrente ao mês desejado
	 * @return <code>Mes</code> com o mês desajado ou <code>null</code> caso não seja encontrado
	 */
	public static Mes obterMes(int numero) {
		if(numero == JANEIRO.getNumero())
			return JANEIRO;
		else if(numero == FEVEREIRO.getNumero())
			return FEVEREIRO;
		else if(numero == MARCO.getNumero())
			return MARCO;
		else if(numero == ABRIU.getNumero())
			return ABRIU;
		else if(numero == MAIO.getNumero())
			return MAIO;
		else if(numero == JUNHO.getNumero())
			return JUNHO;
		else if(numero == JULHO.getNumero())
			return JULHO;
		else if(numero == AGOSTO.getNumero())
			return AGOSTO;
		else if(numero == SETEMBRO.getNumero())
			return SETEMBRO;
		else if(numero == OUTUBRO.getNumero())
			return OUTUBRO;
		else if(numero == NOVEMBRO.getNumero())
			return NOVEMBRO;
		else if(numero == DEZEMBRO.getNumero())
			return DEZEMBRO;
		
		return null;
	}
	
} // enum Mes
