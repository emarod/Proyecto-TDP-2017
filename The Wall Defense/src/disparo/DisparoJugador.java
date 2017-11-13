package disparo;

import jugador.Shooter;
import main.CONFIG;
import main.GameObject;
import main.Visitor;
import mapa.Celda;

public abstract class DisparoJugador extends Disparo {

	Shooter jugador;

	public DisparoJugador(Shooter j) {
		super();
		jugador = j;
		V = new VisitorDisparoPlayer(this);
		velocidad = jugador.getVelocidadDisparo();
		daño = jugador.getDaño();
	}

	@Override
	public void mover() {
		Celda siguiente;
		jugador.animarDisparo();
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
			activeTask.cancel(true);
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
	public void setCelda() {
		celda[0] = jugador.getCeldas()[0];
		celda[0].addDisparo(this);
		grafico.setBounds(64 * celda[0].getPosX(), 64 * celda[0].getPosY(), 64, 64);
		celda[0].getEscenario().agregar(grafico, new Integer(CONFIG.PROFUNDIDAD_DISPARO));
		// activar();
	}

	@Override
	public void run() {
		mover();
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitDisparo(this);
	}

	@Override
	public void destruir() {
		super.destruir();
		jugador.removeDisparo();
		jugador = null;
	}

}
