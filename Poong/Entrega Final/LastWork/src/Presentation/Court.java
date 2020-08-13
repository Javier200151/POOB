package Presentation;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Aplication.*;

public class Court extends JPanel{

    private BufferedImage image;
	private String ball;
	private String player1;
	private String player2;
	
	private Juego juego;
	private Raqueta raqueta1= new Raqueta(330,70,"1");
	private Raqueta raqueta2= new Raqueta(330,770,"2");
	//Objetivos target1=new Objetivos(125,400);
	//Objetivos target2=new Objetivos(545,400);
	private Bloques blocks;
	private Objetivos target1;
	private Objetivos target2;
	private Pelota pelota;
	private Sorpresa sorpresa;
	private Rectangle2D personaje2;
	private Rectangle2D personaje1;
	private JLabel score;
	private int counter;
	private JLabel puntuacion;
	private JLabel puntuacionMax;
	private int highCounter;
	private JLabel scoreMax;
	private String ImageP1;
	private String ImageP2;
	private Rectangle2D pelotica;
	private JLabel pause;
	private String nicknameP1;
	private String nicknameP2;
	private String sorpresaRute;
	private Rectangle2D sopresita;
	private JLabel energiaP1;
	private JLabel energiaP2;
	private Timer time;
	private int direccionPelota;
	private Generador generarSorpresas;
	private String target;
	private Rectangle2D objetivo1;
	//private GameGui juego;
	private String bloqueDireccion;
	private Rectangle2D bloquesito;
	private Raqueta ultimaRaqueta;
	private JLabel ultimaSopresa;
	private boolean isPaused;
	private GameGui gameGui;
	private Generador tiempoDeFinalizar;
	private Pelota fantasma;
	private Rectangle2D fantasmita;

