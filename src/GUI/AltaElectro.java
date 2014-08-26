package GUI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.*;
import Negocio.ElectrodomesticoLogic;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaElectro extends JFrame implements ItemListener {

	/**
	 * 
	 */

	private String[] listaTipo = {"Seleccione tipo","Lavarropas","Television"};
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrecioBase;
	private JTextField txtColor;
	private JTextField txtConsumo;
	private JTextField txtCarga;
	private JTextField txtResolucion;
	private JCheckBox chcSintonizador;
	private JComboBox cmbTipo = new JComboBox(listaTipo);
	private JTextField txtPeso;
	private Electrodomestico electroActual;
	private boolean vacios;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaElectro frame = new AltaElectro();
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
	public AltaElectro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaElectro.class.getResource("/Icono/icono.png")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				VentanaPrincipal.altAbierto = false;
			}
		});
		setBounds(100, 100, 450, 300);
		setTitle("Alta electrodoméstico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 619, 337);
		setSize(334, 438);
		setLocationRelativeTo(null);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPrecioBase = new JLabel("Precio base");
		lblPrecioBase.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioBase.setBounds(15, 52, 128, 14);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setBounds(15, 19, 128, 14);
			
		cmbTipo.setBounds(162, 16, 142, 20);;
		cmbTipo.addItemListener(this);
						
		txtPrecioBase = new JTextField();
		txtPrecioBase.setBounds(162, 49, 86, 20);
		txtPrecioBase.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setBounds(15, 83, 128, 14);
		
		txtColor = new JTextField();
		txtColor.setBounds(162, 80, 142, 20);
		txtColor.setColumns(10);
		
		JLabel lblConsumoEnergtico = new JLabel("Consumo energ\u00E9tico");
		lblConsumoEnergtico.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsumoEnergtico.setBounds(15, 114, 128, 14);
		contentPane.setLayout(null);
		
		txtConsumo = new JTextField();
		txtConsumo.setBounds(162, 111, 36, 20);
		txtConsumo.setColumns(10);
		
		contentPane.add(txtConsumo);
		contentPane.add(lblTipo);
		contentPane.add(lblPrecioBase);
		contentPane.add(lblColor);
		contentPane.add(cmbTipo);
		contentPane.add(txtColor);
		contentPane.add(txtPrecioBase);
		contentPane.add(lblConsumoEnergtico);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeso.setBounds(16, 145, 129, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(162, 142, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JPanel pnlLavarropas = new JPanel();
		pnlLavarropas.setBounds(15, 178, 289, 56);
		pnlLavarropas.setBorder(BorderFactory.createTitledBorder("Lavarropas"));
		contentPane.add(pnlLavarropas);
		pnlLavarropas.setLayout(null);
		
		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setBounds(63, 24, 46, 14);
		pnlLavarropas.add(lblCarga);
		
		txtCarga = new JTextField();
		txtCarga.setBounds(149, 21, 80, 20);
		pnlLavarropas.add(txtCarga);
		txtCarga.setColumns(10);
		
		JPanel pnlTelevision = new JPanel();
		pnlTelevision.setBounds(15, 265, 289, 95);
		pnlTelevision.setBorder(BorderFactory.createTitledBorder("Televisión"));
		contentPane.add(pnlTelevision);
		pnlTelevision.setLayout(null);
		
		JLabel lblResolucin = new JLabel("Resoluci\u00F3n");
		lblResolucin.setHorizontalAlignment(SwingConstants.CENTER);
		lblResolucin.setBounds(26, 24, 87, 14);
		pnlTelevision.add(lblResolucin);
		
		txtResolucion = new JTextField();
		txtResolucion.setBounds(151, 21, 80, 20);
		pnlTelevision.add(txtResolucion);
		txtResolucion.setColumns(10);
		
		chcSintonizador = new JCheckBox("Sintonizador TDT");
		chcSintonizador.setHorizontalAlignment(SwingConstants.CENTER);
		chcSintonizador.setBounds(26, 54, 205, 23);
		pnlTelevision.add(chcSintonizador);
		
		this.txtPrecioBase.setEnabled(false);
		this.txtColor.setEnabled(false);
		this.txtConsumo.setEnabled(false);
		this.txtPeso.setEnabled(false);
		this.txtCarga.setEnabled(false);
    	this.txtResolucion.setEnabled(false);
    	this.chcSintonizador.setEnabled(false);		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				altaElectro();										
			}
		});
		btnGuardar.setBounds(61, 371, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		btnCancelar.setBounds(177, 371, 89, 23);
		contentPane.add(btnCancelar);
		
	}
	
	public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==cmbTipo) {
        	this.txtPrecioBase.setEnabled(true);
    		this.txtColor.setEnabled(true);
    		this.txtConsumo.setEnabled(true);
    		this.txtPeso.setEnabled(true);
        	this.txtCarga.setEnabled(true);
        	this.txtResolucion.setEnabled(true);
        	this.chcSintonizador.setEnabled(true);
        	
        	String seleccionado=(String)cmbTipo.getSelectedItem();
            
        	if (seleccionado == "Seleccione tipo")
            {
        		this.txtPrecioBase.setEnabled(false);
        		this.txtColor.setEnabled(false);
        		this.txtConsumo.setEnabled(false);
        		this.txtPeso.setEnabled(false);
        		this.txtCarga.setEnabled(false);
            	this.txtResolucion.setEnabled(false);
            	this.chcSintonizador.setEnabled(false);
            }
            if (seleccionado == "Lavarropas")
            {
            	this.txtResolucion.setEnabled(false);
            	this.chcSintonizador.setEnabled(false);
            }
            if (seleccionado == "Television")
            {
            	this.txtCarga.setEnabled(false);
            }
        }
    }
	
	public void altaElectro()
	{
		Component[] componentes = contentPane.getComponents(); 
		boolean alta = false;
		vacios = false;
		int rta = 0;
		
		if ("Lavarropas"==(String)cmbTipo.getSelectedItem())
		{
			vacios = comprobarCamposVacios(componentes);
			
			if (vacios)
			{
				rta = JOptionPane.showConfirmDialog(null, "Existen campos vacíos. ¿Desea dar de alta al producto de todas formas?", "CUIDADO !", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (rta == JOptionPane.YES_OPTION)
				{
					if (!(txtPeso.getText().isEmpty()) && !(txtPrecioBase.getText().isEmpty()))
					{
						try 
						{
							electroActual = new Lavarropas(Double.parseDouble(txtPrecioBase.getText()),Double.parseDouble(txtPeso.getText()));
							alta = true;
						} 
						catch (NumberFormatException e) 
						{
							JOptionPane.showMessageDialog(null, "Verifique haber ingresado datos (numéricos) correctos.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						electroActual = new Lavarropas();
						alta = true;
					}					
				}
			}
			else 
			{
				try 
				{
					electroActual = new Lavarropas(Double.parseDouble(txtPrecioBase.getText()),Double.parseDouble(txtPeso.getText()),txtColor.getText(),(txtConsumo.getText()).charAt(0), Double.parseDouble(txtCarga.getText()));
					alta = true;
				} 
				catch (NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(null, "Verifique haber ingresado datos (numéricos) correctos.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if ("Television"==(String)cmbTipo.getSelectedItem())
		{
			vacios = comprobarCamposVacios(componentes);
			if (vacios)
			{
				rta = JOptionPane.showConfirmDialog(null, "Existen campos vacíos. ¿Desea dar de alta al producto de todas formas?", "CUIDADO !", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (rta == JOptionPane.YES_OPTION)
				{
					if (!(txtPeso.getText().isEmpty()) && !(txtPrecioBase.getText().isEmpty()))
					{
						try 
						{
							electroActual = new Television(Double.parseDouble(txtPrecioBase.getText()),Double.parseDouble(txtPeso.getText()));
							alta = true;
						} 
						catch (NumberFormatException e) 
						{
							JOptionPane.showMessageDialog(null, "Verifique haber ingresado datos (numéricos) correctos.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
						}
					}
					else 
					{
						electroActual = new Television();
						alta = true;
					}
				}
			}
			else 
			{
				try 
				{
					electroActual = new Television(Double.parseDouble(txtPrecioBase.getText()),Double.parseDouble(txtPeso.getText()),txtColor.getText(),(txtConsumo.getText()).charAt(0),Double.parseDouble(txtResolucion.getText()), chcSintonizador.isSelected());
					alta = true;
				} 
				catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Verifique haber ingresado datos (numéricos) correctos.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
				}
			}
	      }
		if (alta)
		{
			GuardarCambios(electroActual);
			JOptionPane.showMessageDialog(null,electroActual.getTipo()+" guardado.", "LISTO", JOptionPane.INFORMATION_MESSAGE);
			Limpiar();			
		}
		else if (rta == JOptionPane.NO_OPTION)
		{
			JOptionPane.showMessageDialog(null, "No ha sido guardado", "LISTO", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (("Seleccione tipo para dar de alta" == (String)cmbTipo.getSelectedItem()))
		{
			JOptionPane.showMessageDialog(null, "Seleccione una opción", "ERROR", JOptionPane.ERROR_MESSAGE);
			Limpiar();
		}
	}
	
	private boolean comprobarCamposVacios(Component[] componentes) 
	{
		for(int i=0; i <componentes.length; i++)
		{
			if(componentes[i] instanceof JTextField)
			{
				if(((JTextField)componentes[i]).getText().isEmpty())
				{
					vacios = true;
				}
			}
		}
		return vacios;
	}

	public void Limpiar()
	{
		this.txtPrecioBase.setText(null);
		this.txtColor.setText(null);
		this.txtConsumo.setText(null);
		this.txtPeso.setText(null);
		this.txtCarga.setText(null);
    	this.txtResolucion.setText(null);
	}
	
	public void GuardarCambios(Electrodomestico electro)
	{
		new ElectrodomesticoLogic().Save(electro);
	}
	
	//Modificación
	
	public AltaElectro(final Electrodomestico electro)
	{
		setResizable(false);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaElectro.class.getResource("/Icono/icono.png")));
		setTitle("Modificar electrodoméstico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 619, 337);
		setSize(334, 438);
		setLocationRelativeTo(null);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPrecioBase = new JLabel("Precio base");
		lblPrecioBase.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioBase.setBounds(15, 52, 128, 14);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setBounds(15, 19, 128, 14);
				
		cmbTipo.setBounds(162, 16, 142, 20);
		cmbTipo.setToolTipText("Tipo de electrodomestico");
		
		if(electro instanceof Entidades.Lavarropas)
		{
			cmbTipo.setSelectedIndex(1);
		}
		if (electro instanceof Entidades.Television)
		{
			cmbTipo.setSelectedIndex(2);		
		}
		cmbTipo.addItemListener(this);
						
		txtPrecioBase = new JTextField();
		txtPrecioBase.setBounds(162, 49, 86, 20);
		txtPrecioBase.setColumns(10);
		txtPrecioBase.setText(String.valueOf(electro.getPrecio()));
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setBounds(15, 83, 128, 14);
		
		txtColor = new JTextField();
		txtColor.setBounds(162, 80, 142, 20);
		txtColor.setColumns(10);
		txtColor.setText(electro.getColor().getNombre());
		
		JLabel lblConsumoEnergtico = new JLabel("Consumo energ\u00E9tico");
		lblConsumoEnergtico.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsumoEnergtico.setBounds(15, 114, 128, 14);
		contentPane.setLayout(null);
		
		txtConsumo = new JTextField();
		txtConsumo.setBounds(162, 111, 36, 20);
		txtConsumo.setColumns(10);
		txtConsumo.setText(Character.toString(electro.getConsumo().getLetra()));		
		
		contentPane.add(txtConsumo);
		contentPane.add(lblTipo);
		contentPane.add(lblPrecioBase);
		contentPane.add(lblColor);
		contentPane.add(cmbTipo);
		contentPane.add(txtColor);
		contentPane.add(txtPrecioBase);
		contentPane.add(lblConsumoEnergtico);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeso.setBounds(16, 145, 129, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(162, 142, 86, 20);
		txtPeso.setColumns(10);
		txtPeso.setText(String.valueOf(electro.getPeso()));
		contentPane.add(txtPeso);
				
		JPanel pnlLavarropas = new JPanel();
		pnlLavarropas.setBounds(15, 178, 289, 56);
		pnlLavarropas.setBorder(BorderFactory.createTitledBorder("Lavarropas"));
		contentPane.add(pnlLavarropas);
		pnlLavarropas.setLayout(null);
		
		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setBounds(63, 24, 46, 14);
		pnlLavarropas.add(lblCarga);
		
		txtCarga = new JTextField();
		txtCarga.setBounds(149, 21, 80, 20);
		txtCarga.setColumns(10);
		
		if(electro instanceof Lavarropas)
		{			
			txtCarga.setText(Double.toString(((Lavarropas) electro).getCarga()));
		}
		else
		{
			txtCarga.setEnabled(false);
		}
		
		pnlLavarropas.add(txtCarga);
				
		JPanel pnlTelevision = new JPanel();
		pnlTelevision.setBounds(15, 265, 289, 95);
		pnlTelevision.setBorder(BorderFactory.createTitledBorder("Televisión"));
		contentPane.add(pnlTelevision);
		pnlTelevision.setLayout(null);
		
		JLabel lblResolucin = new JLabel("Resoluci\u00F3n");
		lblResolucin.setHorizontalAlignment(SwingConstants.CENTER);
		lblResolucin.setBounds(26, 24, 87, 14);
		
		pnlTelevision.add(lblResolucin);
		
		txtResolucion = new JTextField();
		txtResolucion.setBounds(151, 21, 80, 20);
		txtResolucion.setColumns(10);
	
		chcSintonizador = new JCheckBox("Sintonizador TDT");
		chcSintonizador.setHorizontalAlignment(SwingConstants.CENTER);
		chcSintonizador.setBounds(26, 54, 205, 23);
		
		
		if (electro instanceof Television)
		{
			txtResolucion.setText(Double.toString(((Television) electro).getResolucion()));
			chcSintonizador.setSelected(((Television) electro).getSintonizadorTDT());
		}
		else
		{
			txtResolucion.setEnabled(false);
			chcSintonizador.setEnabled(false);
		}	
		
		pnlTelevision.add(txtResolucion);
		pnlTelevision.add(chcSintonizador);	
		
		JButton btnGuardar = new JButton("Modificar");
		btnGuardar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{				
				altaElectro();
				new ElectrodomesticoLogic().Delete(electro);
				dispose();
			}
		});
		btnGuardar.setBounds(61, 371, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();			
			}
		});
		btnCancelar.setBounds(177, 371, 89, 23);
		contentPane.add(btnCancelar);
	}

}
