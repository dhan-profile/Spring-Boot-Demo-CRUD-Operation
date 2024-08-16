package com.mypractice.DemoCrudOperation.Dto;


public class OrderPaymentsDto {

    private int orderno;
    private String orderTrackingNumber;
    private String status;
    private String message;
    private PaymentsDto payments;

    public OrderPaymentsDto() {}

    public OrderPaymentsDto(int orderno, String orderTrackingNumber, String status, String message, PaymentsDto payments) {
        this.orderno = orderno;
        this.orderTrackingNumber = orderTrackingNumber;
        this.status = status;
        this.message = message;
        this.payments = payments;
    }

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
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

	public PaymentsDto getPayments() {
		return payments;
	}

	public void setPayments(PaymentsDto payments) {
		this.payments = payments;
	}

    
}

