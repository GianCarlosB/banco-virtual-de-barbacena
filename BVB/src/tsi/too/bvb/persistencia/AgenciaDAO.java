package tsi.too.bvb.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tsi.too.bvb.entidades.agencia.Agencia;

public class AgenciaDAO {
	
	public AgenciaDAO() {
		super();
	}

	public void criar(BancoDeDadosDAO bdDao, Agencia agencia) {
		final String sql = "INSERT INTO agencia VALUES (?, ?)";

		try {
			bdDao.executarComandoSQL(sql);
			bdDao.getStmt().setInt(1, agencia.getCodAgencia());
			bdDao.getStmt().setString(2, agencia.getDescricao());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Agência inserida.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int proximoValorSequencia(BancoDeDadosDAO bdDao) {
		final String sql = "CALL NEXT VALUE FOR seq_agencia";
		int proximoValor = 0;
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			rSet.next();
			
			proximoValor = rSet.getInt(1);
			System.out.println("Próxima chave: " + proximoValor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return proximoValor;
	}
	
	public List<Agencia> ler(BancoDeDadosDAO bdDao) {
		List<Agencia> lista = new ArrayList<>();
		final String sql = "SELECT * FROM agencia";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next())
				lista.add(new Agencia(rSet.getInt(1), rSet.getString(2)));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Agencia pesquisarCodigo(BancoDeDadosDAO bdDao, String codigo) {
		Agencia agencia = new Agencia();
		final String sql = "SELECT * FROM agencia WHERE codAgencia = " + codigo;
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			agencia.setCodAgencia(rSet.getInt(1));
			agencia.setDescricao(rSet.getString(2));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return agencia;
	}
	
	public List<Agencia> pesquisarDescricao(BancoDeDadosDAO bdDao, String descricao) {
		List<Agencia> lista = new ArrayList<>();
		final String sql = "SELECT * FROM agencia WHERE LCASE (descricao) LIKE \'%" + descricao.toLowerCase() + "%\'";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Agencia agencia = new Agencia(rSet.getInt(1), rSet.getString(2));
				
				lista.add(agencia);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void excluir(BancoDeDadosDAO bdDao, String codigo) {
		final String sql = "DELETE FROM agencia WHERE codAgencia = " + codigo;
		
		bdDao.executarComandoSQL(sql);
		
		try {
			bdDao.getStmt().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

} // class AgenciaDAO
