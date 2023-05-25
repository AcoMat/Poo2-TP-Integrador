package sistema.buscador;

import sistema.muestras.Muestra;

import java.util.ArrayList;

public class Buscador {
    private ArrayList<Muestra> muestasTotalesDelSys;

    public void nuevaMuestraEnSistema(Muestra m){
        muestasTotalesDelSys.add(m);
    }
}
