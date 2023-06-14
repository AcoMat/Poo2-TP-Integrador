package sistema.muestras;

import java.util.ArrayList;
import java.util.Date;
import sistema.sistemaDeVotos.*;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.Usuario;



public class Muestra {

	String fotoURL;
	Usuario autor;
	Ubicacion ubicacion;
	Date fecha;
	TipoDeVoto especie;

	ManejadorDeVotos manejadorVotos = new ManejadorDeVotos();

	// Constructor
	public Muestra(TipoDeVoto especie, String fotoURL, Usuario autor, Ubicacion ubicacion) {
		this.getManejadorVotos().asociarMuestra(this);
		this.fotoURL =fotoURL;
		this.autor = autor;
		this.ubicacion = ubicacion;
		this.especie = especie;
		this.fecha = new Date();
		autor.opinar(this, especie);
	}

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

	//

	public Date getFechaUltimaVotacion() {
		return this.getManejadorVotos().getFechaUltimaVotación();
	}

	public TipoDeVoto resultadoActual() {
		return this.getManejadorVotos().resultadoDeVotacion();
	}



}
