package sistema.buscador.interfacez;

import sistema.muestras.IUbicacion;

import java.util.Date;

public interface IMuestra1 {

	public ITipoDeVoto1 getEstado();

	public ITipoDeVoto1 getEspecieEstadoActual();

	public IManejadorVotos1 getManejadorVotos();

	public Date getFecha();

	public Date getFechaUltimaOpinion();


	IUbicacion getUbicacion();
}
