package tsi.too.bvb.eventos.agencia;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import tsi.too.bvb.entidades.agencia.Agencia;
import tsi.too.bvb.gui.JanelaPopUpInfo;
import tsi.too.bvb.gui.agencia.IgCadAgencia;
import tsi.too.bvb.persistencia.AgenciaDAO;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.validacoes.ValidarDados;

public class TEMouseCadastrarAgencia extends MouseAdapter {
	
	private IgCadAgencia igCadAgencia;
	private Agencia agencia;

	public TEMouseCadastrarAgencia(IgCadAgencia igCadAgencia, Agencia agencia) {
		super();
		this.igCadAgencia = igCadAgencia;
		this.agencia = agencia;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		
		if(e.getButton() == MouseEvent.BUTTON1) { // botão esquerdo do mouse
			if(e.getSource() == igCadAgencia.getBtnLimpar())
				igCadAgencia.setDescricaoEditorPane("");
			
			if(e.getSource() == igCadAgencia.getBtnFinalizar()) {
				if(ValidarDados.validarVazio(igCadAgencia.getDescricaoEditorPane().getText()) == false) {
					igCadAgencia.setLblCamposErrados(true);
					igCadAgencia.getDescricaoEditorPane().setBorder(new LineBorder(Color.RED));
				}
				else {
					igCadAgencia.setLblCamposErrados(false);
					igCadAgencia.salvarCampos(agencia);
					igCadAgencia.getDescricaoEditorPane().setBorder(UIManager.getBorder("EditorPane.border"));
					
					AgenciaDAO agenciaDAO = new AgenciaDAO();
					agenciaDAO.criar(BancoDeDadosBVB.getInstance(), agencia);
					
					new JanelaPopUpInfo(igCadAgencia, "Novo Cadastro de Agência", "Cadastro da Agência Realizado com Sucesso!", agencia.toString());
					igCadAgencia.dispose();
				}
			}
		}
	}

} // class TEMouseCadastrarAgencia
