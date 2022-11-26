package ma.projet.connexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {
	private static Connection connexion=null;
	
	static {
		try {
			FileInputStream f = new FileInputStream("base.properties");
			Properties p = new Properties();
			p.load(f);
			String url=p.getProperty("jdbc.url");
			String login=p.getProperty("jdbc.username");
			String password=p.getProperty("jdbc.password");
			String driver=p.getProperty("jdbc.driver");
			Class.forName(driver);
			connexion= DriverManager.getConnection(url, login, password);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static Connection getConnexion() {
		return connexion;
	}
	

}
