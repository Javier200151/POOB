package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AutomataTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AutomataTest
{
    /**
     * Default constructor for test class AutomataTest
     */
    public AutomataTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void deberiaHacerTicTac()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        aplicacion.Celula celula1 = new aplicacion.Celula(automata1, 3, 4);
        aplicacion.Celula celula2 = new aplicacion.Celula(automata1, 3, 5);
        automata1.ticTac();
        assertTrue(automata1.getElemento(3,4).isVivo());
        automata1.ticTac();
        assertFalse(automata1.getElemento(3,4).isVivo());
        automata1.ticTac();
        assertFalse(!automata1.getElemento(3,4).isVivo());
    }

    @Test
    public void deberiaServirizquierdosa()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        aplicacion.Izquierdosa izquierd1 = new aplicacion.Izquierdosa(automata1, 5, 5);
        aplicacion.Izquierdosa izquierd2 = new aplicacion.Izquierdosa(automata1, 5, 6);
        automata1.ticTac();
        assertTrue(automata1.getElemento(5,5).isVivo());
        automata1.ticTac();
        assertFalse(automata1.getElemento(5,5).isVivo());
        automata1.ticTac();
        assertFalse(automata1.getElemento(5,6).isVivo());
    }

    @Test
    public void deberiaCrearBarrera()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        aplicacion.Barrera barrera1 = new aplicacion.Barrera(automata1, 2, 3);
        automata1.ticTac();
        assertFalse(automata1.getElemento(2,3) == null);
        automata1.ticTac();
        assertFalse(automata1.getElemento(2,3) == null);
        automata1.ticTac();
        assertFalse(automata1.getElemento(2,3) == null);
    }

    @Test
    public void Covid19()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        aplicacion.COVID19 cOVID191 = new aplicacion.COVID19(automata1, 3, 4);
        aplicacion.COVID19 cOVID192 = new aplicacion.COVID19(automata1, 4, 3);
        aplicacion.COVID19 cOVID193 = new aplicacion.COVID19(automata1, 5, 4);
        aplicacion.Celula celula1 = new aplicacion.Celula(automata1, 3, 3);
        aplicacion.Celula celula2 = new aplicacion.Celula(automata1, 5, 5);
        aplicacion.Celula celula3 = new aplicacion.Celula(automata1, 3, 5);
        assertFalse(automata1.getElemento(3,4).isVivo());
        assertFalse(automata1.getElemento(4,3).isVivo());
        assertFalse(automata1.getElemento(5,4).isVivo());
        automata1.ticTac();
        assertTrue(automata1.getElemento(3,4).isVivo());
        assertTrue(automata1.getElemento(4,3).isVivo());
        assertTrue(automata1.getElemento(5,4).isVivo());
        automata1.ticTac();
        assertFalse(automata1.getElemento(3,4).isVivo());
        assertFalse(automata1.getElemento(4,3).isVivo());
        assertFalse(automata1.getElemento(5,4).isVivo());
        automata1.ticTac();
        assertTrue(automata1.getElemento(3,4).isVivo());
        assertTrue(automata1.getElemento(4,3).isVivo());
        assertTrue(automata1.getElemento(5,4).isVivo());
        automata1.ticTac();
        automata1.ticTac();

        automata1.ticTac();

    }

    @Test
    public void VirusTest()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        aplicacion.Virus virus1 = new aplicacion.Virus(automata1, 3, 3);
        aplicacion.Celula celula1 = new aplicacion.Celula(automata1, 2, 3);
        aplicacion.Celula celula2 = new aplicacion.Celula(automata1, 3, 4);
        automata1.ticTac();
        automata1.ticTac();
    }

    @Test
    public void bloqueTest()
    {
        aplicacion.AutomataCelular automata1 = new aplicacion.AutomataCelular();
        aplicacion.Celula celula1 = new aplicacion.Celula(automata1, 0, 0);
        aplicacion.Celula celula2 = new aplicacion.Celula(automata1, 0, 1);
        aplicacion.Celula celula3 = new aplicacion.Celula(automata1, 1, 0);
        aplicacion.Celula celula4 = new aplicacion.Celula(automata1, 1, 1);
        automata1.ticTac();
        assertFalse(automata1.getElemento(0,0) == null);
        assertTrue(automata1.getElemento(0,0).isVivo());
        assertFalse(automata1.getElemento(0,1) == null);
        assertTrue(automata1.getElemento(0,1).isVivo());
        assertFalse(automata1.getElemento(1,0) == null);
        assertTrue(automata1.getElemento(1,0).isVivo());
        assertFalse(automata1.getElemento(1,1) == null);
        assertTrue(automata1.getElemento(1,1).isVivo());
        automata1.ticTac();
        assertFalse(automata1.getElemento(0,0) == null);
        assertTrue(automata1.getElemento(0,0).isVivo());
        assertFalse(automata1.getElemento(0,1) == null);
        assertTrue(automata1.getElemento(0,1).isVivo());
        assertFalse(automata1.getElemento(1,0) == null);
        assertTrue(automata1.getElemento(1,0).isVivo());
        assertFalse(automata1.getElemento(1,1) == null);
        assertTrue(automata1.getElemento(1,1).isVivo());
        automata1.ticTac();
        assertFalse(automata1.getElemento(0,0) == null);
        assertTrue(automata1.getElemento(0,0).isVivo());
        assertFalse(automata1.getElemento(0,1) == null);
        assertTrue(automata1.getElemento(0,1).isVivo());
        assertFalse(automata1.getElemento(1,0) == null);
        assertTrue(automata1.getElemento(1,0).isVivo());
        assertFalse(automata1.getElemento(1,1) == null);
        assertTrue(automata1.getElemento(1,1).isVivo());
        automata1.ticTac();
        assertFalse(automata1.getElemento(0,0) == null);
        assertTrue(automata1.getElemento(0,0).isVivo());
        assertFalse(automata1.getElemento(0,1) == null);
        assertTrue(automata1.getElemento(0,1).isVivo());
        assertFalse(automata1.getElemento(1,0) == null);
        assertTrue(automata1.getElemento(1,0).isVivo());
        assertFalse(automata1.getElemento(1,1) == null);
        assertTrue(automata1.getElemento(1,1).isVivo());
    }
}






