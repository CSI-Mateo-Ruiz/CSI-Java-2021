package csi.mateo.finance.pkg;

import java.util.*;

public class Calculator {
	static String vehicle = "none";

	public static void main(String[] args) {
		double banco = 0;
		
	
		double invested = 0;
		double paycheck = 0;
		String location = "none";
		
		//==========loans=============\\
		List<Loan> loans = new ArrayList<Loan>();
		loans.add(new Loan("Student Loans", 0, 0.0466, 0, 0));
		loans.add(new Loan("Personal Loans", 0, 0.16, 0, 0));
		loans.add(new Loan("Mortgage Loans", 0, 0.03125, 0, 0));
		loans.add(new Loan("CreditCard", 0, 0.29, 0, 0));
		
		for (int age = 0; age <= 80; age++) {
			if (age <= 15) {
				location = "Puerto Rico";
				double salary = 0;
				banco += salary;
				vehicle = "none";

			} else if (age <= 17) {
				paycheck = 750;
				banco += paycheck;
				vehicle = "Honda Pilot";
				location = "Puerto Rico";

			} else if (age <= 21) {
				// pre med
				location = "San Francisco";
				double salary = 20_000;
				double tuition = 0;
				double costOfLiving = (12 * 420) + (12 * 580);
				vehicle = "bike";
				// papa me regala una bici

				banco += salary;
				banco -= 15_000;
				loans.get(0).balance += tuition + costOfLiving;
				loans.get(0).balance -= 15_000;

			} else if (age <= 25) {

				// estudiando medicina
				location = "San Francisco";
				double salary = 20_000;
				double tuition = 53_529;
				double costOfLiving = 22_200 + 4_105.32;

//44,400 + 4,105.32 estoy viviendo con un roommate

				loans.get(0).balance += tuition + costOfLiving;
				banco += salary;

			} else if (age == 26) {
				// internship general surgery
				double costOfLiving = (12 * 420) + (12 * 580);
				location = "Puerto Rico";
				loans.get(0).balance += costOfLiving;
				// 420 = comida y 580 es renta

			} else if (age <= 33) {
//	$10,339 to $184,950 average residency rate in Puerto rico and US
				double salary = 60_000;
				banco += salary;
				loans.get(0).balance -= 33_000;
				banco -= 35_000;
//				quiero invest 2000
//						5 years' experience: $301,000
//						10 years: $397,000
//						20+ years: $414,000.
			}
			
			double debt = 0;
			for(Loan loan : loans)
			  debt += loan.balance;

			System.out.println("He is living in " + location + ". Balance at age: " + age + " is: " + banco
					+ " with a debt of " + debt + " and " + invested + " invested. He is driving a " + vehicle);
		}
	}

}
