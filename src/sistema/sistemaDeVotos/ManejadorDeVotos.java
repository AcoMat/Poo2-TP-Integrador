package sistema.sistemaDeVotos;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.validacion.NoValidada;
import sistema.sistemaDeVotos.validacion.EstadoValidacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class ManejadorDeVotos {

	Muestra muestraAsociada;

	ArrayList<Opinion> opinionesBasicas;
	ArrayList<Opinion> opinionesExpertas;

	EstadoValidacion estadoValidacion = new NoValidada(this);

	// Getters

	public ArrayList<Opinion> getOpinionesBasicas() {
		return opinionesBasicas;
	}

	public ArrayList<Opinion> getOpinionesExpertas() {
		return opinionesExpertas;
	}

	// Setters

	public void asociarMuestra(Muestra m) {
		this.muestraAsociada = m;
	}

	//
	// Agregar Opiniones

	public void agregarOpinionBasica(Opinion opinion) {
		opinionesBasicas.add(opinion);
	}

	public void agregarOpinionExperta(Opinion opinion) {
		opinionesExpertas.add(opinion);
	}
	
	//
	// Set Estado
	public void setEstadoValidacion() {
		estadoValidacion = null;
	}

	//
	// Resultado Actual
	public TipoDeVoto resultadoActual() {
		if (this.opinionesExpertas.size() > 0) {
			return this.opinionGanadora(opinionesExpertas);
		} else {
			return this.opinionGanadora(opinionesBasicas);
		}
	}
	
	public TipoDeVoto opinionGanadora(ArrayList<Opinion> opiniones) {
		return null;
	}
}
