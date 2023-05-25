package sistema.webSite;

import sistema.buscador.Buscador;
import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.SistemaDeVotos;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class Website {
    //registrar usuarios usar el buscador etc

    private Buscador motorDeBusqueda;
    private SistemaDeVotos sistemaDeVotos;


    public void registrarPosteoDesdeLaApp(TipoDeVoto especieFotografiada, String fotoURL, Ubicacion ubicacion, Usuario user){
        motorDeBusqueda.nuevaMuestraEnSistema(new Muestra(especieFotografiada, fotoURL, user, ubicacion));
    }

    public void registrarOpinion(Muestra muestra, TipoDeVoto voto, Usuario user){
        sistemaDeVotos.
    }




}
