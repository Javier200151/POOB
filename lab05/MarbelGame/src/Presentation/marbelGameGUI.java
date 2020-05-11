package Presentation;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Aplication.MarbelGame;

public class marbelGameGUI extends JFrame {
	public static int alto;
	public static int ancho;
	public static int panelAlto;
	public static int panelAncho;
	public static int n;
	public Color color=Color.white;
	private JMenuBar barra;
	private JMenu archivo;
	private JMenu ayuda;
	private JMenuItem nuevo;
	private JMenuItem salir;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem Acercade;
	private JMenuItem Acercade2;
	private Rectangle rect;
	private JPanel juego;
	private JPanel tablero;
	private JPanel controles;
	private JButton arriba;
	private JButton abajo;
	private JButton derecha;
	private JButton izquierda;
	private JColorChooser newColor;
	private JButton botonReinicio;
	private JPanel opciones;
	private JButton botonMenu;
	private JPanel movimientos;
	private JLabel buenMove;
	private JLabel malMove;
	private JLabel buenNum;
	private int cont;
	private int cont2;
	private JLabel malNum;
	private JLabel perfectNum;
	private JLabel perfectMove;
	private int res;
	private static MarbelGame mg;

	/**
	 * Constructor de marbelGameGUI
	 * @param LONGITUD entero, tamaño del tablero cuadrado
	 * @param numHuecos entero, numero de huecos y fichas en el tablero
	 * @param numBarreras entero, numero de barreras en el tablero
	 * @param color Color, color del tablero
	 */
	public marbelGameGUI(int n, int numHuecos, int numBarreras, Color color)
	{
		this.n=n;
		mg = new MarbelGame(n,numHuecos,numBarreras);
		setVisible(true);
		cont=0;
		cont2=0;
		this.color=color;
		
		prepareElementos();
		prepareAcciones();
	}

