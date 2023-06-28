package sistema.buscadorV3;

import java.util.List;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

public class BuscadorPorTipoInsecto implements IBuscador {
	private TipoDeVoto insectoBuscado;
	
	
	@Override
	public List<Muestra> buscarMuestras(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return this.muestrasConInsecto(muestras, this.insectoBuscado);
	}
	
	public List<Muestra> muestrasConInsecto(List<Muestra> muestras, TipoDeVoto insecto) {
		return muestras.stream().filter(s -> s.getEspecie() == insecto).toList();
	}

	public BuscadorPorTipoInsecto(TipoDeVoto insectoBuscado) {
		super();
		this.insectoBuscado = insectoBuscado;
	}
	
	

}
