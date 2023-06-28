package sistema.usuario.nivelDeUsuarios;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.usuario.Usuario;

public class Basico extends Nivel {

	public void opinar(Usuario usuario, Muestra muestra, TipoDeVoto voto) {
		Opinion nuevaOpinion = new Opinion(voto, usuario);
		muestra.getManejadorVotos().agregarOpinionBasica(nuevaOpinion);
		usuario.guardarOpinion(muestra, nuevaOpinion);
	};

	@Override
	public boolean esExperto() {
		return false;
	}
}
