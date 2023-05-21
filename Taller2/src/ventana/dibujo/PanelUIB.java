package ventana.dibujo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelUIB extends JPanel {
    public PanelUIB() {
        BufferedImage imagenUIB;
        try {
            imagenUIB = ImageIO.read(new File("assets/imgUIB.jpg"));
        } catch(IOException ioEx) {
            throw new RuntimeException(ioEx);
        }
        JLabel imagen = new JLabel(new ImageIcon(imagenUIB.getScaledInstance(700,500,0)));
        add(imagen);
        setVisible(true);
    }
}
