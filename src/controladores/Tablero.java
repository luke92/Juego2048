package controladores;

import modelos.Puntaje;

public class Tablero {
	private Grilla grilla;
	private Puntaje puntaje;

	public Tablero(int filas, int columnas) {
		grilla = new Grilla(filas, columnas);
		puntaje = new Puntaje();
	}

	public void moverIzquierda() 
	{
		for (int fila = 0; fila < grilla.cantFilas(); fila++) 
		{
			moverCasillerosIzq(fila, 0, 1);
			combinarCasillerosIzq(fila,0,1);
			moverCasillerosIzq(fila,0,1);
		}
	}

	private void moverCasillerosIzq(int fila, int colActual, int colSiguiente) 
	{
		if(colSiguiente >= grilla.cantColumnas()) return;
		if(!grilla.casilleroOcupado(fila, colActual))
		{
			if(grilla.casilleroOcupado(fila, colSiguiente))
			{
				grilla.asignarNumero(fila, colActual, grilla.getCasillero(fila, colSiguiente).valor());
				grilla.asignarNumero(fila, colSiguiente,0);
			}
			else
			{
				moverCasillerosIzq(fila,colActual,colSiguiente+1);
			}
		}
		moverCasillerosIzq(fila, colActual+1, colSiguiente+1);
	}
	
	private void combinarCasillerosIzq(int fila, int colActual, int colSiguiente)
	{
		if(colSiguiente >= grilla.cantColumnas()) return;
		if(grilla.casilleroOcupado(fila, colActual))
		{
			if(grilla.casilleroOcupado(fila, colSiguiente))
			{
				if(grilla.casillerosIguales(fila, colActual, fila, colSiguiente))
				{
					int valor = grilla.getCasillero(fila, colActual).valor() * 2;
					System.out.println(valor);
					puntaje.acumularPuntos(valor);
					grilla.asignarNumero(fila, colActual, valor);
					grilla.removerNumero(fila, colSiguiente);
				}
			}
		}
		combinarCasillerosIzq(fila, colActual+1, colSiguiente+1);
	}

	public void moverDerecha() 
	{
		for(int fila = 0; fila < grilla.cantFilas(); fila++)
		{
			moverCasillerosDer(fila,grilla.cantColumnas()-1,grilla.cantColumnas()-2);
			combinarCasillerosDer(fila,grilla.cantColumnas()-1,grilla.cantColumnas()-2);
			moverCasillerosDer(fila,grilla.cantColumnas()-1,grilla.cantColumnas()-2);
		}
	}
	
	private void moverCasillerosDer(int fila, int colActual, int colSiguiente) 
	{
		if(colSiguiente < 0) return;
		if(!grilla.casilleroOcupado(fila, colActual))
		{
			if(grilla.casilleroOcupado(fila, colSiguiente))
			{
				grilla.asignarNumero(fila, colActual, grilla.getCasillero(fila, colSiguiente).valor());
				grilla.asignarNumero(fila, colSiguiente,0);
			}
			else
			{
				moverCasillerosDer(fila,colActual,colSiguiente-1);
			}
		}
		moverCasillerosDer(fila, colActual-1, colSiguiente-1);
	}
	
	private void combinarCasillerosDer(int fila, int colActual, int colSiguiente)
	{
		if(colSiguiente < 0) return;
		if(grilla.casilleroOcupado(fila, colActual))
		{
			if(grilla.casilleroOcupado(fila, colSiguiente))
			{
				if(grilla.casillerosIguales(fila, colActual, fila, colSiguiente))
				{
					int valor = grilla.getCasillero(fila, colActual).valor() * 2;
					System.out.println(valor);
					puntaje.acumularPuntos(valor);
					grilla.asignarNumero(fila, colActual, valor);
					grilla.removerNumero(fila, colSiguiente);
				}
			}
		}
		combinarCasillerosDer(fila, colActual-1, colSiguiente-1);
	}
	
