package es.torres.connect4.views.console;

import es.torres.connect4.types.TokenColor;

class TokenColorView {

    void write(TokenColor color) {
        String string = color.name();
        if (color == null) {
            string = " ";
        }
        Console.getInstance().write(string);
    }
    
}
