package vistas;

import javax.swing.JPanel;

public class TableroForm {
	private JPanel panel;
	private CasilleroForm[][] casilleros;
	private int medidaCuadricula;

	public TableroForm(int filas, int columnas, int medidaCuadricula) {
		this.medidaCuadricula = medidaCuadricula;
		panel = new JPanel();
		panel.setBounds(10, 10, filas * medidaCuadricula, columnas * medidaCuadricula);
		casilleros = new CasilleroForm[filas][columnas];
		inicializarCasilleros(filas, columnas);
	}

	private void inicializarCasilleros(int filas, int columnas) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilleros[i][j] = new CasilleroForm(j * medidaCuadricula, i * medidaCuadricula, medidaCuadricula,
						medidaCuadricula);
				panel.add(casilleros[i][j].getForm());
			}
		}
	}

	public JPanel getForm() {
		return panel;
	}
}
