package tsi.too.bvb.eventos.buscarcadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.gui.JanelaPopUpAviso;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.agencia.IgAltAgencia;
import tsi.too.bvb.gui.buscarcadastro.IgBuscarCadastro;
import tsi.too.bvb.gui.cliente.IgAltCliente;
import tsi.too.bvb.gui.funcionario.IgAltFuncionario;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;
import tsi.too.bvb.persistencia.FuncionarioDAO;
import tsi.too.bvb.validacoes.ValidarDados;

/** Classe para tratar os eventos de ação da janela <code>IgBuscarCadastro</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionBuscarCadastro implements ActionListener {

	private IgBuscarCadastro igBuscarCadastro;
	private int tipo;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgAltAgencia</code>
	 * @param igBuscarCadastro <code>IgBuscarCadastro</code> que será manipulada
	 * @param tipo <code>int</code> referênte ao tipo da busca: 1 - Cliente, 2 - Funcionário, 3 - Agência
	 */
	public TEActionBuscarCadastro(IgBuscarCadastro igBuscarCadastro, int tipo) {
		super();
		this.igBuscarCadastro = igBuscarCadastro;
		this.tipo = tipo;
	}

	/** Trata os eventos de ação dos elementos da janela <code>IgBuscarCadastro</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igBuscarCadastro.getBtnBuscar()) {
			switch(tipo) {
			case 1:
				String cpfFormatado = igBuscarCadastro.getPBuscarCliente().getCpfFormattedTextField().getText();
				String cpf = igBuscarCadastro.getPBuscarCliente().getCpfFormattedTextField().getText()
						     .replace(".", "").replace("-", "").replace(" ", "");
				
				if(!igBuscarCadastro.getPBuscarCliente().getCpfFormattedTextField().getText()
				   .replace(".", "").replace("-", "").replace(" ", "").isEmpty()) {
					if(ValidarDados.validarCPF(cpf)) {
						igBuscarCadastro.setCliente(new ClienteDAO().pesquisarCpf(BancoDeDadosBVB.getInstance(), cpf));
						
						if(igBuscarCadastro.getCliente() == null)
							new JanelaPopUpAviso(igBuscarCadastro, "BVB - Alteração de Cliente", " Nenhum cliente com o CPF '" +
									             cpfFormatado + "' foi encontrado.");
						else {
							igBuscarCadastro.getPBuscarCliente().getCpfFormattedTextField().setEnabled(false);
							igBuscarCadastro.exibeOpcoesAlterarDados(igBuscarCadastro.getCliente().exibeDadosFormatados());
						}
					}
					else
						new JanelaPopUpErro(igBuscarCadastro, "BVB - Alteração de Cliente", " O nº de CPF '" +
								            cpfFormatado + "' é inválido!" +
								            "\n O campo de busca deve receber 11 dígitos decimais" +
								            "\n de um CPF válido.");
				}
				else
					new JanelaPopUpErro(igBuscarCadastro, "BVB - Alteração de Cliente", " Entrada inválida!\n" +
							            " O campo de busca não pode ser vazio.");
				break;
			// fim case: 1
				
			case 2:
				String login = igBuscarCadastro.getPBuscarFuncionario().getLoginTextField().getText();
				
				if(!igBuscarCadastro.getPBuscarFuncionario().getLoginTextField().getText().isEmpty()) {
					if(ValidarDados.validarLoginFunc(login)) {
						igBuscarCadastro.setFuncionario(new FuncionarioDAO().pesquisarLoginUnico(BancoDeDadosBVB.getInstance(), login));
		
						if(igBuscarCadastro.getFuncionario() == null)
							new JanelaPopUpAviso(igBuscarCadastro, "BVB - Alteração de Funcionário", " Nenhum funcionário com o login '" +
										         login + "' foi encontrado.");
						else {
							igBuscarCadastro.getPBuscarFuncionario().getLoginTextField().setEnabled(false);
							igBuscarCadastro.exibeOpcoesAlterarDados(igBuscarCadastro.getFuncionario().toStringSemSenha());
						}
					}
					else
						new JanelaPopUpErro(igBuscarCadastro, "BVB - Alteração de Funcionário", " O login de funcionário '" +
								            login + "' é inválido!" +
								            "\n O campo de busca deve receber no mínimo 6 e no" +
								            "\n máximo 20 caracteres letras, dígitos e os símbolos" +
								            "\n underscore (_) ou ponto (.).");
				}
				else
					new JanelaPopUpErro(igBuscarCadastro, "BVB - Consulta de Funcionário", " Entrada inválida!\n"
							            + " O campo de busca não pode ser vazio.");
				break;
			// fim case: 2
				
			case 3:
				String codigo = igBuscarCadastro.getPBuscarAgencia().getCodigoTextField().getText();
				
				if(!igBuscarCadastro.getPBuscarAgencia().getCodigoTextField().getText().isEmpty()) {
					if(ValidarDados.validarIntPositivo(codigo) && codigo.length() <= 4) {
						igBuscarCadastro.setAgencia(new AgenciaDAO().pesquisarCodigo(BancoDeDadosBVB.getInstance(), codigo));
						
						if(igBuscarCadastro.getAgencia() == null)
							new JanelaPopUpAviso(igBuscarCadastro, "BVB - Alteração de Agência", " Nenhuma agência com o código '" +
									             codigo + "' foi encontrada.");
						else {
							igBuscarCadastro.getPBuscarAgencia().getCodigoTextField().setEnabled(false);
							igBuscarCadastro.exibeOpcoesAlterarDados(igBuscarCadastro.getAgencia().toString());
						}
					}
					else
						new JanelaPopUpErro(igBuscarCadastro, "BVB - Alteração de Agência", " O código de agência '" +
								            codigo + "' é inválido!\n O campo de busca deve receber um valor inteiro e positivo" +
							            	"\n com no máximo 4 dígitos.");
				}
				else
					new JanelaPopUpErro(igBuscarCadastro, "BVB - Alteração de Agência", " Entrada inválida!\n" +
				                        " O campo de busca não pode ser vazio.");
				break;
			// fim case: 3
			} // fim switch(tipo)
		} // fim if(e.getSource() == igBuscarCadastro.getBtnBuscar())
		
		else if(e.getSource() == igBuscarCadastro.getBtnAlterarDados()) {
			switch(tipo) {
			case 1:
				IgAltCliente igAltCliente = new IgAltCliente(igBuscarCadastro.getCliente(), igBuscarCadastro.getPoint());
				igBuscarCadastro.setCliente(igAltCliente.getCliente());
				igBuscarCadastro.exibeOpcoesAlterarDados(igBuscarCadastro.getCliente().exibeDadosFormatados());
				break;
			case 2:	
				IgAltFuncionario igAltFuncionario = new IgAltFuncionario(igBuscarCadastro.getFuncionario(), igBuscarCadastro.getPoint());
				igBuscarCadastro.setFuncionario(igAltFuncionario.getFuncionario());
				igBuscarCadastro.exibeOpcoesAlterarDados(igBuscarCadastro.getFuncionario().toStringSemSenha());
				break;
			case 3:
				IgAltAgencia igAltAgencia = new IgAltAgencia(igBuscarCadastro.getAgencia(), igBuscarCadastro.getPoint());
				igBuscarCadastro.setAgencia(igAltAgencia.getAgencia());
				igBuscarCadastro.exibeOpcoesAlterarDados(igBuscarCadastro.getAgencia().toString());
				break;			                 
			} //fim switch(tipo)
		} // fim if(e.getSource() == igBuscarCadastro.getBtnExcluir())
		
		else if(e.getSource() == igBuscarCadastro.getBtnAlterar()) {
			igBuscarCadastro.escondeOpcoesAlterarDados();
			
			switch(tipo) {
			case 1: igBuscarCadastro.getPBuscarCliente().getCpfFormattedTextField().setEnabled(true); break;
			case 2: igBuscarCadastro.getPBuscarFuncionario().getLoginTextField().setEnabled(true); break;
			case 3: igBuscarCadastro.getPBuscarAgencia().getCodigoTextField().setEnabled(true); break;
			}
		} // fim if(e.getSource() == igBuscarCadastro.getBtnAlterar())
	}
	
} // class TEActionBuscarCadastro
