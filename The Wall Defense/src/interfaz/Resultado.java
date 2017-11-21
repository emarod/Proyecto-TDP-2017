package interfaz;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controladores.BancoRecursos;
import Controladores.Director;
import main.Juego;

public class Resultado extends JPanel {

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
	protected boolean onefects;
	protected boolean onmusic;
	protected boolean oyentesCreados;
	protected JLabel musicOn, efectsOn;
	protected JLabel musicOff, efectsOff;

	// Constructor.
	public Resultado(Juego game, boolean result) {

		this.game = game;
		bancoRecursos = Director.getBancoRecursos();
		this.setBounds(235, 55, 235, 361);
		this.setLayout(new BorderLayout());
		if (result) {
			menuback = new ImageIcon(this.getClass().getResource("/resources/static/background/victory.png"));
		}
		else {
			menuback = new ImageIcon(this.getClass().getResource("/resources/static/background/defeat.png"));
		}
		menupanel = new JLabel();
		menupanel.setIcon(menuback);
		menupanel.setSize(243, 423);
		this.add(menupanel);

	}

}
