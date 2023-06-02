package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Validada extends EstadoValidacion {

	TipoDeVoto votoValidado;

	public Validada(TipoDeVoto votoGanador) {
		votoValidado = votoGanador;
	}

	// Booleanos a refactorizar
	public Boolean permiteVotoBasico() {
		return false;
	}

	public Boolean permiteVotoExperto() {
		return false;
	}

	public EstadoValidacion cambioDeEstado(ManejadorDeVotos manejadorDeVotos, Opinion opinion) {
		return this;
	}

	// Resultado Actual
	public TipoDeVoto resultadoActual(ManejadorDeVotos manejadorDeVotos) {
		return votoValidado;
	}

}
