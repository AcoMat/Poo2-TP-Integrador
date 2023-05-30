package sistema.usuario;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;

import org.junit.jupiter.api.Test;

class UsuarioTestCases {

	@Test
	public void test() {
		 Usuario usuario1 = mock(Usuario.class);
		 Usuario usuario2 = mock(Usuario.class);
		 
		 when(usuario1.getMuestras()).thenReturn(null);
	}

}


//Creación
//ClassName varName = mock(ClassName.class);
//@Mock private ClassName varName;
//Set un valor
//when(methodCall).thenReturn(value)
//.thenReturn(value, value) .thenThrow(throwableClasses)
//Verificar
//verify(mock).methodCall
//verify(mock, VerificationMode).methodCall
//verifyNoMoreInteractions(mock)
//verifyZeroInteractions(mock)
//Modos de Verificacion
//atLeastOne() atLeast( int )
//atMost( int ) times( int )
//timeout(long) never()


//Dummy: 
//Son objetos que se pasan por allí, pero nunca se utilizan realmente. 
//Por lo general, sólo son utilizadas para rellenar listas de parámetros.


//Stub:
//Proporciona respuestas preprogramadas a las llamadas realizadas durante la prueba.


//Mock:
//Es un Stub con la capacidad de poder verificarse.


	//Spy
	//Es un Mock pero que llama realmente a los métodos del objeto real.