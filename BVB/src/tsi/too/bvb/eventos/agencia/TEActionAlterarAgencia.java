package tsi.too.bvb.eventos.agencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.agencia.IgAltAgencia;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

/** Classe para tratar os eventos de ação da janela <code>IgAltAgencia</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionAlterarAgencia implements ActionListener {
	
	private IgAltAgencia igAltAgencia;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgAltAgencia</code>
	 * @param igAltAgencia <code>IgAltAgencia</code> que será manipulada
	 */
	public TEActionAlterarAgencia(IgAltAgencia igAltAgencia) {
		super();
		this.igAltAgencia = igAltAgencia;
	}
	
	/** Trata os eventos de ação dos elementos da janela <code>IgAltAgencia</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igAltAgencia.getBtnEditarDescricao()) {
			if(igAltAgencia.validarDescricao()) {
				if(!igAltAgencia.getAgencia().getDescricao().equals(igAltAgencia.getDescricaoTextField().getText())) {
					igAltAgencia.inserirBordaPadrao();
					igAltAgencia.setLblCamposErrados(false);
					
					new AgenciaDAO().alterarDescricao(BancoDeDadosBVB.getInstance(), igAltAgencia.getAgencia(),
							                          igAltAgencia.getDescricaoTextField().getText());
		
					new JanelaPopUpInfo(igAltAgencia, "BVB - Alteração de Agência", " Alteração da Descrição da Agência Realizada com Sucesso!" ,
					                    " Nova Descrição: " + igAltAgencia.getDescricaoTextField().getText());
					
					igAltAgencia.getAgencia().setDescricao(igAltAgencia.getDescricaoTextField().getText());
				}
				else {
					igAltAgencia.inserirBordaPadrao();
					igAltAgencia.setLblCamposErrados(false);
				}
					
			}
			else
				igAltAgencia.setLblCamposErrados(true);
		}
		
		else if(e.getSource() == igAltAgencia.getBtnFinalizar())
			igAltAgencia.dispose();
	}

} // class TEActionAlterarAgencia
