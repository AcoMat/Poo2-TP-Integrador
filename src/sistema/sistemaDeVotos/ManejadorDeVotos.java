package sistema.sistemaDeVotos;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.validacion.NoValidada;
import sistema.sistemaDeVotos.validacion.Validacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class ManejadorDeVotos {

    Muestra muestraAsociada;
    ArrayList<Opinion> opinionesExpertos;
    ArrayList<Opinion> opinionesBasicos;
    

    Validacion state = new NoValidada(this);


    //Getters
    public ArrayList<Opinion> getOpinionesExpertos() {
		return opinionesExpertos;
	}
    
    public ArrayList<Opinion> getOpinionesBasicos() {
		return opinionesBasicos;
	}

    //Setters

    private void setMuestraAsociada(Muestra m) {
        this.muestraAsociada = m;
    }

    // expertos

	public void setOpinionesExpertos(ArrayList<Opinion> opinionesExpertos) {
		this.opinionesExpertos = opinionesExpertos;
	}

	// basico 
	public void setOpinionesBasicos(ArrayList<Opinion> opinionesBasicos) {
		this.opinionesBasicos = opinionesBasicos;
	}
	// muestra 
	public void asociarMuestra(Muestra m){
        this.setMuestraAsociada(m);
    }

    public void nuevaOpinion(Usuario usuario, TipoDeVoto voto) {
    	//state.
    }
    
    //agragamos la opinion
    public void agregarOpinion(Opinion nuevaOpinion){
    	if ( nuevaOpinion.getEsExperto()) {
    		opinionesExpertos.add(nuevaOpinion);
    	}
    	else {
    		opinionesBasicos.add(nuevaOpinion);
    	}
    }





    public TipoDeVoto resultadoActual() {
        return null; //el voto q mas aparece en el arraylist
    }
}


