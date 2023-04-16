/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estadisticas;

import java.util.Arrays;
import jugador.*;

/**
 *
 * @author marc
 */
public class GenerarEstadisticas {
//    Treure les estadístiques globals de tot el fitxer, això inclou les següents dades:
//                    a) Nom del fitxer.
//                    b) Nombre d'objectes que té.
//                    c) Sumatori de tots els trofeus obtinguts.
//                    d) Mitjana aritmètica del nombre de trofeus per jugador.
//                    e) Desviació estàndard. (Mirar apèndix A)
//                    f) Dades del millor jugador, del segon i del tercer.

    private int trofeos = 0;
    private double mediatrofeos;
    
    /**
     * Desde el constructor llamamos a todos los metodos necesarios para realizar las
     * estadisticas
     * @param NombreFichero un String que indica el nombre del fichero
     * @param numeroJugadores un in que indica el numero de jugadores
     * @param jugadoresConNull es una array que puede incluir Jugadores y null
     */
    public GenerarEstadisticas(String NombreFichero, int numeroJugadores, Jugador[] jugadoresConNull) {
        Jugador jugadores[] = quitarNull(jugadoresConNull);
        mostrarNombreFichero(NombreFichero);
        mostrarNumeroDeObjetos(numeroJugadores);
        mostrarSumatorioTrofeos(jugadores);
        mostrarMediaAritmeticaTrofeos(numeroJugadores);
        mostrarDesviacionEstandar(jugadores, (double) numeroJugadores);
        mostrarTop3(jugadores);
    }
    
    /**
     * Imprimimos el nombre que pasamos por parametro
     * @param NombreFichero el nombre del fichero
     */
    private void mostrarNombreFichero(String NombreFichero) {
        System.out.println("Nombre del fichero: " + NombreFichero);
    }

    /**
     * Imprimimos el contador que hemos pasado por parametro, como puede ser que
     * no se hayan creado jugadores de un equipo, lo que hacemos es dividirlo en dos casos mediante un 
     * if else.
     * @param numeroJugadores es un int que indica el numero de jugadores
     * 
     */
    private void mostrarNumeroDeObjetos(int numeroJugadores) {
        if (numeroJugadores != 0) {
            System.out.println("Contiene " + numeroJugadores + " jugadores.");
        } else {
            System.out.println("Aún no se han creado los jugadores");
        }
    }

    
    /**
     * Calculamos el sumatorio de los trofeos
     * @param jugadores es una array donde estan todos los objetos de tipo Jugador 
     */
    private void mostrarSumatorioTrofeos(Jugador[] jugadores) {
        for (Jugador j : jugadores) {
            trofeos += j.getTrofeos();
        }
        System.out.println("Los trofeos totales son; " + trofeos);
    }
    
    /**
     * Calculamosla media aritmética
     * @param jugadores pasamos por parametro el numero de jugadores que hay
     */
    private void mostrarMediaAritmeticaTrofeos(int jugadores) {
        mediatrofeos = trofeos / (double) jugadores;
        System.out.println("La meida de trofeos por jugador es: " + mediatrofeos);
    }
    
    /**
     * Calculamos la desviación estadndar
     * @param jugadores es una array de jugadores
     * @param numeroJugadores es un double que nos indica el numero de Jugadores
     */
    private void mostrarDesviacionEstandar(Jugador[] jugadores, double numeroJugadores) {
        double sumatorio = 0.0;
        for (Jugador j : jugadores) {
            sumatorio += Math.pow(j.getTrofeos() - mediatrofeos, 2);
        }
        System.out.println("La desviación estadndar es: " + (Math.sqrt(sumatorio / numeroJugadores)));
    }
    /**
     * Este metodo lo que hace es ordenar la array de jugadores de mayor a menor(respecto las a las copas)
     * y posteriormente elige el podium
     * @param jugadores array en la que solo hay objetos de la clase Jugador
     */
    private void mostrarTop3(Jugador[] jugadores) {
        Jugador tmp;
        for (int i = jugadores.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (jugadores[j].getTrofeos() < jugadores[j + 1].getTrofeos()) {
                    tmp = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = tmp;
                }
            }
        }
        //El top 3 lo tenemos en los tres primeros indices de la array de jugadores
        System.out.println("Podium: ");
        System.out.println("  1º --> " + jugadores[0]);
        System.out.println("  2º --> " + jugadores[1]);
        System.out.println("  3º --> " + jugadores[2]);
    }
    
    /**
     * Este metodo elimina los nulls que pueda haber dentro de la array con jugadores
     * @param jug pasamos la array que puede contener jugadores y null
     * @return recortamos la array hasta donde hay valores de Jugador y la devolvemos
     */
    private Jugador[] quitarNull(Jugador[] jug) {
        int contador = 0;
        for (Jugador j : jug) {
            if (j != null) {
                contador++;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(jug, 0, contador);
    }
}
