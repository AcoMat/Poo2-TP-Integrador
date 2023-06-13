package sistema.buscador.implementacionMartin;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.mockito.internal.stubbing.answers.ThrowsExceptionForClassType;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

class TestBuscador {
	private Buscador buscador; 
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private TipoDeVoto tipo1;
	private TipoDeVoto  tipo2;
	private TipoDeVoto  tipo3;
	
	ArrayList<Muestra> muestras = new ArrayList<Muestra>();
	ArrayList<Muestra> filtro =new ArrayList<Muestra>();

	@BeforeEach
	void setUp() {

		//Test Double Instalation
		buscador = new Buscador(muestras);
		
		//set up 
		muestra1 = new Muestra(tipo1, null, null, null);
		muestra2 = new Muestra(tipo2, null, null, null);
		muestra3 = new Muestra(tipo3, null, null, null);
		
		//tiposDeIsectos
		tipo1 = TipoDeVoto.Vinchuca_Infestans;
		tipo2 =TipoDeVoto.Vinchuca_Guasayana;
		tipo3 =TipoDeVoto.Imagen_poco_clara;
		
		
	}
	
	@Test
	void testObject() {
		//testeo el constructor
		assertEquals(Buscador.class, buscador);
	}


	@Test
	void testNuevaMuestraEnSistema() {
		//Test Double Configuration
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		
		//Exercise
		int tamaño = buscador.getMuestrasTotalesDelSys().size();
		
		//Verify
		assertEquals(tamaño, 3);
	}

	@Test
	void testMuestraCreadaEnLaFecha() {
		//Test Double Configuration
		Date fecha1 = new Date();
		Date fecha2 = new Date();
		Date fecha3 = new Date();
		
		when(muestra1.getFecha()).thenReturn(fecha1);
		when(muestra2.getFecha()).thenReturn(fecha2);
		when(muestra3.getFecha()).thenReturn(fecha3);
		
		
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		
		//Exercise
		/*
		 * hago un filtro que es basicamente lo que hago en el metodo pero acá no
		 * transformo el array en un stream porque no funciona con el mock.
		 */
		for (IMuestra1 m:muestras) {
			if ( m.getFecha()== fecha3) {
				filtro.add(m);
			}
		}
		
		//Verify
		verify(muestra1).getFecha();
		verify(muestra2).getFecha();
		verify(muestra3).getFecha();

	}

	@Test
	void testMuestrasConInsecto() {
		//Test Double Configuration
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		
		
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		//Exercise
		/*
		 * hago un filtro que es basicamente lo que hago en el metodo pero acá no
		 * transformo el array en un stream porque no funciona con el mock.
		 */
		for (IMuestra1 m:muestras) {
			if ( m.getEspecieEstadoActual()== tipo2) {
				filtro.add(m);
			}
		}
		
		verify(muestra1).getEspecieEstadoActual();
		verify(muestra2).getEspecieEstadoActual();
		verify(muestra3).getEspecieEstadoActual();
		
	}

	@Test
	void testNivelValidacion() {
		//Test Double Configuration
		when(muestra3.getEstado()).thenReturn(tipo3);
		when(muestra2.getEstado()).thenReturn(tipo2);
		when(muestra1.getEstado()).thenReturn(tipo1);
		
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		//Exercise
		/*
		* hago un filtro que es basicamente lo que hago en el metodo pero acá no
		* transformo el array en un stream porque no funciona con el mock.
		*/
		for (IMuestra1 m:muestras) {
			if ( m.getEstado()== tipo1) {
				filtro.add(m);
			}
		}
		
		verify(muestra1).getEstado();
		verify(muestra2).getEstado();
		verify(muestra3).getEstado();
	}

	@Test
	void testBuscadorGeneral() {
		Date fecha1 = new Date();
		Date fecha2 = new Date();
		Date fecha3 = new Date();
		
		when(muestra1.getFecha()).thenReturn(fecha1);
		when(muestra2.getFecha()).thenReturn(fecha2);
		when(muestra3.getFecha()).thenReturn(fecha3);
		
		when(muestra3.getEstado()).thenReturn(tipo3);
		when(muestra2.getEstado()).thenReturn(tipo2);
		when(muestra1.getEstado()).thenReturn(tipo1);
		
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		
		
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		//Exercise
		/*
		* hago un filtro que es basicamente lo que hago en el metodo pero acá no
		* transformo el array en un stream porque no funciona con el mock.
		*/
		for (IMuestra1 m:muestras) {
			if ( m.getEstado()== tipo1 && m.getFecha() == fecha3 && m.getEspecieEstadoActual()==  tipo3) {
				filtro.add(m);
			}
		}
		verify(muestra2).getEspecieEstadoActual();
		
	}

	@Test
	void testBuscador() {
		fail("Not yet implemented");
	}


}
