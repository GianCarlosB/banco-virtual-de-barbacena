package tsi.too.bvb.eventos.excluircadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.Mascara;
import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.JanelaPopUpPergunta;
import tsi.too.bvb.gui.excluircadastro.IgExcluirCadastro;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.persistencia.FuncionarioDAO;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEMouseExcluirCadastro implements ActionListener {

	private IgExcluirCadastro igExcluirCadastro;
	private int tipo;

	public TEMouseExcluirCadastro(IgExcluirCadastro igExcluirCadastro, int tipo) {
		super();
		this.igExcluirCadastro = igExcluirCadastro;
		this.tipo = tipo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igExcluirCadastro.getBtnBuscar()) {
			switch(tipo) {
			case 1:
				if(!igExcluirCadastro.getPexCliente().getCpfFormattedTextField().getText()
				   .replace(".", "").replace("-", "").replace(" ", "").isEmpty()) {
					if(ValidarDados.validarCPF(igExcluirCadastro.getPexCliente().getCpfFormattedTextField().getText()
				                               .replace(".", "").replace("-", "").replace(" ", ""))) {
						Cliente cliente = new ClienteDAO().pesquisarCpf(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexCliente()
		                                                                .getCpfFormattedTextField().getText().replace(".", "").replace("-", ""));
						if(cliente == null)
							new JanelaPopUpAviso(igExcluirCadastro, "Exclusão de Cliente", " Nenhum cliente com o CPF '" +
								             	 igExcluirCadastro.getPexCliente().getCpfFormattedTextField().getText() + "' foi encontrado.");
						else {
							cliente.setCpf(Mascara.formatarString(cliente.getCpf(), "###.###.###-##"));
							cliente.getEndereco().setCep(Mascara.formatarString(cliente.getEndereco().getCep(), "#####-###"));
							cliente.getContato().setTelefoneFixo(Mascara.formatarString(cliente.getContato().getTelefoneFixo(), "(##)####-####"));
							cliente.getContato().setTelefoneFixo(Mascara.formatarString(cliente.getContato().getTelefoneMovel(), "(##)####-####"));
							igExcluirCadastro.getPexCliente().getCpfFormattedTextField().setEnabled(false);
							igExcluirCadastro.exibeOpcoesExcluir(cliente.toString());
						}
					}
					else
						new JanelaPopUpAviso(igExcluirCadastro, "Exclusão de Cliente", " O CPF '" +
				             	             igExcluirCadastro.getPexCliente().getCpfFormattedTextField().getText() + "' é inválido.");
				}
				break;
				
			case 2:
				if(!igExcluirCadastro.getPexExFuncionario().getLoginTextField().getText().isEmpty()) {
					Funcionario funcionario = new FuncionarioDAO().pesquisarLoginUnico(BancoDeDadosBVB.getInstance(), igExcluirCadastro
							                                                           .getPexExFuncionario().getLoginTextField().getText());
	
					if(funcionario == null)
						new JanelaPopUpAviso(igExcluirCadastro, "Exclusão de Funcionário", " Nenhum funcionário com o login '" +
									         igExcluirCadastro.getPexExFuncionario().getLoginTextField().getText() + "' foi encontrado.");
					else {
						igExcluirCadastro.getPexExFuncionario().getLoginTextField().setEnabled(false);
						igExcluirCadastro.exibeOpcoesExcluir(funcionario.toString());
					}
				}
				break;
				
			case 3:
				if(!igExcluirCadastro.getPexAgencia().getCodigoTextField().getText().isEmpty()) {
					Agencia agencia = new AgenciaDAO().pesquisarCodigo(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexAgencia()
	                                                                   .getCodigoTextField().getText());
					if(agencia == null)
						new JanelaPopUpAviso(igExcluirCadastro, "Exclusão de Agência", " Nenhuma agência com o código '" +
								             igExcluirCadastro.getPexAgencia().getCodigoTextField().getText() + "' foi encontrada.");
					else {
						igExcluirCadastro.getPexAgencia().getCodigoTextField().setEnabled(false);
						igExcluirCadastro.exibeOpcoesExcluir(agencia.toString());
					}
				}
				break;
			} // fim switch(tipo)
		} // fim if(e.getSource() == igExcluirCadastro.getBtnBuscar())
		
		else if(e.getSource() == igExcluirCadastro.getBtnExcluir()) {
			JanelaPopUpPergunta janelaPopUpPergunta = null;
			
			switch(tipo) {
			case 1:
				janelaPopUpPergunta = new JanelaPopUpPergunta(igExcluirCadastro, "Exclusão de Cliente", " Esta operação irá excluir " +
						                                      "permanentemente o cliente.\n Deseja continuar assim mesmo?");
				if(janelaPopUpPergunta.isSim())
					new ClienteDAO().excluir(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexCliente().getCpfFormattedTextField()
							                 .getText().replace(".", "").replace("-", "")); break;
			case 2:
				janelaPopUpPergunta = new JanelaPopUpPergunta(igExcluirCadastro, "Exclusão de Funcionário", " Esta operação irá excluir " +
                                                              "permanentemente o funcionário.\n Deseja continuar assim mesmo?");
				if(janelaPopUpPergunta.isSim())
					new FuncionarioDAO().excluir(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexExFuncionario().getLoginTextField()
							                     .getText()); break;
			case 3:
				janelaPopUpPergunta = new JanelaPopUpPergunta(igExcluirCadastro, "Exclusão de Agência", " Esta operação irá excluir " +
                                                              "permanentemente a agência.\n Deseja continuar assim mesmo?");
				if(janelaPopUpPergunta.isSim())
					new AgenciaDAO().excluir(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexAgencia().getCodigoTextField()
							                 .getText());break;
			} //fim switch(tipo)
			
			if(janelaPopUpPergunta.isSim()) {
				new JanelaPopUpInfo(igExcluirCadastro, "Exclusão", " Exclusão realizada com sucesso!");
				igExcluirCadastro.escondeOpcoesExcluir();
				
				switch(tipo) {
				case 1: 
					igExcluirCadastro.getPexCliente().getCpfFormattedTextField().setEnabled(true);
					igExcluirCadastro.getPexCliente().setCpfFormattedTextField(""); break;
				case 2: 
					igExcluirCadastro.getPexExFuncionario().getLoginTextField().setEnabled(true);
					igExcluirCadastro.getPexExFuncionario().setLoginTextField(""); break;
				case 3: 
					igExcluirCadastro.getPexAgencia().getCodigoTextField().setEnabled(true);
					igExcluirCadastro.getPexAgencia().setCodigoTextField(""); break;
				}
			}
		} // fim if(e.getSource() == igExcluirCadastro.getBtnExcluir())
		
		else if(e.getSource() == igExcluirCadastro.getBtnAlterar()) {
			igExcluirCadastro.escondeOpcoesExcluir();
			
			switch(tipo) {
			case 1: igExcluirCadastro.getPexCliente().getCpfFormattedTextField().setEnabled(true); break;
			case 2: igExcluirCadastro.getPexExFuncionario().getLoginTextField().setEnabled(true); break;
			case 3: igExcluirCadastro.getPexAgencia().getCodigoTextField().setEnabled(true); break;
			}
		} // fim if(e.getSource() == igExcluirCadastro.getBtnAlterar())
	}
	
} // class TEMouseExcluirCadastro
