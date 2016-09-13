package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controladores.Tablero;

public class FormTablero extends JPanel 
{
	private static final Color BG_COLOR = new Color(0xbbada0);
	private static final String FONT_NAME = "Arial";
	private static final int TILE_SIZE = 64;
	private static final int TILES_MARGIN = 16;
	private Tablero tablero;
	private FormGrilla grillaVisual;
	public FormTablero()
	{
		setFocusable(true);
		addKeyListener(new KeyAdapter() 
		{
			@Override
		    public void keyPressed(KeyEvent e) 
		    {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		          reiniciarJuego();
		        }
		        if (!tablero.hayMovimientosDisponibles()) 
		        {
		        	mostrarMensajeFinal();
		        }
		        else
		        {
		        	switch (e.getKeyCode()) {
		            	case KeyEvent.VK_LEFT:
		            		izquierda();
		            		break;
		            	case KeyEvent.VK_RIGHT:
		            		derecha();
		            		break;
		            	case KeyEvent.VK_DOWN:
		            		abajo();
		            		break;
		            	case KeyEvent.VK_UP:
		            		arriba();
		            		break;
		        	}
		        	
		        }
		        repaint();
		    }
		});
		reiniciarJuego();
	}
	
	private void izquierda()
	{
		if(tablero.moverIzquierda())
		{
			tablero.agregarNumero();
			actualizarTablero();
		}
	}
	
	private void derecha()
	{
		if(tablero.moverDerecha())
		{
			tablero.agregarNumero();
			actualizarTablero();
		}
	}
	
	private void arriba()
	{
		if(tablero.moverArriba())
		{
			tablero.agregarNumero();
			actualizarTablero();
		}
	}
	
	private void abajo()
	{
		if(tablero.moverAbajo())
		{
			tablero.agregarNumero();
			actualizarTablero();
		}
	}
	
	private void reiniciarJuego() 
	{
		tablero = new Tablero(4, 4);
		tablero.agregarNumero();
		tablero.agregarNumero();
		grillaVisual = new FormGrilla(tablero.getGrilla());
		actualizarTablero();
		repaint();
	}
	  
	private void mostrarMensajeFinal() 
	{
		if(tablero.nuevaPuntuacionMaxima())
		{
			String nombre= JOptionPane.showInputDialog("Sos el mas capo! +10. Como te llamas?");
			tablero.grabarPuntaje(nombre);
			JOptionPane.showMessageDialog(null,"Ya guarde tus puntos, espero que no te derroquen");
		}
		else
		{
			if(tablero.victoria())
				JOptionPane.showMessageDialog(null,"Ganaste Papa!");
			else JOptionPane.showMessageDialog(null,"Game Over, mejor para la proxima lince");
		}
	}
	
	private void actualizarTablero()
	{
		grillaVisual.actualizar(tablero.getGrilla());
	}
	
	@Override
	  public void paint(Graphics g) {
	    super.paint(g);
	    g.setColor(BG_COLOR);
	    g.fillRect(0, 0, this.getSize().width, this.getSize().height);
	    for (int fila = 0; fila < 4; fila++) {
	      for (int columna = 0; columna < 4; columna++) {
	        dibujarCasillero(g, grillaVisual.getCasillero(fila, columna), columna, fila);
	      }
	    }
	  }

	  private void dibujarCasillero(Graphics g2, FormCasillero casillero, int x, int y) {
	    Graphics2D g = ((Graphics2D) g2);
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
	    int value = casillero.valor();
	    int xOffset = offsetCoors(x);
	    int yOffset = offsetCoors(y);
	    g.setColor(casillero.getBackground());
	    g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 14, 14);
	    g.setColor(casillero.getForeground());
	    final int size = value < 100 ? 36 : value < 1000 ? 32 : 24;
	    final Font font = new Font(FONT_NAME, Font.BOLD, size);
	    g.setFont(font);

	    String s = String.valueOf(value);
	    final FontMetrics fm = getFontMetrics(font);

	    final int w = fm.stringWidth(s);
	    final int h = -(int) fm.getLineMetrics(s, g).getBaselineOffsets()[2];

	    if (value != 0)
	      g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2);

	    g.setFont(new Font(FONT_NAME, Font.PLAIN, 18));
	    g.drawString("Puntaje: " + tablero.puntajeActual(), 200, 365);

	  }

	  private static int offsetCoors(int arg) {
	    return arg * (TILES_MARGIN + TILE_SIZE) + TILES_MARGIN;
	  }
}
