import javax.swing.*;
import java.awt.*;

public class PanelComponentes extends JPanel {
    private JButton [] componentes = new JButton[4];
    public PanelComponentes(){
        setLayout(new GridLayout(1,4));
        inicializarBotones();
        añadirlisteners();
        añadirAPanel();
    }

    private void inicializarBotones(){
        String [] nombres = {"CREAR", "REPRODUCIR", "ADIVINAR", "SALIR"};
        for (int i = 0; i < nombres.length; i++) {
            componentes[i] = new JButton(nombres[i]);
            componentes[i].setBackground(Color.black);
            componentes[i].setFont(new Font("Arial",Font.BOLD,20));
            componentes[i].setForeground(Color.white);
            componentes[i].setFocusPainted(false);
        }

    }

    private void añadirlisteners() {
        componentes[0].addActionListener(e -> System.out.println("klk"));
        componentes[1].addActionListener(e -> System.out.println("klk"));
        componentes[2].addActionListener(e -> System.out.println("klk"));
        componentes[3].addActionListener(e -> System.exit(0));
    }

    private void añadirAPanel() {
        for (int i = 0; i < componentes.length ; i++) {
            add(componentes[i]);
        }
    }


}
