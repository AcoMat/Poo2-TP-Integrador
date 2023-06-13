package sistema.website;

import org.junit.Test;
import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;
import sistema.webSite.Website;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WebsiteTest {
    Website web = new Website();
    Muestra mockMuestra = mock(Muestra.class);

    @Test
    public void registrarNuevaMuestraTest(){

    }

    @Test
    public void registrarValidacion(Muestra muestra){

    }

    public void nuevaZonaDeCobertura(String nombre, Ubicacion epicentro, int radio){

    }

}
