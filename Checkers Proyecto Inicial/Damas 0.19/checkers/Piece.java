
package checkers;
import Shapes.*;
/**
 * Abstract class Piece - write a description of the class here
 * 
 * @author: 
 * Date: 
 */

public class Piece
{
    protected int i;
    protected int j;
    protected String color;
    public Figura tipo;
    /**
     * Constructor for objects of class KingPieces
     * @param row entero, x coordenada
     * @param column entero, y coordenada
     * @param color String, color a pintar
     * @param xPos entero, distancia en x en la que se pintara sumada a row
     */
    public Piece(int row, int column,String color,int xPos)
    {
        /*circle= new Circle(15+(column*30)+xPos,15+(row*30),color);*/
        i=row;
        j=column;
        this.color=color;
    }
    public String getColor()
    {
        return color;
    }
    /**
     * Vuelve invisible al objeto, si ya lo esta no hace nada
     */
    public void makeInvisible()
    {
       tipo.makeInvisible();
    }
    /**
     * Remueve el objeto
     */
    public void removePiece()
    {
        tipo.makeInvisible();
    }
    /**
     * Mueve horizontalmente el objeto
     * @param x entero, distancia a recorrer en pixeles
     */
    public void moveHorizontal(int x)
    {
        tipo.moveHorizontal(x);
    }
    /**
     * Mueve verticalmente el objeto
     * @param x entero, distancia a recorrer en pixeles
     */
    public void moveVertical(int y)
    {
        tipo.moveVertical(y);
    }
    /**
     * Hace blick al objeto
     */
    public void select()
    {
        tipo.blick(5);
    }
    /**
     * Vuelve visible al objeto, si ya lo esta no hace nada
     */
    public void makeVisible()
    {
        tipo.makeVisible();
    }
    /**
     * Mueve el objeto
     * @param x entero, distancia a recorrer en pixeles
     * @param y entero, distancia a recorrer en pixeles
     */
    public void move(int x, int y){
        moveHorizontal(x);
        moveVertical(y);
    }
}
