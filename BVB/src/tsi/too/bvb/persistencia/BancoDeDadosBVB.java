package tsi.too.bvb.persistencia;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tsi.too.bvb.gui.JanelaPopUpErro;

/** Classe para manipular o banco de dados do sistema
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see BancoDeDadosDAO
 */
public class BancoDeDadosBVB extends BancoDeDadosDAO implements Runnable {
	
	private final static String DIRETORIO = "database\\bvbdb"; // URL de accesso ao banco de dados.
	
	private final static String ARQ_SQL_CRIAR_TABELAS = "src\\tsi\\too\\bvb\\recursos\\scripts\\CriarTabelas.sql";
	
	private final static String ARQ_SQL_DELETAR_TABELAS = "src\\tsi\\too\\bvb\\recursos\\scripts\\DeletarTabelas.sql";
	
	private final static String ARQ_SQL_INSERIR_ADM = "src\\tsi\\too\\bvb\\recursos\\scripts\\InserirAdministrador.sql";

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
	
	public static boolean resetarDadosBD() {
		try {
			BANCO_DE_DADOS_BVB.abrirArquivoSQL(ARQ_SQL_DELETAR_TABELAS);
			BANCO_DE_DADOS_BVB.abrirArquivoSQL(ARQ_SQL_CRIAR_TABELAS);
			BANCO_DE_DADOS_BVB.abrirArquivoSQL(ARQ_SQL_INSERIR_ADM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		} catch (IOException e) {
			// TODO: handle exception
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
	public static void encerrarBD() {
		// Fecha o PreparedStatement.
		try {
			if(BancoDeDadosBVB.getInstance().getStmt() != null) BancoDeDadosBVB.getInstance().fecharPreparedStatement();
		} catch (SQLException eStmt) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", eStmt);
		} finally {
			// Fecha a conexão com o banco de dados e finaliza a aplicação.
			try {
				BancoDeDadosBVB.getInstance().fecharConexao();
				System.out.println("Conexão com o Banco de dados finalizada: " +
				                   new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format(new Date()));
			} catch (SQLException | NullPointerException e) {
				// TODO Auto-generated catch block
				new JanelaPopUpErro(null, "BVB - ERRO", e);
				System.err.println("Conexão com o Banco de dados NÃO finalizada: " +
				                   new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format(new Date()));
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {}
		finally {
			try {
				this.abrirConexao();
				System.out.println("Banco de dados iniciado: " + new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format( new Date()) +
				                   "\nURL da conexão: " + URL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				new JanelaPopUpErro(null, "BVB - ERRO", e);
				System.err.println("Banco de dados NÃO iniciado: " + new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").format( new Date()) +
		                           "\nURL da conexão: " + URL);
				BANCO_DE_DADOS_BVB.setConn(null);
			}
		}
	}

} // class BancoDeDadosBVB
