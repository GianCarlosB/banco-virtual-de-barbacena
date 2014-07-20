package tsi.too.bvb.app;

import tsi.too.bvb.gui.IgApresentacao;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.login.IgLogin;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

/** 
 * Inicia o sistema do Banco Virtual de Barbacena. Cria uma conexão com o banco de dados e a tela de login do sistema
 *
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 * 
 * @see BancoDeDadosBVB
 * @see IgApresentacao
 * @see IgLogin
*/
public abstract class bvbApp {
	
	/** Cria uma instância do programa BVB
	 * @param args <code>String[]</code> com os argumentos de linha de comando, esses argumentos não são utilizados na aplicação
	 */
	public static void main(String[] args) {
		// Inicia a janela de apresentação (carregamento).
		IgApresentacao igApresentacao = new IgApresentacao();

		// Inicia a thread que faz a conexão com o banco de dados.
		Thread threadBancoDeDados = new Thread(BancoDeDadosBVB.getInstance());
		threadBancoDeDados.start();
		
		try { 
			threadBancoDeDados.join(); // Faz o programa só iniciar após o banco de dados iniciar.
		}
		catch (InterruptedException e) {
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			System.exit(0);
		}
		
		// Finaliza a Thread da janela de apresentação.
		igApresentacao.finalizarThread();
		
		// Finaliza a janela de apresentação.
		igApresentacao.dispose();

		// Cria a janela que contém o login.
		new IgLogin();
	} // main()
	
} // class bvbApp
