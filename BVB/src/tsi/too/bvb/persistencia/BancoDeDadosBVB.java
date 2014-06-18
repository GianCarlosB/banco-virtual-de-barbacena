package tsi.too.bvb.persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BancoDeDadosBVB extends BancoDeDadosDAO implements Runnable {
	
	private final static String DIRETORIO = "database\\bvbdb"; // URL de accesso ao banco de dados.

	private static final String TIPO = "jdbc:hsqldb:file:";

	private final static String URL = TIPO + DIRETORIO;
	
	/** <code>BancoDeDadosBVB</code> com a instâncoa do banco de dados */
	protected static BancoDeDadosBVB BANCO_DE_DADOS_BVB = new BancoDeDadosBVB();
	
	/** Cria uma instância do banco de dados do sistema
	 * 
	 */
	protected BancoDeDadosBVB() {
		super(URL);
	}
	
	/** Retorna a instancia do banco de dados do sistema
	 * @return <code>BancoDeDadosBVB</code> com a instancia da classe
	 */
	public static BancoDeDadosBVB getInstance() {
		return BANCO_DE_DADOS_BVB;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.abrirConexao();  
		System.out.println("Banco de dados iniciado: " + new SimpleDateFormat("yyyy/MM/dd  HH:mm").format( new Date()) +
				           "\nURL da conexão: " + URL);
	}

} // class BancoDeDadosBVB
