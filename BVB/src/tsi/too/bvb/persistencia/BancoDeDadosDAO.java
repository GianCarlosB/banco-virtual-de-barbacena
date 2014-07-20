package tsi.too.bvb.persistencia;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;

/** Classe para manipular o banco de dados
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * 
 * @see Connection
 * @see Statement
 */
public abstract class BancoDeDadosDAO {
	
	private final String LOGIN_BD = "admin";
	
	private final String SENHA_BD = "123";
	
	private final String URL;
	
	private Connection conn;
	
	private PreparedStatement stmt;
	
	/**
	   * O construtor cria uma nova conexão com o banco de dados contido
	   * na <code>String</code> passado como parâmetro. A conexão é possibilitada pelo driver
	   * JDBC do banco de dados.
	   * 
	   * @param URL <code>String</code> com endereço do banco de dados.
	   */
	public BancoDeDadosDAO(String URL) {
		super();
		this.URL = URL;
	}

	/** Seta a conexão com o bando de dados
	 * @param conn <code>Connection</code> com a conexão com o banco de dados
	 * @see Connection
	 */
	protected void setConn(Connection conn) {
		this.conn = conn;
	}
	
	/** Retorna um <code>Connection</code> com a conexão com o banco de dados
	 * @return <code>Connection</code> com a conexão com o banco de dados
	 * @see Connection
	 */
	public Connection getConn() {
		return conn;
	}

	/** Seta o executador de comandos SQL
	 * @param stmt <code>PreparedStatement</code> que é o executador de comandos SQL
	 * @see PreparedStatement
	 */
	protected void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}
	
	/** Retorna o <code>PreparedStatement</code> que é o executador de comandos SQL
	 * @return <code>PreparedStatement</code> que é o executador de comandos SQL
	 * @see PreparedStatement
	 */
	public PreparedStatement getStmt() {
		return stmt;
	}

	/** Retorna a URL com a conexão com o banco de dados
	 * @return <code>String</code> com URL da conexão com o banco de dados
	 */
	public String getURL() {
		return URL;
	}
	
	/** Abre a conexão com o banco de dados
	 * @throws SQLException possível erro gerado por má configuração do banco de dados
	 */
	protected void abrirConexao() throws SQLException {
		/*
		 * Não há mais necessidade de carregar o driver para acessar o banco de dados
		 * apartir da versão Java 1.6 (JDBC 4). O driver é reconhecido automaticamente.
		 * 
		 * Class.forName("org.hsqldb.jdbcDriver");
		 */
		
		conn = DriverManager.getConnection(URL, LOGIN_BD, SENHA_BD);
	}
	
	/** Armazena o comando SQL no <code>PreparedStatement</code>
	 * @param sql <code>String</code> com o comando SQL
	 * @return um <code>PreparedStatement</code>  que contém o comando SQL
	 * @throws SQLException possível erro gerado por má configuração do banco de dados
	 */
	public PreparedStatement obterPreparedStatement(String sql) throws SQLException {
		return stmt = conn.prepareStatement(sql);
	}
	
	/** Executa o comando SQL armazenado no <code>PreparedStatement</code>
	 * @return um <code>ResultSet</code> que contém os dados produzidos pelo comando SQL executado
	 * @throws SQLException possível erro gerado por má configuração do banco de dados
	 * @see ResultSet
	 */
	public ResultSet obterResultSet() throws SQLException {
		return stmt.executeQuery();
	}
	
	/** Fecha o executador de comandos SQL
	 * @throws SQLException possível erro gerado pela impossibilidade de fechar o <code>PreparedStatement</code>
	 */
	public void fecharPreparedStatement() throws SQLException {
		stmt.close();
	}
	
	/** Fecha a conexão com o banco de dados
	 * @throws SQLException possível erro gerado pela impossibilidade de fechar a <code>Connection</code>
	 */
	public void fecharConexao() throws SQLException {
		conn.close();
	}
	
	/** Fecha um <code>ResultSet</code> que contém os dados produzidos por um comando SQL executado
	 * @param rSet <code>ResultSet</code> que contém os dados produzidos por um comando SQL executado
	 * @throws SQLException possível erro gerado pela impossibilidade de fechar o <code>ResultSet</code>
	 */
	public static void fecharResultSet(ResultSet rSet) throws SQLException {
		rSet.close();
	}
	
	/** Fecha a conexão e o executador de comandos SQL
	 * @throws SQLException possível erro gerado pela impossibilidade de fechar a <code>Connection</code> ou o <code>PreparedStatement</code>
	 */
	public void fecharTudo() throws SQLException {
		fecharPreparedStatement();
		fecharConexao();
	}
	
	// Executa arquivos .sql
	/** Abre e executa os comando de um arquivo SQL
	 * @param enderecoArqSQL <code>String</code> com o endereco do arquivo sql
	 * @return <code>boolean</code> com <code>true</code> caso o arquivo tenha sido aberto e executado e <code>false</code> caso contrário
	 * @throws SQLException possível erro gerado por má configuração do banco de dados
	 * @throws IOException possível erro ao abrir o arquivo
	 */
	protected boolean abrirArquivoSQL(String enderecoArqSQL) throws SQLException, IOException {
		File arquivo = new File(enderecoArqSQL);
		SqlFile arquivoSql = new SqlFile(arquivo);
		boolean abriu = true;
		
		arquivoSql.setConnection(conn);
		
		try{
			arquivoSql.execute();
			abriu = true;
		}
		catch(SqlToolError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			abriu = false;
		}
		
		arquivoSql.closeReader();
		
		return abriu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	protected void finalize() throws Throwable {
		fecharTudo();
	}
	
} // class DaoHelper
