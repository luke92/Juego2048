package controladores;

import modelos.Grilla;

public class Tablero 
{
	private Grilla grilla;
	
	public Tablero(Dificultad d)
	{
		if(d == Dificultad.FACIL)
			grilla = new Grilla(3, 3);
		if(d == Dificultad.NORMAL)
			grilla = new Grilla(4 , 4);
		if(d == Dificultad.DIFICIL)
			grilla = new Grilla(5, 5);
	}
	
	public void moverIzquierda()
	{
		
	}
	
	public void moverDerecha()
	{
		
	}
	
	public void moverArriba()
	{
		
	}
	
	public void moverAbajo()
	{
		
	}
	
	public enum Dificultad
	{
		FACIL,
		NORMAL,
		DIFICIL
	}
}
