package controladores;

import modelos.Puntaje;

public class Tablero {
	private Grilla grilla;
	private Puntaje puntaje;
	
	public Tablero(int filas, int columnas) 
	{
		grilla = new Grilla(filas, columnas);
		puntaje = new Puntaje();
	
	}
	
	private Tablero(Tablero aux)
	{
		this.grilla = aux.grilla;
	}

	public boolean moverIzquierda() 
	{
		boolean bandera = false;
		for (int fila = 0; fila < grilla.cantFilas(); fila++) 
		{
			moverCasillerosIzq(fila, 0, 1,bandera);
			combinarCasillerosIzq(fila,0,1,bandera);
			moverCasillerosIzq(fila,0,1,bandera);
		}
		return bandera;
	}

	private void moverCasillerosIzq(int fila, int colActual, int colSiguiente, boolean bandera) 
	{
		if(colSiguiente >= grilla.cantColumnas()) 
		{
			return;
		}
		else
		{
			if(!grilla.casilleroOcupado(fila, colActual))
			{
				if(grilla.casilleroOcupado(fila, colSiguiente))
				{
					grilla.asignarNumero(fila, colActual, grilla.getCasillero(fila, colSiguiente).valor());
					grilla.asignarNumero(fila, colSiguiente,0);
					bandera = true;
					moverCasillerosIzq(fila, colActual+1, colSiguiente+1,bandera); 
				}
				else
				{
					moverCasillerosIzq(fila,colActual,colSiguiente+1,bandera);
				}
			}
			else
			{
				moverCasillerosIzq(fila, colActual+1, colSiguiente+1,bandera);
			}
		}
	}
	
	private void combinarCasillerosIzq(int fila, int colActual, int colSiguiente, boolean bandera)
	{
		if(colSiguiente >= grilla.cantColumnas()) 
		{
			return;
		}
		else
		{
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
						bandera = true;
					}
				}
			}
			combinarCasillerosIzq(fila, colActual+1, colSiguiente+1,bandera);
		}
		
	}

	public boolean moverDerecha() 
	{
		boolean bandera = false;
		for(int fila = 0; fila < grilla.cantFilas(); fila++)
		{
			moverCasillerosDer(fila,grilla.cantColumnas()-1,grilla.cantColumnas()-2,bandera);
			combinarCasillerosDer(fila,grilla.cantColumnas()-1,grilla.cantColumnas()-2,bandera);
			moverCasillerosDer(fila,grilla.cantColumnas()-1,grilla.cantColumnas()-2,bandera);
		}
		return bandera;
	}
	
	private void moverCasillerosDer(int fila, int colActual, int colSiguiente, boolean bandera) 
	{
		if(colSiguiente < 0) 
		{
			return;
		}
		else
		{
			if(!grilla.casilleroOcupado(fila, colActual))
			{
				if(grilla.casilleroOcupado(fila, colSiguiente))
				{
					grilla.asignarNumero(fila, colActual, grilla.getCasillero(fila, colSiguiente).valor());
					grilla.asignarNumero(fila, colSiguiente,0);
					bandera = true;
				}
				else
				{
					moverCasillerosDer(fila,colActual,colSiguiente-1,bandera);
				}
			}
			else
			{
				moverCasillerosDer(fila, colActual-1, colSiguiente-1,bandera);
			}
		}
	}
	
	private void combinarCasillerosDer(int fila, int colActual, int colSiguiente, boolean bandera)
	{
		if(colSiguiente < 0) 
		{
			return;
		}
		else
		{
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
						bandera = true;
					}
				}
			}
			combinarCasillerosDer(fila, colActual-1, colSiguiente-1,bandera);
		}
	}
	
	public boolean moverArriba() 
	{
		boolean bandera = false;
		for(int columna = 0; columna < grilla.cantColumnas(); columna++)
		{
			moverCasillerosArr(columna,0,1,bandera);
			combinarCasillerosArr(columna,0,1,bandera);
			moverCasillerosArr(columna,0,1,bandera);
		}
		return bandera;
	}
	
	private void moverCasillerosArr(int columna, int filaActual, int filaSiguiente, boolean bandera)
	{
		if(filaSiguiente >= grilla.cantFilas())
		{
			return;
		}
		else
		{
			if(!grilla.casilleroOcupado(filaActual, columna))
			{
				if(grilla.casilleroOcupado(filaSiguiente, columna))
				{
					grilla.asignarNumero(filaActual, columna, grilla.getCasillero(filaSiguiente, columna).valor());
					grilla.asignarNumero(filaSiguiente, columna,0);
					bandera = true;
				}
				else
				{
					moverCasillerosArr(columna,filaActual,filaSiguiente+1,bandera);
				}
			}
			else
			{
				moverCasillerosArr(columna, filaActual+1, filaSiguiente+1,bandera);
			}
		}
	}
	
	private boolean combinarCasillerosArr(int columna, int filaActual, int filaSiguiente, boolean bandera)
	{
		if(filaSiguiente >= grilla.cantFilas()) return bandera;
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
					bandera = true;
				}
			}
		}
		return combinarCasillerosArr(columna, filaActual+1, filaSiguiente+1,bandera);
	}

	public boolean moverAbajo() 
	{
		boolean bandera = false;
		for(int columna = 0; columna < grilla.cantColumnas(); columna++)
		{
			moverCasillerosAba(columna,grilla.cantFilas()-1,grilla.cantFilas()-2,bandera);
			combinarCasillerosAba(columna,grilla.cantFilas()-1,grilla.cantFilas()-2,bandera);
			moverCasillerosAba(columna,grilla.cantFilas()-1,grilla.cantFilas()-2,bandera);
		}
		return bandera;
	}
	
	private void moverCasillerosAba(int columna, int filaActual, int filaSiguiente, boolean bandera)
	{
		if(filaSiguiente < 0)
		{
			return;
		}
		else
		{
			if(!grilla.casilleroOcupado(filaActual, columna))
			{
				if(grilla.casilleroOcupado(filaSiguiente, columna))
				{
					grilla.asignarNumero(filaActual, columna, grilla.getCasillero(filaSiguiente, columna).valor());
					grilla.asignarNumero(filaSiguiente, columna,0);
					bandera = true;
				}
				else
				{
					moverCasillerosAba(columna,filaActual,filaSiguiente-1,bandera);
				}
			}
			else
			{
				moverCasillerosAba(columna, filaActual-1, filaSiguiente-1,bandera);
			}
		}
	}
	private void combinarCasillerosAba(int columna, int filaActual, int filaSiguiente, boolean bandera)
	{
		if(filaSiguiente < 0)
		{
			return;
		}
		else
		{
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
						bandera = true;
					}
				}
			}
			combinarCasillerosAba(columna, filaActual-1, filaSiguiente-1,bandera);
		}
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

	public boolean hayMovimientosDisponibles() 
	{
		if(grilla.cantidadCasilleros() == grilla.casillerosOcupados())
		{
			Tablero t = new Tablero(this);
			if(!t.moverAbajo() && !t.moverArriba() && !t.moverDerecha() && !t.moverIzquierda())
				return false;
			else return true;
		}
		else
			return true;
	}

}
