import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    public static JSplitPane jsp;
    public static JSplitPane jspComponents;
    public static JSplitPane jspPrincipal;
    public PanelPrincipal(){
        setLayout(new BorderLayout());
        jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new PanelUIB(),new PanelTeclas());
        jsp.setEnabled(false);
        jspComponents = new JSplitPane(JSplitPane.VERTICAL_SPLIT,jsp,new PanelComponentes());
        jspComponents.setDividerLocation(575);
        jspComponents.setEnabled(false);
        jspPrincipal = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        jspPrincipal.setBottomComponent(jspComponents); //Para que salga el remarco de arriba
        add(jspPrincipal);

        setVisible(true);
    }
}
