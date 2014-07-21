package tsi.too.bvb.eventos.menuprincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.cliente.Contato;
import tsi.too.bvb.entidades.cliente.Endereco;
import tsi.too.bvb.entidades.conexao.Conexao;
import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.entidades.tiposenumerados.TipoUsuario;
import tsi.too.bvb.gui.IgAjuda;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.JanelaPopUpPergunta;
import tsi.too.bvb.gui.agencia.IgCadAgencia;
import tsi.too.bvb.gui.agencia.IgConsultarAgencia;
import tsi.too.bvb.gui.agencia.IgRelatorioAgencia;
import tsi.too.bvb.gui.buscarcadastro.IgBuscarCadastro;
import tsi.too.bvb.gui.cliente.IgCadCliente;
import tsi.too.bvb.gui.cliente.IgConsultarCliente;
import tsi.too.bvb.gui.cliente.IgRelatorioCliente;
import tsi.too.bvb.gui.contabancaria.IgAbrirContaBancaria;
import tsi.too.bvb.gui.contabancaria.IgAlterarTipoAplicacao;
import tsi.too.bvb.gui.contabancaria.IgCriarAplicacao;
import tsi.too.bvb.gui.contabancaria.IgDepositarSal;
import tsi.too.bvb.gui.excluircadastro.IgExcluirCadastro;
import tsi.too.bvb.gui.funcionario.IgAltSenhaFuncionario;
import tsi.too.bvb.gui.funcionario.IgCadFuncionario;
import tsi.too.bvb.gui.funcionario.IgConsultarFuncionario;
import tsi.too.bvb.gui.funcionario.IgRelatorioFuncionario;
import tsi.too.bvb.gui.menuprincipal.IgMenuPrincipal;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ConexaoDAO;

