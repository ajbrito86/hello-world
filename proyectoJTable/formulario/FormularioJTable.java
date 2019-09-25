package proyectoJTable.formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import proyectoJTable.domain.Persona;
import proyectoJTable.modelo.Modelo;
import proyectoJTable.sistema.Login;

public class FormularioJTable extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnGuardar;
	private JButton btnEliminar;
	Modelo modelo = new Modelo();
	private JScrollPane scrollPane;
	private JTable table;

	public FormularioJTable() {
		
		setTitle("Formulario JTable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 353);
		setResizable(false);
		setLocationRelativeTo(null);
		
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 34, 63, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(30, 70, 63, 14);
		contentPane.add(lblApellido);

		txtNombre = new JTextField();
		txtNombre.setBounds(130, 31, 151, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(130, 67, 151, 20);
		txtApellido.setColumns(10);
		contentPane.add(txtApellido);

	    btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				guardar();
			}
		});
		btnGuardar.setBounds(30, 277, 89, 27);
		contentPane.add(btnGuardar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 113, 472, 153);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);

	    btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
                    eliminar();
					
				} catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null,
							"Debe elegir la fila a eliminar si las hay");

				}
			}
		});
		btnEliminar.setBounds(146, 277, 89, 27);
		contentPane.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrar();
			}
		});
		btnSalir.setBounds(413, 277, 89, 27);
		contentPane.add(btnSalir);
		
		if (Login.bloquedora == 1)
		{
			txtNombre.setEnabled(false);
			txtApellido.setEnabled(false);
			btnGuardar.setEnabled(false);
			btnEliminar.setEnabled(false);
		}
		

	} // fin de constructor
	
	//**********************************************************************
	
	private void eliminar()
	{
		int valor = JOptionPane.showConfirmDialog(this, "Esta seguro que Desea Eliminar Registro ", "Confirmacion", JOptionPane.YES_NO_OPTION);
		if (valor == JOptionPane.YES_OPTION)
		{
			modelo.eliminar(table.getSelectedRow());
			JOptionPane.showMessageDialog(null, "Registro Eliminado");
		}
	} // fin de eliminar
	
	//**********************************************************************
	
	private void guardar()
	{
		if (txtNombre.getText().trim().equals("")
				|| txtApellido.getText().trim().equals("")) 
		{
			JOptionPane.showMessageDialog(null,
					"Nombre y Apellido Son Obligatorios");
		} else {
			modelo.agregar(new Persona(txtNombre.getText().trim(), txtApellido
					.getText().trim()));
			
			txtNombre.setText("");
			txtApellido.setText("");
			
		}	
		
	} // fin de guardar
	
	private void cerrar()
	{
		int valor = JOptionPane.showConfirmDialog(this, "Esta seguro que Desea Salir? ", "Confirmacion", JOptionPane.YES_NO_OPTION);
		if (valor == JOptionPane.YES_OPTION)
		{
		JOptionPane.showMessageDialog(null, "Hasta luego Buena Suerte");
			System.exit(0);
		}
	} // fin de cerrar
} // fin de la clase
