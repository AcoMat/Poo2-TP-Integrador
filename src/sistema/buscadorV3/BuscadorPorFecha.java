package sistema.buscadorV3;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import sistema.muestras.Muestra;

public abstract class BuscadorPorFecha implements IBuscador {
	private Comparator<Muestra> comparator = Comparator.comparing(Muestra::getFechaUltimaVotacion);

	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		List<Muestra> resultado = this.criterioDeBusquedaPorFecha(muestras, null);
		return resultado;
	}

	public List<Muestra> creadasAntesDe(List<Muestra> muestras, Date fecha) {
		List<Muestra> resultado = muestras.stream().filter(s -> s.getFecha().after(fecha)).toList();
		return resultado;
	}

	public List<Muestra> creadasDespuesDe(List<Muestra> muestras, Date fecha) {
		List<Muestra> resultado = muestras.stream().filter(s -> s.getFecha().before(fecha)).toList();
		return resultado;
	}

	public Optional<Muestra> ultimaVotada(List<Muestra> muestras) {
		Optional<Muestra> filtro = muestras.stream().max(comparator);
		return filtro;
	}

	public List<Muestra> votadasLuegoDeLaFecha(List<Muestra> muestras, Date fecha) {
		List<Muestra> resultado = muestras.stream().filter(s -> s.getFechaUltimaVotacion().before(fecha)).toList();
		return resultado;
	}

	public abstract List<Muestra> criterioDeBusquedaPorFecha(List<Muestra> muestras, Date fecha);

}
