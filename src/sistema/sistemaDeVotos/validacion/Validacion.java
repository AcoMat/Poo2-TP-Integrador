package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.Opinion;
import sistema.usuario.Usuario;

public abstract class Validacion {
    Usuario user;

    Validacion (Usuario user){
        this.user = user;
    }

    protected abstract void registrarOpinion(Opinion o);

}
