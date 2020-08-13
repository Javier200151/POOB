package Aplication;

import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Objetivos {
	private double x;
	private double y;
	private int dx;
	private int dy;
	private int ANCHO=45,ALTO=45;
	private ImageIcon image;
	protected Raqueta raqueta;
	protected Pelota pelota;

	/**
	 * Constructor de Raqueta
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 */
	public Objetivos(double x,double y)
	{
		this.x=x;
		this.y=y;
		
	}
	/**
	 * detecta colision 
	 * @param r rectangle con quien colisona
	 * @return booleano que indica si hubo colision
	 */
	public boolean colision(Rectangle2D r)
	{
		return this.getObjetivo().intersects(r);
	}
	/**
	 * Desplaza el objeto por fuera del canvas
	 */
	public void desaparecer()
	{
		x=x+1000;
	}
	/**
	 * Obtiene el rectangulo del objetivo
	 * @return rectangle2D
	 */
	public Rectangle2D getObjetivo()
	{
		return new Rectangle2D.Double(x,y,ANCHO,ALTO);
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
	 * obtiene la imagen al objeto
	 * @return imagen del objeto
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
}

