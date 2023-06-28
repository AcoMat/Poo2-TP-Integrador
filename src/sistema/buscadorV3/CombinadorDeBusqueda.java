package sistema.buscadorV3;
import sistema.muestras.Muestra;

import java.util.ArrayList;
import java.util.List;


public abstract class CombinadorDeBusqueda implements IBuscador {
	private  IBuscador primerTipoDeFiltro;
	private  IBuscador segundoTipoDeFiltro;
	private ArrayList<Muestra> primeraBusqueda = new ArrayList<Muestra>();
	private ArrayList<Muestra> segundaBusqueda = new ArrayList<Muestra>();
 	
	
	
	public IBuscador getPrimerTipoDeFiltro() {
		return primerTipoDeFiltro;
	}

	public void setPrimerTipoDeFiltro(IBuscador primerTipoDeFiltro) {
		this.primerTipoDeFiltro = primerTipoDeFiltro;
	}

	public IBuscador getSegundoTipoDeFiltro() {
		return segundoTipoDeFiltro;
	}

	public void setSegundoTipoDeFiltro(IBuscador segundoTipoDeFiltro) {
		this.segundoTipoDeFiltro = segundoTipoDeFiltro;
	}

	public List<Muestra> buscarMuestras(List<Muestra> muestras){
		primeraBusqueda.addAll(this.getPrimerTipoDeFiltro().buscarMuestras(muestras));
		segundaBusqueda.addAll(this.getSegundoTipoDeFiltro().buscarMuestras(muestras));
		return this.tipoDeCombinacion(primeraBusqueda, segundaBusqueda);
		
	}
	
	public abstract List<Muestra> tipoDeCombinacion(List<Muestra> muestra1 , List<Muestra> muestra2);
	
}
