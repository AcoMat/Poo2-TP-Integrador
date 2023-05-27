package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;

public class Validada extends Validacion{

    Validada(ManejadorDeVotos h){
        super(h);
    }

    @Override
    protected void registrarOpinion(Opinion o) {
        System.out.println("esta muestra ya esta validada, no se puede votar");
    }


}
