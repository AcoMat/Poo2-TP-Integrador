package sistema.sistemaDeVotos;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.validacion.NoValidada;
import sistema.sistemaDeVotos.validacion.Validacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class ManejadorDeVotos {

    Muestra muestraAsociada;
    ArrayList<Opinion> opiniones;

    Validacion state = new NoValidada(this);


    //Getters

    public ArrayList<Opinion> getOpiniones() {
        return opiniones;
    }

    //Setters

    private void setMuestraAsociada(Muestra m) {
        this.muestraAsociada = m;
    }

    //

    public void asociarMuestra(Muestra m){
        this.setMuestraAsociada(m);
    }

    public void registrarOpinion(Opinion o) {
        state.
    }

    public void agregarOpinion(Opinion o){
        opiniones.add(o);
    }





    public TipoDeVoto resultadoActual() {
        return //el voto q mas aparece en el arraylist
    }
}


