package Aplication;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

public class Raqueta {
	private int x,y;
	private final int ANCHO=80,ALTO=70;
	private ImageIcon image;
	private int energia1;
	private int energia2;
	private int velocidad;
	private boolean muerte1;
	private boolean protegido;
	private String nombre;
	
	/**
	 * Constructor de Raqueta
	 * @param x int, coordenada en el eje x
	 * @param y int, coordenada en el eje y
	 * @param nombre string, nombre de la raqueta
	 */
	public Raqueta(int x,int y,String nombre) 
	{
		this.x=x;
		this.y=y;
		energia1=10000;
		energia2=10000;
		velocidad=2;
		protegido=false;
	}
	/**
	 * obtiene la velocidad de la raqueta
	 * @return int velocidad
	 */
	public int getVelocidad()
	{
		return velocidad;
	}
	/**
	 * cambia la velocidad de la raqueta
	 * param int velocidad
	 */
	public void setVelocidad(int velocidad)
	{
		this.velocidad=velocidad;
	}
	/**
	 * obtiene el Rectangle2D de la raqueta
	 * @return Rectangle2D objeto
	 */
	public Rectangle2D getRaqueta()
	{
		return new Rectangle2D.Double(x,y,ANCHO,ALTO);
	}
	/**
	 * Mueve la raqueta sin salirse los limites
	 * @param limites del rectangle
	 */
	public void moverRaqueta1(Rectangle limites) 
	{
		if(EventoTeclado.a && x>120 ) 
		{
			x=x-velocidad;
			energia1-=0.5;
		}
		if(EventoTeclado.d && x<540) 
		{
			x=x+velocidad;
			energia1-=0.5;			
		}		
	}
	/**
	 * Mueve la raqueta sin salirse los limites
	 * @param limites del rectangle
	 */
	public void moverRaqueta2(Rectangle limites) 
	{
		if(EventoTeclado.left && x>120 ) 
		{
			x=x-velocidad;
			energia2-=0.5;
		}
		if(EventoTeclado.right && x<540) 
		{
			x=x+velocidad;
			energia2-=0.5;		
		}
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
	public int getX() 
	{
		return x;
	}
	/**
	 * retorna pocion y del bloque
	 * @return y int coordenada
	 */
	public int getY() 
	{
		return y;
	}
	/**
	 * obtiene la energia1
	 * @return int energia
	 */
	public int getEnergia1()
	{
		return energia1;
	}
	/**
	 * obtiene la energia2
	 * @return int energia
	 */
	public int getEnergia2()
	{
		return energia2;
	}
	/**
	 * cambia la energia1
	 * @param s int que se sumara a la energia actual
	 */
	public void setEnergia1(int s)
	{
		energia1=energia1+s;
	}
	/**
	 * cambia la energia1
	 * @param s int que se sumara a la energia actual
	 */
	public void setEnergia2(int s)
	{
		energia2=energia2+s;
	}
	/**
	 * detecta la muerte por energia
	 * @return booleano que indica si muere
	 */
	public boolean muerte1() 
	{
		if(energia1<=2000||energia2<=2000) 
		{
			muerte1=true;
		}
		return muerte1;
	}
	/**
	 * cambia el booleano para saber si esta protegido
	 * @param isProtected indica proteccion
	 */
	public void setProtegido(boolean isProtected)
	{
		protegido=isProtected;
	}
	/**
	 * obtiene el booleano para saber si esta protegido
	 * @return isProtected indica proteccion
	 */
	public boolean getProtegido()
	{
		return protegido;
	}
	/**
	 * Obtiene el nombre de la raqueta
	 * @return String nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Cmabia el nombre
	 * @param nickname a reemplazar por el nombre
	 */
	public void setNombre(String nickname) {
		nombre=nickname;
	}
}
