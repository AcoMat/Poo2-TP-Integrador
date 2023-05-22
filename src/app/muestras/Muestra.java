package app.muestras;

import app.usuario.*;
import app.sistemaDeVotos.*;
import app.ubicacion.*;

import java.util.ArrayList;


public class Muestra {
	
	TipoDeVoto especie;
	String fotoURL;
	Usuario autor;
	Ubicacion ubicacion;
	ArrayList<Opinion> votos;
	

	//	Getters
	
	public TipoDeVoto getEspecie() {
		return especie;
	}

	public String getFotoURL() {
		return fotoURL;
	}

	public Usuario getAutor() {
		return autor;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	
	
	// Constructor

	public Muestra(TipoDeVoto especie, String fotoURL, Usuario autor, Ubicacion ubicacion) {
		this.especie = especie;
		this.fotoURL = fotoURL;
		this.autor = autor;
		this.ubicacion = ubicacion;
	}
	
	// Metodos
	
	public TipoDeVoto resultadoActual() {
		return sistemaDeVotos.calcularResultado(this.votos);
	}
	
	
}
