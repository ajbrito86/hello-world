package proyectoJTable.conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import proyectoJTable.domain.Persona;

public class Conexion {

	Connection conn;
	Statement instruccion;
	PreparedStatement psInsertar;
	CallableStatement llamador;

	
	//*******************************************************************
	
	public Conexion() {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/sdqcurso?user=root&password=");
			instruccion = conn.createStatement();

			// JOptionPane.showMessageDialog(null, "Conexion exitosa");

		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}

	} // fin de constructor

	public void agregar(Persona persona) 
	{
		try {
			/* esta es otra forma de hacerlo
			instruccion.execute("insert into Persona(Nombre,Apellido) values ('"
							+ persona.getNombre() + "','"
							+ persona.getApellido() + "')");*/
			
			psInsertar = conn.prepareStatement("insert into Persona(Nombre,Apellido) values(?,?)");
			psInsertar.setString(1, persona.getNombre());
			psInsertar.setString(2, persona.getApellido());
			psInsertar.execute();
			JOptionPane.showMessageDialog(null, "Registro Anadido con Exito");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
	} // fin de agregar

	public ArrayList<Persona> mostrar() 
	{
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		ResultSet resultado = null;

		try {
			// otra manera de hacerlo directo
			// resultado = instruccion.executeQuery("select id,nombre,apellido from Persona");
            
			llamador = conn.prepareCall("{call sp_buscarInformacion}");
            resultado = llamador.executeQuery();
			
            while (resultado.next()) 
            {
				listaPersonas.add(new Persona(resultado.getInt("id"), resultado
						.getString("Nombre"), resultado.getString("Apellido")));

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}

		return listaPersonas;

	} // fin de mostrar

	public void eliminar(int id) {
		try {
			instruccion.execute("delete from persona where id=" + id);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
	} // fin de eliminar

} // fin de la clase
