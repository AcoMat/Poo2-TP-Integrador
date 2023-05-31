package sistema.usuario.nivelDeUsuarios;

import sistema.usuario.Usuario;

import java.util.Date;

public class CalculadorDeNivel {
	private long cantEnviosEn30Dias(Usuario usuario) {
		Date fechaActual = new Date();
		return usuario.getMuestras().stream().filter(muestra -> muestra.getFecha().getTime() - fechaActual.getTime() <= 30).count();
	}

	private long cantRevisionesEn30Dias(Usuario usuario) {
		Date fechaActual = new Date();
		return usuario.getOpiniones().stream().filter(opinion -> opinion.getFecha().getTime() - fechaActual.getTime() <= 30).count();
	}

	private Boolean cumpleEnvios(Usuario usuario) {
		return this.cantEnviosEn30Dias(usuario) >= 10;
	}

	private Boolean cumpleRevisiones(Usuario usuario) {
		return this.cantRevisionesEn30Dias(usuario) >= 20;
	}

	public Boolean esExperto(Usuario usuario) {
		return usuario.isConocimientoValidado() || (this.cumpleEnvios(usuario) && this.cumpleRevisiones(usuario));
	}
}
