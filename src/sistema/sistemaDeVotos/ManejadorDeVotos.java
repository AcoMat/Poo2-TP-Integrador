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

	// Resultado de votación actual
	public TipoDeVoto resultadoDeVotacion() {
		return estadoValidacion.resultadoActual(this);
	}
}
