package Controladores;

/*
 * Implementacion de XORShift para generar numeros de calidad media y de forma rápida.
 */
public class RandomGenerator {

	private long last;

	public RandomGenerator() {
		this(System.currentTimeMillis());
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

}