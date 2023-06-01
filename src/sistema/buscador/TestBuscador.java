package sistema.buscador;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class TestBuscador {
	private Buscador buscador; 
	ArrayList<Muestra> muestras = new ArrayList<Muestra>();
	
	@BeforeEach
	void buscadorIncializado() {
		buscador = new Buscador(null);
	}
	
	@Test
	void testObject() {
		Muestra muestra1 = new Muestra();
		Muestra muestra2  = new Muestra();
		Muestra muestra3 = new Muestra ();
		ArrayList<Muestra> lista = new ArrayList<Muestra>();
		lista.add(muestra1);
		lista.add(muestra2);
		lista.add(muestra3);
		
		Buscador buscador = new Buscador(lista);

		assertInstanceOf(Buscador.class, buscador);
	}
	

	@Test
	void testNuevaMuestraEnSistema() {
		fail("Not yet implemented");
	}

	@Test
	void testMuestraCreadaEnLaFecha() {
		fail("Not yet implemented");
	}

	@Test
	void testMuestrasConInsecto() {
		fail("Not yet implemented");
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
