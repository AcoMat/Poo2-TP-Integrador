package sistema.ubicacion;

import sistema.muestras.Muestra;
import sistema.organizaciones.Organizacion;

import java.util.ArrayList;

public class ZonaDeCobertura {
    private Ubicacion epicentro;
    private double radio;
    private String nombre;

    private ArrayList<Muestra> muestrasReportadas;

    private ArrayList<Organizacion> organizacionesSuscritas;

    public Ubicacion getEpicentro() {
        return epicentro;
    }

    public double getRadio() {
        return radio;
    }

    //  Metodos

    public void agregarSiEstaEnLaZona(Muestra muestra){
        if(this.epicentro.distanciaHasta(muestra.getUbicacion()) < this.radio){

        }
    }

    public void nuevaMuestraEnLaZona(Muestra muestra){
        muestrasReportadas.add(muestra);
        for (Organizacion org:organizacionesSuscritas) {
            org.eventoNuevaMuestra();
        }
    }

    public void nuevaValidacionEnLaZona(Muestra muestra){
        for (Organizacion org:organizacionesSuscritas) {
            org.eventoNuevaValidacion();
        }
    }

    public void suscribirA(Organizacion org) {
        organizacionesSuscritas.add(org);
    }

    public void desuscribirA(Organizacion org) {
        organizacionesSuscritas.remove(org);
    }

    public boolean seSolapaCon(ZonaDeCobertura zc){
        return (this.epicentro.distanciaHasta(zc.getEpicentro())) < zc.getRadio();
    }
}
