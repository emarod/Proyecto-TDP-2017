package enemigo;

import javax.swing.Icon;
import javax.swing.JLabel;

import main.CONFIG;
import main.GameObject;
import main.Unidad;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Enemigo.
 * Clase que generaliza la idea de un enemigo y su comportamiento.
 */

public abstract class Enemigo extends Unidad {

	// Atributos locales.
	protected int vida;
	protected int daño;
	protected int puntaje;
	protected boolean atacar;
	protected boolean mover;
	protected Icon[] graficos;
	protected int graph;

	// Constructor.
	public Enemigo(Celda[] c, int profundidad) {
		V = new VisitorEnemigo(this);
		alto = 30;
		ancho = 30;
		celda = c;
		this.profundidad = profundidad;
		grafico = new JLabel();
		setGrafico();
	}

	// Metodos locales.

	public Visitor getVisitor() {
		return V;
	}
<<<<<<< HEAD

	public boolean recibirDaño(int golpe) {
		boolean destruir = false;
		if (vida <= golpe) {
			System.out.println("Enemigo abatido en " + vida);
			destruir = true;
		}
		else {
			vida = vida - golpe;
		}
=======
    
    public Visitor getVisitor() {
    	return V;
    }
    
	public boolean restarResistencia(int d){ 
		boolean destruir= tipo.impact(d);
>>>>>>> master
		if (destruir) {
			destruir();
		}
		return destruir;
	}

	public void setGrafico() {
		setGrafico(grafico);
	}

	@Override
	public JLabel getGrafico() {
		return grafico;
	}

	@Override
	public void destruir() {
		super.destruir();
		celda[0].destruirEnemigo(this);

	}

	public int getPuntaje() {
		return getPuntaje();
	}

	// Metodos heredados.
	@Override
	public void run() {
		mover();
	}

	@Override
	public int getVelocidad() {
		return velocidad;
	}

	@Override
	public void setVelocidad(int speed) {
		velocidad = speed;
	}

	@Override
	public boolean accept(Visitor V) {
		return V.visitEnemigo(this);
	}

	public int getDaño() {
		return daño;
	}

	public abstract Enemigo clone(Celda[] c);

	@Override
	public void mover() {
		Celda siguiente;
		boolean detener = false;
		int xCelda = getCeldas()[0].getPosX();
		int yCelda = getCeldas()[0].getPosY();
		int xGrafico = getGrafico().getX();
		int yGrafico = getGrafico().getY();
		siguiente = getCeldas()[0].getCelda(xCelda - 1, yCelda);
		for (int i = 0; i < CONFIG.PROFUNDIDAD_CELDA; i++) {
			GameObject objeto = siguiente.getObjects()[i];
			if (objeto != null && !objeto.accept(getVisitor())) {
				detener = true;
			}
		}
		if (!detener && xCelda != 0) {
			getGrafico().setBounds(xGrafico - 64, yGrafico, 64, 64);
			intercambiar_celdas(siguiente);
		}
	}

	@Override
	public abstract void atacar();

	public abstract void playSound();
}
