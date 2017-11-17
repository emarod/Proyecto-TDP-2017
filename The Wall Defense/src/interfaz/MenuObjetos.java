package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.Director;
import interfaz.botones.BtnBarricada;
import interfaz.botones.BtnTrampa;
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
	protected BtnTrampa trampa;

	// Constructor.
	public MenuObjetos(Escenario escenario) {
		this.escenario = escenario;
		this.setLayout(new GridLayout(4, 1));
		this.setBounds(76, 0, 300, 200);
		this.setBackground(Color.BLACK);
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		barricada = new BtnBarricada(this.escenario);
		barricada.oyente();

		barricada.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= barricada.costo) {
					Director.getPartida().quitarDinero(barricada.costo);
					barricada.crearObjeto();
				}
				if (Director.getPartida().getDinero() < barricada.costo) {
					barricada.setEnabled(false);
				}
				escenario.getDinero().actualizar();

			}

		});

		trampa = new BtnTrampa(this.escenario);
		trampa.oyente();

		trampa.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (Director.getPartida().getDinero() >= trampa.costo) {
					Director.getPartida().quitarDinero(trampa.costo);
					trampa.crearObjeto();
				}
				if (Director.getPartida().getDinero() < barricada.costo) {
					trampa.setEnabled(false);
				}
				escenario.getDinero().actualizar();

			}

		});

		agregarBoton(barricada);
		agregarBoton(trampa);

	}

	public void agregarBoton(JButton boton) {
		this.add(boton);
	}

	public void chequear() {

		if (Director.getPartida().getDinero() < barricada.costo) {
			barricada.deshabilitar();
		}

		if (Director.getPartida().getDinero() < trampa.costo) {
			trampa.deshabilitar();
		}

	}

}
