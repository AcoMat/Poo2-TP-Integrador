package sistema.usuario.nivelDeUsuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.Opinion;
import sistema.usuario.Usuario;
import sistema.usuario.nivelDeUsuarios.*;

class CalculadorDeNivelTest {

	CalculadorDeNivel calculador = new CalculadorDeNivel();
	Usuario usuarioMock = mock(Usuario.class);
	ArrayList<Opinion> opinionesMock = new ArrayList<Opinion>();
	ArrayList<Muestra> muestrasMock = new ArrayList<Muestra>();
	Opinion opinionMock = mock(Opinion.class);
	Muestra muestraMock = mock(Muestra.class);
	Date date = new Date();

	@Test
	void noEsExperto() {
		for (int i = 0; i < 5; i++) {
			muestrasMock.add(muestraMock);
		}

		for (int i = 0; i < 5; i++) {
			opinionesMock.add(opinionMock);
		}

		when(muestraMock.getFecha()).thenReturn(date);
		when(usuarioMock.getMuestras()).thenReturn(muestrasMock);

		when(opinionMock.getFecha()).thenReturn(date);
		when(usuarioMock.getOpiniones()).thenReturn(opinionesMock);

		assertFalse(calculador.esExperto(usuarioMock));

	}

	@Test
	void SiEsExperto() {
		for (int i = 0; i < 35; i++) {
			muestrasMock.add(muestraMock);
		}

		for (int i = 0; i < 28; i++) {
			opinionesMock.add(opinionMock);
		}

		when(muestraMock.getFecha()).thenReturn(date);
		when(usuarioMock.getMuestras()).thenReturn(muestrasMock);

		when(opinionMock.getFecha()).thenReturn(date);
		when(usuarioMock.getOpiniones()).thenReturn(opinionesMock);

		assertTrue(calculador.esExperto(usuarioMock));

	}

}
