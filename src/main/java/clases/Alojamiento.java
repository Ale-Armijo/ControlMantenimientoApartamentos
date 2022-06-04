package clases;

public class Alojamiento extends ObjetoConNombre{
	private String ubicacion;
	private byte banio;
	private Salida ultimaSalida;
	
	public Alojamiento(String ubicacion, byte banio,String nombre) {
		super(nombre);//viene de ObjetoConNombre.
		this.ubicacion = ubicacion;
		this.banio = banio;
		
	}
	public Alojamiento(String nombre)	{	
		super(nombre);
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public byte getBanio() {
		return banio;
	}
	public void setBanio(byte banio) {
		this.banio = banio;
	}
	public Salida getUltimaSalida() {
		return ultimaSalida;
	}
	public void setUltimaSalida(Salida ultimaSalida) {
		this.ultimaSalida = ultimaSalida;
	}
	
}
