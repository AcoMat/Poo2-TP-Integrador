package sistema.usuario;

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

	// Setter y Getters

	private void setTipo(Nivel state) {
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



}
