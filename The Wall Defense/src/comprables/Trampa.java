package comprables;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Rock
 * Clase que determina como esta compuesta y como se comporta una roca.
 */

public class Trampa extends ComprableVida {

	// Constructor.
	public Trampa(Celda c) {
		super(c);
		vida = 3;
		graficos = new Icon[3];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa1.png"));
		graficos[1] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa2.png"));
		graficos[2] = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa3.png"));
		setGrafico(2);
		costo = 5;
	}

	// Metodos locales.
	public int getResistencia() {
		return vida;
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	// Metodos heredados.

	public void setGrafico(int i) {
		grafico.setIcon(graficos[i]);
	}

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/static/trampa/trampa1.png"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void playSound() {
		Director.getBancoRecursos().playBarricada();
	}

	@Override
	public Comprable clone(Celda c) {
		Comprable clon = new Trampa(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitComprable(this);
	}
}