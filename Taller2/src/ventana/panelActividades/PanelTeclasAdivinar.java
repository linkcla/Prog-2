package ventana.panelActividades;

import notas.Notas;
import notas.ReproducirSonido;
import ventana.Ventana;
import ventana.dibujo.PanelAdivinar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTeclasAdivinar extends JPanel implements ActionListener {
    private JButton [] botonesSonidos = new JButton[8];
    private PanelAdivinar panelAdivinar;
    private int palabrasIntroducidas = 0;



    public PanelTeclasAdivinar(PanelAdivinar panelAdivinar) {
        this.panelAdivinar = panelAdivinar;
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
        panelAdivinar.addNotaSiEsCorrecta(Notas.valueOf(e.getActionCommand()));
        palabrasIntroducidas++;

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

    public int getPalabrasIntroducidas(){
        return palabrasIntroducidas;
    }

}
