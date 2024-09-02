package com.mypractice.DemoCrudOperation.Others;

class IntegerClass2 implements Numbers{

	@Override
	public void integer() {
		// TODO Auto-generated method stub
		System.out.println("Integer");
	}

	@Override
	public void decimal() {
		// TODO Auto-generated method stub
		System.out.println("Decimal");
	}
	
}

public class IntegerClass {

	public static void main(String[] args) {
		Numbers num = new IntegerClass2() {};
		num.integer();
		num.decimal();
	}

}
