package clases;

import java.sql.SQLException;

public class ObjetoConNombre {
	private String nombre;

	public ObjetoConNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public ObjetoConNombre() {
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SQLException{
		this.nombre = nombre;
	}
	
}
