package mapa;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import Controladores.BancoRecursos;
import Controladores.Director;
import enemigo.Enemigo;
import enemigo.Horda;
import interfaz.Escenario;
import jugador.Jugador;
import main.CONFIG;
import main.GameObject;
import obstaculos.Obstaculo;
import obstaculos.Rock;
import obstaculos.Water;
import preciosos.ObjetoPrecioso;
import terreno.Muro;
import terreno.Nieve;

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

	// Constructor.
	public Mapa() {
		celdas = new Celda[CONFIG.CANT_CELDAS_X][CONFIG.CANT_CELDAS_Y];
		banco = Director.getBancoRecursos();
	}

	// Metodos locales.
	public void inicializarCeldas() {
		int y = 0;
		while (y < CONFIG.CANT_CELDAS_Y) {
			for (int x = 0; x < CONFIG.CANT_CELDAS_X; x++) {
				celdas[x][y] = new Celda(this, x, y);
				GameObject[] objetos = celdas[x][y].getObjects();
				if (x == 0) {
					objetos[CONFIG.PROFUNDIDAD_TERRENO] = new Muro(celdas[x][y]);
				}
				else {
					objetos[CONFIG.PROFUNDIDAD_TERRENO] = new Nieve(celdas[x][y]);
				}
				JLabel terreno = objetos[CONFIG.PROFUNDIDAD_TERRENO].getGrafico();
				terreno.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						if (celdaLabel == null) {
							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
							celdaLabel = terreno;
							System.out.println("(" + terreno.getX() / 64 + "," + terreno.getY() / 64 + ")");
							ver();
						}
						else {
							celdaLabel.setBorder(null);
							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
							celdaLabel = terreno;
							System.out.println("(" + terreno.getX() / 64 + "," + terreno.getY() / 64 + ")");
							ver();

						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						x_mouse = terreno.getX();
						y_mouse = terreno.getY();
						if (terreno != celdaLabel) {
							terreno.setBorder(new LineBorder(new Color(255, 0, 0)));
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						if (terreno != celdaLabel) {
							terreno.setBorder(null);
						}
					}
				}

				);
				terreno.setBounds(64 * x, 64 * y, 64, 64);
				escenario.agregar(terreno, new Integer(CONFIG.PROFUNDIDAD_TERRENO));
			}
			y++;
		}
		Director.ejecutar(this);
		horda = new Horda(escenario);
	}

	protected void ver() {
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
		return celdas[x][y];
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void crearJugador(Jugador j) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] == null) {
				Celda[] c = new Celda[1];
				c[0] = celdas[x_cel][y_cel];
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
						player.getCeldas()[0].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
						player.setCelda(celdas[x_cel][y_cel], 0);
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
			Celda[] c = new Celda[2];
			c[0] = celdas[x_cel][y_cel];
			c[1] = celdas[x_cel + 1][y_cel];
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
					player.getCeldas()[0].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
					player.getCeldas()[1].getObjects()[CONFIG.PROFUNDIDAD_JUGADOR] = null;
					player.setCelda(celdas[x_celd][y_celd], 0);
					player.setCelda(celdas[x_celd + 1][y_celd], 1);
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

	// public void randomToken() {
	// Random r = new Random();
	// int x = r.nextInt(16);
	// int y = r.nextInt(6);
	// celda
	//
	// }

	public void agregar(GameObject g) {
		JLabel objeto = g.getGrafico();
		objeto.setBounds(g.xy().x * 64, g.xy().y * 64, 64, 64);
		escenario.agregar(objeto, new Integer(g.getProfundidad()));

	}

	public void agregarObstaculos() {
		Random r = new Random();
		int x = r.nextInt(16);
		int y = r.nextInt(6);

		if (celdas[x][y].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] == null) {
			GameObject[] objetos = celdas[x][y].getObjects();
			int c = r.nextInt(2) + 0;
			Obstaculo obs;
			JLabel grafico;
			Celda[] celda;
			switch (c) {
				case 0: {
					celda = new Celda[1];
					celda[0] = celdas[x][y];
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
									celda = new Celda[4];
									// Esquina izquierda superior
									celda[0] = celdas[x][y];
									// Esquina derecha superior
									celda[1] = celdas[x + 1][y];
									// Esquina derecha inferior
									celda[2] = celdas[x + 1][y + 1];
									// Esquina izquierda inferior
									celda[3] = celdas[x][y + 1];
									obs = new Water(celda);
									objetos[CONFIG.PROFUNDIDAD_OBSTACULO] = obs;
									celda[1].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] = obs;
									celda[2].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] = obs;
									celda[3].getObjects()[CONFIG.PROFUNDIDAD_OBSTACULO] = obs;

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
		// randomToken();
		agregarObstaculos();
	}

	public void crearPrecioso(ObjetoPrecioso precioso) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_PRECIOSO] == null) {
				Celda[] c = new Celda[1];
				c[0] = celdas[x_cel][y_cel];
				ObjetoPrecioso objeto = precioso.clone(c);
				celdas[x_cel][y_cel].getObjects()[CONFIG.PROFUNDIDAD_PRECIOSO] = objeto;
				JLabel icono = objeto.getGrafico();
				icono.setBounds(x_cel * 64, y_cel * 64, 64, 64);
				icono.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int x_cel = Math.round(x_mouse / 64);
						int y_cel = Math.round(y_mouse / 64);
						GameObject[] objetosCelda = celdas[x_cel][y_cel].getObjects();
						objetosCelda[CONFIG.PROFUNDIDAD_PRECIOSO] = objeto;
						objeto.getCeldas()[0].getObjects()[CONFIG.PROFUNDIDAD_PRECIOSO] = null;
						objeto.setCelda(celdas[x_cel][y_cel], 0);
						int x_terreno = objetosCelda[0].getGrafico().getX();
						int y_terreno = objetosCelda[0].getGrafico().getY();
						objeto.getGrafico().setBounds(x_terreno, y_terreno, 64, 64);
					}
				});
				icono.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						objeto.getGrafico().setBounds(x_mouse, y_mouse, 64, 64);
					}
				});
				escenario.agregar(icono, new Integer(CONFIG.PROFUNDIDAD_PRECIOSO));
			}
		}
	}

	public void setEscenario(Escenario e) {
		escenario = e;
	}
}
