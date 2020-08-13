package Aplication;

import Presentation.Court;

public class Fastball extends Sorpresa{
	
	/**
	 * Constructor de Fastball
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param juego objeto principal de Aplication
	 * @param sigue booleano, define si el objeto sigue
	 * @param court objeto principal de presentation
	 */
	public Fastball(double x, double y, Juego juego, boolean sigue, Court court) {
		super(x, y, juego,sigue, court);
		nombre="FastBall";
	}
	@Override
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		this.pelota=pelota;
		pelota.setdx(1.2);
		pelota.setdy(1.2);
		System.out.println("aumento velocidad un 20%");
		
		System.out.println("Fastball");
	}
}
