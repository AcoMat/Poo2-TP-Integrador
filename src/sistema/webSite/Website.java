package sistema.webSite;

import sistema.buscador.Buscador;
import sistema.muestras.Muestra;
import sistema.organizaciones.FuncionalidadExterna;
import sistema.organizaciones.Organizacion;
import sistema.organizaciones.TipoDeOrg;
import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class Website {
    //registrar usuarios usar el buscador etc

    private Buscador motorDeBusqueda;
    private ArrayList<Usuario> usersRegistrados;
    private ArrayList<Organizacion> organizacionsRegistradas;


    //  Metodos

    public void registrarPosteoDesdeLaApp(Muestra muestra){
        motorDeBusqueda.nuevaMuestraEnSistema(muestra);
        //notificar al observer "zonaDeCobertura"
    }

    public void registrarOpinion(Muestra muestra, Opinion opinion){
        //tengo q verificar que el usuario se registró?
        muestra.registrarOpinion(opinion);//se llaman igual
    }

    public void registrarNuevoUsuario(){
        //todo, agregar al array
    }

    public void registrarNuevaOrganizacion(Ubicacion ubicacion, TipoDeOrg tipoDeLaOrg, int cantEmpleados, FuncionalidadExterna nuevaMuestra, FuncionalidadExterna validacionMuestra){
        Organizacion nuevaOrg = new Organizacion(ubicacion, tipoDeLaOrg, cantEmpleados , nuevaMuestra, validacionMuestra);
        organizacionsRegistradas.add(nuevaOrg);
    }

    public void nuevaZonaDeCobertura(String nombre,Ubicacion epicentro, int radio){
        //TODO
    }


}
