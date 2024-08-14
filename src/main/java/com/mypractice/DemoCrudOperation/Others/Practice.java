package com.mypractice.DemoCrudOperation.Others;

public class Practice {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		java.util.Scanner sc= new java.util.Scanner(System.in);
		int num = sc.nextInt();
		System.out.println("You Entered: "+num);
	}
}

abstract class Language{
	static int a=10;
	abstract void Chinese();
	static void English() {
		
	}
}