package ex2;

/**
 *
 * @author MARC
 */
import java.io.*;
import lecturateclat.*;
import pelicula.*;

public class Ex2 {

    private final LecturaTeclat lt = new LecturaTeclat();
    private final String nomFitxer = "pelicules.dat";

    public static void main(String[] args) {
        (new Ex2()).inici();
    }

    private void inici() {
        emmagatzemarPelicules();
        imprimirPelicules();
    }

    private void emmagatzemarPelicules() {
        int quantitatRegistres = 3;

        try {
            FileOutputStream sortida = new FileOutputStream(nomFitxer);
            ObjectOutputStream oos = new ObjectOutputStream(sortida);

            for (int i = 0; i < quantitatRegistres; i++) {
                Pelicula p = new Pelicula();
                p.setTitol(titol());
                p.setDirector(director());
                p.setAny(any());
                p.setGenere(genere());
                oos.writeObject(p);
            }
            sortida.close();
            oos.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void imprimirPelicules() {
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

    private String genere() {
        int numGenere;

        presentacioGenere();
        numGenere = lt.llegirNum();
        while ((numGenere < 0) || (numGenere > 6)) {
            System.out.print("Error, tria un numero entre el 0-6: ");
            numGenere = lt.llegirNum();
        }
        return convertirAGenere(numGenere);
    }

    private String convertirAGenere(int x) {
        String s = "";
        switch (x) {
            case 0:
                s = "Acció";
                break;
            case 1:
                s = "Autor";
                break;
            case 2:
                s = "Cifi";
                break;
            case 3:
                s = "Comèdia";
                break;
            case 4:
                s = "Drama";
                break;
            case 5:
                s = "Policiaca";
                break;
            case 6:
                s = "Terror";
                break;
        }

        return s;
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
