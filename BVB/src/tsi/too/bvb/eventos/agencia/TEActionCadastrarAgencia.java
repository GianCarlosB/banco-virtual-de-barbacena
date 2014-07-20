package tsi.too.bvb.eventos.agencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.agencia.IgCadAgencia;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

/** Classe para tratar os eventos de ação da janela <code>IgCadAgencia</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see ActionListener
 */
public class TEActionCadastrarAgencia implements ActionListener {
	
	private IgCadAgencia igCadAgencia;
	private Agencia agencia;

	/** Cria uma instância do Tratador de eventos de ação da janela <code>IgCadAgencia</code>
	 * @param igCadAgencia <code>IgCadAgencia</code> que será manipulada
	 * @param agencia <code>Agencia</code> referênte ao objeto que será manipulado
	 * 
	 * @see Agencia
	 */
	public TEActionCadastrarAgencia(IgCadAgencia igCadAgencia, Agencia agencia) {
		super();
		this.igCadAgencia = igCadAgencia;
		this.agencia = agencia;
	}

	/** Trata os eventos de ação dos elementos da janela <code>IgCadAgencia</code>
	 * @see ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == igCadAgencia.getBtnLimpar()) {
			igCadAgencia.limparCampos();
			igCadAgencia.setLblCamposErrados(false);
		}
		
		else if(e.getSource() == igCadAgencia.getBtnFinalizar()) {
			if(igCadAgencia.validarCampos()) {
				igCadAgencia.setLblCamposErrados(false);
				igCadAgencia.salvarCampos(agencia);
				igCadAgencia.getDescricaoTextField().setBorder(UIManager.getBorder("TextField.border"));
				
				AgenciaDAO agenciaDAO = new AgenciaDAO();
				agencia.setCodAgencia(agenciaDAO.proximoValorSequencia(BancoDeDadosBVB.getInstance()));
				agenciaDAO.criar(BancoDeDadosBVB.getInstance(), agencia);
				
				igCadAgencia.setCodigoTextField(Integer.toString(agencia.getCodAgencia()));
				new JanelaPopUpInfo(igCadAgencia, "BVB - Cadastro de Agência", " Cadastro da Agência Realizado com Sucesso!",
						            " Descrição: " + agencia.toString());
				igCadAgencia.dispose();
			}
		}
	}

} // class TEActionCadastrarAgencia
