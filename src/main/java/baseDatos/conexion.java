package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
	
    Connection conect;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conect = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios?serverTimezone=UTC","root","root");
		}
		catch (Exception ex){}
		return conect;
	}
}
