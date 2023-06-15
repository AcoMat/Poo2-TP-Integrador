package sistema.ubicacion;

import org.junit.Before;
import org.junit.Test;
import sistema.muestras.Muestra;
import sistema.organizaciones.Organizacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ZonaDeCoberturaTest {

    Ubicacion epicentroMock;
    Muestra muestraMock;
    Ubicacion ubicacionMock;
    ZonaDeCobertura zonaDePrueba;
    Organizacion orgMock;

    @Before
    public void setUp(){
        epicentroMock =  mock(Ubicacion.class);
        muestraMock = mock(Muestra.class);
        ubicacionMock = mock(Ubicacion.class);
        zonaDePrueba = spy(new ZonaDeCobertura(epicentroMock, 15.0, "ZonaDePrueba"));
        orgMock = mock(Organizacion.class);
    }

    @Test
    public void agregarSiEstaEnLaZonaTest(){
        //TODO
    }

    @Test
    public void nuevaMuestraEnLaZonaTest(){

        assertEquals(0 , zonaDePrueba.getMuestrasReportadas().size());
        zonaDePrueba.suscribirA(orgMock);
        zonaDePrueba.nuevaMuestraEnLaZona(muestraMock);
        verify(orgMock).eventoNuevaMuestra(muestraMock, zonaDePrueba);
        assertEquals(1 , zonaDePrueba.getMuestrasReportadas().size());
    }

    @Test
    public void nuevaValidacionEnLaZonaTest(){
        zonaDePrueba.suscribirA(orgMock);
        zonaDePrueba.nuevaValidacion(muestraMock);
        verify(orgMock).eventoNuevaValidacion(muestraMock, zonaDePrueba);
    }

    @Test
    public void suscribirATest() {
        assertEquals(0,zonaDePrueba.getOrganizacionesSuscritas().size());
        zonaDePrueba.suscribirA(orgMock);
        assertEquals(1,zonaDePrueba.getOrganizacionesSuscritas().size());
        assertTrue(zonaDePrueba.getOrganizacionesSuscritas().stream().anyMatch(o -> o.equals(orgMock)));
    }

    @Test
    public void desuscribirATest() {
        zonaDePrueba.suscribirA(orgMock);
        assertEquals(1,zonaDePrueba.getOrganizacionesSuscritas().size());
        zonaDePrueba.desuscribirA(orgMock);
        assertEquals(0,zonaDePrueba.getOrganizacionesSuscritas().size());
    }

    @Test
    public void seSolapaConTest(){
        ZonaDeCobertura zonaDePrueba2 = mock(ZonaDeCobertura.class);

        when(zonaDePrueba2.getEpicentro()).thenReturn(ubicacionMock);
        when(epicentroMock.distanciaHasta(ubicacionMock)).thenReturn(120.0);


        assertFalse(zonaDePrueba.seSolapaCon(zonaDePrueba2));
    }

    @Test
    public void seSolapaConTest2(){
        ZonaDeCobertura zonaDePrueba2 = mock(ZonaDeCobertura.class);

        when(zonaDePrueba2.getEpicentro()).thenReturn(ubicacionMock);
        when(epicentroMock.distanciaHasta(ubicacionMock)).thenReturn(10.0);

        assertTrue(zonaDePrueba.seSolapaCon(zonaDePrueba2));
    }
}
