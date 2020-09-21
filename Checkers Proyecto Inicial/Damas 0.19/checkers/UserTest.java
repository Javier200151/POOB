package checkers;
import javax.swing.JOptionPane;

/**
 * Write a description of class UserTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserTest
{
    private Checkers c;
    /**
     * Constructor for objects of class UserTest
     */
    public UserTest()
    {
        c=new Checkers(8);
    }
    public void gameSimulation()
    {
        c.read("-b-b-b-bb-b-b-b--b-b-b-b.-.-.-.--.-.-.-.w-w-w-w--w-w-w-ww-w-w-w-");
        c.swap();
        c.move("21-17"); // Blanco
        c.move("10-14"); // Azul    
        c.move("17x10"); // Blanco
        c.move("6x15"); // Azul
        c.move("22-17"); // Blanco
        c.move("12-16"); // Azul 
        c.move("17-14"); // Blanco
        c.move("15-18"); // Azul
        c.move("24-19"); // Blanco
        c.move("18-22"); // Azul
        c.move("27-24"); // Blanco
        c.move("9x18"); // Azul
        c.move("26-23"); // Blanco
        c.move("22-26"); // Azul
        c.move("31-27"); // Blanco
        c.move("26-31"); // Azul
        c.move("23-18"); // Blanco
        c.move("31x24"); // Azul
        c.move("25x18"); // Blanco
        c.move("16-19"); // Azul
        c.move("32-27"); // Blanco
        c.move("11-15"); // Azul
        c.move("27-24"); // Blanco
        c.move("20x27"); // Azul
        c.move("28-24"); // Blanco
        c.move("19x28"); // Azul
        c.move("30-25"); // Blanco
        c.move("27-32"); // Azul
        c.move("25-21"); // Blanco
        c.move("15x22"); // Azul
        c.move("21-17"); // Blanco
        c.move("22x13"); // Azul
        JOptionPane.showMessageDialog(null, "Ganan Azules");
        c.finish();
    }
    public void mejorMovimiento()
    {
        c.read("-.-.-.-..-.-.-.--b-b-b-..-w-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-");
        c.swap();
        c.select(4,3);
        c.move();
        c.swap();
    }
    public void testPriest()
    {
        c.read("-.-.-.-s.-.-.-b--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-");
        c.swap();
        c.move("4x11");   
        c.swap();
        JOptionPane.showMessageDialog(null, "Convierte en su equipo la ficha que salta");
    }
    public void testLibertarian()
    {
        c.read("-.-.-.-i.-.-.-b--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-");
        c.swap();
        c.move("4x11");
        c.swap();
        JOptionPane.showMessageDialog(null, "No captura las que salta");
    }
    public void testPowerful()
    {
        c.read("-.-.-.-e.-.-.-o--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-");
        c.swap();
        c.move("4x11");
        c.swap();
        JOptionPane.showMessageDialog(null, "No se deja capturar");
    }
    public void testProletarian()
    {
        c.read("-.-.-.-..-.-.-p--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-");
        c.swap();
        c.move("8-3");
        c.swap();
        JOptionPane.showMessageDialog(null, "Muere al convertirse en rey");
    }
    public void testLazy()
    {   
        c.read("-.-.-.-l.-.-.-b--.-.-.-..-.-b-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-");
        c.swap();
        c.move("4x11");
        c.swap();
        JOptionPane.showMessageDialog(null, "Se mueve una sola vez");
    }
    public void testHurried()
    {   
        c.read("-h-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-");
        c.swap();
        c.move("1-6");
        c.swap();
        JOptionPane.showMessageDialog(null, "Duplica el ultimo movimiento");
    }
}
