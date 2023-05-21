package notas;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproducirSonido {

    /**
     * ESta clase reproduce el archivo cuyo nombre es el que pasas por parametro
     * @param nombre es el nombre del archivo que se quiere reproducir (sin el .wav)
     */
    public ReproducirSonido(String nombre) {
        Clip clip;
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("assets/sonidos/" + nombre + ".wav")
                    .getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (UnsupportedAudioFileException | LineUnavailableException | IOException error) {
            System.err.println("ERROR: PROBLEMAS CON LA REPRODUCCIÓN DEL SONIDO");
        }
    }
}
