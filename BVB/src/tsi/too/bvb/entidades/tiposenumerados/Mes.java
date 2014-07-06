package tsi.too.bvb.entidades.tiposenumerados;

public enum Mes {
	
	JANEIRO(0, "Janeiro"),
	FEVEREIRO(1, "Fevereiro"),
	MARCO(2, "Março"),
	ABRIU(3, "Abriu"),
	MAIO(4, "Maio"),
	JUNHO(5, "Junho"),
	JULHO(6, "Julho"),
	AGOSTO(7, "Agosto"),
	SETEMBRO(8, "Setembro"),
	OUTUBRO(9, "Outrubro"),
	NOVEMBRO(10, "Novembro"),
	DEZEMBRO(11, "Dezembro");
	
	private int numero;
	private String descricao;
	private final static int NUM_TIPOS = 12;

	private Mes(int numero, String descricao) {
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
