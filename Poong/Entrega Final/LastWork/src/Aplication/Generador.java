package Aplication;

import java.util.Random;
import java.util.TimerTask;
import Presentation.Court;

public class Generador extends TimerTask{
	
	private boolean[] condicion;
	private Court court;
	private int tipo;
	private Freeze sorpresa;
	private Juego juego;
	
	/**
	 * Contructor de generador
	 * @param court clase principal de Presentation
	 * @param tipo de timer
	 * @param freezer objeto de sorpresa
	 * @param juego clase principal de Aplication
	 */
	public Generador(Court court, int tipo,Freeze freezer, Juego juego)
	{
		condicion=new boolean[2];
		condicion[0]=false;
		condicion[1]=true;
		this.sorpresa=sorpresa;
		this.tipo=tipo;
		this.court=court;
		this.juego=juego;
	}
	@Override
	public void run()
	{
		
		if(tipo==1)
		{
			generarSorpresas();
			desaparecerObjetivos();
			generarBloques();
		}else if(tipo==2)
		{
			descongelar();
		}else if(tipo==3)
		{
			finalizar();
		}
	}
	/**
	 * Funcion para finalizar el juego
	 */
	private void finalizar() {
		court.volverMenu();
	}
	/**
	 * Generador de sorpresas
	 */
	public void generarSorpresas()
	{
		Random random = new Random();
		int x=random.nextInt(330);
		if (x<120)
		{
			x=x+120;
		}
		int tipo=random.nextInt(8);
		if(tipo==2)
		{
			tipo=0;
		}
		//System.out.println(tipo+" Random");
		int y=random.nextInt(700);
		if (y<120)
		{
			y=y+120;
		}
		boolean sigue=condicion[random.nextInt(2)];
		juego.generarSopresa(x,y,tipo,sigue);
	}
	/**
	 * Desplaza los objetivos fuera del canvas
	 */
	public void desaparecerObjetivos() 
	{
		int x1=1000;
		int x2=1000;
		int y1=1000;
		int y2=1000;
		juego.generarObjetivo(x1, y1, x2, y2);
	}
	/**
	 * generador de bloque por tiempo
	 */
	public void generarBloques() 
	{
		Random random = new Random();
		int x=random.nextInt(330);
		if (x<120)
		{
			x=x+120;
		}
		int y=random.nextInt(700);
		if (y<120)
		{
			y=y+120;
		}
		boolean sigue=condicion[random.nextInt(2)];
		juego.generarBloques(x, y,sigue);
	}
	/**
	 * devuelve la velocidad normal a las raquetas
	 */
	public void descongelar()
	{
		//System.out.println("a");
		court.descongelar();
	}

}
