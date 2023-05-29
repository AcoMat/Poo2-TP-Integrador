package sistema.usuario;

import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.muestras.*;

public interface Nivel {

	public static Usuario usuario = null;

	public default void opinar(Muestra muestra, TipoDeVoto voto) {
		Opinion nuevaOpinion = new Opinion(voto, usuario.getUserName(), usuario.esExperto());
		muestra.getHandler().nuevaOpinion(usuario, voto);
		usuario.guardarOpinion(muestra, nuevaOpinion);
	};

	public default void enviarMuestra(TipoDeVoto especie, String fotoURL, Ubicacion ubicacion) {
		Muestra nuevaMuestra = new Muestra(especie, fotoURL, usuario, ubicacion);
		usuario.guardarMuestra(nuevaMuestra);
	};

	public default void setUsuario(Usuario nuevoUsuario) {
//		usuario = nuevoUsuario;
	}

	boolean esExperto();
}
