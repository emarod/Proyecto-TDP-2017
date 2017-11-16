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
		enemigo.removeDisparo();
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
		// enemigo.animarDisparo();
		int xCelda = celda.getPosX();
		int yCelda = celda.getPosY();
		int xGrafico = grafico.getX();
		int yGrafico = grafico.getY();
		System.out.println("helooo");
		if (xCelda != 1) {
			siguiente = Director.getMapa().getCelda(xCelda - 1, yCelda);
		}
		else {
			siguiente = Director.getMapa().getCelda(xCelda, yCelda);
		}
		System.out.println("Siguiente elegido " + siguiente.getPosX());
		System.out.println("Siguiente elegido " + grafico.getX());
		GameObject objeto = siguiente.getObjects()[CONFIG.PROFUNDIDAD_JUGADOR];
		if (objeto != null && !objeto.accept(V)) {
			System.out.println("Dio con algo");
			activeTask.cancel(true);
		}

		if (xCelda == 1 || xGrafico <= 128) {
			System.out.println("Murio");
			destruir();
		}
		else {
			System.out.println("moviendo grafico lanza");
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
		System.out.println("Seteando celda");
		celda = enemigo.getCelda();
		celda.addDisparo(this);
		grafico.setBounds(64 * celda.getPosX(), 64 * celda.getPosY(), 64, 64);
		Director.getMapa().getEscenario().agregar(grafico, new Integer(CONFIG.PROFUNDIDAD_DISPARO));
		System.out.println("Celda seteada");

	}

}
