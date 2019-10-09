package de.mariusKlingl.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
	
	
	private final String DATABSENAME="k85506_privat";
	private final String IPADRESS="46.38.249.185:3306/";
	private final String CONNECTIONSTRING="jdbc:mysql://"+IPADRESS+DATABSENAME;
	private final String USERNAME = "k85506_privat";
	private final String PASSWORT = "12345A!";
	
	private Connection connection;
	private Statement statement;
	
	
	
	public int createConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver load error");
			return -1;
		}
		
		try {
			connection = DriverManager.getConnection(CONNECTIONSTRING, USERNAME, PASSWORT);
		} catch (SQLException e) {
			System.out.println(CONNECTIONSTRING);
			System.out.println(CONNECTIONSTRING+" "+USERNAME+" "+PASSWORT);
			System.out.println("DB Connection error");
			return -1;
		}
		
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("DB Statment creation error");
			return -1;
		}
		
		System.out.println("DB Verbindung erfolgreich");
		return 1;
	}
	
	
	public int closeConnection() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Cannot close DB connection");
			return -1;
		}
		return 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	public Connection getConnection() {
		return connection;
	}



	public void setConnection(Connection connection) {
		this.connection = connection;
	}



	public Statement getStatement() {
		return statement;
	}



	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	
	
	
	
	
	
	

}
