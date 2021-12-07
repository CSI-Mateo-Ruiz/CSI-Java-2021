package csi.mateo.finance.pkg;

public class Loan {
	
	String name;
	double principal;
	double annualInterestRate;
	double numberOfYears;
	
	double paid;
	boolean differed = false;
	
	public Loan(String name, double principal, double annualInterestRate, int numberOfYears) {
		super();
		this.name = name;
		this.principal = principal;
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
			
	}
	
	public double makePayment() {
		
		if(getBalance() < getMonthlyPayment()) {
			double due = getBalance();
			paid += due;
			return due;
	
		} else {
			paid += getMonthlyPayment();
			return getMonthlyPayment();
		}
	}
	
	public double getBalance() {
		return (getTotalPayment() - paid);
	}
	
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = principal * monthlyInterestRate / (1 -1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
		return monthlyPayment;
	}
	
	public double getTotalPayment() {
		return (getMonthlyPayment() * numberOfYears * 12);
	}

}


