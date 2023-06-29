package sistema.sistemaDeVotos.validacion;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;

class VotanTodosTest {
	private TipoDeVoto tipo = TipoDeVoto.Chinche_Foliada;
	private EstadoValidacion estado = new VotanTodos();
	private ManejadorDeVotos manejador = mock(ManejadorDeVotos.class);
	Opinion opinion= mock(Opinion.class);
	private ArrayList<Opinion> opinionesExpertas = new ArrayList<Opinion>();

	@Test
	void testPermiteVotoBasico() {
		assertTrue(estado.permiteVotoBasico());
	}

	@Test
	void testPermiteVotoExperto() {
		assertTrue(estado.permiteVotoExperto());
	}

	@Test
	void testCambioDeEstado() {
		when(manejador.getOpinionesExpertas()).thenReturn(opinionesExpertas);
		estado.cambioDeEstado(manejador, opinion);
		
		verify(manejador).getOpinionesExpertas();
	}

	@Test
	void testResultadoActual() {
		assertNull(estado.resultadoActual(manejador));
	}

}
