package controladores;

import java.util.Random;

import modelos.Puntaje;

public class Tablero {
	private Grilla grilla;
	private Puntaje puntaje;

	public Tablero(int filas, int columnas) {
		grilla = new Grilla(filas, columnas);
		puntaje = new Puntaje();
	}

	public void moverIzquierda() {
		for (int i = 0; i < grilla.cantFilas(); i++) {
			buscarCoincidenciasIzquierda(i, 0, 1);
			for (int j = 0; j < grilla.cantColumnas(); j++) {

			}
		}
	}

	private void buscarCoincidenciasIzquierda(int fila, int posInicial, int posBuscar) {
		if (posBuscar >= grilla.cantColumnas() || posInicial >= grilla.cantColumnas()-1)
			return;

		if (!grilla.casilleroOcupado(fila, posInicial)) {	//si en la posInicial esta libre
			buscarCoincidenciasIzquierda(fila, posInicial + 1, posBuscar + 1);
		}
		if (!grilla.casilleroOcupado(fila, posBuscar)) {	//si en la posBuscar esta libre
			buscarCoincidenciasIzquierda(fila, posInicial, posBuscar + 1);
		}
		if (!grilla.casillerosIguales(fila, posInicial, fila, posBuscar)) {	//si NO SON IGUALES
			buscarCoincidenciasIzquierda(fila, posInicial + 1, posBuscar + 1);
		}
		if (grilla.casillerosIguales(fila, posInicial, fila, posBuscar)) {
			int valor = grilla.getCasillero(fila, posInicial).valor() * 2;
			puntaje.acumularPuntos(valor);
			grilla.asignarNumero(fila, posInicial, valor);
			grilla.removerNumero(fila, posBuscar);
			buscarCoincidenciasIzquierda(fila, posBuscar + 1, posBuscar + 2);
		}
	}

	public void moverDerecha() {

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

		int numero = randomCelda();
		int fila = numero / grilla.cantFilas();
		int columna = numero % grilla.cantColumnas();

		if (grilla.casilleroOcupado(fila, columna))
			agregarNumero();
		else
			grilla.asignarNumero(fila, columna, generarNumero());
	}

	private int generarNumero() {
		Random rnd = new Random();
		int[] num = { 2, 4 };
		return num[rnd.nextInt(2)];
	}

	private int randomCelda() {
		Random rnd = new Random();
		return rnd.nextInt(grilla.cantidadCasilleros());
	}

	private boolean hayMovimientos() {
		return true;
	}

}
