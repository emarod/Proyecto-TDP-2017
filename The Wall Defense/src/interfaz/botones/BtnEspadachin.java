package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Espadachin;
import jugador.Jugador;

public class BtnEspadachin extends BtnJugador {
	
	public BtnEspadachin(Escenario e) {
		super(e);
		player=new Jugador(null, 2, new Espadachin());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/JonSnow.gif")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}

}
