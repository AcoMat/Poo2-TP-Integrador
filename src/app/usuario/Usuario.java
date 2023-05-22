package app.usuario;

public class Usuario{
	
	String userName;
	boolean conocimientoValidado = false;
	
	//	Constructor
	
	public Usuario(Boolean validado) {
		this.setConocimientoValidado(validado);
	}


	//	Setter

	private void setConocimientoValidado(String name, boolean conocimientoValidado) {
		this.userName = name;
		this.conocimientoValidado = conocimientoValidado;
	}
	
	
	
	
}

	