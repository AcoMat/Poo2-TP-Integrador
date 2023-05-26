package sistema.sistemaDeVotos;

import sistema.muestras.Muestra;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class ManejadorDeVotos {

    Muestra muestraAsociada;
    ArrayList<Opinion> opiniones;
    Boolean soloExpertos = false;
    TipoDeVoto resultadoActual = TipoDeVoto.Ninguna;

    //Getters

    public Boolean getSoloExpertos() {
        return soloExpertos;
    }
    public ArrayList<Opinion> getOpiniones() {
        return opiniones;
    }
    public TipoDeVoto getResultadoActual() {
        return resultadoActual;
    }

    //Setters

    public void setSoloExpertos(Boolean soloExpertos) {
        this.soloExpertos = soloExpertos;
    }
    private void setMuestraAsociada(Muestra m) {
        this.muestraAsociada = m;
    }

    //

    public void asociarMuestra(Muestra m){
        this.setMuestraAsociada(m);
    }

    public void registrarOpinion(Opinion o) {
        if (o.getEsExperto()){
            this.agregarExperto();
        }else{
            this.agregarBasico();
        }
    }

    private void agregarExperto() {

    }






    public TipoDeVoto resultadoActual() {
        return this.getResultadoActual();
    }
}


