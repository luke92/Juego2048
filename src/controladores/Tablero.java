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

	}

	public void moverArriba() {

	}

	public void moverAbajo() {

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
