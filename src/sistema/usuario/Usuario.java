package sistema.usuario;

import sistema.muestras.Muestra;
import java.util.ArrayList;

import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Usuario {

	String userName;
	boolean conocimientoValidado = false;
	private Nivel nivel;
	private ArrayList<Muestra> muestras;
	private ArrayList<Opinion> opiniones;

	// Constructor

	public Usuario(String name, Boolean validado) {
		this.setConocimientoValidado(validado);
		this.userName = name;
		this.nivel = new Basico();
	}

	private int cantEnviosEn30Dias() {
		return 0;
//		return muestras.stream().count(muestra => muestra.getFecha() - today <= 30);
	}

	private int cantRevisionesEn30Dias() {
		return 0;
//		return opiniones.stream().count(opinion => opinion.getFecha() - today <= 30);
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

	public void guardarOpinion(Opinion opinion) {
		this.opiniones.add(opinion);
	}

	public void guardarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}

	public String getName() {
		return this.userName;
	}

}
