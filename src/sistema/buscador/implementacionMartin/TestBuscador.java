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
	
	@BeforeEach
	void buscadorIncializado() {
		//Test Double Instalation
		buscador = new Buscador(iMuestra1s);
		
		//set up 
		muestra1 = spy(IMuestra1.class);
		muestra2 = spy(IMuestra1.class);
		muestra3 = spy (IMuestra1.class);
		
		//tiposDeIsectos
		tipo1 = spy(ITipoDeVoto1.class);
		tipo2 = spy(ITipoDeVoto1.class);
		tipo3 = spy(ITipoDeVoto1.class);
		
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
	 
		
		buscador.atacar(muestra3);
		
		//Verify
		verify(muestra3).getFecha();

	}

	@Test
	void testMuestrasConInsecto() {
		//Test Double Configuration
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		
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
