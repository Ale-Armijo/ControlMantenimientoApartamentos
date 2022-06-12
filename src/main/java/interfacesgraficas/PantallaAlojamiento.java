package interfacesgraficas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Empleado;
import componentesvisuales.BotonAzul;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaInvalidaException;
import excepciones.UsuarioNoExisteException;

public class PantallaAlojamiento extends JPanel{
	Ventana ventana;
	
	public PantallaAlojamiento(Ventana v) {
		this.ventana = v;
		setLayout(null);
		this.setBackground(new Color(227,218,201));
		
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
}
