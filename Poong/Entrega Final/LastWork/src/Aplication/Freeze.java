package Aplication;

import java.awt.geom.Rectangle2D;

import java.util.Timer;
import java.util.TimerTask;

import Presentation.Court;

public class Freeze extends Sorpresa {

	private Timer time;
	
	/**
	 * Constructor de Freeze
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param juego objeto principal de Aplication
	 * @param sigue booleano, define si el objeto sigue
	 * @param court objeto principal de presentation
	 */
	public Freeze(double x, double y, Juego juego, boolean sigue, Court court) {
		super(x, y, juego,sigue, court);
		time=new Timer();
		nombre="Freeze";
	}
	@Override
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		this.raqueta2=raqueta2;
		this.pelota=pelota;
		System.out.println("Freezer");
		Generador generar=new Generador(court,2,this,juego);
		raqueta2.setVelocidad(0);
		raqueta.setVelocidad(0);
		ultimaRaqueta.setVelocidad(2);
		time.schedule(generar,3000,1000000000);
		desaparecer(court);
	}
}
