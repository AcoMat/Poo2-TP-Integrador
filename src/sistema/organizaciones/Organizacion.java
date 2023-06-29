package sistema.organizaciones;

import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

public class Organizacion {
    private Ubicacion ubicacion;
    private TipoDeOrg tipoDeLaOrg;
    private int cantEmpleados;
    //
    private FuncionalidadExterna funcionalidadExternaNuevaMuestra;
    private FuncionalidadExterna funcionalidadExternaNuevaValidacion;
    //

    //  Constructor

    public Organizacion(Ubicacion ubicacion, TipoDeOrg tipoDeLaOrg, int cantEmpleados, FuncionalidadExterna nuevaMuestra, FuncionalidadExterna validacionMuestra) {
        this.ubicacion = ubicacion;
        this.tipoDeLaOrg = tipoDeLaOrg;
        this.cantEmpleados = cantEmpleados;
        this.funcionalidadExternaNuevaMuestra = nuevaMuestra;
        this.funcionalidadExternaNuevaValidacion = validacionMuestra;
    }


    public void suscribirseAZona(ZonaDeCobertura zona){
        zona.suscribirA(this);
    }

    public void deSuscribirseDe(ZonaDeCobertura zona){
        zona.desuscribirA(this);
    }


    //
    

    public void setFuncionalidadExternaNuevaMuestra(FuncionalidadExterna funcionalidadExterna) {
        this.funcionalidadExternaNuevaMuestra = funcionalidadExterna;
    }

    public FuncionalidadExterna getFuncionalidadExternaNuevaMuestra() {
		return funcionalidadExternaNuevaMuestra;
	}


	public FuncionalidadExterna getFuncionalidadExternaNuevaValidacion() {
		return funcionalidadExternaNuevaValidacion;
	}


	public void setFuncionalidadExternaNuevaValidacion(FuncionalidadExterna funcionalidadExterna) {
        this.funcionalidadExternaNuevaValidacion = funcionalidadExterna;
    }

    //  Funcionalidades Externas

    public void eventoNuevaMuestra(Muestra muestra, ZonaDeCobertura zona){
        funcionalidadExternaNuevaMuestra.nuevoEvento(this, zona, muestra);
    }

    public void eventoNuevaValidacion(Muestra muestra, ZonaDeCobertura zona){
        funcionalidadExternaNuevaValidacion.nuevoEvento(this, zona, muestra);
    }
}