package PatientManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PatientDatabase {
	public static void patient() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		Patient patient = new Patient();
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms", "root", "sakshi@2004");
		while (true) {
			System.out.println("What would you like to do Today ?");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Update");
			System.out.println("4. Search");
			System.out.println("5. View");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Add patient");
				System.out.println("\nEnter the patient details: ");

				System.out.println("Enter the patient ID: ");
				patient.patientid = scanner.nextInt();

				System.out.println("\nEnter the patient name: ");
				patient.name = scanner.next();
				
				System.out.println("\nEnter the patient address: ");
				patient.address = scanner.next();


				System.out.println("Enter the patient  contactno : ");
				patient.contactno = scanner.nextInt();

				System.out.println("Enter the patient age: ");
				patient.age = scanner.nextInt();

				
				System.out.println("\nEnter the patient bloodgroup: ");
				patient.bloodgroup = scanner.next();

				System.out.println("\nEnter the patient earlierdiseas: ");
				patient.earlierdisease = scanner.next();

				String query = "SELECT * FROM hms.patient;";

				String insertQuery = "INSERT INTO patient (ID, Name, Address, ContactNo, age, BloodGroup, earlierdisease) VALUES ("
						+ patient.patientid + ", '" + patient.name + "','" + patient.address + "', " + patient.contactno + ", " + patient.age
						+ ",'" + patient.bloodgroup + "','" + patient.earlierdisease + "')";

				Statement statement = connection.createStatement();

				statement.execute(insertQuery);

				System.out.println("Record inserted successfully.");
				break;
			case 2:
				System.out.print("Enter ID to delete: ");
				patient.patientid = scanner.nextInt();
				
				String deleteQuery = "DELETE FROM patient WHERE ID = " + patient.patientid;
				Statement statement1 = connection.createStatement();

				statement1.execute(deleteQuery);

				System.out.println("Record deleted successfully.");
				break;
			case 3:
				System.out.print("Enter ID to update: ");
				patient.patientid= scanner.nextInt();
				
				System.out.print("Enter new name: ");
				String newName = scanner.next();
				
				System.out.print("Enter new address: ");
				String newaddress = scanner.next();
				
				System.out.print("Enter new Contact no.: ");
				int newcontactno = scanner.nextInt();
				
				System.out.print("Enter new age: ");
				int newage = scanner.nextInt();
				
				System.out.print("Enter new blood group: ");
				String newboodgroup = scanner.next();
				
				System.out.print("Enter new earlierdisease : ");
				String newearlierdisease  = scanner.next();
				
				String updateQuery = "UPDATE patient SET Name = '" + newName + "', Address = '" + newaddress
						+ "',ContactNo=" + newcontactno +",age= "+newage+",BloodGroup='"+newboodgroup+"',earlierdisease='"+newearlierdisease +"' WHERE ID = " +  patient.patientid;
				
				Statement statement2 = connection.createStatement();

				statement2.execute(updateQuery);
				
				System.out.println("Record updated successfully.");
				break;
			case 4:
				 System.out.print("Enter ID to search: ");
                 patient.patientid = scanner.nextInt();
                 String searchQuery = "SELECT * FROM patient WHERE ID = " +  patient.patientid ;
                 Statement statement3 = connection.createStatement();

 				statement3.execute(searchQuery);
                 ResultSet rs = statement3.executeQuery(searchQuery);
                 if (rs.next()) {
                     System.out.println("ID: " + rs.getInt("ID") + ", Name: " + rs.getString("Name") + ",Address: " + rs.getString("Address")+ ", age: " + rs.getInt("age") + ", BloodGroup: " + rs.getString("BloodGroup") + ", earlierdisease: " + rs.getString("earlierdisease"));
                 } else {
                     System.out.println("Record not found.");
                 }
				break;
			case 5:
				String viewAllQuery = "SELECT * FROM patient";
                Statement statement5 = connection.createStatement();

				statement5.execute(viewAllQuery);
				
                ResultSet rsAll = statement5.executeQuery(viewAllQuery);
                while (rsAll.next()) {
                	System.out.println("ID: " + rsAll.getInt("ID") + ", Name: " + rsAll.getString("Name") + ",Address: " + rsAll.getString("Address")+ ", age: " + rsAll.getInt("age") + ", BloodGroup: " + rsAll.getString("BloodGroup") + ", earlierdisease: " + rsAll.getString("earlierdisease"));
                }
				break;
			case 6:
				System.out.println("Exiting...");

				scanner.close();
				return;
				
			default:
				System.out.println("Invalid choice. Please try again.");

			}

		}

	}


}
