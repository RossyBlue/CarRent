package CarRent;


public class Vehiculo {
	private String patente;
	private String marca;
	private String modelo;
	private int anFab;
	private String condicion;

	// constructor
	public Vehiculo(String patente, String marca, String modelo, int anFab, String condicion) {

		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.anFab = anFab;
		this.condicion = condicion;

	}

	// Metodos

	public String getpatente() {
		return this.patente;
	}

	public String getmarca() {
		return this.marca;
	}

	public String getmodelo() {
		return this.modelo;
	}

	public int getanFab() {
		return this.anFab;
	}

	public String getcondicion() {
		return this.condicion;
	}

	void cambiarCondicion(String cambiocondicion) {
		condicion = cambiocondicion;
	}

	public String toString() {
		return String.format("%s %s (%d) - Patente: %s - Estado: %s", marca, modelo, anFab, patente, condicion);
	}
}
