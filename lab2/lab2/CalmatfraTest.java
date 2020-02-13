import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * The test class CalmatfraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalmatfraTest
{
    private Calmatfra Calmatfra;
    
    /**
     * Constructor de CalmatfraTest
     */
    public CalmatfraTest ()
    {
        Calmatfra=new Calmatfra();        
    }

    @Test
    public void consultaLaSumaDeberiaCalcularseNumerosNegativos() 
    {        
        Calmatfra.asigne("x", new int[][][] {{{1,4},{1,8}}});
        Calmatfra.asigne("y", new int[][][] {{{-1,16},{-1,16}}});
        Calmatfra.asigne("res", new int[][][] {{{3,16},{1,16}}});
        Calmatfra.opere("z", "x", '+', "y");
        assertEquals (Calmatfra.consulta("res"), Calmatfra.consulta("z"));        
    }
    
    @Test
    public void consultaLaSumaDeberiaCalcularseNumerosCorrientes() 
    {        
        Calmatfra.asigne("x", new int[][][] {{{2,5},{3,8}}});
        Calmatfra.asigne("y", new int[][][] {{{5,4},{4,5}}});
        Calmatfra.asigne("res", new int[][][] {{{33,20},{47,40}}});
        Calmatfra.opere("z", "x", '+', "y");
        assertEquals (Calmatfra.consulta("res"), Calmatfra.consulta("z"));        
    }
    
    @Test
    public void consultaLaRestaDeberiaCalcularseNumerosNegativos() 
    {        
        Calmatfra.asigne("x", new int[][][] {{{1,4},{1,8}}});
        Calmatfra.asigne("y", new int[][][] {{{-1,16},{-1,16}}});
        Calmatfra.asigne("res", new int[][][] {{{5,16},{3,16}}});
        Calmatfra.opere("z", "x", '-', "y");
        assertEquals (Calmatfra.consulta("res"), Calmatfra.consulta("z"));        
    }
    
    @Test
    public void consultaLaRestaDeberiaCalcularseNumerosCorrientes() 
    {        
        Calmatfra.asigne("x", new int[][][] {{{2,5},{3,8}}});
        Calmatfra.asigne("y", new int[][][] {{{5,4},{4,5}}});
        Calmatfra.asigne("res", new int[][][] {{{-17,20},{-17,40}}});
        Calmatfra.opere("z", "x", '-', "y");
        assertEquals (Calmatfra.consulta("res"), Calmatfra.consulta("z"));        
    }
    
    @Test
    public void consultaLaMatrizOpuestaDeberiaCalcularseNumerosCorrientes() 
    {        
        Calmatfra.asigne("x", new int[][][] {{{-2,5},{3,8}}});
        Calmatfra.asigne("res", new int[][][] {{{2,5},{-3,8}}});
        Calmatfra.opere("z", "x", '~', "y");
        assertEquals (Calmatfra.consulta("res"), Calmatfra.consulta("z"));        
    }
    
    @Test
    public void consultaLaDivisionDeberiaCalcularseNumerosCorrientes() 
    {        
        Calmatfra.asigne("x", new int[][][] {{{2,3},{5,6}}});
        Calmatfra.asigne("y", new int[][][] {{{4,3},{15,12}}});
        Calmatfra.asigne("res", new int[][][] {{{1,2},{2,3}}});
        Calmatfra.opere("z", "x", '/', "y");
        assertEquals (Calmatfra.consulta("res"), Calmatfra.consulta("z"));        
    }
}

