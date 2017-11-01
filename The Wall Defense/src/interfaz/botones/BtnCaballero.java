package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Caballero;
import jugador.Jugador;
import mapa.Celda;

public class BtnCaballero extends BtnJugador{
	
	protected static final long serialVersionUID = 1L;

	public BtnCaballero(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Jugador(c, 2, new Caballero());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/lannister.png")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}

}
