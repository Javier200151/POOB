package aplicacion; 

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @version ECI 2016
 */
public class SINAPExcepcion extends Exception{

	public static final String AREA_NULA="El nombre internacional es nulo";
	public static final String AREA_REPETIDA="No se pueden adicionar duplicados";
	public static final String AREA_INVALIDA="No se permiten areas negativas";
	public static final String ERROR_BUSCAR="Error al buscar";

	public SINAPExcepcion(String message)
	{
		super(message);
	}

}