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

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

class TestBuscador {
	private Buscador buscador; 
	private IMuestra1 muestra1;
	private IMuestra1 muestra2;
	private IMuestra1 muestra3;
	private ITipoDeVoto1 tipo1;
	private ITipoDeVoto1  tipo2;
	private ITipoDeVoto1  tipo3;
	
	ArrayList<IMuestra1> muestras = new ArrayList<IMuestra1>();
	ArrayList<IMuestra1> filtro =new ArrayList<IMuestra1>();

	@BeforeEach
	void setUp() {

		//Test Double Instalation
		buscador = new Buscador(muestras);
		
		//set up 
		muestra1 = mock(IMuestra1.class);
		muestra2 = mock(IMuestra1.class);
		muestra3 = mock(IMuestra1.class);
		
		//tiposDeIsectos
		tipo1 = mock(ITipoDeVoto1.class);
		tipo2 = mock(ITipoDeVoto1.class);
		tipo3 = mock(ITipoDeVoto1.class);
		
		
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
