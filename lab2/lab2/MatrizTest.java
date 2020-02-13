

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatrizTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatrizTest
{
    /**
     * Default constructor for test class MatrizTest
     */
    public MatrizTest()
    {
    }

    @Test
    public void sumaDeberiaCalcularseNumerosNegativos()
    {
        Matriz matriz1 = new Matriz(new int[][][] {{{1,4},{1,8}}});
        Matriz matriz2 = new Matriz(new int[][][] {{{-1,16},{-1,16}}});
        assertEquals(new Matriz(new int[][][] {{{3,16},{1,16}}}).toString(), matriz1.sume(matriz2).toString());
    }

    @Test
    public void sumaDeberiaCalcularseNumerosCorrientes()
    {
        Matriz matriz1 = new Matriz(new int[][][] {{{1,4},{1,8}}});
        Matriz matriz2 = new Matriz(new int[][][] {{{1,4},{1,8}}});
        assertEquals(new Matriz(new int[][][] {{{1,2},{1,4}}}).toString(), matriz1.sume(matriz2).toString());
    }
    
    @Test
    public void restaDeberiaCalcularseNumerosNegativos()
    {
        Matriz matriz1 = new Matriz(new int[][][] {{{7,4},{9,8}}});
        Matriz matriz2 = new Matriz(new int[][][] {{{-9,16},{-9,16}}});
        assertEquals(new Matriz(new int[][][] {{{37,16},{27,16}}}).toString(), matriz1.resta(matriz2).toString());
    }

    @Test
    public void restaDeberiaCalcularseNumerosCorrientes()
    {
        Matriz matriz1 = new Matriz(new int[][][] {{{5,6},{1,8}}});
        Matriz matriz2 = new Matriz(new int[][][] {{{3,4},{3,8}}});
        assertEquals(new Matriz(new int[][][] {{{1,12},{-1,4}}}).toString(), matriz1.resta(matriz2).toString());
    }
    
    @Test
    public void matrizOpuestaDeberiaCalcularseNumerosCorrientes()
    {
        Matriz matriz1 = new Matriz(new int[][][] {{{5,6},{-1,8}}});
        assertEquals(new Matriz(new int[][][] {{{-5,6},{1,8}}}).toString(), matriz1.matrizOpuesta().toString());
    }
    @Test
    public void divisionDeberiaCalcularseNumerosCorrientes()
    {
        Matriz matriz1 = new Matriz(new int[][][] {{{4,5},{2,3}}});
        Matriz matriz2 = new Matriz(new int[][][] {{{3,9},{1,4}}});
        assertEquals(new Matriz(new int[][][] {{{36,15},{8,3}}}).toString(), matriz1.division(matriz2).toString());
    }
}


