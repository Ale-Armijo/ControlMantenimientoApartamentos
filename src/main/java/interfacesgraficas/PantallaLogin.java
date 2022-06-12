package interfacesgraficas;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import clases.Empleado;
import componentesvisuales.BotonAzul;
import componentesvisuales.BotonRojo;
import componentesvisuales.BotonVerde;
import excepciones.ContrasegnaIncorrectaException;
import excepciones.ContrasegnaInvalidaException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaLogin extends JPanel{
	private Ventana ventana;
	private JTextField campoUsuario;
	private JPasswordField campoContrase�a;
	
	public PantallaLogin(Ventana v){
		this.ventana=v;
		setLayout(null);
		
		JButton botonLogin = new BotonAzul("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dni=campoUsuario.getText();
				String contrase�a= new String(campoContrase�a.getPassword());
				try { 
					ventana.empleadoLogueado=new Empleado(dni, contrase�a);
					JOptionPane.showMessageDialog(ventana, "Bienvenid@ "+ventana.empleadoLogueado.getNombre()
					,"Inicio de sesion correcto",
					JOptionPane.INFORMATION_MESSAGE);
					ventana.irAPantalla("principal");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ContrasegnaIncorrectaException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ventana, e1.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				} catch (UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}catch (ContrasegnaInvalidaException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ventana, e1.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonLogin.setToolTipText("Pincha aqu\u00ED para iniciar sesi\u00F3n");
		
		botonLogin.setBounds(95, 179, 160, 44);
		this.add(botonLogin);
		
		JLabel etiquetaTitulo = new JLabel("Iniciar Sesi\u00F3n");
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Miriam Libre", Font.ITALIC, 27));
		etiquetaTitulo.setBounds(10, 11, 480, 44);
		add(etiquetaTitulo);
		
		JLabel etiquetaUsuario = new JLabel("Usuario");
		etiquetaUsuario.setBounds(95, 88, 46, 14);
		add(etiquetaUsuario);
		
		JLabel labelContrase�a = new JLabel("Contrase\u00F1a");
		labelContrase�a.setHorizontalAlignment(SwingConstants.CENTER);
		labelContrase�a.setBounds(95, 129, 78, 14);
		add(labelContrase�a);
		
		campoUsuario = new JTextField();
		campoUsuario.setBounds(184, 85, 242, 20);
		add(campoUsuario);
		campoUsuario.setColumns(10);
		
		campoContrase�a = new JPasswordField();
		campoContrase�a.setEchoChar('*');
		campoContrase�a.setBounds(183, 126, 243, 20);
		add(campoContrase�a);
		
		JButton BotonSalir = new BotonAzul("Salir");
		BotonSalir.setBounds(200, 251, 102, 33);
		add(BotonSalir);
	}
}
