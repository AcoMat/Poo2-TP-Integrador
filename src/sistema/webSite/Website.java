package sistema.webSite;

import sistema.buscador.Buscador;
import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.Usuario;

public class Website {
    //registrar usuarios usar el buscador etc

    private Buscador motorDeBusqueda;

    public void registrarPosteoDesdeLaApp(Muestra muestra){
        motorDeBusqueda.nuevaMuestraEnSistema(muestra);
    }

    public void registrarOpinion(Muestra muestra, Opinion opinion){
        muestra.registrarOpinion(opinion);//se llaman igual
    }




}
