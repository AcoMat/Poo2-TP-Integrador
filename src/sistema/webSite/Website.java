package sistema.webSite;

import sistema.buscador.Buscador;
import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

import java.util.ArrayList;

public class Website {
    //registrar usuarios usar el buscador etc

    private Buscador motorDeBusqueda= new Buscador(new ArrayList<Muestra>());
    private ArrayList<ZonaDeCobertura> zonasDeCoberturas = new ArrayList<ZonaDeCobertura>();


    //  Metodos

    public void registrarNuevaMuestra(Muestra muestra){
        this.getMotorDeBusqueda().registrarNuevaMuestra(muestra);
        this.getZonasDeCoberturas().stream().forEach(zC -> zC.agregarSiEstaEnLaZona(muestra));
    }

    public void registrarValidacion(Muestra muestra){
        this.getZonasDeCoberturas().stream().forEach(zC -> zC.nuevaValidacion(muestra));
    }

    public void nuevaZonaDeCobertura(String nombre,Ubicacion epicentro, int radio){
        this.getZonasDeCoberturas().add(new ZonaDeCobertura(epicentro, radio, nombre));
    }

    public void nuevaZonaDeCobertura(ZonaDeCobertura zc){
        this.getZonasDeCoberturas().add(zc);
    }

    public ArrayList<Muestra> todasLasMuestras(){
        return this.motorDeBusqueda.getMuestrasTotalesDelSys();
    }

    public Buscador getMotorDeBusqueda() {
        return motorDeBusqueda;
    }
    public ArrayList<ZonaDeCobertura> getZonasDeCoberturas() {
        return zonasDeCoberturas;
    }

}
