package tsi.too.bvb.entidades.tiposenumerados;

/** Enumeração com os estados do Brasil
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */ 
public enum UF {
	
	/** Estado do Acre */
	AC("AC", "Acre"),
	/** Estado de Alagoas */
	AL("AL", "Alagoas"),
	/** Estado do Amapá */
	AP("AP", "Amapá"),
	/** Estado do Amazonas*/
	AM("AM", "Amazonas"),
	/** Estado da Bahia*/
	BA("BA", "Bahia"),
	/** Estado do Ceará*/
	CE("CE", "Ceará"),
	/** Distrito Federal */
	DF("DF", "Distrito Federal"),
	/** Estado do Espírito Santo*/
	ES("ES", "Espírito Santo"),
	/** Estado de Goiás*/
	GO("GO", "Goiás"),
	/** Estado do Maranhão*/
	MA("MA", "Maranhão"),
	/** Estado do Mato Grosso*/
	MT("MT", "Mato Grosso"),
	/** Estado do Mato Grosso do Sul*/
	MS("MS", "Mato Grosso do Sul"),
	/** Estado de Minas Gerais*/
	MG("MG", "Minas Gerais"),
	/** Estado do Pará*/
	PA("PA", "Pará"),
	/** Estado da Paraíba*/
	PB("PB", "Paraíba"),
	/** Estado do Paraná*/
	PR("PR", "Paraná"),
	/** Estado de Pernambuco */
	PE("PE", "Pernambuco"),
	/** Estado do Piauí*/
	PI("PI", "Piauí"),
	/** Estado do Rio de Janeiro */
	RJ("RJ", "Rio de Janeiro"),
	/** Estado do Rio Grande do Norte */
	RN("RN", "Rio Grande do Norte"),
	/** Estado do Rio Grande do Sul */
	RS("RS", "Rio Grande do Sul"),
	/** Estado de Rondônia */
	RO("RO", "Rondônia"),
	/** Estado de Roraima */
	RR("RR", "Roraima"),
	/** Estado de Santa Catarina*/
	SC("SC", "Santa Catarina"),
	/** Estado de São Paulo*/
	SP("SP", "São Paulo"),
	/** Estado de Sergipe*/
	SE("SE", "Sergipe"),
	/** Estado do Tocantins*/
	TO("TO", "Tocantins");
	
	private String uf, estado;
	private final static int NUM_ESTADOS = 27;

	private UF(String uf, String estado) {
		this.uf = uf;
		this.estado = estado;
	}

	/** Retorna uma <code>String</code> o uf do estado
	 * @return <code>String</code> o uf do estado
	 */
	public String getUf() {
		return uf;
	}

	/** Retorna uma <code>String</code> o nome do estado
	 * @return <code>String</code> o nome do estado
	 */
	public String getEstado() {
		return estado;
	}

	/** Retorna um <code>int</code> o número de estados do Brasil
	 * @return <code>int</code> o número de estados do Brasil
	 */
	public static int getNUM_ESTADOS() {
		return NUM_ESTADOS;
	}
	
	/** Retorna um <code>String[]</code> com todos os estados do Brasil
	 * @return <code>String[]</code> com todos os estados do Brasil
	 */
	public static String[] obterArrayUF() {
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
	
	/** Obtém o estado da enumeração corresponte ao parâmetro passado
	 * @param uf <code>String</code> referêrente ao estado desejado
	 * @return <code>UF</code> com o estado desajado ou <code>null</code> caso não seja encontrado
	 */
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
