package tsi.too.bvb.app;

import tsi.too.bvb.gui.IgMenuPrincipal;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

public class bvbApp {
	
	public static void main(String[] args) {
		// Inicia a thread que faz a conexão com o banco de dados.
		Thread threadBancoDeDados = new Thread(BancoDeDadosBVB.getInstance());
		threadBancoDeDados.start();
		
		try { 
			threadBancoDeDados.join(); //faz o programa so iniciar apos o banco de dados iniciar
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		new IgMenuPrincipal(); // Cria a janela que contém o menu principal
	} // main()
	
} // class bvbApp
