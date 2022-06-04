package clases;

public class Empleado extends ObjetoConNombre{
	private String dni;
	private byte sueldoPorHora;
	private String email;
	private String contraseña;
	
	public Empleado(String nombre, String dni, byte sueldoPorHora, String email, String contraseña) {
		super(nombre);
		this.dni = dni;
		this.sueldoPorHora = sueldoPorHora;
		this.email = email;
		this.contraseña = contraseña;
	}
	public Empleado(String nombre) {
		super(nombre);
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public byte getSueldoPorHora() {
		return sueldoPorHora;
	}
	public void setSueldoPorHora(byte sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}
