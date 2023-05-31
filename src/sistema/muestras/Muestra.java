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

	// Constructor

	public Muestra(TipoDeVoto especie, String fotoURL, Usuario autor, Ubicacion ubicacion) {
		this.getHandler().asociarMuestra(this);
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

	// Metodos

	public void registrarOpinion(Opinion o) {
		this.getManejadorVotos().agregarOpinion(o);
	}

	// la muestra de un experto la pueden opinar basicos? seguramente no??

	public TipoDeVoto resultadoActual() {
		return this.getManejadorVotos().resultadoActual();
	}

}
