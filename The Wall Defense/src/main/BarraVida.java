package main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Controladores.Director;
import mapa.Celda;

public class BarraVida implements Observer {

	protected JLabel vida;
	protected JLabel daño;
	protected int indice;
	protected Unidad unidad;

	public BarraVida(Unidad u) {
		unidad = u;
		Celda celda = u.getCelda();
		int x = celda.getPosX();
		int y = celda.getPosY();
		daño = new JLabel(new ImageIcon(getClass().getResource("/resources/static/barra_vida/daño.png")));
		daño.setBounds(x * 64, y * 64 - 14, 32, 7);
		vida = new JLabel(new ImageIcon(getClass().getResource("/resources/static/barra_vida/vida.png")));
		vida.setBounds(x * 64, y * 64 - 14, 32, 7);
		indice = Math.round(32 / unidad.getVida());
		Director.getGui().getEscenario().agregar(daño, 10);
		Director.getGui().getEscenario().agregar(vida, 11);
		u.observar(this);

	}

	public void destruir() {
		Director.getGui().getEscenario().remove(daño);
		Director.getGui().getEscenario().remove(vida);
		daño.setIcon(null);
		vida.setIcon(null);
		unidad = null;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("DEAD")) {
			destruir();
		}
		if (arg1.equals("DAÑO") | arg1.equals("MOVE")) {
			int x = unidad.getCelda().getPosX();
			int y = unidad.getCelda().getPosY();
			vida.setBounds(x * 64, y * 64, indice * unidad.getVida(), 7);
			daño.setBounds(x * 64, y * 64, 32, 7);
		}

	}

}
