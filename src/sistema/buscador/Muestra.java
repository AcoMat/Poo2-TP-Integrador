package sistema.buscador;

import java.util.Date;

public interface Muestra {
	public TipoDeVoto getEstado();
	public TipoDeVoto getEspecieEstadoActual();
	public ManejadorVotos getManejadorVotos(); 
	public Date getFecha();
}
