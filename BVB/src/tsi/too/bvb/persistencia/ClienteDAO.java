package tsi.too.bvb.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.cliente.Contato;
import tsi.too.bvb.entidades.cliente.Endereco;
import tsi.too.bvb.entidades.tiposenumerados.UF;
import tsi.too.bvb.gui.JanelaPopUpErro;

public class ClienteDAO {
	
	public ClienteDAO() {
		super();
	}

	public void criar(BancoDeDadosDAO bdDao, Cliente cliente) {
		final String SQL = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, cliente.getCpf());
			bdDao.getStmt().setString(2, cliente.getNome());
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
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
	}
	
	public Cliente pesquisarCpf(BancoDeDadosDAO bdDao, String cpf) {
		Cliente cliente = new Cliente();
		final String SQL = "SELECT * FROM cliente WHERE cpf = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, cpf);
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
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return cliente;
	}

	public List<Cliente> pesquisarNome(BancoDeDadosDAO bdDao, String nome) {
		List<Cliente> lista = new ArrayList<>();
		final String SQL = "SELECT * FROM cliente WHERE LCASE (nome) LIKE ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, "%" + nome.toLowerCase() + "%");
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
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
		
		return lista;
	}
	
	public void excluir(BancoDeDadosDAO bdDao, String cpf) {
		final String SQL = "DELETE FROM cliente WHERE cpf = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, cpf);
			bdDao.getStmt().executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
		}
	}
	
} // class ClienteDAO
