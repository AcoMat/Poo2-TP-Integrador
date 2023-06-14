package sistema.muestras;

import sistema.webSite.Website;

public interface IUsuario {
	public void opinar(Muestra muestra, ITipoDeVoto2 especie);

    Website dondeEstaRegistrado();

    void guardarMuestra(Muestra nuevaMuestra);
}
