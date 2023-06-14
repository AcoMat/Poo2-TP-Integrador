package sistema.buscador.implementacionMartin;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Comparator;

public class Buscador {
	private ArrayList<IMuestra1> muestrasTotalesDelSys;
	private Comparator<IMuestra1> comparator = Comparator.comparing(IMuestra1::getFechaUltimaOpinion);

	public void muestraAAgregar(IMuestra1 m) {
		muestrasTotalesDelSys.add(m);
	}

	// buscar muestras por la fecha de creacion
	public List<IMuestra1> muestraCreadaEnLaFecha(Date fecha){
		return muestrasTotalesDelSys.stream().filter(s -> s.getFecha() == fecha).collect(Collectors.toList());
	}
 
	// consultar tenemos 2 arrays para opiniones
	public Optional<IMuestra1> ultimaMuestraVotada() {
		return muestrasTotalesDelSys.stream().max(comparator);
	}

	// Busqueda por la especie
	public List<IMuestra1> muestrasConInsecto(ITipoDeVoto1 insecto) {
		return muestrasTotalesDelSys.stream().filter(s -> s.getEspecieEstadoActual() == insecto).collect(Collectors.toList());
	}

	// Busqueda por la validacion 
	public  List<IMuestra1> nivelValidacion(ITipoDeVoto1 validacionMuestra) {
		return muestrasTotalesDelSys.stream().filter(s -> s.getEstado() == validacionMuestra).collect(Collectors.toList());
	}
	//busqueda conbinando todos los campos
	List<IMuestra1> buscadorGeneral(Date fecha, ITipoDeVoto1 insecto, ITipoDeVoto1 validacionM, Date ultimaOpinion) {
		return  muestrasTotalesDelSys.stream().filter(
				s -> (s.getFecha() == fecha &&
				s.getEspecieEstadoActual() == insecto && 
				s.getEstado() == validacionM && 
				s.getFechaUltimaOpinion() == ultimaOpinion)).collect(Collectors.toList());
	}

	// constructor
	public Buscador(ArrayList<IMuestra1> muestrasTotalesDelSys) {
		super();
		this.muestrasTotalesDelSys = muestrasTotalesDelSys;
	}

	// setter y getter
	public ArrayList<IMuestra1> getMuestrasTotalesDelSys() {
		return muestrasTotalesDelSys;
	}

	public void setMuestrasTotalesDelSys(ArrayList<IMuestra1> muestrasTotalesDelSys) {
		this.muestrasTotalesDelSys = muestrasTotalesDelSys;
	}
	
	
	

}
