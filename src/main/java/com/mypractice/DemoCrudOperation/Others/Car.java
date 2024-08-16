package com.mypractice.DemoCrudOperation.Others;

public class Car {
	private String brand="Suzuki";
		class Engine{
			void start(){
				System.out.println("Starting "+brand+" engine");
			}
		}
		
		public static void main(String[] args) {
	        Engine engine = new Car().new Engine();
	        engine.start();
		}
	}

