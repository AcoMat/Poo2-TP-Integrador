package sistema.muestras;

import sistema.usuario.*;
import sistema.sistemaDeVotos.*;
import sistema.ubicacion.*;

import java.util.ArrayList;


public class Muestra {

	String fotoURL;
	Usuario autor;
	Ubicacion ubicacion;
	ArrayList<Voto> votos;
	TipoDeVoto resultadoActual;
	

	//	Getters

	public String getFotoURL() {
		return fotoURL;
	}
	public Usuario getAutor() {
		return autor;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public TipoDeVoto getResultadoActual() {
		return resultadoActual;
	}

	//	Setters

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public void setResultadoActual(TipoDeVoto resultadoActual) {
		this.resultadoActual = resultadoActual;
	}


	// Constructor

	public Muestra(TipoDeVoto especie, String fotoURL, Usuario autor, Ubicacion ubicacion) {
		this.setResultadoActual(especie);
		this.setFotoURL(fotoURL);
		this.setAutor(autor);
		this.setUbicacion(ubicacion);
	}
	
	// Metodos
	
	public TipoDeVoto resultadoActual() {
		return this.getResultadoActual();
	}

	
	
}
