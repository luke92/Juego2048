package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestForm window = new TestForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//CasilleroForm casillero0 = new CasilleroForm(0, 0, 50, 50);
		//casillero0.modificarNumero("2");
		TableroForm tablero = new TableroForm(4, 4, 25);
		frame.getContentPane().add(tablero.getForm());
		frame.getContentPane().setLayout(null);
		
	}
}
