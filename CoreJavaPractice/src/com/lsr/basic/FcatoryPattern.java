package com.lsr.basic;

 interface Car{
	 String getModel(String s);
}

class Mazda implements Car{
	
	

	public String getModel(String s) {
		// TODO Auto-generated method stub
		return "cx-5";
	}
	
}
class toyota implements Car{
	
	public String getModel(String s) {
		// TODO Auto-generated method stub
		return "RAV4";
	}
	
}

class CarFcatory{
	
	
	public Car getModel(String s) {
		
		switch(s) {
		case "Mazda": return new Mazda();
		case "toyota": return new toyota();
		}
		return null;

	}
	
}


public class FcatoryPattern {
	
	
	public static void main(String[] args) {
		
		// partial dependency 
		Car carMazda = new Mazda();
		System.out.println(carMazda.getModel("Mazda"));

		CarFcatory cf = new CarFcatory();
		Car car = cf.getModel("Mazda");
		Car car1 = cf.getModel("toyota");
		System.out.println(car.getClass());

		System.out.println(car.getModel("Mazda"));
		System.out.println(car1.getClass());

		System.out.println(car1.getModel("toyota"));


	}

}
