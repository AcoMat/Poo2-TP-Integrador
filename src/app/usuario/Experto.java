package app.usuario;

import app.muestras.Muestra;
import app.sistemaDeVotos.SistemaDeVotos;
import app.sistemaDeVotos.TipoDeVoto;

public class Experto implements Tipo {
	private Usuario usuario;

	@Override
	public void opinar(TipoDeVoto voto, Muestra muestra) {
		SistemaDeVotos.nuevaOpinionExperto(usuario, voto);
	}


	@Override
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

	}

}