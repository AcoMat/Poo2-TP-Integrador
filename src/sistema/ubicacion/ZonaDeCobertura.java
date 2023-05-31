package sistema.ubicacion;

import sistema.muestras.Muestra;
import sistema.organizaciones.Organizacion;

import java.util.ArrayList;

public class ZonaDeCobertura {
    private Ubicacion epicentro;
    private Integer radio;
    private String nombre;

    private ArrayList<Muestra> muestrasReportadas;

    private ArrayList<Organizacion> organizacionesSuscritas;

    //  Metodos

    public ArrayList<ZonaDeCobertura> zonasQueSeSolapan(){
        //TODo
    }




    public void suscribirA(Organizacion org) {
        organizacionesSuscritas.add(org);
    }

    public void desuscribirA(Organizacion org) {
        organizacionesSuscritas.remove(org);
    }
}
