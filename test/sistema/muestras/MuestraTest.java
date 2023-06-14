package sistema.muestras;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;
import java.util.Date;



class MuestraTest {
	private Muestra muestra;
	private TipoDeVoto tipo1;
	private TipoDeVoto tipo2;
	private TipoDeVoto tipo3;
	private Ubicacion ubicacion;
	private Ubicacion ubicacion2;
	private Usuario usuario;
	private Usuario usuario2;
	private ManejadorDeVotos nuevoManejador;
	private ArrayList<Opinion> opiniones;
	
	@BeforeEach
	void setUp() {
		//Test  Instalation
		
		//clases de otro programador
		ubicacion = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		usuario = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		nuevoManejador = mock(ManejadorDeVotos.class);
		
		//tiposDeIsectos
		tipo1 = TipoDeVoto.Chinche_Foliada;
		tipo2 = TipoDeVoto.Vinchuca_Infestans;
		tipo3 = TipoDeVoto.Vinchuca_Sordida;
		
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
		when(nuevoManejador.getTodasLasOpiniones()).thenReturn(opiniones);
		
		muestra.setManejadorDeVotos(nuevoManejador);
		
		muestra.getTodasLasOpiniones();
		
		verify(nuevoManejador).getTodasLasOpiniones();
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
