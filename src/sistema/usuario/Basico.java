package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Basico extends Nivel {

	public void opinar(Usuario usuario, Muestra muestra, TipoDeVoto voto) {
		Opinion nuevaOpinion = new Opinion(voto, usuario.getUserName());
		muestra.getManejadorVotos().agregarOpinionBasica(nuevaOpinion);
		usuario.guardarOpinion(muestra, nuevaOpinion);
	};

	@Override
	public boolean esExperto() {
		return false;
	}
}
