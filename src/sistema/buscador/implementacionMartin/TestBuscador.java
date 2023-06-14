package sistema.buscador.implementacionMartin;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class TestBuscador {
	private Buscador buscador; 
	private IMuestra1 muestra1;
	private IMuestra1 muestra2;
	private IMuestra1 muestra3;

	private ITipoDeVoto1 tipo1;
	private ITipoDeVoto1  tipo2;
	private ITipoDeVoto1  tipo3;
	
	List<IMuestra1> muestras=new ArrayList<IMuestra1>();
	List<IMuestra1> filtro =new ArrayList<IMuestra1>();

	@BeforeEach
	void setUp() {
		//Test  Instalation
		buscador =new Buscador(new ArrayList<IMuestra1>());
		
		//set 
		muestra1 = mock(IMuestra1.class);
		muestra2 = mock(IMuestra1.class);
		muestra3 = mock(IMuestra1.class);

		//tiposDeIsectos
		tipo1 = ITipoDeVoto1.Chinche_Foliada;
		tipo2 =ITipoDeVoto1.Imagen_poco_clara;
		tipo3 = ITipoDeVoto1.Ninguna;
		
	}
	
	@Test
	void testObject() {
		//testeo el constructor
		assertEquals(Buscador.class, buscador.getClass());
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

		when(muestra3.getFecha()).thenReturn(fecha3);
		when(muestra2.getFecha()).thenReturn(fecha3);
		when(muestra1.getFecha()).thenReturn(fecha3);
		
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);

		//exercise
		buscador.muestraCreadaEnLaFecha(fecha2);
		
		//assertEquals(muestras, filtro);
		verify(muestra3).getFecha();
		verify(muestra2).getFecha();
		verify(muestra1).getFecha();
		

	}

	@Test
	void testMuestrasConInsecto() {
		//Test  Configuration
		
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		
		
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		//Exercise
		
		buscador.muestrasConInsecto(tipo3);
		
		//verify
		
		verify(muestra3).getEspecieEstadoActual();
		verify(muestra2).getEspecieEstadoActual();
		verify(muestra1).getEspecieEstadoActual();
		
	}
	
	@Test
	void testUltimaMuestraVotada() {
		//Test  Configuration
		Date fecha1 = new Date();
		Date fecha2 = new Date();
		Date fecha3 = new Date();
		
		when(muestra1.getFechaUltimaOpinion()).thenReturn(fecha1);
		when(muestra2.getFechaUltimaOpinion()).thenReturn(fecha2);
		when(muestra3.getFechaUltimaOpinion()).thenReturn(fecha3);
		
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		
		buscador.ultimaMuestraVotada();
		
		verify(muestra3).getFechaUltimaOpinion();
	}

	@Test
	void testNivelValidacion() {
		//Test configuracion
		
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
	
		//exercise
		buscador.nivelValidacion(tipo3);
		
		//verify
		verify(muestra1).getEstado();
		verify(muestra2).getEstado();
		verify(muestra3).getEstado();
	}

	@Test
	void testBuscadorGeneral() {
		//Test configuracion
		Date fecha1 = new Date();
		Date fecha2 = new Date();
		Date fecha3 = new Date();
		
		when(muestra1.getFecha()).thenReturn(fecha1);
		when(muestra2.getFecha()).thenReturn(fecha2);
		when(muestra3.getFecha()).thenReturn(fecha3);
		
		when(muestra3.getEspecieEstadoActual()).thenReturn(tipo3);
		when(muestra2.getEspecieEstadoActual()).thenReturn(tipo2);
		when(muestra1.getEspecieEstadoActual()).thenReturn(tipo1);
		
		when(muestra3.getEstado()).thenReturn(tipo3);
		when(muestra2.getEstado()).thenReturn(tipo2);
		when(muestra1.getEstado()).thenReturn(tipo1);
		
		
		
		buscador.muestraAAgregar(muestra1);
		buscador.muestraAAgregar(muestra2);
		buscador.muestraAAgregar(muestra3);
		
		//exercise
		buscador.buscadorGeneral(fecha1,tipo1, tipo2,fecha3 );
		
		//verify
		verify(muestra2).getFecha();
		
	}

	
	@Test
	void testSetMuestrasTotalesDelSys() {
		//Test configuracion
		ArrayList<IMuestra1> muestrasIniciales = new ArrayList<IMuestra1>();
		muestrasIniciales.add(muestra1);
		muestrasIniciales.add(muestra2);
		
		//exercise
		buscador.setMuestrasTotalesDelSys(muestrasIniciales);
		
		//verify
		assertEquals(2, buscador.getMuestrasTotalesDelSys().size());
	}
	
	@Test
	void testGetMuestrasTotalesDelSys() {
		//Test configuracion
		ArrayList<IMuestra1> muestrasIniciales = new ArrayList<IMuestra1>();
		muestrasIniciales.add(muestra1);
		muestrasIniciales.add(muestra2);
		
		//exercise
		buscador.setMuestrasTotalesDelSys(muestrasIniciales);
		
		buscador.muestraAAgregar(muestra3);
		buscador.muestraAAgregar(muestra3);
		buscador.muestraAAgregar(muestra3);
		
		//verify
		assertEquals(5, buscador.getMuestrasTotalesDelSys().size());
	}
	


}
