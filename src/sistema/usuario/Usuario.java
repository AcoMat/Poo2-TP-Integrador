package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Usuario {

	private String userName;
	private Nivel state;

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

	private void setTipo(Nivel state) {
		this.state = state;
		this.state.setUsuario(this);
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	//	Getters

	public String getUserName() {
		return userName;
	}
	public Nivel getState() {
		return state;
	}


	// Metodos

	public Boolean soyExperto(){
		return this.state.esExperto();
	}



}
