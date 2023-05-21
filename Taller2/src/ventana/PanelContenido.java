package ventana;

import ventana.dibujo.PanelJuego;
import ventana.dibujo.PanelReproduccion;
import ventana.dibujo.PanelUIB;
import ventana.panelActividades.PanelBotonReproduccion;
import ventana.panelActividades.PanelTeclas;
import ventana.panelActividades.PanelTitulo;

import javax.swing.*;
import java.awt.*;

public class PanelContenido extends JPanel {
    public static JSplitPane jsp;
    public static JSplitPane jspComponents;
    public static JSplitPane jspPrincipal;
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
        }
    }

    public void cambiarAReproducido() {
        jsp.setRightComponent(new PanelTitulo());
        jsp.setDividerLocation(500);
    }

}