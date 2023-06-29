package sistema.sistemaDeVotos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sistema.sistemaDeVotos.validacion.EstadoValidacion;
import sistema.sistemaDeVotos.validacion.VotanSoloExpertos;
import sistema.sistemaDeVotos.validacion.VotanTodos;
import sistema.usuario.Usuario;
import sistema.usuario.nivelDeUsuarios.Basico;

class OpinionTest {
	private TipoDeVoto voto;
	private Usuario votoUserName;
	Date fecha = new Date(); 
	Opinion opinion;
	ManejadorDeVotos manejador;
	EstadoValidacion todos = new VotanTodos() ;
	EstadoValidacion expertos = new VotanSoloExpertos() ;
	
	
	@BeforeEach
	void setUp(){
		voto = TipoDeVoto.Phtia_Chinche;
		votoUserName = mock(Usuario.class);
		opinion = new Opinion(voto, votoUserName);
		manejador = mock(ManejadorDeVotos.class);
		
	}

	@Test
	void testOpinion() {
		Opinion nuevaOpinion = new Opinion(voto, votoUserName);
		assertEquals(nuevaOpinion.getClass(), Opinion.class);
	}

	@Test
	void testGetVoto() {
		assertEquals(opinion.getVoto(), TipoDeVoto.Phtia_Chinche);
	}

	@Test
	void testSetVoto() {
		TipoDeVoto voto2 = TipoDeVoto.Vinchuca_Guasayana;
		opinion.setVoto(voto2);
		assertEquals(opinion.getVoto(),TipoDeVoto.Vinchuca_Guasayana);
	}

	@Test
	void testGetVotoUserName() {
		assertEquals(opinion.getVotoUserName(),votoUserName);
	}

	@Test
	void testGetFecha() {
		opinion.setFecha(fecha);
		assertEquals(opinion.getFecha(),fecha);
	}
	@Test
	void testSuscribirse() {
		when(manejador.getEstadoValidacion()).thenReturn(todos);
		
		opinion.suscribirse(manejador);
		
		verify(manejador).agregarOpinionBasica(opinion);
	}
	@Test
	void testSuscribirseExpertos() {
		when(manejador.getEstadoValidacion()).thenReturn(expertos);
		
		opinion.suscribirse(manejador);
		
		verify(manejador).agregarOpinionExperta(opinion);
	}

}
