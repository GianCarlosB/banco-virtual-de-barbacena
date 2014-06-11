package tsi.too.bvb.entidades.tiposenumerados;

public enum UF {
	
	AC("AC", "Acre"),
	AL("AL", "Alagoas"),
	AP("AP", "Amapá"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Espírito Santo"),
	GO("GO", "Goiás"),
	MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Pará"),
	PB("PB", "Paraíba"),
	PR("PR", "Paraná"),
	PE("PE", "Pernambuco"),
	PI("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rondônia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "São Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");
	
	private String uf, estado;
	private final static int NUM_ESTADOS = 27;

	private UF(String uf, String estado) {
		this.uf = uf;
		this.estado = estado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static int getNUM_ESTADOS() {
		return NUM_ESTADOS;
	}
	
	public static String[] arrayUF() {
		String arrayUF[] = new String[NUM_ESTADOS];
		int i = 0;
		
		arrayUF[i++] = AC.getUf();
		arrayUF[i++] = AL.getUf();
		arrayUF[i++] = AP.getUf();
		arrayUF[i++] = AM.getUf();
		arrayUF[i++] = BA.getUf();
		arrayUF[i++] = CE.getUf();
		arrayUF[i++] = DF.getUf();
		arrayUF[i++] = ES.getUf();
		arrayUF[i++] = GO.getUf();
		arrayUF[i++] = MA.getUf();
		arrayUF[i++] = MT.getUf();
		arrayUF[i++] = MS.getUf();
		arrayUF[i++] = MG.getUf();
		arrayUF[i++] = PA.getUf();
		arrayUF[i++] = PB.getUf();
		arrayUF[i++] = PR.getUf();
		arrayUF[i++] = PE.getUf();
		arrayUF[i++] = PI.getUf();
		arrayUF[i++] = RJ.getUf();
		arrayUF[i++] = RN.getUf();
		arrayUF[i++] = RS.getUf();
		arrayUF[i++] = RO.getUf();
		arrayUF[i++] = RR.getUf();
		arrayUF[i++] = SC.getUf();
		arrayUF[i++] = SP.getUf();
		arrayUF[i++] = SE.getUf();
		arrayUF[i++] = TO.getUf();
		
		return arrayUF;
	}
	
	public static UF obterUF(String uf) {
		if(uf.equalsIgnoreCase(AC.getUf()))
			return AC;
		else if(uf.equalsIgnoreCase(AL.getUf()))
			return AL;
		else if(uf.equalsIgnoreCase(AP.getUf()))
			return AP;
		else if(uf.equalsIgnoreCase(AM.getUf()))
			return AM;
		else if(uf.equalsIgnoreCase(BA.getUf()))
			return BA;
		else if(uf.equalsIgnoreCase(CE.getUf()))
			return CE;
		else if(uf.equalsIgnoreCase(DF.getUf()))
			return DF;
		else if(uf.equalsIgnoreCase(ES.getUf()))
			return ES;
		else if(uf.equalsIgnoreCase(GO.getUf()))
			return GO;
		else if(uf.equalsIgnoreCase(MA.getUf()))
			return MA;
		else if(uf.equalsIgnoreCase(MT.getUf()))
			return MT;
		else if(uf.equalsIgnoreCase(MS.getUf()))
			return MS;
		else if(uf.equalsIgnoreCase(MG.getUf()))
			return MG;
		else if(uf.equalsIgnoreCase(PA.getUf()))
			return PA;
		else if(uf.equalsIgnoreCase(PB.getUf()))
			return PB;
		else if(uf.equalsIgnoreCase(PR.getUf()))
			return PR;
		else if(uf.equalsIgnoreCase(PE.getUf()))
			return PE;
		else if(uf.equalsIgnoreCase(PI.getUf()))
			return PI;
		else if(uf.equalsIgnoreCase(RJ.getUf()))
			return RJ;
		else if(uf.equalsIgnoreCase(RN.getUf()))
			return RN;
		else if(uf.equalsIgnoreCase(RS.getUf()))
			return RS;
		else if(uf.equalsIgnoreCase(RO.getUf()))
			return RO;
		else if(uf.equalsIgnoreCase(RR.getUf()))
			return RR;
		else if(uf.equalsIgnoreCase(SC.getUf()))
			return SC;
		else if(uf.equalsIgnoreCase(SP.getUf()))
			return SP;
		else if(uf.equalsIgnoreCase(SE.getUf()))
			return SE;
		else if(uf.equalsIgnoreCase(TO.getUf()))
			return TO;
		
		return null;
	}

} // enum UF
