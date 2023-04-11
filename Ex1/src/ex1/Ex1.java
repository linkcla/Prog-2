package ex1;

/**
 *
 * @author marc
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        (new Ex1()).inici();
    }
    
    private void inici(){
        Write write = new Write();
        Print print = new Print();
        
        String documento = "peliculas.txt";
        int numeropeliculas = 3;
        //Pelicules
        String [] peliculas = new String [numeropeliculas];
        Pelicula p0 = new Pelicula("Iron Man","Jon Favreu",2008);
        Pelicula p1 = new Pelicula("Avatar","James Cameron",2009);
        Pelicula p2 = new Pelicula("Agente 007","Terence Young",1962);
        
        peliculas[0] = p0.getInfoGen();
        peliculas[1] = p1.getInfoGen();
        peliculas[2] = p2.getInfoGen();
        
        write.escriurePel(documento, peliculas);
        print.imprimirDoc(documento);
        
    }
    
}
