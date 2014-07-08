package tsi.too.bvb.app;

import tsi.too.bvb.entidades.funcionario.Funcionario;
import tsi.too.bvb.gui.IgApresentacao;
import tsi.too.bvb.gui.JanelaPopUpErro;
import tsi.too.bvb.gui.login.IgLogin;
import tsi.too.bvb.gui.menuprincipal.IgMenuPrincipal;
import tsi.too.bvb.persistencia.BancoDeDadosBVB;

public class bvbApp {
	
	public static void main(String[] args) {
		// Inicia a janela de apresentação (carregamento).
		IgApresentacao igApresentacao = new IgApresentacao();
		
		// Inicia a thread que faz a conexão com o banco de dados.
		Thread threadBancoDeDados = new Thread(BancoDeDadosBVB.getInstance());
		threadBancoDeDados.start();
		
		try { 
			threadBancoDeDados.join(); // Faz o programa só iniciar após o banco de dados iniciar
		}
		catch (InterruptedException e) {
			new JanelaPopUpErro(null, "BVB - ERRO", e);
			System.exit(0);
		}
		
		// Finaliza a Thread da janela de apresentação.
		igApresentacao.finalizarThread();
		
		// Finaliza a janela de apresentação.
		igApresentacao.dispose();
		
		IgMenuPrincipal igMenuPrincipal;
		
		// Enquanto o usuário clicar em Logout, a tela de login reaparece. 
		do{
			// O objeto 'funcionário' recebe os dados do funcionário caso ele consiga logar com sucesso.
			Funcionario funcionario = new IgLogin().getFuncionario();
			
			// Cria a janela que contém o menu principal
			igMenuPrincipal = new IgMenuPrincipal(funcionario);
		}while(igMenuPrincipal.isLogout());
	} // main()
	
} // class bvbApp
