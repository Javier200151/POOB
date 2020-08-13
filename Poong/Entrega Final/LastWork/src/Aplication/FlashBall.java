package Aplication;

import java.awt.Rectangle;

public class FlashBall extends Pelota{
	private String ball;
	
	/**
	 * Constructor de FlashBall
	 * @param x coordenada eje horizontal
	 * @param y coordenada eje vertical
	 * @param juego clase principal de Aplication
	 */
	public FlashBall(double x,double y, Juego juego) 
	{
		super(x,y, juego);
		dx=2.0;
		dy=2.0;
		velocidadFlash();		
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
				velocidadFlash();
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
				velocidadFlash();
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
			//this.setImage(ball);
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
			//this.setImage(ball);
			counter2++;
		}
		
		if(x<=120) 
		{
			dx=-dx;	
		}
		
	}
	@Override
	protected void setdx(double i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setdy(double i) {
		// TODO Auto-generated method stub
		
	}
}

