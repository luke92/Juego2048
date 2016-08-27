package vistas;

import controladores.Tablero;
import controladores.Tablero.Dificultad;

public class Consola 
{
	public static void main (String [] args)
	{
		Tablero tablero = new Tablero(Dificultad.NORMAL);
		
		tablero.moverArriba();
		tablero.moverAbajo();
	}
}
