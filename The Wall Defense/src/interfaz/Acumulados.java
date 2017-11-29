package interfaz;

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
import interfaz.botones.BtnBarril;
import interfaz.botones.BtnBomba;
import interfaz.botones.BtnTrampa;

/*
* Clase ComprablesAcumulados.
* Clase encargada de desplegar el menu de los objetos comprables acumulados.
*/
public class Acumulados extends JPanel {

	/**
	 * Atributos Locales
	 */
	private static final long serialVersionUID = 1L;
	protected BtnBarricada barricada;
	protected BtnBomba bomba;
	protected BtnBarril barril;
	protected BtnTrampa trampa;
	protected int cantBomba, cantBarricada, cantTrampa, cantBarril;
	protected JLabel bombasLeft, barricadasLeft, trampasLeft, barrilLeft;
	protected Icon iconoBomba, iconoBarricada, iconoTrampa, iconoBarril;
	protected JLabel label;
	protected JPanel barricadapanel;

	public Acumulados() {
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(10, 100));
		this.setBackground(Color.BLACK);
		cantBomba = 2;
		cantBarricada = 0;
		armarBotonera();
	}

	// Metodos locales.
	private void armarBotonera() {

		barricada = new BtnBarricada();
		bomba = new BtnBomba();
		trampa = new BtnTrampa();
		barril = new BtnBarril();

		iconoBomba = new ImageIcon(this.getClass().getResource("/resources/static/botones/objetos/bombaacumulada.png"));
		iconoBarricada = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/objetos/barricadaacumulada.png"));
		iconoTrampa = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/objetos/trampaacumulada.png"));
		iconoBarril = new ImageIcon(
				this.getClass().getResource("/resources/static/botones/objetos/barrilacumulada.png"));

		bombasLeft = new JLabel("" + cantBomba);
		barricadasLeft = new JLabel("" + cantBarricada);
		trampasLeft = new JLabel("" + cantTrampa);
		barrilLeft = new JLabel("" + cantBarril);

		configurarLabel(barricadasLeft);
		configurarLabel(bombasLeft);
		configurarLabel(trampasLeft);
		configurarLabel(barrilLeft);

		bomba.setIcon(iconoBomba);
		barricada.setIcon(iconoBarricada);
		trampa.setIcon(iconoTrampa);
		barril.setIcon(iconoBarril);

		barricada.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (cantBarricada > 0) {
					boolean desplego = barricada.crearObjeto();
					if (desplego) {
						cantBarricada--;
						barricadasLeft.setText("" + cantBarricada);
					}

				}

			}

		});

		barril.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (cantBarril > 0) {
					boolean desplego = barril.crearObjeto();
					if (desplego) {
						cantBarril--;
						barrilLeft.setText("" + cantBarril);
					}

				}

			}

		});

		bomba.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (cantBomba > 0) {
					boolean desplego = bomba.crearObjeto();
					if (desplego) {
						cantBomba--;
						bombasLeft.setText("" + cantBomba);
					}

				}
			}

		});

		trampa.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evento) {
				if (cantTrampa > 0) {
					boolean desplego = trampa.crearObjeto();
					if (desplego) {
						cantTrampa--;
						trampasLeft.setText("" + cantTrampa);
					}

				}
			}

		});

		this.add(barrilLeft);
		this.add(barril);
		this.add(bombasLeft);
		this.add(bomba);
		this.add(trampasLeft);
		this.add(trampa);

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
		if (cantTrampa < 1) {
			trampa.setEnabled(false);
		}
		if (cantBarril < 1) {
			barril.setEnabled(false);
		}
	}

	public void acumularBomba() {
		cantBomba++;
		bombasLeft.setText("" + cantBomba);
	}

	public void acumularTrampa() {
		cantTrampa++;
		trampasLeft.setText("" + cantTrampa);
	}

	public void acumularBarricada() {
		cantBarricada++;
		barricadasLeft.setText("" + cantBarricada);
	}

	public void acumularBarril() {
		cantBarril++;
		barrilLeft.setText("" + cantBarril);
	}
}
