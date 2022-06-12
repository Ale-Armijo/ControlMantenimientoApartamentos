package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaInvalidaException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;

public class Empleado extends ObjetoConNombre{
	private String dni;
	private String email;
	private byte sueldoPorHora;
	private String pass;
	private boolean activo;

	/**
	 * Este constructor va a persistir en BD el usuario que estoy creando.
	 * 
	 * @param nombre nombre del usuario
	 * @param email  email del usuario
	 * @param pass   password del usuario
	 * @param activo true si estÃ¡ activo, false si no lo estÃ¡
	 * @throws SQLException
	 * @throws ContrasegnaInvalidaException
	 * @throws ContrasegnaIncorrectaException
	 */
	public Empleado(String nombre, String email, String pass, boolean activo)
			throws SQLException, ContrasegnaInvalidaException {
		// Proteger los setters
		if (!isPassValid(pass)) {
			throw new ContrasegnaInvalidaException("La contraseña debe tener al menos 3 caracteres.");
		}
		// Primero, intentamos insertar el usuario en la base de datos
		// OJO, en la consulta se usan los argumentos, no las variables internas
		// (NO PONGAIS THIS), porque las variables internas todavia no estan rellenas

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"insert into empleado values('" + nombre + "','" + email + "','" + pass + "'," + activo + ")") > 0) {
			// Solo si todo ha ido bien insertando, se modifican las variables internas
			super.setNombre(nombre);
			this.email = email;
			this.pass = pass;
			this.activo = activo;
		} else {
			// Si no se ha podido insertar, lanzo un error: Algo ha ido mal.
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar.");
		}
		ConexionBD.desconectar();
	}

	public Empleado(String dni, String contrasegna) throws SQLException, ContrasegnaIncorrectaException,
			UsuarioNoExisteException, ContrasegnaInvalidaException {

		// Proteger los setters
		if (!isPassValid(contrasegna)) {
			throw new ContrasegnaInvalidaException("La contraseña debe tener al menos 3 caracteres.");
		}

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from empleado where dni='" + dni + "'");
		// Aqui podemos usar if en vez de while porque si el email esta, solo va a estar
		// una vez, porque es la PK
		if (cursor.next()) {
			this.pass = cursor.getString("contrasena");
			if (!this.pass.equals(contrasegna)) {
				ConexionBD.desconectar();
				throw new ContrasegnaIncorrectaException("La contraseña no es correcta.");
			}
			this.email = cursor.getString("email");
			super.setNombre(cursor.getString("nombre"));
			this.activo = cursor.getBoolean("activo");
		} else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ese DNI en la BD");
		}
		ConexionBD.desconectar();
	}

	protected Empleado(String email) throws SQLException, UsuarioNoExisteException {

		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from empleado where dni='" + dni + "'");
		// Aqui podemos usar if en vez de while porque si el email esta, solo va a estar
		// una vez, porque es la PK
		if (cursor.next()) {
			this.pass = cursor.getString("pass");
			this.email = cursor.getString("email");
			super.setNombre(cursor.getString("nombre"));
			this.activo = cursor.getBoolean("activo");
		} else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ese email en la BD");
		}
		ConexionBD.desconectar();
	}

	public Empleado(String string, String string2, String string3, short s, LocalDate of, LocalDateTime now,
			LocalTime now2) {
		
	}

	/**
	 * Este setter persiste los cambios en la variable nombre
	 * @param nombre el nuevo nombre del usuario
	 * @throws SQLException
	 */
	public void setNombre(String nombre) throws SQLException {
		// Lo primero siempre actualizar el valor en BD, por si falla para no hacerlo
		// en java.
		Statement smt = ConexionBD.conectar();
		// OJO usar el argumento para la consulta.
		// Si usas el this, te quedas con el valor antiguo
		// Para buscar la PK siempre usar el this, para que encuentre el valor actual
		if (smt.executeUpdate("update empleado set nombre='" + nombre + "' where email='" + this.email + "'") > 0) {
			// Solo modificamos si todo ha ido bien actualizando
			super.setNombre(nombre);
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el nombre");
		}
		ConexionBD.desconectar();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update empleado set email='" + email + "' where email='" + this.email + "'") > 0) {
			this.email = email;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el email");
		}
		ConexionBD.desconectar();
	}

	public String getPass() {
		return pass;
	}

	/*
	 * EJERCICIO PARA EL MARTES 3 DE MAYO: PROTEGER LA VARIABLE PASS PARA QUE NO
	 * PUEDA TENER MENOS DE 3 LETRAS
	 */

	public static boolean isPassValid(String pass) {
		try {
			if (pass.length() < 3) {
				return false;
			} else {
				return true;
			}
		} catch (NullPointerException e) {
			return false;
		}

	}

	public void setPass(String pass) throws SQLException, ContrasegnaInvalidaException {
		// Proteger los setters
		if (!isPassValid(pass)) {
			throw new ContrasegnaInvalidaException("La contraseña debe tener al menos 3 caracteres.");
		}

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update empleado set pass='" + pass + "' where email='" + this.email + "'") > 0) {
			this.pass = pass;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el password");
		}
		ConexionBD.desconectar();
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("update empleado set activo=" + activo + " where email='" + this.email + "'") > 0) {
			this.activo = activo;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido cambiar el boolean activo.");
		}
		ConexionBD.desconectar();
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + super.getNombre() + ", email=" + email + " activo=" + activo + "]";
	}

}
