package tsi.too.bvb.persistencia;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;

public abstract class BancoDeDadosDAO {
	
	private final String LOGIN_BD = "admin",
						 SENHA_BD = "123",
						 URL;
	private Connection conn;
	private PreparedStatement stmt;
	
	public BancoDeDadosDAO(String URL) {
		super();
		this.URL = URL;
	}

	protected void setConn(Connection conn) {
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	protected void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}
	
	public PreparedStatement getStmt() {
		return stmt;
	}

	public String getURL() {
		return URL;
	}

	protected void abrirConexao() throws SQLException {
		/*
		 * Não há mais necessidade de carregar o driver para acessar o banco de dados
		 * apartir da versão Java 1.6 (JDBC 4). O driver é reconhecido automaticamente.
		 * 
		 * Class.forName("org.hsqldb.jdbcDriver");
		 */
		
		conn = DriverManager.getConnection(URL, LOGIN_BD, SENHA_BD);
	}
	
	public PreparedStatement obterPreparedStatement(String sql) throws SQLException {
		return stmt = conn.prepareStatement(sql);
	}
	
	public ResultSet obterResultSet() throws SQLException {
		return stmt.executeQuery();
	}
	
	public void fecharPreparedStatement() throws SQLException {
		stmt.close();
	}
	
	public void fecharConexao() throws SQLException {
		conn.close();
	}
	
	public static void fecharResultSet(ResultSet rSet) throws SQLException {
		rSet.close();
	}
	
	public void fecharTudo() throws SQLException {
		fecharPreparedStatement();
		fecharConexao();
	}
	
	// Executa arquivos .sql
	/** Abre e executa os comando de um arquivo SQL
	 * @param enderecoArqSQL <code>String</code> com o endereco do arquivo sql
	 * @return <code>boolean</code> com <code>true</code> se o arquivo foi aberto e executado e <code>false</code> senão.
	 * @throws SQLException possível erro gerado por má configuração do banco de dados
	 * @throws IOException possivel erro ao abrir o arquivo
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

	@Override
	protected void finalize() throws Throwable {
		fecharTudo();
	}
	
} // class DaoHelper
