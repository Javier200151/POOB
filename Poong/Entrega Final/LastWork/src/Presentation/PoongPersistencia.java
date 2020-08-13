package Presentation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class PoongPersistencia {
	/**
	 * Guarda el archivo file
	 * @param file archivo
	 * @param a gameGui
	 * @throws PoongExcepcion
	 */
	public static void salvar(File file,GameGui a) throws PoongExcepcion
	{
		if(file.getName().endsWith(".dat")) 
		{
			try 
			{
				ObjectOutputStream out= new ObjectOutputStream( new FileOutputStream(file));
				out.writeObject(a);
				out.close();
			} catch(Exception e) 
			{
				throw new PoongExcepcion("Ocurrio un error al guardar "+file.getName());
			}
		}
		else 
		{
			throw new PoongExcepcion(PoongExcepcion.EXTENSION_NO_VALIDA);
		}
	}
	/**
	 * Abre un archivo guardado .dat
	 * @param file archivo
	 * @param a gameGui
	 * @return clase de gameGui
	 * @throws PoongExcepcion
	 */
	public static GameGui abrir(File file,GameGui a) throws PoongExcepcion
	{
		if(file.getName().endsWith(".dat")) 
		{
			try 
			{
				ObjectInputStream in= new ObjectInputStream( new FileInputStream(file));
				GameGui a1=(GameGui)in.readObject();
				in.close();
				return a1;
			} catch(Exception e) 
			{
				System.out.println(e);
				throw new PoongExcepcion("Ocurrio un error al abrir  "+file.getName());
				
			}
		}
		else 
		{
			System.out.println("perra vida");
			throw new PoongExcepcion(PoongExcepcion.ARCHIVO_NO_ENCONTRADO);
			
		}
	}
}
