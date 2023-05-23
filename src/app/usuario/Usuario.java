package app.usuario;

import app.sistemaDeVotos.*;

public class Usuario {

	String userName;
	boolean conocimientoValidado = false;
	private Estado estado;

	// Constructor

	public Usuario(String name, Boolean validado) {
		this.setConocimientoValidado(validado);
		this.userName = name;
		this.setEstado(new Basico());
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		this.estado.setUsuario(this);
	}

	// Setter

	private void setConocimientoValidado(boolean conocimientoValidado) {
		this.conocimientoValidado = conocimientoValidado;
	}

	// Metodos

	public void opinar(TipoDeVoto voto) {
		SistemaDeVotos.nuevaOpinion(this, voto);
	}

}
