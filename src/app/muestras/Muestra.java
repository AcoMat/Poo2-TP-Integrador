package app.muestras;

import app.vinchucas.*;
import app.usuario.*;
import app.ubicacion.*;

import java.util.ArrayList;


public class Muestra {
	
	Vinchucha especie;
	String fotoURL;
	Usuario autor;
	Ubicacion ubicacion;
	ArrayList<Opinion> votos;
	

	//	Getters
	
	public Vinchucha getEspecie() {
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

	public Muestra(Vinchucha especie, String fotoURL, Usuario autor, Ubicacion ubicacion) {
		this.especie = especie;
		this.fotoURL = fotoURL;
		this.autor = autor;
		this.ubicacion = ubicacion;
	}
	
	// Metodos
	
	public Vinchuca resultadoActual() {
		return sistemaDeVotos.calcularResultado(this.votos);
	}
	
	
}
