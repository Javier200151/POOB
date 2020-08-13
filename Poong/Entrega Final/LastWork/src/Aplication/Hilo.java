package Aplication;

import java.util.logging.Level;
import java.util.logging.Logger;

import Presentation.Court;

public class Hilo extends Thread{
	Court lamina;
	/**
	 * Constructor de Hilo
	 * @param lamina clase de la cancha GUI
	 */
	public Hilo(Court lamina) 
	{
		this.lamina=lamina;
	}
	public void run() 
	{
		while(true) 
		{
			try 
			{
				Thread.sleep(5);
			}catch(InterruptedException ex) 
			{
				Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE,null,ex);
			}
			lamina.repaint();
		}
	}
}
