package Aplication;

import java.awt.Rectangle;

public class PerfectBall extends Pelota{
	private double speedx;
	
	/**
	 * Constructor de FlashBall
	 * @param x coordenada eje horizontal
	 * @param y coordenada eje vertical
	 * @param juego clase principal de Aplication
	 */
	public PerfectBall(double x,double y, Juego juego) 
	{
		super(x,y, juego);
		//dx=0.5;
		//dy=0.5;
		speedx=0.001;		
	}
	@Override
	public void mover(Rectangle limites,boolean raqueta1,boolean raqueta2,boolean pausado) 
	{
		
		if(dx<2.000000000|| dx>-2.0000000000000) 
		{
			if(dx>0) 
			{
				dx+=speedx;
			}
			else if(dx<0) 
			{
				dx-=speedx;
			}
			if(dy>0) 
			{
				dy+=speedx;
			}
			else if(dy<0) 
			{
				dy-=speedx;
			}
		}
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
			dx=0.5;
			dy=0.5;
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
			dx=0.5;
			dy=0.5;
		}
		
		if(x<=120) 
		{
			dx=-dx;

		}
		
	}
	public void setdx(double multx) 
	{
		dx=dx*multx;
	}
	public void setdy(double multy) 
	{
		dy=dy*multy;
	}
}
