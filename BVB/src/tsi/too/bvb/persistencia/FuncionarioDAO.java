package tsi.too.bvb.persistencia;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.validacoes.Criptografia;

/** Classe para manipular os dados dos funcionários no banco de dados
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 *
 */
public class FuncionarioDAO {
	
	/** Cria um <code>FuncionarioDAO</code> para realizar o CRUD do funcionário
	 */
	public FuncionarioDAO() {
		super();
	}

	/** Insere um funcionário no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param funcionario <code>Funcionario</code> que será inserido no banco de dados
	 * @return <code>boolean</code> com <code>true</code> caso tenha inserido com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Funcionario
	 */
	public boolean criar(BancoDeDadosDAO bdDao, Funcionario funcionario) {
		final String SQL = "INSERT INTO funcionario VALUES (?, ?, ?)";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, funcionario.getNomeUsuario());
			bdDao.getStmt().setString(2, Criptografia.converterSenhaParaMD5(funcionario.getSenha()));
			bdDao.getStmt().setString(3, Character.toString(funcionario.getTipoUsuario().getCaractere()));
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Funcionário inserido");
		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
	/** Pesquisa um funcionário pelo login no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param login <code>String</code> referênte ao login do funcionário que será procurado
	 * @return <code>Funcionario</code> com os dados do funcionário encontrado ou <code>null</code> caso não encontre
	 * 
	 * @see BancoDeDadosDAO
	 * @see Funcionario
	 */
	public Funcionario pesquisarLoginUnico(BancoDeDadosDAO bdDao, String login) {
		Funcionario funcionario = new Funcionario();
		final String SQL = "SELECT * FROM funcionario WHERE LCASE (nomeUsuario) LIKE ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, login.toLowerCase());
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			funcionario.setNomeUsuario(rSet.getString(1));
			funcionario.setSenha(rSet.getString(2));
			funcionario.setTipoUsuario(TipoUsuario.obterTipoUsuario(rSet.getString(3).charAt(0)));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return funcionario;
	}
	
	/** Pesquisa os funcionários pelo login no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param login <code>String</code> referênte ao login do funcionário que será procurado
	 * @return Uma lista de <code>Funcionario</code> com os dados do(s) funcionário(s) encontrado(s) ou <code>null</code> caso não encontre nem um
	 * 
	 * @see BancoDeDadosDAO
	 * @see Funcionario
	 * @see List
	 */
	public List<Funcionario> pesquisarLogin(BancoDeDadosDAO bdDao, String login) {
		List<Funcionario> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM funcionario WHERE LCASE (nomeUsuario) LIKE ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, "%" + login.toLowerCase() + "%");
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Funcionario funcionario = new Funcionario(rSet.getString(1), rSet.getString(2),
						                                  TipoUsuario.obterTipoUsuario(rSet.getString(3).charAt(0)));
				
				lista.add(funcionario);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	/** Pesquisa os funcionários pelo tipo no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param tipoUsuario <code>TipoUsuario</code> referênte ao tipo do funcionário que será procurado
	 * @return Uma lista de <code>Funcionario</code> com os dados do(s) funcionário(s) encontrado(s) ou <code>null</code> caso não encontre nem um
	 * 
	 * @see BancoDeDadosDAO
	 * @see Funcionario
	 * @see TipoUsuario
	 * @see List
	 */
	public List<Funcionario> pesquisarTipo(BancoDeDadosDAO bdDao, TipoUsuario tipoUsuario) {
		List<Funcionario> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM funcionario WHERE UCASE (tipoUsuario) LIKE ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, "%" + tipoUsuario.getCaractere() + "%");
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Funcionario funcionario = new Funcionario(rSet.getString(1), rSet.getString(2), TipoUsuario.obterTipoUsuario(rSet.getString(3).charAt(0)));
				
				lista.add(funcionario);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	/** Altera a senha de um funcionário no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param funcionario <code>Funcionario</code> cujo login é referênte ao login do funcionário que será alterado, e o senha 
	 * referênte a nova senha do usuário
	 * @return <code>boolean</code> com <code>true</code> caso tenha alterado com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Funcionario
	 */
	public boolean alterarSenha(BancoDeDadosDAO bdDao, Funcionario funcionario) {
		final String SQL = "UPDATE funcionario SET senha = ? WHERE LCASE (nomeUsuario) LIKE ?";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, funcionario.getSenha());
			bdDao.getStmt().setString(2, funcionario.getNomeUsuario().toLowerCase());
			bdDao.getStmt().executeUpdate();

			System.out.println("Senha do funcionário atualizada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
	/** Altera o tipo de um funcionário no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param funcionario <code>Funcionario</code> cujo login é referênte ao login do funcionário que será alterado
	 * @param tipoUsuario <code>TipoUsuario</code> referênte ao novo tipo do funcionário
	 * @return <code>boolean</code> com <code>true</code> caso tenha alterado com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Funcionario
	 * @see TipoUsuario
	 */
	public boolean alterarTipo(BancoDeDadosDAO bdDao, Funcionario funcionario, TipoUsuario tipoUsuario) {
		final String SQL = "UPDATE funcionario SET tipoUsuario = ? WHERE LCASE (nomeUsuario) = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, Character.toString(tipoUsuario.getCaractere()));
			bdDao.getStmt().setString(2, funcionario.getNomeUsuario().toLowerCase());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Tipo do funcionário atualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}

	/** Exclui um cleinte do banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param login <code>String</code> referênte ao login do funcinário que será excluído
	 * @return <code>boolean</code> com <code>true</code> caso tenha excluído com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 */
	public boolean excluir(BancoDeDadosDAO bdDao, String login) {
		final String SQL = "DELETE FROM funcionario WHERE LCASE (nomeUsuario) LIKE ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, "%" + login.toLowerCase() + "%");
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Funcionário deletado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
} // class FuncionarioDAO
