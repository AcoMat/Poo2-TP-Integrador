package sistema.buscador.implementacionMartin;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;

class TestBuscador {
	private Buscador buscador; 
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private TipoDeVoto tipo1;
	private TipoDeVoto  tipo2;
	private TipoDeVoto  tipo3;
	ArrayList<Muestra> muestras = new ArrayList<Muestra>();
	
	@BeforeEach
	void buscadorIncializado() {
		//Test Double Instalation
		buscador = new Buscador(muestras);
		
		//set up 
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock (Muestra.class);
		
		//tiposDeIsectos
		tipo1 = mock(TipoDeVoto.class);
		tipo2 = mock(TipoDeVoto.class);
		tipo3 = mock(TipoDeVoto.class);
		
	}
	
	@Test
	void testObject() {
		//testeo el constructor
		assertInstanceOf(Buscador.class, buscador);
	}
	

	@Test
	void testNuevaMuestraEnSistema() {
		//Test Double Configuration
		
		//Exercise
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		
		int tamaño = buscador.getMuestrasTotalesDelSys().size();
		
		//Verify
		assertEquals(tamaño, 3);
	}

	@Test
	void testMuestraCreadaEnLaFecha() {
		//Test Double Configuration
		Date fechaActual = new Date();
		when(muestra3.getFecha()).thenReturn(fechaActual);
		
		//Exercise
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
	 
		
		buscador.muestraCreadaEnLaFecha(fechaActual);
		
		//Verify
		verify(muestra3, times(1)).getFecha();
	}

	@Test
	void testMuestrasConInsecto() {
		//Test Double Configuration
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		
		
		//Exercise
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		
		
	}

	@Test
	void testNivelValidacion() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscadorGeneral() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscador() {
		fail("Not yet implemented");
	}


}
