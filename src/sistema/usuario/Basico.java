package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

public class Basico extends Nivel {
	@Override
	public boolean esExperto() {
		return false;
	}
}
