package sistema.ubicacion;

import org.junit.Before;
import org.junit.Test;
import sistema.muestras.Muestra;
import sistema.organizaciones.Organizacion;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ZonaDeCoberturaTest {

    Ubicacion epicentro;
    Muestra muestra;
    Ubicacion muestraUbicacion;
    ZonaDeCobertura zonaDePrueba;
    Organizacion orgPrueba;

    @Before
    public void setUp(){
        epicentro =  mock(Ubicacion.class);
        muestra = mock(Muestra.class);
        muestraUbicacion = mock(Ubicacion.class);
        zonaDePrueba = spy(new ZonaDeCobertura(epicentro, 15, "ZonaDePrueba"));
        orgPrueba = mock(Organizacion.class);
    }

    @Test
    public void agregarSiEstaEnLaZonaTest(){
        when(muestra.getUbicacion()).thenReturn(muestraUbicacion);
        when(epicentro.distanciaHasta(muestraUbicacion)).thenReturn(20.0);
        zonaDePrueba.agregarSiEstaEnLaZona(muestra);
        verify(zonaDePrueba, times(1)).nuevaMuestraEnLaZona(muestra);
        //Todo
    }

    @Test
    public void nuevaMuestraEnLaZonaTest(){

        assertEquals(0 , zonaDePrueba.getMuestrasReportadas().size());
        zonaDePrueba.suscribirA(orgPrueba);
        zonaDePrueba.nuevaMuestraEnLaZona(muestra);
        verify(orgPrueba).eventoNuevaMuestra();
        assertEquals(1 , zonaDePrueba.getMuestrasReportadas().size());
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
