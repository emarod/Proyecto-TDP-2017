package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class PopUp extends JOptionPane {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel panel;
	protected Frame frame;
	protected JLabel imagen;
	protected ImageIcon fondo;

	public PopUp() {

	}

	public void ErrorArbol() {
		UIManager UI = new UIManager();
		UI.put("OptionPane.background", Color.black);
		UI.put("Panel.background", Color.black);
		UIManager.put("OptionPane.messageFont",
				new FontUIResource(new Font("ArcadeClassic", Font.CENTER_BASELINE, 18)));

		fondo = new ImageIcon(this.getClass().getResource("/resources/static/background/icon.jpg"));

		JOptionPane.showMessageDialog(null,
				"<html><html><font color='white'>Manual: E l  objetivo  es  defender  el  muro <br> "
						+ "<br> de  los  caminantes  blancos . <br> "
						+ "<br>Situe  estrategicamente  los  personajes <br> "
						+ "<br>en el mapa para luchar contra las tropas<br> "
						+ "<br>del  Night  King  y  asi  poder  salvar  el  Gran  Muro.</html> </font></html>",
				"Instrucciones de juego", JOptionPane.INFORMATION_MESSAGE, fondo);
	}

	public JPanel armarPanel() {
		fondo = new ImageIcon(this.getClass().getResource("/resources/static/background/background.png"));
		panel = new JPanel();
		imagen = new JLabel(fondo);
		panel.add(imagen);
		return panel;

	}

}
