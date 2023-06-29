package sistema.buscadorV3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.muestras.Muestra;

class BuscadorCreadosAntesDeTest {
	private BuscadorCreadosAntesDe buscador;
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
		
		buscador = new BuscadorCreadosAntesDe(fechaActual);
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
	void testBuscadorCreadosAntesDe() {
		IBuscador nuevoBuscador = new BuscadorCreadosAntesDe(fechaActual);
		assertEquals(nuevoBuscador.getClass(), BuscadorCreadosAntesDe.class);
	}

	@Test
	void testGetFechaDeInteres() {
		assertEquals(fechaActual, buscador.getFechaDeInteres());
	}

	@Test
	void testSetFechaDeInteres() {
		Date nuevaFecha = new Date();
		buscador.setFechaDeInteres(nuevaFecha);
		assertEquals(nuevaFecha, buscador.getFechaDeInteres());
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

	@Test
	void testCreadasAntesDe() {
		Date fecha = new Date();
		when(muestra1.getFecha()).thenReturn(fecha);
		when(muestra2.getFecha()).thenReturn(fecha);
		when(muestra3.getFecha()).thenReturn(fecha);
		
		buscador.creadasAntesDe(muestras, fecha);
		
		verify(muestra1).getFecha();
		verify(muestra2).getFecha();
		verify(muestra3).getFecha();
	}

	@Test
	void testCreadasDespuesDe() {
		Date fecha = new Date();
		when(muestra1.getFecha()).thenReturn(fecha);
		when(muestra2.getFecha()).thenReturn(fecha);
		when(muestra3.getFecha()).thenReturn(fecha);
		
		buscador.creadasDespuesDe(muestras, fecha);
		
		verify(muestra1).getFecha();
		verify(muestra2).getFecha();
		verify(muestra3).getFecha();
	}

	@Test
	void testVotadasLuegoDeLaFecha() {
		Date fecha = new Date();
		when(muestra1.getFechaUltimaVotacion()).thenReturn(fecha);
		when(muestra2.getFechaUltimaVotacion()).thenReturn(fecha);
		when(muestra3.getFechaUltimaVotacion()).thenReturn(fecha);
		
		buscador.votadasLuegoDeLaFecha(muestras, fecha);
		
		verify(muestra1).getFechaUltimaVotacion();
		verify(muestra2).getFechaUltimaVotacion();
		verify(muestra3).getFechaUltimaVotacion();

	}

}
