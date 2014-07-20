package tsi.too.bvb.eventos.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.entidades.tiposenumerados.UF;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.gui.cliente.IgAltCliente;
import tsi.too.bvb.gui.cliente.PainelAltCliente;
import tsi.too.bvb.gui.cliente.PainelAltContato;
import tsi.too.bvb.gui.cliente.PainelAltEndereco;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;

/** Classe para tratar os eventos de ação da janela <code>IgAltCliente</code> e de seus paineis <code>PainelAltCliente</code>, 
 * <code>PainelAltContato</code>, <code>PainelAltEndereco</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionAlterarCliente implements ActionListener {
	
	private IgAltCliente igAltCliente;
	private PainelAltCliente painelAltCliente;
	private PainelAltContato painelAltContato;
	private PainelAltEndereco painelAltEndereco;
	private Cliente cliente;
	
	/** Cria uma instância do Tratador de eventos de ação do painel <code>painelAltCliente</code>
	 * @param igAltCliente <code>IgAltCliente</code> que será manipulada
	 * @param painelAltCliente <code>PainelAltCliente</code> que será manipulado
	 * @param cliente <code>Cliente</code> referênte ao objeto que será manipulado
	 * 
	 * @see Cliente
	 */
	public TEActionAlterarCliente(IgAltCliente igAltCliente, PainelAltCliente painelAltCliente, Cliente cliente) {
		super();
		this.painelAltEndereco = null;
		this.painelAltContato = null;
		this.painelAltCliente = painelAltCliente;
		this.igAltCliente = igAltCliente;
		this.cliente = cliente;
	}
	
	/** Cria uma instância do Tratador de eventos de ação do painel <code>painelAltEndereco</code>
	 * @param igAltCliente <code>IgAltCliente</code> que será manipulada
	 * @param painelAltEndereco <code>PainelAltEndereco</code> que será manipulado
	 * @param cliente <code>Cliente</code> referênte ao objeto que será manipulado
	 * 
	 * @see Cliente
	 */
	public TEActionAlterarCliente(IgAltCliente igAltCliente, PainelAltEndereco painelAltEndereco, Cliente cliente) {
		super();
		this.painelAltCliente = null;
		this.painelAltContato = null;
		this.painelAltEndereco = painelAltEndereco;
		this.igAltCliente = igAltCliente;
		this.cliente = cliente;
	}
	
	/** Cria uma instância do Tratador de eventos de ação do painel <code>painelAltContato</code>
	 * @param igAltCliente <code>IgAltCliente</code> que será manipulada
	 * @param painelAltContato <code>PainelAltContato</code> que será manipulado
	 * @param cliente <code>Cliente</code> referênte ao objeto que será manipulado
	 * 
	 * @see Cliente
	 */
	public TEActionAlterarCliente(IgAltCliente igAltCliente, PainelAltContato painelAltContato, Cliente cliente) {
		super();
		this.painelAltCliente = null;
		this.painelAltEndereco = null;
		this.painelAltContato = painelAltContato;
		this.igAltCliente = igAltCliente;
		this.cliente = cliente;
	}
	
	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgCadCliente</code>
	 * @param igAltCliente <code>IgAltCliente</code> que será manipulada
	 * @param cliente <code>Cliente</code> referênte ao objeto que será manipulado
	 * 
	 * @see Cliente
	 */
	public TEActionAlterarCliente(IgAltCliente igAltCliente, Cliente cliente) {
		super();
		this.painelAltCliente = null;
		this.painelAltEndereco = null;
		this.painelAltContato = null;
		this.igAltCliente = igAltCliente;
		this.cliente = cliente;
	}
	
	/** Trata os eventos de ação dos elementos da janela <code>IgAltCliente</code> e de seus paineis <code>PainelAltCliente</code>, 
	 * <code>PainelAltContato</code>, <code>PainelAltEndereco</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/// ===== * Início dos Evento do Painel de Cliente * ===== ///
		
		if(painelAltCliente != null && e.getSource() == painelAltCliente.getBtnEditarNome()) {
			if(painelAltCliente.validarCampos()) {
				if(!painelAltCliente.getNomeTextField().getText().equals(cliente.getNome())) {
					igAltCliente.setLblCamposErrados(false);
					
					new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "nome", painelAltCliente.getNomeTextField().getText());
		
					new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Nome do Cliente Realizada com Sucesso!" ,
					                    " Novo Nome: " + painelAltCliente.getNomeTextField().getText());
					
					igAltCliente.getCliente().setNome(painelAltCliente.getNomeTextField().getText());
				} // fim if(!painelAltCliente.getNomeTextField().getText().equals(cliente.getNome()))
			} // fim if(painelAltCliente.validarNome())
			else
				igAltCliente.setLblCamposErrados(true);
		} // fim if(painelAltCliente != null && e.getSource() == painelAltCliente.getBtnEditarNome())
		
		/// ===== * Fim dos Evento do Painel de Cliente * ===== ///
		
		/// ===== * Início dos Evento do Painel de Endereço * ===== ///
		
		else if(painelAltEndereco != null) {
			if(e.getSource() == painelAltEndereco.getBtnEditarBairro()) {
				if(painelAltEndereco.validarBairro()) {
					if(!painelAltEndereco.getBairroTextField().getText().equals(cliente.getEndereco().getBairro())) {
						igAltCliente.setLblCamposErrados(false);
						
						new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "bairro", painelAltEndereco.getBairroTextField().getText());
			
						new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Bairro do Cliente Realizada com Sucesso!",
								            "Novo Bairro: " + painelAltEndereco.getBairroTextField().getText());
						
						igAltCliente.getCliente().getEndereco().setBairro(painelAltEndereco.getBairroTextField().getText());
					} // fim if(!painelAltEndereco.getBairroTextField().getText().equals(cliente.getEndereco().getBairro()))
				} // fim if(painelAltEndereco.validarBairro())
				else
					igAltCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == painelAltEndereco.getBtnEditarBairro())
			
			else if(e.getSource() == painelAltEndereco.getBtnEditarCep()) {
				if(painelAltEndereco.validarCep()) {
					if(!painelAltEndereco.getCepFormTextField().getText().replace("-", "").equals(cliente.getEndereco().getCep())) {
						igAltCliente.setLblCamposErrados(false);
						
						new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "cep", painelAltEndereco.getCepFormTextField().getText()
								                 .replace("-", ""));
			
						new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Endereço do CEP do Cliente Realizada com" +
								            "\n Sucesso!", " Novo CEP: " + painelAltEndereco.getCepFormTextField().getText());
						
						igAltCliente.getCliente().getEndereco().setCep(painelAltEndereco.getCepFormTextField().getText().replace("-", ""));
					} // fim if(!painelAltEndereco.getCepFormTextField().getText().replace("-", "").equals(cliente.getEndereco().getCep()))
				} // if(painelAltEndereco.validarCep())
				else
					igAltCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == painelAltEndereco.getBtnEditarCep())
			
			else if(e.getSource() == painelAltEndereco.getBtnEditarCidade()) {
				if(painelAltEndereco.validarCidade()) {
					if(!painelAltEndereco.getCidadeTextField().getText().equals(cliente.getEndereco().getCidade())) {
						igAltCliente.setLblCamposErrados(false);
						
						new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "cidade", painelAltEndereco.getCidadeTextField().getText());
			
						new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração da Cidade do Cliente Realizada com Sucesso!",
										    " Nova Cidade: " + painelAltEndereco.getCidadeTextField().getText());
						
						igAltCliente.getCliente().getEndereco().setCidade(painelAltEndereco.getCidadeTextField().getText());
					} // fim if(!painelAltEndereco.getCidadeTextField().getText().equals(cliente.getEndereco().getCidade()))
				} // if(painelAltEndereco.validarCidade())
				else
					igAltCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == painelAltEndereco.getBtnEditarCidade())
			
			else if(e.getSource() == painelAltEndereco.getBtnEditarComplemento()) {
				if(!painelAltEndereco.getComplementoTextField().getText().equals(cliente.getEndereco().getComplemento())) {
					igAltCliente.setLblCamposErrados(false);
					
					new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "complemento", painelAltEndereco
							                 .getComplementoTextField().getText());
		
					new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Complemento do Endereço do Cliente Realizada" +
									    "\n com Sucesso!", " Novo Complemento: " + painelAltEndereco.getComplementoTextField().getText());
					
					igAltCliente.getCliente().getEndereco().setComplemento(painelAltEndereco.getComplementoTextField().getText());
				} // fim if(!painelAltEndereco.getComplementoTextField().getText().equals(cliente.getEndereco().getComplemento()))
				else
					igAltCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == painelAltEndereco.getBtnEditarComplemento())
			
			else if(e.getSource() == painelAltEndereco.getBtnEditarLogradouro()) {
				if(painelAltEndereco.validarLogradouro()) {
					if(!painelAltEndereco.getLogradouroTextField().getText().equals(cliente.getEndereco().getLogradouro())) {
						igAltCliente.setLblCamposErrados(false);
						
						new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "logradouro", painelAltEndereco
								                 .getLogradouroTextField().getText());
			
						new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Endereço do Logradouro do Cliente Realizada" +
									        " com\n com Sucesso!", " Novo Logradouro: " + painelAltEndereco.getLogradouroTextField().getText());
						
						igAltCliente.getCliente().getEndereco().setLogradouro(painelAltEndereco.getLogradouroTextField().getText());
					} // fim if(!painelAltEndereco.getLogradouroTextField().getText().equals(cliente.getEndereco().getLogradouro()))
				} // if(painelAltEndereco.validarLogradouro())
				else
					igAltCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == painelAltEndereco.getBtnEditarLogradouro())
			
			else if(e.getSource() == painelAltEndereco.getBtnEditarNumero()) {
				if(painelAltEndereco.validarNumero()) {
					if(!painelAltEndereco.getNumeroTextField().getText().equals(cliente.getEndereco().getNumero())) {
						igAltCliente.setLblCamposErrados(false);
						
						new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "numero", painelAltEndereco.getNumeroTextField().getText());

						new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Número do Endereço do Cliente Realizada com" +
										    "\n Sucesso!", " Novo Número: " + painelAltEndereco.getNumeroTextField().getText());
						
						igAltCliente.getCliente().getEndereco().setNumero(painelAltEndereco.getNumeroTextField().getText());
					} // fim if(painelAltEndereco.getNumeroTextField().getText().equals(cliente.getEndereco().getNumero()))
				} // if(painelAltEndereco.validarNumero())
				else
					igAltCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == painelAltEndereco.getBtnEditarNumero())
			
			else if(e.getSource() == painelAltEndereco.getBtnEditarUf()) {
				if(!((String)painelAltEndereco.getUfComboBox().getSelectedItem()).equals(cliente.getEndereco().getUf().getUf())) {
					igAltCliente.setLblCamposErrados(false);
					
					new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "UF", (String)painelAltEndereco.getUfComboBox()
							                 .getSelectedItem());
		
					new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do UF da Cidade do Cliente Realizada com Sucesso!",
							            " Novo UF: " + (String)painelAltEndereco.getUfComboBox().getSelectedItem());
					
					igAltCliente.getCliente().getEndereco().setUf(UF.obterUF((String)painelAltEndereco.getUfComboBox().getSelectedItem()));
				} // fim if(((String)painelAltEndereco.getUfComboBox().getSelectedItem()).equals(cliente.getEndereco().getUf().getUf()))
			} // fim if(e.getSource() == painelAltEndereco.getBtnEditarUf())
		} // fim if(painelAltEndereco != null)
		
		/// ===== * Fim dos Evento do Painel de Endereço * ===== ///
		
		/// ===== * Início dos Evento do Painel de Contato * ===== ///
		
		else if(painelAltContato != null) {
			if(e.getSource() == painelAltContato.getBtnEditarTelFixo()) {
				if(painelAltContato.validarCampos()) {
					if(!painelAltContato.getTelFixoFormTextField().getText().replace("(", "").replace(")", "").replace("-", "")
					   .equals(cliente.getContato().getTelefoneFixo())) {
						igAltCliente.setLblCamposErrados(false);
						
						new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "telFixo", painelAltContato.getTelFixoFormTextField()
											     .getText().replace("(", "").replace(")", "").replace("-", ""));
			
						new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Telefone Fixo de Contato do Cliente " +
								            "Realizada \n com Sucesso!" , " Novo Telefone Fixo: " + painelAltContato.getTelFixoFormTextField()
								            .getText());
						
						igAltCliente.getCliente().getContato().setTelefoneFixo(painelAltContato.getTelFixoFormTextField().getText()
								                                               .replace("(", "").replace(")", "").replace("-", ""));
					} // fim if(!painelAltContato.getTelFixoFormTextField().getText().replace("(", "").replace(")", "").replace("-", "")
					  //     .equals(cliente.getContato().getTelefoneFixo()))
				} // fim if(painelAltContato.validarTelFixo())
				else
					igAltCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == painelAltContato.getBtnEditarTelFixo())
			
			else if(e.getSource() == painelAltContato.getBtnEditarTelMovel()) {
				if(!painelAltContato.getTelMovelFormTextField().getText().replace("(", "").replace(")", "").replace("-", "")
				   .equals(cliente.getContato().getTelefoneMovel())) {
					igAltCliente.setLblCamposErrados(false);
					
					new ClienteDAO().alterar(BancoDeDadosBVB.getInstance(), cliente, "telMovel", painelAltContato.getTelMovelFormTextField()
										     .getText().replace("(", "").replace(")", "").replace("-", ""));
		
					new JanelaPopUpInfo(igAltCliente, "BVB - Alteração de Cliente", " Alteração do Telefone Móvel de Contato do Cliente " +
							            "Realizada \n com Sucesso!" , " Novo Telefone Móvel: " + painelAltContato.getTelMovelFormTextField()
							            .getText());
					
					igAltCliente.getCliente().getContato().setTelefoneMovel(painelAltContato.getTelMovelFormTextField().getText()
							                                               .replace("(", "").replace(")", "").replace("-", ""));
				} // fim if(!painelAltContato.getTelMovelFormTextField().getText().replace("(", "").replace(")", "").replace("-", "")
				  //     .equals(cliente.getContato().getTelefoneMovel()))
			} // fim if(e.getSource() == painelAltContato.getBtnEditarTelMovel())
		} // fim if(painelAltContato != null)
		
		/// ===== * Fim dos Evento do Painel de Contato * ===== ///
		
		else {
			TratadorDeCampos painelVisivel = igAltCliente.obterPainelVisivel();
			
			if(e.getSource() == igAltCliente.getBtnProximo()) {
					igAltCliente.setLblCamposErrados(false);
					
					if(painelVisivel instanceof PainelAltCliente) {
						igAltCliente.getCardLayout().show(igAltCliente.getCardPanel(), "enderecoPanel");
						igAltCliente.setTxtpnSubTitulo("Insera o novo endere\u00E7o do cliente.");
						igAltCliente.getpAltEndereco().setVisible(true);
						igAltCliente.getBtnAnterior().setVisible(true);
					}
					else if(painelVisivel instanceof PainelAltEndereco) {
						igAltCliente.getCardLayout().show(igAltCliente.getCardPanel(), "contatoPanel");
						igAltCliente.setTxtpnSubTitulo("Insera o novo contato do cliente.");
						igAltCliente.getpAltContato().setVisible(true);
					}
			} // fim if(e.getSource() == igAltCliente.getBtnProximo())
			
			else if(e.getSource() == igAltCliente.getBtnAnterior()) {
				igAltCliente.setLblCamposErrados(false);
				
				if(painelVisivel instanceof PainelAltEndereco) {
					igAltCliente.getCardLayout().show(igAltCliente.getCardPanel(), "clientePanel");
					igAltCliente.setTxtpnSubTitulo("Insira o novo nome do cliente.");
					igAltCliente.getpAltCliente().setVisible(true);
					igAltCliente.getBtnAnterior().setVisible(false);
				}
				else if(painelVisivel instanceof PainelAltContato) {
					igAltCliente.getCardLayout().show(igAltCliente.getCardPanel(), "enderecoPanel");
					igAltCliente.setTxtpnSubTitulo("Insera o novo endere\u00E7o do cliente.");
					igAltCliente.getpAltEndereco().setVisible(true);
				}
			} // fim if(e.getSource() == igAltCliente.getBtnAnterior())
			
			else if(e.getSource() == igAltCliente.getBtnFinalizar())
				igAltCliente.dispose();
		} // fim else
	}
	
} // class TEActionAlterarCliente
