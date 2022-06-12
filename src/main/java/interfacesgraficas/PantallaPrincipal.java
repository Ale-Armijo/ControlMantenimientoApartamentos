package interfacesgraficas;

import javax.swing.JPanel;

public class PantallaPrincipal extends JPanel{
	private Ventana ventana;
	
	public PantallaPrincipal(Ventana v) {
		this.ventana = v;
		setLayout(null);
	}
}
