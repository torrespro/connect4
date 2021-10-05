package connect4;

public enum TokenColor {
	
	YELLOW('X'), RED('O');

	private final char symbol;

	TokenColor(char symbol){
		this.symbol=symbol;
	}

	public char getSymbol(){
		return symbol;
	}
}
