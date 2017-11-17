package terreno;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Controladores.Director;

public class OyenteTerreno extends MouseAdapter {

	@Override
	public void mousePressed(MouseEvent e) {
		JLabel graficoTerreno = (JLabel) e.getSource();
		JLabel celdaLabel = Director.getMapa().getCeldaLabel();

		if (celdaLabel == null) {
			graficoTerreno.setBorder(new LineBorder(new Color(0, 0, 0)));
			Director.getMapa().setCeldaLabel(graficoTerreno);
			Director.getMapa().ver();

		}
		else {
			celdaLabel.setBorder(null);
			graficoTerreno.setBorder(new LineBorder(new Color(0, 0, 0)));
			Director.getMapa().setCeldaLabel(graficoTerreno);
			Director.getMapa().ver();

		}
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
