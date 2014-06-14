package tsi.too.bvb.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.cliente.Contato;
import tsi.too.bvb.entidades.cliente.Endereco;
import tsi.too.bvb.entidades.tiposenumerados.UF;

public class ClienteDAO {
	
	public ClienteDAO() {
		super();
	}

	public void criar(BancoDeDadosDAO bdDao, Cliente cliente) {
		final String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			bdDao.executarComandoSQL(sql);
			bdDao.getStmt().setString(1, cliente.getCpf().toLowerCase());
			bdDao.getStmt().setString(2, cliente.getNome().toLowerCase());
			bdDao.getStmt().setString(3, cliente.getEndereco().getLogradouro());
			bdDao.getStmt().setString(4, cliente.getEndereco().getNumero());
			bdDao.getStmt().setString(5, cliente.getEndereco().getComplemento());
			bdDao.getStmt().setString(6, cliente.getEndereco().getBairro());
			bdDao.getStmt().setString(7, cliente.getEndereco().getCidade());
			bdDao.getStmt().setString(8, cliente.getEndereco().getUf().getUf());
			bdDao.getStmt().setString(9, cliente.getEndereco().getCep());
			bdDao.getStmt().setString(10, cliente.getContato().getTelefoneFixo());
			bdDao.getStmt().setString(11, cliente.getContato().getTelefoneMovel());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Cliente inserido.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Cliente> ler(BancoDeDadosDAO bdDao) {
		List<Cliente> lista = new ArrayList<>();
		final String sql = "SELECT * FROM cliente";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Cliente cliente = new Cliente(rSet.getString(1), rSet.getString(2));
				Endereco endereco = new Endereco(rSet.getString(3), rSet.getString(4), rSet.getString(5), rSet.getString(6),
						                         rSet.getString(7), UF.obterUF(rSet.getString(8)), rSet.getString(9));
				Contato contato = new Contato(rSet.getString(10), rSet.getString(11));
				
				cliente.setEndereco(endereco);
				cliente.setContato(contato);
				
				lista.add(cliente);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Cliente pesquisarCpf(BancoDeDadosDAO bdDao, String cpf) {
		Cliente cliente = new Cliente();
		final String sql = "SELECT * FROM cliente WHERE cpf = " + cpf;
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			if(!rSet.next()) return null;
			
			cliente.setCpf(rSet.getString(1));
			cliente.setNome(rSet.getString(2));
			cliente.setEndereco(new Endereco(rSet.getString(3), rSet.getString(4), rSet.getString(5), rSet.getString(6),
					                         rSet.getString(7), UF.obterUF(rSet.getString(8)), rSet.getString(9)));
			cliente.setContato(new Contato(rSet.getString(10), rSet.getString(11)));
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}

	public List<Cliente> pesquisarNome(BancoDeDadosDAO bdDao, String nome) {
		List<Cliente> lista = new ArrayList<>();
		final String sql = "SELECT * FROM cliente WHERE nome LIKE \'%" + nome.toLowerCase() + "%\'";
		
		try {
			bdDao.executarComandoSQL(sql);
			ResultSet rSet = bdDao.obterResultSet();
			
			while(rSet.next()) {
				Cliente cliente = new Cliente(rSet.getString(1), rSet.getString(2));
				Endereco endereco = new Endereco(rSet.getString(3), rSet.getString(4), rSet.getString(5), rSet.getString(6),
						                         rSet.getString(7), UF.obterUF(rSet.getString(8)), rSet.getString(9));
				Contato contato = new Contato(rSet.getString(10), rSet.getString(11));
				
				cliente.setEndereco(endereco);
				cliente.setContato(contato);
				
				lista.add(cliente);
			}
			
			BancoDeDadosDAO.fecharResultSet(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void excluir(BancoDeDadosDAO bdDao, String cpf) {
		final String sql = "DELETE FROM cliente WHERE cpf = " + cpf;
		
		bdDao.executarComandoSQL(sql);
		
		try {
			bdDao.getStmt().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
} // class ClienteDAO
