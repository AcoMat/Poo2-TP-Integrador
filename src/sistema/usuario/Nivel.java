package sistema.usuario;

import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.muestras.*;

public abstract class Nivel {
	abstract void opinar(Usuario usuario, Muestra muestra, TipoDeVoto voto);

	public void enviarMuestra(Usuario usuario, TipoDeVoto especie, String fotoURL, Ubicacion ubicacion) {
		Muestra nuevaMuestra = new Muestra(especie, fotoURL, usuario, ubicacion);
		usuario.guardarMuestra(nuevaMuestra);
	};

	abstract boolean esExperto();
}
