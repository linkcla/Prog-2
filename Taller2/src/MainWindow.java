import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        inicializarFrame("TALLER 2", 700, 700);
    }

    private void inicializarFrame(String titulo, int ancho, int alto) {
        setTitle(titulo);
        setSize(ancho,alto);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new PanelPrincipal());
        setVisible(true);
    }

}
