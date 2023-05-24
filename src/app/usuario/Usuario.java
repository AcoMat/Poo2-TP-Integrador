package app.usuario;

import app.sistemaDeVotos.*;

public class Usuario {

	String userName;
	boolean conocimientoValidado = false;
	private Tipo state;

	// Constructor

	public Usuario(String name, Boolean validado) {
		this.setConocimientoValidado(validado);
		this.userName = name;
		this.setEstado(new Basico());
	}

	// Setter

	public void setEstado(Tipo state) {
		this.state = state;
		this.state.setUsuario(this);
	}

	private void setConocimientoValidado(boolean conocimientoValidado) {
		this.conocimientoValidado = conocimientoValidado;
	}

	// Metodos

	public void opinar(TipoDeVoto voto) {
		this.state.opinar(voto);
	}

}
