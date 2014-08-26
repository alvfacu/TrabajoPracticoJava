package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static boolean altAbierto = false;
	public static boolean lisAbierto = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/Icono/icono.png")));
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 337);
		setSize(800, 650);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuAlta = new JMenuItem("Alta de electrodoméstico...");
		menuAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(altAbierto))
				{
					new AltaElectro().setVisible(true);
					altAbierto = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Ya se encuenta abierta esta ventana. No se permite instanciar más de una vez la ventana.", "Error !", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		JMenuItem menuListado = new JMenuItem("Ver listado de electrodomésticos...");
		menuListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(lisAbierto))
				{
					new Listado().setVisible(true);
					lisAbierto = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Ya se encuenta abierta esta ventana. No se permite instanciar más de una vez la ventana.", "Error !", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(menuAlta);
		mnNewMenu.add(menuListado);
		mnNewMenu.add(menuSalir);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
