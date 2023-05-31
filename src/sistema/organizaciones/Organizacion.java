package sistema.organizaciones;

import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

import java.util.ArrayList;

public class Organizacion {
    private Ubicacion ubicacion;
    private TipoDeOrg tipoDeLaOrg;
    private int cantEmpleados;

    private FuncionalidadExterna seCargoUnaNuevaMuestra;
    private FuncionalidadExterna seValidoUnaMuestra;

    private ArrayList<ZonaDeCobertura> zonasSubscritas;

    public void suscribirseAZona(ZonaDeCobertura zona){
        //observer
    }

    public void deSuscribirseDe(ZonaDeCobertura zona){
        //TODO
    }

    public void eventoNuevaMuestra(){

    }

    public void eventoNuevaValidacion(){

    }

}
