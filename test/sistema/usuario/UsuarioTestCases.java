package sistema.usuario;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.*;
import sistema.muestras.*;

class UsuarioTestCases {

	Usuario usuarioLeo = new Usuario("Leo", false);
	Usuario usuarioDiego = new Usuario("Diego", true);

	@BeforeEach
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
		Ubicacion ubicacion = new Ubicacion();
		TipoDeVoto tipoDeVoto = TipoDeVoto.Vinchuca_Guasayana;

		Muestra muestraDeLeo = new Muestra(tipoDeVoto, fotoURL, usuarioLeo, ubicacion);
		ArrayList<Muestra> muestrasDeLeo = new ArrayList<Muestra>();
		muestrasDeLeo.add(muestraDeLeo);

		usuarioLeo.enviarMuestra(tipoDeVoto, fotoURL, ubicacion);

//		assertTrue(usuarioLeo.getMuestras().contains(muestraDeLeo));
//		assertEquals(usuarioLeo.getMuestras(), muestrasDeLeo);
	}
	
	@Test
	public void testDiegoO() {
		String fotoURL = "https://estaesunaurl.com/picture1";
		Ubicacion ubicacion = new Ubicacion();
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