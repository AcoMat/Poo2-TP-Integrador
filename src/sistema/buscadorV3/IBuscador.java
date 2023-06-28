package sistema.buscadorV3;
import sistema.muestras.Muestra;
import java.util.List;

public interface IBuscador {
	
	public List<Muestra> buscarMuestras(List<Muestra> muestras);
}
