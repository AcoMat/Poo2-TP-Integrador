package sistema.muestras;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Date;



public class Muestra {

	String fotoURL;
	IUsuario autor;
	IUbicacion ubicacion;
	Date fecha;
	ITipoDeVoto2 especie;

	IManejadorDeVotos1 manejadorVotos = mock(IManejadorDeVotos1.class);

	// La muestra debe conocer a "website"?? xq a la hora de validar o agregar, las
	// zonas de cobertura tienen q estar al tanto

	// Constructor

	public Muestra(ITipoDeVoto2 especie, String fotoURL, IUsuario autor, IUbicacion ubicacion) {
		this.getManejadorVotos().asociarMuestra(this);
		this.setFotoURL(fotoURL);
		this.setAutor(autor);
		this.setUbicacion(ubicacion);
		this.especie = especie;
		this.fecha = new Date();
		autor.opinar(this, especie);
	}

	// Getters

	public String getFotoURL() {
		return fotoURL;
	}

	public IUsuario getAutor() {
		return autor;
	}

	public IUbicacion getUbicacion() {
		return ubicacion;
	}

	public IManejadorDeVotos1 getManejadorVotos() {
		return manejadorVotos;
	}

	public Date getFecha() {
		return fecha;
	}

	public ITipoDeVoto2 getEspecie() {
		return especie;
	}

	public ArrayList<IOpinion1> getTodasLasOpiniones() {
		return this.getManejadorVotos().getTodasLasOpiniones();
	}

	public Date getUltimaVotacion() {
		return this.getManejadorVotos().getFechaUltimaVotación();
	}

	// Setters

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	public void setAutor(IUsuario autor) {
		this.autor = autor;
	}

	public void setUbicacion(IUbicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public Date  getFechaUltimaOpinion() {
		return null; 
		//necesito esta implementacion para el buscador.
	}

	public ITipoDeVoto2 resultadoActual() {
		return this.getManejadorVotos().resultadoDeVotacion();
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setEspecie(ITipoDeVoto2 especie) {
		this.especie = especie;
	}

}
