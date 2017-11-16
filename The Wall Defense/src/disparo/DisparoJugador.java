package disparo;

import Controladores.Director;
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
		// jugador.animarDisparo();
		int xCelda = celda.getPosX();
		int yCelda = celda.getPosY();
		int xGrafico = grafico.getX();
		int yGrafico = grafico.getY();
		if (xCelda != CONFIG.CANT_CELDAS_X - 1) {
			siguiente = Director.getMapa().getCelda(xCelda + 1, yCelda);
		}
		else {
			siguiente = Director.getMapa().getCelda(xCelda, yCelda);
		}

		GameObject objeto = siguiente.getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO];
		if (objeto != null && !objeto.accept(V)) {
			activeTask.cancel(true);
		}

		if (xCelda == CONFIG.CANT_CELDAS_X - 1 || xGrafico >= 1026) {
			destruir();
		}
		else {
			grafico.setBounds(xGrafico + 64, yGrafico, getAncho(), getAlto());
			intercambiar_celdas(siguiente);
		}

	}

	@Override
	public void setCelda() {
		celda = jugador.getCelda();
		celda.addDisparo(this);
		grafico.setBounds(64 * celda.getPosX(), 64 * celda.getPosY(), 64, 64);
		Director.getMapa().getEscenario().agregar(grafico, new Integer(CONFIG.PROFUNDIDAD_DISPARO));
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
