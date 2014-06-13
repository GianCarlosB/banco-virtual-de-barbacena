package tsi.too.bvb.app;

import tsi.too.bvb.gui.IgMenuPrincipal;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

public class bvbApp {
	
	public static void main(String[] args) {
		// Inicia a thread que faz a conexão com o banco de dados.
		Thread threadBancoDeDados = new Thread(BancoDeDadosBVB.getInstance());
		threadBancoDeDados.start();
		
		try { 
			threadBancoDeDados.join(); // Faz o programa só iniciar após o banco de dados iniciar
		}
		catch (InterruptedException e) {
			new JanelaPopUpErro(null, "BVB - ERRO", " Ocorreu uma interrupção durante a conexão com o banco de dados!", e);
			System.exit(0);
		}

		new IgMenuPrincipal(); // Cria a janela que contém o menu principal
	} // main()
	
} // class bvbApp
