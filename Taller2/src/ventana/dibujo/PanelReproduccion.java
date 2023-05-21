package ventana.dibujo;

import javax.swing.*;
import notas.*;
import ventana.Ventana;

import java.awt.*;

public class PanelReproduccion extends JPanel {
    private Notas[] notasUsadas;
    private JButton[] button = new JButton[110];
    private int indice = 0;
    public PanelReproduccion (Notas[] notasUsadas) {
        this.notasUsadas = notasUsadas;
        setLayout(new GridLayout(11,10,10,10));
        setBackground(Color.black);

        inicializarTablero();

        setVisible(true);
    }

    private void inicializarTablero() {
        for (int i = 0; i <button.length ; i++) {
            JButton jButton = new JButton("");
            jButton.setBackground(Color.BLACK);
            jButton.setBorder(BorderFactory.createEmptyBorder());
            jButton.setEnabled(false);

            button[i] = jButton;
            add(jButton);
        }
    }

    public void reproducir() {
        new ReproducirSonido(notasUsadas[indice].name().toLowerCase());
        button[indice].setBackground(notasUsadas[indice].getColor());
        indice++;
        if(notasUsadas[indice] == null){
            Ventana.panelContenido.cambiarAReproducido();
        }
    }

}
