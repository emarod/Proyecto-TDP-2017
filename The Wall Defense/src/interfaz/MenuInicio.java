package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Controladores.BancoRecursos;
import Controladores.Director;
import main.Juego;

/*
 * Clase MenuInicio.
 * Clase encargada de desplegar el menu de inicio.
 */

public class MenuInicio extends JPanel {

	// Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Icon menuback;
	protected JLabel menupanel;
	protected Icon newGame[];
	protected Icon help[];
	protected Icon options[];
	protected JButton buttons[];
	protected Juego game;
	protected BancoRecursos bancoRecursos;
	protected JButton opcion1;
	protected JButton opcion2;
	protected JButton close, close1;
	protected JButton dificultad;
	protected JButton facil;
	protected JButton moderado;
	protected JButton dificil;
	protected JButton info1, info2, info3;
	protected boolean onefects;
	protected boolean onmusic;
	protected boolean oyentesSonido;
	protected JLabel musicOn, efectsOn;
	protected JLabel musicOff, efectsOff;
	protected JLabel info;
	protected JLabel select;
	protected int difficulty;
	protected int ventanas;

	// Constructor.
	public MenuInicio(Juego game) {

		this.game = game;
		bancoRecursos = Director.getBancoRecursos();
		armarIconos();
		armarBotonera();
		oyentes();

		this.setBounds(235, 0, 243, 420);
		this.setLayout(new BorderLayout());
		menuback = new ImageIcon(this.getClass().getResource("/resources/static/background/menu3.png"));
		menupanel = new JLabel();
		menupanel.setIcon(menuback);
		menupanel.setSize(243, 423);
		this.add(menupanel);

		onefects = true;
		onmusic = true;
		oyentesSonido = false;
		difficulty = 2;
		ventanas = 0;
	}

	// Metodos locales.
	public void armarIconos() {
		newGame = new Icon[3];
		help = new Icon[3];
		options = new Icon[3];

		for (int i = 0; i < 3; i++) {
			newGame[i] = new ImageIcon(
					this.getClass().getResource("/resources/static/botones/ngbutton" + (i + 1) + ".png"));
			help[i] = new ImageIcon(
					this.getClass().getResource("/resources/static/botones/helpbutton" + (i + 1) + ".png"));
			options[i] = new ImageIcon(
					this.getClass().getResource("/resources/static/botones/optionsbutton" + (i + 1) + ".png"));
		}

	}

	public void armarBotonera() {

		buttons = new JButton[3];

		buttons[0] = new JButton();
		buttons[0].setIcon(newGame[2]);
		buttons[0].setBounds(50, 100, buttons[0].getIcon().getIconWidth(), buttons[0].getIcon().getIconHeight());
		buttons[0].setToolTipText("Juego nuevo");

		buttons[1] = new JButton();
		buttons[1].setIcon(options[2]);
		buttons[1].setBounds(50, 200, buttons[1].getIcon().getIconWidth(), buttons[1].getIcon().getIconHeight());
		buttons[1].setToolTipText("Opciones de sonido y dificultad");

		buttons[2] = new JButton();
		buttons[2].setIcon(help[2]);
		buttons[2].setBounds(50, 300, buttons[2].getIcon().getIconWidth(), buttons[2].getIcon().getIconHeight());
		buttons[2].setToolTipText("Objetivo del juego");

		for (int i = 0; i < 3; i++) {
			this.add(buttons[i]);
		}
	}

