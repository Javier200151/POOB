package Aplication;
import java.awt.Color;

/**
 * Write a description of class Izquierdosa here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Izquierdosa extends Celula
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Izquierdosa
     */
    public Izquierdosa (AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        changeColor(Color.red);
    }

    /**
     * Decide si vive o muere, sobreescribe
     */
    @Override
    public void decida(){
        int f=getFila();
        int c=getColumna();
        System.out.println(automata.verificarDerecha(f,c)+" Derecha");
        //System.out.println(automata.counter(f,c));
        if (((automata.counter(f,c)==3) || (automata.counter(f,c)==2 && estadoActual==VIVA)) && !automata.verificarDerecha(f,c))
        {                        
            System.out.println("VIVA");
            estadoSiguiente=VIVA;
        }
        else if(automata.counter(f,c)>3 || automata.counter(f,c)==1 || automata.verificarDerecha(f,c))
        {
            System.out.println("Izquierdoso");
            estadoSiguiente=MUERTA;
        }
    }
}
