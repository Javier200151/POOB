package checkers;
import Shapes.*;

/**
 * Write a description of class Proletarian here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Proletarian extends Piece
{
   private Shapes.Circle circle;
    /**
     * Constructor for objects of class Proletarian
     * @param row entero, x coordenada
     * @param column entero, y coordenada
     * @param color String, color a pintar
     * @param xPos entero, distancia en x en la que se pintara sumada a row
     */
    public Proletarian(int row, int column,String color,int xPos)
    {
        super(row,column,color,xPos);
        tipo= new Circle(15+(column*30)+xPos,15+(row*30),color);
        tipo.makeVisible();
    }
}
