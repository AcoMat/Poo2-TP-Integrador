package sistema.sistemaDeVotos;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManejadorDeVotosTest {

    ManejadorDeVotos mv = new ManejadorDeVotos();
    Opinion opinionMock;

    @BeforeEach
    public void setUp(){
        opinionMock = mock(Opinion.class);
    }


    @Test
    void getTodasLasOpinionesTest1() {
        mv.agregarOpinionBasica(opinionMock);
        mv.agregarOpinionBasica(opinionMock);

        mv.agregarOpinionExperta(opinionMock);
        mv.agregarOpinionExperta(opinionMock);

        assertFalse(mv.getTodasLasOpiniones().size() == 0);
        assertFalse(mv.getTodasLasOpiniones().size() == 5);
        assertEquals(4, mv.getTodasLasOpiniones().size());
    }

    @Test
    void getTodasLasOpinionesTest2() {
        mv.agregarOpinionBasica(opinionMock);
        mv.agregarOpinionBasica(opinionMock);

        mv.agregarOpinionExperta(opinionMock);
        mv.agregarOpinionExperta(opinionMock);

        mv.agregarOpinionBasica(opinionMock);

        assertFalse(mv.getTodasLasOpiniones().size() == 0);
        assertFalse(mv.getTodasLasOpiniones().size() == 5);
        assertEquals(4, mv.getTodasLasOpiniones().size());
    }

    @Test
    void agregarOpinionBasicaTest() {
        Date fecha = new Date();
        when(opinionMock.getFecha()).thenReturn(fecha);

        mv.agregarOpinionBasica(opinionMock);

        assertEquals(fecha, mv.getFechaUltimaVotación());
        assertEquals(1,mv.getOpinionesBasicas().size());
        assertEquals(0,mv.getOpinionesExpertas().size());
    }

    @Test
    void agregarOpinionExpertaTest() {
        Date fecha = new Date();
        when(opinionMock.getFecha()).thenReturn(fecha);

        mv.agregarOpinionExperta(opinionMock);

        assertEquals(fecha, mv.getFechaUltimaVotación());
        assertEquals(0,mv.getOpinionesBasicas().size());
        assertEquals(1,mv.getOpinionesExpertas().size());
    }


    @Test
    void getFechaUltimaVotaciónTest() {
        Date fecha = new Date();
        when(opinionMock.getFecha()).thenReturn(fecha);

        mv.agregarOpinionBasica(opinionMock);

        assertEquals(fecha, mv.getFechaUltimaVotación());
    }

}
