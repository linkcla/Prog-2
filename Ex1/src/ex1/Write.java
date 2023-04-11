package ex1;

import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 *
 * @author marc
 */
public class Write {
    //Constructor buit.
    //String que permet botar de linea.
    private String endLine = System.getProperty("line.separator");
    private FileWriter writer;
    
    public void escriurePel(String documento, String [] peliculas){
        try{
        //Obrim el document
        writer = new FileWriter(documento);
        //Guardam les pelicules
            for (int i = 0; i < peliculas.length; i++) {
                writer.write(peliculas[i] + endLine);
            }
        //Tancam el document
        writer.close();
        } 
        
        /*Este último cahtch no haria falta ya que por defecto el filewriter se
         *inicializa con el append en false, por este motivo si el archivo no
         *existe lo que hace es crearlo
         */
        catch(FileNotFoundException e){
            System.out.println("Error, " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }        
    }
}
