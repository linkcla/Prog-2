package ventana.dibujo;

import javax.swing.*;
import notas.*;
import ventana.Ventana;

import java.awt.*;

/**
 * Esta clase sirve para mostar el panel donde se van ubicando las notas que se reproducen
 */
public class PanelReproduccion extends JPanel {
    private Notas[] notasUsadas;
    private JButton[] button = new JButton[110];
    private int indice = 0;
    public PanelReproduccion (Notas[] notasUsadas) {
        this.notasUsadas = notasUsadas;
        setLayout(new GridLayout(10,11,10,10));
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

        for (int i = 0; i < notasUsadas.length; i++) {
            if(notasUsadas[i] == null) return;
            button[i].setBackground(notasUsadas[i].getColor());
        }

    }

    public void reproducir() {

        if(notasUsadas[indice] == null){
            Ventana.panelContenido.cambiarAReproducido();
            //Por si se entra en la opción de reproducir habiendo entrado a la opción de jugar pero sin haber jugado.
            if(indice == 0) Ventana.panelContenido.cambiarADefault();
            return;
        }
        if(indice == 0) {
            for (int i = 0; i < button.length; i++) {
                button[i].setBackground(Color.BLACK);
            }
        }

        new ReproducirSonido(notasUsadas[indice].name().toLowerCase());
        button[indice].setBackground(notasUsadas[indice].getColor());
        indice++;


    }

}
