package sistema.ubicacion;

import sistema.muestras.Muestra;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ubicacion {
	
	double latitud;
	double longitud;

	// Getters

	public double getLatitud() {
		return latitud;
	}
	public double getLongitud() {
		return longitud;
	}

	//	Constructor

	public Ubicacion(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	//

	public double distanciaHasta(Ubicacion ubi){
		//Teorema de pitagoras?? o Formula de Haversine ??

		// Pitagoras:
		double calculoXs = Math.pow((ubi.getLatitud()-this.getLatitud()),2);
		double calculoYs = Math.pow((ubi.getLongitud()-this.getLongitud()),2);
		return Math.sqrt(calculoXs + calculoYs);

	}

	public ArrayList<Ubicacion> aquellasAMenosDeXKm(ArrayList<Ubicacion> ubicaciones, double kms){
		return ubicaciones.stream().filter(ubi -> ubi.distanciaHasta(this) < kms).collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<Muestra> muestrasAMenosDeXKm(Muestra muestra, double kms){
		ArrayList<Muestra> todasLasMuestras = muestra.getAutor().dondeEstaRegistrado().todasLasMuestras();
		Ubicacion ubicacionMuestra = muestra.getUbicacion();
		return todasLasMuestras.stream()
				.filter(m -> ubicacionMuestra.distanciaHasta(m.getUbicacion()) < kms)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
}
