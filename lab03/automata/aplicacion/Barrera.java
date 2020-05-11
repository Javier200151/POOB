
package aplicacion;

import java.awt.Color;


/**
 * Write a description of class Barrera here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Barrera implements Elemento
{
    // instance variables - replace the example below with your own
    private Color color;
    protected AutomataCelular automata;
    protected int fila,columna;

    /**
      * Constructor for objects of class Barrera
     */
    public Barrera(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.black;
    }
    
    /**Retorna el color de  la célula
    @return 
     */
    public final Color getColor(){
        return color;
    }
}
