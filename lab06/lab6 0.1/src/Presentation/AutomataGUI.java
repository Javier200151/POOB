package Presentation;
import Aplication.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AutomataGUI extends JFrame{	

    private JButton botonReloj;
    private JLabel lFila;
    private JLabel lColumna;
    private JTextField tFila;
    private JTextField tColumna;
    private JPanel panelControl;
    private JPanel panelNueva;
    private JPanel panelBNueva;
    private JButton botonViva;
    private JButton botonLatente;

    private FotoAutomata foto;
    private AutomataCelular automata=null;
	private JMenuBar barra;
	private JMenu archivo;
	private JMenu ayuda;
	private JMenuItem nuevo;
	private JMenuItem salir;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem Acercade;
	private JMenuItem Acercade2;
	private JButton botonNuevo;
	private JMenuItem importar;
	private JMenuItem exportar;

	/**
	 * Constructor de AutomataGUI
	 * @param ac, AutomataCelular a trabajar sobre el interfaz
	 */
    public AutomataGUI(AutomataCelular ac) 
    {
        super("Automata celular");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        automata=ac;
        foto=new FotoAutomata(automata);
        setSize(new Dimension(502,570)); 
        prepareElementos();
        prepareAcciones();
    }
    /**
     * Crea los paneles iniciales
     */
    private void prepareElementos() 
    {
        setResizable(false);
        botonReloj=new JButton("Tic-tac");
        botonNuevo=new JButton("Nuevo");
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto,BorderLayout.NORTH);
        getContentPane().add(botonReloj,BorderLayout.SOUTH);
        prepareElementosMenu();
        foto.repaint();
    }
    /**
     * Pinta los botones del menu
     */
    public void prepareElementosMenu()
	{
		barra=new JMenuBar();
		archivo=new JMenu("Archivo");
		nuevo=new JMenuItem("Nuevo");
		importar=new JMenuItem("Importar");
		exportar=new JMenuItem("Exportar");
		salir=new JMenuItem("Salir");
		abrir=new JMenuItem("Abrir");
		guardar=new JMenuItem("Guardar");
		barra.add(archivo);
		archivo.add(nuevo);
		archivo.add(abrir);
		archivo.add(guardar);
		archivo.add(importar);
		archivo.add(exportar);
		archivo.add(salir);
		setJMenuBar(barra);
	}
    /**
     * Prepara os listeners de los botones
     */
    private void prepareAcciones(){
    	
    	addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
            	int confirmado = JOptionPane.showConfirmDialog(
            			   null,
            			   "¿Esta seguro que desea salir?");

            			if (JOptionPane.YES_OPTION == confirmado) {
            			   System.out.println("confirmado");
                        	setVisible(false);
                        	System.exit(0);}
            			else if (JOptionPane.NO_OPTION == confirmado) {
             			   System.out.println("confirmado");
                         	setVisible(true);
                        }
            			else if (JOptionPane.CANCEL_OPTION == confirmado) {
             			   System.out.println("confirmado");
                         	setVisible(true);
                        }
            }
        });

        botonReloj.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    botonRelojAccion();
                }
            });
        salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionSalir();
            }
		});
        guardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
					accionGuardar();
				} catch (AutomataExcepcion e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
            }
		});
		abrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try {
					accionAbrir();
				} catch (AutomataExcepcion e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
            }
		});
		importar.addActionListener(new ActionListener() {
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
            			ArrayList matriz=new ArrayList<String>();
            			cadena=b.readLine();
            			if(cadena==null)
            			{
            				JOptionPane.showMessageDialog(null, "No fue posible realizar esta accion","Error", JOptionPane.ERROR_MESSAGE);
            			}
            			while(cadena!=null)
            			{
            				cadena=b.readLine();
            				System.out.println(cadena);
            				matriz.add(cadena);          				
            			}
						automata.importarAutomataCelular(matriz);
            		}
            		catch(Exception a)
            		{
            				a.printStackTrace();
            				JOptionPane.showMessageDialog(null, "No fue posible realizar esta accion");
            		}
            	}
            	repaint();
            }
		});
		exportar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	JFileChooser fc=new JFileChooser();
            	int seleccion=fc.showSaveDialog(null);
            	if(seleccion==JFileChooser.APPROVE_OPTION)
            	{
            		File fichero=fc.getSelectedFile();
            		
            		try(FileWriter fw=new FileWriter(fichero))
            		{
            			fw.write(automata.cadenaAGuardar());
            		}catch (IOException el)
            		{
            			el.printStackTrace();
            			JOptionPane.showMessageDialog(null, "No fue posible realizar esta accion");
            		}
            	}
            }
		});
		nuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	accionNuevo();
            }});
    }
    /**
     * Limpia y crean un nuevo AutomataCelular
     */
    public void accionNuevo() 
    {
    	setVisible(false);
		automata.nuevoAutomata();
		setVisible(true);
    }
    /**
     * Abre un archivo .dat
     * @throws AutomataExcepcion
     */
    public void accionAbrir() throws AutomataExcepcion 
	{
    	JFileChooser chooser=new JFileChooser();
		chooser.setVisible(true);
		int accion=chooser.showOpenDialog(this);
		
		if(accion==chooser.APPROVE_OPTION) 
		{
			
			File abre=chooser.getSelectedFile();
			automata=AutomataUI.abrir(abre,automata);
			foto.setAutomata(automata);
			repaint();	
			
		}
		
	}
    /**
     * Guarda un archivo.dat
     * @throws AutomataExcepcion
     */
	public void accionGuardar() throws AutomataExcepcion
	{
		JFileChooser chooser=new JFileChooser();
		chooser.setVisible(true);
		int accion=chooser.showSaveDialog(this);
		if(accion==chooser.APPROVE_OPTION) 
		{
			File abre=chooser.getSelectedFile();
			AutomataUI.salvar(abre,automata);
		}
		
	}
	/**
	 * Realiza un repeint por cada tictac
	 */
    private void botonRelojAccion() {
        automata.ticTac();
        foto.repaint();
    }
    /**
     * Slae de la aplicacion con confirmacion
     */
    public void accionSalir()
	{
		int confirmado = JOptionPane.showConfirmDialog(
 			   null,
 			   "¿Esta seguro que desea salir?");

 			if (JOptionPane.YES_OPTION == confirmado) {
 			   System.out.println("confirmado");
             	//setVisible(false);
             	System.exit(0);
             	}
	}

    public static void main(String[] args) {
        AutomataCelular ac=new AutomataCelular();
        AutomataGUI ca=new AutomataGUI(ac);
        ca.setVisible(true);

    }  
}

class FotoAutomata extends JPanel{
    public static int TAMANO=40;
    private AutomataCelular automata;

    public FotoAutomata(AutomataCelular ac) {
        setBackground(Color.white);
        automata=ac;
        setPreferredSize(new Dimension(800,800)); 		

    }

    public void setAutomata(AutomataCelular automata){
        this.automata=automata;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*TAMANO,0,f*TAMANO,automata.getLongitud()*TAMANO);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*TAMANO,automata.getLongitud()*TAMANO,c*TAMANO);
        }		
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c).getForma()==Elemento.CUADRADA){                  
                        if (automata.getElemento(f,c).isVivo()){
                            g.drawRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);
                        }else{
                            g.fillRoundRect(TAMANO*c+3,TAMANO*f+3,35,35,5,5);    

                        }
                    }else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        } else {
                            g.drawOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        }
                    }
                }
            }
        }
    }
}