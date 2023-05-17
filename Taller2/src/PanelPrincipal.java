import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public static JSplitPane jsp;
    public static JSplitPane jspComponents;
    public PanelPrincipal(){
        setLayout(new BorderLayout());
        jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new PanelUIB(),new PanelTitulo());
        jsp.setEnabled(false);
        jsp.setDividerLocation(500);
        jspComponents = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jsp,new PanelComponentes());
        jspComponents.setDividerLocation(600);
        add(jspComponents);

        setVisible(true);
    }
}
