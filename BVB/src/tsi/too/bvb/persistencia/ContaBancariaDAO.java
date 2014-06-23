package tsi.too.bvb.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.gui.JanelaPopUpErro;

public class ContaBancariaDAO {
	
	public ContaBancariaDAO() {
		super();
	}
	
	public void criar(BancoDeDadosDAO bdDao, ContaBancaria contaBancaria) {
		final String SQL = "INSERT INTO conta_bancaria VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setInt(1, contaBancaria.getCodAgencia());
			bdDao.getStmt().setInt(2, contaBancaria.getNumConta());
			bdDao.getStmt().setInt(3, contaBancaria.getTipoConta().getTipo());
			bdDao.getStmt().setString(4, contaBancaria.getCpf());
			bdDao.getStmt().setBoolean(5, contaBancaria.isContaSalario());
			bdDao.getStmt().setDate(6, new java.sql.Date(contaBancaria.getDataAbertura().getTime()));
			bdDao.getStmt().setDouble(7, contaBancaria.getSaldo());
			bdDao.getStmt().setString(8, contaBancaria.getSenhaNumerica());
			bdDao.getStmt().setString(9, contaBancaria.getSenhaAlfabetica());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Conta Bancária inserida.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
	}
	
	public int proximoValorSequencia(BancoDeDadosDAO bdDao) {
		final String SQL = "CALL NEXT VALUE FOR seq_conta_bancaria";
		int proximoValor = 0;
		
		try {
			bdDao.obterPreparedStatement(SQL);
			ResultSet rSet = bdDao.obterResultSet();
			
			rSet.next();
			
			proximoValor = rSet.getInt(1);
			System.out.println("Próxima chave conta bancária: " + proximoValor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return proximoValor;
	}
	
	public ContaBancaria pesquisarNumConta(BancoDeDadosDAO bdDao, String numero) {
		ContaBancaria contaBancaria = new ContaBancaria();
		final String SQL = "SELECT * FROM conta_bancaria WHERE numeroConta = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, numero);
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			contaBancaria.setCodAgencia(rSet.getInt(1));
			contaBancaria.setNumConta(rSet.getInt(2));
			contaBancaria.setTipoConta(TipoConta.obterTipoConta(rSet.getInt(3)));
			contaBancaria.setCpf(rSet.getString(4));
			contaBancaria.setContaSalario(rSet.getBoolean(5));
			contaBancaria.setDataAbertura(rSet.getDate(6));
			contaBancaria.setSaldo(rSet.getDouble(7));
			contaBancaria.setSenhaNumerica(rSet.getString(8));
			contaBancaria.setSenhaAlfabetica(rSet.getString(9));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return contaBancaria;
	}
	
	public void alterarSaldo(BancoDeDadosDAO bdDao, ContaBancaria contaBancaria) {
		final String SQL = "UPDATE conta_bancaria SET saldo = ? WHERE numeroConta = ?";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setDouble(1, contaBancaria.getSaldo());
			bdDao.getStmt().setInt(2, contaBancaria.getNumConta());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Saldo da Conta Bancária Atualizado.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
	}

} // class ContaBancariaDAO
