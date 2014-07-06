package tsi.too.bvb.entidades.conexao;

import java.util.Date;

public class Conexao {
	
	private String nomeUsuario;
	private Date horaInicial;
	private Date horaFinal;
	private Date dataInicial;
	private Date dataFinal;
	
	public Conexao() {
		super();
	}

	public Conexao(String nomeUsuario) {
		this();
		this.nomeUsuario = nomeUsuario;
	}

	public Conexao(Date dataInicial, Date dataFinal, Date horaInicial, Date horaFinal) {
		this();
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
	}

	public Conexao(String nomeUsuario, Date horaInicial, Date horaFinal,
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

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" Nome do Usuário: ").append(nomeUsuario)
			    .append("\n Hora Inicial: ").append(horaInicial)
				.append("\n Hora Final: ").append(horaFinal)
				.append("\n Data Inicial: ").append(dataInicial)
				.append("\n Data Final: ").append(dataFinal);
		return builder.toString();
	}
	
} // class Conexao
