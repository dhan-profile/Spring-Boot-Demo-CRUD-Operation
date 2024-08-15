package com.mypractice.DemoCrudOperation.Dto;


public class OrderPaymentsDto {

    private int orderno;
    private String OrderTrackingNumber;
    private String status;
    private String message;
    
	private int no;
	private int payment;
	private String mode;


	public OrderPaymentsDto() {
	
	}
	

	public OrderPaymentsDto(int orderno, String orderTrackingNumber, String status, String message, int no, int payment,
			String mode) {
		super();
		this.orderno = orderno;
		OrderTrackingNumber = orderTrackingNumber;
		this.status = status;
		this.message = message;
		this.no = no;
		this.payment = payment;
		this.mode = mode;
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
