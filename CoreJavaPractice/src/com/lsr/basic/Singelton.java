package com.lsr.basic;

public class Singelton {
	
	
	public Singelton() {
		super();
	}

	private static Singelton getSingelton() {
		Singelton instance = null ;
		if (instance == null)
			instance = new Singelton();
		return instance;
	}
	
	public static void main(String args[]) {
		System.out.println(getSingelton().hashCode());
		
		
	}

}
