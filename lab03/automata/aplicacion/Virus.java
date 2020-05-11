
package aplicacion;

import java.awt.Color;


/**
 * Write a description of class Virus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Virus implements Elemento
{
    private Color color;
    protected AutomataCelular automata;
    protected int fila,columna;
    private int infectados=0;
    /**
     * Constructor for objects of class Virus
     */
    public Virus(AutomataCelular ac,int fila, int columna)
    {
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.green;
    }
    /**
     * Cuenta el numero de celulas que infecta, muriendo si infecta a una
     */
    public void cambie()
    {
        infectados++;
        if(infectados>2)
        {
            automata.desinfectaBarrera(fila,columna);
        }
    }
    /**Retorna el color de  la célula
    @return 
     */
    public final Color getColor(){
        return color;
    }
}
