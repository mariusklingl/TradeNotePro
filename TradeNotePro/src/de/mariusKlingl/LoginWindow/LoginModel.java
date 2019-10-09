package de.mariusKlingl.LoginWindow;
import java.sql.ResultSet;
import java.sql.Statement;
import de.mariusKlingl.Database.DatabaseConnector;

public class LoginModel {
	
	private Statement statement;
	
	DatabaseConnector dbConnection = new DatabaseConnector();
	
	
	public boolean checkLoginInfo(String username, String password) {
		
		System.out.println(username+" "+password );
		
		if (dbConnection.createConnection()==1) {
				
				statement = dbConnection.getStatement();
		}else {
			System.out.println("Error creationg connection");
			
			return false;
		}
		
		try {
			
			String sql = "SELECT * from konto WHERE username='"+username+"' AND passwort='"+password+"'";
			ResultSet loginInfo = statement.executeQuery(sql);
			if (loginInfo.next()) {
				System.out.println("Logindaten Korrekt");
				return true;
			}else {
				return false;
			}
			
			
		} catch (Exception e) {
			System.out.println("Error checking Login Data");
			return false;
		}
	}
	
	
	
	
	public boolean checkEmaiInDatabase(String email) {
		if (dbConnection.createConnection()==1) {
			
			statement = dbConnection.getStatement();
	}else {
		System.out.println("Error creationg connection");
		return false;
	}
	
	try {
		
		String sql = "SELECT * from konto WHERE email='"+email+"'";
		ResultSet loginInfo = statement.executeQuery(sql);
		if (loginInfo.next()) {
			System.out.println("Diese Email gibt es schon");
			return false;
		}else {
			System.out.println("Email noch nicht vorhanden, gut");
			return true;
		}
		
		
	} catch (Exception e) {
		System.out.println("Error checking Login Data");
		return false;
	}
	
		
	}
	
	public boolean checkUserNameInDatabse(String username) {
		
		if(dbConnection.createConnection()==1) {
			statement = dbConnection.getStatement();
		}else {
			System.out.println("Error creating connection");
		}
		
		
		try {
		String sql = "SELECT * from konto WHERE username='"+username+"'";
		ResultSet loginInfo = statement.executeQuery(sql);
		
		if (loginInfo.next()) {
			System.out.println("Username vergeben");
			return false;
		}else {
			System.out.println("Username noch frei, gut");
			return true;	
		}
		
	} catch (Exception e) {
		System.out.println("Error checking Login Data");
		return false;
	}	
	}
	
	
	
	public boolean createMember(String username, String email, String password) {
		
		if(dbConnection.createConnection()==1) {
			statement = dbConnection.getStatement();
		}else {
			System.out.println("Error creating Statment");
		}
		
		try {
			String sql = "INSERT INTO konto (username,email,passwort) VALUES('"+username+"','"+email+"','"+password+"')";
			statement.execute(sql);
			System.out.println("Konto erfolgreich angelegt");
			return true;
			
		} catch (Exception e) {
			System.out.println("Fehler beim anlegen");
			return false;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
