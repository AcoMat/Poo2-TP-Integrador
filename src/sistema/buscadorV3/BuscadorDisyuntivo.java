package sistema.buscadorV3;

import java.util.ArrayList;
import java.util.List;

import sistema.muestras.Muestra;

public class BuscadorDisyuntivo extends CombinadorDeBusqueda {

	@Override
	public List<Muestra> tipoDeCombinacion(List<Muestra> muestra1, List<Muestra> muestra2) {
		// TODO Auto-generated method stub
		List<Muestra> resultado = new ArrayList<Muestra>();
		resultado.addAll(muestra1);
		resultado.addAll(muestra2);
		return resultado;
	}

	public BuscadorDisyuntivo(IBuscador primerTipoDeFiltro, IBuscador segundoTipoDeFiltro) {
		super(primerTipoDeFiltro, segundoTipoDeFiltro);
		// TODO Auto-generated constructor stub
	}
	
}
