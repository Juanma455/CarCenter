package model;

import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public Car[] cars; 
	public AutonomousCar[] autonomousCar;
	public ElectricCar[] electricCar;
	

	public CarController() {
		cars = new Car[ TOTAL_CARS ];
		autonomousCar = new AutonomousCar[ TOTAL_CARS ];
		electricCar = new ElectricCar[ TOTAL_CARS ];
	}

	public String createCarAutonomous(String id, String licensePlate, String model, double position, double velocity){
		String msj = "";
		AutonomousCar newAutonomousCar = new AutonomousCar(id, licensePlate, model, velocity, position);
		boolean isEmpty = false;
		for(int i = 0; i < TOTAL_CARS && !isEmpty; i++){
			if(autonomousCar[i] == null){
				autonomousCar[i] = newAutonomousCar;
				isEmpty = true;
				msj = "Carro autonomo agregado.";
			}
		} 
		return msj;
	}

	public String createCarElectric(String id, String licensePlate, String model, double batteryCapacity){
		String msj = "";
		ElectricCar newElectricCar = new ElectricCar(id, licensePlate, model, batteryCapacity);
		boolean isEmpty = false;
		for(int i = 0; i < TOTAL_CARS && !isEmpty; i++){
			if(electricCar[i] == null){
				electricCar[i] = newElectricCar;
				isEmpty = true;
				msj = "Carro autonomo agregado.";
			}
		} 
		return msj;
	}

	public String calculateCollisionProbability(String id){
		String msj = "";
		int posCar = searchCarAutonomusById(id);
		for(int i = 0; i < TOTAL_CARS; i++){
			if(autonomousCar[i] != null && autonomousCar[posCar].getPosition() == autonomousCar[i].getPosition()){
				msj += "Su vehiculo con el vehiculo " + autonomousCar[i].getId() + " pueden colisionar.\n";
			}
		}
		return msj;
	}

	public int searchCarAutonomusById(String id){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i < TOTAL_CARS && !isFound; i++){
			if(autonomousCar[i] != null && autonomousCar[i].getId().equals(id)){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}

	public int searchCarElectricById(String id){
		int pos = -1;
		boolean isFound = false;
		for(int i = 0; i < TOTAL_CARS && !isFound; i++){
			if(electricCar[i] != null && electricCar[i].getId().equals(id)){
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}		

	public String calculateBatery(double batteryCapacity, String id){
		String msj = "";
		double x = 0;
		int posCar = searchCarElectricById(id);
		for(int i = 0; i < TOTAL_CARS; i++){
			if(electricCar[i] != null){
				x= electricCar[posCar].getBatteryCapacity() - ((electricCar[posCar].getBatteryCapacity() * 2)/100);
				msj = "La cantidad de km de la bateria es: " + x + "\n";
			}
		}
		return msj;

	}

}
