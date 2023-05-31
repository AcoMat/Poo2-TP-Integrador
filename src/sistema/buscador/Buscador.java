package sistema.buscador;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.sistemaDeVotos.validacion.Validacion;

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

	// consultar tenemos 2 arrrays para opiniones
	public Opinion ultimaOpinionBasico(Muestra muestra) {
		return muestra.getManejadorVotos().getOpinionesBasicas().stream().max(comparator).get();
	}

	public Opinion ultimaOpinionExperto(Muestra muestra) {
		return muestra.getManejadorVotos().getOpinionesExpertas().stream().max(comparator).get();
	}

	public Date ultimaFechaDeVotacionBasico() {
    	return muestrasTotalesDelSys.stream().forEach(s-> this.ultimaOpinionBasico(s)).max(comparator).get().;
    	
    }

	// Busqueda por la especie 
	public ArrayList<Muestra> muestrasConInsecto(TipoDeVoto insecto) {
		return (ArrayList<Muestra>) muestrasTotalesDelSys.stream().filter(s -> s.getEspecie() == insecto);
	}
	
	// Busqueda por la validacion (falta completar la clase validacion con la muestra)
	public ArrayList<Muestra> nivelValidacion(Validacion validacionMuestra){
    	return (ArrayList<Muestra>) muestrasTotalesDelSys.stream().filter(s-> s.getEstado()== ValidacionMuestra));
    }
	
	public ArrayList<Muestra> buscadorGeneral(Date fecha, TipoDeVoto insecto, Validacion validacionM, boolean ultimaFecha){
		if (ultimaFecha) {
			return this.muestraCreadaEnLaFecha(fecha) && this.muestrasConInsecto(insecto);
		}
	}

}
