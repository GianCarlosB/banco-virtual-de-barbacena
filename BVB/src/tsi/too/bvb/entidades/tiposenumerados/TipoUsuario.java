package tsi.too.bvb.entidades.tiposenumerados;

/** Enumeração com os tipos de funcionários permitidos no sistema BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */ 
public enum TipoUsuario {
	
	/** Administrador */
	ADMINISTRADOR('A', "Administrador",
			  " É o responsável pela segurança do sistema. As suas funções se\n"
			+ " resumem em administrar o módulo Controle de Usuários. É o único\n"
			+ " usuário autorizado a cadastrar, alterar, consultar e excluir os\n"
			+ " dados de um funcionário e a visualizar e imprimir o arquivo de log\n"
			+ " de cada usuário."),
	/** Caixa */
	CAIXA('C', "Caixa",
			  " Este funcionário possui as seguintes funções:\n"
			+ " 1. cadastrar, consultar, alterar e imprimir os dados do cliente;\n"
			+ " 2. consultar os dados das agências;\n"
			+ " 3. abrir conta;\n"
			+ " 4. depositar salário."),
	/** Gerente */
	GERENTE('G', "Gerente",
			  " É o responsável pela administração e coordenação dos serviços da\n"
			+ " agência bancária. Possui acesso irrestrito a todos os serviços do\n"
			+ " módulo Contas Bancárias. É o único funcionário que tem poderes\n"
			+ " para:\n"
			+ " 1. excluir um cliente encerrando as suas contas bancárias;\n"
			+ " 2. cadastrar, consultar, alterar, excluir e imprimir os dados das\n"
			+ "    agências;"
			+ " 3. criar aplicações financeiras;\n"
			+ " 4. alterar o tipo de conta bancária de um cliente;\n"
			+ " 5. ativar e desativar o módulo Caixa Eletrônico.");
	
	private char caractere;
	private String perfil, descricao;
	private final static int NUM_TIPOS = 3;

	private TipoUsuario(char caractere, String perfil, String descricao) {
		this.caractere = caractere;
		this.perfil = perfil;
		this.descricao = descricao;
	}

	/** Retorna um <code>char</code> com o caractere do tipo de funcionário
	 * @return <code>char</code> com o caractere do tipo de funcionário
	 */
	public char getCaractere() {
		return caractere;
	}

	/** Retorna uma <code>String</code> com a perfil do tipo de funcionário
	 * @return <code>String</code> com a perfil do tipo de funcionário
	 */
	public String getPerfil() {
		return perfil;
	}

	/** Retorna uma <code>String</code> com a descrição do tipo de funcionário
	 * @return <code>String</code> com a descrição do tipo de funcionário
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
		
		arrayTipos[i++] = ADMINISTRADOR.getPerfil();
		arrayTipos[i++] = CAIXA.getPerfil();
		arrayTipos[i++] = GERENTE.getPerfil();
		
		return arrayTipos;
	}
	
	/** Obtém o tipo da enumeração corresponte ao parâmetro passado
	 * @param perfil <code>String</code> referêrente ao tipo desejado
	 * @return <code>TipoUsuario</code> com o tipo desajado ou <code>null</code> caso não seja encontrado
	 */
	public static TipoUsuario obterTipoUsuario(String perfil) {
		if(perfil.equalsIgnoreCase(ADMINISTRADOR.getPerfil()))
			return ADMINISTRADOR;
		else if(perfil.equalsIgnoreCase(CAIXA.getPerfil()))
			return CAIXA;
		else if(perfil.equalsIgnoreCase(GERENTE.getPerfil()))
			return GERENTE;
		
		return null;
	}
	
	/** Obtém o tipo da enumeração corresponte ao parâmetro passado
	 * @param caractere <code>char</code> referêrente ao tipo desejado
	 * @return <code>TipoUsuario</code> com o tipo desajado ou <code>null</code> caso não seja encontrado
	 */
	public static TipoUsuario obterTipoUsuario(char caractere) {
		if(caractere == ADMINISTRADOR.getCaractere())
			return ADMINISTRADOR;
		else if(caractere == CAIXA.getCaractere())
			return CAIXA;
		else if(caractere == GERENTE.getCaractere())
			return GERENTE;
		
		return null;
	}
	
} // enum TipoUsuario
