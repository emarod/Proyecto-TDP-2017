package interfaz;

import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.*;
import main.Juego;


public class GUI extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
    private Thread hilo;	
	private static Juego juego;

	public GUI(final Juego j) {	
		super("The Wall Defense");
		getContentPane().setLayout(null);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 618);
		setLocationRelativeTo(null);
		
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		hilo=new Thread(this);
		hilo.start();
		GUI.juego=j;
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
