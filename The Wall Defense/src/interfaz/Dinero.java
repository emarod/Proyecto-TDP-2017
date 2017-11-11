package interfaz;
/*
 * Clase Dinero.
 * Clase encargada de mostrar la cantidad de dinero.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Dinero extends JPanel{
	
	//Atributos locales.
	protected static final long serialVersionUID = 1L;
	protected JLabel monto;
	protected Escenario escenario;
	protected Icon coin;
	protected int dinero;
	
	//Constructor.
	public Dinero(Escenario esc) {
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.escenario=esc;
		agregarLabel();
		this.setBackground(Color.BLACK);	
		dinero=200;
	}
	
	//Metodos locales.
	private void agregarLabel() {
		monto=new JLabel(""+dinero);
		monto.setSize(monto.getWidth(), this.getHeight());
		//Recojo la fuente que se esta utilizando actualmente.
		Font auxFont=new Font("ArcadeClassic", Font.CENTER_BASELINE,50); 
		//Aplico la fuente actual, y al final le doy el tamaño del texto...
		monto.setForeground(Color.WHITE);
		monto.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		this.add(monto,BorderLayout.EAST);
		
		coin=new ImageIcon(this.getClass().getResource("/resources/static/etiquetas/coin.png"));
		this.add(new JLabel(coin), BorderLayout.WEST);		 
	}
	
	
	public void setMontoCompra(int m) {
		dinero=dinero-m;
		monto.setText(""+(dinero));
	}
	
	public void setMontoGanancia(int m) {
		dinero+=m;
		monto.setText(""+(dinero));
	}
	
	public int getTotal() {
		return dinero;
	}
	
}