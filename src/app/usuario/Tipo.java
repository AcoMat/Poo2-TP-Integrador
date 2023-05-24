package app.usuario;

import app.sistemaDeVotos.TipoDeVoto;

public interface Tipo {

	void opinar(TipoDeVoto voto);

	void enviarMuestra();

	void setUsuario(Usuario usuario);
}
