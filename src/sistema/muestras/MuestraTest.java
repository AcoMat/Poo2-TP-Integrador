package sistema.muestras;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;



class MuestraTest {
	private Muestra muestra;
	private ITipoDeVoto2 tipo1;
	private ITipoDeVoto2 tipo2;
	private ITipoDeVoto2 tipo3;
	private IUbicacion ubicacion;
	private IUbicacion ubicacion2;
	private IUsuario usuario;
	private IUsuario usuario2;
	private IManejadorDeVotos1 nuevoManejador;
	
	
	@BeforeEach
	void setUp() {
		//Test  Instalation
		
		//clases de otro programador
		ubicacion = mock(IUbicacion.class);
		ubicacion2 = mock( IUbicacion.class);
		usuario = mock(IUsuario.class);
		usuario2 = mock(IUsuario.class);
		nuevoManejador = mock(IManejadorDeVotos1.class);
		
		//tiposDeIsectos
		tipo1 = ITipoDeVoto2.Chinche_Foliada;
		tipo2 = ITipoDeVoto2.Vinchuca_Infestans;
		tipo3 = ITipoDeVoto2.Vinchuca_Sordida;
		
		//mi clase a testear
		muestra = new Muestra(tipo1, "foto.jpg", usuario, ubicacion);
	}

	@Test
	void testMuestra() {
		assertEquals(Muestra.class, muestra.getClass());
	}

	@Test
	void testGetFotoURL() {
		assertEquals("foto.jpg",muestra.getFotoURL());
	}

	@Test
	void testGetAutor() {
		assertEquals(usuario,muestra.getAutor());
	}

	@Test
	void testGetUbicacion() {
		assertEquals(ubicacion,muestra.getUbicacion());
	}

	@Test
	void testGetManejadorVotos() {
		assertEquals(ubicacion,muestra.getUbicacion());
	}

	@Test
	void testGetFecha() {
		Date fecha1 = new Date();
		
		muestra.setFecha(fecha1);
		
		assertEquals(fecha1,muestra.getFecha());
	} 

	@Test
	void testGetEspecie() {
		assertEquals(ITipoDeVoto2.Chinche_Foliada,muestra.getEspecie());
	}

	@Test
	void testGetTodasLasOpiniones() {
		fail("Not yet implemented");
	}
 
	@Test
	void testGetUltimaVotacion() {
		Date fecha1 = new Date();
		when(nuevoManejador.getFechaUltimaVotación()).thenReturn(fecha1);
		
		muestra.setManejadorDeVotos(nuevoManejador);
		
		muestra.getUltimaVotacion();
		
		verify(nuevoManejador).getFechaUltimaVotación();
	}

	@Test
	void testSetFotoURL() {
		muestra.setFotoURL("nuevaFoto.jpg");
		assertEquals("nuevaFoto.jpg",muestra.getFotoURL());
	}

	@Test
	void testSetAutor() {
		muestra.setAutor(usuario2);
		assertEquals(usuario2,muestra.getAutor());
	}

	@Test
	void testSetUbicacion() {
		muestra.setUbicacion(ubicacion2);
		assertEquals(ubicacion2,muestra.getUbicacion());
	}

	@Test
	void testSetManejadorDeVotos() {
		muestra.setManejadorDeVotos(nuevoManejador);
		assertEquals(nuevoManejador,muestra.getManejadorVotos());
	}

	@Test
	void testResultadoActual() {
		when(nuevoManejador.resultadoDeVotacion()).thenReturn(tipo3);
		
		muestra.setManejadorDeVotos(nuevoManejador);
		
		muestra.resultadoActual();
		
		verify(nuevoManejador).resultadoDeVotacion();
	}

	
	@Test
	void testSetFecha() {
		Date nuevaFecha = new Date();
		muestra.setFecha(nuevaFecha);
		assertEquals(nuevaFecha,muestra.getFecha());
	}

	@Test
	void testSetEspecie() {
		muestra.setEspecie(tipo2);
		assertEquals(tipo2,muestra.getEspecie());
	}

}
