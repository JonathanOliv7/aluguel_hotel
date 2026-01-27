package entitites;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Rent {

	private Date moment;
	private int validity;
	private Customer customer;
	private static Calendar calendar = Calendar.getInstance();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	List<ServiceRoom> services = new ArrayList<>();

	public Rent() {
	}

	public Rent(Customer customer, Date moment, int validity) {
		this.moment = moment;
		this.customer = customer;
		this.validity = validity;
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

	public String totalValidity() {

		calendar.setTime(getMoment());
		;
		for (ServiceRoom rooms : services) {

			switch (rooms.getPeriod().name()) {

			case "DAILY":
				sdf.format(calendar.getTime());
				calendar.add(Calendar.DAY_OF_MONTH, validity);

				break;
			case "WEEK":
				sdf.format(calendar.getTime());
				calendar.add(Calendar.WEEK_OF_MONTH, validity);
				break;
			case "MONTHLY":
				sdf.format(calendar.getTime());
				calendar.add(Calendar.MONTH, validity);
				break;
			}
		}
		return sdf.format(calendar.getTime());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(customer.toString());
		sb.append("Quantidade de quartos alugados: "+ services.size()  +"\n\n");
		for (ServiceRoom rooms : services) {
			sb.append(rooms.toString() + "\n");
			sb.append("Válido até: " + totalValidity() + "\n\n");

		}
		sb.append("Valor total: " + totalPrice());
		return sb.toString() + "\n";
	}

}
