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

    public void registrarPosteoDesdeLaApp(TipoDeVoto especieFotografiada, String fotoURL, Ubicacion ubicacion, Usuario user){
        motorDeBusqueda.nuevaMuestraEnSistema(new Muestra(especieFotografiada, fotoURL, user, ubicacion));
    }

    public void registrarOpinion(Muestra muestra, TipoDeVoto voto, Usuario user){
        muestra.registrarOpinion(new Opinion(voto, user.getName(), user.esExperto()));//se llaman igual
    }




}
