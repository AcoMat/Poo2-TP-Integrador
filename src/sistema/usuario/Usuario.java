package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.*;
import sistema.ubicacion.Ubicacion;

import java.util.ArrayList;

public class Usuario {

	private String userName;
	private Tipo state;
	private ArrayList<Muestra> muestrasPosteadas;

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

	// Setter y Getters

	private void setTipo(Tipo state) {
		this.state = state;
		this.state.setUsuario(this);
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	// Metodos

	public void opinar(TipoDeVoto voto, Muestra muestra) {
		this.state.opinar(voto, muestra);
	}

	public void postearMuestra(TipoDeVoto opinion, String fotoURL, Ubicacion ubicacion){
		Muestra m = new Muestra(opinion, fotoURL, this, ubicacion);
		muestrasPosteadas.add(m);

	}


}
