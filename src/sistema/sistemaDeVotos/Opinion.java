package sistema.sistemaDeVotos;

import sistema.usuario.Nivel;

public class Opinion {
    private TipoDeVoto voto;
    private String votoUserName;
    private Boolean esExperto;
    private Nivel estadoDeUsuarioAlVotar;

    public Opinion(TipoDeVoto v, String username, Boolean esExperto){
        this.voto = v;
        this.votoUserName = username;
        this.esExperto = esExperto;
    }

    public TipoDeVoto getVoto() {
        return voto;
    }

    public void setVoto(TipoDeVoto voto) {
        this.voto = voto;
    }

    public String getVotoUserName() {
        return votoUserName;
    }

    public void setVotoUserName(String votoUserName) {
        this.votoUserName = votoUserName;
    }

    public Boolean getEsExperto() {
        return esExperto;
    }

    public void setEsExperto(Boolean esExperto) {
        this.esExperto = esExperto;
    }
}




