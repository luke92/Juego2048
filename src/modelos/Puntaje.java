package modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Puntaje {
	private Integer puntaje;
	private String nombre;
	private Integer mejorPuntaje;

	public Puntaje() {
		puntaje = 0;
		nombre = "";
		mejorPuntaje = 0;
	}

	public Puntaje(Integer puntos) {
		this.puntaje = puntos;
	}

	public void acumularPuntos(int puntosGanados) {
		this.puntaje += puntosGanados;
	}

	public Integer puntajeActual() {
		return this.puntaje;
	}

	public void checkPuntaje() {
		if (puntaje >= mejorPuntaje) {
			System.out.println("Nueva puntacion mas alta. Cual es tu nombre?");
			Scanner entradaEscaner = new Scanner(System.in);
			nombre = entradaEscaner.nextLine();
			mejorPuntaje = puntaje;

			File scorefile = new File("puntuacionMasAlta.dat");
			if (scorefile.exists()) {
				try {
					scorefile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			FileWriter writeFile = null;
			BufferedWriter writer = null;
			try {
				writeFile = new FileWriter(scorefile);
				writer = new BufferedWriter(writeFile);
				writer.write(nombre + ": " + this.mejorPuntaje);
			} catch (Exception e) {
				// errores
			} finally {
				try {
					if (writer != null)
						writer.close();
				} catch (Exception e) {
				}
			}
		}
	}

}
