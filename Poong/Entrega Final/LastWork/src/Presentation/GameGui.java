package Presentation;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Aplication.EventoTeclado;
import Aplication.Hilo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
public class GameGui extends JFrame  {
	private  int  ancho,altura;
	private Court cancha;
	private JLabel puntuacion;
	private int counter;
	private int highCounter;
	private JLabel score;
	private JLabel puntuacionMax;
	private JLabel scoreMax;
	private JMenuBar barra;
	private JMenu archivo;
	private JMenu ayuda;
	private JMenuItem nuevo;
	private JMenuItem salir;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem creditos;
	private JMenuItem goMenu;
	private JButton aceptar;
	private JLabel pause;
	private Hilo hilo;
	private String characterP1;
	private String characterP2;
	private String nicknameP1;
	private String nicknameP2;
	private GameGui tablero;
	private int pelotaSeleccionada;
	
	/**
	 * Constructor de GameGui
	 * @param characterP1 personaje jugador 1
	 * @param characterP2 personaje jugador 2
	 * @param nicknameP1 nombre jugador 1
	 * @param nicknameP2 nombre jugador 2
	 * @param pelotaSeleccionada tipo de pelota
	 */
	public GameGui(String characterP1,String characterP2,String nicknameP1,String nicknameP2, int pelotaSeleccionada) 
	{
		counter=0;
		highCounter=0;
		/*add(getbAceptar());*/
		this.characterP1=characterP1;
		this.characterP2=characterP2;
		this.nicknameP1=nicknameP1;
		this.nicknameP2=nicknameP2;
		this.pelotaSeleccionada=pelotaSeleccionada;
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
		addKeyListener(new EventoTeclado());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hilo= new Hilo(cancha);
		hilo.start();
	}
	/**
	 * Prepara los listener de los botones de acciones
	 */
	public void prepareAcciones() {
		
		salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionSalir();
            }
		});
		abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
					accionAbrir();
				} catch (PoongExcepcion e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
            }
		});
		guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
					accionGuardar();
				} catch (PoongExcepcion e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
            }
		});
		nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionNuevo();
            }
		});
	
	}
	/**
	 * Crea un nuevo juego
	 */
	public void accionNuevo() 
	{
		setVisible(false);
		PoongGUI gui= new PoongGUI();
		gui.setVisible(true);
	}
	/**
	 * Sale del juego
	 */
	public void accionSalir() 
	{
		int confirmado = JOptionPane.showConfirmDialog(
	 			   null,
	 			   "¿Esta seguro que desea salir?");

	 			if (JOptionPane.YES_OPTION == confirmado) {
	 			   System.out.println("confirmado");
	             	setVisible(false);
	             	System.exit(0);}
	 			else if ( JOptionPane.NO_OPTION ==confirmado) {
	 				setVisible(true);
	 			    System.out.println("No se elimina nada");
	 			   }
	 			else if (JOptionPane.CANCEL_OPTION ==confirmado) {
	 				setVisible(true);
	 			    System.out.println("se cancela todo");}
	}
	   public void accionAbrir() throws PoongExcepcion 
		{
	    	JFileChooser chooser=new JFileChooser();
			chooser.setVisible(true);
			int accion=chooser.showOpenDialog(this);
			
			if(accion==chooser.APPROVE_OPTION) 
			{
				
				File abre=chooser.getSelectedFile();
				tablero=PoongPersistencia.abrir(abre,this);
				repaint();	
				
			}
			
		}
	   /**
	    * Accion guardar
	    * @throws PoongExcepcion 
	    */
	public void accionGuardar() throws PoongExcepcion
	{
		JFileChooser chooser=new JFileChooser();
		chooser.setVisible(true);
		int accion=chooser.showSaveDialog(this);
		if(accion==chooser.APPROVE_OPTION) 
		{
			File abre=chooser.getSelectedFile();
			PoongPersistencia.salvar(abre,this);
		}
		
	}
	/**
	 * Obtiene el threat del juego
	 * @return
	 */
	public Hilo getHilo() 
	{
		return hilo;
	}
	/**
	 * Prepara los elementos de interfaz del menu
	 */
	public void prepareElementosMenu()
	{
		barra=new JMenuBar();
		archivo=new JMenu("Archivo");
		ayuda=new JMenu("Menu");
		nuevo=new JMenuItem("Nuevo juego");
		salir=new JMenuItem("Salir");
		abrir=new JMenuItem("Abrir");
		guardar=new JMenuItem("Guardar");
		goMenu=new JMenuItem("Ir al menu");
		creditos=new JMenuItem("creditos");
		barra.add(archivo);
		barra.add(ayuda);
		archivo.add(nuevo);
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(salir);
		ayuda.add(goMenu);
		ayuda.add(creditos);
		setJMenuBar(barra);	
	}
	/**
	 * Prepara los elementos de interfaz principal
	 */
	public void prepareElementos() {
		
		setTitle("Poong");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		ancho = screenSize.height * 1 / 2;
		altura = screenSize.width * 1 / 3;
		setSize(new Dimension(ancho+200, altura+250));
		setLocationRelativeTo(null);
		setResizable(false);
		Color myColor1 = new Color(0, 204, 102);
		cancha= new Court(characterP1, characterP2, nicknameP1,nicknameP2,pelotaSeleccionada,this);
		add(cancha);
	}
	/**
	 * prepara el interfaz del pausa
	 */
	  public void preparePause() 
	    {
	    	pause= new JLabel();
			pause.setText("Pause");
			pause.setBounds(280, 300, 250, 50);
			pause.setFont(new java.awt.Font("Tahoma", 1, 50));
			pause.setForeground(new java.awt.Color(0, 0, 0));
			this.add(pause);
	   }
	  /**
	   * Convierte el hilo en nulo
	   */
	  public void nullHilo()
	  {
		  hilo=null;
	  }
	
	/*private JButton getbAceptar() {
		  aceptar = new JButton("Aceptar");
		  aceptar.addKeyListener(this);
		  aceptar.setBounds(10, 10, 100, 20);
		  return aceptar;
		 }*/
}
