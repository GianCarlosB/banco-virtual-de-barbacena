package tsi.too.bvb.persistencia;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.entidades.tiposenumerados.TipoConta;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.validacoes.Criptografia;

public class ContaBancariaDAO {

	public ContaBancariaDAO() {
		super();
	}
	
	public void criar(BancoDeDadosDAO bdDao, ContaBancaria contaBancaria) {
		final String SQL = "INSERT INTO conta_bancaria VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setInt(1, contaBancaria.getNumConta());
			bdDao.getStmt().setInt(2, contaBancaria.getCodAgencia());
			bdDao.getStmt().setInt(3, contaBancaria.getTipoConta().getNumero());
			bdDao.getStmt().setString(4, contaBancaria.getCpf());
			bdDao.getStmt().setBoolean(5, contaBancaria.isContaSalario());
			bdDao.getStmt().setDate(6, new java.sql.Date(contaBancaria.getDataAbertura().getTime()));
			bdDao.getStmt().setDouble(7, contaBancaria.getSaldo());
			bdDao.getStmt().setString(8, Criptografia.converterSenhaParaMD5(contaBancaria.getSenhaNumerica()));
			bdDao.getStmt().setString(9, Criptografia.converterSenhaParaMD5(contaBancaria.getSenhaAlfabetica()));
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Conta Bancária inserida");
		} catch (SQLException | NoSuchAlgorithmException e) {
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
			
			contaBancaria.setNumConta(rSet.getInt(1));
			contaBancaria.setCodAgencia(rSet.getInt(2));
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
	
	public List<ContaBancaria> pesquisarCorrentista(BancoDeDadosDAO bdDao, String cpf, TipoConta tipoConta) {
		List<ContaBancaria> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM conta_bancaria WHERE CPF = ?  AND tipoConta = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, cpf);
			bdDao.getStmt().setInt(2, tipoConta.getNumero());
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			do {
				ContaBancaria contaBancaria = new ContaBancaria(rSet.getInt(1), rSet.getInt(2), TipoConta.obterTipoConta(rSet.getInt(3)),
						                                        rSet.getString(4), rSet.getDate(6), rSet.getString(8), rSet.getString(9),
						                                        rSet.getBoolean(5), rSet.getDouble(7));
				
				lista.add(contaBancaria);
			}while(rSet.next());
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	public List<ContaBancaria> pesquisarContas(BancoDeDadosDAO bdDao, Date data) {
		List<ContaBancaria> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM conta_bancaria WHERE MONTH(dataAbertura) = " +
				           "MONTH(CAST(? AS DATE)) AND YEAR(dataAbertura) = YEAR(CAST(? AS DATE))";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setDate(1, new java.sql.Date(data.getTime()));
			bdDao.getStmt().setDate(2, new java.sql.Date(data.getTime()));
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			do {
				ContaBancaria contaBancaria = new ContaBancaria(rSet.getInt(1), rSet.getInt(2), TipoConta.obterTipoConta(rSet.getInt(3)),
						                                        rSet.getString(4), rSet.getDate(6), rSet.getString(8), rSet.getString(9),
						                                        rSet.getBoolean(5), rSet.getDouble(7));

				lista.add(contaBancaria);
			}while(rSet.next());
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	public Set<Date> pesquisarDatasContasAgencia(BancoDeDadosDAO bdDao, String codigo, Date dataIni, Date dataFin) {
		Set<Date> set = new HashSet<>();
		final String SQL = "SELECT * FROM conta_bancaria WHERE codAgencia = ? AND MONTH(dataAbertura) BETWEEN MONTH(CAST(? AS DATE)) AND " +
				           "MONTH(CAST(? AS DATE)) AND YEAR(dataAbertura) BETWEEN YEAR(CAST(? AS DATE)) AND YEAR(CAST(? AS DATE))";
		Calendar cal = Calendar.getInstance();
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, codigo);
			bdDao.getStmt().setDate(2, new java.sql.Date(dataIni.getTime()));
			bdDao.getStmt().setDate(3, new java.sql.Date(dataFin.getTime()));
			bdDao.getStmt().setDate(4, new java.sql.Date(dataIni.getTime()));
			bdDao.getStmt().setDate(5, new java.sql.Date(dataFin.getTime()));
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			 do {
				cal.setTime(rSet.getDate(6));
				cal.set(Calendar.DAY_OF_MONTH, 1);
				set.add(cal.getTime());
			}while(rSet.next());
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return set;
	}
	
	public List<ContaBancaria> pesquisarContasAgencia(BancoDeDadosDAO bdDao, String codigo) {
		List<ContaBancaria> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM conta_bancaria WHERE codAgencia = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, codigo);
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			 do {
				ContaBancaria contaBancaria = new ContaBancaria(rSet.getInt(1), rSet.getInt(2), TipoConta.obterTipoConta(rSet.getInt(3)),
						                                        rSet.getString(4), rSet.getDate(6), rSet.getString(8), rSet.getString(9),
						                                        rSet.getBoolean(5), rSet.getDouble(7));
				
				lista.add(contaBancaria);
			}while(rSet.next());
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	public List<ContaBancaria> pesquisarContasAgencia(BancoDeDadosDAO bdDao, String codigo, Date data) {
		List<ContaBancaria> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM conta_bancaria WHERE codAgencia = ? AND MONTH(dataAbertura) = " +
				           "MONTH(CAST(? AS DATE)) AND YEAR(dataAbertura) = YEAR(CAST(? AS DATE))";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, codigo);
			bdDao.getStmt().setDate(2, new java.sql.Date(data.getTime()));
			bdDao.getStmt().setDate(3, new java.sql.Date(data.getTime()));
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			do {
				ContaBancaria contaBancaria = new ContaBancaria(rSet.getInt(1), rSet.getInt(2), TipoConta.obterTipoConta(rSet.getInt(3)),
						                                        rSet.getString(4), rSet.getDate(6), rSet.getString(8), rSet.getString(9),
						                                        rSet.getBoolean(5), rSet.getDouble(7));

				lista.add(contaBancaria);
			}while(rSet.next());
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	public void alterarSaldo(BancoDeDadosDAO bdDao, ContaBancaria contaBancaria) {
		final String SQL = "UPDATE conta_bancaria SET saldo = ? WHERE numeroConta = ?";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setDouble(1, contaBancaria.getSaldo());
			bdDao.getStmt().setInt(2, contaBancaria.getNumConta());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Saldo da Conta Bancária Atualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
	}
	
	public void alterarTipoConta(BancoDeDadosDAO bdDao, ContaBancaria contaBancaria) {
		final String SQL = "UPDATE conta_bancaria SET tipoConta = ? WHERE numeroConta = ?";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setInt(1, contaBancaria.getTipoConta().getNumero());
			bdDao.getStmt().setInt(2, contaBancaria.getNumConta());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Tipo da Conta Bancária Atualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
	}

} // class ContaBancariaDAO
