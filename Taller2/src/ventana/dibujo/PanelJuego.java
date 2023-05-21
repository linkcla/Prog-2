package ventana.dibujo;

import javax.swing.*;
import java.awt.*;
import notas.*;
import ventana.Ventana;

public class PanelJuego extends JPanel {
    private JButton[] button = new JButton[110];
    private Notas[] notasUsadas = new Notas[110];
    private int indice = 0;

    /**
     * Esta clase sirve para mostar el panel donde se van ubicando las notas que se tocan.
     */
    public PanelJuego() {
        setLayout(new GridLayout(10,11,10,10));
        setBackground(Color.black);

        inicializarBotonesAColorNegro();

        setVisible(true);
    }

    private void inicializarBotonesAColorNegro() {
        for (int i = 0; i < 110; i++) {
            JButton jButton = new JButton("");
            jButton.setBackground(Color.BLACK);
            jButton.setBorder(BorderFactory.createEmptyBorder());
            jButton.setEnabled(false);

            button[i] = jButton;
            add(jButton);
        }
    }

    public void addNota(Notas nota) {
        if(indice == 110) {
            Ventana.panelContenido.cambiarADefault();
            return;
        }

        notasUsadas[indice] = nota;

        button[indice].setBackground(nota.getColor());

        indice++;
    }

    public Notas[] getNotasUsadas() {
        return notasUsadas;
    }
}
