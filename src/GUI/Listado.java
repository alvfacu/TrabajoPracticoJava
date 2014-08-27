package GUI;

import Negocio.*;
import TableModelElectrodomesticos.xTableModelElectrodomesticos;
import Entidades.Electrodomestico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;

public class Listado extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMin;
	private JTextField txtMax;
	private JComboBox cmbConsumo;
	private Character[] letras = {' ','A','B','C','D','E','F'};
	private JTable table;
	private xTableModelElectrodomesticos model;
	private JButton btnActualizar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado frame = new Listado();
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
	public Listado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Listado.class.getResource("/Icono/icono.png")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				VentanaPrincipal.lisAbierto = false;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 711, 681);
		setTitle("Listado");
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlCriterio = new JPanel();
		pnlCriterio.setBorder(BorderFactory.createTitledBorder("Criterios"));
		pnlCriterio.setBounds(10, 11, 685, 83);
		pnlCriterio.setLayout(null);
		contentPane.add(pnlCriterio);
		
		JLabel lblRangoDeImportes = new JLabel("Rango de importes");
		lblRangoDeImportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRangoDeImportes.setBounds(34, 26, 124, 14);
		pnlCriterio.add(lblRangoDeImportes);
		
		txtMin = new JTextField();
		txtMin.setToolTipText("M\u00EDnimo");
		txtMin.setBounds(181, 23, 86, 20);
		pnlCriterio.add(txtMin);
		txtMin.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(277, 26, 28, 14);
		pnlCriterio.add(label);
		
		txtMax = new JTextField();
		txtMax.setToolTipText("M\u00E1ximo");
		txtMax.setBounds(315, 23, 86, 20);
		pnlCriterio.add(txtMax);
		txtMax.setColumns(10);
		
		JLabel lblConsumo = new JLabel("Consumo energ\u00E9tico");
		lblConsumo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumo.setBounds(34, 54, 124, 14);
		pnlCriterio.add(lblConsumo);
		
		cmbConsumo = new JComboBox(letras);
		cmbConsumo.setBounds(181, 51, 52, 20);
		pnlCriterio.add(cmbConsumo);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					ListarTabla();
					if(model.getDataSource().size() == 0)
					{
						JOptionPane.showMessageDialog(null, "No se encontraron electrodomesticos según los criterios ingresados.", "Atención", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						btnModificar.setEnabled(true);
						btnEliminar.setEnabled(true);
					}							
			}
		});
		btnListar.setBounds(584, 50, 89, 23);
		pnlCriterio.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 685, 488);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 604, 685, 38);
		contentPane.add(panel);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{											
				try
				{
					int i = table.getSelectedRow();
					Electrodomestico el = DevolverElectroSeleccionado(i);
					new AltaElectro(el).setVisible(true);
					btnActualizar.setEnabled(true);
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "No existen registros ha modificar", "Atención", JOptionPane.INFORMATION_MESSAGE);
				}				
			}
		});
		btnModificar.setForeground(new Color(0, 128, 0));
		btnModificar.setBounds(219, 7, 89, 23);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{				
				try
				{
					int i = table.getSelectedRow();
					Electrodomestico el = DevolverElectroSeleccionado(i);
					int confirma = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este electrodoméstico?", "Atención", JOptionPane.YES_NO_OPTION);
					if (JOptionPane.YES_OPTION == confirma)
					{
						JOptionPane.showMessageDialog(null, "El electrodoméstico ha sido eliminado", "Atención", JOptionPane.INFORMATION_MESSAGE);
						new ElectrodomesticoLogic().Delete(el);
						ListarTabla();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "El electrodoméstico no ha sido eliminado", "Atención", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "No existen registros ha eliminar", "Atención", JOptionPane.INFORMATION_MESSAGE);
				}								
			}
		});
		btnEliminar.setForeground(new Color(255, 0, 0));
		btnEliminar.setBounds(373, 7, 89, 23);
		panel.setLayout(null);
		
		panel.add(btnModificar);
		panel.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(model.getDataSource().size() == 0)
				{
					JOptionPane.showMessageDialog(null, "No se encontraron electrodomesticos según los criterios ingresados.", "Atención", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					ListarTabla();
				}
			}
		});
		btnActualizar.setBounds(53, 7, 101, 23);
		panel.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(527, 7, 89, 23);
		panel.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal.lisAbierto = false;
			}
		});
	}

	private void ListarTabla() {
		try
		{			
			model = new xTableModelElectrodomesticos(txtMin.getText(),txtMax.getText(),(Character)cmbConsumo.getSelectedItem());
			table.setModel(model);
			for(int i = 0; i < model.getColumnCount(); i++)
			{
				table.getColumnModel().getColumn(i).setResizable(false);
			}
		}
		catch (NumberFormatException ne)
		{
			JOptionPane.showMessageDialog(null, "Verifique que los números ingresados como mínimo y máximo sean válidos.", "Error en el formato de números.", JOptionPane.ERROR_MESSAGE);
		}
	}	

	private Electrodomestico DevolverElectroSeleccionado(int i) {
		
		return model.getDataSource().get(i);
	}
}
