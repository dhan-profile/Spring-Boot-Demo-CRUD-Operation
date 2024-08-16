package com.mypractice.DemoCrudOperation.Dto;

public class PaymentsDto {

    private int no;
    private int payment;
    private String mode;

    public PaymentsDto() {}

    public PaymentsDto(int no, int payment, String mode) {
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

