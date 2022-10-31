package ui;

import model.*;
import java.util.Scanner;

public class Main {

	private CarController controller;
	private Scanner reader;

	public Main() {
		controller = new CarController();
		reader = new Scanner(System.in);

	}

	public static void main(String[] args) {

		// creación del objeto. 
		Main main = new Main(); 
		// llamdo a uno de los metodos de la clase. 
		int option = 0; 

		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

		main.getReader().close();

	}

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Store >>>>>");
		System.out.println(
				"1. agregar un carro autonomo nuevo.\n" +
				"2. agregar un carro electrico nuevo.\n" +
				"3. calcular probabilidad de colision. \n" +
				"4. calcular estado de la bateria \n" +
				"0. Exit. \n");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 
		double batteryCapacity = 0;

		switch(option){
			case 1: 
				
				System.out.println("Ingrese el id del carro: ");
				id = reader.next();
				System.out.println("Ingrese la placa del carro: ");
				licensePlate = reader.next();
				System.out.println("Ingrese el modelo del carro: ");
				model = reader.next();
				System.out.println("Ingrese la velocidad del carro: ");
				velocity = reader.nextDouble();
				System.out.println("Ingrese la posicion del carro: ");
				position = reader.nextDouble();
	
				String msj = controller.createCarAutonomous(id, licensePlate, model, velocity, position);
				System.out.println(msj + "\n");

				break;

			case 2: 

				System.out.println("Ingrese el id del carro: ");
				id = reader.next();
				System.out.println("Ingrese la placa del carro: ");
				licensePlate = reader.next();
				System.out.println("Ingrese el modelo del carro: ");
				model = reader.next();
				System.out.println("Ingrese la capacidad de la bateria del carro: ");
				batteryCapacity = reader.nextDouble();

				msj = controller.createCarElectric(id, licensePlate, model, batteryCapacity);
				System.out.println(msj + "\n");

				break; 

			case 3: 
				
				System.out.println("Ingrese el id del carro autonomo: ");
				id = reader.next();

				msj = controller.calculateCollisionProbability(id);
				System.out.println(msj);

				break; 

			case 4:

				System.out.println("Ingrese el id del carro electrico: ");
				id = reader.next();

				msj = controller.calculateBatery(batteryCapacity, id);
				System.out.println(msj);

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	public Scanner getReader(){
		return reader; 
	}

	public int validateIntegerInput(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

	public double validateDoubleInput(){
		double option = 0; 

		if(reader.hasNextDouble()){
			option = reader.nextDouble(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}



}
