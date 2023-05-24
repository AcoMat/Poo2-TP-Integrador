package app.usuario;

import app.sistemaDeVotos.SistemaDeVotos;
import app.sistemaDeVotos.TipoDeVoto;

public class Basico implements Tipo {
	private Usuario usuario;

	@Override
	public void opinar(TipoDeVoto voto) {
		SistemaDeVotos.nuevaOpinion(usuario, voto);

	}

	@Override
	public void enviarMuestra() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

	}

}
