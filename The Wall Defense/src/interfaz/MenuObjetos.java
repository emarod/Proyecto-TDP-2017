package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.Director;
import interfaz.botones.BtnBarricada;
import interfaz.botones.BtnBomba;
import mapa.Mapa;

/*
* Clase MenuPowerups.
* Clase encargada de desplegar el menu de power ups.
*/

public class MenuObjetos extends JPanel {

	// Atributos locales.
	protected JLabel personaje;
	protected Mapa mapa;
	protected Escenario escenario;
	protected static final long serialVersionUID = 1L;
	protected JPanel botonera;
	protected BtnBarricada barricada;
	protected BtnBomba bomba;

	// Constructor.
	public MenuObjetos(Escenario escenario) {
		this.escenario = escenario;
		this.setLayout(new FlowLayout());
		this.setBounds(76, 0, 300, 200);
		this.setBackground(Color.BLACK);
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		barricada = new BtnBarricada(this.escenario);
		bomba = new BtnBomba(this.escenario);

		barricada.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= barricada.getObjeto().getCosto()) {
					Director.getPartida().quitarDinero(barricada.getObjeto().getCosto());
					barricada.crearObjeto();
				}
				if (Director.getPartida().getDinero() < barricada.getObjeto().getCosto()) {
					barricada.setEnabled(false);
				}
				chequear();
				escenario.getDinero().actualizar();

			}

		});

		bomba.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= bomba.getObjeto().getCosto()) {
					Director.getPartida().quitarDinero(bomba.getObjeto().getCosto());
					bomba.crearObjeto();
				}
				if (Director.getPartida().getDinero() < bomba.getObjeto().getCosto()) {
					bomba.setEnabled(false);
				}
				chequear();
				disable();
				escenario.getDinero().actualizar();

			}

		});

		agregarBoton(barricada);
		agregarBoton(bomba);

	}

	public void agregarBoton(JButton boton) {
		this.add(boton);
	}

	public void chequear() {

		if (Director.getPartida().getDinero() < 10) {
			barricada.deshabilitar();
		}
		if (Director.getPartida().getDinero() < 15) {
			bomba.deshabilitar();
		}

		if (!barricada.isEnabled()) {
			escenario.getMenu().chequear();
		}
	}

	@Override
	public void disable() {
		if (Director.getPartida().getDinero() < 25) {
			escenario.getMenu().chequear();
		}
	}

}
