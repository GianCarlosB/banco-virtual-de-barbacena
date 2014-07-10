package tsi.too.bvb.persistencia;

import java.sql.SQLException;
import java.util.Calendar;

import tsi.too.bvb.entidades.movimentacao.Movimentacao;
import tsi.too.bvb.gui.JanelaPopUpErro;

public class MovimentacaoDAO {
	
	public MovimentacaoDAO() {
		super();
	}

	public void criar(BancoDeDadosDAO bdDao, Movimentacao movimentacao) {
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
		}
	}
	
} // class MovimentacaoDAO
