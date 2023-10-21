package entities;

public class Account {
	private int number;
	private String user;
	private double balance;
	
	public Account(int number, String holder) {
		this.number = number;
		this.user = holder;
	}

	public Account(int number, String holder, double initialDeposit) {
		this.number = number;
		this.user = holder;
		deposit(initialDeposit);
	}

	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return user;
	}

	public void setHolder(String holder) {
		this.user = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount + 5.0;
	}
	
	public void transfer(double amount) {
		balance -= amount;
	}
	
	public String toString() {
		return "Número da conta: "
				+ number
				+ ", Usuário: "
				+ user
				+ ", Saldo: $"
				+ String.format("%.2f", balance);
	}
}