	/*public static void main(String[] args) 
	{
		mg = new MarbelGame(n);
		marbelGameGUI gui= new marbelGameGUI(mg);
		gui.setVisible(true);
	}*/
	private void prepareElementos() 
	{
		setTitle(" Marbel Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		alto = screenSize.height * 1 / 2;
		ancho = screenSize.width * 1 / 2;
		setSize(new Dimension(ancho, alto));
		setLocationRelativeTo(null);
		setLayout(null);
		prepareElementosTablero();
		prepareElementosMenu();
	}
	private void prepareElementosTablero()
	{
		this.getContentPane().setBackground(Color.black);
		res=mg.getCounter();
		juego = new JPanel();
		juego.setBackground(Color.black);
		juego.setBounds(400, 0, (n*80)+22, (n*80)+35);
		juego.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new TitledBorder("Juego")));
		juego.setLayout(new BorderLayout());
		tablero = new TableroDibujo(color, n, mg);
		juego.add(tablero, BorderLayout.CENTER);
		add(juego);
		controles = new JPanel();
		controles.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new TitledBorder("Controles")));
		controles.setBounds(250, 0, 150,300);
		controles.setLayout(null);
		controles.setBackground(Color.black);
		movimientos= new JPanel();
		movimientos.setBackground(new Color(255,116,0));
		movimientos.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new TitledBorder("Movimientos")));
		movimientos.setBounds(100, 300, 300,150);
		movimientos.setLayout(null);
		buenMove= new JLabel();
		buenMove.setText("Movimientos totales");
		buenMove.setBackground(Color.orange);
		buenMove.setBounds(25, 20, 150, 50);
		buenNum= new JLabel();
		buenNum.setText(String.valueOf(cont));
		buenNum.setBounds(200, 20, 150, 50);
		malNum= new JLabel();
		malNum.setText(String.valueOf(cont2));
		malNum.setBounds(200, 60, 150, 50);
		malMove= new JLabel();
		malMove.setText("Malos movimientos");
		malMove.setBounds(25, 60, 150, 50);
		perfectNum= new JLabel();
		perfectNum.setText(String.valueOf(cont2));
		perfectNum.setBounds(200, 100, 150, 50);
		perfectMove= new JLabel();
		perfectMove.setText("Buenos  movimientos");
		perfectMove.setBounds(25, 100, 150, 50);
		movimientos.add(buenMove);
		movimientos.add(buenNum);
		movimientos.add(malMove);
		movimientos.add(malNum);
		movimientos.add(perfectMove);
		movimientos.add(perfectNum);
		add(movimientos);
		arriba= new JButton("Arriba");
		abajo= new JButton("Abajo");
		izquierda= new JButton("Izquierda");
		derecha= new JButton("Derecha");
		arriba.setBounds(25, 40, 100, 50);
		arriba.setBackground(new Color(255,116,0));
		abajo.setBounds(25, 100, 100, 50);
		abajo.setBackground(new Color(255,116,0));
		izquierda.setBounds(25, 160, 100, 50);
		izquierda.setBackground(new Color(255,116,0));
		derecha.setBounds(25, 220, 100, 50);
		derecha.setBackground(new Color(255,116,0));
		controles.add(arriba);
		opciones= new JPanel();
		opciones.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new TitledBorder("Opciones")));
		opciones.setBounds(100,0, 150,300);
		opciones.setLayout(null);
		opciones.setBackground(Color.black);
		botonReinicio= new JButton("Reiniciar");
		botonReinicio.setBounds(25,80, 100, 50);
		botonReinicio.setBackground(new Color(255,116,0));
		botonMenu=new JButton("Menu");
		botonMenu.setBackground(new Color(255,116,0));
		botonMenu.setBounds(25,160, 100, 50);;
		opciones.add(botonReinicio);	
		opciones.add(botonMenu);
		add(opciones);
		botonReinicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionReiniciar();
            }
		});
		botonMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionMenu();
            }
		});
		arriba.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionArriba();
            	
            }
		});
		controles.add(abajo);
		abajo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionAbajo();
            }
		});
		controles.add(izquierda);
		izquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionIzquierda();
            }
		});
		controles.add(derecha);
		derecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionDerecha();
            }
		});
		add(controles);
	}
	private void refresque()
	{
		tablero.repaint();
	}
	private void accionArriba()
	{
		mg.mueveArriba();
		int res=mg.getCounter();
		refresque();
		cont++;
		buenNum.setText(String.valueOf(cont));
		perfectNum.setText(String.valueOf(res));
	}
	private void accionAbajo()
	{
		mg.mueveAbajo();
		int res=mg.getCounter();
		refresque();
		cont++;
		buenNum.setText(String.valueOf(cont));
		perfectNum.setText(String.valueOf(res));
		
	}
	private void accionIzquierda()
	{
		mg.mueveIzquierda();
		int res=mg.getCounter();
		refresque();
		cont++;
		buenNum.setText(String.valueOf(cont));
		perfectNum.setText(String.valueOf(res));
	}
	private void accionDerecha()
	{
		mg.mueveDerecha();
		refresque();
		int res=mg.getCounter();
		cont++;
		buenNum.setText(String.valueOf(cont));
		perfectNum.setText(String.valueOf(res));
	}
	private void accionReiniciar() 
	{
		mg.reiniciar();
		int res=mg.getCounter();
		refresque();
		cont=0;
		cont2=0;
		buenNum.setText(String.valueOf(cont));
		perfectNum.setText(String.valueOf(res));			
	}
	private void accionMenu() 
	{
		setVisible(false);
		ConfiguracionGUI gui= new ConfiguracionGUI();
		gui.setVisible(true);
	}
	
	private void prepareElementosMenu()
	{
		barra=new JMenuBar();
		archivo=new JMenu("Archivo");
		ayuda=new JMenu("Configuracion");
		nuevo=new JMenuItem("Nuevo");
		salir=new JMenuItem("Salir");
		abrir=new JMenuItem("Abrir");
		guardar=new JMenuItem("Guardar");
		Acercade=new JMenuItem("Configuracion inicial");
		Acercade2=new JMenuItem("Configuracion del tablero");
		barra.add(archivo);
		barra.add(ayuda);
		archivo.add(nuevo);
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(salir);
		ayuda.add(Acercade);
		ayuda.add(Acercade2);
		setJMenuBar(barra);
	}

	private void accionSalir() 
	{
		int confirmado = JOptionPane.showConfirmDialog(
 			   null,
 			   "¿Esta seguro que desea salir?");

			System.out.println(confirmado);
 			if (JOptionPane.YES_OPTION == confirmado) {
 			   //System.out.println("confirmado");
             	setVisible(false);
             	System.exit(0);}
 			/*else if ( JOptionPane.NO_OPTION ==confirmado) {
 				setVisible(true);
 			    //System.out.println("No se elimina nada");
 			   }
 			else if (JOptionPane.CANCEL_OPTION ==confirmado) {
 				setVisible(true);
 			    //System.out.println("se cancela todo");
 				}*/
	}
	private void  accionAbrir() 
	{
		JFileChooser file=new JFileChooser();
		int accion=file.showOpenDialog(this);
		if(accion==file.APPROVE_OPTION) 
		{
			File abre=file.getSelectedFile();
			JOptionPane.showMessageDialog(null, "El archivo con el nombre"+ abre +" no se puede abrir pro que el metodo se encuentra en construccion.","Ojo con eso", JOptionPane.ERROR_MESSAGE);

		}
				
	}
	private void accionGuardar() 
	{
		JFileChooser file=new JFileChooser();
		int accion=file.showSaveDialog(this);
		if(accion==file.APPROVE_OPTION) 
		{
			File abre=file.getSelectedFile();
			JOptionPane.showMessageDialog(null, "El archivo con el nombre"+ abre +" no se puede guardar por que el metodo se encuentra en construccion.","Ojo con eso", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void prepareAcciones() 
	{
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
            	int confirmado = JOptionPane.showConfirmDialog(
            			   null,
            			   "¿Esta seguro que desea salir?");

            			if (JOptionPane.YES_OPTION == confirmado) {
            			   System.out.println("confirmado");
                        	setVisible(false);
                        	System.exit(0);}
            			/*else if ( JOptionPane.NO_OPTION ==confirmado) {
            				setVisible(true);
            			    System.out.println("No se elimina nada");
            			   }
            			else if (JOptionPane.CANCEL_OPTION ==confirmado) {
            				setVisible(true);
            			    System.out.println("se cancela todo");
            			}*/
            }
        });
		
		salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionSalir();
            }
		});
		abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	JFileChooser fc=new JFileChooser();
            	int seleccion=fc.showOpenDialog(null);
            	if(seleccion==JFileChooser.APPROVE_OPTION)
            	{
            		String nombre=fc.getSelectedFile().getPath();
            		FileReader f;
            		try 
            		{
            			f=new FileReader(nombre);
            			BufferedReader b =new BufferedReader(f);
            			String cadena=b.readLine();
            			while(cadena!=null)
            			{
            				setVisible(false);
            				MarbelGame mg = new MarbelGame(cadena);
            				tablero.repaint();
            				cadena=b.readLine();
            			}
            		}
            		catch(Exception a)
            		{
            				a.printStackTrace();
            		}
            	}
            }
		});
		guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	JFileChooser fc=new JFileChooser();
            	int seleccion=fc.showSaveDialog(null);
            	if(seleccion==JFileChooser.APPROVE_OPTION)
            	{
            		File fichero=fc.getSelectedFile();
            		
            		try(FileWriter fw=new FileWriter(fichero))
            		{
            			fw.write(mg.cadenaAGuardar());
            		}catch (IOException el)
            		{
            			el.printStackTrace();
            		}
            	}
            }
		});
	}
}

