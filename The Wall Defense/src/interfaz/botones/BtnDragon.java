package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import interfaz.Escenario;
import jugador.Dragon;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase BtnDrgon.
 * Clase encargada del boton para el despliegue de un dragon.
 */

public class BtnDragon extends BtnJugador {
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;

	//Constructor.
	public BtnDragon(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Jugador(c, 2, new Dragon());
		imagen=new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragon.png"));
		info=new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/dragondescripcion.png"));
		this.setIcon(imagen);
	}
	
	//Metodos heredados.
	public void create() {
		stage.getMapa().crearJugadorLargo(player);		
		
	}
	
	public void oyente() {
		
		this.addMouseListener(
				new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						setIcon(imagen);
					}
					
					public void mousePressed(MouseEvent e) {
						setIcon(imagen);
					}
					
					public  void mouseEntered(MouseEvent evento) {
						setIcon(info);

					}
					
					public  void mouseExited(MouseEvent evento) {
						setIcon(imagen);

					}
					
				}
			);
	}

}
