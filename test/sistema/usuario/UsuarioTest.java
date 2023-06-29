package sistema.usuario;

import org.junit.Before;
import org.junit.Test;

import sistema.buscadorV3.BuscadorVotadasDespuesDe;
import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.nivelDeUsuarios.Nivel;
import sistema.websiteapp.Website;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UsuarioTest {

    Website web;
    Muestra muestraMock;
    Opinion opinion;

    Ubicacion ubicacionMock;
    TipoDeVoto tipoDeVotoMock;
    ManejadorDeVotos manejadorDeVotosMock;
    Nivel nivelMock;

    Usuario userLeo;
    Usuario userDiego;


    @Before
    public void before() {
        web = mock(Website.class);
        muestraMock = mock(Muestra.class);
        opinion = mock(Opinion.class);

        ubicacionMock = mock(Ubicacion.class);
        tipoDeVotoMock = mock(TipoDeVoto.class);

        nivelMock = mock(Nivel.class);

        userLeo = spy(new Usuario("Leo", false, web));
        userDiego = new Usuario("Diego", true, web);
    }


    @Test
    public void testCreacionLeoYDiego() {

        assertEquals("Leo", userLeo.getUserName());
        assertFalse(userLeo.isConocimientoValidado());

        assertEquals("Diego", userDiego.getUserName());
        assertTrue(userDiego.isConocimientoValidado());
    }

    @Test
    public void guardarMuestraTest() {
        userLeo.guardarMuestra(muestraMock);
        assertEquals(1, userLeo.getMuestras().size());
        verify(web).registrarNuevaMuestra(muestraMock);
    }


    @Test
    public void enviarMuestraTest() {
        when(userLeo.getNivel()).thenReturn(nivelMock);
        doNothing().when(nivelMock).enviarMuestra(userLeo,tipoDeVotoMock, "url", ubicacionMock);

        userLeo.enviarMuestra(tipoDeVotoMock, "url", ubicacionMock);

        verify(nivelMock).enviarMuestra(userLeo,tipoDeVotoMock, "url", ubicacionMock);
    }

    @Test
    public void opinarTest() {
        manejadorDeVotosMock = mock(ManejadorDeVotos.class);
        when(muestraMock.getManejadorVotos()).thenReturn(manejadorDeVotosMock);
        when(userLeo.getNivel()).thenReturn(nivelMock);
        when(userLeo.isConocimientoValidado()).thenReturn(false);
        userLeo.opinar(muestraMock, tipoDeVotoMock);

        verify(userLeo).setNivel();
        verify(nivelMock).opinar(userLeo, muestraMock, tipoDeVotoMock);

    }
    
    @Test
    public void testDondeEstaRegistrado() {
    	assertEquals(userDiego.dondeEstaRegistrado(), web);

    }
    
    @Test
    public void testGuardarOpinion() {
    	userDiego.guardarOpinion(muestraMock, opinion);
    	
    	assertEquals(userDiego.getOpiniones().size(), 1);

    }
}
