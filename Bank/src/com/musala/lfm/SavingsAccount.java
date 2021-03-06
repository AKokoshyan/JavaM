package com.musala.lfm;

public class SavingsAccount extends Account {

	private double interestRate;
	private boolean isInterestPaid;
	private SimpleAccountOpener ownAccount = new SimpleAccountOpener();

	public SavingsAccount(String name, double interestRate) {
		super(name);
		this.interestRate = 0.1;
		this.isInterestPaid = false;
		if (interestRate >= 0) {
			this.interestRate = interestRate;
		}
		this.ownAccount.open(this);
	}

	@Override
	public void withdraw(double amount) {
		if (amount > 0 && isOpen()) {
			double newBalance = getBalance() - amount;

			if (newBalance >= 0) {
				super.withdraw(amount);
			}
		}
	}

	public void payInterest() {

		if (!isInterestPaid) {
			double interest = (getBalance() * interestRate) / 100;
			deposit(interest);
			isInterestPaid = true;
		}
	}

	@Override
	public void initialize() {

	}
}
