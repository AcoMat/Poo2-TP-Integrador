package sistema.muestras;

import sistema.usuario.*;
import sistema.sistemaDeVotos.*;
import sistema.ubicacion.*;


public class Muestra {

	String fotoURL;
	Usuario autor;
	Ubicacion ubicacion;

	ManejadorDeVotos handler = new ManejadorDeVotos();
	

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
	public ManejadorDeVotos getHandler() {
		return handler;
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
		this.getHandler().asociarMuestra(this);
		this.setFotoURL(fotoURL);
		this.setAutor(autor);
		this.setUbicacion(ubicacion);
		//registrar voto owner
	}

	// Cuando se crea una muestra se le registra el voto del owner, del resto se encarga el sistema

	// Metodos

	public void registrarOpinion(Opinion o){
		this.getHandler().registrarOpinion(o);
	}

	// la muestra de un experto la pueden opinar basicos? seguramente no??

	public TipoDeVoto resultadoActual(){
		return this.getHandler().resultadoActual();
	}

	
	
}
