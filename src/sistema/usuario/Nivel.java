package sistema.usuario;

import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.muestras.*;

public abstract class Nivel {

	public void opinar(Usuario usuario, Muestra muestra, TipoDeVoto voto) {
		Opinion nuevaOpinion = new Opinion(voto, usuario.getUserName(), usuario.esExperto());
		muestra.getHandler().nuevaOpinion(usuario, voto);
		usuario.guardarOpinion(muestra, nuevaOpinion);
	};

	public void enviarMuestra(Usuario usuario, TipoDeVoto especie, String fotoURL, Ubicacion ubicacion) {
		Muestra nuevaMuestra = new Muestra(especie, fotoURL, usuario, ubicacion);
		usuario.guardarMuestra(nuevaMuestra);
	};

	abstract boolean esExperto();
}
