package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.SistemaDeVotos;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Basico implements Nivel {
	private Usuario usuario;

	@Override
	public void opinar(TipoDeVoto voto, Muestra muestra) { SistemaDeVotos.nuevaOpinionBasico(usuario, voto); }

	@Override
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

	}

}
