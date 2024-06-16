package Application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import DoctorManagement.DoctorDatabase;
import HospiatalInformation.HospitalInformation;
import PatientManagement.PatientDatabase;




public class Application {
	public static void main(String[] args) throws IOException, SQLException {

		System.out.println(" ___________________________________________");
		System.out.println("|                                           |");
		System.out.println("|****WELCOME TO THE  HOSPITAL MANAGEMENT****|");
		System.out.println("|                                           |");
		System.out.println("|___________________________________________|");

		Scanner sc = new Scanner(System.in);

		boolean shouldContinue = true;

		while (shouldContinue) {
			System.out.println("What would you like to do Today ?");
			System.out.println(" 1. Hospital information ");
			System.out.println(" 2. Doctor Management ");
			System.out.println(" 3. Patient Management ");
			System.out.println("9.Exit");
			int decision = sc.nextInt();

			switch (decision) {
			case 1:
				HospitalInformation.information();
				break;
			case 2:
				DoctorDatabase.doctor();
				break;
			case 3:
				PatientDatabase.patient();
				break;
			case 9:
				shouldContinue = false;
				System.out.println("Exit Application");
				break;
			default:
				System.out.println("invalid data ");

			}

		}

	}

}
