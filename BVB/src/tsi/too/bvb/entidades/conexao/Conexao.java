package tsi.too.bvb.entidades.conexao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conexao {
	
	private String nomeUsuario;
	private Date dataHoraInicial;
	private Date dataHoraFinal;
	
	public Conexao() {
		super();
	}

	public Conexao(String nomeUsuario) {
		this();
		this.nomeUsuario = nomeUsuario;
	}

	public Conexao(Date dataHoraInicial, Date dataHoraFinal) {
		this();
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
	}

	public Conexao(String nomeUsuario, Date dataHoraInicial, Date dataHoraFinal) {
		this();
		this.nomeUsuario = nomeUsuario;
		this.dataHoraInicial = dataHoraInicial;
		this.dataHoraFinal = dataHoraFinal;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataHoraInicial() {
		return dataHoraInicial;
	}

	public void setDataHoraInicial(Date dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	public Date getDataHoraFinal() {
		return dataHoraFinal;
	}

	public void setDataHoraFinal(Date dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}

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
