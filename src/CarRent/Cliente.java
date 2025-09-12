package CarRent;

public class Cliente {
	private String cedula;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private boolean vigencia;

// constructor
	public Cliente(String cedula, String nombre, String apellidoPaterno, String apellidoMaterno, boolean vigencia) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.vigencia = vigencia;
	}

	public String getcedula() {
		return this.cedula;
	}

	public String getnombre() {
		return this.nombre;
	}

	public String getapellidoPaterno() {
		return this.apellidoPaterno;
	}

	public String getapellidoMaterno() {
		return this.apellidoMaterno;
	}

	public boolean getvigencia() {
		return this.vigencia;
	}

	void deshabilitar() {
		vigencia = false;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidoPaterno;
	}

}