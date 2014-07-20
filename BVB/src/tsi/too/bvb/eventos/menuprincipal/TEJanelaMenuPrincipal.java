package tsi.too.bvb.eventos.menuprincipal;

import java.applet.Applet;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import tsi.too.bvb.entidades.conexao.Conexao;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.menuprincipal.IgMenuPrincipal;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;
import tsi.too.bvb.persistencia.ConexaoDAO;

/** Classe para tratar os eventos de janela da janela <code>IgMenuPrincipal</code>
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see WindowAdapter
 */
public class TEJanelaMenuPrincipal extends WindowAdapter {
	
	private IgMenuPrincipal igMenuPrincipal;

	/** Cria uma instância do Tratador de eventos de janela da janela <code>IgMenuPrincipal</code>
	 * @param igMenuPrincipal <code>IgMenuPrincipal</code> que será manipulada
	 */
	public TEJanelaMenuPrincipal(IgMenuPrincipal igMenuPrincipal) {
		super();
		this.igMenuPrincipal = igMenuPrincipal;
	}
	
	/** Trata os eventos de abertura de janela da janela <code>IgMenuPrincipal</code>
	 * @see MouseAdapter
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
		Applet.newAudioClip(JanelaPopUpErro.class.getResource("/tsi/too/bvb/recursos/sons/Windows Logon Sound.wav")).play();
		
		igMenuPrincipal.ativarRestricaoUsuario();
	}
	
	/** Trata os eventos de fechamento de janela da janela <code>IgMenuPrincipal</code>
	 * @see MouseAdapter
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
		new ConexaoDAO().criar(BancoDeDadosBVB.getInstance(), new Conexao(igMenuPrincipal.getFuncionario().getNomeUsuario(),
                               igMenuPrincipal.getDataInicial(), new Date()));
		igMenuPrincipal.terminarPrograma();
	}
	
} // class TEJanelaMenuPrincipal