package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;

public abstract class EstadoValidacion {

	// Booleanos a refactorizar
	public abstract Boolean permiteVotoBasico();

	public abstract Boolean permiteVotoExperto();

	// Cambio de estado
	public abstract EstadoValidacion cambioDeEstado(ManejadorDeVotos manejadorDeVotos, Opinion opinion);

	// Resultado Actual
	public abstract TipoDeVoto resultadoActual(ManejadorDeVotos manejadorDeVotos);

}
