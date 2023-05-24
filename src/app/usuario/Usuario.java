package app.usuario;

import app.muestras.Muestra;
import app.sistemaDeVotos.*;

public class Usuario {

	private String userName;
	private Tipo state;

	// Constructor

	public Usuario(String name, Boolean validado) {
		if (validado){
			this.setTipo(new ExpertoValidado());
			this.setUserName(name);
		}else {
			this.setTipo(new Basico());
			this.setUserName(name);
		}
	}

	// Setter

	private void setTipo(Tipo state) {
		this.state = state;
		this.state.setUsuario(this);
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	// Metodos

	public void opinar(TipoDeVoto voto, Muestra muestra) {
		this.state.opinar(voto, muestra);
	}



}
