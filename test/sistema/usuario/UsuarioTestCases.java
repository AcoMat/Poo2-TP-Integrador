package sistema.usuario;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.*;
import sistema.websiteapp.Website;
import sistema.muestras.*;


class UsuarioTestCases {

	Website web = mock(Website.class);

	Usuario usuarioLeo = new Usuario("Leo", false, web);
	Usuario usuarioDiego = new Usuario("Diego", true, web);

	@Before
	public void setUp() {

	}

	@Test
	public void testCreacionLeo() {
		assertEquals("Leo", usuarioLeo.getUserName());
		assertFalse(usuarioLeo.isConocimientoValidado());
	}

	@Test
	public void testCreacionDiego() {
		assertEquals("Diego", usuarioDiego.getUserName());
		assertTrue(usuarioDiego.isConocimientoValidado());
	}

	@Test
	public void testLeoEnviaMuestra() {
		String fotoURL = "https://estaesunaurl.com/picture1";
		Ubicacion ubicacion = new Ubicacion(0, 0);
		TipoDeVoto tipoDeVoto = TipoDeVoto.Vinchuca_Guasayana;

		Muestra muestraDeLeo = new Muestra(tipoDeVoto, fotoURL, usuarioLeo, ubicacion);
		ArrayList<Muestra> muestrasDeLeo = new ArrayList<Muestra>();
		muestrasDeLeo.add(muestraDeLeo);

		usuarioLeo.enviarMuestra(tipoDeVoto, fotoURL, ubicacion);

		assertTrue(usuarioLeo.getMuestras().contains(muestraDeLeo));
		assertEquals(usuarioLeo.getMuestras(), muestrasDeLeo);
	}
	
	@Test
	public void testDiegoO() {
		String fotoURL = "https://estaesunaurl.com/picture1";
		Ubicacion ubicacion = new Ubicacion(0, 0);
		TipoDeVoto tipoDeVoto = TipoDeVoto.Vinchuca_Guasayana;

		Muestra muestraDeLeo = new Muestra(tipoDeVoto, fotoURL, usuarioLeo, ubicacion);
		ArrayList<Muestra> muestrasDeLeo = new ArrayList<Muestra>();
		muestrasDeLeo.add(muestraDeLeo);

		usuarioLeo.enviarMuestra(tipoDeVoto, fotoURL, ubicacion);
		
		usuarioDiego.opinar(muestraDeLeo, tipoDeVoto);

//		assertTrue(usuarioDiego.getOpiniones());
	}
	
	

}

//Creación
//ClassName varName = mock(ClassName.class);
//@Mock private ClassName varName;
//Set un valor
//when(methodCall).thenReturn(value)
//.thenReturn(value, value) .thenThrow(throwableClasses)
//Verificar
//verify(mock).methodCall
//verify(mock, VerificationMode).methodCall
//verifyNoMoreInteractions(mock)
//verifyZeroInteractions(mock)
//Modos de Verificacion
//atLeastOne() atLeast( int )
//atMost( int ) times( int )
//timeout(long) never()

//Dummy: 
//Son objetos que se pasan por allí, pero nunca se utilizan realmente. 
//Por lo general, sólo son utilizadas para rellenar listas de parámetros.

//Stub:
//Proporciona respuestas preprogramadas a las llamadas realizadas durante la prueba.

//Mock:
//Es un Stub con la capacidad de poder verificarse.

// Spy
// Es un Mock pero que llama realmente a los métodos del objeto real.