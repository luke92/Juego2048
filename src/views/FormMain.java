package views;

import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;

import javax.swing.JFrame;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.internal.win32.KEYBDINPUT;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.MessageBox;

import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.naming.ldap.Control;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		frmVargas.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println(arg0.getKeyChar());
			}
		});
		frmVargas.setTitle("2048 1.0 Vargas Lucero");
		frmVargas.setBounds(100, 100, 655, 480);
		frmVargas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVargas.getContentPane().setLayout(null);
		
		JButton btnNumero = new JButton("2");
		btnNumero.setBounds(118, 87, 89, 57);
		frmVargas.getContentPane().add(btnNumero);
		
		JButton btnIzq = new JButton("<<<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNumero.setBounds(btnNumero.getX()-5, btnNumero.getY(), btnNumero.getWidth(), btnNumero.getHeight());
				
			}
		});
		btnIzq.setBounds(74, 213, 89, 23);
		frmVargas.getContentPane().add(btnIzq);
		
		JButton btnDer = new JButton(">>>");
		btnDer.setBounds(173, 213, 89, 23);
		frmVargas.getContentPane().add(btnDer);
		
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
