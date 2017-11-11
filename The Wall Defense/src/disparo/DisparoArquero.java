package disparo;

import javax.swing.ImageIcon;

import Controladores.Director;
import jugador.Arquero;
import main.CONFIG;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

/*
 * Clase DisparoArquero
 * Clase que especifica el comportamiento de los proyectiles generados por el arquero.
 */

public class DisparoArquero extends Disparo {

	// Atributos locales.
	protected Arquero arquero;

	// Constructor.
	public DisparoArquero(Arquero archer) {
		super();

		arquero = archer;
		celda[0] = arquero.getCeldas()[0];
		System.out.println("Inicio constructor arquero");
		celda[0].addDisparo(this);
		V = new VisitorDisparoPlayer(this);
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/disparo/flecha.png")));
		grafico.setBounds(64 * celda[0].getPosX(), 64 * celda[0].getPosY(), 64, 64);
		celda[0].getEscenario().agregar(grafico, new Integer(CONFIG.PROFUNDIDAD_DISPARO));
		activeTask = Director.ejecutar(this, arquero.getVelocidadDisparo());
		System.out.println("Fin constructor arquero");
	}

	// Metodos Locales.
	@Override
	public void destruir() {
		super.destruir();
		restarDisparosEnEjecucion();
		arquero = null;
	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return V.visitDisparoPlayer(this);
	}

	@Override
	public void mover() {
		System.out.println("Disparo Arquero");
		Celda siguiente;
		arquero.animarDisparo();
		int xCelda = celda[0].getPosX();
		int yCelda = celda[0].getPosY();
		int xGrafico = grafico.getX();
		int yGrafico = grafico.getY();
		if (xCelda != CONFIG.CANT_CELDAS_X - 1) {
			siguiente = celda[0].getCelda(xCelda + 1, yCelda);
		}
		else {
			siguiente = celda[0].getCelda(xCelda, yCelda);
		}

		GameObject objeto = siguiente.getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO];
		if (objeto != null && !objeto.accept(V)) {
			Director.desactivar(this);
		}

		if (xCelda == CONFIG.CANT_CELDAS_X || xGrafico >= 1026) {
			destruir();
		}
		else {
			grafico.setBounds(xGrafico + 64, yGrafico, getAncho(), getAlto());
			intercambiar_celdas(siguiente);
		}

	}

	@Override
	public void atacar() {

	}

	@Override
	public int getVelocidad() {
		return arquero.getVelocidadDisparo();
	}

	@Override
	public void setVelocidad(int speed) {
		arquero.setVelocidad(speed);
	}

	@Override
	public void restarDisparosEnEjecucion() {
		arquero.restarDisparosEnEjecucion();
	}

	@Override
	public void run() {
		mover();
	}

	@Override
	public int getDaño() {
		return arquero.getDaño();
	}
}
