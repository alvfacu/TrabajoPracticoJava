package GUI;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.Color;

import Entidades.Electrodomestico;
import Negocio.ElectrodomesticoLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Lista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private String[] columnas = {"Descripción", "Precio (U$S)", "Color", "Peso (kg)", "Consumo", "Carga (kg)", "Resol. (in)", "TDT"};
	
	private DefaultTableModel miModelo = new DefaultTableModel(null,columnas); 
	private JTextField txtMin;
	private JTextField txtMax;
	private JComboBox cmbConsumo;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnModificar;
	
	private JButton btnListar;
	
	private Character[] letras = {' ','A','B','C','D','E','F'};
	
	private ArrayList<Electrodomestico> elecs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista frame = new Lista();
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
	public Lista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Lista.class.getResource("/Icono/icono.png")));
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
		
		JPanel pnlCriterios = new JPanel();
		pnlCriterios.setBounds(10, 11, 675, 84);
		pnlCriterios.setBorder(BorderFactory.createTitledBorder("Criterios"));
		contentPane.add(pnlCriterios);
		pnlCriterios.setLayout(null);
		
		JLabel lblRangoDeImportes = new JLabel("Rango de importes");
		lblRangoDeImportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRangoDeImportes.setBounds(34, 22, 124, 14);
		pnlCriterios.add(lblRangoDeImportes);
		
		txtMin = new JTextField();
		txtMin.setToolTipText("M\u00EDnimo");
		txtMin.setBounds(181, 19, 86, 20);
		pnlCriterios.add(txtMin);
		txtMin.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(277, 22, 28, 14);
		pnlCriterios.add(label);
		
		txtMax = new JTextField();
		txtMax.setToolTipText("M\u00E1ximo");
		txtMax.setBounds(315, 19, 86, 20);
		pnlCriterios.add(txtMax);
		txtMax.setColumns(10);
		
		JLabel lblConsumo = new JLabel("Consumo energ\u00E9tico");
		lblConsumo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumo.setBounds(34, 54, 124, 14);
		pnlCriterios.add(lblConsumo);
		
		cmbConsumo = new JComboBox(letras);
		cmbConsumo.setBounds(181, 51, 52, 20);
		pnlCriterios.add(cmbConsumo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPrincipal.lisAbierto = false;
			}
		});
		btnCancelar.setBounds(576, 50, 89, 23);
		pnlCriterios.add(btnCancelar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar();
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		btnListar.setBounds(477, 50, 89, 23);
		pnlCriterios.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 675, 487);
		contentPane.add(scrollPane);
		
		table = new JTable(miModelo);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 604, 675, 38);
		contentPane.add(panel);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{											
				int i = table.getSelectedRow();
				Electrodomestico el = DevolverElectroSeleccionado(i);
				new AltaElectro(el).setVisible(true);
				btnActualizar.setEnabled(true);
			}
		});
		btnModificar.setForeground(new Color(0, 128, 0));
		btnModificar.setBounds(477, 0, 89, 23);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{				
				int i = table.getSelectedRow();
				Electrodomestico el = DevolverElectroSeleccionado(i);
				int confirma = JOptionPane.showConfirmDialog(null, "¿Confirma la eliminación de "+el.getTipo()+" ?", "Atención", JOptionPane.YES_NO_OPTION);
				if (JOptionPane.YES_OPTION == confirma)
				{
					JOptionPane.showMessageDialog(null, "El Electrodoméstico ha sido eliminado", "Atención", JOptionPane.INFORMATION_MESSAGE);
					new ElectrodomesticoLogic().Delete(el);
					Listar();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "El Electrodoméstico no ha sido eliminado", "Atención", JOptionPane.INFORMATION_MESSAGE);
				}						
			}
		});
		btnEliminar.setForeground(new Color(255, 0, 0));
		btnEliminar.setBounds(576, 0, 89, 23);
		panel.setLayout(null);
		
		panel.add(btnModificar);
		panel.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar();
			}
		});
		btnActualizar.setBounds(10, 0, 107, 23);
		panel.add(btnActualizar);
	}
	
	public void Listar()
	{
		LimpiarTabla();
		elecs = new ElectrodomesticoLogic().GetAll();
				
		try
		{
			for(int i = 0; i < elecs.size(); i++)
			{				
				if (!((Character)cmbConsumo.getSelectedItem() == ' '))
				{
					if((txtMin.getText().isEmpty()) && (txtMax.getText().isEmpty()))
					{
						if(elecs.get(i).getConsumo().getLetra() == (Character)cmbConsumo.getSelectedItem())
						{
							if (elecs.get(i) instanceof Entidades.Television)
							{
								String[] electroActual = {elecs.get(i).getTipo(),String.valueOf(elecs.get(i).precioFinal()),elecs.get(i).getColor().getNombre(),
										String.valueOf(elecs.get(i).getPeso()),String.valueOf(elecs.get(i).getConsumo().getLetra())," ",
										String.valueOf(((Entidades.Television)elecs.get(i)).getResolucion()), ((Entidades.Television)elecs.get(i)).getTDT()};
								miModelo.addRow(electroActual);
							}
							else if (elecs.get(i) instanceof Entidades.Lavarropas)
							{
								String[] electroActual = {elecs.get(i).getTipo(),String.valueOf(elecs.get(i).precioFinal()),elecs.get(i).getColor().getNombre(),
										String.valueOf(elecs.get(i).getPeso()),String.valueOf(elecs.get(i).getConsumo().getLetra()), String.valueOf(((Entidades.Lavarropas)elecs.get(i)).getCarga()),
										" "," "};
								miModelo.addRow(electroActual);
							}
						}
					}
					else if (!(txtMin.getText().isEmpty()) && !(txtMax.getText().isEmpty()))
					{
						if(elecs.get(i).getConsumo().getLetra() == (Character)cmbConsumo.getSelectedItem() && (elecs.get(i).precioFinal() > Float.parseFloat(txtMin.getText())) && (elecs.get(i).precioFinal() < Float.parseFloat(txtMax.getText())))
						{
							if (elecs.get(i) instanceof Entidades.Television)
							{
								String[] electroActual = {elecs.get(i).getTipo(),String.valueOf(elecs.get(i).precioFinal()),elecs.get(i).getColor().getNombre(),
										String.valueOf(elecs.get(i).getPeso()),String.valueOf(elecs.get(i).getConsumo().getLetra())," ",
										String.valueOf(((Entidades.Television)elecs.get(i)).getResolucion()), ((Entidades.Television)elecs.get(i)).getTDT()};
								miModelo.addRow(electroActual);
							}
							else if (elecs.get(i) instanceof Entidades.Lavarropas)
							{
								String[] electroActual = {elecs.get(i).getTipo(),String.valueOf(elecs.get(i).precioFinal()),elecs.get(i).getColor().getNombre(),
										String.valueOf(elecs.get(i).getPeso()),String.valueOf(elecs.get(i).getConsumo().getLetra()), String.valueOf(((Entidades.Lavarropas)elecs.get(i)).getCarga()),
										" "," "};
								miModelo.addRow(electroActual);
							}
						}
					}
				}
				else if(!(txtMin.getText().isEmpty()) && !(txtMax.getText().isEmpty()))
				{
					if((elecs.get(i).precioFinal() > Float.parseFloat(txtMin.getText())) && (elecs.get(i).precioFinal() < Float.parseFloat(txtMax.getText())))
					{
						if (elecs.get(i) instanceof Entidades.Television)
						{
							String[] electroActual = {elecs.get(i).getTipo(),String.valueOf(elecs.get(i).precioFinal()),elecs.get(i).getColor().getNombre(),
									String.valueOf(elecs.get(i).getPeso()),String.valueOf(elecs.get(i).getConsumo().getLetra())," ",
									String.valueOf(((Entidades.Television)elecs.get(i)).getResolucion()), ((Entidades.Television)elecs.get(i)).getTDT()};
							miModelo.addRow(electroActual);
						}
						else if (elecs.get(i) instanceof Entidades.Lavarropas)
						{
							String[] electroActual = {elecs.get(i).getTipo(),String.valueOf(elecs.get(i).precioFinal()),elecs.get(i).getColor().getNombre(),
									String.valueOf(elecs.get(i).getPeso()),String.valueOf(elecs.get(i).getConsumo().getLetra()), String.valueOf(((Entidades.Lavarropas)elecs.get(i)).getCarga()),
									" "," "};
							miModelo.addRow(electroActual);
						}
					}
				}
			}
		}
		catch (NumberFormatException ne)
		{
			JOptionPane.showMessageDialog(null, "Verifique que los números ingresados como mínimo y máximo sean válidos.", "Error en el formato de números", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Electrodomestico DevolverElectroSeleccionado(int indice)
	{
		elecs = new ElectrodomesticoLogic().GetAll();
		
		Electrodomestico electroBuscado = new Electrodomestico(); 
		
		for(int i = 0; i < elecs.size(); i++)
		{				
			if (!((Character)cmbConsumo.getSelectedItem() == ' '))
			{
				if((txtMin.getText().isEmpty()) && (txtMax.getText().isEmpty()))
				{
					if(elecs.get(i).getConsumo().getLetra() == (Character)cmbConsumo.getSelectedItem())
					{
						if(indice == i)
						{
							electroBuscado = elecs.get(i);
							break;
						}
					}
				}
				else if (!(txtMin.getText().isEmpty()) && !(txtMax.getText().isEmpty()))
				{
					if(elecs.get(i).getConsumo().getLetra() == (Character)cmbConsumo.getSelectedItem() && (elecs.get(i).precioFinal() > Float.parseFloat(txtMin.getText())) && (elecs.get(i).precioFinal() < Float.parseFloat(txtMax.getText())))
					{
						if(indice == i)
						{
							electroBuscado = elecs.get(i);
							break;
						}
					}
				}
			}
			else if(!(txtMin.getText().isEmpty()) && !(txtMax.getText().isEmpty()))
			{
				if((elecs.get(i).precioFinal() > Float.parseFloat(txtMin.getText())) && (elecs.get(i).precioFinal() < Float.parseFloat(txtMax.getText())))
				{
					if(indice == i)
					{
						electroBuscado = elecs.get(i);
						break;
					}
				}
			}
		}
		if (electroBuscado == null)
		{
			return null;
		}
		else
		{
			return electroBuscado;
		}
	}
	
	public void LimpiarTabla()
	{
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		while(modelo.getRowCount()>0)
			{
				modelo.removeRow(0);			
			}
	}
}
