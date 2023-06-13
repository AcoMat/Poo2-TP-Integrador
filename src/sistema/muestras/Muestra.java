package sistema.muestras;

import sistema.usuario.*;

import java.util.Date;

import sistema.sistemaDeVotos.*;
import sistema.ubicacion.*;

public class Muestra {

	String fotoURL;
	Usuario autor;
	Ubicacion ubicacion;
	Date fecha;
	TipoDeVoto especie;

	ManejadorDeVotos manejadorVotos = new ManejadorDeVotos();

	// La muestra debe conocer a "website"?? xq a la hora de validar o agregar, las zonas de cobertura tienen q estar al tanto

	// Constructor

	public Muestra(TipoDeVoto especie, String fotoURL, Usuario autor, Ubicacion ubicacion) {
		this.getManejadorVotos().asociarMuestra(this);
		this.setFotoURL(fotoURL); 
		this.setAutor(autor);
		this.setUbicacion(ubicacion);
		this.especie = especie;
		this.fecha = new Date();
		// registrar voto owner
	}

	// Cuando se crea una muestra se le registra el voto del owner, del resto se
	// encarga el sistema

	// Getters

	public String getFotoURL() {
		return fotoURL;
	}

	public Usuario getAutor() {
		return autor;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public ManejadorDeVotos getManejadorVotos() {
		return manejadorVotos;
	}

	public Date getFecha() {
		return fecha;
	}

	public TipoDeVoto getEspecie() {
		return especie;
	}

	// Setters

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public Date  getFechaUltimaOpinion() {
		return null; 
		//necesito esta implementacion para el buscador.
	}


	// la muestra de un experto la pueden opinar basicos?¿ seguramente no??

	public TipoDeVoto resultadoActual() {
		return this.getManejadorVotos().resultadoDeVotacion();
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setEspecie(TipoDeVoto especie) {
		this.especie = especie;
	}

}
