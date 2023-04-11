/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author marc
 */
public class Print {
    //Constructor buit.
    
    private FileReader reader;
    
    public void imprimirDoc(String document){
        
        try {
            
            int i;
            String lectura = "";
            //Obrim el document
            reader = new FileReader(document);
            //Començam a extreure informació del docuement
            i = reader.read();
            //Feim un bucle per extrure tota l'informació del document
            while (i != -1){
                lectura = lectura + (char)i;
                i = reader.read();
            }
            //Feim un print del document que hem carregat a "lectura".
            System.out.println(lectura);
            //Tancam el document
            reader.close();
        }    
        
        /* Este cahtch no haria falta ya que en la clase "Write" el FileWriter se
         * incialia por defecto en false. Este false hace que si el archivo no
         * existe se crea un documento con ese nombre, y si existe lo que hace
         * es chafarlo. Por eso, como en el main primero se escribe y despues se
         * lee, no haria falta poner este catch.
         */        
        catch(FileNotFoundException e){
            System.out.println("Error, " + e.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
