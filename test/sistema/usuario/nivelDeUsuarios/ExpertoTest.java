package sistema.usuario.nivelDeUsuarios;

import org.junit.jupiter.api.Test;
import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.usuario.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ExpertoTest {

    Experto nivelE = new Experto();

    Usuario userMock;
    Muestra muestraMock;
    TipoDeVoto tipoDeVotoMock;
    ManejadorDeVotos manejadorDeVotosMock;

    @Test
    public void opinarTest() {
        manejadorDeVotosMock = mock(ManejadorDeVotos.class);
        userMock = mock(Usuario.class);
        muestraMock = mock(Muestra.class);
        tipoDeVotoMock = mock(TipoDeVoto.class);

        when(muestraMock.getManejadorVotos()).thenReturn(manejadorDeVotosMock);

        nivelE.opinar(userMock, muestraMock, tipoDeVotoMock);

        verify(manejadorDeVotosMock).agregarOpinionExperta(any(Opinion.class));
        verify(manejadorDeVotosMock, never()).agregarOpinionBasica(any(Opinion.class));
        verify(userMock).guardarOpinion(eq(muestraMock), any(Opinion.class));
    }

    @Test
    public void esExpertoTest() {
        assertTrue(nivelE.esExperto());
    }
}