package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Arquero;
import jugador.Jugador;
import mapa.Celda;

public class BtnArquero extends BtnJugador {
	
	protected static final long serialVersionUID = 1L;

	public BtnArquero(Escenario e) {
		super(e);
		Celda [] c = new Celda[4];
		player=new Jugador(c, 2, new Arquero());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/personajes/ygritte2.png")));
	}

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}
	
}