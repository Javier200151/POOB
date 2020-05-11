package aplicacion;
import java.awt.Color;
/**
 * Write a description of class COVID19 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class COVID19 extends Celula
{
    /**
     * Constructor for objects of class COVID19
     */
    public COVID19(AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        changeColor(Color.green);
    }
    /**
     * Decide si vive o muere, sobreescribe
     */
    @Override
    public void decida()
    {
        int f=getFila();
        int c=getColumna();
        //System.out.println(automata.verificarDerecha(f,c)+" Derecha");
        //System.out.println(automata.counter(f,c));
        if(estadoActual==MUERTA)
        {
            automata.desinfectar(f,c);
        }
        else if(estadoActual==VIVA)
        {
            estadoSiguiente=MUERTA;
            automata.infectar(f,c);
        }
    }
}
