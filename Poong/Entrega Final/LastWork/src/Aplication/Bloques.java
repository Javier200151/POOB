package Aplication;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Bloques {
	private double x;
	private double y;
	private int counter1;
	private int counter2;
	private int ANCHO=45,ALTO=45;
	protected int tipo;
	private ImageIcon image;
	protected Raqueta raqueta;
	protected Pelota pelota;
	private boolean sigue;

	/**
	 * Constructor de Bloques
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param sigue booleano, define si el objeto sigue
	 */
	public Bloques(double x,double y,boolean sigue)
	{
		this.x=x;
		this.y=y;
		counter1=0;
		counter2=0;
		this.sigue=sigue;
	}
	/**
	 * Detecta la colision
	 * @param r el objeto de rectangulo con quien colisiona
	 * @return booleano para comprobar colision
	 */
	public boolean colision(Rectangle2D r)
	{
		//System.out.println("BloqueGolpeo");
		return this.getBloque().intersects(r);
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
	 */
	public void desaparecer()
	{
		x=x+10000;
	}
	/**
	 * Obtener el objeto rectangulo de el bloque
	 * @return objeto rectangulo
	 */
	public Rectangle2D getBloque()
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
}
