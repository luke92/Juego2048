package modelos;

import java.io.*;
import java.util.*;

public class AccesoDatos {
	
	public static void grabar(String nombreArchivo, ArrayList<String> cadenas)
	{
		try 
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(nombreArchivo, true));
            for(String x : cadenas)
            {
            	out.write(x + ";");
            }
            out.newLine();
			out.close();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> leer(String nombreArchivo)
	{
        ArrayList<String> cadenas = new ArrayList<String>();
        File f = new File( nombreArchivo );
		BufferedReader entrada;
		try 
		{
			entrada = new BufferedReader( new FileReader( f ) );
			String[] linea;
			while(entrada.ready())
			{
				linea = entrada.readLine().split(";");
				cadenas.addAll(Arrays.asList(linea));
			}
			entrada.close();
		}
		catch (IOException e) 
		{
			return null;
		}
		return cadenas;
	}	

}
