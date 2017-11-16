package mapa;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;

import Controladores.BancoRecursos;
import Controladores.Director;
import Controladores.RandomGenerator;
import comprables.Comprable;
import enemigo.Enemigo;
import enemigo.Horda;
import interfaz.Escenario;
import jugador.Jugador;
import main.CONFIG;
import main.GameObject;
import objetoMapa.ObjetoMapa;
import objetoMapa.Rock;
import objetoMapa.Water;
import premios.Premio;
import terreno.Muro;
import terreno.OyenteTerreno;
import terreno.Pasto;
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

	}

	// Metodos locales.
	public void inicializarCeldas() {
		int nivel = Director.getPartida().getNivel();
		int y = 0;
		while (y < CONFIG.CANT_CELDAS_Y) {
			for (int x = 0; x < CONFIG.CANT_CELDAS_X; x++) {
				celdas[x][y] = new ParentCell(x, y);
				GameObject[] objetos = celdas[x][y].getObjects();
				if (x == 0) {
					objetos[CONFIG.PROFUNDIDAD_TERRENO] = new Muro(celdas[x][y], nivel);
				}
				else {
					objetos[CONFIG.PROFUNDIDAD_TERRENO] = new Pasto(celdas[x][y]);
				}
				JLabel graficoTerreno = objetos[CONFIG.PROFUNDIDAD_TERRENO].getGrafico();
				graficoTerreno.addMouseListener(oyenteTerreno);
				graficoTerreno.setBounds(64 * x, 64 * y, 64, 64);
				escenario.agregar(graficoTerreno, new Integer(CONFIG.PROFUNDIDAD_TERRENO));
			}
			y++;
		}
		// horda = new Horda(escenario);
	}

	public void ejecutar() {
		Director.ejecutar(this);
	}

	public void ver() {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			GameObject[] objetos = celdas[x_cel][y_cel].getObjects();
			for (int i = 0; i < CONFIG.PROFUNDIDAD_CELDA; i++) {
				if (objetos[i] != null) {
					System.out.println(i + "." + objetos[i].getClass());
				}
				else {
					System.out.println(i + "." + null);
				}

			}
			System.out.println("end ver()");
		}

	}

	public Celda getCelda(int x, int y) {
		Celda celda = null;
		if (x < CONFIG.CANT_CELDAS_X && x > 0) {
			if (y < CONFIG.CANT_CELDAS_Y && y > 0) {
				celda = celdas[x][y];
			}
		}
		return celda;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void crearJugador(Jugador j) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null) {
				Celda c = celdas[x_cel][y_cel];
				Jugador player = j.clone(c);
				celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = player;
				JLabel icono = player.getGrafico();
				icono.setBounds(x_cel * 64, y_cel * 64, 64, 64);
				icono.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int x_cel = Math.round(x_mouse / 64);
						int y_cel = Math.round(y_mouse / 64);
						GameObject[] objetosCelda = celdas[x_cel][y_cel].getObjects();
						objetosCelda[CONFIG.PROFUNDIDAD_JUGADOR] = player;
						player.getCelda().getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
						player.setCelda(celdas[x_cel][y_cel]);
						int x_terreno = objetosCelda[0].getGrafico().getX();
						int y_terreno = objetosCelda[0].getGrafico().getY();
						player.getGrafico().setBounds(x_terreno, y_terreno, 64, 64);
					}
				});
				icono.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						player.getGrafico().setBounds(x_mouse, y_mouse, 64, 64);
					}
				});
				escenario.agregar(icono, new Integer(CONFIG.PROFUNDIDAD_JUGADOR));
				player.activar();
			}
		}
	}

	public void crearJugadorLargo(Jugador j) {
		int x_cel = Math.round(celdaLabel.getX() / 64);
		int y_cel = Math.round(celdaLabel.getY() / 64);
		if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null
				&& celdas[x_cel + 1][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null) {
			Celda c = celdas[x_cel][y_cel];
			c.addChild(celdas[x_cel + 1][y_cel]);
			Jugador player = j.clone(c);
			celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = player;
			celdas[x_cel + 1][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = player;
			JLabel icono = player.getGrafico();
			icono.setBounds(x_cel * 64, y_cel * 64, 128, 64);

			// Codigo de soltado de mouse.
			icono.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					int x_celd = Math.round(x_mouse / 64);
					int y_celd = Math.round(y_mouse / 64);
					GameObject[] objetosCelda1 = celdas[x_celd][y_celd].getObjects();
					GameObject[] objetosCelda2 = celdas[x_celd + 1][y_celd].getObjects();
					objetosCelda1[CONFIG.PROFUNDIDAD_JUGADOR] = player;
					objetosCelda2[CONFIG.PROFUNDIDAD_JUGADOR] = player;
					player.getCelda().getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
					player.getCelda().getChild().getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
					celdas[x_celd][y_celd].addChild(celdas[x_celd + 1][y_celd]);
					player.setCelda(celdas[x_celd][y_celd]);
					int x_terreno = objetosCelda1[0].getGrafico().getX();
					int y_terreno = objetosCelda1[0].getGrafico().getY();
					player.getGrafico().setBounds(x_terreno, y_terreno, 128, 64);
				}
			});

			// Codigo del arrastrado en mapa.
			icono.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					player.getGrafico().setBounds(x_mouse, y_mouse, 128, 64);
				}
			});
			escenario.agregarLargo(icono, new Integer(CONFIG.PROFUNDIDAD_JUGADOR));
			player.activar();
		}
	}

	public void crearEnemigo(Enemigo e, int x, int y) {
		System.out.println("Enemigo creado - x:" + x + " y:" + y);
		celdas[x][y].getObjects()[CONFIG.PROFUNDIDAD_ENEMIGO] = e;
		JLabel icono = e.getGrafico();
		icono.setBounds(x * 64, y * 64, 64, 64);
		escenario.agregar(icono, new Integer(CONFIG.PROFUNDIDAD_ENEMIGO));
		e.activar();

	}

	public void destruirEnemigo(Enemigo e) {
		System.out.println(puntaje);
		puntaje = puntaje + e.getPuntaje();
		System.out.println(puntaje);
		actualizarPuntaje();
		escenario.repaint();

	}

	private void actualizarPuntaje() {
		Director.getPartida().añadirPuntaje(puntaje);
		escenario.getScore().actualizar();
	}

	public void agregarTokens() {
		RandomGenerator r = new RandomGenerator();
		int x = r.nextInt(16);
		int y = r.nextInt(6);

		if (celdas[x][y].getObjects()[CONFIG.PROFUNDIDAD_TOKEN] == null) {
			int c = r.nextInt(30);
			Token tk = null;
			JLabel grafico = null;
			switch (c) {
				case 5: {
					tk = new MonedaOro(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 25: {
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
				case 17: {
					tk = new tkBomba(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 26: {
					tk = new tkDañoAumentado(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 8: {
					tk = new tkInvulnerable(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
				case 13: {
					tk = new tkVelocidadAumentada(celdas[x][y]);
					grafico = tk.getGrafico();
					break;
				}
			}
			if (grafico != null) {
				grafico.addMouseListener(oyenteToken);
				oyenteToken.setToken(tk);
			}

		}
	}

	public void agregar(GameObject g) {
		JLabel objeto = g.getGrafico();
		objeto.setBounds(g.xy().x * 64, g.xy().y * 64, 64, 64);
		escenario.agregar(objeto, new Integer(g.getProfundidad()));

	}

	public void agregarObstaculos() {
		RandomGenerator r = new RandomGenerator();
		int x = r.nextInt(16);
		int y = r.nextInt(6);

		if (celdas[x][y].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
			GameObject[] objetos = celdas[x][y].getObjects();
			// int c = r.nextInt(2) + 0;
			ObjetoMapa obs;
			JLabel grafico;
			Celda celda;
			int c = 1;
			switch (c) {
				case 0: {
					celda = celdas[x][y];
					obs = new Rock(celda);
					objetos[CONFIG.PROFUNDIDAD_OBSTACULO] = obs;
					grafico = obs.getGrafico();
					grafico.setBounds(x * 64, y * 64, 64, 64);
					escenario.agregar(grafico, new Integer(CONFIG.PROFUNDIDAD_OBSTACULO));
					break;
				}
				case 1: {
					if (x < CONFIG.CANT_CELDAS_X - 2 && x > 0 && y < CONFIG.CANT_CELDAS_Y && y >= 0) {
						if (celdas[x + 1][y + 1].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
							if (celdas[x][y + 1].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
								if (celdas[x + 1][y].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
									// Cada hijo se agrega siguiente a la celda principal
									// Esquina izquierda superior
									celda = celdas[x][y];
									// Esquina derecha inferior
									celda.addChild(celdas[x + 1][y + 1]);
									// Esquina izquierda inferior
									celda.addChild(celdas[x][y + 1]);
									// Esquina derecha superior
									celda.addChild(celdas[x + 1][y]);
									obs = new Water(celda);
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
		// agregarTokens();
		// agregarObstaculos();

	}

	public void crearPremio(Premio precioso) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_PREMIO] == null) {
				Celda c = celdas[x_cel][y_cel];
				Premio objeto = precioso.clone(c);
				celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_PREMIO] = objeto;
				JLabel icono = objeto.getGrafico();
				icono.setBounds(x_cel * 64, y_cel * 64, 64, 64);
				escenario.agregar(icono, new Integer(CONFIG.PROFUNDIDAD_PRECIOSO));
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
