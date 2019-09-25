package proyectoJTable.modelo;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import proyectoJTable.conexion.Conexion;
import proyectoJTable.domain.Persona;

public class Modelo extends AbstractTableModel
{

	private static final long serialVersionUID = 1L;
	
	Conexion conexion = new Conexion();
	String[] encabezados = { "Id", "Nombre", "Apellido" };
	ArrayList<Persona> lista = null;

	
	// *************************************************************

	
	public Modelo() 
	{
		lista = conexion.mostrar();
	}

	// *************************************************************

	public void agregar(Persona persona) 
	{
		conexion.agregar(persona);
		lista = conexion.mostrar();
		fireTableDataChanged();
	}

	public void eliminar(int fila) 
	{
		conexion.eliminar(lista.get(fila).getId());
		lista.remove(fila);
		fireTableRowsDeleted(fila, fila);
	}

	// ************************************************************

	@Override
	public int getColumnCount() 
	{

		return encabezados.length;
	}

	@Override
	public int getRowCount() 
	{

		return lista.size();
	}

	@Override
	public String getColumnName(int x) {

		return encabezados[x];
	}

	@Override
	public Object getValueAt(int x, int y) {
		Object o = new Object();
		Persona p = lista.get(x);

		switch (y) {
		case 0:
			o = p.getId();
			break;

		case 1:
			o = p.getNombre();
			break;
		case 2:
			o = p.getApellido();
		}
		return o;
	}

} // fin de clase modelo
