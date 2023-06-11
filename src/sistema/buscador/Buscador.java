package sistema.buscador;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Comparator;

public class Buscador {

	private ArrayList<Muestra> muestrasTotalesDelSys;
	private Comparator<Muestra> comparator = Comparator.comparing(Muestra::getFechaUltimaOpinion);

	public void muestraAAgregar(Muestra m) {
		muestrasTotalesDelSys.add(m);
	}

	// buscar muestras por la fecha de creacion
	public Stream<Muestra> muestraCreadaEnLaFecha(Date fecha) {
		return muestrasTotalesDelSys.stream().filter(s -> s.getFecha() == fecha);
	}

	// consultar tenemos 2 arrays para opiniones
	public Optional<Muestra> ultimaMuestraVotada() {
		return muestrasTotalesDelSys.stream().max(comparator);
	}

	// Busqueda por la especie
	public Stream<Muestra> muestrasConInsecto(TipoDeVoto insecto) {
		return muestrasTotalesDelSys.stream().filter(s -> s.getEspecieEstadoActual() == insecto);
	}

	// Busqueda por la validacion (falta completar la clase validacion con la
	// muestra
	public Stream<Muestra> nivelValidacion(TipoDeVoto validacionMuestra) {
		return muestrasTotalesDelSys.stream().filter(s -> s.getEstado() == validacionMuestra);
	}
	private Stream<Muestra> buscadorGeneral(Date fecha, TipoDeVoto insecto, TipoDeVoto validacionM, Date ultimaOpinion) {
		return  muestrasTotalesDelSys.stream().filter(
				s -> s.getFecha() == fecha &&
				s.getEspecieEstadoActual() == insecto && 
				s.getEstado() == validacionM && 
				s.getFechaUltimaOpinion() == ultimaOpinion) ;
	}

	// constructor
	public Buscador(ArrayList<Muestra> muestrasTotalesDelSys) {
		super();
		this.muestrasTotalesDelSys = muestrasTotalesDelSys;
	}

	// setter y getter
	public ArrayList<Muestra> getMuestrasTotalesDelSys() {
		return muestrasTotalesDelSys;
	}

	public void setMuestrasTotalesDelSys(ArrayList<Muestra> muestrasTotalesDelSys) {
		this.muestrasTotalesDelSys = muestrasTotalesDelSys;
	}

}
