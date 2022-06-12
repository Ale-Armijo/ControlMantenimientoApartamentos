package interfacesgraficas;

import java.awt.Cursor;
import java.awt.Image;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Empleado;

public class Ventana extends JFrame{//Frame es el marco
	/** La clave va a ser un nombre que le pongamos a la pantalla, y el valor la pantalla 
	 * con ese nombre**/
	protected Empleado empleadoLogueado;
	private HashMap<String,JPanel> pantallas;
	
	public Ventana() throws SQLException {
		this.pantallas=new HashMap<String,JPanel>();//inicializa el HashMap
		
		this.pantallas.put("login",new PantallaLogin(this));//introduce en el mapa de Pantallas 1 registro con clave login
		this.pantallas.put("principal",new PantallaPrincipal(this));
		this.pantallas.put("alojamiento",new PantallaAlojamiento(this));
		
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		
		//Pantalla completa las dos lineas siguentes
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true);
		
		this.setTitle("GLA Software");
		this.setIconImage(new ImageIcon("./iconos/iconoPrincipal.png").getImage());
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		//this.setAlway	sOnTop(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//cierra por defecto.
		this.setResizable(false);//usuario puede cambiar el tamanio??
		this.setContentPane(this.pantallas.get("login"));//primero aparece el login
		this.setVisible(true);//Frame visible
	}
	
	public void irAPantalla(String nombrePantalla) {
		Iterator it=this.pantallas.values().iterator();
		while(it.hasNext()) {
			JPanel actual=(JPanel)it.next();
			actual.setVisible(false);
		}
		this.pantallas.get(nombrePantalla).setVisible(true);
		this.setContentPane(this.pantallas.get(nombrePantalla));
	}
}
