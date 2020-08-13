package Presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PoongGUI extends JFrame{
	
	private int alto;
	private int ancho;
	private JPanel buttons;
	private JButton buttonPlay;
	private JButton buttonSettings;
	private JButton buttonClose;
	private TitlePoong title;
	private JFrame settings;
	private JPanel panelSettings;
	private JCheckBox multiplayer;
	private JLabel PvP;
	
	private JPanel player1;
	private JTextField nickname;
	private JLabel textplayer1;
	private JButton buttonSuperhero;
	private JButton buttonVillain;
	
	private JPanel player2;
	private JTextField nickname2;
	private JLabel textplayer2;
	private JButton buttonSuperhero2;
	private JButton buttonVillain2;
	protected String characterP2="";
	protected String characterP1="";
	protected boolean twoplayers;
	private JButton save;
	private String nicknameP1;
	private String nicknameP2;
	private JPanel seleccionPelota;
	private JButton flashball;
	private JButton slowball;
	private JButton perfectball;
	private int pelotaSeleccionada=-1;
	private JPanel fondo;
	/**
	 * Constructor de la clase PoongGUI
	 */
	public PoongGUI()
	{
		setVisible(true);
		prepareElementos();
	}
	/**
	 * Prepara los elementos de la interfaz principal
	 */
	private void prepareElementos() 
	{		
		setTitle(" Poong");
		this.setBackground(Color.black);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		alto = screenSize.height /2; //540
		ancho = screenSize.width /2; //960
		setSize(new Dimension((int) ((ancho*0.8)+200), (int) ((alto*0.8)+250)));
		setLocationRelativeTo(null);
		setLayout(null);
		prepareElementsSettings();
		
		prepareSeleccion();
		prepareElementsMenu();
		setVisible(false);
		setVisible(true);
	}
	public static void main(String[] args) 
	{	
		PoongGUI gui= new PoongGUI();
		gui.setVisible(true);
	}
	/**
	 * Prepara los elementos del interfaz de menu
	 */
	private void prepareElementsMenu()
	{
		buttons=new JPanel();
		title=new TitlePoong("POONG",100,300,140);
		title.setBounds(0,0,ancho+200,alto+200);
		title.setBackground(new Color(17,216,0));
		buttons.setBounds(ancho/4, 200, 500, 100);
		buttons.setBackground(new Color(17,216,0));
		buttons.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), null)); //new TitledBorder("")
		buttons.setLayout(null);
		buttonPlay=new JButton("Play");
		buttonSettings=new JButton("Settings");
		buttonClose=new JButton("Close");
		buttonPlay.setBounds(25,0,200,75);
		//buttonSettings.setBounds(25,100,200,75);
		buttonClose.setBounds(250,0,200,75);
		prepareAcciones();
		buttons.add(buttonPlay);
		buttons.add(buttonSettings);
		buttons.add(buttonClose);
		add(buttons);
		add(title);
	}
	/**
	 * Prepara los elementos de la interfaz de configuracion
	 */
	private void prepareElementsSettings()
	{				
		prepareOnePlayer();
		prepareTwoPlayer();
		
		multiplayer=new JCheckBox("Player 2");
		multiplayer.setBounds(440,490,120,20);
		multiplayer.setBackground(new Color(17,216,0));
		
		prepareActionsSettings();
			
		add(multiplayer);
		add(player1);
		add(player2);
	}
	/**
	 * prepara el panel del jugador 1
	 */
	private void prepareOnePlayer()
	{
		player1=new JPanel();
		player1.setBounds(170,290, 300, 200);
		player1.setLayout(null);
		player1.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new TitledBorder("PLAYER 1")));
		player1.setBackground(new Color(16,169,0));
		nickname=new JTextField(15);
		nickname.setBounds(100,50,150,25);
		
		textplayer1=new JLabel();
		textplayer1.setText("Nickname");
		textplayer1.setBounds(25,12, 200, 100);
		
		buttonSuperhero=new JButton("Superhero");
		buttonSuperhero.setBounds(25, 100, 100, 25);
		
		buttonVillain=new JButton("Villain");
		buttonVillain.setBounds(125, 100, 100, 25);
		
		player1.add(buttonSuperhero);
		player1.add(buttonVillain);
		player1.add(nickname);
		player1.add(textplayer1);
	}
	/**
	 * prepara el panel del jugador 2
	 */
	private void prepareTwoPlayer()
	{
		player2=new JPanel();
		player2.setBounds(485,290, 300, 200);
		player2.setLayout(null);
		player2.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), new TitledBorder("PLAYER 2")));
		player2.setBackground(new Color(16,169,0));
		nickname2=new JTextField(15);
		nickname2.setBounds(100,50,150,25);
		
		textplayer2=new JLabel();
		textplayer2.setText("Nickname");
		textplayer2.setBounds(25,12, 200, 100);
		
		buttonSuperhero2=new JButton("Superhero");
		buttonSuperhero2.setBounds(25, 100, 100, 25);
		
		buttonVillain2=new JButton("Villain");
		buttonVillain2.setBounds(125, 100, 100, 25);
		player2.setVisible(false);
		
		player2.add(buttonSuperhero2);
		player2.add(buttonVillain2);
		player2.add(nickname2);
		player2.add(textplayer2);
	}
	/**
	 * Prepara los elementos de seleccion de pelota
	 */
	private void prepareSeleccion()
	{
		seleccionPelota = new JPanel();
		seleccionPelota.setBackground(new Color(17,216,0));
		seleccionPelota.setLayout(null);
		seleccionPelota.setBounds(10,510,940,120);
		seleccionPelota.setBorder(new CompoundBorder(new EmptyBorder(5,5,5,5), null));
		flashball = new JButton("Flashball");
		flashball.setBounds(200,30,150,50);
		slowball = new JButton("Slowball");
		slowball.setBounds(400,30,150,50);
		perfectball = new JButton("Perfectball");
		perfectball.setBounds(600,30,150,50);
		prepareBotonesSeleccion();
		seleccionPelota.add(perfectball);
		seleccionPelota.add(slowball);
		seleccionPelota.add(flashball);
		add(seleccionPelota);
	}
	/**
	 * verifica los errores y lanza las excepciones
	 * @throws PoongExcepcion
	 */
	private void actionVerificarParametros() throws PoongExcepcion 
	{
		if(nickname.getText().length()>=1 && nickname2.getText().length()>=1)
		{
			nicknameP1=nickname.getText();
			nicknameP2=nickname2.getText();			
		}else
		{
			throw new PoongExcepcion(PoongExcepcion.NOMBRES_VACIOS);
		}
		if(pelotaSeleccionada==-1)
    	{
			throw new PoongExcepcion(PoongExcepcion.PELOTA_NO_SELECCIONADA);
    	}
		if(characterP1.length()<=1 || characterP2.length()<=1)
    	{
			throw new PoongExcepcion(PoongExcepcion.PERSONAJE_NO_SELECCIONADO);
    	}
		if(characterP1==characterP2)
    	{
			throw new PoongExcepcion(PoongExcepcion.PERSONAJE_IGUALES);
    	}
	}
	/**
	 * manda a preparar los elementos de configuracion 
	 */
	private void actionOpenSettings()
	{
		prepareElementsSettings();
	}
	/**
	 * cierra la aplicacion
	 */
	private void actionClose()
	{
		System.exit(0);
	}
	/**
	 * prepara los listener de configuracion
	 */
	private void prepareActionsSettings()
	{
		multiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (multiplayer.isSelected()) {
					   player2.setVisible(true);
					   twoplayers=true;
				}else if (!multiplayer.isSelected()){
					   player2.setVisible(false);
					   twoplayers=false;
				}
			}
		});
		buttonSuperhero2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	characterP2="flash";
            }
		});
		buttonSuperhero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	characterP1="flash";
            }
		});
		buttonVillain2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	characterP2="leatherface";
            }
		});
		buttonVillain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	characterP1="leatherface";
            }
		});
	}
	/**
	 * prepara los listeners de los botones de seleccion de pelotas
	 */
	private void prepareBotonesSeleccion()
	{
		slowball.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	pelotaSeleccionada=0;
            }
		});
		flashball.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	pelotaSeleccionada=1;
            }
		});
		perfectball.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	pelotaSeleccionada=2;
            }
		});
	}
	/**
	 * prepara los listener de las acciones
	 */
	private void prepareAcciones()
	{
		/*addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
            	int confirmado = JOptionPane.showConfirmDialog(
            			   null,
            			   "¿Are you sure do you wanna exit?");

            			if (JOptionPane.YES_OPTION == confirmado) {
                        	setVisible(false);
                        	System.exit(0);}
            }
        });*/
		buttonPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//System.out.println("JEG");
            	try
            	{
            		actionVerificarParametros();
            		setVisible(false);
                	new mainGui(characterP1,characterP2,nicknameP1,nicknameP2,pelotaSeleccionada);
            	}catch (Exception ex) {
            		ex.printStackTrace();
            	}
            	
            }
		});

		buttonSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	actionOpenSettings();
            }
		});
		buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	actionClose();
            }
		});
	}
	private class TitlePoong extends JPanel
	{
		private int x;
		private int y;
		private int size;
		private String title;
		
		public TitlePoong(String title,int size,int x,int y)
		{
			setVisible(true);
			this.x=x;
			this.y=y;
			this.size=size;
			this.title=title;
		}
		
		public void paint(Graphics g)
		{
			super.paint(g);
			g.setColor(Color.black);
	        g.setFont(new Font("Comic Sans MS",Font.BOLD,size));
	        g.drawString(title,x,y);
	    }
	}
}