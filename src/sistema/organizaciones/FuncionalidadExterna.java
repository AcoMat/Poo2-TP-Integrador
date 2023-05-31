package sistema.organizaciones;

import sistema.muestras.Muestra;
import sistema.ubicacion.ZonaDeCobertura;

public interface FuncionalidadExterna {
    public void nuevoEvento(Organizacion org, ZonaDeCobertura zona, Muestra muestra);
}
