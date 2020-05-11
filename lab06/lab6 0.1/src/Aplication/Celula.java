package Aplication;

import java.awt.Color;
import java.io.Serializable;

/**Informacion sobre una célula<br>
<b>(COLOR,automata,fila,columna,estadoActual,estadoSigiente)</b><br>
Las celulas conocen su color, el automata en la que viven, la posición en la que están en ese autómata,su estado actual y el estado que van a tomar en el siguiente instante.<br>
Todas las células son de color azul<br>
Los posibles estados de una célula son tres: viva, muerta o latente<br>
 */
public class Celula implements Elemento,Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5872036575685165234L;
	protected final static char VIVA='v', MUERTA='m';
    protected AutomataCelular automata;
    protected int fila,columna;
    protected char estadoActual,estadoSiguiente;
    protected Color color;
    protected int edad;

    /**Crea una célula, viva o latente, en la posición (<b>fila,columna</b>) del autómta <b>ac</b>.Toda nueva célula va a estar viva en el estado siguiente.
    @param ac automata celular en el que se va a ubicar la nueva célula
    @param fila fila en el automata celular
    @param columna columna en el automata celula
     */
    public Celula(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        estadoActual=' ';
        estadoSiguiente=VIVA;
        edad=0;
        automata.setElemento(fila,columna,(Elemento)this);  
        color=Color.blue;
    }

    /**Retorna la fila del automata en que se encuentra 
    @return 
     */

    public final int getFila(){
        return fila;
    }

    /**Retorna la columna del automata en que se encuentra
    @return 
     */
    public final int getColumna(){
        return columna;
    }

    
    /**Retorna el color de  la célula
    @return 
     */
    public final Color getColor(){
        return color;
    }
    /**
     * Cambia el color de las celula
     * @param newColor Color, color a cambiar
     */
    public void changeColor(Color newColor){
        color=newColor;
    }
    /**Retorna si está viva
    @return v
     */
    public final boolean isVivo(){
        return (estadoActual == VIVA) ;
    }

    /**Retorna la edad de la célula
    @return 
     */
    public final int edad(){
        return (edad) ;
    }

    /**Decide cual va a ser su  siguiente estado 
     */
    public void decida(){
        int f=getFila();
        int c=getColumna();
        //System.out.println(automata.counter(f,c));
        if ((automata.counter(f,c)==3) || (automata.counter(f,c)==2 && estadoActual==VIVA))
        {                        
            //System.out.println("VIVA");
            estadoSiguiente=VIVA;
        }
        else if(automata.counter(f,c)>3 || automata.counter(f,c)==1)
        {
            //System.out.println("MUERTA");
            estadoSiguiente=MUERTA;
        }
    }
    
    /**Actualiza su estado actual considerando lo definido como siguiente estado
     */
    public final void cambie(){
        //System.out.println("Cambio");
        edad++;
        estadoActual=estadoSiguiente;
    }
}
