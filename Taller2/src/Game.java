import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Game extends JFrame {
    private JPanel panelTeclas = new JPanel();
    private JPanel panelDibujo = new JPanel();
    private JPanel panelOpciones = new JPanel();
    private JSplitPane s1,s2,s3;
    public Game(){
        inicializarFrame("TALLER 2", 1300, 850);
    }

    private void inicializarFrame(String s, int width, int height) {
        setTitle(s);
        setSize(width,height);
        setResizable(false);
        setVisible(true);
        setContentPane(mainPanel());
    }

    private JPanel mainPanel() {
        JPanel c = new JPanel();
        crearVentana();
        crearTeclas();
        crearOpciones();
        s1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panelDibujo,panelTeclas);
        s1.setEnabled(false);
        s2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,s1,panelOpciones);
        s2.setEnabled(false);
        s3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        s3.setEnabled(false);
        s3.setBottomComponent(s2);
        c.add(s3);
        return c;
    }


    private void crearVentana() {
        JLabel imagenUIB = new JLabel(new ImageIcon("./assets/imgUIB"));
        panelDibujo.add(imagenUIB);
    }

    private void crearTeclas() {
        JButton [] botonesSonidos = new JButton[8];
        String [] nombreBotonesSonido = {"DO","RE","MI","FA","SOL","LA","SI","FIN"};
        Color [] coloresBotonesSonido = {Color.red, Color.pink, Color.cyan, Color.yellow, Color.magenta, Color.white, Color.green, Color.black};
        for (int i = 0; i < nombreBotonesSonido.length; i++) {
            botonesSonidos[i] = new JButton(nombreBotonesSonido[i]);
            botonesSonidos[i].setFont(new Font("arial",Font.BOLD, 20));
            botonesSonidos[i].setForeground(Color.black);
            botonesSonidos[i].setBackground(coloresBotonesSonido[i]);
            botonesSonidos[i].addActionListener(gestorEventosSonido);
            panelTeclas.add(botonesSonidos[i]);
        }
    }

    private void crearOpciones() {
        JButton [] menu = new JButton[4];
        String [] titulos = {"CREAR","REPRODUCIR","ADIVINAR","SALIR"};
        for (int i = 0; i < titulos.length; i++) {
            menu[i] = new JButton(titulos[i]);
            menu[i].setFont(new Font("arial",Font.BOLD, 20));
            menu[i].setBackground(Color.black);
            menu[i].addActionListener(gestorEventosMenu);
            panelOpciones.add(menu[i]);
        }


    }


    ActionListener gestorEventosMenu = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){
                //case "CREAR"        :generarPartida();break;
                //case "REPRODUCIR"   :reproducir();break;
                //case "ADIVINAR"     :adivinar();break;
                case "SALIR"        :System.exit(0);

            }
        }
    };

    ActionListener gestorEventosSonido = new ActionListener()  {
        String sonido;
        @Override
        public void actionPerformed(ActionEvent evento)  {
            switch (evento.getActionCommand()) {
                case "DO"         :sonido="do.wav";break;
                case "RE"         :sonido="re.wav";break;
                case "MI"         :sonido="mi.wav";break;
                case "FA"         :sonido="fa.wav";break;
                case "SOL"        :sonido="sol.wav";break;
                case "LA"         :sonido="la.wav";break;
                case "SI"         :sonido="si.wav";break;
                case "SALIR"      :System.exit(0); // *************+*CAMBAIRLO

            }
            //reproducción sonido
            reproduccionSonido(sonido);
        }
    };

    private void reproduccionSonido(String sonido) {
        Clip clip=null;
        AudioInputStream audioInputStream=null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("sonidos/"+sonido).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (UnsupportedAudioFileException | LineUnavailableException | IOException error) {
            System.err.println("ERROR: PROBLEMAS CON LA REPRODUCCIÓN SONIDO");
        }
    }
}
