/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author marc
 */
public class Ex3 {

    private final LecturaTeclat lt = new LecturaTeclat();
    private final String nomFitxerALlegir = "pelicules.dat";
    

    public static void main(String[] args) {
        (new Ex3()).inici();
    }

    private void inici() {
        emmagatzemarPelicules();
        ordenarPeliculesSegonsGen();
//        imprimirGenere("");
        
    }

    private void emmagatzemarPelicules() {
        int quantitatRegistres = 2;

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFitxerALlegir));

            for (int i = 0; i < quantitatRegistres; i++) {
                Pelicula p = new Pelicula();
                p.setTitol(titol());
                p.setDirector(director());
                p.setAny(any());
                p.setGenere(genere());
                oos.writeObject(p);
            }
            oos.writeObject(Pelicula.CENTINELA);
            oos.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void ordenarPeliculesSegonsGen() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFitxerALlegir));
            boolean fiDeFitcher = false;
            Pelicula p;
            while (!fiDeFitcher) {
                try {
                    p = (Pelicula) ois.readObject();
                    fiDeFitcher = p.esCentinela();
                    if (!fiDeFitcher) {
                        p.guardarSegonsGen();
                    }
                } catch (EOFException eofe) {
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void imprimirGenere(String nomFitxer) {
        try {
            FileInputStream entrada = new FileInputStream(nomFitxer);
            ObjectInputStream ois = new ObjectInputStream(entrada);

            Pelicula p;
            boolean fidefitxer = false;
            do {
                try {
                    p = (Pelicula) ois.readObject();
                    System.out.println(p);
                } catch (EOFException eofe) {
                    fidefitxer = true;
                }
            } while (!fidefitxer);
            entrada.close();
            ois.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    //--------------------------------------------------------------------------
    private String titol() {
        System.out.print("Titol: ");
        return lt.llegirString();
    }

    private String director() {
        System.out.print("Director: ");
        return lt.llegirString();
    }

    private int any() {
        System.out.print("Any: ");
        return lt.llegirNum();
    }

    private int genere() {
        int numGenere;

        presentacioGenere();
        numGenere = lt.llegirNum();
        while ((numGenere < 0) || (numGenere > 6)) {
            System.out.print("Error, tria un numero entre el 0-6: ");
            numGenere = lt.llegirNum();
        }
        return numGenere;
    }

    private void presentacioGenere() {

        System.out.println("A quin gènere pertany la pel·lícula? ");
        System.out.println("0 : ACCIÓ");
        System.out.println("1 : AUTOR");
        System.out.println("2 : CIFI");
        System.out.println("3 : COMÈDIA");
        System.out.println("4 : DRAMA");
        System.out.println("5 : POLICIACA");
        System.out.println("6 : TERROR");
    }

}