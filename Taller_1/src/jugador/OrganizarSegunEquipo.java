/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class OrganizarSegunEquipo {
    
    //logger lo usamos para generar los comentarios de las excepciones
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    //copimaos el Enum de los tipos de eqipos
    private Equipo[] equipos = Equipo.values();
    private ObjectInputStream ois;
    //Creamos una array de contadores que esta relacionada con cada equipo
    private int contadores[] = new int[Equipo.values().length];
    //Creamos una array de escritores, así sera mas facil y mas automatico.
    private ObjectOutputStream[] escritores = new ObjectOutputStream[equipos.length];
    
    /**
     * Con el constructor lo que hacemos es inicializar una array de ObjectOutputStream.
     * Cada ObjectOutputStream es para un equipo diferente.
     * @param archivoParaOrganizar pasamos el archivo de Jugadores que queremos organizar
     * por equipos en diferentes ficheros
     */
    public OrganizarSegunEquipo(String archivoParaOrganizar) {
        try {
            //Inicializamos escritores
            for (int i = 0; i < equipos.length; i++) {
                escritores[i] = new ObjectOutputStream(new FileOutputStream(equipos[i].toString() + ".dat"));
            }
            //Inicializamos ois para poder leer el fichero de jugadores
            ois = new ObjectInputStream(new FileInputStream(archivoParaOrganizar));

        } catch (IOException e) {
            logger.log(Level.WARNING, "No se ha podido crear el lector/escritor de ficheros de objetos.");
        }

    }
    
    /**
     * Organiza el fichero de jugadores
     * @return devulve una matriz donde para cada equipo hay una array con los jugadores
     * que pertenecen a ese equipo
     */
    public Jugador[][] organizar() {

        Jugador jugadoresSegunEquipo[][] = new Jugador[Equipo.values().length][200];
        //Inicializamos a 0 la array de contadores
        for (int i = 0; i < contadores.length; i++) {
            contadores[i] = 0;
        }

        try {
            Jugador j;
            boolean fidefitxer = false;

            do {
                j = (Jugador) ois.readObject();
                //Si no es el centinel analizamos a que equipo pertenece
                if (!j.esCentinela()) {
                    //Escribimos el objeto en su archivo correspondiente
                    escritores[encontrarValor(j.getEquipo())].writeObject(j);
                    jugadoresSegunEquipo[encontrarValor(j.getEquipo())][contadores[encontrarValor(j.getEquipo())]] = j;
                    //Sumamos uno al contador correspondiente
                    contadores[encontrarValor(j.getEquipo())]++;
                } else {
                    fidefitxer = true;
                }
            } while (!fidefitxer);
            for (int i = 0; i < escritores.length; i++) {
                escritores[i].writeObject(Jugador.CENTINELA);
                escritores[i].close();
            }
            
        } catch (ClassNotFoundException ex) {
            logger.log(Level.WARNING, "No se ha encontrado la clase.");
        } catch (IOException e) {
            logger.log(Level.WARNING, "No se ha podido crear el lector/escritor de ficheros de objetos.");
        }
        return jugadoresSegunEquipo;
    }

    public int[] getContadores() {
        return contadores;
    }
    
    /**
     * Encuentra el indice de donde esta ubicado el equipo.
     * @param equipo enum
     * @return el indice del enum
     */
    private int encontrarValor(Equipo equipo) {
        int index = 0;
        for (int i = 0; i < Equipo.values().length; i++) {
            if (Equipo.values()[i].equals(equipo)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
