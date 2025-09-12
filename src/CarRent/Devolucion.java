package CarRent;

import java.time.LocalDateTime;

public class Devolucion {
	private Arriendo arriendoEspecifico;
	private LocalDateTime fechaDevol;
	private Cliente clienteArrienda;
	private LocalDateTime fechaArriendo;
	private int numDiasArrendado;

// constructor
	public Devolucion(Arriendo arriendoEspecifico, LocalDateTime fechaDevol, Cliente clienteArrienda,

			LocalDateTime fechaArriendo, int numDiasArrendado) {
		this.arriendoEspecifico = arriendoEspecifico;
		this.fechaDevol = fechaDevol;
		this.clienteArrienda = clienteArrienda;
		this.numDiasArrendado = numDiasArrendado;
	}

	public Arriendo getarriendoEspecifico() {
		return this.arriendoEspecifico;
	}

	public LocalDateTime getfechaDevol() {
		return this.fechaDevol;
	}

	public Cliente getclienteArrienda() {
		return this.clienteArrienda;
	}

	public LocalDateTime getfechaArriendo() {
		return this.fechaArriendo;
	}

	public int getnumDiasArrendado() {
		return this.numDiasArrendado;
	}

	boolean devolucionvehiculo(Vehiculo vehiculoDevol) {
		if (arriendoEspecifico.getvehiculoArriendo().getpatente() ==

				vehiculoDevol.getpatente()

				&& arriendoEspecifico.getvehiculoArriendo().getanFab() ==

						vehiculoDevol.getanFab()

				&& arriendoEspecifico.getvehiculoArriendo().getmarca() ==

						vehiculoDevol.getmarca()

				&& arriendoEspecifico.getvehiculoArriendo().getmodelo() ==

						vehiculoDevol.getmodelo()) {

			vehiculoDevol.cambiarCondicion("D");
			return true;
		} else {
			return false;

		}
	}
}