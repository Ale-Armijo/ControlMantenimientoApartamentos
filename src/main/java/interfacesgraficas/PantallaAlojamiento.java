package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import clases.Empleado;
import componentesvisuales.BotonAzul;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaInvalidaException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;

public class PantallaAlojamiento extends JPanel{
	protected Ventana ventana;
	private String alojamiento;
	
	public PantallaAlojamiento(Ventana v, String a) throws SQLException {
		this.ventana = v;
		this.alojamiento = a;
		setLayout(null);
		this.setBackground(new Color(227,218,201));
		
		String nombreAlojamiento = obtenerNombreAlojamiento(alojamiento);
		
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from Alojamiento a, Salida s where a.nombre='" + 
		nombreAlojamiento + "' and a.id=s.alojamiento_id");

		establecerEtiqueta("PROXIMA SALIDA", 27, 10, 11, 480, 44);
		
		String mascotas;
		String ninos;
		if(cursor.next()) {
			establecerEtiqueta("Numero de personas: "+cursor.getString("num_personas"), 20, 10, 100, 480, 44);
			if(cursor.getString("ninos").equals("0")) {
				ninos = "SI";
			}else {
				ninos = "NO";
			}
			if(cursor.getString("mascotas").equals("0")) {
				mascotas = "SI";
			}else {
				mascotas = "NO";
			}
			establecerEtiqueta("Niños: "+ninos, 20, 10, 130, 480, 44);
			establecerEtiqueta("Mascotas: "+mascotas, 20, 10, 160, 480, 44);
		}
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla("principal");
			}
		});
		botonAtras.setBounds(200, 300, 102, 33);
		this.add(botonAtras);
	}
	
	public void establecerEtiqueta(String etiqueta, int tam, int x, int y, int w, int h) {
		JLabel etiquetaTitulo = new JLabel(etiqueta);
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Miriam Libre", Font.ITALIC, tam));
		etiquetaTitulo.setBounds(x, y, w, h);
		add(etiquetaTitulo);
	}
	
	public static String obtenerNombreAlojamiento(String alojamiento) {
		String[] partes = alojamiento.split(",");
		return partes[0];
 	}
	
}
