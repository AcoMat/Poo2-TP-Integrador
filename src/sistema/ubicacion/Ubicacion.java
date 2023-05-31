package sistema.ubicacion;

import sistema.muestras.Muestra;

import java.util.ArrayList;

public class Ubicacion {
	
	double latitud;
	double longitud;

	public int distanciaHasta(Ubicacion ubi){
		//TODO, teorema de pitagoras
		return 0;
	}

	public ArrayList<Ubicacion> aquellasAMenosDe1Km(ArrayList<Ubicacion> ubicaciones){
		//TODO, filtrar aquellas q this.distanciaHasta < 1
	}

	public ArrayList<Muestra> muestrasAMenosDeXKm(int kms){
		//TODO
	}
	
}
