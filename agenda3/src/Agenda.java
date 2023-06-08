import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {

	
	public static void imprimirTodos() {
		
		ArrayList<Contacto> listadoDeContactos = new ArrayList<Contacto>();

		listadoDeContactos = Conexion.leerContactosDesdeBD();

		if (listadoDeContactos.isEmpty() == true) {
			System.out.println("[!] Listamos todos los contactos (no encontramos ninguno)");
		} else {
			System.out.println("[*] Listamos todos los contactos (encontramos " + listadoDeContactos.size() + ")");

			// Recorremos el arraylist
			for (int i = 0; i < listadoDeContactos.size(); i++) {
				// Extraemos el contacto del ArrayList
				Contacto contactoActual = Conexion.leerContactosDesdeBD().get(i);
				// Imprimimos el contacto

				System.out.print("	=> ");
				contactoActual.imprimir();
			}
		}
	}
	
	
	public static void agregarContacto() {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Introduzca el nombre del usuario: ");
		String fullname = in.nextLine();
		
		System.out.print("Introduzca el telefono del contacto: ");
		String telephone = in.nextLine();
		
		System.out.print("Introduzca el email del contacto: ");
		String email = in.nextLine();
		
		Conexion.addUser(fullname, telephone, email);
		
	}
	
	public static void borrarContacto() {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Introduzca el nombre del usuario que quiera borrar: ");
		String fullname = in.nextLine();
		
		Conexion.delUser(fullname);
		
	}
	public static void buscarContactoNombre() {
		
		
		Scanner in = new Scanner(System.in);
		ArrayList<Contacto> listadoDeContactos = new ArrayList<Contacto>();

		
		System.out.print("Introduzca el nombre del usuario que quieras buscar: ");
		String fullname = in.nextLine();
		

		listadoDeContactos = Conexion.srchUserNm(fullname);

		if (listadoDeContactos.isEmpty() == true) {
			System.out.println("[!] Listamos todos los contactos (no encontramos ninguno)");
		} else {
			System.out.println("[*] Listamos todos los contactos (encontramos " + listadoDeContactos.size() + ")");

			// Recorremos el arraylist
			for (int i = 0; i < listadoDeContactos.size(); i++) {
				// Extraemos el contacto del ArrayList
				Contacto contactoActual = Conexion.srchUserNm(fullname).get(i);
				// Imprimimos el contacto

				System.out.print("	=> ");
				contactoActual.imprimir();
			}
		}
		
	}
	
	public static void buscarContactoMovil() {
			
			
			Scanner in = new Scanner(System.in);
			ArrayList<Contacto> listadoDeContactos = new ArrayList<Contacto>();
	
			
			System.out.print("Introduzca el teléfono del usuario que quieras buscar: ");
			String telephone = in.nextLine();
			
	
			listadoDeContactos = Conexion.srchUserTf(telephone);
	
			if (listadoDeContactos.isEmpty() == true) {
				System.out.println("[!] Listamos todos los contactos (no encontramos ninguno)");
			} else {
				System.out.println("[*] Listamos todos los contactos (encontramos " + listadoDeContactos.size() + ")");
	
				// Recorremos el arraylist
				for (int i = 0; i < listadoDeContactos.size(); i++) {
					// Extraemos el contacto del ArrayList
					Contacto contactoActual = Conexion.srchUserTf(telephone).get(i);
					// Imprimimos el contacto
	
					System.out.print("	=> ");
					contactoActual.imprimir();
				}
			}
			
	}
	public static void buscarContactoEmail() {
		
		
		Scanner in = new Scanner(System.in);
		ArrayList<Contacto> listadoDeContactos = new ArrayList<Contacto>();

		
		System.out.print("Introduzca el email del usuario que quieras buscar: ");
		String email = in.nextLine();
		

		listadoDeContactos = Conexion.srchUserEmail(email);

		if (listadoDeContactos.isEmpty() == true) {
			System.out.println("[!] Listamos todos los contactos (no encontramos ninguno)");
		} else {
			System.out.println("[*] Listamos todos los contactos (encontramos " + listadoDeContactos.size() + ")");

			// Recorremos el arraylist
			for (int i = 0; i < listadoDeContactos.size(); i++) {
				// Extraemos el contacto del ArrayList
				Contacto contactoActual = Conexion.srchUserEmail(email).get(i);
				// Imprimimos el contacto

				System.out.print("	=> ");
				contactoActual.imprimir();
			}
		}
		
}
	
	public static void buscarContactoGlobal() {
		
		
		Scanner in = new Scanner(System.in);
		ArrayList<Contacto> listadoDeContactos = new ArrayList<Contacto>();

		
		System.out.print("Introduzca el dato del usuario que quieras buscar: ");
		String text = in.nextLine();
		

		listadoDeContactos = Conexion.srchUserGb(text);

		if (listadoDeContactos.isEmpty() == true) {
			System.out.println("[!] Listamos todos los contactos (no encontramos ninguno)");
		} else {
			System.out.println("[*] Listamos todos los contactos (encontramos " + listadoDeContactos.size() + ")");

			// Recorremos el arraylist
			for (int i = 0; i < listadoDeContactos.size(); i++) {
				// Extraemos el contacto del ArrayList
				Contacto contactoActual = Conexion.srchUserGb(text).get(i);
				// Imprimimos el contacto

				System.out.print("	=> ");
				contactoActual.imprimir();
			}
		}
		
}
	public static void CambiarDatoContacto() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("1. Nombre");
		System.out.println("2. Numero de telefono");
		System.out.println("3. Email");
		System.out.print("Eliga que dato quiera cambiar: ");
		
		int opcion = in.nextInt();
		
		
		System.out.print("Eliga el usuario que quiera cambiar mediante su ID: ");
		int id = in.nextInt();
		
		in.nextLine();
		
		System.out.print("Introduzca el nuevo dato: ");
		String data = in.nextLine();
		
		Conexion.changeUser(data, id, opcion);
		


		
		
		
		
		/*Scanner in = new Scanner(System.in);
		ArrayList<Contacto> listadoDeContactos = new ArrayList<Contacto>();

		
		System.out.print("Introduzca el dato del usuario que quieras buscar: ");
		String text = in.nextLine();
		

		listadoDeContactos = Conexion.srchUserGb(text);

		if (listadoDeContactos.isEmpty() == true) {
			System.out.println("[!] Listamos todos los contactos (no encontramos ninguno)");
		} else {
			System.out.println("[*] Listamos todos los contactos (encontramos " + listadoDeContactos.size() + ")");

			// Recorremos el arraylist
			for (int i = 0; i < listadoDeContactos.size(); i++) {
				// Extraemos el contacto del ArrayList
				Contacto contactoActual = Conexion.srchUserGb(text).get(i);
				// Imprimimos el contacto

				System.out.print("	=> ");
				contactoActual.imprimir();
			}
		}*/
		
}
	
	
	
	
	
	
}
