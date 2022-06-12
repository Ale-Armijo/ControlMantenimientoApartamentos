package componentesvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class BotonAzul extends BotonVerde {

	public BotonAzul(String m) {
		super(m);
		estilosPorDefecto();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Color.BLUE);
				setBackground(Color.CYAN);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}
		});
		
	
	}
	
	
	
	private void estilosPorDefecto() {
		this.setForeground(Color.CYAN);
		this.setBackground(Color.BLUE);
	}
}
