package com.mypractice.DemoCrudOperation.Entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Orders 
{
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int orderno;
     
     @Column(name = "OrderTrackingNumber", unique = true, nullable = false)
     private String OrderTrackingNumber;
     private String status;
     private String message;
     
     @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
     @JoinColumn(name="payments_id", referencedColumnName="no")
     private Payments payments;
	
     
     public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public Orders() {
	
	}

	public Orders(int orderno, String orderTrackingNumber, String status, String message) {
		this.orderno = orderno;
		OrderTrackingNumber = orderTrackingNumber;
		this.status = status;
		this.message = message;
	}

	public int getOrderno() {
		return orderno;
	}
	
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getOrderTrackingNumber() {
		return OrderTrackingNumber;
	}
	public void setOrderTrackingNumber(String orderTrackingNumber) {
		OrderTrackingNumber = orderTrackingNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
     
     
    
}