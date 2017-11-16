package Controladores;

import java.util.concurrent.ConcurrentLinkedDeque;

/*
 * Implementacion de XORShift para generar numeros de calidad media y de forma rápida.
 */
public class RandomGenerator {

	private long last;
	protected ConcurrentLinkedDeque<Integer> guardados;

	public RandomGenerator() {
		this(System.currentTimeMillis());
		guardados = new ConcurrentLinkedDeque<>();

	}

	public RandomGenerator(long seed) {
		this.last = seed;
	}

	public int nextInt(int max) {
		last ^= (last << 21);
		last ^= (last >>> 35);
		last ^= (last << 4);
		int out = (int) last % max;
		return (out < 0) ? -out : out;
	}

	public int poll(int max) {
		int salida;
		if (!guardados.isEmpty()) {
			salida = guardados.pollFirst();
			guardados.addLast(salida);
			salida = salida % max;
		}
		else {
			salida = nextInt(max);
		}
		return salida;
	}

	public void generar(int cant, int max) {
		last = System.currentTimeMillis();
		guardados.clear();
		for (int i = 0; i < cant; i++) {
			guardados.add(nextInt(max));
		}
	}

}