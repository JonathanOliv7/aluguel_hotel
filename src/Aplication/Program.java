package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitites.Customer;
import entitites.Rent;
import entitites.Room;
import entitites.ServiceRoom;
import entitites.enums.RentalPeriod;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

//Coletar dados do cliente		
		System.out.println("Insira os dados do cliente: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de nascimento: ");
		Date dateBirth = sdf.parse(sc.nextLine());
		Customer customer = new Customer(name, email, dateBirth);
//Dados do aluguel		
		System.out.println();
		System.out.print("Quantos quartos:");
		Integer quantityRooms = sc.nextInt();
		Rent rent = new Rent(customer, new Date(), quantityRooms);

		for (int i = 0; i < quantityRooms; i++) {
			System.out.print("Digite o número do quarto: ");
			int number = sc.nextInt();
			sc.nextLine();
			Room rooms = new Room(number);

			System.out.print("Qual plano será(DAILY,WEEK, MOTHLY)");
			RentalPeriod period = RentalPeriod.valueOf(sc.nextLine().toUpperCase());
			System.out.print("Tempo: ");
			Integer quantityRent = sc.nextInt();
			ServiceRoom services = new ServiceRoom(quantityRooms, quantityRent, period, rooms);
			rent.addRoom(services);
		}
		System.out.println();
		System.out.println(rent.toString());
		sc.close();
	}

}
