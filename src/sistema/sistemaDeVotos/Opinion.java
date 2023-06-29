package sistema.sistemaDeVotos;

import java.util.Date;

import sistema.usuario.Usuario;

public class Opinion {
	private TipoDeVoto voto;
	private Usuario votoUserName;
	Date fecha = new Date();

	public Opinion(TipoDeVoto v, Usuario usuario) {
		this.voto = v;
		this.votoUserName = usuario;
	}

	public TipoDeVoto getVoto() {
		return voto;
	}

	public void setVoto(TipoDeVoto voto) {
		this.voto = voto;
	}

	public Usuario getVotoUserName() {
		return votoUserName;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha=fecha;
	}
}