	public void oyentes() {

		// Oyente boton new game crea GUI
		buttons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				game.crearGUI(difficulty);
			}
		});

		// Oyentes boton new game

		buttons[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buttons[0].setIcon(newGame[2]);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttons[0].setIcon(newGame[1]);
				bancoRecursos.playClick();

			}

			@Override
			public void mouseEntered(MouseEvent evento) {
				buttons[0].setIcon(newGame[0]);

			}

			@Override
			public void mouseExited(MouseEvent evento) {
				buttons[0].setIcon(newGame[2]);

			}

		});

		// Oyentes boton help

		buttons[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buttons[2].setIcon(help[2]);
				buttons[0].setVisible(false);
				buttons[1].setVisible(false);
				buttons[2].setVisible(false);
				armarAyuda();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttons[2].setIcon(help[1]);
				bancoRecursos.playClick();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				buttons[2].setIcon(help[0]);

			}

			@Override
			public void mouseExited(MouseEvent evento) {
				buttons[2].setIcon(help[2]);

			}

		});

		// Oyentes boton options

		buttons[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				buttons[1].setIcon(options[2]);
				buttons[0].setVisible(false);
				buttons[1].setVisible(false);
				buttons[2].setVisible(false);

				opcion1.setVisible(true);
				opcion2.setVisible(true);
				close.setVisible(true);

				ventanas = 1;

				armarOpciones();
				armarOyentesSonido();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				buttons[1].setIcon(options[1]);
				bancoRecursos.playClick();

			}

			@Override
			public void mouseEntered(MouseEvent evento) {
				buttons[1].setIcon(options[0]);

			}

			@Override
			public void mouseExited(MouseEvent evento) {
				buttons[1].setIcon(options[2]);

			}

		});

		opcion1 = new JButton();
		opcion2 = new JButton();
		close = new JButton();
		dificultad = new JButton();

		opcion1.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/efectbotonreleased.png")));
		opcion2.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/musicbotonreleased.png")));
		close.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/close.png")));
		dificultad.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/dificultad.png")));

		musicOn = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/on.png")));
		musicOff = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/off.png")));
		efectsOn = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/on.png")));
		efectsOff = new JLabel(new ImageIcon(this.getClass().getResource("/resources/static/botones/off.png")));

		opcion1.setBounds(50, 200, opcion1.getIcon().getIconWidth(), opcion1.getIcon().getIconHeight());
		opcion2.setBounds(50, 300, opcion2.getIcon().getIconWidth(), opcion2.getIcon().getIconHeight());
		close.setBounds(110, 380, close.getIcon().getIconWidth(), close.getIcon().getIconHeight());
		musicOn.setBounds(110, 270, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());
		musicOff.setBounds(110, 270, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());
		efectsOn.setBounds(110, 170, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());
		efectsOff.setBounds(110, 170, musicOn.getIcon().getIconWidth(), musicOn.getIcon().getIconHeight());
		dificultad.setBounds(50, 100, dificultad.getIcon().getIconWidth(), dificultad.getIcon().getIconHeight());

		close.setBackground(Color.BLACK);
		close.setBorderPainted(false);
		close.setBorder(new LineBorder(Color.BLACK));
		close.setFocusPainted(false);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setToolTipText("Volver a inicio");

		opcionesDificultad();

	}

	public void armarOyentesSonido() {
		if (!oyentesSonido) {
			oyentesSonido = true;
			// oyente boton efectos
			opcion1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {

					if (onefects) {
						bancoRecursos.stopEfectos();
						opcion1.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/botones/efectbotonreleased.png")));
						onefects = false;
						efectsOff.setVisible(true);
						efectsOn.setVisible(false);
					}
					else {
						bancoRecursos.playEfectos();
						opcion1.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/botones/efectbotonreleased.png")));
						onefects = true;

						efectsOff.setVisible(false);
						efectsOn.setVisible(true);
					}

				}

				@Override
				public void mousePressed(MouseEvent e) {
					opcion1.setIcon(new ImageIcon(
							this.getClass().getResource("/resources/static/botones/efectbotonpresed.png")));
					bancoRecursos.playClick();

				}
			});

			// Oyente boton musica
			opcion2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {

					if (onmusic == true) {
						bancoRecursos.stopMusica();
						opcion2.setIcon(new ImageIcon(
								this.getClass().getResource("/resources/static/botones/musicbotonreleased.png")));
						onmusic = false;
						musicOff.setVisible(true);
						musicOn.setVisible(false);
					}
					else {
						if (onmusic == false) {
							bancoRecursos.playMusica();
							opcion2.setIcon(new ImageIcon(
									this.getClass().getResource("/resources/static/botones/musicbotonreleased.png")));
							onmusic = true;

							musicOff.setVisible(false);
							musicOn.setVisible(true);
						}
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {

					opcion2.setIcon(new ImageIcon(
							this.getClass().getResource("/resources/static/botones/musicbotonpressed.png")));
					bancoRecursos.playClick();

				}
			});

			close.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					opcion1.setVisible(false);
					opcion2.setVisible(false);
					close.setVisible(false);
					musicOn.setVisible(false);
					musicOff.setVisible(false);
					efectsOn.setVisible(false);
					efectsOff.setVisible(false);
					buttons[0].setVisible(true);
					buttons[1].setVisible(true);
					buttons[2].setVisible(true);
					dificultad.setVisible(false);
					if (ventanas == 2) {
						facil.setVisible(false);
						moderado.setVisible(false);
						dificil.setVisible(false);
						select.setVisible(false);
						info1.setVisible(false);
						info2.setVisible(false);
						info3.setVisible(false);
						ventanas = 0;
					}

				}

			});
		}
	}

	public void armarOpciones() {

		menupanel.add(musicOn);
		menupanel.add(close);
		menupanel.add(efectsOn);
		menupanel.add(musicOff);
		menupanel.add(efectsOff);
		menupanel.add(opcion1);
		menupanel.add(opcion2);
		menupanel.add(dificultad);

		if (onmusic) {
			musicOn.setVisible(true);
		}
		else {
			musicOff.setVisible(true);
		}

		if (onefects) {
			efectsOn.setVisible(true);
		}
		else {
			efectsOff.setVisible(true);
		}

		dificultad.setVisible(true);

	}

	public void armarAyuda() {
		menupanel.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/background/ayuda.png")));
		menupanel.add(close);
		close.setVisible(true);

		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				opcion1.setVisible(false);
				opcion2.setVisible(false);
				close.setVisible(false);
				buttons[0].setVisible(true);
				buttons[1].setVisible(true);
				buttons[2].setVisible(true);
				menupanel.setIcon(menuback);

			}

		});

	}

	public void opcionesDificultad() {

		dificultad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dificultad.setVisible(false);
				menupanel.setIcon(menuback);
				opcion1.setVisible(false);
				opcion2.setVisible(false);
				musicOn.setVisible(false);
				musicOff.setVisible(false);
				efectsOn.setVisible(false);
				efectsOff.setVisible(false);
				dificultad.setIcon(
						new ImageIcon(this.getClass().getResource("/resources/static/botones/dificultad.png")));
				ventanas = 2;
				dificultades();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				dificultad.setIcon(
						new ImageIcon(this.getClass().getResource("/resources/static/botones/dificultadpressed.png")));
			}

		});

	}

	public void dificultades() {

		facil = new JButton();
		moderado = new JButton();
		dificil = new JButton();
		select = new JLabel();
		info1 = new JButton();
		info2 = new JButton();
		info3 = new JButton();
		close1 = new JButton();

		info1.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/question2.png")));
		info2.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/question2.png")));
		info3.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/question2.png")));

		facil.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/easy.png")));
		moderado.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/medium.png")));
		dificil.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/hard.png")));
		select.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/check.png")));
		close1.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/close.png")));

		facil.setBounds(50, 100, dificultad.getIcon().getIconWidth(), dificultad.getIcon().getIconHeight());
		moderado.setBounds(50, 200, dificultad.getIcon().getIconWidth(), dificultad.getIcon().getIconHeight());
		dificil.setBounds(50, 300, dificultad.getIcon().getIconWidth(), dificultad.getIcon().getIconHeight());
		close1.setBounds(110, 380, close1.getIcon().getIconWidth(), close1.getIcon().getIconHeight());

		menupanel.add(info1);
		menupanel.add(info2);
		menupanel.add(info3);

		info1.setBounds(200, 110, info1.getIcon().getIconWidth(), info1.getIcon().getIconHeight());
		info1.setBackground(Color.BLACK);
		info1.setBorderPainted(false);
		info1.setBorder(new LineBorder(Color.BLACK));
		info1.setFocusPainted(false);
		info1.setOpaque(false);
		info1.setContentAreaFilled(false);

		info2.setBounds(200, 210, info2.getIcon().getIconWidth(), info2.getIcon().getIconHeight());
		info2.setBackground(Color.BLACK);
		info2.setBorderPainted(false);
		info2.setBorder(new LineBorder(Color.BLACK));
		info2.setFocusPainted(false);
		info2.setOpaque(false);
		info2.setContentAreaFilled(false);

		info3.setBounds(200, 310, info3.getIcon().getIconWidth(), info3.getIcon().getIconHeight());
		info3.setBackground(Color.BLACK);
		info3.setBorderPainted(false);
		info3.setBorder(new LineBorder(Color.BLACK));
		info3.setFocusPainted(false);
		info3.setOpaque(false);
		info3.setContentAreaFilled(false);

		close1.setBackground(Color.BLACK);
		close1.setBorderPainted(false);
		close1.setBorder(new LineBorder(Color.BLACK));
		close1.setFocusPainted(false);
		close1.setOpaque(false);
		close1.setContentAreaFilled(false);
		close1.setVisible(false);

		menupanel.add(select);
		menupanel.add(facil);
		menupanel.add(moderado);
		menupanel.add(dificil);
		menupanel.add(close1);

		dificultadesOyentes();

	}

	public void dificultadesOyentes() {

		facil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				facil.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/easy.png")));
				select.setBounds(10, 105, select.getIcon().getIconWidth(), select.getIcon().getIconHeight());
				select.setVisible(true);
				difficulty = 2;

			}

			@Override
			public void mousePressed(MouseEvent e) {
				facil.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/easypressed.png")));
			}

		});

		moderado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				moderado.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/medium.png")));
				select.setBounds(10, 205, select.getIcon().getIconWidth(), select.getIcon().getIconHeight());
				select.setVisible(true);
				difficulty = 3;

			}

			@Override
			public void mousePressed(MouseEvent e) {
				moderado.setIcon(
						new ImageIcon(this.getClass().getResource("/resources/static/botones/mediumpressed.png")));
			}

		});

		dificil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dificil.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/botones/hard.png")));
				select.setBounds(10, 305, select.getIcon().getIconWidth(), select.getIcon().getIconHeight());
				select.setVisible(true);
				difficulty = 4;

			}

			@Override
			public void mousePressed(MouseEvent e) {
				dificil.setIcon(
						new ImageIcon(this.getClass().getResource("/resources/static/botones/hardpressed.png")));
			}

		});

		info1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				menupanel.setIcon(
						new ImageIcon(this.getClass().getResource("/resources/static/background/easyinfo.png")));
				facil.setVisible(false);
				dificil.setVisible(false);
				moderado.setVisible(false);
				select.setVisible(false);
				info1.setVisible(false);
				info2.setVisible(false);
				info3.setVisible(false);
				close1.setVisible(true);
				close.setVisible(false);

			}

		});

		info2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

				menupanel.setIcon(
						new ImageIcon(this.getClass().getResource("/resources/static/background/mediuminfo.png")));
				facil.setVisible(false);
				dificil.setVisible(false);
				moderado.setVisible(false);
				select.setVisible(false);
				info1.setVisible(false);
				info2.setVisible(false);
				info3.setVisible(false);
				close1.setVisible(true);
				close.setVisible(false);

			}

		});

		info3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				menupanel.setIcon(
						new ImageIcon(this.getClass().getResource("/resources/static/background/hardinfo.png")));
				facil.setVisible(false);
				dificil.setVisible(false);
				moderado.setVisible(false);
				select.setVisible(false);
				info1.setVisible(false);
				info2.setVisible(false);
				info3.setVisible(false);
				close1.setVisible(true);
				close.setVisible(false);

			}

		});

		close1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				menupanel.setIcon(menuback);
				facil.setVisible(true);
				dificil.setVisible(true);
				moderado.setVisible(true);
				select.setVisible(true);
				info1.setVisible(true);
				info2.setVisible(true);
				info3.setVisible(true);
				close1.setVisible(false);
				close.setVisible(true);

			}

		});

		if (difficulty == 2) {
			select.setBounds(10, 105, select.getIcon().getIconWidth(), select.getIcon().getIconHeight());
			select.setVisible(true);

		}
		if (difficulty == 3) {
			select.setBounds(10, 205, select.getIcon().getIconWidth(), select.getIcon().getIconHeight());
			select.setVisible(true);
		}
		if (difficulty == 4) {
			select.setBounds(10, 305, select.getIcon().getIconWidth(), select.getIcon().getIconHeight());
			select.setVisible(true);
		}

	}

	public int getDificultad() {
		return difficulty;
	}

}