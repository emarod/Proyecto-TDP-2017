package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Arquero;
import jugador.Dragon;
import jugador.Jugador;

public class BtnArquero extends BtnJugador {
	
	protected static final long serialVersionUID = 1L;

	public BtnArquero(Escenario e) {
		super(e);
		/*
		player=new Jugador(null, 2, new Arquero());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/ygritte/ygritte_atacando_10fps.gif")));
		 */
		player=new Jugador(null, 2, new Dragon());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/dragon_atacando.gif")));
	}

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}
	
}