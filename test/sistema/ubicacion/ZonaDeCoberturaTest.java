package sistema.ubicacion;

import org.junit.Test;
import sistema.muestras.Muestra;
import sistema.organizaciones.Organizacion;

import static org.mockito.Mockito.*;

public class ZonaDeCoberturaTest {

    Ubicacion epicentro =  mock(Ubicacion.class);
    Muestra muestra = mock(Muestra.class);
    Ubicacion muestraUbicacion = mock(Ubicacion.class);
    ZonaDeCobertura zonaDePrueba = spy(new ZonaDeCobertura(epicentro, 15, "ZonaDePrueba"));

    @Test
    public void agregarSiEstaEnLaZonaTest(){
        when(muestra.getUbicacion()).thenReturn(muestraUbicacion);
        when(epicentro.distanciaHasta(muestraUbicacion)).thenReturn(20.0);
        zonaDePrueba.agregarSiEstaEnLaZona(muestra);
        verify(zonaDePrueba).nuevaMuestraEnLaZona(muestra);
    }

    @Test
    public void nuevaMuestraEnLaZonaTest(){

    }

    @Test
    public void nuevaValidacionEnLaZonaTest(){

    }

    @Test
    public void suscribirATest() {

    }

    @Test
    public void desuscribirATest() {

    }

    @Test
    public void seSolapaConTest(){

    }
}
