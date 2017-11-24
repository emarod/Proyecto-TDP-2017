package objetos;

public interface Unit extends ObjetoCelda {

	public abstract Unit clone();

	public abstract void guardarInicio();

	public abstract void regresarInicio();

	public abstract void guardarEstado(String save);

	public abstract void regresarUltimo();

	public abstract void reset(String save);

	public abstract int getVelocidad();

	public abstract void setVelocidad(int v);

	public abstract void setDaño(int d);

	public abstract int getDaño();
}
