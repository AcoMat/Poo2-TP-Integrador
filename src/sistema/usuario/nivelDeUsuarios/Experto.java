package sistema.usuario.nivelDeUsuarios;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.usuario.Usuario;

public class Experto extends Nivel {

	public void opinar(Usuario usuario, Muestra muestra, TipoDeVoto voto) {
		Opinion nuevaOpinion = new Opinion(voto, usuario);
		muestra.getManejadorVotos().agregarOpinionExperta(nuevaOpinion);
		usuario.guardarOpinion(muestra, nuevaOpinion);
	};

	@Override
	public boolean esExperto() {
		return true;
	}
}