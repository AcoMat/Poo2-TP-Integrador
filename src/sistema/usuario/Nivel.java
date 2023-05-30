package sistema.usuario;

import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.muestras.*;

public abstract class Nivel {

	public Usuario usuario;

	public void opinar(Muestra muestra, TipoDeVoto voto) {
		Opinion nuevaOpinion = new Opinion(voto, usuario.getUserName(), usuario.esExperto());
		muestra.getHandler().nuevaOpinion(usuario, voto);
		usuario.guardarOpinion(muestra, nuevaOpinion);
	};

	public void enviarMuestra(TipoDeVoto especie, String fotoURL, Ubicacion ubicacion) {
		Muestra nuevaMuestra = new Muestra(especie, fotoURL, usuario, ubicacion);
		usuario.guardarMuestra(nuevaMuestra);
	};

	public  void setUsuario(Usuario nuevoUsuario) {
//		usuario = nuevoUsuario;
	}

	abstract boolean esExperto();
}
