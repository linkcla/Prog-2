package jugador;

import java.io.Serializable;

/**
 *
 * @author marc
 */
public class Jugador implements Serializable{
    private String nombre;
    private Equipo equipo;
    private int trofeos;
    //Al centinela le he puesto el nombre de "xxx" porque en el fichero proporcionado
    //no existe ningún nombre igual.
    public static final Jugador CENTINELA = new Jugador("xxx");
    
    public Jugador(){    
    }
    
    public Jugador(String nombre){
        this.nombre = nombre;
    }
    
    //Comprobamos si es centinela
    public boolean esCentinela(){
        return (this.nombre.equals(Jugador.CENTINELA.getNombre()));
    }
    /**
     * Damos formato al Jugador
     */
    @Override
    public String toString(){
        return ("{Nombre: " + nombre + ", Equipo: " + equipo + ", Treofeos: " +
                trofeos + "}");
    }
    
    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getTrofeos() {
        return trofeos;
    }

    public void setTrofeos(int trofeos) {
        this.trofeos = trofeos;
    }

    
    
    
}
