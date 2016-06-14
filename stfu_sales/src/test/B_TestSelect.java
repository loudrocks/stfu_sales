package test;

import connection.OracleConnection;
import model.CustomerAL;
import model.CustomerException;
import service.CustomerService;

public class B_TestSelect {
	public static void main(String[] args) {
		try{
		CustomerAL cusAL = new CustomerAL(); //create domain
		OracleConnection oracon = new OracleConnection(); //create oracleconnection
		CustomerService cusSer = new CustomerService(oracon.getConnection()); //create servicelayer
		cusSer.getCustomers(cusAL); //call service methods...
		System.out.println(cusAL); //verify
		oracon.close();
		}catch(CustomerException e){
			System.out.println(e.getMessage());
		}
	}
}