package sistema.webSite;

import sistema.buscador.BuscadorV2;
import sistema.buscador.implementacionMartin.Buscador;
import sistema.muestras.Muestra;
import sistema.organizaciones.FuncionalidadExterna;
import sistema.organizaciones.Organizacion;
import sistema.organizaciones.TipoDeOrg;
import sistema.sistemaDeVotos.Opinion;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class Website {
    //registrar usuarios usar el buscador etc

    private BuscadorV2 motorDeBusqueda= new BuscadorV2();
    private ArrayList<Organizacion> organizacionsRegistradas;
    private ArrayList<ZonaDeCobertura> zonasDeCoberturas = new ArrayList<ZonaDeCobertura>();


    //  Metodos

    public void registrarNuevoUsuario(String name, boolean esExpertoValidado){
        new Usuario(name, esExpertoValidado, this);
    }

    public void registrarNuevaMuestra(Muestra muestra){
        motorDeBusqueda.registrarNuevaMuestra(muestra);

    }

    public void registrarOpinion(Muestra muestra, Opinion opinion){
        muestra.registrarOpinion(opinion);
    }

    public void registrarNuevaOrganizacion(Ubicacion ubicacion, TipoDeOrg tipoDeLaOrg, int cantEmpleados, FuncionalidadExterna nuevaMuestra, FuncionalidadExterna validacionMuestra){
        Organizacion nuevaOrg = new Organizacion(ubicacion, tipoDeLaOrg, cantEmpleados , nuevaMuestra, validacionMuestra);
        organizacionsRegistradas.add(nuevaOrg);
    }

    public void nuevaZonaDeCobertura(String nombre,Ubicacion epicentro, int radio){
        //TODO
    }


}
