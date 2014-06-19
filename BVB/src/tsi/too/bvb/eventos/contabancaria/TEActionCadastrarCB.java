package tsi.too.bvb.eventos.contabancaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.entidades.contabancaria.ContaBancaria;
import tsi.too.bvb.gui.PainelConfCad;
import tsi.too.bvb.gui.TratadorDeCampos;
import tsi.too.bvb.gui.contabancaria.IgAbrirContaBancaria;
import tsi.too.bvb.gui.contabancaria.PainelAbContaDadosChave;
import tsi.too.bvb.gui.contabancaria.PainelAbContaDadosSec;
import tsi.too.bvb.gui.contabancaria.PainelAbContaSenhas;

public class TEActionCadastrarCB implements ActionListener {
	
	private IgAbrirContaBancaria igAbrirContaBancaria;
	private PainelAbContaDadosChave painelAbContaDadosChave;
	private ContaBancaria contaBancaria;
	
	public TEActionCadastrarCB(PainelAbContaDadosChave painelAbContaDadosChave) {
		super();
		this.painelAbContaDadosChave = painelAbContaDadosChave;
	}

	public TEActionCadastrarCB(IgAbrirContaBancaria igAbrirContaBancaria,
			ContaBancaria contaBancaria) {
		super();
		this.painelAbContaDadosChave = null;
		this.igAbrirContaBancaria = igAbrirContaBancaria;
		this.contaBancaria = contaBancaria;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(painelAbContaDadosChave != null && e.getSource() == painelAbContaDadosChave.getBtnValidarCodAgencia())
			painelAbContaDadosChave.validarCampoCodAgencia();
		else if(painelAbContaDadosChave != null && e.getSource() == painelAbContaDadosChave.getBtnValidarCpf())
			painelAbContaDadosChave.validarCampoCpf();
		else {
			TratadorDeCampos painelVisivel = igAbrirContaBancaria.obterPainelVisivel();
			
			if(e.getSource() == igAbrirContaBancaria.getBtnLimpar()) {
				painelVisivel.limparCampos();
				igAbrirContaBancaria.setLblCamposErrados(false);
			}
			else if(e.getSource() == igAbrirContaBancaria.getBtnProximo()) {
				if(painelVisivel.validarCampos()) {
					igAbrirContaBancaria.setLblCamposErrados(false);
					painelVisivel.salvarCampos(contaBancaria);
					
					if(painelVisivel instanceof PainelAbContaDadosChave) {
						igAbrirContaBancaria.getCardLayout().show(igAbrirContaBancaria.getCardPanel(), "dadosSecundarioPanel");
						igAbrirContaBancaria.setTxtpnSubTitulo("Insira os dados secundários da nova conta bancária.");
						igAbrirContaBancaria.setProgressBar(50);
						igAbrirContaBancaria.getpAbContaDadosSec().setVisible(true);
						igAbrirContaBancaria.getBtnAnterior().setVisible(true);
					}
					else if(painelVisivel instanceof PainelAbContaDadosSec) {
						igAbrirContaBancaria.getCardLayout().show(igAbrirContaBancaria.getCardPanel(), "senhasPanel");
						igAbrirContaBancaria.setTxtpnSubTitulo("Insera as senhas da nova conta bancária.");
						igAbrirContaBancaria.setProgressBar(75);
						igAbrirContaBancaria.getpAbContaSenhas().setVisible(true);
					}
					else if(painelVisivel instanceof PainelAbContaSenhas) {
						igAbrirContaBancaria.getCardLayout().show(igAbrirContaBancaria.getCardPanel(), "confCadPanel");
						igAbrirContaBancaria.setTxtpnSubTitulo("Confirme os dados da nova conta bancária.");
						igAbrirContaBancaria.setProgressBar(100);
						contaBancaria.insereMascara();
						igAbrirContaBancaria.getpConfCad().setDadosEditorPane(contaBancaria.toString());
						contaBancaria.removeMascara();
						igAbrirContaBancaria.getpConfCad().setVisible(true);
						igAbrirContaBancaria.getBtnLimpar().setVisible(false);
						igAbrirContaBancaria.getBtnProximo().setVisible(false);
						igAbrirContaBancaria.getBtnFinalizar().setVisible(true);
					}
				}
				else
					igAbrirContaBancaria.setLblCamposErrados(true);
			} // fim if(e.getSource() == igAbrirContaBancaria.getBtnProximo())
			
			else if(e.getSource() == igAbrirContaBancaria.getBtnAnterior()) {
				if(painelVisivel instanceof PainelAbContaDadosSec) {
					igAbrirContaBancaria.getCardLayout().show(igAbrirContaBancaria.getCardPanel(), "dadosChavePanel");
					igAbrirContaBancaria.setTxtpnSubTitulo("Insira os dados chave da nova conta bancária.");
					igAbrirContaBancaria.setProgressBar(25);
					igAbrirContaBancaria.setLblCamposErrados(false);
					igAbrirContaBancaria.getpAbContaDadosChave().setVisible(true);
					igAbrirContaBancaria.getBtnAnterior().setVisible(false);
				}
				else if(painelVisivel instanceof PainelAbContaSenhas) {
					igAbrirContaBancaria.getCardLayout().show(igAbrirContaBancaria.getCardPanel(), "dadosSecundarioPanel");
					igAbrirContaBancaria.setTxtpnSubTitulo("Insira os dados secundários da nova conta bancária.");
					igAbrirContaBancaria.setProgressBar(50);
					igAbrirContaBancaria.setLblCamposErrados(false);
					igAbrirContaBancaria.getpAbContaDadosSec().setVisible(true);
				}
				else if(painelVisivel instanceof PainelConfCad) {
					igAbrirContaBancaria.getCardLayout().show(igAbrirContaBancaria.getCardPanel(), "senhasPanel");
					igAbrirContaBancaria.setTxtpnSubTitulo("Insera as senhas da nova conta bancária.");
					igAbrirContaBancaria.setProgressBar(75);
					igAbrirContaBancaria.setLblCamposErrados(false);
					igAbrirContaBancaria.getpAbContaSenhas().setVisible(true);
					igAbrirContaBancaria.getBtnLimpar().setVisible(true);
					igAbrirContaBancaria.getBtnProximo().setVisible(true);
					igAbrirContaBancaria.getBtnFinalizar().setVisible(false);
				}
			} // fim if(e.getSource() == igAbrirContaBancaria.getBtnAnterior())
			
			else if(e.getSource() == igAbrirContaBancaria.getBtnFinalizar()) {
				/*ContaBancariaDAO contaBancariaDAO = new ContaBancariaDAO();
				contaBancariaDAO.criar(BancoDeDadosBVB.getInstance(), contaBancaria);
				
				contaBancaria.insereMascara();
				new JanelaPopUpInfo(igAbrirContaBancaria, "BVB - Cadastro de contaBancaria", " Cadastro do contaBancaria Realizado com Sucesso!",
				                    contaBancaria.toString());
				contaBancaria.removeMascara();
				*/igAbrirContaBancaria.dispose();
			} // fim if(e.getSource() == igAbrirContaBancaria.getBtnFinalizar())
		} // fim else
	}

} // class TEActionCadastrarCB
