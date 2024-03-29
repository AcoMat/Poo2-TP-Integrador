package sistema.usuario;

import sistema.muestras.Muestra;

import java.util.ArrayList;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.nivelDeUsuarios.Basico;
import sistema.usuario.nivelDeUsuarios.CalculadorDeNivel;
import sistema.usuario.nivelDeUsuarios.Experto;
import sistema.usuario.nivelDeUsuarios.Nivel;
import sistema.websiteapp.Website;

public class Usuario {

	String userName;
	boolean conocimientoValidado = false;
	private Nivel nivel = new Basico();
	private ArrayList<Muestra> muestras = new ArrayList<Muestra>();
	private ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
	private Website website;
	private CalculadorDeNivel calculador = new CalculadorDeNivel();

	// Constructor
	public Usuario(String name, Boolean expertoValidado, Website registradoEn) {
		conocimientoValidado = expertoValidado;
		this.userName = name;
		this.website = registradoEn;
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

	public Website dondeEstaRegistrado() {
		return website;
	}

	// Setters
	public void setNivel() {
		this.nivel = calculador.esExperto(this) ? new Experto() : new Basico();
	}

	//
	// Metodos
	//
	// Opinar
	public void opinar(Muestra muestra, TipoDeVoto voto) {
		this.setNivel();
		this.getNivel().opinar(this, muestra, voto);
	}

	public void guardarOpinion(Muestra muestra, Opinion opinion) {
		this.opiniones.add(opinion);
	}

	// Enviar muestras
	public void enviarMuestra(TipoDeVoto especie, String fotoURL, Ubicacion ubicacion) {
		this.setNivel();
		this.getNivel().enviarMuestra(this, especie, fotoURL, ubicacion);
	}

	public void guardarMuestra(Muestra muestra) {
		this.website.registrarNuevaMuestra(muestra);
		this.muestras.add(muestra);
	}

	public Nivel getNivel() {
		return nivel;
	}
}
