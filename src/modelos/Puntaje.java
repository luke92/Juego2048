package modelos;

public class Puntaje 
{
	private String nombre;
	private Integer puntos;
	
	public Puntaje()
	{
		nombre = "";
		puntos = 0;
	}
	
	public Puntaje(String nombre)
	{
		this.nombre = nombre;
	}
	
	public Puntaje(String nombre, Integer puntos)
	{
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	public void acumularPuntos(int puntosGanados)
	{
		this.puntos += puntosGanados;
	}
	
	public Integer puntajeActual()
	{
		return this.puntos;
	}
	
	
}
