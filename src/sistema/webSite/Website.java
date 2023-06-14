package sistema.webSite;

import sistema.buscador.Buscador;
import sistema.buscador.interfacez.IMuestra1;
import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

import java.util.ArrayList;

public class Website {
    //registrar usuarios usar el buscador etc

    private Buscador motorDeBusqueda= new Buscador(new ArrayList<IMuestra1>());
    private ArrayList<ZonaDeCobertura> zonasDeCoberturas = new ArrayList<ZonaDeCobertura>();


    //  Metodos

    public void registrarNuevaMuestra(Muestra muestra){
        this.motorDeBusqueda.registrarNuevaMuestra(muestra);
        this.zonasDeCoberturas.stream().forEach(zC -> zC.agregarSiEstaEnLaZona(muestra));
    }

    public void registrarValidacion(Muestra muestra){
        this.zonasDeCoberturas.stream().forEach(zC -> zC.nuevaValidacion(muestra));
    }

    public void nuevaZonaDeCobertura(String nombre,Ubicacion epicentro, int radio){
        this.zonasDeCoberturas.add(new ZonaDeCobertura(epicentro, radio, nombre));
    }

    public ArrayList<IMuestra1> todasLasMuestras(){
        return this.motorDeBusqueda.getMuestrasTotalesDelSys();
    }

    public Buscador getMotorDeBusqueda() {
        return motorDeBusqueda;
    }
    public ArrayList<ZonaDeCobertura> getZonasDeCoberturas() {
        return zonasDeCoberturas;
    }

}
