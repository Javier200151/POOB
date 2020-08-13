package Aplication;

import Presentation.Court;

public class Escudo extends Sorpresa{
	
	/**
	 * Constructor de Sorpresa
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param juego objeto principal de Aplication
	 * @param sigue booleano, define si el objeto sigue
	 * @param court objeto principal de presentation
	 */
	public Escudo(double x, double y, Juego juego,boolean sigue, Court court) {
		super(x, y, juego, sigue,court);
		nombre="Escudo";
	}
	@Override
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		this.pelota=pelota;
		ultimaRaqueta.setProtegido(true);
		//System.out.println("TieneESCUDO");
	}

}
