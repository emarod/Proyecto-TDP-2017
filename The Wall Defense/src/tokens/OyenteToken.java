package tokens;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Controladores.Director;
import main.CONFIG;
import mapa.Celda;
import terreno.OyenteTerreno;

public class OyenteToken extends MouseAdapter {

	@Override
	public void mousePressed(MouseEvent e) {
		int x_mouse = Director.getMapa().get_x_mouse();
		int y_mouse = Director.getMapa().get_y_mouse();
		int x_celd = Math.round(x_mouse / 64);
		int y_celd = Math.round(y_mouse / 64);
		Celda celda = Director.getCelda(x_celd, y_celd);
		Token token = (Token) celda.getObjects()[CONFIG.PROFUNDIDAD_TOKEN];
		if (token != null) {
			token.aplicar();
		}
		JLabel graficoTerreno = (JLabel) e.getSource();
		OyenteTerreno oyenteTerreno = new OyenteTerreno();
		graficoTerreno.addMouseListener(oyenteTerreno);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel graficoTerreno = (JLabel) e.getSource();

		JLabel celdaLabel = Director.getMapa().getCeldaLabel();
		Director.getMapa().set_x_mouse(graficoTerreno.getX());
		Director.getMapa().set_y_mouse(graficoTerreno.getY());
		if (graficoTerreno != celdaLabel) {
			graficoTerreno.setBorder(new LineBorder(new Color(255, 0, 0)));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JLabel graficoTerreno = (JLabel) e.getSource();
		JLabel celdaLabel = Director.getMapa().getCeldaLabel();
		if (graficoTerreno != celdaLabel) {
			graficoTerreno.setBorder(null);
		}
	}

}
