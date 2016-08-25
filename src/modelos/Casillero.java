package modelos;

public class Casillero 
{
	private Integer numero;
	
	public Casillero(Integer n)
	{
		invariante(n);
		numero = n;
	}
	
	private void invariante(Integer n)
	{
		if(n == null) lanzarExcepcion("No puede ser null el numero");
		if(!esPotenciaDe2(n)) lanzarExcepcion("El numero no es una potencia de 2 positiva");
	}
	
	private boolean esPotenciaDe2(int n)
	{
		if(n == 0) return true;
		return ((n & (n - 1)) == 0);
	}
	
	private void lanzarExcepcion(String error)
	{
		throw new RuntimeException(error);
	}
	public Integer valor()
	{
		return this.numero;
	}
}
