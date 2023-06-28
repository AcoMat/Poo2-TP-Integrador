package sistema.buscadorV3;

import java.util.List;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

public class BuscadorPorValidacion implements IBuscador {
	private TipoDeVoto tipoDeVoto;
	

	public TipoDeVoto getTipoDeVoto() {
		return tipoDeVoto;
	}
	public void setTipoDeVoto(TipoDeVoto tipoDeVoto) {
		this.tipoDeVoto = tipoDeVoto;
	}
	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return this.nivelValidacion(muestras, this.getTipoDeVoto());
	}
	public  List<Muestra> nivelValidacion(List<Muestra> muestras, TipoDeVoto validacionMuestra) {
		return muestras.stream().filter(s -> s.resultadoActual() == validacionMuestra).toList();
	}
	public BuscadorPorValidacion(TipoDeVoto tipoDeVoto) {
		super();
		this.tipoDeVoto = tipoDeVoto;
	}
	
}
