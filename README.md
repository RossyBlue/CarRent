# Car-REnt (Java)

A simple **Car Rental Management System** implemented in Java.  
This project was built to practice **Object-Oriented Programming (OOP)** concepts, event-driven programming, and modular software design.

---

## Features

- **Vehicle Management**: add, update, and list vehicles.
- **Client Management**: register and update clients.
- **Rental Process**: create and manage rental contracts.
- **Return Process**: handle returns and calculate rental fees.
- **Basic Validation**: availability, dates, and consistency checks.
- Modular design with separate classes for `Vehiculo`, `Cliente`, `Arriendo`, and `Devolucion`.

---

## Project Structure

- `Vehiculo.java` → represents a vehicle (attributes, availability).
- `Cliente.java` → represents a customer.
- `Arriendo.java` → handles rental contracts (start, duration, cost).
- `Devolucion.java` → handles rental returns and payments.
- `Main.java` → entry point, simulates user interactions.
- `module-info.java` → Java module configuration.

---

##  Requirements

- Java 17 or later
- Maven or Gradle for build automation (Optional)

---

## How to Run

### Option A: Compile & run manually
```bash
javac *.java
java Main
