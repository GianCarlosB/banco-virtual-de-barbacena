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
		final String sql = "INSERT INTO agencia VALUES (NEXT VALUE FOR seq_agencia, ?)";

		try {
			bdDao.executarComandoSQL(sql);
			bdDao.getStmt().setString(1, agencia.getDescricao());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Agência inserida: ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

} // class AgenciaDAO
