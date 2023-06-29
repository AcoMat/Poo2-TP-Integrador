package sistema.websiteapp;

import sistema.buscadorV3.IBuscador;
import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

import java.util.*;

public class Website {
    //registrar usuarios usar el buscador etc
	private IBuscador motorDeBusqueda;
    private ArrayList<Muestra> muestras = new ArrayList<Muestra>();
    private ArrayList<ZonaDeCobertura> zonasDeCoberturas = new ArrayList<ZonaDeCobertura>();


    //  Metodos

    public void registrarNuevaMuestra(Muestra muestra){
        muestras.add(muestra);
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
        return muestras;
    }

    public ArrayList<ZonaDeCobertura> getZonasDeCoberturas() {
        return zonasDeCoberturas;
    }

}
