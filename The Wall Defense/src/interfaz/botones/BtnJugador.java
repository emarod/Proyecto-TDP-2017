package interfaz.botones;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import interfaz.Escenario;
import jugador.Jugador;

/*
 * Clase abstracta BtnJugador.
 * Clase que generaliza el comportamiento de un boton para el despliegue de un jugador.
 */

public abstract class BtnJugador extends JButton{
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Escenario stage;
	protected Jugador player;
	
	//Constructor.
	public BtnJugador(Escenario e) {
		stage=e;
		this.setSize(80,79);
		this.setBorderPainted(true);
		this.setContentAreaFilled(false);
		this.setOpaque(true);
		this.setBackground(Color.BLACK);

		this.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						create();
					}
				}
		);
	}
	
	//Metodos abstractos.
	public abstract void create();

}
