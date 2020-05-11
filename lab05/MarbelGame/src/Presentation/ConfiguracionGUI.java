package Presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Aplication.MarbelGame;

public class ConfiguracionGUI extends JFrame
{
	public static int alto;
	public static int ancho;
	public static int n;
	public Color newColor=Color.white;
	public JColorChooser color;
	private JMenuBar barra;
	private JMenu archivo;
	private JMenu ayuda;
	private JMenuItem nuevo;
	private JMenuItem salir;
	private JMenuItem abrir;
	private JMenuItem Acercade;
	private JMenuItem Acercade2;
	private JTextField tamaño;
	private JPanel configuracion;
	private JTextField barreras;
	private JTextField huecos;
	private JButton guardar;
	private int numHuecos;
	private int numBarreras;
	private JButton cambiarColor;
	private JFrame ventana;
	private JButton jugar;
	private Title titulo;
	private TituloConfiguracion tituloConfig;
	private boolean yaFueGuardado;
	/**
	 * Constructor en ConfiguracionGUI
	 */
	public ConfiguracionGUI()
	{
		yaFueGuardado=false;
		prepareElementos();
		prepareAcciones();
	}
	public static void main(String[] args) 
	{
		
		ConfiguracionGUI gui= new ConfiguracionGUI();
		gui.setVisible(true);
	}
	private void prepareElementos() 
	{
		setTitle(" Marbel Game");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		alto = screenSize.height * 1 / 2;
		ancho = screenSize.width * 1 / 2;
		setSize(new Dimension(ancho, alto));
		setLocationRelativeTo(null);
		setLayout(null);
		prepareElementosMenu();
		prepareElementosConfiguracion();
	}
	
	private void prepareElementosConfiguracion()
	{
		this.getContentPane().setBackground(Color.black);
		configuracion = new JPanel();
		configuracion.setBounds(200, 0, alto, ancho);
		configuracion.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5),null));
		configuracion.setBackground(Color.black);
		titulo=new Title();
		titulo.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5),null));
		titulo.setBackground(Color.black);
		tituloConfig=new TituloConfiguracion();
		tituloConfig.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5),null));
		tituloConfig.setBackground(Color.black);
		tamaño=new JTextField();
		huecos=new JTextField();
		barreras=new JTextField();
		color=new JColorChooser();
		cambiarColor=new JButton("Escoger Color");
		cambiarColor.setBackground(new Color(255,116,0));
		guardar=new JButton("Guardar");
		guardar.setBackground(new Color(255,116,0));
		jugar=new JButton("Jugar");
		jugar.setBackground(new Color(255,116,0));
		tituloConfig.setBounds(150, 290, 120, 170);
		titulo.setBounds(100, 20, 350, 100);
		cambiarColor.setBounds(300, 210, 150, 50);
		tamaño.setBounds(280, 290, 120, 30);
		huecos.setBounds(280, 350, 120, 30);
		barreras.setBounds(280, 410, 120, 30);
		guardar.setBounds(100, 210, 150, 50);
		jugar.setBounds(200, 130, 150, 50);
		guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionGuardarConfiguracion();
            }
		});
		cambiarColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionEscogerColor();
            }
		});
		jugar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionEmpezarJuego();
            }
		});
		configuracion.setLayout(null);
		configuracion.add(huecos);
		configuracion.add(tamaño);
		configuracion.add(barreras);
		configuracion.add(cambiarColor);
		configuracion.add(guardar);
		configuracion.add(jugar);
		configuracion.add(titulo);
		configuracion.add(tituloConfig);
		add(configuracion);
	}
	
	public class Title extends JPanel
	{
		public Title()
		{
			setVisible(true);
		}
		
		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(Color.white);
	        g.setFont(new Font("Comic Sans MS",Font.BOLD,50));
	        g.drawString("Marbel Game",20,70);
	    }
	}
	
	public class TituloConfiguracion extends JPanel
	{
		/**
		 * Constructor de TituloConfiguracion
		 */
		public TituloConfiguracion()
		{
			setVisible(true);
		}
		
		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(Color.white);
	        g.setFont(new Font("Comic Sans MS",Font.BOLD,20));
	        g.drawString("Tamaño",0,20);
	        g.drawString("Numero",0,70);
	        g.drawString("de Huecos",0,90);
	        g.drawString("Numero",0,130);
	        g.drawString("de Barreras",0,150);
	    }
	}
	
	private void prepareElementosMenu()
	{
		barra=new JMenuBar();
		archivo=new JMenu("Archivo");
		ayuda=new JMenu("Configuracion");
		nuevo=new JMenuItem("Nuevo");
		salir=new JMenuItem("Salir");
		abrir=new JMenuItem("Abrir");
		Acercade=new JMenuItem("Configuracion inicial");
		Acercade2=new JMenuItem("Configuracion del tablero");
		barra.add(archivo);
		barra.add(ayuda);
		archivo.add(nuevo);
		archivo.add(abrir);
		archivo.add(salir);
		ayuda.add(Acercade);
		ayuda.add(Acercade2);
		setJMenuBar(barra);
	}
	
	private void accionEmpezarJuego()
	{
		try {
			if(yaFueGuardado)
			{
				setVisible(false);
				new marbelGameGUI(n,numHuecos,numBarreras,newColor);	
			}else
			{
				JOptionPane.showMessageDialog(null,"Asegurese de guardar una configuracion antes de jugar","Configuracion No Existente",JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception a)
		{
			yaFueGuardado=false;
			JOptionPane.showMessageDialog(null,"Hubo un error al tratar de crear el juego","Error al cargar",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void accionEscogerColor()
	{
		newColor=JColorChooser.showDialog(this,"Selecciona un color",Color.white);
	}
	
	private void accionGuardarConfiguracion()
	{
		try {
			n=Integer.parseInt(tamaño.getText());
			numBarreras=Integer.parseInt(barreras.getText());
			numHuecos=Integer.parseInt(huecos.getText());
			JOptionPane.showMessageDialog(null, "Configuracion Aplicada Correctamente","Guardado",JOptionPane.INFORMATION_MESSAGE);
			yaFueGuardado=true;
		} catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Asegurese de insertar valores enteros validos", "Valor Invalido",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void accionSalir() 
	{
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
 			    System.out.println("se cancela todo");}*/
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
            	accionAbrir();
            }
		});
		
		
	}
}
	