class TableroDibujo extends JPanel
{
    public static int TAMANO=80;
    private int longitud;
    private Graphics g;
    private MarbelGame marbel;

    public TableroDibujo(Color color, int longitud, MarbelGame marbel) 
    {
        setBackground(color);
        setPreferredSize(new Dimension(80,80));
        this.marbel=marbel;
        this.longitud=longitud;
        setVisible(true);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        for (int f=0;f<=longitud;f++)
        {
            g.drawLine(f*TAMANO,0,f*TAMANO,longitud*TAMANO);
        }
        for (int c=0;c<=longitud;c++)
        {
            g.drawLine(0,c*TAMANO,longitud*TAMANO,c*TAMANO);		
        }
        for (int f=0;f<marbel.getLongitud();f++){
            for(int c=0;c<marbel.getLongitud();c++){
                if (marbel.getMarbel(f,c)!=0)
                {
                	g.setColor(marbel.getJBalvin(f,c));
                	if(marbel.getMarbel(f,c)==1)
                	{
                		g.fillOval(10+(80*c), 10+(80*f), 60, 60);
                	}else if(marbel.getMarbel(f,c)==2)
                	{
                		g.drawOval(5+(80*c), 5+(80*f), 70, 70);
                	}else if(marbel.getMarbel(f,c)==-1)
                	{
                		g.fillRect(80*c, 80*f, 80, 80);
                	}
                	else if(marbel.getMarbel(f,c)==3)
                	{
                		g.drawOval(5+(80*c), 5+(80*f), 70, 70);
                		g.fillOval(10+(80*c), 10+(80*f), 60, 60);
                	}
                }
            }
        }
        //refresque();  
    }

    public void refresque()
    {
    	//Huecos
    	g.setColor(Color.blue);
    	g.drawOval(10, 170, 60, 60);
    	g.setColor(Color.orange);
    	g.drawOval(250, 170, 60, 60);
    	g.setColor(Color.green);
    	g.drawOval(90, 250, 60, 60);
    	//Rellenas
    	g.setColor(Color.blue);
    	g.fillOval(10, 90, 60, 60);
    	g.setColor(Color.orange);
    	g.fillOval(90, 10, 60, 60);
    	g.setColor(Color.green);
    	g.fillOval(170, 90, 60, 60);
    	//Bloque
    	g.setColor(Color.black);
    	g.fillRect(80, 80, 80, 80);  	
    }   
}