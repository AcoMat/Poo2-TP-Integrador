package sistema.usuario.nivelDeUsuarios;

import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.muestras.*;
import sistema.usuario.Usuario;

public abstract class Nivel {
	public abstract void opinar(Usuario usuario, Muestra muestra, TipoDeVoto voto);

	public void enviarMuestra(IUsuario usuario, ITipoDeVoto2 especie, String fotoURL, IUbicacion ubicacion) {
		Muestra nuevaMuestra = new Muestra(especie, fotoURL, usuario, ubicacion);
		usuario.guardarMuestra(nuevaMuestra);
	};

	abstract boolean esExperto();
}
