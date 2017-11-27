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
	protected boolean activado;

	// Constructor.
	public MenuObjetos() {
		this.setLayout(new GridLayout(4, 1));
		this.setBounds(76, 0, 300, 200);
		this.setBackground(Color.BLACK);
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		barricada = new BtnBarricada();
		barricada.oyente();

		barricada.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (barricada.isEnabled() && activado) {
					if (Director.getPartida().getDinero() >= barricada.costo) {
						Director.getPartida().quitarDinero(barricada.costo);
						Director.getGui().getAcumulados().acumularBarricada();
					}
					if (Director.getPartida().getDinero() < barricada.costo) {
						barricada.setEnabled(false);
					}
					Director.getGui().getDinero().actualizar();

				}
			}

		});

		trampa = new BtnTrampa();
		trampa.oyente();

		trampa.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (trampa.isEnabled() && activado) {
					if (Director.getPartida().getDinero() >= trampa.costo) {
						Director.getPartida().quitarDinero(trampa.costo);
						Director.getGui().getAcumulados().acumularTrampa();
					}
					if (Director.getPartida().getDinero() < barricada.costo) {
						trampa.setEnabled(false);
					}
					Director.getGui().getDinero().actualizar();

				}
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

	public void deshabilitarCompra() {
		trampa.deshabilitar();
		barricada.deshabilitar();

	}

	public void habilitarCompra() {
		trampa.habilitar();
		barricada.habilitar();
	}

	public void setActivado(boolean a) {
		activado = a;
	}

}
