package pelicula;

/**
 *
 * @author MARC
 */
import java.io.Serializable;

public class Pelicula
        implements Serializable {

    private String titol;
    private String director;
    private int any;
    private String genere;

    @Override
    public String toString() {
        return ("Titol: " + titol + " - Director: " + director + " - Any: " + any + " - Gènere: " + genere);
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

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

}
