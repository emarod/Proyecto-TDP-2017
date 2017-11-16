package tokens;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OyenteToken extends MouseAdapter {

	protected Token token;

	@Override
	public void mousePressed(MouseEvent e) {
		token.aplicar();
	}

	public void setToken(Token tk) {
		token = tk;
	}

}
