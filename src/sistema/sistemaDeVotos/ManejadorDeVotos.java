package sistema.sistemaDeVotos;

import sistema.muestras.Muestra;

import sistema.sistemaDeVotos.validacion.VotanTodos;
import sistema.sistemaDeVotos.validacion.EstadoValidacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class ManejadorDeVotos {

	Muestra muestraAsociada;

	ArrayList<Opinion> opinionesBasicas;
	ArrayList<Opinion> opinionesExpertas;

	EstadoValidacion estadoValidacion = new VotanTodos();

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
		if (estadoValidacion.permiteVotoBasico()) {
			opinionesBasicas.add(opinion);
			setEstadoValidacion();
		}

	}

	public void agregarOpinionExperta(Opinion opinion) {
		if (estadoValidacion.permiteVotoExperto()) {
			opinionesExpertas.add(opinion);
			setEstadoValidacion();
		}

	}

	//
	// Set Estado
	public void setEstadoValidacion() {
		estadoValidacion = null;
	}

	// Resultado de votación actual
	public TipoDeVoto resultadoDeVotacion() {
		return estadoValidacion.resultadoActual(this);
	}
}
