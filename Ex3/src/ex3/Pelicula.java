package ex3;

/**
 *
 * @author MARC
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pelicula
        implements Serializable {

    private String titol;
    private String director;
    private int any;
    private int genere;

    public static final Pelicula CENTINELA = new Pelicula("zzz", "zzz", 999, 999);

    public Pelicula() {

    }

    public Pelicula(String t, String d, int a, int g) {
        titol = t;
        director = d;
        any = a;
        genere = g;
    }

    private String convertirAGenere() {
        String s = "";
        switch (genere) {
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

    public void guardarSegonsGen() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(convertirAGenere() + ".dat"));
            switch (genere) {
                case 0:
                    oos.writeObject(this);
                    break;
                case 1:
                    oos.writeObject(this);
                    break;
                case 2:
                    oos.writeObject(this);
                    break;
                case 3:
                    oos.writeObject(this);
                    break;
                case 4:
                    oos.writeObject(this);
                    break;
                case 5:
                    oos.writeObject(this);
                    break;
                case 6:
                    oos.writeObject(this);
                    break;
            }
            oos.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean esCentinela() {
        return director.equals(CENTINELA.director);
    }

    @Override
    public String toString() {
        return ("Titol: " + titol + " - Director: " + director + " - Any: " + any + " - Gènere: " + convertirAGenere());
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getGenere() {
        return genere;
    }

    public void setGenere(int genere) {
        this.genere = genere;
    }

}
