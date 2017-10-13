package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import interfaz.Escenario;
import jugador.Arquero;
import jugador.Jugador;

public class BtnArquero extends BtnJugador {
	
	public BtnArquero(Escenario e) {
		super(e);
		player=new Jugador(null, 2, new Arquero());
		this.setIcon(new ImageIcon(this.getClass().getResource("/resources/dinamic/Ygritte.gif")));
	};

	public void create() {
		stage.getMapa().crearJugador(player);		
		
	}
	
}
