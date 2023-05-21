package notas;

import java.awt.*;

public enum Notas {
    DO(Color.RED),
    RE(Color.PINK),
    MI(Color.CYAN),
    FA(Color.YELLOW),
    SOL(Color.MAGENTA),
    LA(Color.WHITE),
    SI(Color.GREEN);

    private Color color;
    Notas(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
}
