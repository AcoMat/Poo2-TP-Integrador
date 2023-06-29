package sistema.buscadorV3;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

class BuscadorPorTipoInsectoTest {
	private BuscadorPorTipoInsecto buscador;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
 	
	@BeforeEach
	void setUp(){
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		
		buscador = new BuscadorPorTipoInsecto(TipoDeVoto.Vinchuca_Infestans);
	}

	@Test
	void testBuscarMuestras() {
		when(muestra1.getEspecie()).thenReturn(TipoDeVoto.Chinche_Foliada);
		when(muestra2.getEspecie()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra3.getEspecie()).thenReturn(TipoDeVoto.Imagen_poco_clara);
		
		buscador.buscarMuestras(muestras);
		
		verify(muestra1).getEspecie();
		verify(muestra2).getEspecie();
		verify(muestra3).getEspecie();
	}

	@Test
	void testMuestrasConInsecto() {
		when(muestra1.getEspecie()).thenReturn(TipoDeVoto.Chinche_Foliada);
		when(muestra2.getEspecie()).thenReturn(TipoDeVoto.Vinchuca_Infestans);
		when(muestra3.getEspecie()).thenReturn(TipoDeVoto.Imagen_poco_clara);
		
		buscador.muestrasConInsecto(muestras,TipoDeVoto.Vinchuca_Infestans );
		
		verify(muestra1).getEspecie();
		verify(muestra2).getEspecie();
		verify(muestra3).getEspecie();
	}

	@Test
	void testBuscadorPorTipoInsecto() {
		IBuscador nuevoBuscador = new BuscadorPorTipoInsecto(TipoDeVoto.Vinchuca_Sordida);
		assertEquals(nuevoBuscador.getClass() , BuscadorPorTipoInsecto.class);
	}

}
