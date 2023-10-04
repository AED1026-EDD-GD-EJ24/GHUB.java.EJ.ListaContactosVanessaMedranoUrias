package negocios;
import datos.Contacto;
/*Clase que representa una lista de contactos*/
import datos.Lista;
import datos.PosicionIlegalException;

public class ListaDeContactos {
	//Atributos
	private Lista<Contacto> contactos;
	//Método
	
	//Constructors
	public ListaDeContactos() {
		contactos = new Lista<Contacto>();
	}
	
	//Retorna una lista de todos los contactos
	public Lista<Contacto> mostrarTodosLosContactos(){
		try {
		for (int i=0;i<contactos.getTamanio();i++) {
			System.out.print("Num: "+i+"-> ");
			System.out.println(contactos.getValor(i).getNombres()+" "+
			                       contactos.getValor(i).getApellidos()+ " "+
					               contactos.getValor(i).getDireccion()+ " "+
			                       contactos.getValor(i).getCelular());
		}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return contactos;
	}
	
	/*
	 * Agregar un nuevo contacto a la lista, si todavía no hay
	 * ningun contacto
	 * con los nombres y apellidos dados
	 * @throws PosicionIlegalException
	 */
	public boolean agregarContacto(String nombres, 
	    String apellidos, String direccion, String correo,
		String telefono,String celular) throws PosicionIlegalException{
		Contacto con = buscarContacto(nombres,apellidos);
		if (con==null) //se puede agregar el contacto
		{
			Contacto nuevo = new Contacto(nombres,apellidos,
					direccion,correo,telefono,celular);
			contactos.agregar(nuevo);
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 *Elimina un contacto dado sus nombres y su apellido
	 *Si el usuario existe en la lista se elimina si no
	 *se pudo eliminar el contacta retorna falso 
	 */
	public boolean eliminarContacto(String nombres, String 
	    apellidos) throws PosicionIlegalException{
	    	Contacto con = buscarContacto(nombres,apellidos);
	    	if (con != null){
	    		for(int i=0;i<this.contactos.getTamanio();i++) {
	    			Contacto contAux = contactos.getValor(i);
	    			if (contAux.getNombres().equals(nombres) &&
	    			contAux.getApellidos().equals(apellidos))
	    			{
	    				contactos.remover(i);
	    			}
	    			
	    		}return true;
	    		
	    	}else 
	    		return false;
	}
	
	/*
	 * Modificar los datos de un contacto dando sus nombres y
	 * apellidos. Si el usuario existe se modifican los datos 
	 * regresa true si se pudo modificar y falso si no se pudo
	 *  modificar
	 */
	public boolean modificarContacto(String nombres,String apellidos,
			String direccion,String correo,String telefono,
			String celular) throws PosicionIlegalException{
		//verifica si el contacto existr
		Contacto con = buscarContacto(nombres,apellidos);
		if (con==null) {
			return false;
		}
		//modifica el contacto con los nuevos datos
		con.setNombres(nombres);
		con.setApellidos(apellidos);
		con.setDireccion(direccion);
		con.setCorreo(correo);
		con.setTelefono(telefono);
		con.setCelular(celular);
		return true;
		
	}
	/*
	 * Busca un contacto dado sus nombres y apellidos
	 * retorna el contacto si lo encuentra y null si no 
	 * lo encuentra
	 */
	public Contacto buscarContacto(String nombres,String apellidos) 
	    throws PosicionIlegalException{
		for (int i=0;i<contactos.getTamanio();i++) {
			Contacto con = contactos.getValor(i);
			if(nombres.equals(con.getNombres()) && 
					apellidos.equals(con.getApellidos())) {
				return con;
			}
		}
		return null; // no lo encontro, devuelve nula
	}
	

	@Override
	public String toString() {
		return "ListaDeContactos [contactos=" + contactos.getTamanio() + "]";
	}
	public int tamanio() {
		return contactos.getTamanio();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

