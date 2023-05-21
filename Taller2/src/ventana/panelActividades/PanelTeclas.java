package ventana.panelActividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import notas.*;
import ventana.dibujo.PanelJuego;
import ventana.Ventana;

public class PanelTeclas extends JPanel implements ActionListener {
    private JButton [] botonesSonidos = new JButton[8];
    private PanelJuego pJuego;

    public PanelTeclas(PanelJuego panelJuego) {
        this.pJuego = panelJuego;

        setLayout(new GridLayout(1,8,4,0));
        inicializarTeclas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sonido = e.getActionCommand().toLowerCase();

        if(e.getActionCommand().equals("FIN")) {
            Ventana.panelContenido.cambiarADefault();
            return;
        }

        pJuego.addNota(Notas.valueOf(e.getActionCommand()));

        new ReproducirSonido(sonido);
    }

    private void inicializarTeclas() {
        String[] nombreBotonesSonido = {"DO","RE","MI","FA","SOL","LA","SI","FIN"};
        Color[] coloresBotonesSonido = {Color.red, Color.pink, Color.cyan, Color.yellow, Color.magenta, Color.white, Color.green, Color.black};

        for (int i = 0; i < botonesSonidos.length; i++) {
            JButton botonesSonido = new JButton(nombreBotonesSonido[i]);

            botonesSonido.setFont(new Font("Arial",Font.BOLD,20));
            if(coloresBotonesSonido[i] == Color.black) botonesSonido.setForeground(Color.white);
            botonesSonido.setBackground(coloresBotonesSonido[i]);
            botonesSonido.addActionListener(this);

            botonesSonidos[i] = botonesSonido;
            add(botonesSonido);
        }
    }

}
