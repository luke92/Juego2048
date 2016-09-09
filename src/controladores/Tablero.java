package controladores;

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
			for (int j = 0; j < grilla.cantColumnas(); j++) {

			}
		}
	}

	private void moverCasillerosIzq(int fila, int pos, int casLibre) {
		// buscarCoincidenciasIzquierda(fila, pos);
		if (pos < grilla.cantColumnas()) {
			buscarCoincidenciasIzquierda(fila, pos);
			if (!grilla.casilleroOcupado(fila, pos)) {
				if (casLibre >= pos)
					casLibre = pos;
				moverCasillerosIzq(fila, pos + 1, casLibre);
			} else {
				if (casLibre < pos) {
					int valor = grilla.getCasillero(fila, pos).valor();
					grilla.removerNumero(fila, pos);
					pos = casLibre;
					grilla.asignarNumero(fila, pos, valor);
				}
				moverCasillerosIzq(fila, pos + 1, casLibre + 1);
			}
		}
		buscarCoincidenciasIzquierda(fila, pos + 1);
	}

	private void buscarCoincidenciasIzquierda(int fila, int posInicial) {
		int posSiguiente = posInicial + 1;
		if (posInicial < grilla.cantColumnas() - 1) {
			if (!grilla.casilleroOcupado(fila, posInicial)
					|| !grilla.casillerosIguales(fila, posInicial, fila, posSiguiente)) {
				buscarCoincidenciasIzquierda(fila, posSiguiente);
			} else {
				if (grilla.casillerosIguales(fila, posInicial, fila, posSiguiente)) {
					int valor = grilla.getCasillero(fila, posInicial).valor() * 2;
					System.out.println(valor);
					puntaje.acumularPuntos(valor);
					grilla.asignarNumero(fila, posInicial, valor);
					grilla.removerNumero(fila, posSiguiente);
					buscarCoincidenciasIzquierda(fila, posSiguiente);
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
