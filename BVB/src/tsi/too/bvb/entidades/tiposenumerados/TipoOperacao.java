package tsi.too.bvb.entidades.tiposenumerados;

public enum TipoOperacao {
	
	SAQUE(1, "Saque"),
	DEPOSITO(2, "Depósito"),
	TRANSFERENCIA(3, "Transferência"),
	RESGATE(4, "Resgate");
	
	private int tipo;
	private String descricao;
	private final static int NUM_TIPOS = 4;

	private TipoOperacao(int tipo, String descricao) {
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

	public static String[] obterArrayTipos() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = SAQUE.getDescricao();
		arrayTipos[i++] = DEPOSITO.getDescricao();
		arrayTipos[i++] = TRANSFERENCIA.getDescricao();
		arrayTipos[i++] = RESGATE.getDescricao();
		
		return arrayTipos;
	}
	
	public static TipoOperacao obterTipoOperacao(String tipo) {
		if(tipo.equalsIgnoreCase(SAQUE.getDescricao()))
			return SAQUE;
		else if(tipo.equalsIgnoreCase(DEPOSITO.getDescricao()))
			return DEPOSITO;
		else if(tipo.equalsIgnoreCase(TRANSFERENCIA.getDescricao()))
			return TRANSFERENCIA;
		else if(tipo.equalsIgnoreCase(RESGATE.getDescricao()))
			return RESGATE;
		
		return null;
	}
	
	public static TipoOperacao obterTipoOperacao(int tipo) {
		if(tipo == SAQUE.getTipo())
			return SAQUE;
		else if(tipo == DEPOSITO.getTipo())
			return DEPOSITO;
		else if(tipo == TRANSFERENCIA.getTipo())
			return TRANSFERENCIA;
		else if(tipo == RESGATE.getTipo())
			return RESGATE;
		
		return null;
	}
	
} // enum TipoOperacao
