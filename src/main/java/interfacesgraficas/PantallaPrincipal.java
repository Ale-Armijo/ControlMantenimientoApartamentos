package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;

import clases.Alojamiento;
import utils.ConexionBD;

public class PantallaPrincipal extends JPanel{
	Ventana ventana;
	
	public PantallaPrincipal(Ventana v) throws SQLException{
		ventana = v;
		setLayout(new BorderLayout());
		this.setBackground(new Color(227,218,201));
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("select * from alojamiento");
		String nombre;
		String ubicacion;
		byte banio;
		List<String> list = new LinkedList<String>();
		while (cursor.next()) {
			nombre = cursor.getString("nombre");
			banio = cursor.getByte("num_banos");
			ubicacion = cursor.getString("ubicacion");
			Alojamiento a = new Alojamiento(ubicacion, banio, nombre);
			list.add(a.toString());
		}
		String[] alojamientos = new String[list.size()];
		int i = 0;
		for(String ap : list) {
			alojamientos[i] = ap;
			i++;
		}
		
		final JList<String> lista = new JList<String>(alojamientos);
		lista.addMouseListener(new MouseAdapter() {
		     public void mouseClicked(MouseEvent e) {
		         if (e.getClickCount() == 2) {
		        	 try {
						ventana.irAPantallaAlojamiento(lista.getSelectedValue());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
		          }
		     }
		 });
		add(lista, BorderLayout.NORTH);
		
		ConexionBD.desconectar();
	}
}
