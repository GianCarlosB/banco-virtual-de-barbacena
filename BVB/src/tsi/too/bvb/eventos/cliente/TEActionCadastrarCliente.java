package tsi.too.bvb.eventos.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.cliente.Cliente;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.PainelConfCad;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.gui.cliente.IgCadCliente;
import tsi.too.bvb.gui.cliente.PainelCadContato;
import tsi.too.bvb.gui.cliente.PainelCadCliente;
import tsi.too.bvb.gui.cliente.PainelCadEndereco;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ClienteDAO;

public class TEActionCadastrarCliente implements ActionListener {
	
	private IgCadCliente igCadCliente;
	private PainelCadCliente painelCadCliente;
	private Cliente cliente;

	public TEActionCadastrarCliente(PainelCadCliente painelCadCliente) {
		super();
		this.painelCadCliente = painelCadCliente;
	}

	public TEActionCadastrarCliente(IgCadCliente igCadCliente, Cliente cliente) {
		super();
		this.painelCadCliente = null;
		this.igCadCliente = igCadCliente;
		this.cliente = cliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(painelCadCliente != null && e.getSource() == painelCadCliente.getBtnValidar())
			painelCadCliente.validarCampoCpf();
		else {
			TratadorDeCampos painelVisivel = igCadCliente.obterPainelVisivel();
			
			if(e.getSource() == igCadCliente.getBtnLimpar()) {
				painelVisivel.limparCampos();
				igCadCliente.setLblCamposErrados(false);
			}
			else if(e.getSource() == igCadCliente.getBtnProximo()) {
				if(painelVisivel.validarCampos()) {
					igCadCliente.setLblCamposErrados(false);
					painelVisivel.salvarCampos(cliente);
					
					if(painelVisivel instanceof PainelCadCliente) {
						igCadCliente.getCardLayout().show(igCadCliente.getCardPanel(), "enderecoPanel");
						igCadCliente.setTxtpnSubTitulo("Insera o endere\u00E7o do novo cliente.");
						igCadCliente.getpCadEndereco().inserirBordasPadrao();
						igCadCliente.setProgressBar(25);
						igCadCliente.getpCadEndereco().setVisible(true);
						igCadCliente.getBtnAnterior().setVisible(true);
					}
					else if(painelVisivel instanceof PainelCadEndereco) {
						igCadCliente.getCardLayout().show(igCadCliente.getCardPanel(), "contatoPanel");
						igCadCliente.setTxtpnSubTitulo("Insera o contato do novo cliente.");
						igCadCliente.getpCadContato().inserirBordasPadrao();
						igCadCliente.setProgressBar(50);
						igCadCliente.getpCadContato().setVisible(true);
					}
					else if(painelVisivel instanceof PainelCadContato) {
						igCadCliente.getCardLayout().show(igCadCliente.getCardPanel(), "confClientePanel");
						igCadCliente.setTxtpnSubTitulo("Confirme os dados do novo cliente.");
						igCadCliente.setProgressBar(75);
						igCadCliente.getpConfCad().setDadosEditorPane(cliente.exibeDadosFormatados());
						igCadCliente.getpConfCad().setVisible(true);
						igCadCliente.getBtnLimpar().setVisible(false);
						igCadCliente.getBtnProximo().setVisible(false);
						igCadCliente.getBtnFinalizar().setVisible(true);
					}
				}
				else
					igCadCliente.setLblCamposErrados(true);
			} // fim if(e.getSource() == igCadCliente.getBtnProximo())
			
			else if(e.getSource() == igCadCliente.getBtnAnterior()) {
				if(painelVisivel instanceof PainelCadEndereco) {
					igCadCliente.getCardLayout().show(igCadCliente.getCardPanel(), "clientePanel");
					igCadCliente.setTxtpnSubTitulo("Insira o nome e o CPF do novo cliente.");
					igCadCliente.setProgressBar(0);
					igCadCliente.setLblCamposErrados(false);
					igCadCliente.getpCadCliente().setVisible(true);
					igCadCliente.getBtnAnterior().setVisible(false);
				}
				else if(painelVisivel instanceof PainelCadContato) {
					igCadCliente.getCardLayout().show(igCadCliente.getCardPanel(), "enderecoPanel");
					igCadCliente.setTxtpnSubTitulo("Insera o endere\u00E7o do novo cliente.");
					igCadCliente.setProgressBar(25);
					igCadCliente.setLblCamposErrados(false);
					igCadCliente.getpCadEndereco().setVisible(true);
				}
				else if(painelVisivel instanceof PainelConfCad) {
					igCadCliente.getCardLayout().show(igCadCliente.getCardPanel(), "contatoPanel");
					igCadCliente.setTxtpnSubTitulo("Insera o contato do novo cliente.");
					igCadCliente.setProgressBar(50);
					igCadCliente.setLblCamposErrados(false);
					igCadCliente.getpCadContato().setVisible(true);
					igCadCliente.getBtnLimpar().setVisible(true);
					igCadCliente.getBtnProximo().setVisible(true);
					igCadCliente.getBtnFinalizar().setVisible(false);
				}
			} // fim if(e.getSource() == igCadCliente.getBtnAnterior())
			
			else if(e.getSource() == igCadCliente.getBtnFinalizar()) {
				new ClienteDAO().criar(BancoDeDadosBVB.getInstance(), cliente);
				igCadCliente.setProgressBar(100);
				
				new JanelaPopUpInfo(igCadCliente, "BVB - Cadastro de Cliente", " Cadastro do Cliente Realizado com Sucesso!",
						            cliente.exibeDadosFormatados());
				igCadCliente.dispose();
			} // fim if(e.getSource() == igCadCliente.getBtnFinalizar())
		} // fim else
	}

} // class TEActionCadastrarCliente
