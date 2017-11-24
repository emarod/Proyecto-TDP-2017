package objetos;

import main.Visitor;

public interface Visitable {

	public abstract Visitor getVisitor();
}
