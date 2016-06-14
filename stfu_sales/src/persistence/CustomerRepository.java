package persistence;

import model.Customer;
import model.CustomerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class CustomerRepository {
	private final static String SQL_SELECT_ALL =
		"SELECT CUSTOMER_ID, " + 
		"FIRSTNAME, " + "CREDIT " +
		"FROM CUSTOMER"; //kein ;
	
	private PreparedStatement selectAllStatement;
	
	public List<Customer> selectAll(Connection con) throws CustomerException{
		try{
			if(selectAllStatement == null) //wird nur beim 1.mal durchgeführt
				selectAllStatement = con.prepareStatement(SQL_SELECT_ALL);
			ResultSet resultSet = selectAllStatement.executeQuery(); //zb executeUpdate = count(*)
			if(resultSet != null){
				List<Customer> customer = new ArrayList<>(1000);
				while(resultSet.next()){
					Long customer_id = resultSet.getLong(1);
					String firstname = resultSet.getString(2);
					Long credit = resultSet.getLong(3);
					customer.add(new Customer(customer_id, firstname, credit));
				}
				return customer;	
			}else{
				throw new CustomerException("could not read data from database");
			}
		}catch(SQLException e){
			throw new CustomerException("could not execute sql statement");
		}
	}
}
