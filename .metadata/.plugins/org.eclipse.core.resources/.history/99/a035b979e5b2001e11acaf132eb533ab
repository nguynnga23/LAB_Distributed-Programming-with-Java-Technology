package Exercise03;

public class Account implements Runnable {
	private double balance;
	private long number;

	public Account(double balance, long number) {
		super();
		this.balance = 0;
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean Deposit(double moneyDeposit) {
		if (moneyDeposit <= 0.0) {
			System.out.println("The deposit amount must be greater than 0 !");
			return false;
		}
		balance += moneyDeposit;
		System.out.println("Deposit successfully !");
		return true;
	}

	public boolean Withdraw(double moneyWithdraw) {
		if (moneyWithdraw > balance) {
			System.out.println("The balance in your account is insufficient !");
			return false;
		}
		balance -= moneyWithdraw;
		System.out.println("Withdraw successfully !");
		return true;
	}

	@Override
	public void run() {

	}

}
