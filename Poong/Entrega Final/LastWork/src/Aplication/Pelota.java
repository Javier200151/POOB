package Aplication;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;


public abstract  class Pelota {
	protected double x;
	protected double y;
	private int ANCHO=15,ALTO=15;
	protected double dx;
	protected double dy;
	protected int counter1;
	protected int counter2;
	private ImageIcon image;
	public boolean veloz;
	public boolean freezer;
	protected Juego juego;
	
	/**
	 * Constructor de Pelota
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param nombre string, nombre de la raqueta
	 */
	public Pelota(double x,double y,Juego juego) 
	{
		freezer=false;
		veloz=false;
		this.x=x;
		this.y=y;
		this.juego=juego;
		counter1=0;
		counter2=0;
		dx=0.5;
		dy=0.5;
	}
	/**
	 * retorna el objeto rectangulo de la pelota
	 * @return rectagle objeto de la pelota
	 */
	public Rectangle2D getPelota() 
	{
		return new Rectangle2D.Double(x,y,ANCHO,ALTO);
	}
	/**
	 * mueve la pelota teniendo en cuenta cada limite
	 * @param limites de la cancha
	 * @param raqueta1 objeto 
	 * @param raqueta2 objeto
	 * @param pausado si esta pausado o no el juego
	 */
	public void mover(Rectangle limites,boolean raqueta1,boolean raqueta2,boolean pausado) 
	{
		
		x+=dx;
		y+=dy;

		if(raqueta1) 
		{
			if(veloz)
			{
				velocidadNormal();
			}
			if(freezer)
			{
				congelar(juego.raqueta1);
			}
			dy=-dy;
			y=140;
		}
		if(raqueta2) 
		{
			if(veloz)
			{
				velocidadNormal();
			}
			if(freezer)
			{
				congelar(juego.raqueta2);
			}
			dy=-dy;
			y=750;
		}
		if (y>780)
		{
			x=350;
			y=440;
			counter1++;
		}
		if(x>=580)
		{
			dx=-dx;
			
		}
		if(y<100) 
		{
			x=350;
			y=440;
			counter2++;
		}
		
		if(x<=120) 
		{
			dx=-dx;	
		}
		
	}
	/**
	 * detiene la velocidad de la raqueta enviada
	 * @param raqueta a congelar
	 */
	protected void congelar(Raqueta raqueta) {
		freezer=false;
		raqueta.setVelocidad(0);
	}
	/**
	 * retorna el contador numero 1
	 * @return int contador
	 */
	public int cont1()
	{
		return counter1;
	}
	/**
	 * retorna el contador numero 2
	 * @return int contador
	 */
	public int cont2() 
	{
		return counter2;
	}
	/**
	 * suma el puntaje 1
	 * @param s int a sumar
	 */
	public void setCounter1(int s) 
	{
		if(veloz)
		{
			velocidadNormal();
		}
		counter1=counter1+s;
	}
	/**
	 * suma el puntaje 2
	 * @param s int a sumar
	 */
	public void setCounter2(int s) 
	{
		if(veloz)
		{
			velocidadNormal();
		}
		counter2=counter2+s;
	}
	/**
	 * setear velocidad para pelota flash
	 */
	public void velocidadFlash()
	{
		veloz=false;
		dx=1;
		dy=1;
	}
	/**
	 * setear velocidad para pelota slow
	 */
	public void velocidadNormal()
	{
		veloz=false;
		dx=1;
		dy=1;
	}
	/**
	 * coloca la imagen al objeto
	 * @param rute string, direccion de donde se encuentra la imagen
	 */
	public void setImage(String rute) 
	{
		image = new ImageIcon(rute);
	}
	/**
	 * coloca la imagen al objeto
	 * @param rute string, direccion de donde se encuentra la imagen
	 */
	public Image getImage() 
	{
		Image temporal=image.getImage().getScaledInstance(ANCHO,ALTO,Image.SCALE_SMOOTH);
		ImageIcon res=new ImageIcon(temporal);
		return res.getImage();
	}
	/**
	 * posicion x de la pelota
	 * @return x int
	 */
	public double getX() 
	{
		return x;
	}
	/**
	 * Posicion y de la pelota
	 * @return y int
	 */
	public double getY() 
	{
		return y;
	}
	/**
	 * Pausar movimiento de la raqueta
	 * @param pausado booleano
	 */
	public void pausaRaqueta(boolean pausado) 
	{
		if(pausado) 
		{
			dx=0;
			dy=0;
		}
		else 
		{
			dx=1;
			dy=1;
		}	
	}
	/**
	 * aumenta en 20% la velocidad x
	 */
	public void updx() 
	{
		dx=dx+dx*0.2;
	}
	/**
	 * aumenta en 20% la velocidad y
	 */
	public void updy() 
	{
		dy=dy+dy*0.2;
	}
	/**
	 * obtiene la velocidad en x
	 * @return int dx
	 */
	public double getdx() 
	{
		return dx;
	}
	/**
	 * obtiene la velocidad en y
	 * @return int dy
	 */
	public double getdy() 
	{
		return dy;
	}
	protected abstract void setdx(double d);
	protected abstract void setdy(double d);
	public void setX(double i) {
		// TODO Auto-generated method stub	
	}
	public void setY(double i) {
		// TODO Auto-generated method stub		
	}

}
