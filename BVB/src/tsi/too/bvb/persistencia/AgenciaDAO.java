package tsi.too.bvb.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.gui.JanelaPopUpErro;

/** Classe para manipular os dados das agências no banco de dados
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 *
 */
public class AgenciaDAO {
	
	/** Cria uma <code>AgenciaDAO</code> para realizar o CRUD da agência
	 */
	public AgenciaDAO() {
		super();
	}

	/** Insere uma agência no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param agencia <code>Agencia</code> que será inserida no banco de dados
	 * @return <code>boolean</code> com <code>true</code> caso tenha inserido com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Agencia
	 */
	public boolean criar(BancoDeDadosDAO bdDao, Agencia agencia) {
		final String SQL = "INSERT INTO agencia VALUES (?, ?)";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setInt(1, agencia.getCodAgencia());
			bdDao.getStmt().setString(2, agencia.getDescricao());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Agência inserida");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
	/** Obtém o próximo valor do código da agência de sua respectiva sequência no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @return <code>int</code> com o próximo valor do código da agência
	 * 
	 * @see BancoDeDadosDAO
	 */
	public int proximoValorSequencia(BancoDeDadosDAO bdDao) {
		final String SQL = "CALL NEXT VALUE FOR seq_agencia";
		int proximoValor = 0;
		
		try {
			bdDao.obterPreparedStatement(SQL);
			ResultSet rSet = bdDao.obterResultSet();
			
			rSet.next();
			
			proximoValor = rSet.getInt(1);
			System.out.println("Próxima chave agência: " + proximoValor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return proximoValor;
	}
	
	/** Pesquisa uma agência pelo código no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param codigo <code>String</code> referênte ao código da agência que será procurado
	 * @return <code>Agencia</code> com os dados da agência encontrada ou <code>null</code> caso não encontre
	 * 
	 * @see BancoDeDadosDAO
	 * @see Agencia
	 */
	public Agencia pesquisarCodigo(BancoDeDadosDAO bdDao, String codigo) {
		Agencia agencia = new Agencia();
		final String SQL = "SELECT * FROM agencia WHERE codAgencia = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, codigo);
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			agencia.setCodAgencia(rSet.getInt(1));
			agencia.setDescricao(rSet.getString(2));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return agencia;
	}
	
	/** Pesquisa as agência pela descrição no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param descricao <code>String</code> referênte a descrição que será procurada
	 * @return Uma lista de <code>Agencia</code> com os dados da(s) agência(s) encontrada(s) ou <code>null</code> caso não encontre nem uma
	 * 
	 * @see BancoDeDadosDAO
	 * @see Agencia
	 * @see List
	 */
	public List<Agencia> pesquisarDescricao(BancoDeDadosDAO bdDao, String descricao) {
		List<Agencia> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM agencia WHERE LCASE (descricao) LIKE ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, "%" + descricao.toLowerCase() + "%");
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Agencia agencia = new Agencia(rSet.getInt(1), rSet.getString(2));
				
				lista.add(agencia);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	/** Altera a descrição de uma agência no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param agencia <code>Agencia</code> cujo código é referênte ao código da agência que será alterada
	 * @param descricao <code>String</code> referênte a descrição que será alterada
	 * @return <code>boolean</code> com <code>true</code> caso tenha alterado com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Agencia
	 */
	public boolean alterarDescricao(BancoDeDadosDAO bdDao, Agencia agencia, String descricao) {
		final String SQL = "UPDATE agencia SET descricao = ? WHERE codAgencia = ?";
		
		try{
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, descricao);
			bdDao.getStmt().setInt(2, agencia.getCodAgencia());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Descrição da agência atualizada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
	/** Exclui uma agência do banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param codigo <code>int</code> referênte ao código da agência que será excluída
	 * @return <code>boolean</code> com <code>true</code> caso tenha excluído com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 */
	public boolean excluir(BancoDeDadosDAO bdDao, String codigo) {
		final String SQL = "DELETE FROM agencia WHERE codAgencia = ?";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, codigo);
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Agência deletada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}

} // class AgenciaDAO
