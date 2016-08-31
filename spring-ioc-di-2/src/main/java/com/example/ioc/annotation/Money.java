package com.example.ioc.annotation;

// VO
// = model, domain , entity, DTO (Data Transfer Object)
public class Money {

	private int amount;

	public Money() {
		// TODO Auto-generated constructor stub
	}

	public Money(int amount) {
		super();
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


}
