package componentesvisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonVerde extends BotonRojo{
	public BotonVerde(String m) {
		super(m);
		estilosPorDefecto();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(150,200, 150));
				setBackground(new Color( 0,50, 0));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			
			
			@Override
			public void mouseExited(MouseEvent e) {
				estilosPorDefecto();
			}
		});
		
	}
	
	
	
	private void estilosPorDefecto() {
		this.setForeground(new Color(0, 102, 153));
		this.setBackground(new Color(102, 255, 102));
	}
}
