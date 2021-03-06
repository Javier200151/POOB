package checkers;
import Shapes.*;

/**
 * Write a description of class Libertarian here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Libertarian extends Piece
{
    private Shapes.Circle circle;
    /**
     * Constructor for objects of class Libertarian
     * @param row entero, x coordenada
     * @param column entero, y coordenada
     * @param color String, color a pintar
     * @param xPos entero, distancia en x en la que se pintara sumada a row
     */
    public Libertarian(int row, int column,String color,int xPos)
    {
        super(row,column,color,xPos);
        tipo= new Circle(15+(column*30)+xPos,15+(row*30),color);
        tipo.makeVisible();
    }
}
