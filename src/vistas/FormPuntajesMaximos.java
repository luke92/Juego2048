package vistas;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JDialog;
import modelos.PuntajesMaximos;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FormPuntajesMaximos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormPuntajesMaximos() throws java.io.IOException
	{
		this.setTitle("Puntajes Maximos");
		this.setSize(340, 400);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    getContentPane().setLayout(null);
	    
	    JLabel lblPuntajesMaximos = new JLabel("Puntajes Maximos");
	    lblPuntajesMaximos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    lblPuntajesMaximos.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPuntajesMaximos.setBounds(54, 11, 212, 48);
	    getContentPane().add(lblPuntajesMaximos);
	    this.setVisible(true);
	    
	    PuntajesMaximos puntajes = new PuntajesMaximos();
	    int x= 33;
	    int y= 53;
	    BufferedReader l = new BufferedReader (new FileReader ("puntuacionesMaximas.txt"));
	    int i = 0;
	    while (i < puntajes.tamanio()) 
	    {
			JLabel nuevoLbl = new JLabel( l.readLine() );
		    nuevoLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    nuevoLbl.setBounds(x, y, 113, 22);
		    getContentPane().add(nuevoLbl);
		    i++;
	    }
	}

//	private void crearLbl(int x, int y, PuntajesMaximos puntajes,  int i) {
//		JLabel nuevoLbl = new JLabel( );
//	    nuevoLbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//	    nuevoLbl.setBounds(x, y, 113, 22);
//	    getContentPane().add(nuevoLbl);
//	}	
}

//class Form extends JPanel
//{
//	private static final Color FONDO_COLOR = new Color(0xedcc61);
//	private static final String FUENTE_NOMBRE = "Arial";
//	
//	public Form()
//	{
//		repaint();
//	}
//	
//	@Override
//	public void paint(Graphics g) 
//	{
//	    super.paint(g);
//	    g.setColor(FONDO_COLOR);
//	    g.fillRect(0, 0, this.getSize().width, this.getSize().height);
//	    PuntajesMaximos puntajes = new PuntajesMaximos();
//	    for (int i = 0; i < puntajes.tamanio(); i++) 
//	    {
//	    	dibujarPosiciones(g, puntajes.posicion(i), i+1);
//	    }
//	}
//	
//	private void dibujarPosiciones(Graphics g2, Puntaje puntaje, int y) 
//	{
//	    Graphics2D g = ((Graphics2D) g2);
//	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//	    g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
//	    g.setFont(new Font(FUENTE_NOMBRE, Font.PLAIN, 18));
//	    g.drawString(y + ") " + puntaje.getNombre() + " : " + puntaje.getPuntos(), 10, y*10);
//	}
//}