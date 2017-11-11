package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controladores.BancoRecursos;
import main.Juego;

/*
 * Clase MenuInicio.
 * Clase encargada de desplegar el menu de inicio.
 */

public class MenuInicio extends JPanel {
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected Icon menuback;
	protected JLabel menupanel;
	protected Icon newGame[];
	protected Icon help[];
	protected Icon options[];
	protected JButton buttons[];
	protected Juego game;
	protected BancoRecursos bancoRecursos;

	//Constructor.
	public MenuInicio(Juego game) {
		
		this.game=game;
		bancoRecursos=new BancoRecursos();
		
		armarIconos();
		armarBotonera();
		oyentes();
		
		this.setBounds(235,0 , 243, 420);
		this.setLayout(new BorderLayout());
		menuback=new ImageIcon(this.getClass().getResource("/resources/static/background/menu3.png"));
		menupanel=new JLabel();
		menupanel.setIcon(menuback);
		menupanel.setSize(243,423);
		this.add(menupanel);		
		
	}
	
	//Metodos locales.
	public void armarIconos() {
		newGame=new Icon[3];
		help=new Icon[3];
		options=new Icon[3];
		
		for(int i=0;i<3;i++) {
			newGame[i]=new ImageIcon(this.getClass().getResource("/resources/static/botones/ngbutton"+(i+1)+".png"));
			help[i]=new ImageIcon(this.getClass().getResource("/resources/static/botones/helpbutton"+(i+1)+".png"));
			options[i]=new ImageIcon(this.getClass().getResource("/resources/static/botones/optionsbutton"+(i+1)+".png"));
		}

	}
	
	public void armarBotonera() {
		
		buttons=new JButton[3];
		
		buttons[0]=new JButton();
		buttons[0].setIcon(newGame[2]);
		buttons[0].setBounds(50, 100, buttons[0].getIcon().getIconWidth(), buttons[0].getIcon().getIconHeight());
		
		buttons[1]=new JButton();
		buttons[1].setIcon(options[2]);
		buttons[1].setBounds(50, 200, buttons[1].getIcon().getIconWidth(), buttons[1].getIcon().getIconHeight());

		
		buttons[2]=new JButton();
		buttons[2].setIcon(help[2]);
		buttons[2].setBounds(50, 300, buttons[2].getIcon().getIconWidth(), buttons[2].getIcon().getIconHeight());
		
		for(int i=0;i<3;i++) {
			this.add(buttons[i]);
		}
	}
		
	public void oyentes() {
			
			//Oyente boton new game crea GUI
			buttons[0].addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							game.crearGUI();
						}
					}
				);		
			
			//Oyentes boton new game
			
			buttons[0].addMouseListener(
					new MouseAdapter() {
						public void mouseReleased(MouseEvent e) {
							buttons[0].setIcon(newGame[2]);
						}
						
						public void mousePressed(MouseEvent e) {
							buttons[0].setIcon(newGame[1]);
							bancoRecursos.playClick();

						}
						
						public  void mouseEntered(MouseEvent evento) {
							buttons[0].setIcon(newGame[0]);

						}
						
						public  void mouseExited(MouseEvent evento) {
							buttons[0].setIcon(newGame[2]);

						}
						
					}
				);
			
			//Oyentes boton help
			
			
			buttons[2].addMouseListener(
					new MouseAdapter() {
						public void mouseReleased(MouseEvent e) {
							buttons[2].setIcon(help[2]);
						}
						
						public void mousePressed(MouseEvent e) {
							buttons[2].setIcon(help[1]);
							bancoRecursos.playClick();

						}
						
						public  void mouseEntered(MouseEvent e) {
							buttons[2].setIcon(help[0]);

						}
						
						public  void mouseExited(MouseEvent evento) {
							buttons[2].setIcon(help[2]);

						}
						
					}
				);
			
			//Oyentes boton options
			
			
			buttons[1].addMouseListener(
					new MouseAdapter() {
						public void mouseReleased(MouseEvent e) {
							buttons[1].setIcon(options[2]);
						}
						
						public void mousePressed(MouseEvent e) {
							buttons[1].setIcon(options[1]);
							bancoRecursos.playClick();

						}
						
						public  void mouseEntered(MouseEvent evento) {
							buttons[1].setIcon(options[0]);

						}
						
						public  void mouseExited(MouseEvent evento) {
							buttons[1].setIcon(options[2]);

						}
						
					}
				);
			
		}
			
	
	
	
	

}
