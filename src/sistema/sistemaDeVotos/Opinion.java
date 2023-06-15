package sistema.sistemaDeVotos;

import java.util.Date;

public class Opinion {
	private TipoDeVoto voto;
	private String votoUserName;
	Date fecha = new Date();

	public Opinion(TipoDeVoto v, String username) {
		this.voto = v;
		this.votoUserName = username;
	}

	public TipoDeVoto getVoto() {
		return voto;
	}

	public void setVoto(TipoDeVoto voto) {
		this.voto = voto;
	}

	public String getVotoUserName() {
		return votoUserName;
	}

	public Date getFecha() {
		return fecha;
	}
}
