package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;

public class VotanSoloExpertos extends EstadoValidacion {

	// Booleanos a refactorizar
	public Boolean permiteVotoBasico() {
		return false;
	}

	public Boolean permiteVotoExperto() {
		return true;
	}

	// Cambio de estado
	public EstadoValidacion cambioDeEstado(ManejadorDeVotos manejadorDeVotos, Opinion opinion) {
		if (manejadorDeVotos.getOpinionesExpertas().stream()
				.anyMatch(opinionExperta -> opinion.getVoto() == opinionExperta.getVoto())) {
			return new Validada(opinion.getVoto());
		} else {
			return this;
		}
	}

	// Resultado Actual
	public TipoDeVoto resultadoActual(ManejadorDeVotos manejadorDeVotos) {
		return null;
	}
}
