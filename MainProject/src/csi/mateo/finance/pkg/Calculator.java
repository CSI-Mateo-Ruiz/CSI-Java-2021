package csi.mateo.finance.pkg;

import java.util.*;

public class Calculator {
	static String vehicle = "none";
	static String job;
	static String house;
	
	public static void main(String[] args) {
		double banco = 0;

		double invested = 0;
		double paycheck = 0;
		String location = "none";

		// ==========loans=============\\
		List<Loan> loans = new ArrayList<Loan>();
		loans.add(new Loan("Student Loans", 0, 0.0466, 10));
		loans.add(new Loan("Personal Loans", 0, 0.16, 10));
		loans.add(new Loan("Mortgage Loans", 0, 0.03125, 15));
		loans.add(new Loan("CreditCard", 0, 0.29, 99));

		for (int age = 0; age <= 90; age++) {
			if (age <= 15) {
				location = "Puerto Rico";
				double salary = 0;
				banco += salary;
				vehicle = "none";
				job = "unemployed";
				loans.get(0).differed = true;

			} else if (age <= 17) {
				paycheck = 750;
				banco += paycheck;
				vehicle = "Honda Pilot";
				location = "Puerto Rico";
				job = "unemployed";
				loans.get(0).differed = true;

			} else if (age <= 21) {
				// pre med
				location = "San Francisco";
				double salary = 20_000;
				double tuition = 0;
				double costOfLiving = 12 * 1_773 + 6_960;
				vehicle = "bike";

				// papa me regala una bici

				banco += salary;
				banco -= 12_000;
				loans.get(0).principal += tuition + costOfLiving;
				loans.get(0).principal -= 12_000;
				job = "Part time fast food employee";
				loans.get(0).differed = true;

			} else if (age <= 25) {

				// estudiando medicina
				location = "San Francisco";
				double salary = 20_000;
				double tuition = 53_529;
				double costOfLiving = 12 * 2_170 + 6_960;

				loans.get(0).principal += tuition + costOfLiving;
				banco += salary;
				job = "Part time fast food employee";
				loans.get(0).differed = true;

			} else if (age == 26) {
				// internship general surgery
				double costOfLiving = 12 * 1_780;
				location = "Puerto Rico";
				loans.get(0).principal += costOfLiving;
				// 420 = comida y 580 es renta
				job = "an intern at general surgery";
				loans.get(0).differed = true;

			} else if (age == 27) {
				double salary = 60_000;
				double buyVehicle = 15_000;
				vehicle = "2016 toyota corola";

				banco += salary;
				banco -= buyVehicle;
				job = "Resident";
				
				loans.get(0).differed = false;
				
			} else if (age == 28) {
				double salary = 60_000;

				vehicle = "2016 toyota corola";

				banco += salary;
				job = "Resident";
				

			} else if (age == 29) {
				double salary = 60_000;
				
				// casa = 275_000
				
				 double apartmentPrice = 275_000;
			        double downPayment = apartmentPrice * 0.15;
			        double interestRate = 0.03;
			        int repaymentYears = 15;
				
			        Loan mortgageLoan = new Loan("My first home", 
			                (apartmentPrice - downPayment),
			                interestRate, 
			                repaymentYears);
			        loans.add( mortgageLoan );
			        
			        System.out.println("House mortgage: " + mortgageLoan.getMonthlyPayment() + " For a total of " + mortgageLoan.getTotalPayment() );

				vehicle = "2016 toyota corola";
				job = "Resident";
				house = "house in parkville";
				

				banco += salary;
				banco -= 2_000;
				banco -= downPayment;
				// invest 2_000\\
				
				

			} else if (age == 30) {
				double salary = 60_000;
				double childDelivery = 3_068;

				vehicle = "2014 toyota corola";

				banco += salary;
				banco -= childDelivery;
				job = "Resident";
				

			} else if (age <= 33) {
//	$10,339 to $184,950 average residency rate in Puerto rico and US
				double salary = 60_000;
				location = "Puerto Rico";
				banco += salary;
				job = "Resident";
				

			
				banco -= 3_000;
//				quiero invest 3000
//						5 years' experience: $301,000
//						10 years: $397,000
//						20+ years: $414,000.

			} else if (age <= 38) {
				double salary = 301_000;
				location = "Puerto Rico";
				banco += salary;

				loans.get(0).makePayment();
				loans.get(3).makePayment();

				banco -= 10_000;
				banco -= loans.get(0).makePayment();
				banco -= loans.get(3).makePayment();
				// invest 10000
				job = "Neurosurgeon";
				

			} else if (age == 39) {
				double salary = 397_000;
				banco += salary;
				

				banco -= 10_000;
				// invest 10000

			} else if (age <= 43) {
				double salary = 397_000;
				location = "Puerto Rico";
				banco += salary;
				

				banco -= 10_000;
				// invest 10000

			} else if (age <= 48) {
				double salary = 414_000;
				location = "Puerto Rico";
				banco += salary;
				

				banco -= 10_000;
				// invest 10000

			} else if (age <= 50) {
				double salary = 414_000;
				location = "Puerto Rico";
				banco += salary;

			} else if (age <= 60) {
					job = "retired";
			}
			
			///////////// monthly Loan payments\\\\\\\\
			for (Loan loan : loans) {
				for (int month = 0; month < 12; month++) {
					if (loan.getBalance() > 0 && loan.differed == false) {
						banco -= loan.makePayment();
					}
				}
			}
			
			
			
			double debt = 0;
			for (Loan loan : loans)
				debt += loan.getBalance();
			System.out.println("He is living in " + location + ". Balance at age: " + age + " is: " + banco
					+ " with a debt of " + debt + " and " + invested + " invested. He is driving a " + vehicle
					+ " and is working as a " + job + "." + " He is livving in " + house);
		}
	}
}
