package sistema.usuario;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.TipoDeVoto;

public interface Tipo {

	void opinar(TipoDeVoto voto, Muestra muestra);

	void setUsuario(Usuario usuario);
}
