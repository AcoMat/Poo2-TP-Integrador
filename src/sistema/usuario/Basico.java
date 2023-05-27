package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Basico implements Nivel {
	private Usuario usuario;

	@Override
	public void opinar(TipoDeVoto voto, Muestra muestra) {

	}

	@Override
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

	}

	@Override
	public boolean esExperto() {
		return false;
	}
}
