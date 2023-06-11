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
	private IMuestra1 muestra1;
	private IMuestra1 muestra2;
	private IMuestra1 muestra3;
	private ITipoDeVoto1 tipo1;
	private ITipoDeVoto1  tipo2;
	private ITipoDeVoto1  tipo3;
	ArrayList<IMuestra1> iMuestra1s = new ArrayList<IMuestra1>();
	
	
	ArrayList mockList;
	
	@BeforeEach
	void setUp() {
		//Test Double Instalation
		buscador = new Buscador(iMuestra1s);
		
		//set up 
		muestra1 = mock(IMuestra1.class);
		muestra2 = mock(IMuestra1.class);
		muestra3 = mock (IMuestra1.class);
		
		//tiposDeIsectos
		tipo1 = mock(ITipoDeVoto1.class);
		tipo2 = mock(ITipoDeVoto1.class);
		tipo3 = mock(ITipoDeVoto1.class);
		
		mockList = new ArrayList<>();
		
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
		Date fecha1 = new Date();
		Date fecha2 = new Date();
		Date fecha3 = new Date();
		
		when(muestra1.getFecha()).thenReturn(fecha1);
		when(muestra2.getFecha()).thenReturn(fecha2);
		when(muestra3.getFecha()).thenReturn(fecha3);
		
		
		//Exercise
		
		//Verify
		verify(muestra1,never()).getFecha();

	}

	@Test
	void testMuestrasConInsecto() {
		//Test Double Configuration
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		
		when(mockList.get(0)).thenReturn("visitMeHere");
		
		//Exercise
		buscador.muestrasConInsecto(tipo2);
		
		
		verify(muestra3,  never()).getEspecieEstadoActual();
		
	}

	@Test
	void testNivelValidacion() {
		when(muestra3.getEstado()).thenReturn(tipo3);
		when(muestra2.getEstado()).thenReturn(tipo2);
		when(muestra1.getEstado()).thenReturn(tipo1);
		
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		
		
		buscador.
		
		verify(muestra3,  never()).getEstado();
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
