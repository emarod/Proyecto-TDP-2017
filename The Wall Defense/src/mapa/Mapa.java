package mapa;

import javax.swing.JLabel;

import Controladores.BancoRecursos;
import Controladores.Director;
import Controladores.RandomGenerator;
import enemigo.Horda;
import interfaz.Escenario;
import jugador.Jugador;
import main.CONFIG;
import objetoMapa.Rock;
import objetoMapa.Water;
import objetos.Comprable;
import objetos.Obstaculo;
import objetos.Premio;
import terreno.Muro;
import terreno.OyenteTerreno;
import terreno.Terreno;
import tokens.Diamante;
import tokens.MonedaBronce;
import tokens.MonedaOro;
import tokens.MonedaPlata;
import tokens.OyenteToken;
import tokens.Token;
import tokens.tkBomba;
import tokens.tkDañoAumentado;
import tokens.tkInvulnerable;
import tokens.tkVelocidadAumentada;

/*
 * Clase Map.
 * Clase encargada de la construccion de toda la logica del campo de batalla.
 */

public class Mapa implements Runnable {

	// Atributos locales.
	protected Celda[][] celdas;
	protected Escenario escenario;
	protected JLabel celdaLabel;
	protected int puntaje;
	protected int x_mouse;
	protected int y_mouse;
	protected BancoRecursos banco;
	protected Horda horda;
	protected OyenteTerreno oyenteTerreno;
	protected OyenteToken oyenteToken;

	// Constructor.
	public Mapa() {
		celdas = new Celda[CONFIG.CANT_CELDAS_X][CONFIG.CANT_CELDAS_Y];
		banco = Director.getBancoRecursos();
		oyenteTerreno = new OyenteTerreno();
		oyenteToken = new OyenteToken();
		horda = null;

	}

	// Metodos locales.
	public void inicializarCeldas(int n) {
		int y = 0;
		Terreno terreno;
		while (y < CONFIG.CANT_CELDAS_Y) {
			for (int x = 0; x < CONFIG.CANT_CELDAS_X; x++) {
				celdas[x][y] = new ParentCell(x, y);
				if (x == 0) {
					terreno = new Muro(celdas[x][y], n);
					terreno.crear();

				}
				else {
					terreno = CONFIG.crearTerreno(celdas[x][y], n);

				}
				terreno.getGrafico().addMouseListener(oyenteTerreno);
			}
			y++;
		}
		// horda = new Horda(escenario);
	}

	public void ejecutar() {
		Director.ejecutar(this);
	}

