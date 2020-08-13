package Aplication;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Presentation.Court;

public abstract class Sorpresa {
	
	private double x;
	private double y;
	private int counter1;
	private int counter2;
	private int dx;
	private int dy;
	private int ANCHO=45,ALTO=45;
	protected int tipo;
	private ImageIcon image;
	protected Raqueta raqueta;
	protected Raqueta raqueta2;
	protected Pelota pelota;
	protected Pelota fantasma;
	protected Timer time;
	protected Court court;
	private boolean sigue;
	protected Juego juego;
	protected String nombre;

	/**
	 * Constructor de Sorpresa
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param sigue booleano, define si el objeto sigue
	 */
	public Sorpresa(double x,double y,Juego juego, boolean sigue,Court court)
	{
		nombre="";
		this.court=court;
		this.x=x;
		this.y=y;
		counter1=0;
		counter2=0;
		this.sigue=sigue;
		this.juego=juego;
	}
	/**
	 * obtiene el tipo de sorpresa indicada en int
	 * @return int que indica la sorpresa
	 */
	public int getTipo()
	{
		return tipo;
	}
	/**
	 * Detecta la colision
	 * @param r el objeto de rectangulo con quien colisiona
	 * @return booleano para comprobar colision
	 */
	public boolean colision(Rectangle2D r)
	{
		return this.getSorpresa().intersects(r);
	}
	/**
	 * accion de la sorpresa
	 * @param raqueta objeto de la raqueta1
	 * @param raqueta2 objeto de la raqueta2
	 * @param pelota objeto de la pelota
	 * @param activador indica con enteros el ultimo quien toco la pelota
	 * @param ultimaRaqueta es el objeto de la ultima raqueta que toco la pelota
	 * @param fantasma objeto pelota fantasma
	 */
	public void accionSorpresa(Raqueta raqueta, Raqueta raqueta2, Pelota pelota,int activador, Raqueta ultimaRaqueta,Pelota fantasma)
	{
		this.raqueta=raqueta;
		System.out.println(pelota instanceof PerfectBall);
		this.pelota=pelota;
		this.fantasma=fantasma;
	}
	/**
	 * Mueve el objeto hacia las coordenadas que es la posicion de la pelota
	 * @param d coordenada x de la pelota
	 * @param e coordenada y de la pelota
	 */
	public void acercar(double d, double e)
	{
		if(sigue)
		{
			if(x<d && y<e)
			{
				x=x+1;
				y=y+1;
			}else if(x>d && y<e)
			{
				x=x-1;
				y=y+1;
			}else if(x<d && y>e)
			{
				x=x+1;
				y=y-1;
			}else if(x>d && y>e)
			{
				x=x-1;
				y=y-1;
			}
		}
	}
	/**
	 * Desplaza fuera del canvas el objeto
	 * @param court objeto de la cancha
	 */
	public void desaparecer(Court court)
	{
		court.actualizarSorpresa();
		x=x+10000;
	}
	/**
	 * Obtener el objeto rectangulo de la sorpresa
	 * @return objeto rectangulo
	 */
	public Rectangle2D getSorpresa()
	{
		return new Rectangle2D.Double(x,y,ANCHO,ALTO);
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
	 * coloca la imagen al objeto
	 * @param rute string, direccion de donde se encuentra la imagen
	 */
	public void setImage(String rute) 
	{
		image = new ImageIcon(rute);
	}
	/**
	 * retorna la imagen al objeto
	 * @return imagen del bloque
	 */
	public Image getImage() 
	{
		Image temporal=image.getImage().getScaledInstance(ANCHO,ALTO,Image.SCALE_SMOOTH);
		ImageIcon res=new ImageIcon(temporal);
		return res.getImage();
	}
	/**
	 * retorna pocion x del bloque
	 * @return x int coordenada
	 */
	public double getX() 
	{
		return x;
	}
	/**
	 * retorna pocion y del bloque
	 * @return y int coordenada
	 */
	public double getY() 
	{
		return y;
	}
	/**
	 * obtiene el nombre de la sopresa
	 * @return string nombre
	 */
	public String getNombre()
	{
		return nombre;
	}
}
