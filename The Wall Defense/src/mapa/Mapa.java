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
import interfaz.Escenario;
import jugador.Jugador;
import main.GameObject;
import objetos.ObjetoPrecioso;
import objetos.Obstaculo;
import objetos.Rock;
import objetos.Water;
import powerUp.Bomba;
import powerUp.DañoAtkAumentado;
import powerUp.Invulnerable;
import powerUp.PowerUp;
import powerUp.VelAtkAumentado;
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
	protected Director director;
	protected BancoRecursos banco;
	public static final int CANT_CELDAS_Y = 6;
	public static final int CANT_CELDAS_X = 16;

	// Constructor.
	public Mapa(Escenario stage, Director director, int width, int height, int sprites) {
		celdas = new Celda[width][height];
		escenario = stage;
		this.director = director;
		banco = director.getBancoRecursos();
		inicializarCeldas(sprites);
	}

	// Metodos locales.
	private void inicializarCeldas(int t) {
		int y = 0;
		while (y < CANT_CELDAS_Y) {
			for (int x = 0; x < CANT_CELDAS_X; x++) {
				System.out.println(x + "," + y);
				celdas[x][y] = new Celda(this, x, y);
				GameObject[] objetos = celdas[x][y].getObjects();
				if (x == 0) {
					objetos[0] = new Muro(celdas[x][y]);
				}
				else {
					objetos[0] = new Nieve(celdas[x][y]);
				}
				JLabel terreno = objetos[0].getGrafico();
				terreno.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						if (celdaLabel == null) {
							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
							celdaLabel = terreno;
							System.out.println("(" + terreno.getX() / 64 + "," + terreno.getY() / 64 + ")");
						}
						else {
							celdaLabel.setBorder(null);
							terreno.setBorder(new LineBorder(new Color(0, 0, 0)));
							celdaLabel = terreno;
							System.out.println("(" + terreno.getX() / 64 + "," + terreno.getY() / 64 + ")");

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
				escenario.agregar(terreno, new Integer(0));
			}
			y++;
		}

		// Codido a prueba de token invulnerable
		GameObject[] objetos22 = celdas[8][4].getObjects();
		PowerUp p = new Invulnerable(celdas[8][4], 4);
		JLabel grafico22 = p.getGraficoToken();
		objetos22[4] = p;
		grafico22.setBounds(8 * 64, 4 * 64, 64, 64);
		escenario.agregar(grafico22, new Integer(2));
		grafico22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (celdaLabel != null) {
					setPowerUp(p);
				}

			}
		});
		// Fin de codigo prueba
		director.ejecutar(this);

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
			if (celdas[x_cel][y_cel].getObjects()[2] == null) {
				Celda[] c = new Celda[1];
				c[0] = celdas[x_cel][y_cel];
				Jugador player = j.clone(c);
				celdas[x_cel][y_cel].getObjects()[2] = player;
				JLabel icono = player.getGrafico();
				icono.setBounds(x_cel * 64, y_cel * 64, 64, 64);
				icono.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int x_cel = Math.round(x_mouse / 64);
						int y_cel = Math.round(y_mouse / 64);
						GameObject[] objetosCelda = celdas[x_cel][y_cel].getObjects();
						objetosCelda[2] = player;
						player.getCeldas()[0].getObjects()[2] = null;
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
				escenario.agregar(icono, new Integer(2));
				player.activar();
			}
		}
	}

	public void crearJugadorLargo(Jugador j) {
		int x_cel = Math.round(celdaLabel.getX() / 64);
		int y_cel = Math.round(celdaLabel.getY() / 64);
		if (celdas[x_cel][y_cel].getObjects()[2] == null && celdas[x_cel + 1][y_cel].getObjects()[2] == null) {
			Celda[] c = new Celda[2];
			c[0] = celdas[x_cel][y_cel];
			c[1] = celdas[x_cel + 1][y_cel];
			Jugador player = j.clone(c);
			celdas[x_cel][y_cel].getObjects()[2] = player;
			celdas[x_cel + 1][y_cel].getObjects()[2] = player;
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
					objetosCelda1[2] = player;
					objetosCelda2[2] = player;
					player.getCeldas()[0].getObjects()[2] = null;
					player.getCeldas()[1].getObjects()[2] = null;
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
			escenario.agregarLargo(icono, new Integer(2));
			player.activar();
		}
	}

	public void crearObstaculo(Obstaculo o) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[3] == null) {
				Celda[] c = new Celda[1];
				c[0] = celdas[x_cel][y_cel];
				Obstaculo obstaculo = o.clone(c);
				celdas[x_cel][y_cel].getObjects()[3] = obstaculo;
				JLabel icono = obstaculo.getGrafico();
				icono.setBounds(x_cel * 64, y_cel * 64, 64, 64);
				icono.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int x_cel = Math.round(x_mouse / 64);
						int y_cel = Math.round(y_mouse / 64);
						GameObject[] objetosCelda = celdas[x_cel][y_cel].getObjects();
						objetosCelda[3] = obstaculo;
						obstaculo.getCeldas()[0].getObjects()[2] = null;
						obstaculo.setCelda(celdas[x_cel][y_cel], 0);
						int x_terreno = objetosCelda[0].getGrafico().getX();
						int y_terreno = objetosCelda[0].getGrafico().getY();
						obstaculo.getGrafico().setBounds(x_terreno, y_terreno, 64, 64);
					}
				});
				icono.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						obstaculo.getGrafico().setBounds(x_mouse, y_mouse, 64, 64);
					}
				});
				escenario.agregar(icono, new Integer(3));
			}
		}
	}

	public void crearEnemigo(Enemigo e, int x, int y) {
		System.out.println("Enemigo creado - x:" + x + " y:" + y);
		if (celdas[x][y].getObjects()[1] == null) {
			Celda[] c = new Celda[4];
			c[0] = celdas[x][y];
			Enemigo enemy = e.clone(c);
			celdas[x][y].getObjects()[1] = enemy;
			JLabel icono = enemy.getGrafico();
			icono.setBounds(x * 64, y * 64, 64, 64);
			escenario.agregar(icono, new Integer(1));
			enemy.activar();
		}
	}

	public void destruirEnemigo(Enemigo e) {
		System.out.println(puntaje);
		puntaje = puntaje + e.getPuntaje();
		System.out.println(puntaje);
		actualizarPuntaje();
		escenario.repaint();

	}

	private void actualizarPuntaje() {
		escenario.setPuntaje("Puntaje: " + puntaje);
	}

	public Director getDirector() {
		return director;
	}

	private void agregarPowerUp() {
		Random r = new Random();
		int x = r.nextInt(16);
		int y = r.nextInt(6);

		if (celdas[x][y].getObjects()[4] == null) {
			GameObject[] objetos2 = celdas[x][y].getObjects();
			int c = r.nextInt(4) + 0;
			PowerUp p;
			JLabel grafico2;
			switch (c) {
				case 0: {
					p = new DañoAtkAumentado(celdas[x][y], 4);
					grafico2 = p.getGraficoToken();
					objetos2[4] = p;
					grafico2.setBounds(x * 64, y * 64, 64, 64);
					grafico2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (celdaLabel != null) {
								setPowerUp(p);
							}

						}
					});
					escenario.agregar(grafico2, new Integer(4));
					break;
				}
				case 1: {
					p = new VelAtkAumentado(celdas[x][y], 4);
					grafico2 = p.getGraficoToken();
					objetos2[4] = p;
					grafico2.setBounds(x * 64, y * 64, 64, 64);
					grafico2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (celdaLabel != null) {
								setPowerUp(p);
							}

						}
					});
					escenario.agregar(grafico2, new Integer(4));
					break;
				}
				case 2: {
					p = new Bomba(celdas[x][y], 4);
					grafico2 = p.getGraficoToken();
					objetos2[4] = p;
					grafico2.setBounds(x * 64, y * 64, 64, 64);
					grafico2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (celdaLabel != null) {
								setPowerUp(p);
							}

						}
					});
					escenario.agregar(grafico2, new Integer(4));
					break;
				}
				case 3: {
					p = new Invulnerable(celdas[x][y], 4);
					grafico2 = p.getGraficoToken();
					objetos2[4] = p;
					grafico2.setBounds(x * 64, y * 64, 64, 64);
					grafico2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (celdaLabel != null) {
								setPowerUp(p);
							}

						}
					});
					break;
				}

			}

		}
	}

	public void agregarObstaculos() {
		Random r = new Random();
		int x = r.nextInt(16);
		int y = r.nextInt(6);

		if (celdas[x][y].getObjects()[3] == null) {
			GameObject[] objetos = celdas[x][y].getObjects();
			int c = r.nextInt(2) + 0;
			Obstaculo obs;
			JLabel grafico;
			Celda[] celda;
			switch (c) {
				case 0: {
					celda = new Celda[1];
					celda[0] = celdas[x][y];
					obs = new Rock(celda, 3);
					objetos[3] = obs;
					grafico = obs.getGrafico();
					grafico.setBounds(x * 64, y * 64, 64, 64);
					escenario.agregar(grafico, new Integer(3));
					break;
				}
				case 1: {
					if (x < 15 && x > 0 && y < 5 && y >= 0) {
						if (celdas[x + 1][y + 1].getObjects()[3] == null) {
							if (celdas[x][y + 1].getObjects()[3] == null) {
								if (celdas[x + 1][y].getObjects()[3] == null) {
									celda = new Celda[4];
									// Esquina izquierda superior
									celda[0] = celdas[x][y];
									// Esquina derecha superior
									celda[1] = celdas[x + 1][y];
									// Esquina derecha inferior
									celda[2] = celdas[x + 1][y + 1];
									// Esquina izquierda inferior
									celda[3] = celdas[x][y + 1];
									obs = new Water(celda, 3);
									objetos[3] = obs;
									celda[1].getObjects()[3] = obs;
									celda[2].getObjects()[3] = obs;
									celda[3].getObjects()[3] = obs;

								}
							}
						}
					}
					break;
				}
			}

		}
	}

	public void setPowerUp(PowerUp p) {
		int x_cel = Math.round(celdaLabel.getX() / 64);
		int y_cel = Math.round(celdaLabel.getY() / 64);
		Jugador player = (Jugador) celdas[x_cel][y_cel].getObjects()[2];
		if (celdas[x_cel][y_cel].getObjects()[2] != null) {
			p.aplicar(player);
			escenario.remove(p.getGraficoToken());
			p.getGraficoToken().setIcon(null);
			celdas[x_cel][y_cel].getObjects()[4] = p.getCeldas()[0].getObjects()[4];
			p.getGrafico().setBounds(x_cel * 64, y_cel * 64, 64, 64);
			escenario.agregar(p.getGrafico(), new Integer(4));
		}
	}

	// Metodos heredados.
	@Override
	public void run() {
		escenario.repaint();
		agregarPowerUp();
		agregarObstaculos();
	}

	public void crearPrecioso(ObjetoPrecioso precioso) {
		if (celdaLabel != null) {
			int x_cel = Math.round(celdaLabel.getX() / 64);
			int y_cel = Math.round(celdaLabel.getY() / 64);
			if (celdas[x_cel][y_cel].getObjects()[3] == null) {
				Celda[] c = new Celda[1];
				c[0] = celdas[x_cel][y_cel];
				ObjetoPrecioso objeto = precioso.clone(c);
				celdas[x_cel][y_cel].getObjects()[3] = objeto;
				JLabel icono = objeto.getGrafico();
				icono.setBounds(x_cel * 64, y_cel * 64, 64, 64);
				icono.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						int x_cel = Math.round(x_mouse / 64);
						int y_cel = Math.round(y_mouse / 64);
						GameObject[] objetosCelda = celdas[x_cel][y_cel].getObjects();
						objetosCelda[3] = objeto;
						objeto.getCeldas()[0].getObjects()[2] = null;
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
				escenario.agregar(icono, new Integer(3));
			}
		}
	}
}
