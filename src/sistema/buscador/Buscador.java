package sistema.buscador;

import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.muestras.Muestra;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;

public class Buscador {
	private ArrayList<Muestra> muestrasTotalesDelSys = new ArrayList<Muestra>();
	private Comparator<Muestra> comparator = Comparator.comparing(Muestra::getFechaUltimaOpinion);

	public void muestraAAgregar(Muestra m) {
		muestrasTotalesDelSys.add(m);
	}

	// buscar muestras por la fecha de creacion
	public List<Muestra> muestraCreadaEnLaFecha(Date fecha){
		return muestrasTotalesDelSys.stream().filter(s -> s.getFecha() == fecha).collect(Collectors.toList());
	}
 
	// consultar tenemos 2 arrays para opiniones
	public Optional<Muestra> ultimaMuestraVotada() {
		return muestrasTotalesDelSys.stream().max(comparator);
	}

	// Busqueda por la especie
	public List<Muestra> muestrasConInsecto(TipoDeVoto insecto) {
		return muestrasTotalesDelSys.stream().filter(s -> s.getEspecieEstadoActual() == insecto).collect(Collectors.toList());
	}

	// Busqueda por la validacion 
	public  List<Muestra> nivelValidacion(TipoDeVoto validacionMuestra) {
		return muestrasTotalesDelSys.stream().filter(s -> s.getEstado() == validacionMuestra).collect(Collectors.toList());
	}
	//busqueda conbinando todos los campos
	List<Muestra> buscadorGeneral(Date fecha, TipoDeVoto insecto, TipoDeVoto validacionM, Date ultimaOpinion) {
		return  muestrasTotalesDelSys.stream().filter(
				s -> (s.getFecha() == fecha &&
				s.getEspecieEstadoActual() == insecto && 
				s.getEstado() == validacionM && 
				s.getFechaUltimaOpinion() == ultimaOpinion)).collect(Collectors.toList());
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

	public void registrarNuevaMuestra(Muestra muestra){
		this.muestrasTotalesDelSys.add(muestra);
	}
	
	
	

}
