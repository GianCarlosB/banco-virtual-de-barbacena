package tsi.too.bvb.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;

public class FuncionarioDAO {
	
	public FuncionarioDAO() {
		super();
	}

	public void criar(BancoDeDadosDAO bdDao, Funcionario funcionario) {
		final String sql = "INSERT INTO funcionario VALUES (?, ?, ?)";
		
		try {
			bdDao.executarComandoSQL(sql);
			bdDao.getStmt().setString(1, funcionario.getNomeUsuario().toLowerCase());
			bdDao.getStmt().setString(2, funcionario.getSenha());
			bdDao.getStmt().setString(3, Character.toString(funcionario.getTipoUsuario().getTipo()));
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Funcionário inserido.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> ler(BancoDeDadosDAO bdDao) {
		List<Funcionario> lista = new ArrayList<>();
		final String sql = "SELECT * FROM funcionario";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next())
				lista.add(new Funcionario(rSet.getString(1), rSet.getString(2), TipoUsuario.obterTipoUsuario(rSet.getString(3))));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Funcionario pesquisarLoginUnico(BancoDeDadosDAO bdDao, String login) {
		Funcionario funcionario = new Funcionario();
		final String sql = "SELECT * FROM funcionario WHERE nomeUsuario LIKE '" + login.toLowerCase() + "'";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			funcionario.setNomeUsuario(rSet.getString(1));
			funcionario.setSenha(rSet.getString(2));
			funcionario.setTipoUsuario(TipoUsuario.obterTipoUsuario(rSet.getString(3).charAt(0)));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return funcionario;
	}
	
	public List<Funcionario> pesquisarLogin(BancoDeDadosDAO bdDao, String login) {
		List<Funcionario> lista = new ArrayList<>();
		final String sql = "SELECT * FROM funcionario WHERE nomeUsuario LIKE \'%" + login.toLowerCase() + "%\'";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Funcionario funcionario = new Funcionario(rSet.getString(1), rSet.getString(2),
						                                  TipoUsuario.obterTipoUsuario(rSet.getString(3).charAt(0)));
				
				lista.add(funcionario);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<Funcionario> pesquisarTipo(BancoDeDadosDAO bdDao, char tipo) {
		List<Funcionario> lista = new ArrayList<>();
		final String sql = "SELECT * FROM funcionario WHERE tipoUsuario LIKE \'%" + tipo + "%\'";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Funcionario funcionario = new Funcionario(rSet.getString(1), rSet.getString(2), TipoUsuario.obterTipoUsuario(rSet.getString(3)));
				
				lista.add(funcionario);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

	public void excluir(BancoDeDadosDAO bdDao, String login) {
		final String sql = "DELETE FROM funcionario WHERE nomeUsuario LIKE '" + login.toLowerCase() + "'";
		
		bdDao.executarComandoSQL(sql);
		
		try {
			bdDao.getStmt().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
} // class FuncionarioDAO
