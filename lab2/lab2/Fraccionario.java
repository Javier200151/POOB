import java.util.ArrayList;
import java.lang.Math;
/**
 * Fraccionario
 * Esta clase implementa el tipo de dato Fraccionario; es decir, un n�mero racional que se pueden escribir de la forma p/q, donde p y q son enteros, con q <> 0
 * La implemantacion se hace mediante objetos inmutables
 * INV: El fraccionario se encuentra representado en forma irreductible.
 * @author Javier Esteban López Peña
 * @author Andres Felipe Davila Gurrero
 *
 */
public class Fraccionario {
    private ArrayList<Integer> fraccionario;

    
    /**Calcula el maximo comun divisor de dos enteros
     * Lo implementaremos mediante el algoritmo recursivo
     * @param a primer entero
     * @param b segundo entero
     * @return el Maximo Comun Divisor de a y b
     */
  
    public static int mcd(int a,int b){

        if(b==0)
        {
            //System.out.println(a);
            return Math.abs(a);
        }else
        {
            int divisor=(a%b);
            //System.out.println(mcd(b,divisor));
            return Math.abs(mcd(b,divisor));
        }
        
    }    
    
    /**Crea un nuevo fraccionario, dado el numerador y el denominador
     * @param numerador
     * @param denominador. denominador <> 0
     */
    public Fraccionario (int numerador, int denominador) {
        fraccionario = new ArrayList<Integer>();
        if(denominador<0)
        {
            int nDenominador=denominador*-1;
            int newNumerador=numerador*-1;
            
            fraccionario.add(newNumerador);
            fraccionario.add(nDenominador);
            numerador();
            denominador();
        }else
        {
            fraccionario.add(numerador);
            fraccionario.add(denominador);
            numerador();
            denominador();
        }
    }
    
    /**Crea un fraccionario correspondiente a un entero
     * @param entero el entero a crear
     */
    public Fraccionario (int entero) {
        fraccionario= new ArrayList<Integer>();
        fraccionario.add(entero);
        fraccionario.add(1);
        
    }

     /**Crea un fraccionario, a partir de su representacion mixta. 
     * El numero creado es enteroMixto + numeradorMixto/denominadorMixto
     * @param enteroMixto la parte entera del numero
     * @param numeradorMixto el numerador de la parte fraccionaria
     * @param denominadorMixto el denominador de la parte fraccionaria. denominadorMixto<>0
     */
    public Fraccionario (int enteroMixto, int numeradorMixto, int denominadorMixto) {
        fraccionario= new ArrayList();
        int numerador = (enteroMixto*denominadorMixto)+numeradorMixto;
        fraccionario.add(numerador);
        fraccionario.add(denominadorMixto);
    }

    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return El numerador simplificado del fraccionario
     */
    public int numerador() {
        int mcd = mcd(fraccionario.get(0),fraccionario.get(1));
        int num=fraccionario.get(0)/mcd;
        //System.out.println(num);
        fraccionario.set(0,num);
        int deno = fraccionario.get(1)/mcd;
        //System.out.println(deno);
        fraccionario.set(1,deno);        
        return fraccionario.get(0);
    }
    
    /**
     * Un fraccionario p/q esta escrito en forma simplificada si q es un entero Positivo y 
     * el maximo comun divisor de p y q es 1.
     * @return el denominador simplificado del fraccionario
     */
    public int denominador() {
        //int mcd = mcd(fraccionario.get(0),fraccionario.get(1));
        return fraccionario.get(1);
    }
    
    /**Suma este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario sume (Fraccionario otro) {
        int n1=fraccionario.get(0);
        int d1=fraccionario.get(1);
        int n2=otro.numerador();
        int d2=otro.denominador();
        Fraccionario suma=new Fraccionario((n1*d2+n2*d1),(d1*d2));
        return suma;
    }
    
    /**Resta este fraccionario con otro fraccionario
     * @param otro es otro fraccionario
     * @return este+otro
     */
    public Fraccionario resta (Fraccionario otro) {
        int n1=fraccionario.get(0);
        int d1=fraccionario.get(1);
        int n2=otro.numerador();
        int d2=otro.denominador();
        Fraccionario resta=new Fraccionario((n1*d2-n2*d1),(d1*d2));
        return resta;
    }
    
    /**Multiplica este fraccionario con otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario multiplique (Fraccionario otro) {
        int num1=fraccionario.get(0);
        int den1=fraccionario.get(1);
        int num2=otro.numerador();
        int den2=otro.denominador();
        Fraccionario multiplique=new Fraccionario((num1*num2),(den1*den2));
        return multiplique;
    }
    
    /**
     * Convierte todos los valores fraccionarios de la matriz en su opuesto
     */
    public Fraccionario matrizOpuesta () {
        int n1=fraccionario.get(0);
        int d1=fraccionario.get(1);
        Fraccionario MatrizOpuesta=new Fraccionario(n1*(-1),d1);
        return MatrizOpuesta;
    }
    
    /**Divide este fraccionario sobre otro fraccionario
     * @param otro El otro fraccionario
     * @return este * otro
     */
    public Fraccionario division (Fraccionario otro) {
        int n1=fraccionario.get(0);
        int d1=fraccionario.get(1);
        int n2=otro.numerador();
        int d2=otro.denominador();
        Fraccionario division=new Fraccionario(n1*d2,n2*d1);
        return division;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        return equals((Fraccionario)obj);
    }    
    
    /**Compara este fraccionario con otro fraccionario
     * @param otro eL otro fraccionario
     * @return true si este fraccionario es igual matematicamente al otro fraccionario, False d.l.c.
     */
    public boolean equals (Fraccionario otro) {
        boolean igual;
        igual=(fraccionario.get(0)==otro.numerador() && fraccionario.get(1)==otro.denominador())? true:false;
        return igual;
    }


    /** Calcula la representacion en cadena de un fraccionario en formato mixto simplificado
     * @see java.lang.Object#toString(java.lang.Object)
     */
    @Override
    public String toString() {
        String res=Integer.toString(fraccionario.get(0))+"/"+Integer.toString(fraccionario.get(1));
        return res;
    }
    
}
