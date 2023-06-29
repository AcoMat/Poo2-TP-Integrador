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
	public void suscribirse(ManejadorDeVotos manejador) {
		if (manejador.getEstadoValidacion().permiteVotoBasico()) {
			manejador.agregarOpinionBasica(this);
		}
		else if (manejador.getEstadoValidacion().permiteVotoExperto()) {
			manejador.agregarOpinionExperta(this);
		}
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
