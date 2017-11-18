package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class EsqueletoSuicida extends Enemigo {

	// Constructor.
	public EsqueletoSuicida(Celda c) {
		super(c);
		puntaje = 100;
		velocidad = 50;
		vida = 1;
		daño = 1;
		graficos = new Icon[1];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/dinamic/esqueleto_suicida.gif"));
	}

	// Metodos heredados.

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(this.getClass().getResource("/resources/dinamic/esqueleto_suicida.gif"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void setGraficos(Icon[] graficos, JLabel grafico) {

	}

	@Override
	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public Enemigo clone(Celda c) {
		// Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new WhiteWalker(c);
		return clon;
	}

	@Override
	public void playSound() {

	}

	@Override
	public void destruir() {
		super.destruir();
	}

	@Override
	public void guardarInicio() {
		guardarEstado("ESQUELETO");
	}

	@Override
	public void regresarInicio() {
		reset("ESQUELETO");
		careTaker.clearSavepoint();

	}

}
