import javax.swing.*;
import java.awt.*;

public class PanelTitulo extends JPanel {
    private JLabel jlb;
    public PanelTitulo() {
        setLayout(new BorderLayout());
        darFormatoJLabel();
        add(jlb);
        setVisible(true);
    }

    private void darFormatoJLabel() {

        jlb = new JLabel("TALLER 2 - PROGRAMACIÓN II - CURSO 2022-23");
        jlb.setFont(new Font("ARIAL" , Font.BOLD,20));
        jlb.setOpaque(true);
        jlb.setForeground(Color.lightGray);
        jlb.setBackground(Color.black);
        jlb.setSize(700,100);
        jlb.setHorizontalAlignment(0);
    }
}
