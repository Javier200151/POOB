package Aplication;

public class AutomataExcepcion extends Exception{

    public static final String  EXTENSION_NO_VALIDA= "La extension del archivo no se puede guardar";
    public static final String  ARCHIVO_NO_ENCONTRADO= "El archivo a abrir no existe";
    
    
    public AutomataExcepcion(String message){
        super(message);
    }

}
