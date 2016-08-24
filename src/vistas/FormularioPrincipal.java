package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import java.awt.Panel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FormularioPrincipal {

	private JFrame frmVargas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPrincipal window = new FormularioPrincipal();				
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
	public FormularioPrincipal() {
		inicializar();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void inicializar() {
		frmVargas = new JFrame();
		frmVargas.setTitle("2048 1.0 Vargas Lucero");
		frmVargas.setBounds(100, 100, 506, 445);
		frmVargas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVargas.getContentPane().setLayout(null);
		
		JPanel pnl00 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnl00.getLayout();
		flowLayout.setAlignOnBaseline(true);
		pnl00.setBackground(SystemColor.activeCaption);
		pnl00.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl00.setBounds(66, 46, 75, 75);
		frmVargas.getContentPane().add(pnl00);
		
		JLabel lbl00 = new JLabel("");
		lbl00.setHorizontalAlignment(SwingConstants.CENTER);
		lbl00.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl00.add(lbl00);
		
		JPanel pnl01 = new JPanel();
		pnl01.setBackground(SystemColor.activeCaption);
		pnl01.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl01.setBounds(143, 46, 75, 75);
		frmVargas.getContentPane().add(pnl01);
		
		JLabel lbl01 = new JLabel("");
		lbl01.setHorizontalAlignment(SwingConstants.CENTER);
		lbl01.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl01.add(lbl01);
		
		JPanel pnl02 = new JPanel();
		pnl02.setBackground(SystemColor.activeCaption);
		pnl02.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl02.setBounds(220, 46, 75, 75);
		frmVargas.getContentPane().add(pnl02);
		
		JLabel lbl02 = new JLabel("");
		lbl02.setHorizontalAlignment(SwingConstants.CENTER);
		lbl02.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl02.add(lbl02);
		
		JPanel pnl03 = new JPanel();
		pnl03.setBackground(SystemColor.activeCaption);
		pnl03.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl03.setBounds(298, 46, 75, 75);
		frmVargas.getContentPane().add(pnl03);
		
		JLabel lbl03 = new JLabel("");
		lbl03.setHorizontalAlignment(SwingConstants.CENTER);
		lbl03.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl03.add(lbl03);
		
		JPanel pnl10 = new JPanel();
		pnl10.setBackground(SystemColor.activeCaption);
		pnl10.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl10.setBounds(66, 127, 75, 75);
		frmVargas.getContentPane().add(pnl10);
		
		JLabel lbl10 = new JLabel("");
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		lbl10.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl10.add(lbl10);
		
		JPanel pnl11 = new JPanel();
		pnl11.setBackground(SystemColor.activeCaption);
		pnl11.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl11.setBounds(143, 127, 75, 75);
		frmVargas.getContentPane().add(pnl11);
		
		JLabel lbl11 = new JLabel("");
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		lbl11.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl11.add(lbl11);
		
		JPanel pnl12 = new JPanel();
		pnl12.setBackground(SystemColor.activeCaption);
		pnl12.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl12.setBounds(220, 127, 75, 75);
		frmVargas.getContentPane().add(pnl12);
		
		JLabel lbl12 = new JLabel("");
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		lbl12.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl12.add(lbl12);
		
		JPanel pnl13 = new JPanel();
		pnl13.setBackground(SystemColor.activeCaption);
		pnl13.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl13.setBounds(298, 127, 75, 75);
		frmVargas.getContentPane().add(pnl13);
		
		JLabel lbl13 = new JLabel("");
		lbl13.setHorizontalAlignment(SwingConstants.CENTER);
		lbl13.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl13.add(lbl13);
		
		JPanel pnl20 = new JPanel();
		pnl20.setBackground(SystemColor.activeCaption);
		pnl20.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl20.setBounds(66, 206, 75, 75);
		frmVargas.getContentPane().add(pnl20);
		
		JLabel lbl20 = new JLabel("");
		lbl20.setHorizontalAlignment(SwingConstants.CENTER);
		lbl20.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl20.add(lbl20);
		
		JPanel pnl21 = new JPanel();
		pnl21.setBackground(SystemColor.activeCaption);
		pnl21.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl21.setBounds(143, 206, 75, 75);
		frmVargas.getContentPane().add(pnl21);
		
		JLabel lbl21 = new JLabel("");
		lbl21.setHorizontalAlignment(SwingConstants.CENTER);
		lbl21.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl21.add(lbl21);
		
		JPanel pnl22 = new JPanel();
		pnl22.setBackground(SystemColor.activeCaption);
		pnl22.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl22.setBounds(220, 206, 75, 75);
		frmVargas.getContentPane().add(pnl22);
		
		JLabel lbl22 = new JLabel("");
		lbl22.setHorizontalAlignment(SwingConstants.CENTER);
		lbl22.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl22.add(lbl22);
		
		JPanel pnl23 = new JPanel();
		pnl23.setBackground(SystemColor.activeCaption);
		pnl23.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl23.setBounds(298, 206, 75, 75);
		frmVargas.getContentPane().add(pnl23);
		
		JLabel lbl23 = new JLabel("");
		lbl23.setHorizontalAlignment(SwingConstants.CENTER);
		lbl23.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl23.add(lbl23);
		
		JPanel pnl30 = new JPanel();
		pnl30.setBackground(SystemColor.activeCaption);
		pnl30.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl30.setBounds(66, 284, 75, 75);
		frmVargas.getContentPane().add(pnl30);
		
		JLabel lbl30 = new JLabel("");
		lbl30.setHorizontalAlignment(SwingConstants.CENTER);
		lbl30.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl30.add(lbl30);
		
		JPanel pnl31 = new JPanel();
		pnl31.setBackground(SystemColor.activeCaption);
		pnl31.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl31.setBounds(143, 284, 75, 75);
		frmVargas.getContentPane().add(pnl31);
		
		JLabel lbl31 = new JLabel("");
		lbl31.setHorizontalAlignment(SwingConstants.CENTER);
		lbl31.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl31.add(lbl31);
		
		JPanel pnl32 = new JPanel();
		pnl32.setBackground(SystemColor.activeCaption);
		pnl32.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl32.setBounds(220, 284, 75, 75);
		frmVargas.getContentPane().add(pnl32);
		
		JLabel lbl32 = new JLabel("");
		lbl32.setHorizontalAlignment(SwingConstants.CENTER);
		lbl32.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl32.add(lbl32);
		
		JPanel pnl33 = new JPanel();
		pnl33.setBackground(SystemColor.activeCaption);
		pnl33.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		pnl33.setBounds(298, 284, 75, 75);
		frmVargas.getContentPane().add(pnl33);
		
		JLabel lbl33 = new JLabel("");
		lbl33.setHorizontalAlignment(SwingConstants.CENTER);
		lbl33.setFont(new Font("Calibri", Font.PLAIN, 29));
		pnl33.add(lbl33);
		
		JButton btnNuevoJuego = new JButton("Juego Nuevo");
		btnNuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Poner en 0 todos los labels y puntaje a 0 tambien.
			}
		});
		btnNuevoJuego.setBounds(143, 370, 162, 23);
		btnNuevoJuego.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
		          switch (e.getKeyCode()) {
		            case KeyEvent.VK_LEFT:
		              moverIzq();
		              break;
		            case KeyEvent.VK_RIGHT:
		              moverDer();
		              break;
		            case KeyEvent.VK_DOWN:
		              moverAbajo();
		              break;
		            case KeyEvent.VK_UP:
		              moverArriba();
		              break;
		          }
			}

			private void moverArriba() {
				
			}

			private void moverAbajo() {
			}

			private void moverDer() {
			}

			private void moverIzq() {
			}
		});
		
		frmVargas.getContentPane().add(btnNuevoJuego);
		
	}
	
	
}
