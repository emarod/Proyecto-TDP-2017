package jugador;

<<<<<<< HEAD
import javax.swing.Icon;
import javax.swing.JLabel;

import main.CONFIG;
=======
import mapa.Celda;
import java.util.concurrent.Future;
import javax.swing.*;
import Controladores.BancoRecursos;
import interfaz.Dinero;
>>>>>>> master
import main.Unidad;
import main.Visitor;
import mapa.Celda;

/*
 * Clase Jugador.
 * Clase que generaliza la idea de un jugador y su comportamiento.
 */

public abstract class Jugador extends Unidad {

	// Atributos locales.
	protected JLabel imagen;
<<<<<<< HEAD
	protected int daño;
	protected int vida;
	protected Icon[] graficos;
	protected int graph;

	// Constructor.
	public Jugador(Celda[] c) {
		alto = 30;
		ancho = 30;
		profundidad = CONFIG.PROFUNDIDAD_JUGADOR;
		V = new VisitorJugador(this);
		celda = c;
		grafico = new JLabel();
	}

	// Metodos locales.
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
	protected int vidas;
	protected PerfilJugador tipo;
    protected Future<?> activeAttack;
	protected BancoRecursos bancoRecursos;
	protected Dinero dinero;

    
	//Constructor.
    public Jugador(Celda[] c,int prof, PerfilJugador t){	 
    	 alto=30;
    	 ancho=30;
    	 profundidad=prof;
    	 V=new VisitorJugador(this);
    	 celda=c;    	 
    	 grafico=new JLabel();
    	 tipo = t;
    	 setGrafico();
    }
    
    //Metodos locales.
	public boolean restarResistencia(int d){ 
		boolean destruir= (tipo.impact(d));
>>>>>>> master
		if (destruir) {
			System.out.println("antes de restar resistencia de jugador");
			destruir();
		}
		return destruir;
	}

	public void setVisitor(Visitor v) {
		V = v;
	}

	@Override
	public void destruir() {
		super.destruir();
	}

	public void setV() {
		setVisitor(new VisitorJugador(this));

	}

	@Override
	public JLabel getGrafico() {
		return grafico;
	}

	public Visitor getVisitor() {
		return V;
	}

	public int getDaño() {
		return getDaño();
	}

	public void setAtaque(int a) {
		setAtaque(a);
	}

	// Metodos heredados.
	@Override
	public void run() {
		atacar();
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
		return V.visitPlayer(this);
	}

	// abstract methods
	public abstract Jugador clone(Celda[] c);

	@Override
	public abstract void mover();

	@Override
	public abstract void atacar();

	public abstract void playSound();

}