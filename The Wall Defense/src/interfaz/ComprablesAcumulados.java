package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
* Clase ComprablesAcumulados.
* Clase encargada de desplegar el menu de los objetos comprables acumulados.
*/
public class ComprablesAcumulados extends JPanel {

	/**
	 * Atributos Locales
	 */
	private static final long serialVersionUID = 1L;
	protected Escenario escenario;
	protected JButton barricada;
	protected JButton bomba;
	protected int cantBomba, cantBarricada;
	protected JLabel bombasLeft, barricadasLeft;

	public ComprablesAcumulados(Escenario esc) {
		this.escenario = esc;
		this.setLayout(new FlowLayout());
		this.setBounds(76, 0, 300, 200);
		this.setBackground(Color.BLACK);
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		barricada = new JButton();
		bomba = new JButton();

		bombasLeft = new JLabel("0");
		barricadasLeft = new JLabel("0");

		barricada.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
			}

		});

		bomba.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {

			}

		});

		agregarBoton(barricada);
		agregarBoton(bomba);

	}

	public void agregarBoton(JButton boton) {
		this.add(boton);
	}

	public void chequear() {

		if (cantBarricada < 1) {
			barricada.setEnabled(false);
		}
		if (cantBomba < 1) {
			bomba.setEnabled(false);
		}

	}
}
