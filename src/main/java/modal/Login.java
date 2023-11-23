package modal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import baseDatos.conexion;


public class Login {

	public static int validar(String usuario, String clave) {
		Connection conect;
		conexion cnt = new conexion();
		
		PreparedStatement ps;
		ResultSet re;
		String user ="";
		int valido = 0;
		String sql = "Select * from db.usuarios where user = ? and pass ?";
		try {
		
			conect = cnt.getConnection();
			ps =conect.prepareStatement(sql);
			ps.setString(1,usuario);
			ps.setString(2,clave);
			re = ps.executeQuery();
			while(re.next()) {
				user = re.getString("usuario");
			}
			if(user.equals("admin")) {
				valido = 1;
			}
			else {valido = 0;}
		}
		catch (Exception ex){
			return valido;
		}
		return valido;
	}
}
