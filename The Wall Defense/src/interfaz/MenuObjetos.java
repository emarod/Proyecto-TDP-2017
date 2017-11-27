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
import interfaz.botones.BtnBarril;
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
	protected BtnBarril barril;
	protected BtnTrampa trampa;
	protected boolean activado;
	protected boolean enPartida;

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

		barril = new BtnBarril();
		barril.oyente();

		barril.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (barril.isEnabled() && activado) {
					if (Director.getPartida().getDinero() >= barril.costo) {
						Director.getPartida().quitarDinero(barril.costo);
						Director.getGui().getAcumulados().acumularBarril();
					}
					if (Director.getPartida().getDinero() < barril.costo) {
						barril.setEnabled(false);
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
		agregarBoton(barril);
		agregarBoton(trampa);

	}

	public void agregarBoton(JButton boton) {
		this.add(boton);
	}

	public void chequear() {

		if (Director.getPartida().getDinero() >= barricada.costo && !enPartida) {
			barricada.habilitar();
		}
		else {
			barricada.deshabilitar();
		}

		if (Director.getPartida().getDinero() >= barril.costo && !enPartida) {
			barril.habilitar();
		}
		else {
			barril.deshabilitar();
		}

		if (Director.getPartida().getDinero() >= trampa.costo && !enPartida) {
			trampa.habilitar();
		}
		else {
			trampa.deshabilitar();
		}

	}

	public void deshabilitarCompra() {
		enPartida = true;
		trampa.deshabilitar();
		barricada.deshabilitar();
		barril.deshabilitar();
	}

	public void habilitarCompra() {
		enPartida = false;
		trampa.habilitar();
		barricada.habilitar();
		barril.deshabilitar();
	}

	public void setActivado(boolean a) {
		activado = a;
	}

}
