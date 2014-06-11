package tsi.too.bvb.entidades.tiposenumerados;

public enum TipoUsuario {
	
	ADMINISTRADOR('A', "Administrador", "É o responsável pela segurança do sistema.\n"
			+ "As suas funções se resumem em administrar o módulo Controle de Usuários.\n"
			+ "É o único usuário autorizado a cadastrar, alterar, consultar e excluir os dados\n"
			+ "de um funcionário e a visualizar e imprimir o arquivo de log de cada usuário.\n"),
	CAIXA('C', "Caixa", "Este funcionário possui as seguintes funções:\n"
			+ "1. cadastrar, consultar, alterar e imprimir os dados do cliente;\n"
			+ "2. consultar os dados das agências;\n"
			+ "3. abrir conta;\n"
			+ "4. depositar salário."),
	GERENTE('G', "Gerente", "É o responsável pela administração e coordenação dos serviços da agência bancária.\n"
			+ "Possui acesso irrestrito a todos os serviços do módulo Contas Bancárias. É o único funcionário que tem poderes para:\n"
			+ "1. excluir um cliente encerrando as suas contas bancárias;\n"
			+ "2. cadastrar, consultar, alterar, excluir e imprimir os dados das agências;\n"
			+ "3. criar aplicações financeiras;\n"
			+ "4. alterar o tipo de conta bancária de um cliente;\n"
			+ "5. ativar e desativar o módulo Caixa Eletrônico.");
	
	private char tipo;
	private String perfil, descricao;
	private final static int NUM_TIPOS = 3;

	private TipoUsuario(char tipo, String perfil, String descricao) {
		this.tipo = tipo;
		this.perfil = perfil;
		this.descricao = descricao;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
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

	public static String[] arrayTipos() {
		String arrayTipos[] = new String[NUM_TIPOS];
		int i = 0;
		
		arrayTipos[i++] = ADMINISTRADOR.getPerfil();
		arrayTipos[i++] = CAIXA.getPerfil();
		arrayTipos[i++] = GERENTE.getPerfil();
		
		return arrayTipos;
	}
	
	public static TipoUsuario obterTipoUsuario(String tipo) {
		if(tipo.equalsIgnoreCase(ADMINISTRADOR.getPerfil()))
			return ADMINISTRADOR;
		else if(tipo.equalsIgnoreCase(CAIXA.getPerfil()))
			return CAIXA;
		else if(tipo.equalsIgnoreCase(GERENTE.getPerfil()))
			return GERENTE;
		
		return null;
	}
	
	public static TipoUsuario obterTipoUsuario(char tipo) {
		if(tipo == ADMINISTRADOR.getTipo())
			return ADMINISTRADOR;
		else if(tipo == CAIXA.getTipo())
			return CAIXA;
		else if(tipo == GERENTE.getTipo())
			return GERENTE;
		
		return null;
	}
	
} // enum TipoUsuario
