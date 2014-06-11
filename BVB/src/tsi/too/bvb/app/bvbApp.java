package tsi.too.bvb.app;

import tsi.too.bvb.gui.MenuPrincipal;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

public class bvbApp {
	
	public static void main(String[] args) {
		// Inicia a thread que faz a conexão com o banco de dados.
		BancoDeDadosBVB bancoDeDadosBVB = BancoDeDadosBVB.getInstance();
		Thread threadBancoDeDados = new Thread(bancoDeDadosBVB);
		threadBancoDeDados.start();
		
		try { 
			threadBancoDeDados.join(); //faz o programa so iniciar apos o banco de dados iniciar
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		new MenuPrincipal();
		
		// Fecha a conexão com o banco de dados.
		// bancoDeDadosBVB.fecharTudo();
	} // main()
	
} // class bvbApp
