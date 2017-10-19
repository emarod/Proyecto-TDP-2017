<<<<<<< HEAD
package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Espadachin;
import jugador.Jugador;

public class BtnEspadachin extends BtnJugador {
	
	protected static final long serialVersionUID = 1L;

	public BtnEspadachin(Escenario e) {
		super(e);
		player=new Jugador(null, 2, new Espadachin());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/JonSnow.gif")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}

}
=======
package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Espadachin;
import jugador.Jugador;

public class BtnEspadachin extends BtnJugador {
	
	public BtnEspadachin(Escenario e) {
		super(e);
		player=new Jugador(null, 2, new Espadachin());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/jon_snow.gif")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}

}
>>>>>>> refs/remotes/origin/hilos
