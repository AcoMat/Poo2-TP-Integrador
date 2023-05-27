package sistema.sistemaDeVotos.validacion;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.usuario.Usuario;

public abstract class Validacion {
    ManejadorDeVotos handlerAsoc;

    public Validacion (ManejadorDeVotos h){
        this.handlerAsoc = h;
    }

    protected abstract void registrarOpinion(Opinion o);

}
