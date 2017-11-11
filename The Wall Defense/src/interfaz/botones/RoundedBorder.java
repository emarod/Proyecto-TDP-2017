package interfaz.botones;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

/*
 * Clase RoundedBorder.
 * Clase encargada de generar un borde especial a los botones.
 */

public class RoundedBorder implements Border {
	
	//Atributos locales.
    protected int radius;
    
    //Constructor.
    RoundedBorder(int radius) {
        this.radius = radius;
    }
    
    //Metodos heredados.
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    public boolean isBorderOpaque() {
        return true;
    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }

}