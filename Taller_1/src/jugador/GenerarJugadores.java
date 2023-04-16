package jugador;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author marc
 */
public class GenerarJugadores {

    private final String nombreFichero = "Nombres.txt";
    private final Random ran = new Random();
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private int numeroDeJugadores = ran.nextInt(200) + 1;
    private final int MAXNOMBRES = 510;
    private final int MAXTROFEOS = 201;

    /**
     * Genera los jugadores mediante el uso de java.util.Random
     * @param nombreDocumento el documento donde estan los diferentes nombres
     * que pueden tener los jugadores
     * @return devuelve una array de Jugador donde estan todos los jugadores que
     * se han generado
     */
    public Jugador[] start(String nombreDocumento) {
        Jugador jugador;
        Jugador todosLosJugadores[] = new Jugador[numeroDeJugadores];
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreDocumento));
            for (int i = 0; i < numeroDeJugadores; i++) {
                jugador = new Jugador();
                //Guardamos el nombre
                jugador.setNombre(generarNombre(ran.nextInt(MAXNOMBRES)));
                //Guardamos el equipo
                jugador.setEquipo(Equipo.values()[ran.nextInt(Equipo.values().length)]);
                //Guardamos la cantidad de trofeos
                jugador.setTrofeos(ran.nextInt(MAXTROFEOS));
                //Escribimos el objeto
                oos.writeObject(jugador);
                todosLosJugadores[i] = jugador;
            }
            //Escribimos el CENTINELA al final del fichero
            oos.writeObject(Jugador.CENTINELA);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n             *JUGADORES CREADOS*\n");
        return todosLosJugadores;

    }
    
    /**
     * Mediante un random creado anteriormente extrae un nombre aleatorio ubicado
     * en el fichero de nombres
     * @param posicionDelNombre linea del documento en el que se encuetra el
     * nombre que queremos exreaer
     * @return devolvemos el nombre
     */
    private String generarNombre(int posicionDelNombre) {
        String nombre = "";
        try {
            BufferedReader read = new BufferedReader(new FileReader(nombreFichero));
            for (int i = 0; i <= posicionDelNombre; i++) {
                nombre = read.readLine();
            }
            read.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "El fichero:" + nombreFichero + " no se ha encontrado.");
        }
        return nombre;
    }

    public int getNumeroJugadores() {
        return numeroDeJugadores;
    }
}
