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
		String opciones = "1 Izquierda 2 Derecha 3 Arriba 4 Abajo";
		
		while(true)
		{
			System.out.println(tablero.mostrar());
			System.out.println();
			System.out.println(opciones);
			opcion = Entrada.readLine();
			switch(opcion)
			{
				case "1": tablero.moverIzquierda();
				System.out.println("Izq");
					break;
				case "2": tablero.moverDerecha();
				System.out.println("der");
					break;
				case "3": tablero.moverArriba();
				System.out.println("up");
					break;
				case "4": tablero.moverAbajo();
				System.out.println("down");
					break;
				default: System.out.println("opcion erronea");
			}
			tablero.agregarNumero();
		}
	
	}
		
}
