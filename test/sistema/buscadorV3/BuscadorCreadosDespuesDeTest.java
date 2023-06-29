package sistema.buscadorV3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.muestras.Muestra;

class BuscadorCreadosDespuesDeTest {
	private BuscadorCreadosDespuesDe buscador;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Date fechaActual= new Date();
	
	@BeforeEach
	void setUp(){
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		buscador = new BuscadorCreadosDespuesDe(fechaActual);
	}


	@Test
	void testCriterioDeBusquedaPorFecha() {
		Date fecha = new Date();
		when(muestra1.getFecha()).thenReturn(fecha);
		when(muestra2.getFecha()).thenReturn(fecha);
		when(muestra3.getFecha()).thenReturn(fecha);
		
		buscador.criterioDeBusquedaPorFecha(muestras, fecha);
		
		verify(muestra1).getFecha();
		verify(muestra2).getFecha();
		verify(muestra3).getFecha();
	}

	@Test
	void testBuscadorCreadosDespuesDe() {
		IBuscador nuevo= new BuscadorCreadosDespuesDe(fechaActual);
		assertEquals(nuevo.getClass(), BuscadorCreadosDespuesDe.class);
	}

	@Test
	void testBuscarMuestras() {
		Date fecha = new Date();
		when(muestra1.getFecha()).thenReturn(fecha);
		when(muestra2.getFecha()).thenReturn(fecha);
		when(muestra3.getFecha()).thenReturn(fecha);
		
		buscador.buscarMuestras(muestras);
		
		verify(muestra1).getFecha();
		verify(muestra2).getFecha();
		verify(muestra3).getFecha();
	}

}
