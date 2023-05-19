import javax.swing.*;
import java.awt.*;

public class PanelReproduccion extends JPanel {
    public PanelReproduccion() {
        setLayout(new BorderLayout());
        JButton jb = new JButton(">");
        jb.addActionListener(e -> System.out.println("Reproducir"));
        jb.setFont(new Font("Arial",Font.BOLD,40));
        jb.setBackground(Color.black);
        jb.setForeground(Color.lightGray);
        add(jb);
        setSize(700,100);
    }
}
