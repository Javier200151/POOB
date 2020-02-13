import java.util.ArrayList;
/**
 * @author Javier Esteban López Peña
 * @author Andres Felipe Davila Gurrero
 *
 */
public class Matriz{
    //{{{1,2},{2,3},{4,5},{6,7}}}
    //{{{1,4},{1,8}}}
    private Fraccionario [][] matriz;
    private String mensaje=" ";
    private int m;
    private int n;
    /**
     * Retorna una matriz dados sus elementos. Los fraccionarios se representan como {numerador, denominador}
     */
    
    public static boolean esMatriz (int [][][] elementos){
        return false;
    }
    
    /**
     * Asigna tuplas de numerador y denominador dentro de una matriz
     * @param recibe una matriz cubica llamada elementos
     */
    public Matriz (int [][][] elementos) {
      n=elementos[0].length;
      m=elementos.length;
      matriz= new Fraccionario[m][n];
      for(int i=0;i<m;i++)
      {
            for(int j=0;j<n;j++)
            {
               int[] actual=new int[2];
               actual=elementos[i][j];
               
               Fraccionario f = new Fraccionario( actual[0], actual[1]);
               matriz[i][j]= f;

            }
      }         
    }    
    
    /**
     * Retorna una matriz dados sus elementos. 
     */ // {{{-1,4},{1,8}}}
    public Matriz (Fraccionario  elementos[][]) {
          matriz= new Fraccionario[elementos.length][elementos[0].length];
          for(int i=0;i<elementos.length;i++)
          {
                for(int j=0;j<elementos[0].length;j++)
                {         
                   matriz[i][j]= elementos[i][j];    
                }
          }   
    }
   
    
     /**
     * Retorna una matriz dada su diagonal. 
     */    
    public Matriz (Fraccionario d []){

    }    

    /**
     * Retorna una matriz de un numero repetido dada su dimension. 
     */
    public Matriz (Fraccionario e, int f, int c) {

    }
    
    /**
     * Retorna una matriz identidad dada su dimension. 
     */
    public Matriz (int n) {
    }
    
    
    public Matriz dimension(){
        return null;
    }
    
    
    public Fraccionario get(int f, int c){
        return null;
    }
    
    /**
     * Compara esta matriz con otra
     */
    public boolean equals (Matriz otra) {
        return false;
    }

    /** 
     * Compara esta matriz con otra
     */
    @Override
    public boolean equals(Object otra) {
        return false;
    }
    
    
    /**
     * Retorna una cadena con los datos de la matriz alineado a derecha por columna
     * 
    */  
   @Override
    public String toString () {       
        for(int i=0;i<matriz.length;i++)
        {            
            for(int j=0;j<matriz[0].length;j++)
            {
                mensaje+=matriz[i][j].toString().replace("\n"," ");
                mensaje+=", ";
            }            
        }  
        return mensaje;
    } 
    
    private Fraccionario[][] ObtenerMatriz()
    {
        return matriz;
    }
    
    //Retorna la matriz con el numero de filas o columnas
    /**
     * Suma cada componente fraccionario de ambas matrices
     * @param m Matriz, operando 2
     */
    public Matriz sume(Matriz m)
    {                        
        Fraccionario[][] matriz2=m.ObtenerMatriz();
        int[][][] res;
        res= new int[1][matriz[0].length][2];

        //System.out.println(matriz[0].length+ " longitud");
        //System.out.println(matriz2[0][0] + " cero");
        //System.out.println(matriz2[0][1] + " uno");
        for(int i=0;i<matriz[0].length;i++)
        {  //Fraccionario   
           //System.out.println(i+ "i") ;           
           res[0][i][0]=(matriz[0][i].sume(matriz2[0][i])).numerador();
           res[0][i][1]=(matriz[0][i].sume(matriz2[0][i])).denominador();           
        }
        
        return new Matriz(res);
    }
    
    /**
     * Resta cada componente fraccionario de ambas matrices
     * @param m Matriz, operando 2
     */
    public Matriz resta(Matriz m)
    {                        
        Fraccionario[][] matriz2=m.ObtenerMatriz();
        int[][][] res;
        res= new int[1][matriz[0].length][2];

        //System.out.println(matriz[0].length+ " longitud");
        //System.out.println(matriz2[0][0] + " cero");
        //System.out.println(matriz2[0][1] + " uno");
        for(int i=0;i<matriz[0].length;i++)
        {  //Fraccionario   
           //System.out.println(i+ "i") ;           
           res[0][i][0]=(matriz[0][i].resta(matriz2[0][i])).numerador();
           res[0][i][1]=(matriz[0][i].resta(matriz2[0][i])).denominador();           
        }
        
        return new Matriz(res);
    }
    
    /**
     * Convierte cada fraccionario en su opuesto
     */
    public Matriz matrizOpuesta()
    {                        
        int[][][] res;
        res= new int[1][matriz[0].length][2];

        //System.out.println(matriz[0].length+ " longitud");
        //System.out.println(matriz2[0][0] + " cero");
        //System.out.println(matriz2[0][1] + " uno");
        for(int i=0;i<matriz[0].length;i++)
        {  //Fraccionario   
           //System.out.println(i+ "i") ;           
           res[0][i][0]=matriz[0][i].matrizOpuesta().numerador();
           res[0][i][1]=matriz[0][i].matrizOpuesta().denominador();           
        }
        
        return new Matriz(res);
    }
    
    /**
     * Divide cada componente fraccionario de ambas matrices
     * @param m Matriz, operando 2
     */
    public Matriz division(Matriz m)
    {              
        Fraccionario[][] matriz2=m.ObtenerMatriz();
        int[][][] res;
        res= new int[1][matriz[0].length][2];

        //System.out.println(matriz[0].length+ " longitud");
        //System.out.println(matriz2[0][0] + " cero");
        //System.out.println(matriz2[0][1] + " uno");
        for(int i=0;i<matriz[0].length;i++)
        {  //Fraccionario   
           //System.out.println(i+ "i") ;           
           res[0][i][0]=matriz[0][i].division(matriz2[0][i]).numerador();
           res[0][i][1]=matriz[0][i].division(matriz2[0][i]).denominador();           
        }
        
        return new Matriz(res);
    }
    
    /**
     * Multiplicacion de matrices
     * @param m Matriz, operando 2
     */
    public Matriz producto(Matriz mat)
    {
        Matriz res=null;
        //System.out.println(n+"jeg");
        //System.out.println(mat.getM()+"jeg");
        if(mat.getM()!=n)
        {
            System.out.println("matrices de diferentes dimensiones");
        }
        else
        {
            Fraccionario [][] aux= new Fraccionario[m][mat.getN()];
            Fraccionario [][] aux2=mat.ObtenerMatriz();
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<mat.getN();j++)
                {
                    Fraccionario cont= new Fraccionario(0,0);
                    for(int k=0;k<n;k++)
                    {
                        cont=cont.sume(matriz[i][k].multiplique(aux2[k][j]));
                    }
                    aux[i][j]=cont;
                }
               
               
            }
            res= new Matriz(aux);
           
        }
        return res;
    }

    public int getM()
    {
        return m;
    }
    public int getN()
    {
        return n;
    }
}
