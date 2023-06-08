import java.sql.*;
import java.util.ArrayList;

public class Conexion {

	// public String driver = "com.mysql.cj.jdbc.Driver";
	public String driver = "org.mariadb.jdbc.Driver";
	public String database = "AGENDA";
	public String hostname = "localhost";
	public String port = "3306";
	// public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
	// + "?useSSL=false";
	public String url = "jdbc:mariadb://" + hostname + ":" + port + "/" + database + "?useSSL=false";
	public String username = "usr_agenda";
	public String password = "pwd1234";
	public static Connection conn = null;

	public void conectarMySQL() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("[!] Estás conectado a la BD");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("[!] No se ha podido conectar con la BD. Detalles: ");
			e.printStackTrace();
		}
	}

	public void desconectarMySQL() {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("[!] Estás desconectado de la BD");
			}
		} catch (SQLException e) {
			System.out.println("[!] No se ha podido desconectar con la BD. Detalles: ");
			e.printStackTrace();
		}
	}

	public static ArrayList<Contacto> leerContactosDesdeBD() {
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		Contacto contactoActual;
		try {
			Statement stmt = conn.createStatement();
			String consulta = "SELECT * FROM CONTACTS";
			ResultSet res = stmt.executeQuery(consulta);
			while (res.next()) {
				contactoActual = new Contacto(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
				contactos.add(contactoActual);
			}
		} catch (SQLException e) {
			System.out.println("[!] No se ha podido leer el contacto. Detalles: ");
			e.printStackTrace();
		}
		return contactos;
	}

	public static void addUser(String fullname, String telephone, String email) {

		try {
			String sql = " insert into contacts (fullname, telephone, email)" + " values (?, ?, ?)";
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, fullname.toUpperCase());
			preparedStmt.setString(2, telephone);
			preparedStmt.setString(3, email.toUpperCase());
			
			
			// execute the preparedstatement
		      preparedStmt.execute();
		      
			System.out.println("[*] Contacto creado");

		      		      
		      
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}

	}
	
	public static void delUser(String fullname) {
		
		try {
			String query = "delete from contacts where fullname = ?";
		    PreparedStatement preparedStmt = conn.prepareStatement(query);
		    preparedStmt.setString(1, fullname);
		      
		    preparedStmt.execute();
		    
		    System.out.println("[*] Contacto borrado");
		}catch (Exception e){
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		}
		
	}
	
	public static ArrayList<Contacto> srchUserNm(String fullname){
		
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		Contacto contactoActual;
		try {
			String consulta = "SELECT fullname, telephone, email FROM CONTACTS where fullname = ?";
		    PreparedStatement preparedStmt = conn.prepareStatement(consulta);
		    preparedStmt.setString(1, fullname.toUpperCase());
		      
			ResultSet res = preparedStmt.executeQuery();

			while (res.next()) {
				contactoActual = new Contacto(res.getString(1), res.getString(2), res.getString(3));
				contactos.add(contactoActual);
			}
		} catch (SQLException e) {
			System.out.println("[!] No se ha podido leer el contacto. Detalles: ");
			e.printStackTrace();
		}
		return contactos;
	}
	public static ArrayList<Contacto> srchUserTf(String telephone){
		
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		Contacto contactoActual;
		try {
			String consulta = "SELECT fullname, telephone, email FROM CONTACTS where telephone = ?";
		    PreparedStatement preparedStmt = conn.prepareStatement(consulta);
		    preparedStmt.setString(1, telephone.toUpperCase());
		      
			ResultSet res = preparedStmt.executeQuery();

			while (res.next()) {
				contactoActual = new Contacto(res.getString(1), res.getString(2), res.getString(3));
				contactos.add(contactoActual);
			}
		} catch (SQLException e) {
			System.out.println("[!] No se ha podido leer el contacto. Detalles: ");
			e.printStackTrace();
		}
		return contactos;
	}
	public static ArrayList<Contacto> srchUserEmail(String email){
		
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		Contacto contactoActual;
		try {
			String consulta = "SELECT fullname, telephone, email FROM CONTACTS where email = ?";
		    PreparedStatement preparedStmt = conn.prepareStatement(consulta);
		    preparedStmt.setString(1, email.toUpperCase());
		      
			ResultSet res = preparedStmt.executeQuery();

			while (res.next()) {
				contactoActual = new Contacto(res.getString(1), res.getString(2), res.getString(3));
				contactos.add(contactoActual);
			}
		} catch (SQLException e) {
			System.out.println("[!] No se ha podido leer el contacto. Detalles: ");
			e.printStackTrace();
		}
		return contactos;
	}
	public static ArrayList<Contacto> srchUserGb(String text){
		
		ArrayList<Contacto> contactos = new ArrayList<Contacto>();
		Contacto contactoActual;
		try {
			String consulta = "SELECT fullname, telephone, email FROM CONTACTS where email = ? or fullname = ? or telephone = ?";
		    PreparedStatement preparedStmt = conn.prepareStatement(consulta);
		    preparedStmt.setString(1, text.toUpperCase());
		    preparedStmt.setString(2, text.toUpperCase());
		    preparedStmt.setString(3, text.toUpperCase());
		      
			ResultSet res = preparedStmt.executeQuery();

			while (res.next()) {
				contactoActual = new Contacto(res.getString(1), res.getString(2), res.getString(3));
				contactos.add(contactoActual);
			}
		} catch (SQLException e) {
			System.out.println("[!] No se ha podido leer el contacto. Detalles: ");
			e.printStackTrace();
		}
		return contactos;
	}
	public static void changeUser(String data, int id, int option) {
		try
	    {
	    
	      // create the java mysql update preparedstatement
		      String query = "0";

			
			
			switch(option) {
				case 1:
				      query = "update contacts set fullname = ? where contactid = ?";
					break;
				case 2:
				      query = "update contacts set telephone = ? where contactid = ?";
					break;
				case 3:
				      query = "update contacts set email = ? where contactid = ?";
					break;
			}
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, data.toUpperCase());
	      preparedStmt.setInt   (2, id);

	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();

	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }
	
}
