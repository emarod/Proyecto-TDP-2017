package interfaz.botones;

import javax.swing.ImageIcon;
import interfaz.Escenario;
import obstaculo.Obstaculo;
import obstaculo.Barricada;
import mapa.Celda;

/*
 * Clase BtnBarricada.
 * Clase encargada del boton para el despliegue de una barricadao.
 */

public class BtnBarricada extends BtnObstaculo{
	
		//Atributos locales.
		protected static final long serialVersionUID = 1L;
		
		//Constructor.
		public BtnBarricada(Escenario e) {
			super(e);
			Celda [] c = new Celda[4];
			obstaculo = new Obstaculo(c, 3, new Barricada());
			this.setIcon(new ImageIcon(this.getClass().getResource("/resources/static/terrenos/barricada/barricada_3.png")));
		};
		
		//Metodos heredados.
		public void create() {
			stage.getMapa().crearObstaculo(obstaculo);		
			
		}
}
