package sistema.muestras;

import sistema.usuario.*;
import sistema.sistemaDeVotos.*;
import sistema.ubicacion.*;

import java.util.ArrayList;


public class Muestra {

	String fotoURL;
	Usuario autor;
	Ubicacion ubicacion;

	ManejadorDeVotos hadler = new ManejadorDeVotos();
	

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
	public ManejadorDeVotos getHadler() {
		return hadler;
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


	// Constructor

	public Muestra(TipoDeVoto especie, String fotoURL, Usuario autor, Ubicacion ubicacion) {
		this.getHadler().asociarMuestra(this);
		this.setFotoURL(fotoURL);
		this.setAutor(autor);
		this.setUbicacion(ubicacion);
	}
	
	// Metodos

	public void registrarOpinion(Opinion o){
		this.getHadler().registrarOpinion(o);
	}

	// la muestra de un experto la pueden opinar basicos? seguramente no??

	public resultadoActual(){
		this.getHadler().resultadoActual();
	}

	
	
}
