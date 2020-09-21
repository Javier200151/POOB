package checkers;
import Shapes.*;

/**
 * Write a description of class Priest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Priest extends Piece
{
    // instance variables - replace the example below with your own
    private Shapes.Circle circle;
    /**
     * Constructor for objects of class Priest
     * @param row entero, x coordenada
     * @param column entero, y coordenada
     * @param color String, color a pintar
     * @param xPos entero, distancia en x en la que se pintara sumada a row
     */
    public Priest(int row, int column,String color,int xPos)
    {   
        super(row,column,color,xPos);
        tipo= new Circle(15+(column*30)+xPos,15+(row*30),color);
        tipo.makeVisible();
    }
}
