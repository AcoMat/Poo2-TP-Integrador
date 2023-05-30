package sistema.usuario;

import sistema.muestras.Muestra;

import java.util.ArrayList;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.webSite.Website;

public class Usuario {

	String userName;
	boolean conocimientoValidado = false;
	private Nivel nivel;
	private ArrayList<Muestra> muestras;
	private ArrayList<Opinion> opiniones;
	private Website website;

	// Constructor

	public Usuario(String name, Boolean expertoValidado) {
		conocimientoValidado = expertoValidado;
		this.userName = name;
		this.nivel = new Basico();
	}

	// Getters
	public String getUserName() {
		return this.userName;
	}

	public Boolean isConocimientoValidado() {
		return this.conocimientoValidado;
	}

	public ArrayList<Muestra> getMuestras() {
		return muestras;
	}

	public ArrayList<Opinion> getOpiniones() {
		return opiniones;
	}

	// Setters
	public void setNivel() {
		CalculadorDeNivel calculador = new CalculadorDeNivel();
		this.nivel = calculador.esExperto(this) ? new Experto() : new Basico();
	}

	//
	// Metodos
	//
	// Opinar
	public void opinar(Muestra muestra, TipoDeVoto voto) {
		this.setNivel();
		this.nivel.opinar(this, muestra, voto);
	}

	public void guardarOpinion(Muestra muestra, Opinion opinion) {
		this.website.registrarOpinion(muestra, opinion);
		this.opiniones.add(opinion);
	}

	// Enviar muestras
	public void enviarMuestra(TipoDeVoto especie, String fotoURL, Ubicacion ubicacion) {
		this.setNivel();
		this.nivel.enviarMuestra(this, especie, fotoURL, ubicacion);
	}

	public void guardarMuestra(Muestra muestra) {
		this.website.registrarPosteoDesdeLaApp(muestra);
		this.muestras.add(muestra);
	}
}
