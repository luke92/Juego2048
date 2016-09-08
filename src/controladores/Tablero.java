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
			moverCasillerosIzq(i, 0, 0);
			buscarCoincidenciasIzquierda(i, 0, 1);
			for (int j = 0; j < grilla.cantColumnas(); j++) {

			}
		}
	}

	private void moverCasillerosIzq(int fila, int pos, int casLibre) { // porFila
		if (pos < grilla.cantColumnas()) {
			if (!grilla.casilleroOcupado(fila, pos)) { // libre
				if (casLibre >= pos)
					casLibre = pos;
				moverCasillerosIzq(fila, pos + 1, casLibre);
			} else { // ocupado
				if (casLibre < pos) {
					int valor = grilla.getCasillero(fila, pos).valor();
					grilla.removerNumero(fila, pos);
					pos = casLibre;
					grilla.asignarNumero(fila, pos, valor);
				}
				moverCasillerosIzq(fila, pos + 1, casLibre + 1);
			}
		}
	}

	private void buscarCoincidenciasIzquierda(int fila, int posInicial, int posBuscar) { // porFila
		if (posBuscar < grilla.cantColumnas() && posInicial < grilla.cantColumnas() - 1) {
			if (!grilla.casilleroOcupado(fila, posInicial)
					|| !grilla.casillerosIguales(fila, posInicial, fila, posBuscar)) {
				buscarCoincidenciasIzquierda(fila, posInicial++, posBuscar++);
			}
			if (!grilla.casillerosIguales(fila, posInicial, fila, posBuscar)) {
				buscarCoincidenciasIzquierda(fila, posInicial++, posBuscar++);
			} else {
				if (!grilla.casilleroOcupado(fila, posBuscar)) {
					buscarCoincidenciasIzquierda(fila, posInicial, posBuscar++);
				} else {
					if (grilla.casillerosIguales(fila, posInicial, fila, posBuscar)) {
						int valor = grilla.getCasillero(fila, posInicial).valor() * 2;
						System.out.println(valor);
						puntaje.acumularPuntos(valor);
						grilla.asignarNumero(fila, posInicial, valor);
						grilla.removerNumero(fila, posBuscar);
						buscarCoincidenciasIzquierda(fila, posInicial++, posBuscar++);
					}
				}
			}
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
		grilla.agregarNumeroAleatorio();
	}

	public Integer puntajeActual() {
		return this.puntaje.puntajeActual();
	}

	private boolean hayMovimientos() {
		return true;
	}

}
