package sistema.sistemaDeVotos.validacion;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.TipoDeVoto;

class ValidadaTest {
	private TipoDeVoto tipo = TipoDeVoto.Chinche_Foliada;
	private EstadoValidacion validada = new Validada(tipo);
	private ManejadorDeVotos manejador = new ManejadorDeVotos();

	@Test
	void testPermiteVotoBasico() {
		assertFalse(validada.permiteVotoBasico());
	}

	@Test
	void testPermiteVotoExperto() {
		assertFalse(validada.permiteVotoExperto());
	}

	@Test
	void testResultadoActual() {
		assertEquals(validada.resultadoActual(manejador),tipo);
	}

	@Test
	void testValidada() {
		assertEquals(validada.getClass(),Validada.class);
	}

}
