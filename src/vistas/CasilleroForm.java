package vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class CasilleroForm
{
	
	private JPanel panel;
	private JLabel label;
	
	public CasilleroForm(int posicionX, int posicionY, int ancho, int alto)
	{
		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBorder(UIManager.getBorder("RootPane.informationDialogBorder"));
		panel.setBounds(posicionX, posicionY, ancho, alto);
		
		label = new JLabel("4");
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 70));
		
		panel.add(label);
	}
	
	public JPanel getForm()
	{
		return panel;
	}
	
	public void modificarNumero(String text)
	{
		label.setText(text);
	}
}
