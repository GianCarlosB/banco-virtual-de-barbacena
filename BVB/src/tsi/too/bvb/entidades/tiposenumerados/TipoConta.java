package tsi.too.bvb.entidades.tiposenumerados;

public enum TipoConta {
	
	CONTA_CORRENTE(1, "Conta Corrente"),
	POUPANCA(2, "Conta Poupança"),
	FIF_PRATICO(3, "BVB FIF Prático"),
	FIF_EXECUTIVO(4, "BVB FIF Executivo");
	
	private int tipo;
	private String descricao;
	private final static int NUM_TIPOS = 4;
	
	private TipoConta(int tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static int getNumTipos() {
		return NUM_TIPOS;
	}

	public static String[] obterArrayTiposComuns() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = CONTA_CORRENTE.getDescricao();
		arrayTipos[i++] = POUPANCA.getDescricao();
		
		return arrayTipos;
	}
	
	public static String[] obterArrayTiposFIF() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = FIF_PRATICO.getDescricao();
		arrayTipos[i++] = FIF_EXECUTIVO.getDescricao();
		
		return arrayTipos;
	}
	
	public static TipoConta obterTipoConta(String tipo) {
		if(tipo.equalsIgnoreCase(CONTA_CORRENTE.getDescricao()))
			return CONTA_CORRENTE;
		else if(tipo.equalsIgnoreCase(POUPANCA.getDescricao()))
			return POUPANCA;
		else if(tipo.equalsIgnoreCase(FIF_PRATICO.getDescricao()))
			return FIF_PRATICO;
		else if(tipo.equalsIgnoreCase(FIF_EXECUTIVO.getDescricao()))
			return FIF_EXECUTIVO;
		
		return null;
	}
	
	public static TipoConta obterTipoConta(int tipo) {
		if(tipo == CONTA_CORRENTE.getTipo())
			return CONTA_CORRENTE;
		else if(tipo == POUPANCA.getTipo())
			return POUPANCA;
		else if(tipo == FIF_PRATICO.getTipo())
			return FIF_PRATICO;
		else if(tipo == FIF_EXECUTIVO.getTipo())
			return FIF_EXECUTIVO;
		
		return null;
	}

} // enum TipoConta
