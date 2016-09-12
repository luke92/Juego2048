package vistas;

import controladores.Tablero;

public class Consola 
{
	public static void main (String [] args)
	{
		Tablero tablero = new Tablero(4,4);
		tablero.agregarNumero();
		tablero.agregarNumero();
		
		String opcion;
		String opciones;
		
		while(tablero.hayMovimientosDisponibles())
		{
			
			opciones = "1 Izquierda 2 Derecha 3 Arriba 4 Abajo, Puntos " + tablero.puntajeActual();
			
			System.out.println(tablero.mostrar());
			System.out.println();
			System.out.println(opciones);
			opcion = Entrada.readLine();
			switch(opcion)
			{
				case "1": 
					if(tablero.moverIzquierda()) 
					{
						System.out.println("Izquierda");
						tablero.agregarNumero();
					}
					break;
				case "2": 
					if(tablero.moverDerecha()) 
					{
						System.out.println("Derecha");
						tablero.agregarNumero();
					}
					break;
				case "3": 
					if(tablero.moverArriba())
					{
						System.out.println("Arriba");
						tablero.agregarNumero();
					}
					break;
				case "4": 
				if(tablero.moverAbajo())
				{
					System.out.println("Abajo");
					tablero.agregarNumero();
				}
					break;
				default: System.out.println("opcion erronea");
			}
			
		}
		System.out.println(tablero.mostrar());
		System.out.println("Game Over");
		System.out.println("Puntos: " + tablero.puntajeActual());
	
	}
		
}
