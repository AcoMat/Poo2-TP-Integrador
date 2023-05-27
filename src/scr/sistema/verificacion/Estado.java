package scr.sistema.verificacion;

import sistema.muestras.Muestra;

public interface Estado {
	
	public Estado verificar (Muestra m);
	public boolean estaVerificada (Muestra m);
	
}