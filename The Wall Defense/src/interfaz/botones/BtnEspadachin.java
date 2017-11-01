package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Espadachin;
import jugador.Jugador;
import mapa.Celda;

public class BtnEspadachin extends BtnJugador {
	
	protected static final long serialVersionUID = 1L;
	
	public BtnEspadachin(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Jugador(c, 2, new Espadachin());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/jonsnow.png")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);
	}

}
