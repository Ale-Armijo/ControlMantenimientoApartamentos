package clases;

public class Apartamento extends Alojamiento{
	private byte numeroHabitaciones;

	public Apartamento(String ubicacion, byte banio, String nombre, byte numeroHabitaciones) {
		super(ubicacion, banio, nombre);
		this.numeroHabitaciones = numeroHabitaciones;
	}

	public Apartamento(String ubicacion, byte banio, String nombre) {
		super(ubicacion, banio, nombre);
	}

	public byte getNumeroHabitaciones() {
		return numeroHabitaciones;
	}

	public void setNumeroHabitaciones(byte numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}
	
}
