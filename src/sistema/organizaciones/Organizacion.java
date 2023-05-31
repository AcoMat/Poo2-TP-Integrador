package sistema.organizaciones;

import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

import java.util.ArrayList;

public class Organizacion {
    private Ubicacion ubicacion;
    private TipoDeOrg tipoDeLaOrg;
    private int cantEmpleados;
    //
    private FuncionalidadExterna seCargoUnaNuevaMuestra;
    private FuncionalidadExterna seValidoUnaMuestra;
    //
    private ArrayList<ZonaDeCobertura> zonasSubscritas;

    //  Constructor


    public Organizacion(Ubicacion ubicacion, TipoDeOrg tipoDeLaOrg, int cantEmpleados, FuncionalidadExterna nuevaMuestra, FuncionalidadExterna validacionMuestra) {
        this.ubicacion = ubicacion;
        this.tipoDeLaOrg = tipoDeLaOrg;
        this.cantEmpleados = cantEmpleados;
        this.seCargoUnaNuevaMuestra = nuevaMuestra;
        this.seValidoUnaMuestra = validacionMuestra;
    }

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
