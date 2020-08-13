package Aplication;

import java.util.Timer;

import Presentation.Court;

public class ColdRacket extends Sorpresa{
	private Timer time;
	
	/**
	 * Constructor de ColdRacket
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param juego objeto principal de Aplication
	 * @param sigue booleano, define si el objeto sigue
	 * @param court objeto principal de presentation
	 */
	public ColdRacket(double x, double y, Juego juego, boolean sigue, Court court) {
		super(x, y, juego, sigue, court);
		time=new Timer();
		nombre="ColdRacket";
	}
	@Override
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		this.raqueta2=raqueta2;
		this.pelota=pelota;
		Generador generar=new Generador(court,2,null,juego);	
		pelota.freezer=true;
		time.schedule(generar,5000,1000000000);
		desaparecer(court);
	}
}
