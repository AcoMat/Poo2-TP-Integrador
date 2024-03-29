package sistema.ubicacion;

import sistema.muestras.Muestra;
import sistema.organizaciones.Organizacion;

import java.util.ArrayList;

public class ZonaDeCobertura {
	private Ubicacion epicentro;
	private double radio;
	private String nombre;

	private ArrayList<Muestra> muestrasReportadas = new ArrayList<Muestra>();

	private ArrayList<Organizacion> organizacionesSuscritas = new ArrayList<Organizacion>();

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public double getRadio() {
		return radio;
	}

	//

	public ZonaDeCobertura(Ubicacion epicentro, double radio, String nombre) {
		this.epicentro = epicentro;
		this.radio = radio;
		this.nombre = nombre;
	}

	// Metodos

	public void agregarSiEstaEnLaZona(Muestra muestra) {
		if (estaEnCobertura(muestra)) {
			this.nuevaMuestraEnLaZona(muestra);
		}
	}

	private boolean estaEnCobertura(Muestra muestra) {
		return this.epicentro.distanciaHasta((Ubicacion) muestra.getUbicacion()) < this.radio;
	}

	public void nuevaMuestraEnLaZona(Muestra muestra) {
		this.muestrasReportadas.add(muestra);
		for (Organizacion org : organizacionesSuscritas) {
			org.eventoNuevaMuestra(muestra, this);
		}
	}

	public void nuevaValidacion(Muestra muestra) {
		if (estaEnCobertura(muestra)) {
			for (Organizacion org : organizacionesSuscritas) {
				org.eventoNuevaValidacion(muestra, this);
			}
		}
	}

	public void suscribirA(Organizacion org) {
		organizacionesSuscritas.add(org);
	}

	public void desuscribirA(Organizacion org) {
		organizacionesSuscritas.remove(org);
	}

	public boolean seSolapaCon(ZonaDeCobertura zc) {
		return (this.epicentro.distanciaHasta(zc.getEpicentro())) < this.radio;
	}

	public ArrayList<Muestra> getMuestrasReportadas() {
		return muestrasReportadas;
	}

	public ArrayList<Organizacion> getOrganizacionesSuscritas() {
		return organizacionesSuscritas;
	}
}