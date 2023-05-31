package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.usuario.Usuario;

public class VotanTodos extends EstadoValidacion {

	// Booleanos a refactorizar
	public Boolean permiteVotoBasico() {
		return true;
	}

	public Boolean permiteVotoExperto() {
		return true;
	}

	// Cambio de estado
	public EstadoValidacion cambioDeEstado(ManejadorDeVotos manejadorDeVotos) {
		return manejadorDeVotos.getOpinionesExpertas().size() > 0 ? new VotanSoloExpertos() : this;
	}
	
	//Resultado Actual
	public TipoDeVoto resultadoActual(ManejadorDeVotos manejadorDeVotos) {
		return null;
	}

}
