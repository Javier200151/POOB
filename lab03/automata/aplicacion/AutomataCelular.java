package aplicacion;
import java.awt.Color;
import java.util.*;

public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;
    private static int [][] movements={{-1,1},{0,1},{1,1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1}};
    
    /**
     * Constructor de AutomataCelular
     */
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }
    /**
     * Se obtiene la longitud de la matriz
     * @return int, longitud de la matriz
     */
    public int  getLongitud(){
        return LONGITUD;
    }

    /**
     * Obtener el elemento de una posicion especifica
     * @return Elemento, objeto tipo Elemento en una posicion
     * @param c int, columna posicion 
     * @param f int, fila posicion 
     */
    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    /**
     * Pone un elemento de una posicion especifica
     * @param nueva Elemento, objeto tipo Elemento a añadir
     * @param c int, columna posicion 
     * @param f int, fila posicion 
     */
    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }
    /**
     * Constructor de elementos en la automata
     */
    public void algunosElementos(){
        Elemento john= new COVID19(this,3,4);
        john.cambie();
        Elemento horton= new COVID19(this,4,3);
        horton.cambie();
        Elemento john1= new COVID19(this,5,4);
        john1.cambie();
        Elemento john2= new Celula(this,3,3);
        john2.cambie();
        Elemento john3= new Celula(this,5,5);
        john2.cambie();
        Elemento john4= new Celula(this,3,5);
        john2.cambie();       
    }
    /**
     * Realiza un paso en el tiempo de vida de las celulas
     */
    public void ticTac()
    {
        for(int i=0; i<automata.length;i++)
        {
            for(int j=0; j<automata.length;j++)
            {
                if(automata[i][j]!=null){
                    automata[i][j].decida();      
                }
            }
        }
        for(int i=0; i<automata.length;i++)
        {
            for(int j=0; j<automata.length;j++)
            {    
                if(automata[i][j]==null && counter(i,j)==3)
                {                  
                    automata[i][j]=new Celula(this,i,j);
                }
            }
        }  
        for(int i=0; i<automata.length;i++)
        {
            for(int j=0; j<automata.length;j++)
            {
                if(automata[i][j]!=null){
                    automata[i][j].cambie();
                }
            }
        }  
        crearInfectados();
    }
    /**
     * Infecta celulas de tipo Celula y las convierte a tipo COVID19
     */
    private void crearInfectados()
    {
        for(int i=0; i<automata.length;i++)
        {
            for(int j=0; j<automata.length;j++)
            {
                if(automata[i][j] instanceof Virus){
                    infectar(i,j);
                }
            }
        }         
    }
    /**
     * Valida que no se salga de la matriz las posiciones
     * @param c int, columna posicion 
     * @param f int, fila posicion 
     */
    private boolean valid(int f, int c)
    {
         boolean v=true;
         if(f<0 || f>=LONGITUD)
         {
             v=false;
         }
         else if(c<0 || c>=LONGITUD)
         {
             v=false;
         }
         else if(getElemento(f,c)==null)
         {
             v=false;
         }
         return v;
    }
    /**    
     * Verifica si tiene celulas a su derecha
     * @param columna int, columna posicion 
     * @param fila int, fila posicion 
     * @return boolean, booleano que dice si existe una celula a la derecha
     */
    public boolean verificarDerecha(int fila, int columna)
    {
        boolean derecha=false;
        int temp1=fila;
        int temp2=columna+1;
        if(valid(temp1,temp2) && getElemento(temp1,temp2).isVivo())
        {
            derecha=true;              
        }            
        return derecha;
    }
    /**
     * Conocer las celulas vecinas en desde una posicion especifica
     * @param c int, columna posicion 
     * @param f int, fila posicion
     * @return int , numero de celulas vecinas
     */
    public int counter(int f,int c)
    {
        int cont=0;
        for(int [] move:movements)
        {
           int temp1=f+move[0];
           int temp2=c+move[1];
           if(valid(temp1,temp2) && getElemento(temp1,temp2).isVivo())
           {
               cont++;              
           }            
        }
        return cont;
    }
    /**
     * Infecta las celulas vecinas de una posicion especifica
     * @param c int, columna posicion 
     * @param f int, fila posicion
     */
    public void infectar(int f,int c)
    {
        for(int [] move:movements)
        {
           int temp1=f+move[0];
           int temp2=c+move[1];
           if(valid(temp1,temp2) && getElemento(temp1,temp2).isVivo() && ( getElemento(temp1,temp2) instanceof Celula) ?true: false)
           {
               automata[temp1][temp2]=new COVID19(this,temp1,temp2);  
               automata[temp1][temp2].cambie();
           }            
        }
        automata[f][c].cambie();
    }
    /**
     * Cambia una COVID19 por una celula comun
     * @param c int, columna posicion 
     * @param f int, fila posicion
     */
    public void desinfectar(int f, int c)
    {
        automata[f][c]=new Celula(this,f,c);
    }
    /**
     * Cambia los Elementos tipo Virus a uno tipo Barrera
     * @param c int, columna posicion 
     * @param f int, fila posicion
     */
    public void desinfectaBarrera(int f, int c)
    {
        automata[f][c]=new Barrera(this,f,c);
    }
}
