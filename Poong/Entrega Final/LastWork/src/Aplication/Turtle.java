package Aplication;

import java.util.Timer;

import Presentation.Court;

public class Turtle extends Sorpresa{
	private Timer time;
	
	/**
	 * Constructor de Turtle
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param juego objeto principal de Aplication
	 * @param sigue booleano, define si el objeto sigue
	 * @param court objeto principal de presentation
	 */
	public Turtle(double x, double y, Juego juego, boolean sigue, Court court) {
		super(x, y, juego, sigue, court);
		time=new Timer();
		nombre="Turtle";
	}
	@Override
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		this.raqueta2=raqueta2;
		this.pelota=pelota;
		System.out.println("Freezer");
		Generador generar=new Generador(court,2,null,juego);
		raqueta2.setVelocidad(1);
		raqueta.setVelocidad(1);
		ultimaRaqueta.setVelocidad(2);
		time.schedule(generar,3000,1000000000);
		desaparecer(court);
	}
}
