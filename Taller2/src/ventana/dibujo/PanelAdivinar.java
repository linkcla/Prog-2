package ventana.dibujo;

import javax.swing.*;
import java.awt.*;

import notas.*;
import ventana.Ventana;

/**
 * Esta clase sirve para implemetar el panen donde se muestran las notas que vas adivinando.
 * Encontramos addNotaSiEsCorrecta que implementa la logica para saber si la tecla nota
 * introducida es correcta.
 */
public class PanelAdivinar extends JPanel {
    private JButton[] button = new JButton[110];
    private Notas[] notasAAdivinar;
    private int indice = 0;
    public PanelAdivinar(Notas[] notasAAdivinar) {

        this.notasAAdivinar = notasAAdivinar;
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

    public void addNotaSiEsCorrecta(Notas nota) {

        if(notasAAdivinar[indice] == nota){
            button[indice].setBackground(nota.getColor());
            try{
                if(notasAAdivinar[indice+1] == null){
                    new ReproducirSonido("campeones");
                    JOptionPane.showMessageDialog(null,"HAS GANADO");
                    Ventana.panelContenido.cambiarADefault();
                }
            }catch (IndexOutOfBoundsException e){
                new ReproducirSonido("campeones");
                JOptionPane.showMessageDialog(null,"HAS GANADO");
                Ventana.panelContenido.cambiarADefault();
            }

            indice++;
        } else {
            new ReproducirSonido("error");
        }

    }
}
