package tsi.too.bvb.eventos.excluircadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.JanelaPopUpPergunta;
import tsi.too.bvb.gui.excluircadastro.IgExcluirCadastro;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.persistencia.FuncionarioDAO;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEActionExcluirCadastro implements ActionListener {

	private IgExcluirCadastro igExcluirCadastro;
	private int tipo;

	public TEActionExcluirCadastro(IgExcluirCadastro igExcluirCadastro, int tipo) {
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
				String cpfFormatado = igExcluirCadastro.getPexCliente().getCpfFormattedTextField().getText();
				String cpf = igExcluirCadastro.getPexCliente().getCpfFormattedTextField().getText()
						     .replace(".", "").replace("-", "").replace(" ", "");
				
				if(!igExcluirCadastro.getPexCliente().getCpfFormattedTextField().getText()
				   .replace(".", "").replace("-", "").replace(" ", "").isEmpty()) {
					if(ValidarDados.validarCPF(cpf)) {
						Cliente cliente = new ClienteDAO().pesquisarCpf(BancoDeDadosBVB.getInstance(), cpf);
						
						if(cliente == null)
							new JanelaPopUpAviso(igExcluirCadastro, "BVB - Exclusão de Cliente", " Nenhum cliente com o CPF '" +
									             cpfFormatado + "' foi encontrado.");
						else {
							igExcluirCadastro.getPexCliente().getCpfFormattedTextField().setEnabled(false);
							igExcluirCadastro.exibeOpcoesExcluir(cliente.exibeDadosFormatados());
						}
					}
					else
						new JanelaPopUpErro(igExcluirCadastro, "BVB - Exclusão de Cliente", " O nº de CPF '" +
								            cpfFormatado + "' é inválido!" +
								            "\n O campo de busca deve receber 11 dígitos decimais" +
								            "\n de um CPF válido.");
				}
				else
					new JanelaPopUpErro(igExcluirCadastro, "BVB - Exclusão de Cliente", " Entrada inválida!\n" +
							            " O campo de busca não pode ser vazio.");
				break;
			// fim case: 1
				
			case 2:
				String login = igExcluirCadastro.getPexExFuncionario().getLoginTextField().getText();
				
				if(!igExcluirCadastro.getPexExFuncionario().getLoginTextField().getText().isEmpty()) {
					if(ValidarDados.validarLoginFunc(login)) {
						Funcionario funcionario = new FuncionarioDAO().pesquisarLoginUnico(BancoDeDadosBVB.getInstance(), login);
		
						if(funcionario == null)
							new JanelaPopUpAviso(igExcluirCadastro, "BVB - Exclusão de Funcionário", " Nenhum funcionário com o login '" +
										         login + "' foi encontrado.");
						else {
							igExcluirCadastro.getPexExFuncionario().getLoginTextField().setEnabled(false);
							igExcluirCadastro.exibeOpcoesExcluir(funcionario.toString());
						}
					}
					else
						new JanelaPopUpErro(igExcluirCadastro, "BVB - Exclusão de Funcionário", " O login de funcionário '" +
								            login + "' é inválido!" +
								            "\n O campo de busca deve receber no mínimo 6 e no máximo" +
								            "\n 20 caracteres letras, dígitos e os símbolos underscore (_)" +
								            "\n ou ponto (.).");
				}
				else
					new JanelaPopUpErro(igExcluirCadastro, "BVB - Consulta de Funcionário", " Entrada inválida!\n"
							            + " O campo de busca não pode ser vazio.");
				break;
			// fim case: 2
				
			case 3:
				String codigo = igExcluirCadastro.getPexAgencia().getCodigoTextField().getText();
				
				if(!igExcluirCadastro.getPexAgencia().getCodigoTextField().getText().isEmpty()) {
					if(ValidarDados.validarIntPositivo(codigo)) {
						Agencia agencia = new AgenciaDAO().pesquisarCodigo(BancoDeDadosBVB.getInstance(), codigo);
						
						if(agencia == null)
							new JanelaPopUpAviso(igExcluirCadastro, "BVB - Exclusão de Agência", " Nenhuma agência com o código '" +
									             codigo + "' foi encontrada.");
						else {
							igExcluirCadastro.getPexAgencia().getCodigoTextField().setEnabled(false);
							igExcluirCadastro.exibeOpcoesExcluir(agencia.toString());
						}
					}
					else
						new JanelaPopUpErro(igExcluirCadastro, "BVB - Exclusão de Agência", " O código de agência '" +
								            codigo + "' é inválido!" +
								            "\n O campo de busca deve receber um valor inteiro e positivo.");
				}
				else
					new JanelaPopUpErro(igExcluirCadastro, "BVB - Exclusão de Agência", " Entrada inválida!\n" +
				                        " O campo de busca não pode ser vazio.");
				break;
			// fim case: 3
			} // fim switch(tipo)
		} // fim if(e.getSource() == igExcluirCadastro.getBtnBuscar())
		
		else if(e.getSource() == igExcluirCadastro.getBtnExcluir()) {
			JanelaPopUpPergunta janelaPopUpPergunta = null;
			
			switch(tipo) {
			case 1:
				janelaPopUpPergunta = new JanelaPopUpPergunta(igExcluirCadastro, "BVB - Exclusão de Cliente", " Esta operação irá excluir " +
						                                      "permanentemente o cliente.\n Deseja continuar assim mesmo?");
				if(janelaPopUpPergunta.isSim())
					new ClienteDAO().excluir(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexCliente().getCpfFormattedTextField()
							                 .getText().replace(".", "").replace("-", ""));
			break;
			// fim case: 1
			
			case 2:
				janelaPopUpPergunta = new JanelaPopUpPergunta(igExcluirCadastro, "BVB - Exclusão de Funcionário", " Esta operação irá excluir " +
                                                              "permanentemente o funcionário.\n\n Deseja continuar assim mesmo?");
				if(janelaPopUpPergunta.isSim())
					new FuncionarioDAO().excluir(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexExFuncionario().getLoginTextField()
							                     .getText());
			break;
			// fim case: 2
			
			case 3:
				janelaPopUpPergunta = new JanelaPopUpPergunta(igExcluirCadastro, "BVB - Exclusão de Agência", " Esta operação irá excluir " +
                                                              "permanentemente a agência.\n Deseja continuar assim mesmo?");
				if(janelaPopUpPergunta.isSim())
					new AgenciaDAO().excluir(BancoDeDadosBVB.getInstance(), igExcluirCadastro.getPexAgencia().getCodigoTextField()
							                 .getText());
			break;
            // fim case: 3				                 
			} //fim switch(tipo)
			
			if(janelaPopUpPergunta.isSim()) {
				new JanelaPopUpInfo(igExcluirCadastro, "BVB - Exclusão", " Exclusão realizada com sucesso!");
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
	
} // class TEActionExcluirCadastro
