package com.mypractice.DemoCrudOperation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int no;
	private int payment;
	private String mode;
	
	public Payments() {
	
	}

	public Payments(int no, int payment, String mode, boolean status) {
		super();
		this.no = no;
		this.payment = payment;
		this.mode = mode;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

	
}
