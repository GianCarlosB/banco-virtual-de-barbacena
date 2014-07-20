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

/** Classe para manipular os dados dos clientes no banco de dados
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 *
 */
public class ClienteDAO {
	
	/** Cria um <code>ClienteDAO</code> para realizar o CRUD do cliente
	 */
	public ClienteDAO() {
		super();
	}
	
	/** Insere um cliente no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param cliente <code>Cliente</code> que será inserido no banco de dados
	 * @return <code>boolean</code> com <code>true</code> caso tenha inserido com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Cliente
	 */
	public boolean criar(BancoDeDadosDAO bdDao, Cliente cliente) {
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
			
			System.out.println("Cliente inserido");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
	/** Pesquisa um cliente pelo cpf no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param cpf <code>String</code> referênte ao cpf que será procurado
	 * @return <code>Cliente</code> com os dados do cliente encontrado ou <code>null</code> caso não encontre
	 * 
	 * @see BancoDeDadosDAO
	 * @see Cliente
	 */
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

	/** Pesquisa os cliente pelo nome no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param nome <code>String</code> referênte ao nome que será procurada
	 * @return Uma lista de <code>Cliente</code> com os dados do(s) cliente(s) encontrado(s) ou <code>null</code> caso não encontre nem um
	 * 
	 * @see BancoDeDadosDAO
	 * @see Cliente
	 * @see List
	 */
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
	
	/** Altera os dados de um cliente no banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param cliente <code>Cliente</code> cujo cpf é referênte ao cpf do cliente que será alterado
	 * @param coluna <code>String</code> referênte a coluna do banco de dados que será alterado
	 * @param dado <code>String</code> referênte ao dado que será alterado
	 * @return <code>boolean</code> com <code>true</code> caso tenha alterado com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 * @see Cliente
	 */
	public boolean alterar(BancoDeDadosDAO bdDao, Cliente cliente, String coluna, String dado) {
		final String SQL= String.format("UPDATE cliente SET %s = ? WHERE CPF = ?", coluna);
		
		try{
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, dado);
			bdDao.getStmt().setString(2, cliente.getCpf());
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Cliente atualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
	/** Exclui um cliente do banco de dados
	 * 
	 * @param bdDao <code>BancoDeDadosDAO</code> referênte a instância do banco de dados onde os métodos de acesso ao banco estão localizados
	 * @param cpf <code>String</code> referênte ao cpf do cliente que será excluído
	 * @return <code>boolean</code> com <code>true</code> caso tenha excluído com sucesso, e <code>false</code> caso contrário
	 * 
	 * @see BancoDeDadosDAO
	 */
	public boolean excluir(BancoDeDadosDAO bdDao, String cpf) {
		final String SQL = "DELETE FROM cliente WHERE cpf = ?";
		
		try {
			bdDao.obterPreparedStatement(SQL);
			bdDao.getStmt().setString(1, cpf);
			bdDao.getStmt().executeUpdate();
			
			System.out.println("Cliente deletado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			return false;
		}
		
		return true;
	}
	
} // class ClienteDAO
