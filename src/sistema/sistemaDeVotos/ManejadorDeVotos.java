package sistema.sistemaDeVotos;

import java.util.Date;
import sistema.muestras.Muestra;

import sistema.sistemaDeVotos.validacion.VotanTodos;
import sistema.sistemaDeVotos.validacion.EstadoValidacion;

import java.util.ArrayList;

public class ManejadorDeVotos {

	private Muestra muestraAsociada;

	private ArrayList<Opinion> opinionesBasicas = new ArrayList<Opinion>();
	private ArrayList<Opinion> opinionesExpertas = new ArrayList<Opinion>();

	private EstadoValidacion estadoValidacion = new VotanTodos();
	private Date fechaUltimaVotación = new Date();

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
		opinionesBasicas.add(opinion);
		this.setFechaDeUltimaVotacion(opinion.getFecha());
		this.setEstadoValidacion(opinion);

	}

	public void agregarOpinionExperta(Opinion opinion) {
		opinionesExpertas.add(opinion);
		this.setFechaDeUltimaVotacion(opinion.getFecha());
		this.setEstadoValidacion(opinion);

	}

	public void agregarOpinion(Opinion opinionAAgregar) {
		opinionAAgregar.suscribirse(this);
	}

	//
	// Set Estado
	public void setEstadoValidacion(Opinion opinion) {
		estadoValidacion = estadoValidacion.cambioDeEstado(this, opinion);
	}

	// get Estado
	public EstadoValidacion getEstadoValidacion() {
		return estadoValidacion;
	}
	public void setEstadoValidacion(EstadoValidacion estado) {
		this.estadoValidacion=estado ;
	}

	// Resultado de votación actual
	public TipoDeVoto resultadoDeVotacion() {
		return estadoValidacion.resultadoActual(this);
	}
}
