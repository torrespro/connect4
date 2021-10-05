package connect4;

import java.util.Objects;

public class Token {
	private TokenColor color;

	public Token(TokenColor color) {
		this.color = color;
	}

	public TokenColor getColor() {
		return color;
	}

	@Override
	public boolean equals(Object o) {
		// self check
		if (this == o)
			return true;
		// null check
		if (o == null)
			return false;
		// type check and cast
		if (getClass() != o.getClass())
			return false;
		Token token = (Token) o;
		// field comparison
		return Objects.equals(color, token.getColor());
		
	}
}
