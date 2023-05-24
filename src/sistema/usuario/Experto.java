package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.SistemaDeVotos;
import sistema.sistemaDeVotos.TipoDeVoto;

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