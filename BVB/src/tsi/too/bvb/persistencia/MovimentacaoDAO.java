package tsi.too.bvb.persistencia;

import java.sql.SQLException;
import java.util.Calendar;

import tsi.too.bvb.entidades.movimentacao.Movimentacao;
import tsi.too.bvb.gui.JanelaPopUpErro;

/** Classe para manipular os dados das movimentações das contas bancárias no banco de dados
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 *
 */
public class MovimentacaoDAO {
	
	/** Cria uma <code>MovimentacaoDAO</code> para realizar o CRUD da movimentação
	 */
	public MovimentacaoDAO() {
		super();
	}

	/** Insere uma movimentação no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param movimentacao <code>Conexao</code> que será inserida no banco de dados
	 * @return <code>boolean</code> com <code>true</code> caso tenha inserido com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Movimentacao
	 */
	public boolean criar(BancoDeDadosDAO bdDao, Movimentacao movimentacao) {
		final String SQL = "INSERT INTO movimentacao VALUES (?, ?, ?, ?, ?, ?)";

		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(movimentacao.getDataHora());
			
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setInt(1, movimentacao.getNumConta());
			bdDao.getStmt().setInt(2, movimentacao.getCodAgencia());
			bdDao.getStmt().setInt(3, movimentacao.getTipoConta().getNumero());
			bdDao.getStmt().setDate(4, new java.sql.Date(cal.getTimeInMillis()));
			bdDao.getStmt().setDouble(5, movimentacao.getValor());
			bdDao.getStmt().setInt(6, movimentacao.getTipoOperacao().getNumero());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Movimentação inserida");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
} // class MovimentacaoDAO
