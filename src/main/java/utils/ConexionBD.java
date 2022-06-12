package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConexionBD {
	//He cambiado la base de datos para que me funcione a mi ya que tengo una contraseña diferente y nombres diferentes
	private final static String cadenaConexion = "jdbc:mysql://localhost:3306/proyecto_cenec";
	private final static String usuarioBD = "root";
	private final static String passwordBD = "MySQL2022";
	private static Connection conexion; // singleton, solo puede instanciarse una vez.

	public static Statement conectar() {
		try {
			if (conexion == null) {//si la conexion no esta instanciada la instancia.
				conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);//realiza la conexion segun parametros.
			}
			return conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void desconectar() {
		if(conexion!=null) {
			try {
				conexion.close();
				conexion=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
