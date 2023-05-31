package sistema.ubicacion;

import sistema.muestras.Muestra;

import java.util.ArrayList;

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

		/*	Haversine:

			public final static double AVERAGE_RADIUS_OF_EARTH_KM = 6371;
			public int calculateDistanceInKilometer(double userLat, double userLng,
			double venueLat, double venueLng) {

			double latDistance = Math.toRadians(userLat - venueLat);
			double lngDistance = Math.toRadians(userLng - venueLng);

			double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
					+ Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(venueLat))
					* Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2);

			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

			return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH_KM * c));
		}

		*/

	}

	public ArrayList<Ubicacion> aquellasAMenosDe1Km(ArrayList<Ubicacion> ubicaciones){
		//TODO, filtrar aquellas q this.distanciaHasta < 1
	}

	public ArrayList<Muestra> muestrasAMenosDeXKm(int kms){
		//TODO
		//	como hago para saber las muestras a menos de x km???
	}
	
}
