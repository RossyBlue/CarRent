package CarRent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Clase y atributos de arriendo 

public class Arriendo {

	private int numArriendo;
	private Vehiculo vehiculoArriendo;
	private Cliente clienteArriendo;
	private LocalDateTime fechaArriendo;
	private int numDiasArrendado;
	private double precioDiario;

	// constructor
	public Arriendo(int numArriendo, Vehiculo vehiculoArriendo, Cliente clienteArriendo, LocalDateTime fechaArriendo,
			int numDiasArrendado, double precioDiario) {

		this.numArriendo = numArriendo;
		this.vehiculoArriendo = vehiculoArriendo;
		this.clienteArriendo = clienteArriendo;
		this.fechaArriendo = fechaArriendo;
		this.numDiasArrendado = numDiasArrendado;
		this.precioDiario = precioDiario;

	}

//Metodos de arriendo

	public int getnumArriendo() {
		return this.numArriendo;
	}

	public Vehiculo getvehiculoArriendo() {
		return this.vehiculoArriendo;
	}

	public Cliente getclienteArriendo() {
		return this.clienteArriendo;
	}

	public LocalDateTime getfechaArriendo() {
		return this.fechaArriendo;
	}

	public int getnumDiasArrendado() {
		return this.numDiasArrendado;
	}

	public double getprecioDiario() {
		return this.precioDiario;
	}

	boolean evaluar() {
		if (clienteArriendo.getvigencia() == true && vehiculoArriendo.getcondicion() == "D") {
			return true;
		} else {
			return false;
		}
	}

	boolean ingresar() {
		if (evaluar() == true) {
			vehiculoArriendo.cambiarCondicion("A");
			return true;
		} else {
			return false;
		}
	}

	public double montoPagoTotal() {
		return precioDiario * numDiasArrendado;
	}

	public void generarTicket() {

		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("\n T I C K E T A R R I E N D O D E V E H Í C U L O");
		System.out.println("---------------------------------------------------------------");
		System.out.println(String.format(" NÚMERO ARRIENDO : %-10d", getnumArriendo()));
		System.out.println(String.format(" VEHÍCULO : %-20s", getvehiculoArriendo()));
		System.out.println(String.format(" PRECIO DIARIO : $%.0f", getprecioDiario()));
		System.out.println();
		System.out.println(" FECHA CLIENTE DÍAS A PAGAR");
		System.out.println("---------------------------------------------------------------");
		String fechaFormateada = getfechaArriendo().format(formatoFecha);
		String clienteFormateado = getclienteArriendo().getcedula() + "/ " + getclienteArriendo().toString();
		String diasTexto = getnumDiasArrendado() + " días";
		double total = montoPagoTotal();
		System.out.printf(" %-11s %-28s %-7s $%.0f\n", fechaFormateada, clienteFormateado, diasTexto, total);
		System.out.println("---------------------------------------------------------------");
		System.out.println(" ____________________");
		System.out.println(" FIRMA CLIENTE");
	}
}