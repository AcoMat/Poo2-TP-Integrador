package sistema.usuario;

import sistema.muestras.Muestra;
import java.util.ArrayList;
import java.util.Date;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.webSite.Website;

public class Usuario {

	String userName;
	boolean conocimientoValidado = false;
	private Nivel nivel;
	private ArrayList<Muestra> muestras;
	private ArrayList<Opinion> opiniones;
	private Website website;

	// Constructor

	public Usuario(String name, Boolean validado) {
		this.setConocimientoValidado(validado);
		this.userName = name;
		this.nivel = new Basico();
	}

	private long cantEnviosEn30Dias() {
		Date fechaActual = new Date();
		return muestras.stream().filter(muestra -> muestra.getFecha().getTime() - fechaActual.getTime() <= 30).count();
	}

	private long cantRevisionesEn30Dias() {
		Date fechaActual = new Date();
		return opiniones.stream().filter(opinion -> opinion.getFecha().getTime() - fechaActual.getTime() <= 30).count();
	}

	private Boolean cumpleEnvios() {
		return this.cantEnviosEn30Dias() >= 10;
	}

	private Boolean cumpleRevisiones() {
		return this.cantRevisionesEn30Dias() >= 20;
	}

	public Boolean esExperto() {
		return this.conocimientoValidado || (this.cumpleEnvios() && this.cumpleRevisiones());
	}

	public void setEstado() {
		this.nivel = this.esExperto() ? new Experto() : new Basico();
		this.nivel.setUsuario(this);
	}

	// Setter

	private void setConocimientoValidado(boolean conocimientoValidado) {
		this.conocimientoValidado = conocimientoValidado;
	}

	// Metodos

	public void opinar(Muestra muestra, TipoDeVoto voto) {
		this.setEstado();
		this.nivel.opinar(muestra, voto);
	}

	public void guardarOpinion(Muestra muestra, Opinion opinion) {
		this.website.registrarOpinion(muestra, opinion);
		this.opiniones.add(opinion);
	}

	public void guardarMuestra(Muestra muestra) {
		this.website.registrarPosteoDesdeLaApp(muestra);
		this.muestras.add(muestra);
	}

	public String getName() {
		return this.userName;
	}

}