	public void moverArriba() 
	{
		for(int columna = 0; columna < grilla.cantColumnas(); columna++)
		{
			moverCasillerosArr(columna,0,1);
			combinarCasillerosArr(columna,0,1);
			moverCasillerosArr(columna,0,1);
		}
	}
	
	private void moverCasillerosArr(int columna, int filaActual, int filaSiguiente)
	{
		if(filaSiguiente >= grilla.cantFilas()) return;
		if(!grilla.casilleroOcupado(filaActual, columna))
		{
			if(grilla.casilleroOcupado(filaSiguiente, columna))
			{
				grilla.asignarNumero(filaActual, columna, grilla.getCasillero(filaSiguiente, columna).valor());
				grilla.asignarNumero(filaSiguiente, columna,0);
			}
			else
			{
				moverCasillerosArr(columna,filaActual,filaSiguiente+1);
			}
		}
		moverCasillerosArr(columna, filaActual+1, filaSiguiente+1);
	}
	
	private void combinarCasillerosArr(int columna, int filaActual, int filaSiguiente)
	{
		if(filaSiguiente >= grilla.cantFilas()) return;
		if(grilla.casilleroOcupado(filaActual, columna))
		{
			if(grilla.casilleroOcupado(filaSiguiente, columna))
			{
				if(grilla.casillerosIguales(filaActual, columna, filaSiguiente, columna))
				{
					int valor = grilla.getCasillero(filaActual, columna).valor() * 2;
					System.out.println(valor);
					puntaje.acumularPuntos(valor);
					grilla.asignarNumero(filaActual, columna, valor);
					grilla.removerNumero(filaSiguiente, columna);
				}
			}
		}
		combinarCasillerosArr(columna, filaActual+1, filaSiguiente+1);
	}

	public void moverAbajo() 
	{
		for(int columna = 0; columna < grilla.cantColumnas(); columna++)
		{
			moverCasillerosAba(columna,grilla.cantFilas()-1,grilla.cantFilas()-2);
			combinarCasillerosAba(columna,grilla.cantFilas()-1,grilla.cantFilas()-2);
			moverCasillerosAba(columna,grilla.cantFilas()-1,grilla.cantFilas()-2);
		}
	}
	
	private void moverCasillerosAba(int columna, int filaActual, int filaSiguiente)
	{
		if(filaSiguiente < 0) return;
		if(!grilla.casilleroOcupado(filaActual, columna))
		{
			if(grilla.casilleroOcupado(filaSiguiente, columna))
			{
				grilla.asignarNumero(filaActual, columna, grilla.getCasillero(filaSiguiente, columna).valor());
				grilla.asignarNumero(filaSiguiente, columna,0);
			}
			else
			{
				moverCasillerosAba(columna,filaActual,filaSiguiente-1);
			}
		}
		moverCasillerosAba(columna, filaActual-1, filaSiguiente-1);
	}
	
	private void combinarCasillerosAba(int columna, int filaActual, int filaSiguiente)
	{
		if(filaSiguiente < 0) return;
		if(grilla.casilleroOcupado(filaActual, columna))
		{
			if(grilla.casilleroOcupado(filaSiguiente, columna))
			{
				if(grilla.casillerosIguales(filaActual, columna, filaSiguiente, columna))
				{
					int valor = grilla.getCasillero(filaActual, columna).valor() * 2;
					System.out.println(valor);
					puntaje.acumularPuntos(valor);
					grilla.asignarNumero(filaActual, columna, valor);
					grilla.removerNumero(filaSiguiente, columna);
				}
			}
		}
		combinarCasillerosAba(columna, filaActual-1, filaSiguiente-1);
	}

	public String mostrar() {
		return grilla.toString();
	}

	public void agregarNumero() {
		if (grilla.cantidadCasilleros() == grilla.casillerosOcupados())
			throw new RuntimeException("No se pueden agregar mas numeros");
		grilla.agregarNumeroAleatorio();
	}

	public Integer puntajeActual() {
		return this.puntaje.puntajeActual();
	}

	private boolean hayMovimientos() {
		return true;
	}

}
