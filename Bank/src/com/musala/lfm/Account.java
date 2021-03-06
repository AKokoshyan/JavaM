package com.musala.lfm;

public abstract class Account {

	private String name;
	private double balance;
	private boolean isOpen;
	private String iban;
	private AccountOpener opener;

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public abstract void initialize();

	public Account() {
		this("");
	}

	public Account(String name) {
		this(name, 0, true);
	}

	public Account(String name, double balance, boolean isOpen) {
		this.name = "";
		setName(name);
		this.balance = balance;
		this.isOpen = isOpen;
		setOpener(this);
	}

	private AccountOpener getOpener() {
		return opener;
	}

	private void setOpener(Account account) {
		if (this.opener != null) {
			this.opener.open(account);
		}

	}

	public void setName(String name) {

		if (name != null) {
			this.name = name;
		}
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void withdraw(double amount) {

		if (amount > 0 && isOpen()) {
			balance -= amount;
		}
	}

	public void deposit(double amount) {

		if (amount > 0 && isOpen()) {
			balance += amount;
		}
	}

	public void open() {
		isOpen = true;
	}

	public void lock() {
		isOpen = false;
	}

	@Override
	public String toString() {

		String status = isOpen ? "open" : "locked";

		return name + " (" + balance + "): " + status;
	}
}
