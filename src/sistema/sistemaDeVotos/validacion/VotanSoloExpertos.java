package sistema.sistemaDeVotos.validacion;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;

public class NoValidadaExpertos extends Validacion{

    public NoValidadaExpertos(ManejadorDeVotos h){
        super(h);
    }

    @Override
    public void registrarOpinion(Opinion o){
        if (o.getEsExperto()){
            handlerAsoc.agregarOpinion(o);
        }else{
            System.out.println("Solo pueden votar expertos!");
        }
    }
}
