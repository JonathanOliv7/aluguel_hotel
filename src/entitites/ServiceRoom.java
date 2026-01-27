package entitites;

import entitites.enums.RentalPeriod;


public class ServiceRoom {
	private Integer quantityRooms;
	private Integer quantityRent;
	private RentalPeriod period;
	private Room rooms;	
	public ServiceRoom() {
	}

	public ServiceRoom(Integer quantityRooms, Integer quantityRent, RentalPeriod period, Room rooms) {
		this.quantityRooms = quantityRooms;
		this.quantityRent = quantityRent;
		this.period = period;
		this.rooms = rooms;
		
	}

	public Integer getQuantityRooms() {
		return quantityRooms;
	}

	public void setQuantityRooms(Integer quantityRooms) {
		this.quantityRooms = quantityRooms;
	}

	public Integer getQuantityRent() {
		return quantityRent;
	}

	public void setQuantityRent(Integer quantityRent) {
		this.quantityRent = quantityRent;
	}

	public RentalPeriod getPeriod() {
		return period;
	}

	public void setPeriod(RentalPeriod period) {
		this.period = period;
	}

	public Room getRooms() {
		return rooms;
	}

	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}
	public double pricePeriodRoom() {
		double price = 0;
		switch(period.name()) {
		case "DAILY":
			price = 120 * quantityRent;
			break;
		case "WEEK": 
			price = 750 * quantityRent;
			break;
		case "MONTHLY":
		price = 2500 * quantityRent;
			break;
		}	return price;
		} 
	
	public String toString() {
		return "Número: " + rooms.getNumber() +"\nPrice do quarto: $" + pricePeriodRoom() + "\nSituação: Alugado" ;
		
	}
}
