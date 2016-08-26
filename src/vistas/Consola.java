package vistas;

import controladores.Tablero;

public class Consola 
{
	public static void main (String [] args)
	{
		Tablero tablero = new Tablero();
		
		tablero.moverArriba();
		tablero.moverAbajo();
	}
}
