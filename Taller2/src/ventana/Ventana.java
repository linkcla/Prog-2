package ventana;

import javax.swing.*;

public class Ventana extends JFrame {
    public static PanelContenido panelContenido = new PanelContenido();
    public Ventana() {
        inicializarFrame("TALLER 2", 700, 700);
    }

    private void inicializarFrame(String titulo, int ancho, int alto) {
        setTitle(titulo);
        setSize(ancho,alto);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panelContenido);
        setVisible(true);
    }

}
