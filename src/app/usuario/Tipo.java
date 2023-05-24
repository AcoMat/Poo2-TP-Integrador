package app.usuario;

import app.muestras.Muestra;
import app.sistemaDeVotos.TipoDeVoto;

public interface Tipo {

	void opinar(TipoDeVoto voto, Muestra muestra);

	void setUsuario(Usuario usuario);
}
