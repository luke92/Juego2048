package controladores;

import java.util.Random;

import modelos.Puntaje;

public class Tablero 
{
	private Grilla grilla;
	private Puntaje puntaje;
	
	public Tablero(int filas, int columnas)
	{
		grilla = new Grilla(filas, columnas);
		puntaje = new Puntaje();
	}
	
	public void moverIzquierda()
	{
		for(int i = 0; i < grilla.cantFilas(); i++)
		{
			buscarCoincidenciasIzquierda(0,1);
			for(int j = 0; j < grilla.cantColumnas(); j++)
			{
				
			}
		}
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
	
	public String mostrar()
	{
		return grilla.toString();
	}
	
	public void agregarNumero()
	{
		if(grilla.cantidadCasilleros() == grilla.casillerosOcupados())
			throw new RuntimeException("No se pueden agregar mas numeros");
		
		int numero = randomCelda();
		int fila = numero / grilla.cantFilas();
		int columna = numero % grilla.cantColumnas();
		
		if(grilla.casilleroOcupado(fila, columna))
			agregarNumero();
		else
			grilla.asignarNumero(fila, columna, generarNumero());
	}
	
	private int generarNumero(){
		Random rnd = new Random();
		int[] num= {2,4};
		return num[ rnd.nextInt(2) ];
	}
	
	private int randomCelda()
	{
		Random rnd = new Random();
		return rnd.nextInt( grilla.cantidadCasilleros() );
	}
	
	private boolean hayMovimientos()
	{
		return true;
	}
	
	
	
}
