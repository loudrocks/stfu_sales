package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.CustomerException;

public class OracleConnection{
	private Connection con;
	
	public OracleConnection() throws CustomerException{
		try{
			Class.forName("oracle.jdbc.OracleDriver"); //laden driver
			open();
		}catch(ClassNotFoundException e){ //wenn treiber nicht gefunden
			throw new CustomerException("oracle driver? :o");			
		}
	}
	
	public void open() throws CustomerException{
		try{
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@192.168.180.3:1521:orcl", "batman", "oracle"); //1521,1158
			//ip(aus oracleterminal):port:instance, "connection", "pwd"
			con.setAutoCommit(false); //nicht alles autocommitn
		}catch(SQLException e){
			throw new CustomerException("could not open database connection");
		}
	}
	
	public void close() throws CustomerException{
		try{
			con.close();
		}catch(SQLException e){
			throw new CustomerException("could not close database connection");
		}
	}
	
	public Connection getConnection(){
		return con;
	}
}
