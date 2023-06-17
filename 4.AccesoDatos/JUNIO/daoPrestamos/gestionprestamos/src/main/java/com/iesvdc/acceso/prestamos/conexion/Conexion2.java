// package com.iesvdc.acceso.prestamos.conexion;

// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.util.Properties;

// /**
//  * Clase que conecta con nuestra BBDD.
//  * Deberá ser compartido por el resto de clases.
//  * Lo hacemos a partir de métodos estáticos.
//  */
// public class Conexion2 {

// 	private static Connection conexion = null;

// 	private Conexion2() {}

// 	public static Connection getConexion() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {

// 		if(conexion == null) {
// 			Properties properties = new Properties();
// 			properties.load(new FileReader("config.properties"));
// 			String nombreBBDD = properties.getProperty("DATABASE");
// 			String servidor = properties.getProperty("HOSTNAME");
// 			String puerto = properties.getProperty("PORT");
// 			String driver = properties.getProperty("DRIVER");
// 			String url = driver+"//"+servidor+":"+puerto+"/"+nombreBBDD+"?allowPublicKeyRetrieval=true&useSSL=false";
// 			String username = properties.getProperty("USERNAME");
// 			String password = properties.getProperty("PASSWORD");

// 			conexion = DriverManager.getConnection(url,username,password);
// 		}
// 		return conexion;
// 	}

// 	public static void closeConexion() throws SQLException {
// 		if(conexion != null) {
// 			conexion.close();
// 		}
// 	}


// 	public static void main(String[] args) {
// 		try {
// 			Connection conexionDB = Conexion2.getConexion();
// 			System.out.println(conexionDB);
// 		} catch (IOException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 			System.out.println("Fallo en la lectura del fichero");
// 		} catch (SQLException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 			System.out.println("Fallo en la base de datos");
// 		} catch (ClassNotFoundException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}


// 	}

// }
