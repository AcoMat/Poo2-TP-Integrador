package sistema.website;

import org.junit.Test;
import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;
import sistema.websiteapp.Website;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WebsiteTest {
    Website web = spy(new Website());
    Muestra mockMuestra = mock(Muestra.class);
    Ubicacion ubiMock = mock(Ubicacion.class);
    ZonaDeCobertura zc = mock(ZonaDeCobertura.class);

    @Test
    public void registrarNuevaMuestraTest(){
        web.nuevaZonaDeCobertura(zc);

        web.registrarNuevaMuestra(mockMuestra);

        verify(zc).agregarSiEstaEnLaZona(mockMuestra);
    }

    @Test
    public void registrarValidacionTest(){
        web.nuevaZonaDeCobertura(zc);

        web.registrarValidacion(mockMuestra);

        verify(zc).nuevaValidacion(mockMuestra);
    }

    @Test
    public void nuevaZonaDeCoberturaTest(){
        assertEquals(0, web.getZonasDeCoberturas().size());

        web.nuevaZonaDeCobertura("zonaA",ubiMock, 100);

        assertEquals(1, web.getZonasDeCoberturas().size());
    }

    @Test
    public void todasLasMuestrasTest(){
        assertEquals(0,web.todasLasMuestras().size());

        web.registrarNuevaMuestra(mockMuestra);

        assertEquals(1,web.todasLasMuestras().size());

    }

}
