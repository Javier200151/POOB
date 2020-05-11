package Aplication;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MarbelGame extends JFrame {
	//1=pelota | 2=hueco | 3=pelota en hueco correcto | -1=barrera
	private int[][] marbel;//= {{0,1,0,0},{1,-1,1,0},{2,0,0,2},{0,2,0,0}};
	private Color[][] JBalvin;// = {{null,Color.orange,null,null},{Color.blue,Color.black,Color.green,null},{Color.blue,null,null,Color.orange},{null,Color.green,null,null}};
	private int LONGITUD;
	private int numHuecos;
	private int numBarreras;
	private int fila;
	private int columna;
	private Color auxi;
	private  int[][] matrizTemporal;
	private  Color[][] colorTemporal;
	private int counter;
	
	/**
	 * Constructor de MarbelGame con enteros
	 * @param LONGITUD entero, tamaño del tablero cuadrado
	 * @param numHuecos entero, numero de huecos y fichas en el tablero
	 * @param numBarreras entero, numero de barreras en el tablero
	 */
	public MarbelGame(int LONGITUD, int numHuecos, int numBarreras)
	{
		this.LONGITUD=LONGITUD;
		this.numHuecos=numHuecos;
		this.numBarreras=numBarreras;
		marbel=new int[LONGITUD][LONGITUD];
		JBalvin=new Color[LONGITUD][LONGITUD];
		matrizTemporal=new int[LONGITUD][LONGITUD];
		colorTemporal=new Color[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++)
        {
            for (int c=0;c<LONGITUD;c++)
            {
            	marbel[f][c]=0;
            	JBalvin[f][c]=null;
            	matrizTemporal[f][c]=0;
            	colorTemporal[f][c]=null;
            }
        }
        posicionarElementos();
	}
	/**
	 * Constructor de MarbelGame con una cadena
	 * @param cadena, tablero en forma de cadena
	 */
	public MarbelGame(String cadena)
	{
		JOptionPane.showMessageDialog(null, "Abrir aun no implementado");
	}
	/**
	 * Reiniciar el tablero a como empezó el juego
	 */
	public void reiniciar() 
	{
		counter=0;
		for(int i=0;i<marbel.length;i++) 
		{
			for(int j=0;j<marbel.length;j++) 
			{
				marbel[i][j]=matrizTemporal[i][j];
				JBalvin[i][j]=colorTemporal[i][j];
			} 
		}
		
	}
	/**
	 * Convierte el tablero en una string
	 * @return String, tablero en formato de cadena
	 */
	public String cadenaAGuardar()
	{
		String cadena="";
		cadena+="{";
		for(int i=0; i<LONGITUD;i++)
		{
			cadena+="{";
			for(int j=0; j<LONGITUD;j++)
			{
				if(j==LONGITUD-1)
				{
					cadena += String.valueOf(marbel[i][j]);
				}else
				{
					cadena += String.valueOf(marbel[i][j]);
					cadena+=",";
				}
			}if(i==LONGITUD-1)
			{
				cadena += "}";
			}else
			{
				cadena += "}";
				cadena += ",";
			}
		} 
		cadena += "}";
		return cadena;
	}
	/**
	 * Obtiene el tipo de elemento en una coordenada
	 * @param f entero, posicion en fila
	 * @param c entero, posicion en columna
	 * @return entero, numero que representa una pieza
	 */
	public int getMarbel(int f,int c)
	{
		return marbel[f][c];
	}
	/**
	 * Obtiene el color de un elemento en una coordenada
	 * @param f entero, posicion en fila
	 * @param c entero, posicion en columna
	 * @return Color, color que se usa en una posicion
	 */
	public Color getJBalvin(int f,int c)
	{
		return JBalvin[f][c];
	}
	/**
	 * Obtiene la longitud del tablero
	 * @return entero, longitud del tablero
	 */
	public int getLongitud()
	{
		return LONGITUD;
	}
	/**
	 * Accion de mover las fichas a la izquierda
	 */
	public void mueveIzquierda()
	{
		for(int q=0; q<LONGITUD; q++)
		{
			for(int p=0; p<LONGITUD; p++)
			{	
				if(marbel[q][p]==1)
				{
					int k=p;
					while (k>0)
					{
						if(marbel[q][k-1]==2)
						{
							marbel[q][p]=0;
							marbel[q][k-1]=3;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k-1]=auxi;
							k=0;
							System.out.println("intento 1");
							counter++;
						}else if(marbel[q][k-1]==-1 || marbel[q][k-1]==1)
						{						
							marbel[q][p]=0;
							marbel[q][k]=1;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k]=auxi;
							k=0;
							System.out.println("intento 2");
						}
						else if(k-2==-1 && marbel[q][k-1]==0)
						{
							marbel[q][p]=0;
							marbel[q][k-1]=1;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k-1]=auxi;
							System.out.println("intento 3");
						}
						else if(marbel[q][k-1]==3 && k-2==-1)
						{
							marbel[q][p]=0;
							marbel[q][k]=1;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k]=auxi;
							k=0;
							System.out.println("intento 4");
						}
						k--;
					}
				}			
			}
		}
	}
	/**
	 * Accion de mover las fichas a la derecha
	 */
	public void mueveDerecha()
	{
		for(int q=LONGITUD-1; q>=0; q--)
		{
			for(int p=LONGITUD-1; p>=0; p--)
			{	
				if(marbel[q][p]==1)
				{
					int k=p;
					while (k<LONGITUD-1)
					{
						if(marbel[q][k+1]==2)
						{
							marbel[q][p]=0;
							marbel[q][k+1]=3;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k+1]=auxi;
							k=LONGITUD-1;
							counter++;
						}else if(marbel[q][k+1]==-1 || marbel[q][k+1]==1)
						{
							
							marbel[q][p]=0;
							marbel[q][k]=1;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k]=auxi;
							k=LONGITUD-1;
						}
						else if(k+2==LONGITUD && marbel[q][k+1]==0)
						{
							marbel[q][p]=0;
							marbel[q][k+1]=1;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k+1]=auxi;						
						}
						else if(marbel[q][k+1]==3 && k+2==LONGITUD)
						{
							marbel[q][p]=0;
							marbel[q][k]=1;
							auxi=JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[q][k]=auxi;
							k=LONGITUD-1;
							
						}
						k++;
					}
				}			
			}
		}
	}
	/**
	 * Accion de mover las fichas hacia arriba
	 */
	public void mueveArriba()
	{
		for(int q=0; q<LONGITUD; q++)
		{
			for(int p=0; p<LONGITUD; p++)
			{	
				if(marbel[q][p]==1)
				{
					int k=q;
					while (k>0)
					{
						if(marbel[k-1][p]==2)
						{
							marbel[q][p]=0;
							marbel[k-1][p]=3;
							auxi = JBalvin[q][p];						
							JBalvin[q][p]=null;
							JBalvin[k-1][p]=auxi;
							k=0;
							counter++;
						}else if(marbel[k-1][p]==-1 || marbel[k-1][p]==1)
						{							
							marbel[q][p]=0;
							marbel[k][p]=1;
							auxi = JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[k][p]=auxi;
							k=0;
						}
						else if(k-2==-1 && marbel[k-1][p]==0)
						{
							marbel[q][p]=0;			
							marbel[k-1][p]=1;
							auxi = JBalvin[q][p];						
							JBalvin[q][p]=null;
							JBalvin[k-1][p]=auxi;
						}
						else if(marbel[k-1][p]==3 && k-2==-1)
						{
							marbel[q][p]=0;
							marbel[k][p]=1;
							auxi = JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[k][p]=auxi;
							k=0;
						}
						k--;
					}
				}			
			}
		}
	}
	/**
	 * Accion de mover las fichas hacia abajo
	 */
	public void mueveAbajo()
	{
		for(int q=LONGITUD-1; q>=0; q--)
		{
			for(int p=LONGITUD-1; p>=0; p--)
			{	
				if(marbel[q][p]==1)
				{
					int k=q;
					while (k<LONGITUD-1)
					{
						if(marbel[k+1][p]==2)
						{
							marbel[q][p]=0;
							marbel[k+1][p]=3;
							auxi = JBalvin[q][p];						
							JBalvin[q][p]=null;
							JBalvin[k+1][p]=auxi;
							k=LONGITUD-1;
							counter++;
						}else if(marbel[k+1][p]==-1 || marbel[k+1][p]==1)
						{							
							marbel[q][p]=0;
							marbel[k][p]=1;
							auxi = JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[k][p]=auxi;
							k=LONGITUD-1;
							
						}
						else if(k+2==LONGITUD && marbel[k+1][p]==0)
						{
							marbel[q][p]=0;			
							marbel[k+1][p]=1;
							auxi = JBalvin[q][p];						
							JBalvin[q][p]=null;
							JBalvin[k+1][p]=auxi;
							
						}
						else if(marbel[k+1][p]==3 && k+2==LONGITUD)
						{
							marbel[q][p]=0;
							marbel[k][p]=1;
							auxi = JBalvin[q][p];
							JBalvin[q][p]=null;
							JBalvin[k][p]=auxi;
							k=LONGITUD-1;						
						}
						k++;
					}
				}			
			}
		}
	}
	/**
	 * Obtiene el contador de movimientos
	 * @return entero contador de movimientos
	 */
	public int getCounter() 
	{
		return counter;
	}
	/**
	 * Imprime el tablero para visualizarlo en consola
	 */
	private void printMarbel()
	{
		for(int q=0; q<LONGITUD; q++)
		{
			System.out.println();
			for(int p=0; p<LONGITUD; p++)
				System.out.print(marbel[q][p]);			
		}
	}
	/**
	 * Posiciona los elementos de manera aleatoria en el tablero
	 */
	private void posicionarElementos()
	{	
		//posicionar huecos y fichas
		for(int i=0; i<numHuecos; i++)
		{
			Random rand = new Random();
		    float r = rand.nextFloat();
		    float g = rand.nextFloat();
		    float b = rand.nextFloat();
		    Color randomColor = new Color(r, g, b);

			int[] posPelota=randomNumber();
			marbel[posPelota[0]][posPelota[1]]=1;
			JBalvin[posPelota[0]][posPelota[1]]=randomColor;
			matrizTemporal[posPelota[0]][posPelota[1]]=1;
			colorTemporal[posPelota[0]][posPelota[1]]=randomColor;
			
			
			int[] posHueco=randomNumber();
			marbel[posHueco[0]][posHueco[1]]=2;
			JBalvin[posHueco[0]][posHueco[1]]=randomColor;
			matrizTemporal[posHueco[0]][posHueco[1]]=2;
			colorTemporal[posHueco[0]][posHueco[1]]=randomColor;
			
		}
		//posicionar barreras
		for(int j=0; j<numBarreras; j++)
		{
			int[] posBarrera=randomNumber();
			JBalvin[posBarrera[0]][posBarrera[1]]=Color.black;
			marbel[posBarrera[0]][posBarrera[1]]=-1;
			colorTemporal[posBarrera[0]][posBarrera[1]]=Color.black;
			matrizTemporal[posBarrera[0]][posBarrera[1]]=-1;
			
		}
		
		
	}
	/**
	 * Obtiene un numero aleatoria sin repetir
	 * @return entero, numero aleatorio de 0 a LONGITUD sin repetir
	 */
	private int[] randomNumber()
	{
		fila = new Random().nextInt(LONGITUD);
		columna = new Random().nextInt(LONGITUD);
		while (marbel[fila][columna]!=0)
		{
			fila = new Random().nextInt(LONGITUD);
			columna = new Random().nextInt(LONGITUD);
		}			
		int[] pos=new int[2];
		pos[0]=fila;
		pos[1]=columna;	
		return pos;
		
	}
	
}
