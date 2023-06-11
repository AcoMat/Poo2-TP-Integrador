package sistema.buscador;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;

class TestBuscador {
	private Buscador buscador; 
	private IMuestra1 muestra1;
	private IMuestra1 muestra2;
	private IMuestra1 muestra3;
	private ITipoDeVoto tipo1;
	private ITipoDeVoto  tipo2;
	private ITipoDeVoto  tipo3;
	ArrayList<IMuestra1> iMuestra1s = new ArrayList<IMuestra1>();
	
	@BeforeEach
	void buscadorIncializado() {
		//Test Double Instalation
		buscador = new Buscador(iMuestra1s);
		
		//set up 
		muestra1 = mock(IMuestra1.class);
		muestra2 = mock(IMuestra1.class);
		muestra3 = mock (IMuestra1.class);
		
		//tiposDeIsectos
		tipo1 = mock(ITipoDeVoto.class);
		tipo2 = mock(ITipoDeVoto.class);
		tipo3 = mock(ITipoDeVoto.class);
		
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
