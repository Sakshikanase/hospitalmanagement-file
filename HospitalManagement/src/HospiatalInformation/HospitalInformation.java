package HospiatalInformation;

import java.util.Scanner;

public class HospitalInformation {
	public static void information() {
		Scanner sc = new Scanner(System.in);

		boolean shouldContinue = true;

		
		System.out.println("|****WELCOME TO Hospital MANAGEMENT****|");
		
		while (shouldContinue) {

			
			System.out.println("1. Hospital information");
			System.out.println("2. Exit ");

			int decision = sc.nextInt();

			if (decision == 1) {
				System.out.println("_____________________________________________________________________");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|                                                                    |");
				System.out.println("|____________________________________________________________________|");
				
			} else if (decision == 2) {
				System.out.println("Thank you for visit");

				shouldContinue = false;

			} else {
				System.out.println("invalid data ");

			}
		}
	}

}
