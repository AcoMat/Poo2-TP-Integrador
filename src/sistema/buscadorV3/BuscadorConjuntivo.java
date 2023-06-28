package sistema.buscadorV3;

import java.util.ArrayList;
import java.util.List;

import sistema.muestras.Muestra;

public class BuscadorConjuntivo extends CombinadorDeBusqueda {

	public BuscadorConjuntivo(IBuscador primerTipoDeFiltro, IBuscador segundoTipoDeFiltro,
			ArrayList<Muestra> primeraBusqueda, ArrayList<Muestra> segundaBusqueda) {
		super(primerTipoDeFiltro, segundoTipoDeFiltro, primeraBusqueda, segundaBusqueda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Muestra> tipoDeCombinacion(List<Muestra> muestra1, List<Muestra> muestra2) {
		// TODO Auto-generated method stub
		List<Muestra> resultado = new ArrayList<Muestra>();
		resultado.addAll(muestra1);
		resultado.retainAll(muestra2);
		return resultado;
	}
 
}
