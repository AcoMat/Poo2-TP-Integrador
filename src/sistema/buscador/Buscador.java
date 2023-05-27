package sistema.buscador;

import sistema.muestras.Muestra;

import java.util.ArrayList;

public class Buscador {
    //Proposito: se encarga de guardar todas las muestras para su posterior busqueda

    private ArrayList<Muestra> muestasTotalesDelSys;

    public void nuevaMuestraEnSistema(Muestra m){
        muestasTotalesDelSys.add(m);
    }
}
