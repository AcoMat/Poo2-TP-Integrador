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

    //

    public void setSeCargoUnaNuevaMuestra(FuncionalidadExterna seCargoUnaNuevaMuestra) {
        this.seCargoUnaNuevaMuestra = seCargoUnaNuevaMuestra;
    }

    public void setSeValidoUnaMuestra(FuncionalidadExterna seValidoUnaMuestra) {
        this.seValidoUnaMuestra = seValidoUnaMuestra;
    }

    //
    public void suscribirseAZona(ZonaDeCobertura zona){
        //observer
        zona.suscribirA(this);
    }

    public void deSuscribirseDe(ZonaDeCobertura zona){
        zona.desuscribirA(this);
    }
    //

    //  Funcionalidades Externas

    public void eventoNuevaMuestra(){
        //Todo
    }

    public void eventoNuevaValidacion(){
        //TODO
    }

}