package tsi.too.bvb.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tsi.too.bvb.gui.JanelaPopUpErro;

public abstract class BancoDeDadosDAO {
	
	private final String URL;
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

	protected void abrirConexao() {
		/*
		 * Não há mais necessidade de carregar o driver para acessar o banco de dados
		 * apartir da versão Java 1.6 (JDBC 4). O driver é reconhecido automaticamente.
		 * 
		 * Class.forName("org.hsqldb.jdbcDriver");
		 */
		
		try {
			conn = DriverManager.getConnection(URL, "admin", "123");
		} catch (SQLException e) {
			conn = null;
			new JanelaPopUpErro(null, "BVB - ERRO", " Falha na aquisição de bloqueio do banco de dados!", e);
		}
	}
	
	public PreparedStatement obterPreparedStatement(String sql) {
		try {
			stmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		}
		
		return rset;
	}
	
	public void fecharPreparedStatement() {
		if(stmt == null) return;
		
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fecharConexao() {
		if(conn == null) return;
		
		try {
			conn.close();
			System.out.println("Conexão com o Banco de dados finalizada: " + new SimpleDateFormat("dd/MM/yyyy  HH:mm").format(new Date()));
		} catch (SQLException e) {
			new JanelaPopUpErro(null, "BVB - ERRO", " Falha na finalização da conexão com o banco de dados!", e);
		}
	}
	
	public static void fecharResultSet(ResultSet rSet) {
		if(rSet == null) return;
		
		try {
			rSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fecharTudo() {
		fecharPreparedStatement();
		fecharConexao();
	}

	@Override
	protected void finalize() throws Throwable {
		fecharTudo();
	}
	
} // class DaoHelper
