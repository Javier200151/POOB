package Aplication;

import java.awt.Rectangle;

public class Phantom extends Pelota{
	
	/**
	 * Constructor de Phantom
	 * @param x coordenada eje horizontal
	 * @param y coordenada eje vertical
	 * @param juego clase principal de Aplication
	 */
	public Phantom(double x,double y, Juego juego) 
	{
		super(x,y, juego);
		dx=0.000000000000000001;
		dy=0.000000000000000001;
	}
	@Override
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
			x=10000;
			y=440;
			//counter1++;
		}
		if(x>=580)
		{
			dx=-dx;
			
		}
		if(y<100) 
		{
			x=10000;
			y=440;
			//counter2++;
		}
		
		if(x<=120) 
		{
			dx=-dx;	
		}
		
	}
	@Override
	protected void setdx(double i) {
		// TODO Auto-generated method stub
		dx=i;
	}
	@Override
	protected void setdy(double i) {
		// TODO Auto-generated method stub
		dy=i;
	}
	@Override
	public void setX(double i) 
	{
		x=i;
	}
	@Override
	public void setY(double i) 
	{
		y=i;
	}
}