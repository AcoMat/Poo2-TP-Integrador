package sistema.buscadorV3;

import java.util.Date;
import java.util.List;

import sistema.muestras.Muestra;

public class BuscadorVotadasDespuesDe extends BuscadorPorFecha {

	public BuscadorVotadasDespuesDe(Date fechaDeInteres) {
		super(fechaDeInteres);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Muestra> criterioDeBusquedaPorFecha(List<Muestra> muestras, Date fecha) {
		// TODO Auto-generated method stub
		return this.votadasLuegoDeLaFecha(muestras, fecha);
	}

}
