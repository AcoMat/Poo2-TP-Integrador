package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.usuario.Usuario;

public class NoValidada extends Validacion {

    public NoValidada(ManejadorDeVotos h) {
        super(h);
    }

    @Override
    protected void registrarOpinion(Opinion o) {
        if (o.getEsExperto()){
            Validacion soloExpertos = new NoValidadaExpertos(handlerAsoc);
            handlerAsoc.agregarOpinion(o);
            handlerAsoc.setState(soloExpertos);
        }else{
            handlerAsoc.agregarOpinion(o);
        }
    }
}
