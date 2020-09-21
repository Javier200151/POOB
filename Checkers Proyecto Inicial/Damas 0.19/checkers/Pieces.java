package checkers;
import Shapes.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Constructor de piezas tipo normal
 * 
 * @author Javier Esteban López Peña
 * @author Andres Felipe Davila Gutierrez
 * @version 0.14 (18/02/2020)
 * @version 0.15 (19/02/2020)
 * @version 0.16 (20/02/2020)
 * @version 0.17 (21/02/2020)
 */
public class Pieces extends Piece
{
    private Shapes.Circle circle;
    /**
     * Constructor for objects of class KingPieces
     * @param row entero, x coordenada
     * @param column entero, y coordenada
     * @param color String, color a pintar
     * @param xPos entero, distancia en x en la que se pintara sumada a row
     */
    public Pieces(int row, int column,String color,int xPos)
    {
        super(row,column,color,xPos);
        tipo= new Circle(15+(column*30)+xPos,15+(row*30),color);
        tipo.makeVisible();
        
    }



}
