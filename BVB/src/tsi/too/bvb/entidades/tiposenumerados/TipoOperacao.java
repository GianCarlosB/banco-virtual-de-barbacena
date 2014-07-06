package tsi.too.bvb.entidades.tiposenumerados;

public enum TipoOperacao {
	
	SAQUE(1, "Saque"),
	DEPOSITO(2, "Depósito"),
	TRANSFERENCIA(3, "Transferência"),
	RESGATE(4, "Resgate");
	
	private int numero;
	private String descricao;
	private final static int NUM_TIPOS = 4;

	private TipoOperacao(int numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public static TipoOperacao obterTipoOperacao(String numero) {
		if(numero.equalsIgnoreCase(SAQUE.getDescricao()))
			return SAQUE;
		else if(numero.equalsIgnoreCase(DEPOSITO.getDescricao()))
			return DEPOSITO;
		else if(numero.equalsIgnoreCase(TRANSFERENCIA.getDescricao()))
			return TRANSFERENCIA;
		else if(numero.equalsIgnoreCase(RESGATE.getDescricao()))
			return RESGATE;
		
		return null;
	}
	
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
