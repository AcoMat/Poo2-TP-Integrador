package sistema.muestras;

import sistema.sistemaDeVotos.Opinion;

import java.util.ArrayList;
import java.util.Date;

public interface IManejadorDeVotos1 {
	public ITipoDeVoto2 resultadoDeVotacion();
	public ArrayList<IOpinion1> getTodasLasOpiniones(); 
	
	public void asociarMuestra(Muestra m) ;
	
	
	public Date getFechaUltimaVotación();

    void agregarOpinionBasica(Opinion nuevaOpinion);

	void agregarOpinionExperta(Opinion nuevaOpinion);
}
