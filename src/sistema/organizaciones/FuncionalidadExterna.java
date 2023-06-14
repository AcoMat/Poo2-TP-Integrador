package sistema.organizaciones;

import sistema.muestras.Muestra;
import sistema.ubicacion.ZonaDeCobertura;

import java.util.ArrayList;

public interface FuncionalidadExterna {
    public void nuevoEvento(Organizacion org, ArrayList<ZonaDeCobertura> zonas, Muestra muestra);
}
