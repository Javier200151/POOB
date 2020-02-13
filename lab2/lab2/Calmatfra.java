/** Calculadora.java
 * Representa una calculadora de matrices de fraccionarios
 * @author Javier Esteban López Peña
 * @author Andres Felipe Davila Gurrero
 */
import java.util.HashMap;

public class Calmatfra{
    private HashMap<String, Matriz> variables;
    //Consultar en el API Java la clase HashMap
    
    /**
     * Constructor de Calmatfra
     */
    public Calmatfra(){
        variables= new HashMap();        
    }

    
    /**
     * Crea una variable, la matriz para asignar y guardar numerador y denominador
     * @param variable cadena para consultar la matriz
     * @param matriz cubica donde guardar los fraccionarios
     */
    public void asigne(String variable, int [][][] matriz){         
        variables.put(variable,new Matriz(matriz ));
    }

    // Los operadores binarios : + (suma), - (resta), . (multiplique elemento a elemento), * (multiplique matricial)
    /**
     * Operador matrices (suma, resta, multiplicacion, división)
     * @param respuesta cadena, llave de la matriz respuesta
     * @param operando1 cadena, llave de un operador
     * @param operando2 cadena, llave de un operador
     * @param operacion char, caracter (+,-,*,~,/)
     * Si es la MatrizOpuesta, operando2 puede ser cualquier cadena sin tenerse en cuenta
     */
    public void opere(String respuesta, String operando1, char operacion, String operando2){
        //System.out.println(operando1);
        
        Matriz op1=variables.get(operando1);
        //System.out.println(op1+"op1");
        
        Matriz op2=variables.get(operando2);
        //System.out.println(op2+"op2");
        
        if (operacion=='+')
        {
            Matriz matrizsum=op1.sume(op2);
            variables.put(respuesta,matrizsum);
        } else if (operacion=='-')
        {
            Matriz matrizresta=op1.resta(op2);
            variables.put(respuesta,matrizresta);
        } else if (operacion=='~')
        {
            Matriz matrizOpuesta=op1.matrizOpuesta();
            variables.put(respuesta,matrizOpuesta);            
        } else if (operacion=='/')
        {
            Matriz matrizdiv=op1.division(op2);
            variables.put(respuesta,matrizdiv); 
        }
    }
    
    /**
     * consulta los fraccionarios de la matriz de la variable
     * @param variable cadena, para llamar los fraccionarios de la matriz
     */
    public String consulta(String variable){   
        String a= variables.get(variable).toString();
        return a;
    }
    
    public boolean ok(){
        return false;
    }
}
    



