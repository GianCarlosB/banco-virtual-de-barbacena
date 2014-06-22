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

import tsi.too.bvb.gui.JanelaPopUpErro;

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

	public Connection getConn() {
		return conn;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

	public void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}

	public String getURL() {
		return URL;
	}

	protected boolean abrirConexao() {
		/*
		 * Não há mais necessidade de carregar o driver para acessar o banco de dados
		 * apartir da versão Java 1.6 (JDBC 4). O driver é reconhecido automaticamente.
		 * 
		 * Class.forName("org.hsqldb.jdbcDriver");
		 */
		
		try {
			conn = DriverManager.getConnection(URL, LOGIN_BD, SENHA_BD);
			return true;
		} catch (SQLException e) {
			conn = null;
			new JanelaPopUpErro(null, "BVB - ERRO", " Falha na aquisição do bloqueio do banco de dados!", e);
			return false;
		}
	}
	
	public PreparedStatement obterPreparedStatement(String sql) {
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return stmt;
	}
	
	public ResultSet obterResultSet() {
		ResultSet rset = null;
		
		try {
			rset = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return rset;
	}
	
	public boolean fecharPreparedStatement() {
		if(stmt == null) return false;
		
		try {
			stmt.close();
			return true;
		} catch (SQLException e) { return false; }
	}
	
	public boolean fecharConexao() {
		if(conn == null) return false;
		
		try {
			conn.close();
			return true;
		} catch (SQLException e) { 
			new JanelaPopUpErro(null, "BVB - ERRO", " Falha na finalização da conexão com o banco de dados!", e);
			return false; 
		}
	}
	
	public static boolean fecharResultSet(ResultSet rSet) {
		if(rSet == null) return false;
		
		try {
			rSet.close();
			return true;
		} catch (SQLException e) { return false; }
	}
	
	public boolean fecharTudo() {
		fecharPreparedStatement();
		if(!fecharConexao())
			return false;
		
		return true;
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
