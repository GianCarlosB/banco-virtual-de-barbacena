package tsi.too.bvb.entidades.conexao;

import java.text.SimpleDateFormat;
import java.util.Date;

/** A classe <code>Conexao</code> manipula dados referênte as conexões dos funcionários do BVB
 * 
 * @author Gian Carlos Barros Honório
 * @author Diego Oliveira
 */
public class Conexao {
	
	private String nomeUsuario;
	private Date dataHoraInicial;
	private Date dataHoraFinal;
	
	/** Cria uma conexão sem nem um atributo
	 */
	public Conexao() {
		super();
	}

	/** Cria uma conexão com o nome do usuário, data inicial e data final
	 * 
	 * @param nomeUsuario <code>String</code> com nome do usuário da conexão
	 * @param dataHoraInicial <code>Date</code> com a data inicial da conexão
	 * @param dataHoraFinal <code>Date</code> com a data final da conexão
	 */
	public Conexao(String nomeUsuario, Date dataHoraInicial, Date dataHoraFinal) {
		this();
		this.nomeUsuario = nomeUsuario;
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
	}

	/** Retorna uma <code>String</code> com o nome do usuário da conexão
	 * @return <code>String</code> com o nome do usuário da conexão
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/** Muda o nome do usuário da conexão
	 * @param nomeUsuario <code>String</code> com o novo nome do usuário da conexão
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/** Retorna um <code>Date</code> com a data inicial da conexão
	 * @return <code>Date</code> com a data inicial da conexão
	 */
	public Date getDataHoraInicial() {
		return dataHoraInicial;
	}

	/** Muda a data inicial da conexão
	 * @param dataHoraInicial <code>Date</code> com a nova data inicial da conexão
	 */
	public void setDataHoraInicial(Date dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	/** Retorna um <code>Date</code> com a data final da conexão
	 * @return <code>Date</code> com a data final da conexão
	 */
	public Date getDataHoraFinal() {
		return dataHoraFinal;
	}

	/** Muda a data final da conexão
	 * @param dataHoraFinal <code>Date</code> com a nova data final da conexão
	 */
	public void setDataHoraFinal(Date dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}

	/** Retorna uma <code>String</code> com todos os dados da conexão
	 * @return <code>String</code> com todos os dados da conexão
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Nome do Usuário: ").append(nomeUsuario)
				.append("\n Data Inicial: ").append(new SimpleDateFormat("dd/MM/yyyy").format(dataHoraInicial))
			    .append("\n Hora Inicial: ").append(new SimpleDateFormat("HH:mm:ss").format(dataHoraInicial))
			    .append("\n Data Final: ").append(new SimpleDateFormat("dd/MM/yyyy").format(dataHoraFinal))
				.append("\n Hora Final: ").append(new SimpleDateFormat("HH:mm:ss").format(dataHoraFinal));
		return builder.toString();
	}
	
} // class Conexao
