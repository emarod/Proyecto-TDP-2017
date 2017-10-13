package interfaz.botones;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import interfaz.Escenario;
import jugador.Jugador;

public abstract class BtnJugador extends JButton{
	protected Escenario stage;
	protected Jugador player;
	
	public BtnJugador(Escenario e) {
		stage=e;
		this.setSize(32,32);
		this.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						create();
					}
				}
		);
	}
	
	public abstract void create();

}