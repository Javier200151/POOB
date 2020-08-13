package Aplication;

import java.util.Timer;

import Presentation.Court;

public class PhantomRocket extends Sorpresa{
	private Timer time;
	private String ball;
	/**
	 * Constructor de PhantomRocket
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param juego objeto principal de Aplication
	 * @param sigue booleano, define si el objeto sigue
	 * @param court objeto principal de presentation
	 */
	public PhantomRocket(double x, double y, Juego juego,boolean sigue, Court court) {
		super(x, y, juego, sigue,court);
		nombre="PhantomRacket";
		time=new Timer();
		ball=new String("Imagenes/pelota.png");
		
	}
	@Override
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		this.pelota=pelota;
		this.fantasma=fantasma;
		System.out.println("EsInvisible");
		Generador generar=new Generador(court,2,null,juego);
		pelota.setImage(null);
		fantasma.setImage(ball);
		fantasma.setdx(pelota.getdx());
		fantasma.setdy(pelota.getdy());
		time.schedule(generar,5000,1000000000);
		fantasma.setX(0);
		fantasma.setY(0);
		desaparecer(court);
		
	}

}
