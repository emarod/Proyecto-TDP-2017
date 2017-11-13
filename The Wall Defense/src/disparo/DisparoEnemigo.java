package disparo;

import Controladores.Director;
import enemigo.ShooterEnemigo;
import main.CONFIG;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public class DisparoEnemigo extends Disparo {

	// Atributos locales.
	protected ShooterEnemigo enemigo;

	// Constructor.
	public DisparoEnemigo(ShooterEnemigo e) {
		super();
		enemigo = e;
		V = new VisitorDisparoEnemigo(this);
		velocidad = enemigo.getVelocidadDisparo();
		daño = enemigo.getDaño();
	}

	// Metodos locales.
	@Override
	public void destruir() {
		super.destruir();
		enemigo = null;
	}

	// Metodos heredados.
	@Override
	public boolean accept(Visitor V) {
		return V.visitDisparo(this);
	}

	@Override
	public void mover() {
		Celda siguiente;
		enemigo.animarDisparo();
		int xCelda = celda[0].getPosX();
		int yCelda = celda[0].getPosY();
		int xGrafico = grafico.getX();
		int yGrafico = grafico.getY();
		if (xCelda != 0) {
			siguiente = Director.getMapa().getCelda(xCelda - 1, yCelda);
		}
		else {
			siguiente = Director.getMapa().getCelda(xCelda, yCelda);
		}

		GameObject objeto = siguiente.getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO];
		if (objeto != null && !objeto.accept(V)) {
			Director.desactivar(this);
		}

		if (xCelda == 0 || xGrafico == 0) {
			destruir();
		}
		else {
			grafico.setBounds(xGrafico - 64, yGrafico, getAncho(), getAlto());
			intercambiar_celdas(siguiente);
		}

	}

	@Override
	public void run() {
		mover();
	}

	@Override
	public void setCelda() {
		celda[0] = enemigo.getCeldas()[0];
		celda[0].addDisparo(this);
		grafico.setBounds(64 * celda[0].getPosX(), 64 * celda[0].getPosY(), 64, 64);
		Director.getMapa().getEscenario().agregar(grafico, new Integer(CONFIG.PROFUNDIDAD_DISPARO));

	}
}
