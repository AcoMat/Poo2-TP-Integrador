package app.usuario;

import app.sistemaDeVotos.*;

public class Usuario{
	
	String userName;
	boolean conocimientoValidado = false;
	
	//	Constructor
	
	public Usuario(String name, Boolean validado) {
		this.setConocimientoValidado(validado);
		this.userName = name;
	}


	//	Setter

	private void setConocimientoValidado(boolean conocimientoValidado) {
		this.conocimientoValidado = conocimientoValidado;
	}
	
	//	Metodos
	
	public void opinar(TipoDeVoto voto) {
		SistemaDeVotos.nuevaOpinion(this, voto);
	}
	
	
	
	
}

	