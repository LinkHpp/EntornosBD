import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Conectamos a la BD
		Conexion SQL = new Conexion();

		SQL.conectarMySQL();

		// Leemos los contactos

		menu();

		// Desconectamos de la BD
		SQL.desconectarMySQL();
	}


	public static void menu() {
		int opcion;
		do {
			opcion = menuPrint();

			switch (opcion) {
			case 1: // Ver contactos
				Agenda.imprimirTodos();
				break;

			
			 case 2: // Añadir contacto
			 
			  Agenda.agregarContacto();
			  break;
			  
			 case 3: // Eliminar contacto
				 
				 Agenda.borrarContacto();
			 break;
			 
			 case 4:
				 
				 Agenda.CambiarDatoContacto();
				 break;
			 
			case 5: // Buscar por nombre
				
				Agenda.buscarContactoNombre();
				break;
			 
			 case 6: // Buscar por teléfono

				 Agenda.buscarContactoMovil();
				 break;
			 
			 case 7: // Buscar por correo // Pedimos correo a buscar
					
				Agenda.buscarContactoEmail();
				break;
			 
			 case 8: // Búsqueda global
			 
				 Agenda.buscarContactoGlobal();
				 break;
			 case 9:
				 break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}

			System.out.println("");
		} while (opcion != 9);
	}

	public static int menuPrint() {

		System.out.println("1. Ver contactos");
		System.out.println("2. Agregar contacto.");
		System.out.println("3. Eliminar contacto.");
		System.out.println("4. Modificar contacto.");
		System.out.println("5. Buscar por nombre.");
		System.out.println("6. Buscar por teléfono");
		System.out.println("7. Buscar por correo.");
		System.out.println("8. Búsqueda global.");
		System.out.println("9. Salir.");
		System.out.print("¿Opción? ");

		int opcion = pedirIntEnRango(1, 9);

		return opcion;
	}
	
	public static int pedirIntEnRango(int min, int max) {

        Scanner in = new Scanner(System.in);
        int valor;

        do {
            valor = in.nextInt();
            if (valor < min || valor > max) {
                System.out.println("AVISO: No válido. Debe ser entre " + min + " y " + max);
                System.out.print("Vuelve a intentarlo: ");
            }
        } while (valor < min || valor > max);

        return valor;
    }
}
