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
import sistema.sistemaDeVotos.TipoDeVoto;

class BuscadorConjuntivoTest {
	private BuscadorConjuntivo buscador;
	private IBuscador primerFiltro;
	private IBuscador segundoFiltro;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
 	
	@BeforeEach
	void setUp(){
		primerFiltro = new BuscadorPorTipoInsecto(TipoDeVoto.Chinche_Foliada);
		segundoFiltro= new BuscadorPorValidacion(TipoDeVoto.Vinchuca_Infestans);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		buscador = new BuscadorConjuntivo(primerFiltro, segundoFiltro);
	}

	@Test
	void testTipoDeCombinacion() {
		when(muestra1.getEspecie()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra1.resultadoActual()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra2.getEspecie()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra2.resultadoActual()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra3.getEspecie()).thenReturn(TipoDeVoto.Chinche_Foliada);
		when(muestra3.resultadoActual()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		
		buscador.buscarMuestras(muestras);
		
		verify(muestra3).resultadoActual();
		verify(muestra3).getEspecie();
		
	}

	@Test
	void testGetPrimerTipoDeFiltro() {
		IBuscador nuevoFiltro = new BuscadorVotadasDespuesDe(new Date());
		
		buscador.setPrimerTipoDeFiltro(nuevoFiltro);
		
		IBuscador resultado = buscador.getPrimerTipoDeFiltro();
		
		assertEquals(resultado.getClass(), BuscadorVotadasDespuesDe.class);
	}

	@Test
	void testSetPrimerTipoDeFiltro() {
		IBuscador nuevoFiltro = new BuscadorCreadosAntesDe(new Date());
		buscador.setPrimerTipoDeFiltro(nuevoFiltro);
		
		
		assertEquals(buscador.getPrimerTipoDeFiltro().getClass(), BuscadorCreadosAntesDe.class);
	}

	@Test
	void testGetSegundoTipoDeFiltro() {
		IBuscador nuevoFiltro = new BuscadorCreadosDespuesDe(new Date());
		buscador.setSegundoTipoDeFiltro(nuevoFiltro);
		
		IBuscador resultado = buscador.getSegundoTipoDeFiltro();
		assertEquals(resultado.getClass(), BuscadorCreadosDespuesDe.class);
	}

	@Test
	void testSetSegundoTipoDeFiltro() {
		
		IBuscador nuevoFiltro = new BuscadorCreadosAntesDe(new Date());
		buscador.setPrimerTipoDeFiltro(nuevoFiltro);
		
		
		assertEquals(buscador.getPrimerTipoDeFiltro().getClass(), BuscadorCreadosAntesDe.class);
	}

	@Test
	void testBuscarMuestras() {
		when(muestra1.getEspecie()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra1.resultadoActual()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra2.getEspecie()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra2.resultadoActual()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra3.getEspecie()).thenReturn(TipoDeVoto.Chinche_Foliada);
		when(muestra3.resultadoActual()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		
		buscador.buscarMuestras(muestras);
		
		verify(muestra3).resultadoActual();
		verify(muestra3).getEspecie();
		verify(muestra2).resultadoActual();
		verify(muestra2).getEspecie();
		verify(muestra1).resultadoActual();
		verify(muestra1).getEspecie();
	}

	@Test
	void testCombinadorDeBusqueda() {
		
		assertEquals(buscador.getClass(), BuscadorConjuntivo.class);
	}

}
