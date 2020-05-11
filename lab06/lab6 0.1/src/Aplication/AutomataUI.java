package Aplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AutomataUI {
	public static void salvar(File file,AutomataCelular a) throws AutomataExcepcion
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
				throw new AutomataExcepcion("Ocurrio un error al guardar "+file.getName());
			}
		}
		else 
		{
			throw new AutomataExcepcion(AutomataExcepcion.EXTENSION_NO_VALIDA);
		}
	}
	public static AutomataCelular abrir(File file,AutomataCelular a) throws AutomataExcepcion
	{
		if(file.getName().endsWith(".dat")) 
		{
			try 
			{
				ObjectInputStream in= new ObjectInputStream( new FileInputStream(file));
				AutomataCelular a1=(AutomataCelular)in.readObject();
				in.close();
				return a1;
			} catch(Exception e) 
			{
				System.out.println(e);
				throw new AutomataExcepcion("Ocurrio un error al abrir  "+file.getName());
				
			}
		}
		else 
		{
			System.out.println("perra vida");
			throw new AutomataExcepcion(AutomataExcepcion.ARCHIVO_NO_ENCONTRADO);
			
		}
	}
}
