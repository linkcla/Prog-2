package ventana.panelActividades;

import ventana.dibujo.PanelReproduccion;

import javax.swing.*;
import java.awt.*;

public class PanelBotonReproduccion extends JPanel {

    public PanelBotonReproduccion(PanelReproduccion panelReproduccion) {
        setLayout(new BorderLayout());
        setSize(700,100);

        JButton jb = new JButton(">");
        jb.addActionListener(e -> panelReproduccion.reproducir());
        jb.setFont(new Font("Arial",Font.BOLD,40));
        jb.setBackground(Color.black);
        jb.setForeground(Color.lightGray);

        add(jb);
    }
}
