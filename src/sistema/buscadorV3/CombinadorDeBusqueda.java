package sistema.buscadorV3;
import sistema.muestras.Muestra;

import java.util.ArrayList;
import java.util.List;


public abstract class CombinadorDeBusqueda implements IBuscador {
	private  IBuscador primerTipoDeFiltro;
	private  IBuscador segundoTipoDeFiltro;
 	
	
	
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
		ArrayList<Muestra> primeraBusqueda = new ArrayList<Muestra>();
		ArrayList<Muestra> segundaBusqueda = new ArrayList<Muestra>();
		primeraBusqueda.addAll(this.getPrimerTipoDeFiltro().buscarMuestras(muestras));
		segundaBusqueda.addAll(this.getSegundoTipoDeFiltro().buscarMuestras(muestras));
		return this.tipoDeCombinacion(primeraBusqueda, segundaBusqueda);
		
	}
	
	public abstract List<Muestra> tipoDeCombinacion(List<Muestra> muestra1 , List<Muestra> muestra2);

	public CombinadorDeBusqueda(IBuscador primerTipoDeFiltro, IBuscador segundoTipoDeFiltro) {
		super();
		this.primerTipoDeFiltro = primerTipoDeFiltro;
		this.segundoTipoDeFiltro = segundoTipoDeFiltro;
	}
	
	
}
