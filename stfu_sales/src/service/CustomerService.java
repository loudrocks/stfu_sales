package service;  //is datenbankunabhängig

import java.sql.Connection;
import model.CustomerAL;
import model.CustomerException;
import persistence.CustomerRepository;

public class CustomerService {
	private Connection con;
	private CustomerRepository cusRep;
	
	public CustomerService(Connection con){
		this.con = con;
		this.cusRep = new CustomerRepository();
	}
	
	public void getCustomers(CustomerAL cusAL) throws CustomerException{
		cusAL.clear();
		cusAL.addAll(cusRep.selectAll(con));
	}
}
