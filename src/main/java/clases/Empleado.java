package clases;

public class Empleado extends ObjetoConNombre{
	private String dni;
	private byte sueldoPorHora;
	private String email;
	private String contrase�a;
	
	public Empleado(String nombre, String dni, byte sueldoPorHora, String email, String contrase�a) {
		super(nombre);
		this.dni = dni;
		this.sueldoPorHora = sueldoPorHora;
		this.email = email;
		this.contrase�a = contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
}
