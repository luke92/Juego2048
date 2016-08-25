package modelos;

public class Grilla 
{
	private Casillero casilleros[][];
	
	public Grilla(int filas, int columnas)
	{
		invariante(filas,columnas);
		casilleros = new Casillero[filas][columnas];
		inicializarCasilleros();
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
			for(int j = 0; j < casilleros[i].length; i++)
				casilleros[i][j] = new Casillero(0);
	}
}
