import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {
    private JLabel [][] label;
    public PanelJuego() {
        //todo el tema de pintar las melodia
        setLayout(new GridLayout(11,10,4,4));
        label = new JLabel[10][11];
        inicializarLabelsAColorNegro();
    }


    //no funciona
    private void inicializarLabelsAColorNegro() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                label[i][j] = new JLabel("");
                label[i][j].setBackground(Color.black);
                add(label[i][j]);
            }
        }
    }
}
