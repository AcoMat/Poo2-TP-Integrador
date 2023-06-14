package sistema.sistemaDeVotos;

import java.util.Date;
import sistema.muestras.Muestra;

import sistema.sistemaDeVotos.validacion.VotanTodos;
import sistema.sistemaDeVotos.validacion.EstadoValidacion;
import sistema.sistemaDeVotos.validacion.Validada;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class ManejadorDeVotos {

	Muestra muestraAsociada;

	ArrayList<Opinion> opinionesBasicas = new ArrayList<Opinion>();
	ArrayList<Opinion> opinionesExpertas = new ArrayList<Opinion>();

	EstadoValidacion estadoValidacion = new VotanTodos();
	Date fechaUltimaVotación = new Date();

	// Getters

	public ArrayList<Opinion> getOpinionesBasicas() {
		return opinionesBasicas;
	}

	public ArrayList<Opinion> getOpinionesExpertas() {
		return opinionesExpertas;
	}

	public ArrayList<Opinion> getTodasLasOpiniones() {
		ArrayList<Opinion> todasLasOpiniones = new ArrayList<Opinion>();
		todasLasOpiniones.addAll(opinionesBasicas);
		todasLasOpiniones.addAll(opinionesExpertas);
		return todasLasOpiniones;
	}

	public Date getFechaUltimaVotación() {
		return fechaUltimaVotación;
	}

	// Setters

	public void asociarMuestra(Muestra m) {
		this.muestraAsociada = m;
	}

	public void setFechaDeUltimaVotacion(Date nuevaFecha) {
		fechaUltimaVotación = nuevaFecha;
	}
	//
	// Agregar Opiniones

	public void agregarOpinionBasica(Opinion opinion) {
		if (estadoValidacion.permiteVotoBasico()) {
			opinionesBasicas.add(opinion);
			this.setFechaDeUltimaVotacion(opinion.getFecha());
			this.setEstadoValidacion(opinion);
		}

	}

	public void agregarOpinionExperta(Opinion opinion) {
		if (estadoValidacion.permiteVotoExperto()) {
			opinionesExpertas.add(opinion);
			this.setFechaDeUltimaVotacion(opinion.getFecha());
			this.setEstadoValidacion(opinion);
		} else {
			System.err.println("No es posible agregar opiniones");
		}

	}

	//
	// Set Estado
	public void setEstadoValidacion(Opinion opinion) {
		estadoValidacion = estadoValidacion.cambioDeEstado(this, opinion);
	}

	public Boolean hayDosVotosExpertosIguales() {
		return true;
	}

	// Resultado de votación actual
	public TipoDeVoto resultadoDeVotacion() {
		return estadoValidacion.resultadoActual(this);
	}
}
