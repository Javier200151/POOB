package Presentation;

import javax.swing.JFrame;

public class mainGui {
	/**
	 * Constructor de mainGui
	 * @param characterP1 personaje jugador 1
	 * @param characterP2 personaje jugador 2
	 * @param nicknameP1 nombre jugador 1
	 * @param nicknameP2 nombre jugador 2
	 * @param pelotaSeleccionada tipo de pelota
	 */
	public  mainGui(String characterP1,String characterP2,String nicknameP1,String nicknameP2, int pelotaSeleccionada) 
	{
		GameGui ventana= new GameGui(characterP1, characterP2, nicknameP1,nicknameP2,pelotaSeleccionada);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
