package ex3;

/**
 *
 * @author MARC
 */

import java.io.*;
public class LecturaTeclat {
    //Constructor buit
    
    public String llegirString(){
            String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
        } catch (IOException ex) {
        }
        return s;
    }
    
    public int llegirNum(){
        int x = 0;
        try {
            String s;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            s = in.readLine();
            x = Integer.parseInt(s);
        } 
        catch (IOException e) {
        } 
        catch (NumberFormatException e) {
        }
        return x;
    }
}
