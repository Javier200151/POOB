package Presentation;

import javax.swing.JOptionPane;

public class PoongExcepcion extends Exception{

    public static final String EXTENSION_NO_VALIDA= "La extension del archivo no se puede guardar";
    public static final String ARCHIVO_NO_ENCONTRADO= "El archivo a abrir no existe";
    public static final String NOMBRES_VACIOS= "Los jugadores deben tener un nombre";
    public static final String PELOTA_NO_SELECCIONADA= "Debe seleccionar un tipo de pelota antes de jugar";
    public static final String PERSONAJE_NO_SELECCIONADO= "Debe seleccionar un personaje antes de jugar";
    public static final String PERSONAJE_IGUALES="Deben ser diferentes personajes para cada jugador";
    
	    /**
	     * Constructor de PoongException
	     * @param message , String mensaje de error
	     */
	public PoongExcepcion(String message){
		super(message);
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}

