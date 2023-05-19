import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PanelTeclas extends JPanel {
    private JButton [] botonesSonidos;
    private ActionListener gestorSonidos = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sonido = null;
            switch (e.getActionCommand()){
                case "DO"         :sonido="do.wav";break;
                case "RE"         :sonido="re.wav";break;
                case "MI"         :sonido="mi.wav";break;
                case "FA"         :sonido="fa.wav";break;
                case "SOL"        :sonido="sol.wav";break;
                case "LA"         :sonido="la.wav";break;
                case "SI"         :sonido="si.wav";break;
                case "FIN"        :break;
            }
            reproducirSonido(sonido);
        }
    };


    public PanelTeclas() {
        setLayout(new GridLayout(1,8,4,0));
        inicializarTeclas();
    }

    private void inicializarTeclas() {
        botonesSonidos = new JButton[8];
        String [] nombreBotonesSonido = {"DO","RE","MI","FA","SOL","LA","SI","FIN"};
        Color[] coloresBotonesSonido = {Color.red, Color.pink, Color.cyan, Color.yellow, Color.magenta, Color.white, Color.green, Color.black};
        for (int i = 0; i < botonesSonidos.length; i++) {
            botonesSonidos[i] = new JButton(nombreBotonesSonido[i]);
            botonesSonidos[i].setFont(new Font("Arial",Font.BOLD,20));
            botonesSonidos[i].setBackground(coloresBotonesSonido[i]);
            botonesSonidos[i].addActionListener(gestorSonidos);
            add(botonesSonidos[i]);
        }
    }
    private void reproducirSonido(String sonido) {
        Clip clip=null;
        AudioInputStream audioInputStream=null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("assets/sonidos/"+sonido).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (UnsupportedAudioFileException | LineUnavailableException | IOException error) {
            System.err.println("ERROR: PROBLEMAS CON LA REPRODUCCIÓN DEL SONIDO");
        }
    }
}
