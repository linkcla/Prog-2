package ventana;

import javax.swing.*;
import java.awt.*;

/**
 * En esta clase encontramos el panlen que contiene los botones CREAR, REPRODUCIR, ADIVINAR y SALIR.
 */
public class PanelBotones extends JPanel {
    private JButton [] componentes = new JButton[4];

    public PanelBotones() {
        setLayout(new GridLayout(1,4));
        inicializarBotones();
        addlisteners();
        addAPanel();
    }

    private void inicializarBotones() {
        String [] nombres = {"CREAR", "REPRODUCIR", "ADIVINAR", "SALIR"};

        for (int i = 0; i < nombres.length; i++) {
            componentes[i] = new JButton(nombres[i]);
            componentes[i].setBackground(Color.black);
            componentes[i].setFont(new Font("Arial",Font.BOLD,20));
            componentes[i].setForeground(Color.white);
            componentes[i].setFocusPainted(false);
        }

    }

    private void addlisteners() {
        componentes[0].addActionListener(e -> Ventana.panelContenido.cambiarAJuego());
        componentes[1].addActionListener(e -> Ventana.panelContenido.cambiarAReproduccion());
        componentes[2].addActionListener(e -> Ventana.panelContenido.cambiarAAdivinar());
        componentes[3].addActionListener(e -> System.exit(0));
    }

    private void addAPanel() {
        for (int i = 0; i < componentes.length ; i++) {
            add(componentes[i]);
        }
    }


}
