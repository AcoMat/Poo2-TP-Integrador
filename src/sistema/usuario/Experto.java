package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Experto extends Nivel {
	private Usuario usuario;


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean esExperto() {
		return false;
	}
}