package model;

public class Customer {
	private long customer_id;
	private String firstname; //first_name? :o richtet sich nach db?
	private long credit;
	
	public Customer(long customer_id, String firstname, long credit){
		setCustomer_id(customer_id);
		setFirstname(firstname);
		setCredit(credit);
	}
	
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String first_name) {
		this.firstname = first_name;
	}
	public long getCredit() {
		return credit;
	}
	public void setCredit(long credit) {
		this.credit = credit;
	}
	
}

/*@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", openingDate=" + openingDate + ", firstname=" + firstname + ", amount=" + amount
			+ ", creditlimit=" + creditlimit + "]\n";*/
