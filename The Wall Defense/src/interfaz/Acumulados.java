package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import interfaz.botones.BtnBarricada;
import interfaz.botones.BtnBomba;

/*
* Clase ComprablesAcumulados.
* Clase encargada de desplegar el menu de los objetos comprables acumulados.
*/
public class Acumulados extends JPanel {

	/**
	 * Atributos Locales
	 */
	private static final long serialVersionUID = 1L;
	protected Escenario escenario;
	protected BtnBarricada barricada;
	protected BtnBomba bomba;
	protected int cantBomba, cantBarricada;
	protected JLabel bombasLeft, barricadasLeft;
	protected Icon iconoBomba, iconoBarricada;

	public Acumulados(Escenario esc) {
		this.escenario = esc;
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(10, 50));
		this.setBackground(Color.BLACK);
		cantBomba = 0;
		cantBarricada = 1;
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		barricada = new BtnBarricada(escenario);
		bomba = new BtnBomba(escenario);

		barricada.setBounds(150, 0, 64, 64);

		iconoBomba = new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bombaacumulada.png"));
		iconoBarricada = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/objetos/barricadaacumulada.png"));

		bombasLeft = new JLabel("" + cantBomba);
		barricadasLeft = new JLabel("" + cantBarricada);

		configurarLabel(barricadasLeft);
		configurarLabel(bombasLeft);

		bomba.setIcon(iconoBomba);
		barricada.setIcon(iconoBarricada);

		barricada.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (cantBarricada > 0) {
					barricada.crearObjeto();
					cantBarricada--;
					barricadasLeft.setText("" + cantBarricada);
				}

			}

		});

		bomba.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (cantBomba > 0) {
					bomba.crearObjeto();
					cantBomba--;
					bombasLeft.setText("" + cantBomba);
				}
			}

		});

		configurarBoton(barricada);
		configurarBoton(bomba);
		this.add(barricadasLeft);
		this.add(barricada);
		this.add(bombasLeft);
		this.add(bomba, BorderLayout.NORTH);

	}

	public void configurarBoton(JButton boton) {
		boton.setBackground(Color.BLACK);
		boton.setBorderPainted(false);
		boton.setBorder(new LineBorder(Color.BLACK));
		boton.setFocusPainted(false);
		boton.setContentAreaFilled(false);
		boton.setSize(boton.getIcon().getIconWidth(), boton.getIcon().getIconHeight());
	}

	public void configurarLabel(JLabel label) {

		label.setSize(label.getWidth(), this.getHeight());
		Font auxFont = new Font("ArcadeClassic", Font.CENTER_BASELINE, 50);
		label.setForeground(Color.WHITE);
		label.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
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