/** Classe para tratar os eventos de ação da janela <code>IgMenuPrincipal</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionMenuPrincipal implements ActionListener {
	
	private IgMenuPrincipal igMenuPrincipal;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgMenuPrincipal</code>
	 * @param igMenuPrincipal <code>IgMenuPrincipal</code> que será manipulada
	 */
	public TEActionMenuPrincipal(IgMenuPrincipal igMenuPrincipal) {
		super();
		this.igMenuPrincipal = igMenuPrincipal;
	}
	
	/** Trata os eventos de ação dos elementos da janela <code>IgMenuPrincipal</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if((e.getSource() == igMenuPrincipal.getAjudaBtn()) || (e.getSource() == igMenuPrincipal.getAjudaImgBtn()))
			new IgAjuda(igMenuPrincipal);
		
		else if(e.getSource() == igMenuPrincipal.getMntmAutor())
			new JanelaPopUpInfo(igMenuPrincipal, "BVB - Sobre", " Criado por:\n     Diego Oliveira   &   Gian Carlos Barros Honório",
					"Copyright \u00A9 2001-2014, BVB vers\u00E3o 1.04. Software criado por"
					+ "\nDiego Oliveira & Gian Carlos para avalia\u00E7\u00E3o na disciplina"
					+ "\nde Tecnologia de Orienta\u00E7\u00E3o a Objetos do Curso Superior de"
					+ "\nTecnologia em Sistemas para internet do Instituto Federal do Sudeste"
					+ "\nde Minas Gerais C\u00E2mpus Barbacena. Prof. M\u00E1rlon.");
		
		else if(e.getSource() == igMenuPrincipal.getMntmAdministrador())
			new JanelaPopUpInfo(igMenuPrincipal, "BVB - Funcionários - Administrador", " Tipo: " + TipoUsuario.ADMINISTRADOR.getPerfil(),
					            TipoUsuario.ADMINISTRADOR.getDescricao());
		
		else if(e.getSource() == igMenuPrincipal.getMntmCaixa())
			new JanelaPopUpInfo(igMenuPrincipal, "BVB - Funcionários - Caixa", " Tipo: " + TipoUsuario.CAIXA.getPerfil(),
					            TipoUsuario.CAIXA.getDescricao());
		
		else if(e.getSource() == igMenuPrincipal.getMntmGerente())
			new JanelaPopUpInfo(igMenuPrincipal, "BVB - Funcionários - Gerente", " Tipo: " + TipoUsuario.GERENTE.getPerfil(),
					            TipoUsuario.GERENTE.getDescricao());
		
		else if(e.getSource() == igMenuPrincipal.getMntmTema())
			new JanelaPopUpInfo(igMenuPrincipal, "BVB - Tema", " Tema utilizado: javax.swing.plaf.metal."
					+ "\n\n OBS:: A utilização de outros temas pode causar problemas"
					+ "\n na visualização do aplicativo!");
		
		// Se o usuário clicou em 'Logout' ou em 'Sair' as funções que encerram o programa são invocadas.
		else if((e.getSource() == igMenuPrincipal.getMntmLogout()) || (e.getSource() == igMenuPrincipal.getMntmSair())) {
			new ConexaoDAO().criar(BancoDeDadosBVB.getInstance(), new Conexao(igMenuPrincipal.getFuncionario().getNomeUsuario(),
                                   igMenuPrincipal.getDataInicial(), new Date()));
			
			if(e.getSource() == igMenuPrincipal.getMntmLogout())
				igMenuPrincipal.logout();
			
			else if(e.getSource() == igMenuPrincipal.getMntmSair())
				igMenuPrincipal.terminarPrograma();
		}
		
		else if(BancoDeDadosBVB.getInstance().getConn() != null) {
			if((e.getSource() == igMenuPrincipal.getMntmLimparBD())) {
				JanelaPopUpPergunta janelaPopUpPergunta = new JanelaPopUpPergunta(igMenuPrincipal, "BVB - Limpar Banco de Dados",
						" Esta operação irá excluir permanentemente TODOS os"
						+ "\n registros do banco de dados!"
						+ "\n\n Deseja continuar assim mesmo?");
				
				if(janelaPopUpPergunta.isSim()) {
					if(BancoDeDadosBVB.resetarDadosBD()) {
						new JanelaPopUpInfo(igMenuPrincipal, "BVB - Limpar Banco de Dados", " O banco de dados foi Limpo com sucesso!"
								+ "\n Para Logar novamente, use o login e a senha padrão.", " Login: Admin_BVB\n Senha: 123456");
						new JanelaPopUpAviso(igMenuPrincipal, "BVB - Limpar Banco de Dados", " Para que as mudanças sejam devidamente aplicadas,"
								+ "\n o aplicativo será finalizado.");
						
						igMenuPrincipal.terminarPrograma();
					}
				}
			}
			
			// Fim do menu item "limparBD".
			
			
			if((e.getSource() == igMenuPrincipal.getCadClienteBtn()) || (e.getSource() == igMenuPrincipal.getCadClienteImgBtn()))
				new IgCadCliente(igMenuPrincipal, new Cliente(new Contato(), new Endereco()));
			
			else if((e.getSource() == igMenuPrincipal.getConsClienteBtn()) || (e.getSource() == igMenuPrincipal.getConsClienteImgBtn()))
				new IgConsultarCliente(igMenuPrincipal);
				
			else if((e.getSource() == igMenuPrincipal.getAltClienteBtn()) || (e.getSource() == igMenuPrincipal.getAltClienteImgBtn()))
				new IgBuscarCadastro(igMenuPrincipal, "BVB - Alteração de Cliente", "Alteração de Cliente",
						     "Insira o CPF do cliente que deseja alterar.", 1);
			
			else if((e.getSource() == igMenuPrincipal.getExClienteBtn()) || (e.getSource() == igMenuPrincipal.getExClienteImgBtn()))
				new IgExcluirCadastro(igMenuPrincipal, igMenuPrincipal.getFuncionario(), "BVB - Exclusão de Cliente", "Exclusão de Cliente",
						              "Insira o CPF do cliente que deseja excluir.", 1);
			
			else if((e.getSource() == igMenuPrincipal.getRelClienteBtn()) || (e.getSource() == igMenuPrincipal.getRelClienteImgBtn()))
				new IgRelatorioCliente(igMenuPrincipal);
		
			// Fim dos botões da aba "cliente".
			
			
			else if((e.getSource() == igMenuPrincipal.getCadFuncBtn()) || (e.getSource() == igMenuPrincipal.getCadFuncImgBtn()))
				new IgCadFuncionario(igMenuPrincipal, new Funcionario());
			
			else if((e.getSource() == igMenuPrincipal.getConsFuncBtn()) || (e.getSource() == igMenuPrincipal.getConsFuncImgBtn()))
				new IgConsultarFuncionario(igMenuPrincipal);
			
			else if((e.getSource() == igMenuPrincipal.getAltFuncBtn()) || (e.getSource() == igMenuPrincipal.getAltFuncImgBtn()))
				new IgBuscarCadastro(igMenuPrincipal, "BVB - Alteração de Funcionário", "Alteração de Funcionário",
					     	 "Insira o Login do funcionário que deseja alterar.", 2);
			
			else if((e.getSource() == igMenuPrincipal.getExFuncBtn()) || (e.getSource() == igMenuPrincipal.getExFuncImgBtn()))
				new IgExcluirCadastro(igMenuPrincipal, igMenuPrincipal.getFuncionario(), "BVB - Exclusão de Funcionário", "Exclusão de Funcionário",
			                          "Insira o Login do funcionário que deseja excluir.", 2);
			
			else if((e.getSource() == igMenuPrincipal.getRelFuncBtn()) || (e.getSource() == igMenuPrincipal.getRelFuncImgBtn()))
				new IgRelatorioFuncionario(igMenuPrincipal);
	
			// Fim dos botões da aba "funcionário".
			
			
			else if((e.getSource() == igMenuPrincipal.getCadAgBtn()) || (e.getSource() == igMenuPrincipal.getCadAgImgBtn()))
				new IgCadAgencia(igMenuPrincipal, new Agencia());
			
			else if((e.getSource() == igMenuPrincipal.getConsAgBtn()) || (e.getSource() == igMenuPrincipal.getConsAgImgBtn()))
				new IgConsultarAgencia(igMenuPrincipal);
			
			else if((e.getSource() == igMenuPrincipal.getAltAgBtn()) || (e.getSource() == igMenuPrincipal.getAltAgImgBtn()))
				new IgBuscarCadastro(igMenuPrincipal, "BVB - Alteração de Agência", "Alteração de Agência",
				     	     "Insira o código da agência que deseja alterar.", 3);
			
			else if((e.getSource() == igMenuPrincipal.getExAgBtn()) || (e.getSource() == igMenuPrincipal.getExAgImgBtn()))
				new IgExcluirCadastro(igMenuPrincipal, igMenuPrincipal.getFuncionario(), "BVB - Exclusão de Agência", "Exclusão de Agência",
                                      "Insira o código da agência que deseja excluir.", 3);
			
			else if((e.getSource() == igMenuPrincipal.getRelAgBtn()) || (e.getSource() == igMenuPrincipal.getRelAgImgBtn()))
				new IgRelatorioAgencia(igMenuPrincipal);
			
			// Fim dos botões da aba "agência".
			
			
			else if((e.getSource() == igMenuPrincipal.getAbrirContaBtn()) || (e.getSource() == igMenuPrincipal.getAbrirContaImgBtn()))
				new IgAbrirContaBancaria(igMenuPrincipal, new ContaBancaria());
			
			else if((e.getSource() == igMenuPrincipal.getDepositarSalContaBtn()) || (e.getSource() == igMenuPrincipal.getDepositarSalContaImgBtn()))
				new IgDepositarSal(igMenuPrincipal);
			
			else if((e.getSource() == igMenuPrincipal.getCriarAplicContaBtn()) || (e.getSource() == igMenuPrincipal.getCriarAplicContaImgBtn()))
				new IgCriarAplicacao(igMenuPrincipal, new ContaBancaria());
			
			else if((e.getSource() == igMenuPrincipal.getAlterarAplicContaBtn()) || (e.getSource() == igMenuPrincipal.getAlterarAplicContaImgBtn()))
				new IgAlterarTipoAplicacao(igMenuPrincipal);
			
			// Fim dos botões da aba "conta".
			
			
			else if((e.getSource() == igMenuPrincipal.getCaixaEletronicoBtn()) || (e.getSource() == igMenuPrincipal.getCaixaEletronicoImgBtn())){}
			
			else if((e.getSource() == igMenuPrincipal.getAlterarSenhaBtn()) || (e.getSource() == igMenuPrincipal.getAlterarSenhaImgBtn()))
				new IgAltSenhaFuncionario(igMenuPrincipal, igMenuPrincipal.getFuncionario());
			
			// Fim dos botões da aba "outros".
		} // fim if(BancoDeDadosBVB.getInstance().getConn() != null)
		else
			new JanelaPopUpErro(igMenuPrincipal, "BVB - ERRO", " A conexão com o banco de dados não foi estabelecida!\n" +
					            " Para realizar esta operação reinicie a aplicação!");
	}
	
} // class TEActionMenuPrincipal