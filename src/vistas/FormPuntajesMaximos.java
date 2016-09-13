package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JDialog;
import javax.swing.JPanel;

import modelos.Puntaje;
import modelos.PuntajesMaximos;

public class FormPuntajesMaximos extends JDialog {

	public FormPuntajesMaximos() 
	{
		this.add(new Form());
		this.setTitle("Puntajes Maximos");
		this.setSize(340, 400);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	    
	}	

}

class Form extends JPanel
{
	private static final Color FONDO_COLOR = new Color(0xedcc61);
	private static final String FUENTE_NOMBRE = "Arial";
	
	public Form()
	{
		repaint();
	}
	
	@Override
	public void paint(Graphics g) 
	{
	    super.paint(g);
	    g.setColor(FONDO_COLOR);
	    g.fillRect(0, 0, this.getSize().width, this.getSize().height);
	    PuntajesMaximos puntajes = new PuntajesMaximos();
	    for (int i = 0; i < puntajes.tamanio(); i++) 
	    {
	    	dibujarPosiciones(g, puntajes.posicion(i), i+1);
	    }
	}
	
	private void dibujarPosiciones(Graphics g2, Puntaje puntaje, int y) 
	{
	    Graphics2D g = ((Graphics2D) g2);
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
	    g.setFont(new Font(FUENTE_NOMBRE, Font.PLAIN, 18));
	    g.drawString(y + ") " + puntaje.getNombre() + " : " + puntaje.getPuntos(), 10, y*10);
	}
}