	/**
	 * Constructor de Court
	 * @param characterP1 personaje jugador 1
	 * @param characterP2 personaje jugador 2
	 * @param nicknameP1 nombre jugador 1
	 * @param nicknameP2 nombre jugador 2
	 * @param pelotaSeleccionada tipo de pelota
	 * @param gameGui clase que pinta tablero
	 */
    public Court(String characterP1,String characterP2,String nicknameP1,String nicknameP2, int pelotaSeleccionada, GameGui gameGui) {  
       try {
    	  this.gameGui=gameGui;
    	  this.setLayout(null);
    	  this.nicknameP1=nicknameP1;
    	  this.nicknameP2=nicknameP2;
    	  raqueta1.setNombre(this.nicknameP1);
    	  raqueta2.setNombre(this.nicknameP2);
    	  ImageP1 = "Imagenes/"+characterP1+"1"+".png";
          ImageP2 = "Imagenes/"+characterP2+"2"+".png";
    	  player1= new String(ImageP1);
    	  player2= new String(ImageP2);
    	  sorpresaRute=new String("Imagenes/caja.png");
    	  target= new String("Imagenes/target2.png");
          image = ImageIO.read(new File("Imagenes/TableroProyecto.jpg"));
          ball=new String("Imagenes/pelota.png");
          bloqueDireccion=new String("Imagenes/Cubo.png");
          juego= new Juego(this,pelota,ball,sorpresa,sorpresaRute,blocks,bloqueDireccion,target1,target2,target,raqueta1,raqueta2,fantasma);
          juego.generarPelota(350,440,pelotaSeleccionada);
          juego.generarFantasma(350,400);
          raqueta1.setImage(player1);
          raqueta2.setImage(player2);
          ultimaRaqueta=raqueta1;
          juego.generarObjetivo(125,400,545,400);
          juego.generarSopresa(350, 30000, 0,true);
          juego.generarBloques(250,20000,true);
          time=new Timer();
          generarSorpresas=new Generador(this,1,null,juego);
          time.schedule(generarSorpresas,10000,10000);
          prepareScore();
          prepareTituloSorpresa();
          prepareEnergia();
          Color myColor1 = new Color(75, 128, 70);
  		  setBackground(myColor1);
  		  isPaused=true;
       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,
        	        600,  800,  100,  100,
        	        0,  0, 700,  1600,
        	       this);
        /*g.drawImage(ball, 450,  505,  190,  230,
    	        -300,  200, 2700,  3500,
    	       this);*/
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.BLACK);
        dibujar(g2);
        actualizar();
    }
    /**
     * Actualiza la ultima sorpresa recogida
     */
    public void actualizarSorpresa()
    {
    	ultimaSopresa.setText(sorpresa.getNombre());
    }
    /**
     * cambia la sorpresa actual
     * @param sorpresa
     */
    public void setSorpresa(Sorpresa sorpresa)
    {
    	this.sorpresa=sorpresa;
    }
    /**
     * cambia la pelota actual
     * @param pelota
     */
    public void setPelota(Pelota pelota)
    {
    	this.pelota=pelota;
    }
    /**
     * cambia el bloque actual
     * @param blocks
     */
    public void setBlocks(Bloques blocks)
    {
    	this.blocks=blocks;
    }
    /**
     * cambia pelota fantasma
     * @param fantasma
     */
    public void setPhantom(Pelota fantasma) 
    {
    	this.fantasma=fantasma;
    }
    /**
     * cambia los targets actuales
     * @param target1
     * @param target2
     */
    public void setTargets(Objetivos target1,Objetivos target2)
    {
    	this.target1=target1;
    	this.target2=target2;
    }
    /**
     * obtiene la ultima raqueta que bateo
     * @return ultima Raqueta Objeto
     */
    public Raqueta getUltimaRaqueta()
    {
    	return ultimaRaqueta;
    }

    /**
     * Pinta en el canvas
     * @param g
     */
    public void dibujar(Graphics2D g) 
    {
        
    	pelotica=pelota.getPelota();
    	Image imagen3=pelota.getImage();
    	g.drawImage(imagen3,(int)pelotica.getX(),(int)pelotica.getY(), this);
    	
    	sopresita=sorpresa.getSorpresa();
    	Image imagen4=sorpresa.getImage();
    	g.drawImage(imagen4,(int)sopresita.getX(),(int)sopresita.getY(), this);
    	
    	personaje1= raqueta1.getRaqueta();
    	Image imagen=raqueta1.getImage();
    	g.drawImage(imagen,(int)personaje1.getX(),(int)personaje1.getY(), this);
    	
    	personaje2= raqueta2.getRaqueta();
    	Image imagen2=raqueta2.getImage();
    	g.drawImage(imagen2,(int)personaje2.getX(),(int)personaje2.getY(), this);
    	
    	objetivo1=target1.getObjetivo();
    	Image imagen5=target1.getImage();
    	g.drawImage(imagen5,(int)target1.getX(),(int)target1.getY(), this);
  
     	objetivo1=target2.getObjetivo();
    	g.drawImage(imagen5,(int)target2.getX(),(int)target2.getY(), this);
    	
    	bloquesito=blocks.getBloque();
    	Image imagen6=blocks.getImage();
    	g.drawImage(imagen6,(int)blocks.getX(),(int)blocks.getY(), this);
    	
    	fantasmita=fantasma.getPelota();
    	Image invisible=fantasma.getImage();
    	g.drawImage(invisible,(int)fantasmita.getX(),(int)fantasmita.getY(), this);
    	
    	/*objetivo1=target3.getObjetivo();
    	g.drawImage(imagen5,(int)target3.getX(),(int)target3.getY(), this);
    	
     	objetivo1=target4.getObjetivo();
    	g.drawImage(imagen5,(int)target4.getX(),(int)target4.getY(), this);*/
    }
    /**
     * Metodo que esta iterando constantemente
     */
	public void actualizar()
    {
    	if(EventoTeclado.pause) 
    	{
    		pausar();
    	}
    	else 
    	{
    		//System.out.println(ultimaRaqueta.getProtegido());
    		pelota.mover(getBounds(),colision(raqueta1.getRaqueta()),colision(raqueta2.getRaqueta()),false);
    		fantasma.mover(getBounds(),phantomColision(raqueta1.getRaqueta()),phantomColision(raqueta2.getRaqueta()),false);
    		juego.activarSorpresa();
        	raqueta1.moverRaqueta1(getBounds());
        	raqueta2.moverRaqueta2(getBounds());
        	//System.out.println(blocks.getX());
        	//System.out.println(blocks.getY());
        	juego.seAcerca();
        	detener();
        	ultimoGolpeador();
        	colisionObjetivo();
        	juego.seAcercaSorpresa();
        	colisionBloque();
    		pause.setVisible(false);
    		if(pelota.cont1()==10||pelota.cont2()==10||raqueta1.muerte1()||raqueta2.muerte1()) 
    		{
    			
    			fin();  				
    		}
    	}   	
    }
    
	/**
	 * obtiene direccion de la pelota
	 * @return int direccion
	 */
    public int getDireccionPelota()
    {
    	return direccionPelota;
    }
    /**
     * Colision con objetivos
     */
    public void colisionObjetivo() 
    {
    	if(colision(target1.getObjetivo())) 
    	{
    		Random random = new Random();
    		int x=random.nextInt(5);
    		if (x<1)
    		{
    			x=x+1;
    		}
    		pelota.setCounter1(x);
    		target1.desaparecer();
    	}
    	if(colision(target2.getObjetivo())) 
    	{
    		Random random = new Random();
    		int x=random.nextInt(5);
    		if (x<1)
    		{
    			x=x+1;
    		}
    		pelota.setCounter2(x);
    		target2.desaparecer();
    	}
    }
    
    /**
     * Colision con un bloque
     */
    public void colisionBloque() 
    {
    	
	    	if(colision(blocks.getBloque())) 
	    	{	
	    		if(!ultimaRaqueta.getProtegido())
	        	{
	    			System.out.println("QuitóEnergia");
		    		raqueta2.setEnergia2(-4000);
		    		blocks.desaparecer();
	        	}else
	        	{
	        		blocks.desaparecer();
	        		ultimaRaqueta.setProtegido(false);
	        		System.out.println("NoTieneESCUDO");
	        	}
	    	}
	    	if(colision(blocks.getBloque())) 
	    	{
	    		if(!ultimaRaqueta.getProtegido())
	        	{
	    			System.out.println("QuitóEnergia");
		    		raqueta1.setEnergia1(-4000);
		    		blocks.desaparecer();
	        	}else
	        	{
	        		blocks.desaparecer();
	        		ultimaRaqueta.setProtegido(false);
	        		System.out.println("NoTieneESCUDO");
	        	}
	    	}
    }
    /**
     * actualiza el ultimo bateador
     */
    public void ultimoGolpeador()
    {
    	if(colision(raqueta1.getRaqueta()))
    	{
    		//System.out.println("raqueta1");
    		ultimaRaqueta=raqueta1;
    		direccionPelota=-1;
    	}else if(colision(raqueta2.getRaqueta()))
    	{
    		//System.out.println("raqueta2");
    		ultimaRaqueta=raqueta2;
    		direccionPelota=1;
    	}
    }
    /**
     * actualiza los puntajes
     */
    public void detener() 
    {
    	energiaP1.setText(String.valueOf(raqueta1.getEnergia1()/100));
    	energiaP2.setText(String.valueOf(raqueta2.getEnergia2()/100));
    	if(pelota.cont1()<=10) 
    	{
    		score.setText(String.valueOf(pelota.cont1()));
    	}
    	if(pelota.cont2()<=10) 
    	{
    		scoreMax.setText(String.valueOf(pelota.cont2()));
    	}
    }
    /**
     * threat de la cancha
     */
    public void iterarJuego() 
    {
    	while(true) 
    	{
    		try 
			{
    			repaint();
				Thread.sleep(5);
			}catch(InterruptedException ex) 
			{
				Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE,null,ex);
			}
    	}
    }
    /**
     * Colision de la pelota
     * @param rectangle con quien choca
     * @return booleano que indica colision
     */
    private boolean colision(Rectangle2D r) 
    {
    	return pelota.getPelota().intersects(r);
    }
    /**
     * Colision de la pelota phantom
     * @param rectangle con quien choca
     * @return booleano que indica colision
     */
    private boolean phantomColision(Rectangle2D r) 
    {
    	return fantasma.getPelota().intersects(r);
    } 
    /**
     * Crea los elementos de la interfaz de energia
     */
    public void prepareEnergia()
    {
		energiaP1= new JLabel();
		energiaP1.setText(String.valueOf(raqueta1.getEnergia1()));
		energiaP1.setBounds(30, 100, 150, 50);
		energiaP1.setFont(new java.awt.Font("Tahoma", 1, 30));
		energiaP1.setForeground(new java.awt.Color(255, 255, 255));
		
		energiaP2= new JLabel();
		energiaP2.setText(String.valueOf(raqueta2.getEnergia2()));
		energiaP2.setBounds(30, 700, 150, 50);
		energiaP2.setFont(new java.awt.Font("Tahoma", 1, 30));
		energiaP2.setForeground(new java.awt.Color(255, 255, 255));	
		add(energiaP1);
		add(energiaP2);
    }
    /**
     * Crea los elementos del interfaz de la ultima sorpresa tomada
     */
    public void prepareTituloSorpresa()
    {
		ultimaSopresa= new JLabel();
		ultimaSopresa.setText("");
		ultimaSopresa.setBounds(20, 400, 150, 50);
		ultimaSopresa.setFont(new java.awt.Font("Tahoma", 1, 20));
		ultimaSopresa.setForeground(new java.awt.Color(255, 255, 255));	
		add(ultimaSopresa);

    }
    /**
     * Crea los elementos del interfaz de los puntajes
     */
    public void prepareScore() 
    {
    	puntuacion= new JLabel();
    	puntuacion.setText(nicknameP1);
		puntuacion.setBounds(120, 20, 250, 50);
		puntuacion.setFont(new java.awt.Font("Tahoma", 1, 30));
		puntuacion.setForeground(new java.awt.Color(255, 255, 255));
    	score= new JLabel();
		score.setText(String.valueOf(pelota.cont1()));
		score.setBounds(330, 20, 150, 50);
		score.setFont(new java.awt.Font("Tahoma", 1, 30));
		score.setForeground(new java.awt.Color(255, 255, 255));
		puntuacionMax= new JLabel();
		puntuacionMax.setText(nicknameP2);
		puntuacionMax.setBounds(410, 20, 250, 50);
		puntuacionMax.setFont(new java.awt.Font("Tahoma", 1, 30));
		puntuacionMax.setForeground(new java.awt.Color(255, 255, 255));
		scoreMax= new JLabel();
		scoreMax.setText(String.valueOf(pelota.cont2()));
		scoreMax.setBounds(370, 20, 150, 50);
		scoreMax.setFont(new java.awt.Font("Tahoma", 1, 30));
		scoreMax.setForeground(new java.awt.Color(255, 255, 255));
		pause= new JLabel();
    	pause.setText("Paused");
    	pause.setBounds(310, 440, 150, 50);
    	pause.setFont(new java.awt.Font("Tahoma", 1, 30));
    	pause.setForeground(new java.awt.Color(0, 0, 0));
		add(puntuacion);
		add(score);
		add(scoreMax);
		add(puntuacionMax);
		add(pause);
    }
    /**
     * hace visible el interfaz de pause
     */
    public void pausar()
    {
    		//preparePause();
    		pause.setVisible(true);
    		//pelota.mover(getBounds(),colision(raqueta1.getRaqueta()),colision(raqueta2.getRaqueta()),true);		
    }
    /**
     * Finaliza el juego
     */
    public void fin() 
    {
    		gameGui.nullHilo();
    		tiempoDeFinalizar=new Generador(this,3,null,null);
    		pause.setBounds(270, 430, 400, 50);
    		pause.setText("Ganador "+ultimaRaqueta.getNombre());
    		pause.setVisible(true);
    		EventoTeclado.pause=true;
    		time.schedule(tiempoDeFinalizar,3000,1000000000);
   
    }
    /**
     * Descongela las raquetas
     */
    public void descongelar() {
		raqueta1.setVelocidad(2);
		raqueta2.setVelocidad(2);
		pelota.setImage(ball);
	}

    /**
     * Termina la aplicacion
     */
	public void volverMenu() {
		System.exit(0);
	}
    
  
}