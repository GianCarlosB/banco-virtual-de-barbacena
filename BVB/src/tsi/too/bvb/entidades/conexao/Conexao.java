package tsi.too.bvb.entidades.conexao;

import java.sql.Date;

public class Conexao {
	
	private String nomeUsuario, horaInicial, horaFinal;
	private Date dataInicial, dataFinal;
	
	public Conexao() {
		super();
	}

	public Conexao(String nomeUsuario) {
		this();
		this.nomeUsuario = nomeUsuario;
	}

	public Conexao(String horaInicial, String horaFinal) {
		this();
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}
	
	public Conexao(Date dataInicial, Date dataFinal) {
		this();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Conexao(String nomeUsuario, String horaInicial, String horaFinal,
			Date dataInicial, Date dataFinal) {
		this();
		this.nomeUsuario = nomeUsuario;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nome do Usuário: ").append(nomeUsuario)
			    .append("\nHora Inicial: ").append(horaInicial)
				.append("\nHora Final: ").append(horaFinal)
				.append("\nData Inicial: ").append(dataInicial)
				.append("\nData Final: ").append(dataFinal);
		return builder.toString();
	}
	
} // class Conexao
