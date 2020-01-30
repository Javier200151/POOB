import java.util.ArrayList;
import java.util.*;

/**
 * Una conversora de numeros enteros a numeracion maya
 *
 * @author Javier Esteban López Peña
 * @version 1.0 01/29/2020
 */
public class Xook
{
    // instance variables - replace the example below with your own
    private int value;
    private int cont;
    private ArrayList circlist;
    private ArrayList rectlist;
    private ArrayList trianlist;
    private ArrayList<Integer> reslist;
    private int divi;
    private int res;
    private int moveH=0;
    private String color="black";

    /**
     * Constructor for objects of class Xook
     */
    public Xook(int value)
    {
        // initialise instance variables
        this.value = value;
        circlist = new ArrayList<Circle>();
        rectlist = new ArrayList<Rectangle>();
        trianlist = new ArrayList<Triangle>();
        reslist = new ArrayList<Integer>();
    }
    
    /**
     * Constructor para la calculadora CalcXook
     */
    public Xook(int value, String Mayacolor)
    {
        // initialise instance variables
        this.value = value;        
        circlist = new ArrayList<Circle>();
        rectlist = new ArrayList<Rectangle>();
        trianlist = new ArrayList<Triangle>();
        reslist = new ArrayList<Integer>();
        changeColor(Mayacolor);
    }
    
    private void Draw()
    {
        cont = 100*reslist.size();
        for (int k = 0 ; k < reslist.size() ; k++)
        {            
            int numRec = reslist.get(k)/5;        
            int numCir = reslist.get(k)%5;
            if (reslist.get(k)==0)
            {
                //System.out.println("triangulo"+reslist.get(k));
                Triangle triangle = new Triangle(25+moveH,(50+cont),color);
                trianlist.add(triangle);                
            } else
            {
                for (int i = 0 ; i < numCir ; i++)
                {
                    Circle circle = new Circle((10*(i+1))+moveH,40+cont,color);
                    circlist.add(circle);
                }
                for (int j = 0 ; j < numRec ; j++)
                {
                    Rectangle rectangle = new Rectangle(5+moveH,(40+(13*(j+1)))+cont,color);
                    rectlist.add(rectangle);
                }                
            }
            cont-=100;
        }
    }
    
    private void Numbers()
    {
        reslist.add(value%20);
        divi=value/20;
        while (divi!=0)
        {
            reslist.add(divi%20);
            divi=divi/20;
            System.out.println(reslist);
            System.out.println(divi);
        }            
    }

    /**
     * Da el valor actualmente pintado en numeracion maya sobre el canvas
     *
     * @return value, valor entero representado en el canvas
     */
    public int getValue()
    {
        // put your code here
        return value;
    }
    
    /**
     * Vuelve visible el objeto, si ya lo esta no hace nada
     */
    public void makeVisible()
    {
        circlist.clear();
        rectlist.clear();
        trianlist.clear();
        reslist.clear();
        Numbers();
        Draw();
    }
    
    /**
     * Vuelve invisible el objeto, si ya lo esta no hace nada
     */
    public void makeInvisible()
    {
        erase();       
        circlist.clear();
        rectlist.clear();
        trianlist.clear();
        reslist.clear();
    }
    
    private void erase()
    {
        for (int i = 0 ; i < circlist.size() ; i++)
        {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(circlist.get(i));            
        }
        for (int j = 0 ; j < rectlist.size() ; j++)
        {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(rectlist.get(j));           
        }
        for (int k = 0 ; k < trianlist.size() ; k++)
        {            
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(trianlist.get(k));           
        }
    }
    
    /**
     * Pinta sobre el canvas el valor puesto en numeracion maya
     * @param value, valor entero que se quiere representar en maya
     */
    public void setValue(int value)
    {
        erase();
        this.value=value;
        makeVisible();
    }
    
    /**
     * Cambia el numero a uno aleatorio entre 0 y 1000. 
     */
    public void random()
    {
        int NumMinimo=0;
        int NumMaximo=1000;
        int randomint=(int )(Math.random()*(NumMinimo+NumMaximo));
        System.out.println(randomint);
        value=randomint;
        setValue(value);
    }
    
    /**
     * Move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance)
    {
        erase();
        moveH+=distance;
        Draw();        
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor (String newColor)
    {
        color=newColor;
        Draw();
    }    
}
