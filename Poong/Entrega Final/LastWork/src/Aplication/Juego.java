package Aplication;

import Presentation.Court;

public class Juego {
	
	private Pelota pelota;
	private String ball;
	private Sorpresa sorpresa;
	private String sorpresaRute;
	private Court court;
	private Bloques blocks;
	private String bloqueDireccion;
	private Objetivos target2;
	private Objetivos target1;
	private String target;
	public Raqueta raqueta1;
	public Raqueta raqueta2;
	private Pelota fantasma;

	/**
	 * Constructor de juego
	 * @param court clase principal de Presentation
	 * @param pelota objeto
	 * @param ball direccion de imagen de la pelota
	 * @param sorpresa objeto
	 * @param sorpresaRute direccion de imagen de los sorpresa
	 * @param blocks objeto bloque
	 * @param bloqueDireccion direccion de imagen de los bloques
	 * @param target1 objeto
	 * @param target2 objeto
	 * @param target direccion de imagen de los target
	 * @param raqueta1 objeto del jugador 1
	 * @param raqueta2 objeto del jugador 2
	 * @param fantasma pelota fanstama
	 */
	public Juego(Court court, Pelota pelota, String ball, Sorpresa sorpresa, String sorpresaRute, Bloques blocks, String bloqueDireccion, Objetivos target1, Objetivos target2, String target, Raqueta raqueta1, Raqueta raqueta2,Pelota fantasma)
	{
		this.court=court;
		this.pelota=pelota;
		this.ball=ball;
		this.sorpresa=sorpresa;
		this.sorpresaRute=sorpresaRute;		
		this.blocks=blocks;
		this.bloqueDireccion=bloqueDireccion;
		this.target1=target1;
		this.target2=target2;
		this.target=target;
		this.raqueta1=raqueta1;
		this.raqueta2=raqueta2;
		this.fantasma=fantasma;
	}
	
	/**
     * generador de pelota dependiendo el tipo
     * @param x coordenada horizontal
     * @param y coordenada vertical
     * @param tipo int que representa el tipo de pelota
     */
    public void generarPelota(int x,int y,int tipo) 
    {
    	if(tipo==0) 
    	{
    		System.out.println("slow ball");
    		pelota= new SlowBall(x,y,this);
    	}
    	else if(tipo==1) 
    	{
    		System.out.println("flash ball");
    		pelota=new FlashBall(x,y,this);
    	}
    	else if(tipo==2) 
    	{
    		System.out.println("perfect ball");
    		pelota=new PerfectBall(x,y,this);
    	}
    	pelota.setImage(ball);
    	court.setPelota(pelota);
    }
    /**
     * generador de pelota fantasma
     * @param x coordenada horizontal
     * @param y coordenada vertical
     */
    public void generarFantasma(int x,int y)
    {
    	System.out.println("Phantom ball");
    	fantasma=new Phantom(x,y,this);
    	fantasma.setImage(null);
    	court.setPhantom(fantasma);
    }
    /**
     * generador de pelota dependiendo el tipo
     * @param x coordenada horizontal
     * @param y coordenada vertical
     * @param tipo int que representa el tipo de pelota
     * @param sigue booleano que indica si sigue la pelota
     */
    public void generarSopresa(int x, int y, int tipo, boolean sigue)
    {
    	if(tipo==2)
    	{
    		//System.out.println("SpawneoFreeze");
			sorpresa= new Freeze(x,y,this,sigue,court);
    	}else if(tipo==1)
    	{
    		//System.out.println("SpawneoEnergy");
			sorpresa= new Energy(x,y,this,sigue,court);
    	}
    	else if(tipo==0)
    	{
    		//System.out.println("SpawneFastball");
    		sorpresa= new Fastball(x,y,this,sigue,court);
    	}else if(tipo==3)
    	{
    		//System.out.println("SpawneTurtle");
    		sorpresa= new Turtle(x,y,this,sigue,court);
    	}else if(tipo==4) 
    	{
    		//System.out.println("SpawneFlash");
    		sorpresa= new Davila(x,y,this,sigue,court);
    	}
    	else if(tipo==5) 
    	{
    		//System.out.println("SpawneEscudo");
    		sorpresa= new Escudo(x,y,this,sigue,court);
    	}
    	else if(tipo==6) 
    	{
    		//System.out.println("SpawneEscudo");
    		sorpresa= new ColdRacket(x,y,this,sigue,court);
    	}
    	else if(tipo==7) 
    	{
    		sorpresa=new PhantomRocket(x,y,this,sigue,court);
    	}
    	sorpresa.setImage(sorpresaRute);
    	court.setSorpresa(sorpresa);
    }
    /**
     * generador de bloques
     * @param x coordenada horizontal
     * @param y coordenada vertical
     * @param sigue booleano que indica si sigue la pelota
     */
    public void generarBloques(int x,int y, boolean sigue) 
    {
    	blocks=new Bloques(x,y,sigue);
    	blocks.setImage(bloqueDireccion);
    	court.setBlocks(blocks);
    }
    /**
     * 
     * @param x1 int coordenada de objetivo 1
     * @param y1 int coordenada de objetivo 1
     * @param x2 int coordenada de objetivo 2
     * @param y2 int coordenada de objetivo 2
     */
    public void generarObjetivo(int x1,int y1,int x2,int y2) 
    {
    	target1=new Objetivos(x1,y1);
    	target2=new Objetivos(x2,y2);
    	target1.setImage(target);
    	target2.setImage(target);
    	court.setTargets(target1,target2);
    }
    /**
     * Detecta si la pelota se acerca a un bloque
     */
    public void seAcerca()
    {
		if(pelota.getX()-blocks.getX()<150 && pelota.getY()-blocks.getY()<150)
		{
			blocks.acercar(pelota.getX(),pelota.getY());
		}
	}
    /**
     * Detecta si la pelota se acerca a una sorpresa
     */
    public void seAcercaSorpresa()
    {
		if(pelota.getX()-sorpresa.getX()<150 && pelota.getY()-sorpresa.getY()<150)
		{
			sorpresa.acercar(pelota.getX(),pelota.getY());
		}
	}
    /**
     * Activa la accion de la sorpresa al colisionar
     */
	public void activarSorpresa()
    {
    	if(sorpresa.colision(pelota.getPelota()))
    	{
    		//System.out.println("Colision");
    		if(court.getDireccionPelota()==-1)
    		{
    			sorpresa.accionSorpresa(raqueta1,raqueta2,pelota,-1,court.getUltimaRaqueta(),fantasma);
    		}else if(court.getDireccionPelota()==1)
    		{
    			sorpresa.accionSorpresa(raqueta1,raqueta2,pelota,1,court.getUltimaRaqueta(),fantasma);
    		}
    		sorpresa.desaparecer(court);
    	}	
    }
}
