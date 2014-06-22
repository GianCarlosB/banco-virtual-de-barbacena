package tsi.too.bvb.persistencia;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BancoDeDadosBVB extends BancoDeDadosDAO implements Runnable {
	
	private final static String DIRETORIO = "database\\bvbdb", // URL de accesso ao banco de dados.
								ARQ_SQL_CRIAR_TABELAS = "src\\tsi\\too\\bvb\\recursos\\scripts\\CriarTabelas.sql",
			                    ARQ_SQL_DELETAR_TABELAS = "src\\tsi\\too\\bvb\\recursos\\scripts\\DeletarTabelas.sql",
			                    ARQ_SQL_INSERIR_ADM = "src\\tsi\\too\\bvb\\recursos\\scripts\\InserirAdministrador.sql";

	private static final String TIPO = "jdbc:hsqldb:file:";

	private final static String URL = TIPO + DIRETORIO;
	
	/** <code>BancoDeDadosBVB</code> com a instâncoa do banco de dados */
	protected static BancoDeDadosBVB BANCO_DE_DADOS_BVB = new BancoDeDadosBVB();
	
	/** Cria uma instância do banco de dados do sistema
	 * 
	 */
	protected BancoDeDadosBVB() {
		super(URL);
	}
	
	/** Retorna a instancia do banco de dados do sistema
	 * @return <code>BancoDeDadosBVB</code> com a instancia da classe
	 */
	public static BancoDeDadosBVB getInstance() {
		return BANCO_DE_DADOS_BVB;
	}
	
	public static int resetarDadosBD() {
		try {
			BANCO_DE_DADOS_BVB.abrirArquivoSQL(ARQ_SQL_DELETAR_TABELAS);
			BANCO_DE_DADOS_BVB.abrirArquivoSQL(ARQ_SQL_CRIAR_TABELAS);
			BANCO_DE_DADOS_BVB.abrirArquivoSQL(ARQ_SQL_INSERIR_ADM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 2;
		}
		
		return 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {}
		finally {
			if(this.abrirConexao())  
				System.out.println("Banco de dados iniciado: " + new SimpleDateFormat("dd/MM/yyyy  HH:mm").format( new Date()) +
						           "\nURL da conexão: " + URL);
			else
				System.err.println("Banco de dados NÃO iniciado: " + new SimpleDateFormat("dd/MM/yyyy  HH:mm").format( new Date()) +
				                   "\nURL da conexão: " + URL);
		}
	}

} // class BancoDeDadosBVB
