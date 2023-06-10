package sistema.buscador;

import sistema.muestras.Muestra;

import java.util.ArrayList;

public class BuscadorV2 {
    private ArrayList<Muestra> muestrasEnSistema = new ArrayList<Muestra>();

    public void registrarNuevaMuestra(Muestra muestra){
        this.muestrasEnSistema.add(muestra);
    }




}