	public Celda getCelda(int x, int y) {
		Celda celda = null;
		if (x < CONFIG.CANT_CELDAS_X && x > 0) {
			if (y < CONFIG.CANT_CELDAS_Y && y >= 0) {
				celda = celdas[x][y];
			}
		}
		return celda;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public boolean crearJugador(Jugador j) {
		boolean desplego = false;
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null) {
				desplego = true;
				Celda c = celdas[x_cel][y_cel];
				Jugador player = j.clone(c);
				player.crear();
				player.activar();
			}
		}
		return desplego;
	}

	protected boolean hordaActiva() {
		boolean activa = false;
		if (horda != null) {
			activa = horda.getEnemigos() > 0;
		}
		return activa;
	}

	public boolean crearJugadorLargo(Jugador j) {
		boolean desplego = false;
		int x_cel = Math.round(celdaLabel.getX() / 64);
		int y_cel = Math.round(celdaLabel.getY() / 64);
		if (x_cel < 15 && celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null
				&& celdas[x_cel + 1][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null) {
			desplego = true;
			Celda c = celdas[x_cel][y_cel];
			c.addChild(celdas[x_cel + 1][y_cel]);
			Jugador player = j.clone(c);
			player.crearMulticelda();
			JLabel icono = player.getGrafico();
			icono.setBounds(x_cel * 64, y_cel * 64, 128, 64);
			escenario.agregarLargo(icono, new Integer(CONFIG.PROFUNDIDAD_JUGADOR));
			player.activar();
		}
		return desplego;
	}

	public boolean crearJugadorGrande(Jugador j) {
		boolean desplego = false;
		int x_cel = Math.round(celdaLabel.getX() / 64);
		int y_cel = Math.round(celdaLabel.getY() / 64);
		if (x_cel < 15 && y_cel < 5 && celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null
				&& celdas[x_cel + 1][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null
				&& celdas[x_cel][y_cel + 1].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null
				&& celdas[x_cel + 1][y_cel + 1].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null) {
			desplego = true;
			Celda c = celdas[x_cel][y_cel];
			c.addChild(celdas[x_cel + 1][y_cel]);
			c.addChild(celdas[x_cel][y_cel + 1]);
			c.addChild(celdas[x_cel + 1][y_cel + 1]);
			Jugador player = j.clone(c);
			player.crearMulticelda();
			JLabel icono = player.getGrafico();
			icono.setBounds(x_cel * 64, y_cel * 64, 128, 128);
			escenario.agregarGrande(icono, new Integer(CONFIG.PROFUNDIDAD_JUGADOR));
			player.activar();
		}
		return desplego;
	}

	public void agregarTokens() {
		RandomGenerator r = Director.getRandom();
		int x = r.poll(14) + 1;
		int y = r.poll(6);

		if (celdas[x][y].getObjects()[CONFIG.PROFUNDIDAD_TOKEN] == null) {
			int c = r.poll(13);
			Token tk = null;
			JLabel grafico = null;
			switch (c) {
				case 5: {
					tk = new MonedaOro(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 6: {
					tk = new MonedaPlata(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 12: {
					tk = new MonedaBronce(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 9: {
					tk = new Diamante(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 8: {
					tk = new tkBomba(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 7: {
					tk = new tkDañoAumentado(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 4: {
					tk = new tkInvulnerable(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 1: {
					tk = new tkVelocidadAumentada(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
			}
			if (grafico != null) {
				grafico.addMouseListener(oyenteToken);
			}
		}
	}

	public Horda nuevaHorda(int d) {
		horda = CONFIG.crearHorda(d);
		return horda;
	}

	public void agregarObstaculos() {
		RandomGenerator r = Director.getRandom();
		int x = r.poll(14) + 1;
		int y = r.poll(6);

		if (celdas[x][y].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
			int c = r.poll(2);
			Obstaculo obs;
			Celda celda;
			switch (c) {
				case 0: {
					celda = celdas[x][y];
					if (celda.estaOcupada() == null) {
						obs = new Rock(celda);
						obs.crear();
					}
					break;
				}
				case 1: {
					if (x < CONFIG.CANT_CELDAS_X - 2 && x > 0 && y < CONFIG.CANT_CELDAS_Y - 1 && y >= 0) {
						if (celdas[x + 1][y + 1].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
							if (celdas[x][y + 1].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
								if (celdas[x + 1][y].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
									// Cada hijo se agrega siguiente a la celda
									// principal
									// Esquina izquierda superior
									celda = celdas[x][y];
									// Esquina derecha inferior
									celda.addChild(celdas[x + 1][y + 1]);
									// Esquina izquierda inferior
									celda.addChild(celdas[x][y + 1]);
									// Esquina derecha superior
									celda.addChild(celdas[x + 1][y]);
									if (celdas[x][y].estaOcupada() == null && celdas[x + 1][y].estaOcupada() == null
											&& celdas[x][y + 1].estaOcupada() == null
											&& celdas[x + 1][y + 1].estaOcupada() == null) {
										obs = new Water(celda);
										obs.crearMulticelda();
										JLabel icono = obs.getGrafico();
										icono.setBounds(x * 64, y * 64, 128, 128);
									}

								}
							}
						}
					}
					break;
				}
			}

		}
	}

	// Metodos heredados.
	@Override
	public void run() {
		escenario.repaint();
		agregarObstaculos();
		agregarTokens();

	}

	public void crearPremio(Premio precioso) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_PREMIO] == null) {
				Celda c = celdas[x_cel][y_cel];
				Premio objeto = precioso.clone(c);
				objeto.crear();
			}
		}
	}

	public void crearPremio(Premio precioso, Celda celda) {
		if (celdaLabel != null) {
			int x_cel = celda.getPosX();
			int y_cel = celda.getPosY();
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_PREMIO] == null) {
				Celda c = celdas[x_cel][y_cel];
				Premio objeto = precioso.clone(c);
				objeto.crear();
			}
		}
	}

	public void setEscenario(Escenario e) {
		escenario = e;
	}

	public JLabel getCeldaLabel() {
		return celdaLabel;
	}

	public void setCeldaLabel(JLabel l) {
		celdaLabel = l;
	}

	public int get_x_mouse() {
		return x_mouse;
	}

	public int get_y_mouse() {
		return y_mouse;
	}

	public void set_x_mouse(int i) {
		x_mouse = i;
	}

	public void set_y_mouse(int i) {
		y_mouse = i;
	}

	public Horda getHorda() {
		return horda;
	}

	public void crearComprable(Comprable comprable) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_COMPRABLE] == null) {
				Celda c = celdas[x_cel][y_cel];
				Comprable objeto = comprable.clone(c);
				objeto.crear();
			}
		}

	}
}
