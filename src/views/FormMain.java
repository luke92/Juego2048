package views;

import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;

import javax.swing.JFrame;

import org.eclipse.swt.widgets.Layout;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class FormMain {

	private JFrame frmVargas;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain window = new FormMain();
					window.frmVargas.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVargas = new JFrame();
		frmVargas.setTitle("2048 1.0 Vargas Lucero");
		frmVargas.setBounds(100, 100, 655, 480);
		frmVargas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVargas.getContentPane().setLayout(null);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
