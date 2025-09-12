package CarRent;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		// Creacion del cliente
		Cliente cliente_1 = new Cliente("20023066-3", "Juan", "Pérez", "Gonzalez", true);
		System.out.println("\n El Estado del cliente:" + cliente_1.getvigencia());

		// creación del vehiculo
		Vehiculo vehiculo_1 = new Vehiculo("CZSL60-6", " Toyota", " Corolla", 2018, "D");
		System.out.println("\n El Estado del vehiculo creado es:" +

				vehiculo_1.getcondicion());

		// Deshabilite al cliente creado y muestre su estado para validar sus datos.
		cliente_1.deshabilitar();
		System.out.println("\nEl Estado del cliente después de deshabilitarlo: " +

				cliente_1.getvigencia());

		// Asigne en mantención al vehículo creado y muestre su estado para validar sus
		// datos.
		vehiculo_1.cambiarCondicion("M");
		System.out.println("\nEl Estado del vehículo después de asignarlo a mantención: " + vehiculo_1.getcondicion());

		// Prueba de arriendo
		// Creamos los dos clientes
		Cliente cliente_2 = new Cliente("19876543-8", "Carlos", "Soto", "Muñoz", true);
		Cliente cliente_3 = new Cliente("19876543-8", "Carlos", "Soto", "Muñoz", true);

		// Creamos dos vehículos
		Vehiculo vehiculo_2 = new Vehiculo("BXTJ34-2", "Honda", "Civic", 2020, "D");
		Vehiculo vehiculo_3 = new Vehiculo("ZXC123-7", "Nissan", "Versa", 2019, "D");

		// arriendo exitoso
		Arriendo arriendoExitoso = new Arriendo(1, vehiculo_2, cliente_2, LocalDateTime.now(), 5, 25000);

		if (arriendoExitoso.ingresar()) {
			System.out.println("\n Arriendo exitoso. Generando ticket...");
			arriendoExitoso.generarTicket();
		} else {
			System.out.println("\n Error: No se pudo realizar el arriendo exitoso.");
		}

		// **Arriendo fallido**
		Arriendo arriendoFallido = new Arriendo(2, vehiculo_3, cliente_3,

				LocalDateTime.now(), 3, 28000);

		if (arriendoFallido.ingresar()) {

			System.out.println("\n Arriendo fallido realizado (esto no debería ocurrir).");
		} else {
			System.out.println(

					"\n Error: No se pudo realizar el arriendo porque el cliente está inhabilitado o el vehículo no está disponible.");

		}

		// INGRESO DE ARRIENDO EXITOSO Y FALLIDO
		// Cliente y vehículo para arriendo exitoso
		Cliente clienteValido = new Cliente("20023066-3", "Juan", "Pérez", "González", true);

		Vehiculo vehiculoDisponible = new Vehiculo("CZSL60-6", "Toyota", "Corolla", 2021, "D");

		// Arriendo exitoso
		Arriendo arriendoExitoso1 = new Arriendo(23453, vehiculoDisponible, clienteValido,
				LocalDateTime.of(2021, 1, 10, 0, 0), 3, 45000);
		if (arriendoExitoso1.ingresar()) {
			System.out.println(" Arriendo exitoso. Generando ticket...");
			arriendoExitoso1.generarTicket();
			System.out.println("Estado del vehículo después del arriendo: " + vehiculo_2.getcondicion());
		} else {
			System.out.println(" No fue posible realizar el arriendo exitoso.");
		}

		// Cliente y vehículo para arriendo fallido (vehículo en mantención)
		Cliente clienteSecundario = new Cliente("19283746-8", "Laura", "Ríos", "Salinas", true);

		Vehiculo vehiculoNoDisponible = new Vehiculo("ZZZ123-4", "Mazda", "CX-5", 2022, "M");

		// Arriendo fallido
		Arriendo arriendoFallido1 = new Arriendo(23454, vehiculoNoDisponible, clienteSecundario,

				LocalDateTime.of(2021, 1, 10, 0, 0), 4, 40000);
		if (arriendoFallido1.ingresar()) {
			System.out.println("Arriendo fallido fue aceptado (esto es un error).");
		} else {
			System.out.println("Arriendo fallido rechazado correctamente.");
			System.out.println("Cliente: " + clienteSecundario.getcedula() + " - " + clienteSecundario);
			System.out.println("Vehículo: " + vehiculoNoDisponible);
		}

		// Devolución de VEHICULO EXITOSO Y FALLIDA

		// Devolución exitosa (mismo vehículo arrendado en arriendoExitoso)
		Devolucion devolucionOk = new Devolucion(arriendoExitoso, LocalDateTime.of(2021, 1, 13, 0, 0), clienteValido,
				LocalDateTime.of(2021, 1, 10, 0, 0), 3);
		if (devolucionOk.devolucionvehiculo(vehiculoDisponible)) {

			System.out.println(
					"Devolución exitosa. Vehículo devuelto en condición: " + vehiculoDisponible.getcondicion());

		} else {
			System.out.println("Devolución falló (error inesperado en devolución válida).");
		}
		// Devolución fallida (vehículo no corresponde al arriendo y devuelve la
		// condición del vehículo)
		Devolucion devolucionMala = new Devolucion(arriendoExitoso, LocalDateTime.of(2021, 1, 13, 0, 0), clienteValido,
				LocalDateTime.of(2021, 1, 10, 0, 0), 3);
		if (devolucionMala.devolucionvehiculo(vehiculoNoDisponible)) {
			System.out.println("Devolución incorrectamente aceptada (esto es un error).");
		} else {
			System.out.println("Devolución fallida correctamente rechazada. Vehículo no coincide con el arriendo.");
			System.out.println(
					"Estado del vehículo después de la devolución fallida: " + vehiculoNoDisponible.getcondicion());

		}
	}
}
