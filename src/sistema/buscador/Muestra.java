package sistema.buscador;

import java.util.Date;

public abstract class Muestra {
	public  TipoDeVoto getEstado() {
		return null;
	}
	public TipoDeVoto getEspecieEstadoActual() {
		return null;
	}
	public ManejadorVotos getManejadorVotos() {
		return null;
	}
	public Date getFecha() {
		return null;
	}
	public abstract Date FechaUltimaOpinion() ;
}
