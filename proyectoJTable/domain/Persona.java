package proyectoJTable.domain;

public class Persona 
{
    private int id;
	private String nombre;
	private String apellido;
	
	
	//***************************************************************
	
	public Persona()
	{} // constructor maniqui
	
	public Persona(String nombre, String apellido)
	{
		this.nombre = nombre;
		this.apellido = apellido;
	} // fin del constructor
	
	
	public Persona(int id, String nombre, String apellido)
	{
		this(nombre, apellido);
		this.id = id;
	} // fin del constructor
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
