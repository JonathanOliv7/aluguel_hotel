package entitites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private String name;
	private String email;
	private Date dateBirth;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Customer() {
	}
	public Customer(String name, String email, Date dateBirth) {
		this.name = name;
		this.email = email;
		this.dateBirth = dateBirth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	public String toString() {
		return "Nome: " + name + " - Data de nascimento(" + sdf.format(dateBirth) + ")" + " - Email: "+ email + "\n";
	}
}
