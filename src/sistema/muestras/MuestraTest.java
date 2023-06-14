package sistema.muestras;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MuestraTest {
	private Muestra muestra;
	private ITipoDeVoto2 tipo1;
	private ITipoDeVoto2 tipo2;
	private ITipoDeVoto2 tipo3;
	private IUbicacion ubicacion;
	private IUsuario usuario;
	
	
	@BeforeEach
	void setUp() {
		//Test  Instalation
		
		//clases de otro programador
		ubicacion = mock(IUbicacion.class);
		usuario = mock(IUsuario.class);
		
		//tiposDeIsectos
		tipo1 = ITipoDeVoto2.Chinche_Foliada;
		tipo2 = ITipoDeVoto2.Vinchuca_Infestans;
		tipo3 = ITipoDeVoto2.Vinchuca_Sordida;
		
		
		muestra = new Muestra(tipo1, "foto.jpg", usuario, ubicacion);
	}

	@Test
	void testMuestra() {
		assertEquals(Muestra.class, muestra.getClass());
	}

	@Test
	void testGetFotoURL() {
		muestra.getFotoURL();
		fail("Not yet implemented");
	}

	@Test
	void testGetAutor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUbicacion() {
		fail("Not yet implemented");
	}

	@Test
	void testGetManejadorVotos() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFecha() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEspecie() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTodasLasOpiniones() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUltimaVotacion() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFotoURL() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAutor() {
		fail("Not yet implemented");
	}

	@Test
	void testSetUbicacion() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFechaUltimaOpinion() {
		fail("Not yet implemented");
	}

	@Test
	void testResultadoActual() {
		fail("Not yet implemented");
	}

	@Test
	void testSetFecha() {
		fail("Not yet implemented");
	}

	@Test
	void testSetEspecie() {
		fail("Not yet implemented");
	}

}
