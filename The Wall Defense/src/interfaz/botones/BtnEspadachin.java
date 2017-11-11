package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import interfaz.Escenario;
import jugador.Espadachin;
import jugador.Jugador;
import mapa.Celda;

/*
 * Clase BtnEspadachin.
 * Clase encargada del boton para el despliegue de un espadachin.
 */

public class BtnEspadachin extends BtnJugador {
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	
	//Constructor
	public BtnEspadachin(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Jugador(c, 2, new Espadachin());
		imagen=new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/jonsnow.png"));
		info=new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/espadachindescripcion.png"));
		this.setIcon(imagen);
	};
	
	//Metodos heredados.
	public void create() {
		stage.getMapa().crearJugador(player);
	}
	
	public void oyente() {
		
		this.addMouseListener(
				new MouseAdapter() {

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
