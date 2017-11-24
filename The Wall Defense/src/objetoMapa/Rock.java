package objetoMapa;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import main.CONFIG;
import main.Visitor;
import mapa.Celda;
import objetos.ObjetoVida;
import objetos.Obstaculo;

public class Rock extends ObjetoVida implements Obstaculo {

	public Rock(Celda c) {
		super(c);
		vida = 3;
		graficos = new Icon[3];
		graficos[0] = new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca/roca_1.png"));
		graficos[1] = new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca/roca_2.png"));
		graficos[2] = new ImageIcon(this.getClass().getResource("/resources/static/terrenos/roca/roca_3.png"));
		setGrafico(2);
		profundidad = CONFIG.PROFUNDIDAD_OBSTACULO;
	}

	@Override
	public Obstaculo clone(Celda c) {
		Obstaculo clon = new Rock(c);
		return clon;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitObjeto(this);
	}

}
