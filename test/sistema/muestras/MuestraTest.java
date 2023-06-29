package sistema.muestras;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.sistemaDeVotos.ManejadorDeVotos;
import sistema.sistemaDeVotos.Opinion;
import sistema.sistemaDeVotos.TipoDeVoto;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;



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
	void testGetEspecie() {
		assertEquals(TipoDeVoto.Chinche_Foliada,muestra.getEspecie());
	}
	
	@Test
	void testGetFecha() {
		Date nuevaFecha = new Date();
		muestra.setFecha(nuevaFecha);
		assertEquals(muestra.getFecha(),nuevaFecha);
	}
	
	@Test
	void testGetFechaUltimaVotacion() {
		Date nuevaFecha = new Date();
		when(nuevoManejador.getFechaUltimaVotación()).thenReturn(nuevaFecha);
		muestra.setManejadorVotos(nuevoManejador);
		
		muestra.getFechaUltimaVotacion();
		
		verify(nuevoManejador).getFechaUltimaVotación();
	}
	
	@Test
	void testGetResultadoActual() {
		when(nuevoManejador.resultadoDeVotacion()).thenReturn(tipo2);
		muestra.setManejadorVotos(nuevoManejador);
		
		muestra.resultadoActual();
		
		verify(nuevoManejador).resultadoDeVotacion();
	}



}
