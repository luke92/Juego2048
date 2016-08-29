package controladores;

public class Grilla 
{
	private Casillero casilleros[][];
	private int cantCasillerosOcupados;
	
	public Grilla(int filas, int columnas)
	{
		invariante(filas,columnas);
		casilleros = new Casillero[filas][columnas];
		inicializarCasilleros();
		cantCasillerosOcupados = 0;
	}
	
	private void invariante(int filas, int columnas)
	{
		if(filas != columnas) throw new RuntimeException("La cantidad de filas debe ser igual a la de columnas");
		if(filas < 3 || columnas < 3)
			throw new RuntimeException("La cantidad de filas o columnas no puede ser menor a 3");
	}
	
	private void inicializarCasilleros()
	{
		for(int i = 0; i < casilleros.length; i++)
			for(int j = 0; j < casilleros[i].length; j++)
				casilleros[i][j] = new Casillero(0);
	}
	
	public boolean casilleroOcupado(int fila, int columna)
	{
		if(casilleros[fila][columna].valor() != 0)
			return true;
		return false;
	}
	
	public void agregarNumero(int fila, int columna, int numero)
	{
		casilleros[fila][columna] = new Casillero(numero);
		cantCasillerosOcupados++;
	}
	
	public void removerNumero(int fila, int columna)
	{
		casilleros[fila][columna] = new Casillero(0);
		cantCasillerosOcupados--;
	}
	
	public int cantidadCasilleros()
	{
		return cantFilas()*cantColumnas();
	}
	
	public int cantFilas()
	{
		return casilleros.length;
	}
	
	public int cantColumnas()
	{
		return casilleros[0].length;
	}
	
	public int casillerosOcupados()
	{
		return cantCasillerosOcupados;
	}
	
	public String toString()
	{
		String cadena = "";
		for(int i = 0; i < cantFilas(); i++)
		{
			for(int j = 0; j < cantColumnas(); j++)
				cadena += casilleros[i][j].toString();
			cadena+= "\n";
		}
		return cadena;
	}
}
