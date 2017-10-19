package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Arquero;
import jugador.Jugador;

public class BtnArquero extends BtnJugador {
	
<<<<<<< HEAD
	protected static final long serialVersionUID = 1L;
=======
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
>>>>>>> refs/remotes/origin/hilos

	public BtnArquero(Escenario e) {
		super(e);
		player=new Jugador(null, 2, new Arquero());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/ygritte.gif")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}
	
}
