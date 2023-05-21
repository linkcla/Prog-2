package ventana;

import ventana.dibujo.PanelAdivinar;
import ventana.dibujo.PanelJuego;
import ventana.dibujo.PanelReproduccion;
import ventana.dibujo.PanelUIB;
import ventana.panelActividades.PanelBotonReproduccion;
import ventana.panelActividades.PanelTeclas;
import ventana.panelActividades.PanelTeclasAdivinar;
import ventana.panelActividades.PanelTitulo;
import javax.swing.*;
import java.awt.*;

/**
 * Esta clase es la principal, se encarga de gestionar los paneles que se visualizan
 * en la pantalla. Tiene una serie de metodos que permiten cambiar su visualizaciñon
 * desde otras clases.
 */
public class PanelContenido extends JPanel {
    private  JSplitPane jsp;
    private  JSplitPane jspComponents;
    private  JSplitPane jspPrincipal;
    private PanelJuego panelJuego;

    public PanelContenido() {
        setLayout(new BorderLayout());

        jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new PanelUIB(),new PanelTitulo());
        jsp.setEnabled(false);
        jsp.setDividerLocation(500);

        jspComponents = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jsp,new PanelBotones());
        jspComponents.setDividerLocation(575);
        jspComponents.setEnabled(false);

        jspPrincipal = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jspPrincipal.setBottomComponent(jspComponents); //Para que salga el remarco de arriba
        jspPrincipal.setEnabled(false);

        add(jspPrincipal);

        setVisible(true);
    }

    public void cambiarAJuego() {
        panelJuego = new PanelJuego();

        jsp.setLeftComponent(panelJuego);
        jsp.setRightComponent(new PanelTeclas(panelJuego));
        jsp.setDividerLocation(500);
    }

    public void cambiarADefault() {
        jsp.setLeftComponent(new PanelUIB());
        jsp.setRightComponent(new PanelTitulo());
        jsp.setDividerLocation(500);
    }

    public void cambiarAReproduccion() {
        if(panelJuego != null){
            PanelReproduccion panelReproduccion = new PanelReproduccion(panelJuego.getNotasUsadas());
            jsp.setLeftComponent(panelReproduccion);
            jsp.setRightComponent(new PanelBotonReproduccion(panelReproduccion));
            jsp.setDividerLocation(500);
        } else {
            JOptionPane.showMessageDialog(null,"PRIMERO DEBES CREAR UNA MELODIA");
        }
    }

    public void cambiarAReproducido() {
        jsp.setRightComponent(new PanelTitulo());
        jsp.setDividerLocation(500);
    }

    public void cambiarAAdivinar() {
        if(panelJuego != null){
            PanelAdivinar panelAdivinar = new PanelAdivinar(panelJuego.getNotasUsadas());

            jsp.setLeftComponent(panelAdivinar);
            jsp.setRightComponent(new PanelTeclasAdivinar(panelAdivinar));
            jsp.setDividerLocation(500);
        } else {
            JOptionPane.showMessageDialog(null,"PRIMERO DEBES CREAR UNA MELODIA");
        }

    }

}