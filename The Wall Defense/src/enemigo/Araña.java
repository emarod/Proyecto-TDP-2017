package enemigo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Celda;

public class Araña extends Enemigo {

	// Constructor.
	public Araña(Celda c) {
		super(c);
		puntaje = 100;
		velocidad = 50;
		vida = 2;
		daño = 4;
		graficos = new Icon[1];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/dinamic/personajes/araña_caminando.gif"));
	}

	// Metodos heredados.

	@Override
	public void setGrafico(JLabel grafico) {
		ImageIcon imagen = new ImageIcon(
				this.getClass().getResource("/resources/dinamic/personajes/araña_caminando.gif"));
		graph = 0;
		grafico.setIcon(imagen);
	}

	public void setGraficos(Icon[] graficos, JLabel grafico) {

	}

	@Override
	public Enemigo clone(Celda c) {
		// Profundidad 1 predeterminada. Retorna una unidad de mismo tipo.
		Enemigo clon = new Araña(c);
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
		guardarEstado("ARAÑA");
	}

	@Override
	public void regresarInicio() {
		reset("ARAÑA");

	}

}