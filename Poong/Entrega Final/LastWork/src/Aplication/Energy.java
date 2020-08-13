package Aplication;

import java.awt.geom.Rectangle2D;

import Presentation.Court;

public class Energy extends Sorpresa{
	
	/**
	 * Constructor de Energy
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param juego objeto principal de Aplication
	 * @param sigue booleano, define si el objeto sigue
	 * @param court objeto principal de presentation
	 */
	public Energy(double x, double y, Juego juego, boolean sigue, Court court) {
		super(x, y, juego, sigue, court);
		nombre="Energy";
	}
	@Override
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		this.pelota=pelota;
		ultimaRaqueta.setEnergia1(10000-ultimaRaqueta.getEnergia1());
		ultimaRaqueta.setEnergia2(10000-ultimaRaqueta.getEnergia2());
	}
}