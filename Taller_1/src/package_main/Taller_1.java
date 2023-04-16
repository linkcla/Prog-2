package package_main;

import io.LT;
import jugador.*;
import estadisticas.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marc
 */
public class Taller_1 {

    public static void main(String[] args) {
        (new Taller_1()).menuPrincipal();
    }

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final String NOMBREFICHEROJUGADORES = "Jugadores.dat";
    private Jugador jugadoresSegunEquipo[][] = new Jugador[Equipo.values().length][200];
    private Jugador jugadoresTotales[] = new Jugador[200];

    /**
     * Muestra por consola el menu y llama a las clases dependiendo de la opción
     * elegida por el usuario
     */
    private void menuPrincipal() {
        String opcion;
        LT lt = new LT();
        boolean salir = false;
        int numeroDeJugadores = 0;
        int numeroDeJugadoresDependiendoDelEquipo[] = new int[Equipo.values().length];
        boolean jugadoresGenerados = false;
        boolean jugadoresSeparados = false;

        while (!salir) {
            System.out.println("-------------------- MENÚ --------------------");
            System.out.println("    1 --> Crear jugadores.");
            System.out.println("    2 --> Mostrar datos del fichero de jugadores.");
            System.out.println("    3 --> Estadísticas.");
            System.out.println("    4 --> Separar los jugadores según equipo.");
            System.out.println("    5 --> Mostrar jugadores separados por equipos.");
            System.out.println("    6 --> Mostrar las estadisticas separadas para cada fichero.");
            System.out.println("    s --> SALIR.");

            opcion = lt.llegirLiniaS();

            switch (opcion) {
                case "1":
                    //El metodo start genera los jugadores y devuelve un int con el numero 
                    //de jugadores creados
                    GenerarJugadores gen = new GenerarJugadores();
                    jugadoresTotales = gen.start(NOMBREFICHEROJUGADORES);
                    numeroDeJugadores = gen.getNumeroJugadores();
                    System.out.println("He creado: " + numeroDeJugadores);
                    jugadoresGenerados = true;
                    break;
                case "2":
                    //Mostrar el fichero de Juagadores
                    printFicheroDeJugador(NOMBREFICHEROJUGADORES);
                    break;
                case "3":
                    //Generar las estadisticas
                    if (jugadoresGenerados) {
                        new GenerarEstadisticas(NOMBREFICHEROJUGADORES,
                                numeroDeJugadores, jugadoresTotales);
                    } else {
                        System.out.println("Primero debes crear los jugadores.");
                    }
                    break;
                case "4":
                    //Separar equipos
                    OrganizarSegunEquipo org = new OrganizarSegunEquipo(NOMBREFICHEROJUGADORES);
                    //Organiza y devuelve una array de jugadores por cada equipo.
                    jugadoresSegunEquipo = org.organizar();
                    numeroDeJugadoresDependiendoDelEquipo = org.getContadores();
                    jugadoresSeparados = true;
                    break;
                case "5":
                    //Mostrar tots els jugadors separats per equips.
                    for (int i = 0; i < Equipo.values().length; i++) {

                        System.out.println("\n\nFichero del equipo: " + Equipo.values()[i] + "\n");
                        printFicheroDeJugador(Equipo.values()[i].toString() + ".dat");
                    }
                    break;
                case "6":
                    //Treure les estadístiques separades per cada fitxer (les mateixes del punt 3).
                    if (jugadoresSeparados) {
                        for (int i = 0; i < Equipo.values().length; i++) {
                            new GenerarEstadisticas(Equipo.values()[i].toString() + ".dat",
                                    numeroDeJugadoresDependiendoDelEquipo[i], jugadoresSegunEquipo[i]);
                            System.out.println("\n\n");
                        }
                    } else {
                        System.out.println("Primero debes separar los jugadores.");
                    }

                    break;
                case "s":
                    //Salir
                    salir = true;
                    break;
                default:
                    System.out.println("    Error, introduce un valor valido");
            }
        }
    }

    /**
     * Imprime un fichero de objetos de tipo Jugador
     *
     * @param nombreFicheroDeObjetos el nombre del ficero de Jugadores que hay
     * que imprimir
     */
    private void printFicheroDeJugador(String nombreFicheroDeObjetos) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFicheroDeObjetos));
            Jugador j;
            boolean fidefitxer = false;
            do {
                try {
                    //Vamos sacando objeto a objeto
                    j = (Jugador) ois.readObject();
                    //Si no es el centinela lo imprimimos, si es el centinela indicamos que es el
                    //final del fichero con la variable booleana
                    if (!j.esCentinela()) {
                        System.out.println(j);
                    } else {
                        fidefitxer = true;
                    }

                } catch (ClassNotFoundException ex) {
                    logger.log(Level.WARNING, "No se ha podido leer el Jugador.");
                }
            } while (!fidefitxer);

            ois.close();
        } catch (IOException e) {
            logger.log(Level.WARNING, "El fichero: \"Jugadores.dat\" no se ha encontrado.");
        }
    }

}
