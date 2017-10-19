package interfaz.botones;

import javax.swing.ImageIcon;

import interfaz.Escenario;
import jugador.Caballero;
import jugador.Jugador;

public class BtnCaballero extends BtnJugador{
	
	protected static final long serialVersionUID = 1L;

	public BtnCaballero(Escenario e) {
		super(e);
		player=new Jugador(null, 2, new Caballero());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/lannister_atacando_8fps.gif")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}

}
