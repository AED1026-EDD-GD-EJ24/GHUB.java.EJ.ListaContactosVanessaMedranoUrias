package uI;
import java.util.Scanner;

import datos.Contacto;
import negocios.ListadeContactos;

public class Interfaz {
	static Scanner entrada = new  Scanner(System.in);
	static ListadeContactos ldc = new ListadeContactos();
	public static void lectura() {
		System.out.println("Bienvenido");
		System.out.println("Por favor, escoja una de las siguientes opciones");
		System.out.println("Para acceder a la opcion, escriba el número");
		//por implementar
		imprimirMenu();			
	}
	private static void imprimirMenu() {
		System.out.println("Por favor, escoja una de las siguientes opciones");
		System.out.println("Para acceder a la opcion, escriba el número");
		System.out.println("****** MENU PRINCIPAL ******");
		System.out.println("1.- Ingresar Nuevo Contacto");
		System.out.println("2.- Mostrar Contactos");
		System.out.println("3.- Modificar Contacto");
		System.out.println("4.- Eliminar Contacto");
		System.out.println("5.- Salir");
		System.out.println("*****************************");
		int opcion = entrada.nextInt();
		switch  (opcion) {
		case 1:
			entrada.nextLine(); // solo limpia la cadena Scanner
			validarAlta(); // si los datos que ingresa el usuario tiene el formato correcto
			break;
		case 2:
			// mostrar todos los contactos
			mostrarContactos();
			break;
		case 3:
			//modificar un contacto
			entrada.nextLine(); // solo limpia la cadena Scanner
			validarCambio();
			break;
		case 4:
			//Eliminar un contactoentrada.nextLine(); // solo limpia la cadena Scanner
			entrada.nextLine(); // solo limpia la cadena Scanner
			validarBaja();
			break;
		case 5:
			salir();
			break;
		
		default:
			System.out.println("Opción invalida");
			break;		
		};
	}
	private static void salir() {
		System.out.println("Sesion Finalizada");
		System.out.println("Adios!");
		System.exit(0);
	}
	private static void validarAlta() {
		try {
			String nombres,apellidos,direccion,
			       correo,telefono,celular;
			while (true) {
				
				System.out.println("Ingresar un nuevo contacto");
				System.out.println("Por favor ingrese la información del contacto");
				System.out.println("El nombre debe contener entre 3 y 10 caracteres");
				System.out.println("y el celular debe contener exactamento 10 números");
				System.out.println("Los nombres y apellidos no pueden repetirse");
				
				System.out.print("NOMBRES:");
				
				nombres = entrada.nextLine();
				
				System.out.print("APELLIDOS:");
				apellidos = entrada.nextLine();
	
				if (ldc.buscarContacto(nombres, apellidos)!=null) //se puede agregar el contacto
				{
					System.out.println("Ya existe un contacto con ese nombre y apellido");
					System.out.println("Si desea agregar nuevamente un contacto");
					System.out.println("Ingrese un nuevo nombre y apellido");
				}
				else
				{
					break;
				}
			}
			System.out.print("DOMICILIO:");
			direccion = entrada.nextLine();
			System.out.print("CORREO:");
			correo = entrada.nextLine();
			System.out.print("TELÉFONO:");
			telefono = entrada.nextLine();
			System.out.print("CELULAR:");
			celular = entrada.nextLine();

			if (ldc.agregarContacto(nombres, apellidos, direccion,
					correo, telefono, celular))
			{
				System.out.println("Exito Agregado a la lista de contacto");	
			}
			else
			{
				System.out.println("No se Agrego");
				System.out.println("Si desea agregar nuevamente un contacto");
				System.out.println("Seleccione la opcion 1");	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    imprimirMenu();
	}
	private static void mostrarContactos() {
		System.out.println("Total de elementos: "+ldc.tamanio());
		ldc.mostrarTodosLosContactos();
		imprimirMenu();
		
	}
	private static void validarCambio() {
		try {
			String nombres,apellidos,direccion,
			       correo,telefono,celular;
			while (true) {
				System.out.println("Modificar un contacto");
				System.out.println("Por favor ingrese la información del contacto");
				System.out.println("El nombre y apellido deben existir");
				System.out.print("NOMBRES:");
				nombres = entrada.nextLine();
				System.out.print("APELLIDOS:");
				apellidos = entrada.nextLine();
				if (ldc.buscarContacto(nombres, apellidos) == null) 
				{
					System.out.println("Contacto No Existe");				
				}
				else
				{
					break;
				}
			}
			System.out.print("DOMICILIO:");
			direccion = entrada.nextLine();
			System.out.print("CORREO:");
			correo = entrada.nextLine();
			System.out.print("TELÉFONO:");
			telefono = entrada.nextLine();
			System.out.print("CELULAR:");
			celular = entrada.nextLine();
			if (ldc.modificarContacto(nombres, apellidos, direccion, correo, telefono, celular))
			{
				System.out.println("Modificación Exitosa");
				System.out.println("Lista de Contactos");
				ldc.mostrarTodosLosContactos();
			}
			else
			{
				System.out.println("No se puedo Modificar Contacto");
				System.out.println("Si desea hacerlos, intente nuevamente ");
				System.out.println("Seleccione la opcion 3");	
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		imprimirMenu();
	}
	private static void validarBaja() {
		try {
			String nombres,apellidos;
			while (true) {
				System.out.println("Eliminar un contacto");
				System.out.println("Por favor ingrese la información del contacto");
				System.out.println("El nombre y apellido deben existir");
				//Contacto contacto = new Contacto();
				System.out.print("NOMBRES:");
				nombres = entrada.nextLine();
				System.out.print("APELLIDOS:");
				apellidos = entrada.nextLine();

				if (ldc.eliminarContacto(nombres, apellidos)) 
				{
					System.out.println("Contacto Eliminada");
					System.out.println("Lista de Contactos");
					ldc.mostrarTodosLosContactos();
					break;
					
					
				}
				else
				{
					
					System.out.println("No Existe un Contacto con ese nombre y apellido");
					System.out.println("Si desea eleminar un contacto");
					System.out.println("Ingrese un Contacto nombre y apellido válido");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		imprimirMenu();
	}
	


}
	

	

