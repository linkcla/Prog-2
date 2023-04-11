
package ex1;

/**
 *
 * @author linkc
 */
public class Pelicula {
    private final String titol;
    private final String director;
    private final int any;
    
    public Pelicula(String titol, String director, int any){
        this.titol = titol;
        this.director = director;
        this.any = any;
    }
    public String getTitol() {
        return titol;
    }

    public String getDirector() {
        return director;
    }

    public int getAny() {
        return any;
    }
    
    public String getInfoGen(){
        return ("Titol: " + titol + " - Director: " + director + " - Any: " + any);
    }

    
}
