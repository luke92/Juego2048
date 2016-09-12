package modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Puntaje {
	private Integer puntaje;
	private String nombre;
	private Integer mejorPuntaje;
	private String nombreArchivo;
	public Puntaje() {
		puntaje = 0;
		nombre = "";
		mejorPuntaje = 0;
		nombreArchivo = "puntuacionMasAlta.txt";
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
	
	public void grabarPuntaje(String nombre)
	{
		ArrayList<String> puntuacion = new ArrayList<String>();
		puntuacion.add(nombre);
		puntuacion.add(String.valueOf(puntaje));
		AccesoDatos.grabar(nombreArchivo, puntuacion);
	}
	
	public Puntaje puntajeMaximo()
	{
		ArrayList<String> puntuaciones = AccesoDatos.leer(nombreArchivo);
		Puntaje puntuacionMaxima = new Puntaje();
		if(!puntuaciones.isEmpty())
		{
			puntuacionMaxima.nombre = puntuaciones.get(0);
			puntuacionMaxima.puntaje = Integer.parseInt(puntuaciones.get(1));
		}
		else
		{
			puntuacionMaxima.nombre = "admin";
			puntuacionMaxima.puntaje = 0;
		}
		return puntuacionMaxima;
	}

}
