package sistema.sistemaDeVotos;

import sistema.muestras.Muestra;
import sistema.sistemaDeVotos.validacion.NoValidada;
import sistema.sistemaDeVotos.validacion.Validacion;
import sistema.usuario.Usuario;

import java.util.ArrayList;

public class ManejadorDeVotos {

	Muestra muestraAsociada;

	ArrayList<Opinion> opinionesBasicas;
	ArrayList<Opinion> opinionesExpertas;

	Validacion state = new NoValidada(this);

	// Getters

	public ArrayList<Opinion> getOpinionesBasicas() {
		return opinionesBasicas;
	}

	public ArrayList<Opinion> getOpinionesExpertas() {
		return opinionesExpertas;
	}

	// Setters

	public void asociarMuestra(Muestra m) {
		this.muestraAsociada = m;
	}

	//
	// Agregar Opiniones

	public void agregarOpinionBasica(Opinion opinion) {
		opinionesBasicas.add(opinion);
	}

	public void agregarOpinionExperta(Opinion opinion) {
		opinionesExpertas.add(opinion);
	}

	//
	// Resultado Actual
	public TipoDeVoto resultadoActual() {
		return null; // el voto q mas aparece en el arraylist
	}
}
