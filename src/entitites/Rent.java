package entitites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Rent {

	private Date moment;
	private Customer customer;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	List<ServiceRoom> services = new ArrayList<>();

	public Rent() {
	}

	public Rent(Customer customer, Date moment) {
		this.moment = moment;
		this.customer = customer;
	
	}

	public Customer getClient() {
		return customer;
	}

	public void setClient(Customer customer) {
		this.customer = customer;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public List<ServiceRoom> getServices() {
		return services;
	}

	public void addRoom(ServiceRoom services) {
		this.services.add(services);
	}

	public void removeRoom(ServiceRoom services) {
		this.services.remove(services);
	}

	public double totalPrice() {
		double total = 0;
		for (ServiceRoom rooms : services) {
			total += rooms.pricePeriodRoom();
		}
		return total;
	}

	public String totalValidity(ServiceRoom room) {

		Calendar calendar = Calendar.getInstance();
		
			switch (room.getPeriod().name()) {

			case "DAILY":
				sdf.format(calendar.getTime());
				calendar.add(Calendar.DAY_OF_MONTH, room.getQuantityRent() );
				break;
				
			case "WEEK":
				sdf.format(calendar.getTime());
				calendar.add(Calendar.WEEK_OF_MONTH, room.getQuantityRent());
				break;
				
			case "MONTHLY":
				sdf.format(calendar.getTime());
				calendar.add(Calendar.MONTH, room.getQuantityRent());
				break;
			}
		
		return sdf.format(calendar.getTime());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(customer.toString());
		sb.append("Quantidade de quartos alugados: "+ services.size()  +"\n\n");
		for (ServiceRoom rooms : services) {
			sb.append(rooms.toString() + "\n");
			sb.append("Válido até: " + totalValidity(rooms) + "\n\n");

		}
		sb.append("Valor total: " + totalPrice());
		return sb.toString() + "\n";
	}

}
