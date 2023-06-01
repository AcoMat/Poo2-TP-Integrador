package sistema.buscador;
import java.util.Date;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Comparator;

public class Buscador {
	// Proposito: se encarga de guardar todas las muestras para su posterior
	// busqueda

	private ArrayList<Muestra> muestrasTotalesDelSys;
	private Comparator<Opinion> comparator = Comparator.comparing(Opinion::getFecha);

	public void nuevaMuestraEnSistema(Muestra m) {
		muestrasTotalesDelSys.add(m);
	}

	// buscar muestras por la fecha de creacion
	public ArrayList<Muestra> muestraCreadaEnLaFecha(Date fecha) {
		return (ArrayList<Muestra>) muestrasTotalesDelSys.stream().filter(s -> s.getFecha() == fecha);
	}

	// consultar tenemos 2 arrays para opiniones
//	public Opinion ultimaOpinionBasico(Muestra muestra) {
//		return muestra.getManejadorVotos().getOpinionesBasicas().stream().max(comparator).get();
//	}
//
//	public Opinion ultimaOpinionExperto(Muestra muestra) {
//		return muestra.getManejadorVotos().getOpinionesExpertas().stream().max(comparator).get();
//	}
//
//	public Date ultimaFechaDeVotacionBasico() {
//    	return muestrasTotalesDelSys.stream().forEach(s-> this.ultimaOpinionBasico(s)).max(comparator).get().;
//    	
//    }

	// Busqueda por la especie 
	public ArrayList<Muestra> muestrasConInsecto(TipoDeVoto insecto) {
		return (ArrayList<Muestra>) muestrasTotalesDelSys.stream().filter(s -> s.getEspecieEstadoActual() == insecto);
	}
	
	// Busqueda por la validacion (falta completar la clase validacion con la muestra)
	public ArrayList<Muestra> nivelValidacion(TipoDeVoto validacionMuestra){
    	return (ArrayList<Muestra>) muestrasTotalesDelSys.stream().filter(s-> s.getEstado()== validacionMuestra);
    }
	
	public ArrayList<Muestra> buscadorGeneral(Date fecha, TipoDeVoto insecto, TipoDeVoto validacionM, boolean ultimaFecha){
		if (ultimaFecha) {
			return extracted(fecha, insecto, validacionM);
		}
		else {
			 return extracted(fecha, insecto, validacionM); //agregarElFiltroPorUltimaFecha
		}
	}

	private ArrayList<Muestra> extracted(Date fecha, TipoDeVoto insecto, TipoDeVoto validacionM) {
		return (ArrayList<Muestra>) muestrasTotalesDelSys.stream().
				filter(s-> s.getFecha() == fecha && 
				s.getEspecieEstadoActual()== insecto &&
				s.getEstado() == validacionM );
	}

}
