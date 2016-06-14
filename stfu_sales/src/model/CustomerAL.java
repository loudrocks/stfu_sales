package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerAL{
	private List<Customer> customers;
	
	public CustomerAL(){
		customers = new ArrayList<>();
	}
	
	public void add(Customer a){
		customers.add(a);
	}
	
	public void clear(){
		customers.clear();
	}
	
	public void remove(Customer a){
		customers.remove(a);
	}
	
	public void remove(Customer... cus){
		for(Customer a: cus){
			remove(a);
		}
	}
	
	public void add(Customer...cus){
		for(Customer a: cus){
			add(a);
		}
	}
	
	public void addAll(List<Customer> cusList){
		customers.addAll(cusList);
	}
	
	public List<Customer> getCustomers(){
		return Collections.unmodifiableList(customers);
	}
	
	@Override
	public String toString(){
		return "CustomerAL [customers=" + customers +"]";
	}
}
