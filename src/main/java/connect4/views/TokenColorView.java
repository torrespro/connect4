package connect4.views;

import connect4.Console;
import connect4.types.TokenColor;

class TokenColorView {

    void write(TokenColor color) {
        String string = color.name();
        if (color == null) {
            string = " ";
        }
        Console.getInstance().write(string);
    }
    
}
