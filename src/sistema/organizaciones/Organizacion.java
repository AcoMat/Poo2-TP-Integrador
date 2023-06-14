package sistema.organizaciones;

import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

import java.util.ArrayList;

public class Organizacion {
    private Ubicacion ubicacion;
    private TipoDeOrg tipoDeLaOrg;
    private int cantEmpleados;
    //
    private FuncionalidadExterna funcionalidadExternaNuevaMuestra;
    private FuncionalidadExterna funcionalidadExternaNuevaValidacion;
    //
    private ArrayList<ZonaDeCobertura> zonasSubscritas;

    //  Constructor

    public Organizacion(Ubicacion ubicacion, TipoDeOrg tipoDeLaOrg, int cantEmpleados, FuncionalidadExterna nuevaMuestra, FuncionalidadExterna validacionMuestra) {
        this.ubicacion = ubicacion;
        this.tipoDeLaOrg = tipoDeLaOrg;
        this.cantEmpleados = cantEmpleados;
        this.funcionalidadExternaNuevaMuestra = nuevaMuestra;
        this.funcionalidadExternaNuevaValidacion = validacionMuestra;
    }

    //

    public void setFuncionalidadExternaNuevaMuestra(FuncionalidadExterna funcionalidadExterna) {
        this.funcionalidadExternaNuevaMuestra = funcionalidadExterna;
    }

    public void setFuncionalidadExternaNuevaValidacion(FuncionalidadExterna funcionalidadExterna) {
        this.funcionalidadExternaNuevaValidacion = funcionalidadExterna;
    }

    //  Funcionalidades Externas

    public void eventoNuevaMuestra(Muestra muestra){
        funcionalidadExternaNuevaMuestra.nuevoEvento(this, zonasSubscritas, muestra);
    }

    public void eventoNuevaValidacion(Muestra muestra){
        funcionalidadExternaNuevaValidacion.nuevoEvento(this, zonasSubscritas, muestra);
    }

}
